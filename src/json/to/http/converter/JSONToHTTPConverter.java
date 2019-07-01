
package json.to.http.converter;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.mail.*;
import javax.mail.Authenticator;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.util.*;

/**
 *
 * @author YZheng
 */






public class JSONToHTTPConverter {

    /**
     * @param args the command line arguments
     * @throws java.net.UnknownHostException
     * @throws java.net.MalformedURLException
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws UnknownHostException, MalformedURLException, IOException {
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
            @Override
            public void run() {
                try {
                MongoClient mongoClient = new MongoClient("localhost");
                MongoDatabase db = mongoClient.getDatabase("Tododb");
                MongoCollection<Document> collection = db.getCollection("forms");
                           
                    MongoCursor<Document> findIterable = collection.find().iterator();
                    while (findIterable.hasNext()) {
                        HashMap<String, String> hmap = new HashMap<String, String>();
                        // declare all the elements
                        while (findIterable.hasNext()) {
                            String tempString = findIterable.next().toString();
                            String[] tempStrArray = tempString.split(", |=|\\{|\\}");
                            List<String> wordList = Arrays.asList(tempStrArray);
                            String FirstName = "";
                            String LastName = "";
                            String Email = "";
                            String Country = "";
                            String Address1 = "";
                            String Address2 = "";
                            String City = "";
                            String State = "";
                            String Zip = "";
                            String PrimaryPhone = "";
                            String Program = "";
                            String AnticipatedStartTimeFrame = "";
                            String AnticipatedStartTerm = "";
                            String comm_key_2 = "";
                            String comm_key = "";
                            String comm_key_3 = "";
                            String comm_key_4 = "";
                            String aac_online_interst = "";
                            String Military_Status_Desc = "";
                            String Military = "";
                            String admin_function_2 = "";
                            String EducationLevel = "";
                            String aac_100prct_online = "";
                            String Country_Code = "";
                            String recruiting_status = "";
                            String admin_function_3 = "";
                            String admin_function_4 = "";
                            String admin_function = "";
                            String aac_intrnt_qstn = "N";
                            String LeadProviderReceivedDate = "" + (LocalDateTime.now());
                            String RequestedCampusType = "";
                            String aac_hgh_scl_grd_dt = "";
                            //String High_School_GraduationYearMonth = "";
                            //String High_School_Graduation_Date = "";
                            String MarketingCode = "";
                            String AdvertisingSource = "";
                            String aac_srvc_ind_cd1 = "";
                            String aac_srvc_ind_rsn1 = "";
                            String specialAccommodations = "";
                            String FORMNAME = "";
                            String repId = "";
                            String commComments = "";
                            String Tour_Details = "";
                            String eventdetails = "";
                            String NumberofTourAttendees = "";
                            String tourDate = "";
                            String eventLocation = "";
                            String OperatorAAUStaff = "";
                            String CampusTourSelected = "";     
                            String TCPAExpressConsent = "";
                            String Citizenship = "";
                            String leadid_token = "";
			    String url = "";
                            int flag = 0;
                            //check for indexes of individual elements if found then the value is on the next index
                            //some values are using replaceAll(" ", "%20") this can be replace with URLEncoder.encode
                            FORMNAME = wordList.get(wordList.indexOf("FORMNAME") + 1);
				if (wordList.indexOf("url") != -1) {
                                url = wordList.get(wordList.indexOf("url") + 1);
                            }
                            if (wordList.indexOf("event_details") != -1) {
                                eventdetails = wordList.get(wordList.indexOf("event_details") + 1).replaceAll(" ", "%20").replaceAll("-", "%2D").replaceAll(":", "%3A");
                            }
                            if (wordList.indexOf("Citizenship") != -1) {
                            	Citizenship = wordList.get(wordList.indexOf("Citizenship") + 1).replaceAll(" ", "%20");
                            }
                            if (wordList.indexOf("TCPAExpressConsent") != -1) {
                            	TCPAExpressConsent = wordList.get(wordList.indexOf("TCPAExpressConsent") + 1).replaceAll(" ", "%20");
                            }
                            else {
                            	TCPAExpressConsent = "Y";
                            }
                            	
                            if (wordList.indexOf("tourDate") != -1) {
                            	tourDate = wordList.get(wordList.indexOf("tourDate") + 1).replaceAll(" ", "%20").replaceAll("-", "%2D");
                            }
                            if (wordList.indexOf("eventLocation") != -1) {
                            	eventLocation = wordList.get(wordList.indexOf("eventLocation") + 1).replaceAll(" ", "%20");
                            }
                            if (wordList.indexOf("NumberofTourAttendees") != -1) {
                            	NumberofTourAttendees = wordList.get(wordList.indexOf("NumberofTourAttendees") + 1).replaceAll(" ", "%20");
                            }                            
                                if (wordList.indexOf("TourTime_ALL_1") != -1) {
                            	if(wordList.get(wordList.indexOf("TourTime_ALL_1") + 1).equals("9:00 AM")) {
                                    if(flag == 1) {
                                        Tour_Details += "|" + "9:00%20AM" + "%20-%20" + "GAM_ANM_MUS";
                                        flag = 1;
                                    }
                                    else {
                                        Tour_Details += "9:00%20AM" + "%20-%20" + "GAM_ANM_MUS";
                                        flag = 1;
                                    }
                                }
                            	if(wordList.get(wordList.indexOf("TourTime_ALL_1") + 1).equals("3:00 PM")) {
                                    if(flag == 1) {
                                        Tour_Details += "|" + "3:00%20PM" +"%20-%20" + "GAM_ANM_MUS";
                                        flag = 1;
                                    }
                                    else{
                                        Tour_Details += "3:00%20PM" +"%20-%20" + "GAM_ANM_MUS";
                                        flag = 1;
                                    }
                                }
                            	}
                            	if (wordList.indexOf("TourTime_ALL_2") != -1) {
                            	if(wordList.get(wordList.indexOf("TourTime_ALL_2") + 1).equals("9:00 AM")) {
                                    if(flag == 1) {
                                        Tour_Details += "|" + "9:00%20AM" + "%20-%20" + "ARE_GR_CA";
                                        flag = 1;
                                    }
                                    else{
                                        Tour_Details += "9:00%20AM" + "%20-%20" + "ARE_GR_CA";
                                        flag = 1;
                                    }
                                }
                            	if(wordList.get(wordList.indexOf("TourTime_ALL_2") + 1).equals("3:00 PM")) {
                                    if(flag == 1) {
                                        Tour_Details += "|" + "3:00%20PM" + "%20-%20" + "ARE_GR_CA";
                                        flag = 1;
                                    }
                                    else{
                                        Tour_Details += "3:00%20PM" + "%20-%20" + "ARE_GR_CA";
                                        flag = 1;
                                    }
                                }
                            	}
                            	if (wordList.indexOf("TourTime_ALL_3") != -1) {
                            	if(wordList.get(wordList.indexOf("TourTime_ALL_3") + 1).equals("9:00 AM")) {
                                    if(flag == 1) {
                                        Tour_Details += "|" + "9:00%20AM" + "%20-%20" + "MPT_COM";
                                        flag = 1;
                                    }
                                    else{
                                        Tour_Details += "9:00%20AM" + "%20-%20" + "MPT_COM";
                                        flag = 1;
                                    }
                                }
                            	if(wordList.get(wordList.indexOf("TourTime_ALL_3") + 1).equals("3:00 PM")) {
                                    if(flag == 1) {
                                        Tour_Details += "|" + "3:00%20PM" + "%20-%20" + "MPT_COM";
                                        flag = 1;
                                    }
                                    else{
                                        Tour_Details += "3:00%20PM" + "%20-%20" + "MPT_COM";
                                        flag = 1;
                                    }
                                }
                            	}
                            	if (wordList.indexOf("TourTime_ALL_4") != -1) {
                            	if(wordList.get(wordList.indexOf("TourTime_ALL_4") + 1).equals("10:00 AM")) {
                                    if(flag == 1) {
                                        Tour_Details += "|" + "10:00%20AM" + "%20-%20" + "ACT_MPT_WRI";
                                        flag = 1;
                                    }
                                    else{
                                        Tour_Details += "10:00%20AM" + "%20-%20" + "ACT_MPT_WRI";
                                        flag = 1;
                                    }
                                }
                            	if(wordList.get(wordList.indexOf("TourTime_ALL_4") + 1).equals("2:00 PM")) {
                                    if(flag == 1) {
                                        Tour_Details += "|" + "2:00%20PM" + "%20-%20" + "ACT_MPT_WRI";
                                        flag = 1;
                                    }
                                    else{
                                        Tour_Details += "2:00%20PM" + "%20-%20" + "ACT_MPT_WRI";
                                        flag = 1;
                                    }
                                }
                            	} 
                            	if (wordList.indexOf("TourTime_ALL_5") != -1) {
                            	if(wordList.get(wordList.indexOf("TourTime_ALL_5") + 1).equals("10:00 AM")) {
                                    if(flag == 1) {
                                        Tour_Details += "|" + "10:00%20AM" + "%20-%20" + "ILL_ANM_VIS" ;
                                        flag = 1;
                                    }
                                    else{
                                        Tour_Details += "10:00%20AM" + "%20-%20" + "ILL_ANM_VIS" ;
                                        flag = 1;
                                    }
                                }
                            	if(wordList.get(wordList.indexOf("TourTime_ALL_5") + 1).equals("2:00 PM")) {
                                    if(flag == 1) {
                                        Tour_Details += "|" + "2:00%20PM" + "%20-%20" + "ILL_ANM_VIS";
                                        flag = 1;
                                    }
                                    else{
                                        Tour_Details += "2:00%20PM" + "%20-%20" + "ILL_ANM_VIS";
                                        flag = 1;
                                    }
                                }
                            	}    
                            	if (wordList.indexOf("TourTime_ALL_6") != -1) {
                            	if(wordList.get(wordList.indexOf("TourTime_ALL_6") + 1).equals("10:00 AM")) {
                                    if(flag == 1) {
                                        Tour_Details += "|" + "10:00%20AM" + "%20-%20" + "AHS_FA" ;
                                        flag = 1;
                                    }
                                    else{
                                        Tour_Details += "10:00%20AM" + "%20-%20" + "AHS_FA" ;
                                        flag = 1;
                                    }
                                }
                            	}     
                            	if (wordList.indexOf("TourTime_ALL_7") != -1) {
                            	if(wordList.get(wordList.indexOf("TourTime_ALL_7") + 1).equals("11:00 AM")) {
                                    if(flag == 1) {
                                        Tour_Details += "|" + "11:00%20AM" + "%20-%20" + "IND";
                                        flag = 1;
                                    }
                                    else{
                                        Tour_Details += "11:00%20AM" + "%20-%20" + "IND" ;
                                        flag = 1;
                                    }
                                }
                            	}   
                            	if (wordList.indexOf("TourTime_ALL_8") != -1) {
                            	if(wordList.get(wordList.indexOf("TourTime_ALL_8") + 1).equals("11:00 AM")) {
                                    if(flag == 1) {
                                        Tour_Details += "|" + "11:00%20AM"+ "%20-%20"+"Housing" ;
                                        flag = 1;
                                    }
                                    else{
                                        Tour_Details += "11:00%20AM"+ "%20-%20"+"Housing" ;
                                        flag = 1;
                                    }
                                }
                            	if(wordList.get(wordList.indexOf("TourTime_ALL_8") + 1).equals("2:00 PM")) {
                                    if(flag == 1) {
                                        Tour_Details += "|" + "2:00%20PM" +"%20-%20"+"Housing" ;
                                        flag = 1;
                                    }
                                    else{
                                        Tour_Details += "2:00%20PM" +"%20-%20"+"Housing" ;
                                        flag = 1;
                                    }
                                }
                            	}   
                            	if (wordList.indexOf("TourTime_ALL_9") != -1) {
                            	if(wordList.get(wordList.indexOf("TourTime_ALL_9") + 1).equals("11:00 AM")) {
                                    if(flag == 1) {
                                        Tour_Details += "|" + "11:00%20AM" + "%20-%20" + "LAN_FASCU";
                                        flag = 1;
                                    }
                                    else {
                                        Tour_Details += "11:00%20AM" + "%20-%20" + "LAN_FASCU";
                                        flag = 1;
                                    }
                                }
                            	}
                            	if (wordList.indexOf("TourTime_ALL_10") != -1) {
                            	if(wordList.get(wordList.indexOf("TourTime_ALL_10") + 1).equals("2:00 PM")) {
                                    if(flag == 1) {
                                        Tour_Details += "|" + "2:00%20PM" +"%20-%20" +"PH";
                                        flag = 1;
                                    }
                                    else {
                                        Tour_Details += "2:00%20PM" + "%20-%20" + "PH";
                                        flag = 1;
                                    }
                                }
                            	} 
                            	if (wordList.indexOf("TourTime_ALL_11") != -1) {
                            	if(wordList.get(wordList.indexOf("TourTime_ALL_11") + 1).equals("12:00 PM")) {
                                    if(flag == 1) {
                                        Tour_Details += "|" + "12:00%20PM" + "%20-%20" + "FSH_MK_FSH_MR" ;
                                        flag = 1;
                                    }
                                    else {
                                        Tour_Details += "12:00%20PM" + "%20-%20" + "FSH_MK_FSH_MR" ;
                                        flag = 1;
                                    }
                                }
                            	}
                            	if (wordList.indexOf("TourTime_ALL_12") != -1) {
                            	if(wordList.get(wordList.indexOf("TourTime_ALL_12") + 1).equals("1:00 PM")) {
                                    if(flag == 1) {
                                        Tour_Details += "|" + "1:00%20PM" + "%20-%20" + "JEM_ADV";
                                        flag = 1;
                                    }
                                    else {
                                        Tour_Details += "1:00%20PM" + "%20-%20" + "JEM_ADV" ;
                                        flag = 1;
                                    }
                                }
                            	}
                            	if (wordList.indexOf("TourTime_ALL_13") != -1) {   
                            	if(wordList.get(wordList.indexOf("TourTime_ALL_13") + 1).equals("11:00 AM")) {
                                    if(flag == 1) {
                                        Tour_Details += "|" + "11:00%20AM" + "%20-%20" + "FSH_CD";
                                        flag = 1;
                                    }
                                    else {
                                        Tour_Details += "11:00%20AM" + "%20-%20" + "FSH_CD" ;
                                        flag = 1;
                                    }
                                }
                            	}
                            	if (wordList.indexOf("TourTime_ALL_14") != -1) { 
                            	if(wordList.get(wordList.indexOf("TourTime_ALL_14") + 1).equals("10:00 AM")) {
                                    if(flag == 1){
                                        Tour_Details += "|" + "10:00%20AM" + "%20-%20" + "ARH_IAD";
                                        flag = 1;
                                    }
                                    else {
                                        Tour_Details += "10:00%20AM" + "%20-%20" + "ARH_IAD" ;
                                        flag = 1;
                                    }
                                }
                            	}      
                            // the commented out two fields are requested fields left out until salesforce add them on their end
                            /*if (wordList.indexOf("aac_hgh_scl_grd_dt") != -1) {
                            	High_School_GraduationYearMonth = "June" + wordList.get(wordList.indexOf("aac_hgh_scl_grd_dt") + 1).replaceAll(" ", "%20").replaceAll("/","%2F");
                            }*/
                            /*if (wordList.indexOf("aac_hgh_scl_grd_dt") != -1) {
                            	High_School_Graduation_Date = "1st"; 
                            }*/
                            aac_online_interst = wordList.get(wordList.indexOf("aac_online_interst") + 1).replaceAll(",", "");
                            if(aac_online_interst.equals("")) {
                            	RequestedCampusType = "SR_BR%2D000028887312";
                            	aac_100prct_online = "N";
                            	aac_online_interst = "N";
                            }
                            else if (aac_online_interst.equals("Onsite Only")){
                                RequestedCampusType = "SR_BR%2D000028887312";
                                aac_100prct_online = "N";
                                aac_online_interst = "N";
                            }
                            else if(aac_online_interst.equals("Online Only")){
                                RequestedCampusType = "SR_BR%2D000028804634";
                                aac_100prct_online = "Y";
                                aac_online_interst = "Y";
                            } 
                            else if (aac_online_interst.equals("Both")){
                                RequestedCampusType = "SR_BR%2D000028804634";
                                aac_100prct_online = "N";
                                aac_online_interst = "Y";
                            }
                            if (wordList.indexOf("commComments") != -1) {                             
                            	commComments = wordList.get(wordList.indexOf("commComments") + 1).replaceAll(" ", "%20").replaceAll(";", "%3B").replaceAll("/", "%2F").replaceAll("\\?", "%3F").replaceAll(":", "%3A").replaceAll("@", "%40").replaceAll("=", "%3D").replaceAll("&", "%26").replaceAll("\"", "%22").replaceAll("<", "%3C").replaceAll(">", "%3E").replaceAll("#", "%23").replaceAll("\\{", "%7B").replaceAll("\\}", "%7D").replaceAll("\\\\", "%5C").replaceAll("~", "%7E").replaceAll("\\[", "%5B").replaceAll("\\]", "%5D").replaceAll("`", "%60").replaceAll("\n", "").replace("\r", "");
                            	 if(FORMNAME.equals("3")) {
                                 	commComments = "Operator%3A" + wordList.get(wordList.indexOf("OperatorAAUStaff") + 1).replaceAll(" ", "%20").replaceAll(";", "%3B").replaceAll("/", "%2F").replaceAll("\\?", "%3F").replaceAll(":", "%3A").replaceAll("@", "%40").replaceAll("=", "%3D").replaceAll("&", "%26").replaceAll("\"", "%22").replaceAll("<", "%3C").replaceAll(">", "%3E").replaceAll("#", "%23").replaceAll("\\{", "%7B").replaceAll("\\}", "%7D").replaceAll("\\\\", "%5C").replaceAll("~", "%7E").replaceAll("\\[", "%5B").replaceAll("\\]", "%5D").replaceAll("`", "%60").replaceAll("\n", "").replace("\r", "") + ",%20" + "Comments%3A" + wordList.get(wordList.indexOf("commComments") + 1).replaceAll(" ", "%20").replaceAll(";", "%3B").replaceAll("/", "%2F").replaceAll("\\?", "%3F").replaceAll(":", "%3A").replaceAll("@", "%40").replaceAll("=", "%3D").replaceAll("&", "%26").replaceAll("\"", "%22").replaceAll("<", "%3C").replaceAll(">", "%3E").replaceAll("#", "%23").replaceAll("\\{", "%7B").replaceAll("\\}", "%7D").replaceAll("\\\\", "%5C").replaceAll("~", "%7E").replaceAll("\\[", "%5B").replaceAll("\\]", "%5D").replaceAll("`", "%60").replaceAll("\n", "").replace("\r", "");
                                     }
                            }
                            if (wordList.indexOf("repId") != -1) {
                                repId = wordList.get(wordList.indexOf("repId") + 1).replaceAll(" ", "%20");
                            }
                            if (wordList.indexOf("PrimaryPhone") != -1) {
                                PrimaryPhone = wordList.get(wordList.indexOf("PrimaryPhone") + 1).replaceAll(" ", "%20");
                            }
                            if (wordList.indexOf("FirstName") != -1) {
                                FirstName = wordList.get(wordList.indexOf("FirstName") + 1).replaceAll(" ", "%20");
                            }
                            if (wordList.indexOf("specialAccommodations") != -1) {
                                specialAccommodations = wordList.get(wordList.indexOf("specialAccommodations") + 1).replaceAll(" ", "%20").replaceAll(";", "%3B").replaceAll("/", "%2F").replaceAll("\\?", "%3F").replaceAll(":", "%3A").replaceAll("@", "%40").replaceAll("=", "%3D").replaceAll("&", "%26").replaceAll("\"", "%22").replaceAll("<", "%3C").replaceAll(">", "%3E").replaceAll("#", "%23").replaceAll("\\{", "%7B").replaceAll("\\}", "%7D").replaceAll("\\\\", "%5C").replaceAll("~", "%7E").replaceAll("\\[", "%5B").replaceAll("\\]", "%5D").replaceAll("`", "%60").replaceAll("\n", "").replace("\r", "");
                            }
                            if (wordList.indexOf("LastName") != -1) {
                                LastName = wordList.get(wordList.indexOf("LastName") + 1).replaceAll(" ", "%20");
                            }
                            if (wordList.indexOf("Email") != -1) {
                                Email = wordList.get(wordList.indexOf("Email") + 1).replaceAll(" ", "%20");
                            }
                            if (wordList.indexOf("Country") != -1) {
                                Country = wordList.get(wordList.indexOf("Country") + 1).replaceAll(" ", "%20");
                            }
                            if (wordList.indexOf("Address1") != -1) {
                                Address1 = wordList.get(wordList.indexOf("Address1") + 1).replaceAll(" ", "%20").replaceAll(" ", "%2C");
                            }
                            if (wordList.indexOf("Address2") != -1) {
                                Address2 = wordList.get(wordList.indexOf("Address2") + 1).replaceAll(" ", "%20").replaceAll(" ", "%2C");
                            }
                            if (wordList.indexOf("City") != -1) {
                                City = wordList.get(wordList.indexOf("City") + 1).replaceAll(" ", "%20");
                            }
                            if (wordList.indexOf("State") != -1) {
                                State = wordList.get(wordList.indexOf("State") + 1).replaceAll(" ", "%20").replaceAll(",", "");
                            }
                            if (wordList.indexOf("Zip") != -1) {
                                Zip = wordList.get(wordList.indexOf("Zip") + 1).replaceAll(" ", "%20").replaceAll(",", "");
                            }
                            if (wordList.indexOf("PrimaryPhone") != -1) {
                                PrimaryPhone = wordList.get(wordList.indexOf("PrimaryPhone") + 1).replaceAll(" ", "%20");
                            }                                                           
                            if (wordList.indexOf("AnticipatedStartTimeFrame") != -1) {
                                AnticipatedStartTimeFrame = wordList.get(wordList.indexOf("AnticipatedStartTimeFrame") + 1).replaceAll(" ", "%20").replaceAll("\\(", "%28").replaceAll("\\)", "%29");
                            }                          
                            if (wordList.indexOf("AnticipatedStartTerm") != -1) {
                            	AnticipatedStartTerm = wordList.get(wordList.indexOf("AnticipatedStartTerm") + 1).replaceAll(" ", "%20").replaceAll("\\(", "%28").replaceAll("\\)", "%29");
                            }
                            if (wordList.indexOf("comm_key_2") != -1) {
                                comm_key_2 = wordList.get(wordList.indexOf("comm_key_2") + 1).replaceAll(" ", "%20");
                            }
                            if (wordList.indexOf("comm_key_3") != -1) {
                                comm_key_3 = wordList.get(wordList.indexOf("comm_key_3") + 1).replaceAll(" ", "%20");
                            }
                            if (wordList.indexOf("Military_Status_Desc") != -1) {
                                Military_Status_Desc = wordList.get(wordList.indexOf("Military_Status_Desc") + 1).replaceAll(" ", "%20");
                            }                     
                            if (Military_Status_Desc.equals("") || Military_Status_Desc.equals("Not%20Applicable")){
                                Military = "No";
                                Military_Status_Desc = "";
                            }
                            else {
                                Military = "Yes";
                            }       
                            if (wordList.indexOf("admin_function_3") != -1) {
                                admin_function_3 = wordList.get(wordList.indexOf("admin_function_3") + 1).replaceAll(" ", "%20");
                            }
                            if (wordList.indexOf("admin_function_4") != -1) {
                                admin_function_4 = wordList.get(wordList.indexOf("admin_function_4") + 1).replaceAll(" ", "%20");
                            }
                            if (wordList.indexOf("EducationLevel") != -1) {
                                EducationLevel = wordList.get(wordList.indexOf("EducationLevel") + 1).replaceAll("-", "%20").replaceAll(" ", "%20");
                                if(EducationLevel.equals("Associate%20Degree")) {
                                	EducationLevel = "Associate%27s%20Degree";
                                }
                                if(EducationLevel.equals("Bachelor%20Degree")) {
                                	EducationLevel = "Bachelor%27s%20Degree";
                                }
                                if(EducationLevel.equals("Second%20Bachelor%20Degree")) {
                                	EducationLevel = "Second%20Bachelor%27s%20Degree";
                                }
                                if(EducationLevel.equals("Master%20Degree")) {
                                	EducationLevel = "Master%27s%20Degree";
                                }
                                if(EducationLevel.equals("Did%20Not%20Complete%20High%20School%20No%20GED")) {
                                	EducationLevel = "Did%20Not%20Complete%20High%20School%2C%20No%20GED";
                                }
                            }
                            if (wordList.indexOf("Country_Code") != -1) {
                                Country_Code = wordList.get(wordList.indexOf("Country_Code") + 1).replaceAll(" ", "%20").replaceAll("-", "%96");
                            }
                            String fin_aid_interest = "";
                            if (wordList.indexOf("fin_aid_interest") == (-1)) {
                                fin_aid_interest = "N";
                            } else {
                                fin_aid_interest = wordList.get(wordList.indexOf("fin_aid_interest") + 1).replaceAll(" ", "%20");
                            }
                            String housing_interest = "";
                            if (wordList.indexOf("housing_interest") == (-1)) {
                                housing_interest = "N";
                            } else {
                                housing_interest = wordList.get(wordList.indexOf("housing_interest") + 1).replaceAll(" ", "%20");
                            }
                            String acad_career = "";
                            if (EducationLevel.equals("")) {
                                acad_career = "";
                            } 
                            else if (EducationLevel.contains("High%20School%20Student") || EducationLevel.contains("Some%20College") || EducationLevel.contains("High%20School%20Diploma") || EducationLevel.contains("Associate") || EducationLevel.contains("Did%20Not%20Complete%20High%20School")) {
                                acad_career = "UGRD";
                            } else {
                                acad_career = "GRAD";
                            }  
                            if (wordList.indexOf("recruiting_status") != -1) {
                                recruiting_status = wordList.get(wordList.indexOf("recruiting_status") + 1).replaceAll(" ", "%20");
                            }
                            if (wordList.indexOf("Program") != -1) {
                                if (wordList.indexOf("EducationLevel") != -1) {
                                    if(EducationLevel.contains("Current%20High%20School%20Student")|| EducationLevel.contains("High%20School%20Diploma")|| EducationLevel.contains("Did%20Not%20Complete%20High%20School")|| EducationLevel.contains("No%20GED")|| EducationLevel.contains("Some%20College%20Credits") || EducationLevel.contains("Associate%27s%20Degree")){
                                    Program = wordList.get(wordList.indexOf("Program") + 1).replaceAll(",", "");
                                    if((Program.equals("ARH"))){
                                       Program = "BARCH%2DARH";   
                                    }  
                                    else if((Program.equals("COM"))){
                                       Program = "BA%2DCOM";   
                                    } 
                                    else if((Program.equals("FSH-J"))){
                                       Program = "BA%2DFSH%2DJ";   
                                    } 
                                    else if((Program.equals("ARH-D"))){
                                       Program = "BA%2DARH%2DD";   
                                    }   
                                    else if((Program.equals("GAP"))){
                                       Program = "BS%2DGAP";   
                                    }
                                    else if((Program.equals("PRO"))){
                                       Program = "PEUG%2DPRO";   
                                    }
                                    else if((Program.equals("ADV-S"))){
                                       Program = "AA%2DADV%2DS";   
                                    }
                                    else if((Program.equals("AUT"))){
                                       Program = "AA%2DAUT";   
                                    }
                                    else if((Program.equals("ARH2"))){
                                       Program = "BARCH%2DARH";   
                                    }
                                    else if((Program.equals("ARE"))){
                                        Program = "BFA%2DARE";   
                                     }
                                    else if((Program.equals("ADV1"))){
                                       Program = "AA%2DADV%2DS";   
                                    }
                                    else if((Program.equals("SM"))){
                                        Program = "CRT%2DSM";
                                    }
                                    else{
                                       Program = ("BFA%2D" + Program).replaceAll("-", "%2D"); 
                                    }
                                    }  
                                    if(EducationLevel.contains("Bachelor%27s%20Degree")||EducationLevel.contains("Second%20Bachelor%20Degree")||EducationLevel.contains("Some%20Post%20Graduate")||EducationLevel.contains("Master%27s%20Degree")||EducationLevel.contains("Doctoral%20Degree")){
                                    Program = wordList.get(wordList.indexOf("Program") + 1).replaceAll(",", "");
                                    if((Program.equals("ARH1"))){
                                       Program = "MA%2DARH";   
                                    }   
                                    else if((Program.equals("ARH"))){
                                       Program = "MARCH%2DARH";   
                                    }
                                    else if((Program.equals("AHS"))){
                                       Program = "MA%2DAHS";   
                                    }
                                    else if((Program.equals("COM"))){
                                       Program = "MA%2DCOM";   
                                    }
                                    else if((Program.equals("FSH-J"))){
                                       Program = "MA%2DFSH%2DJ";   
                                    }
                                    else if((Program.equals("FSH-MR"))){
                                       Program = "MA%2DFSH%2DMR";   
                                    }
                                    else if((Program.equals("GAP"))){
                                       Program = "BS%2DGAP";  
                                       acad_career = "UGRD";
                                    }
                                    else if((Program.equals("PRO"))){
                                       Program = "PEUG%2DPRO";
                                       acad_career = "UGRD";
                                    }
                                    else if((Program.equals("SM"))){
                                        Program = "CRT%2DSM";
                                        acad_career = "UGRD";
                                    }
                                    else if((Program.equals("ADV-S"))){
                                       Program = "AA%2DADV%2DS";   
                                    }
                                    else if((Program.equals("ATC"))){
                                        Program = "CRED%2DARE";   
                                    }
                                    else if((Program.equals("AUT"))){
                                       Program = "AA%2DAUT";   
                                       acad_career = "UGRD";
                                    }
                                    else if((Program.equals("ARE"))){
                                       Program = "MA%2DARE";   
                                    }
                                    else if((Program.equals("ARE1"))){
                                       Program = "MAT%2DARE";   
                                    }
                                    else if((Program.equals("ARE2"))){
                                       Program = "CRED%2DARE";   
                                    }
                                    else if((Program.equals("FSH-S"))){
                                        Program = "BFA%2DFSH%2DS";  
                                        acad_career = "UGRD";
                                     }
                                    else if((Program.equals("FSH-VM"))){
                                        Program = "BFA%2DFSH%2DVM";  
                                        acad_career = "UGRD";
                                     }
                                    else if((Program.equals("ADV-S"))){
                                        Program = "BFA%2DFSH%2DS";  
                                        acad_career = "UGRD";
                                     }
                                    else if((Program.equals("ADV1"))){
                                        Program = "AA%2DADV%2DS";  
                                        acad_career = "UGRD";
                                     }                                  
                                    else{
                                       Program = ("MFA%2D" + Program).replaceAll("-", "%2D"); 
                                    }
                                    }
                                }
                            }
                            // 1 = MMI, 2 = Tours, 3 = phone leads, 4 = College Connect
                            if(FORMNAME.equals("1")){                                                  
                                    comm_key = "MMI";
                                    admin_function = "PROS";
                                    admin_function_2 =	"RECR";
                                    comm_key_4 = "PURE";
                                    MarketingCode = "PURE";
                                    AdvertisingSource = "MMI";
                                    admin_function_4 = "RECR";
                            }
                            else if(FORMNAME.equals("2")){ 
                                    comm_key = "OTOUR";
                                    admin_function = "PROS";
                                    //admin_function_2 =	"RECR";
                                    comm_key_4 = "PURE";
                                    MarketingCode = "PURE";
                                    AdvertisingSource = "MMI";
                                    admin_function_4 = "RECR";
                            } 
                            else if(FORMNAME.equals("3")){ 
                                    comm_key = "PRCALL";
                                    admin_function = "PROS";
                                    //admin_function_2 =	"RECR";
                                    comm_key_4 = "PURE";
                                    MarketingCode = "PURE";
                                    AdvertisingSource = "INTERNAL";
                                    admin_function_4 = "RECR";
                            } 
                            else if(FORMNAME.equals("4")){ 
                                comm_key = "PM334";
                                admin_function = "PROS";
                                //admin_function_2 =	"RECR";
                                comm_key_4 = "PURE";
                                MarketingCode = "PURE";
                                AdvertisingSource = "MMI";
                                admin_function_4 = "RECR";
                            } 
                            // Did not complete high scchool has a special filing
                            if(EducationLevel.contains("Did%20Not%20Complete%20High%20School")){
                                aac_srvc_ind_cd1 = "DNE";
                                aac_srvc_ind_rsn1 = "HSGED";
                            }   
                            if (!(wordList.get(wordList.indexOf("referral_engine") + 1).equals(""))){
                            	if(!(wordList.get(wordList.indexOf("referral_engine") + 1).contains("eloqua"))) {
                            		comm_key_4 = "XOXXXX";
                            	}
                            }
                            if(!wordList.get(wordList.indexOf("IT") + 1).equals("")){
                                comm_key_4 = wordList.get(wordList.indexOf("IT") + 1).replaceAll(" ", "%20");
                            } 
                            if(!wordList.get(wordList.indexOf("leadid_token") + 1).equals("")){
                            	leadid_token = wordList.get(wordList.indexOf("leadid_token") + 1).replaceAll(" ", "%20");
                            }
                            if(EducationLevel.contains("Did%20Not%20Complete%20High%20School")){
                            	
                            }
                            else if (wordList.indexOf("aac_hgh_scl_grd_dt") != -1) {
                                aac_hgh_scl_grd_dt = "06%2F01%2F" + wordList.get(wordList.indexOf("aac_hgh_scl_grd_dt") + 1).replaceAll(" ", "%20").replaceAll("/","%2F");
                            }
                            if(FORMNAME.equals("3")) {
                            	comm_key_4 = comm_key_2;
                            	comm_key_2 = "";
                            }
                            // need at least First Name Last Name and Email to create contact
                            if(FirstName != null  && LastName != null  && Email != null){
                            String blank = "";
                            String USER_AGENT = "Mozilla/5.0";
                            URL temp2 = new URL("https://uat-artu.cs17.force.com/LeadPost?" + "Firstname=" + URLEncoder.encode(FirstName, "UTF-8") + "&Lastname=" + URLEncoder.encode(LastName, "UTF-8") + "&Email=" + Email + "&acad_career=" + acad_career + "&Country=" + Country + "&Country_Code=" + Country_Code + "&Address1=" + URLEncoder.encode(Address1, "UTF-8") + "&Address2=" + URLEncoder.encode(Address2, "UTF-8") + "&City=" + URLEncoder.encode(City, "UTF-8") + "&State=" + State + "&Zip=" + Zip + "&PrimaryPhone=" + PrimaryPhone + "&Program=" + Program + "&Comm_Key_2=" + comm_key_2 + "&Comm_Key=" + comm_key + "&Comm_Key_3=" + comm_key_3 + "&Comm_Key_4=" + comm_key_4 + "&aac_online_interst=" + aac_online_interst + "&Military_Status_Desc=" + Military_Status_Desc + "&Military=" + Military + "&Admin_Function_2=" + admin_function_2 + "&Admin_Function_3=" + admin_function_3 + "&Admin_Function_4=" + admin_function_4 + "&Admin_Function=" + admin_function + "&AnticipatedStartTimeFrame=" + AnticipatedStartTimeFrame + "&AnticipatedStartTerm=" + AnticipatedStartTerm + "&TCPAExpressConsent=" + TCPAExpressConsent + "&EducationLevel=" + EducationLevel + "&aac_100prct_online=" + aac_100prct_online + "&fin_aid_interest=" + fin_aid_interest + "&housing_interest=" + housing_interest + "&recruiting_status=" + recruiting_status + "&LeadProviderReceivedDate=" + LeadProviderReceivedDate + "&aac_intrnt_qstn=" + aac_intrnt_qstn + "&RequestedCampusType=" + RequestedCampusType + "&MarketingCode=" + MarketingCode + "&AdvertisingSource=" + AdvertisingSource + "&aac_srvc_ind_cd1=" + aac_srvc_ind_cd1 +"&aac_srvc_ind_rsn1=" + aac_srvc_ind_rsn1 + "&Special_Accommodations_Comments=" + specialAccommodations +"&RepID=" + repId + "&Comm_Comments=" + commComments + "&Tour_Detail=" + Tour_Details + "&Tour_Date=" + tourDate + "&Event_City=" + eventLocation + "&aac_hgh_scl_grd_dt=" + aac_hgh_scl_grd_dt + "&Citizenship=" + Citizenship + "&Event_Details=" + eventdetails + "&%23_of_Attendees=" + NumberofTourAttendees + "&Universal_LeadID=" + leadid_token + "&URL_Parameters=" + url);
                            //URL temp1 = new URL("https://artu.secure.force.com/LeadPost?" + "Firstname=" + FirstName + "&Lastname=" + LastName + "&Email=" + Email + "&acad_career=" + acad_career + "&Country=" + Country + "&Country_Code=" + Country_Code + "&Address1=" + Address1 + "&Address2=" + Address2 + "&City=" + City + "&State=" + State + "&Zip=" + Zip + "&PrimaryPhone=" + PrimaryPhone + "&Program=" + Program + "&Comm_Key_2=" + comm_key_2 + "&Comm_Key=" + comm_key + "&Comm_Key_3=" + comm_key_3 + "&Comm_Key_4=" + comm_key_4 + "&aac_online_interst=" + aac_online_interst + "&Military_Status_Desc=" + Military_Status_Desc + "&Military=" + Military + "&Admin_Function_2=" + admin_function_2 + "&Admin_Function_3=" + admin_function_3 + "&Admin_Function_4=" + admin_function_4 + "&Admin_Function=" + admin_function + "&AnticipatedStartTimeFrame=" + AnticipatedStartTimeFrame + "&AnticipatedStartTerm=" + AnticipatedStartTerm + "&TCPAExpressConsent=" + TCPAExpressConsent + "&EducationLevel=" + EducationLevel + "&aac_100prct_online=" + aac_100prct_online + "&fin_aid_interest=" + fin_aid_interest + "&housing_interest=" + housing_interest + "&recruiting_status=" + recruiting_status + "&LeadProviderReceivedDate=" + LeadProviderReceivedDate + "&aac_intrnt_qstn=" + aac_intrnt_qstn + "&RequestedCampusType=" + RequestedCampusType + "&MarketingCode=" + MarketingCode + "&AdvertisingSource=" + AdvertisingSource + "&aac_srvc_ind_cd1=" + aac_srvc_ind_cd1 +"&aac_srvc_ind_rsn1=" + aac_srvc_ind_rsn1 + "&Special_Accommodations_Comments=" + specialAccommodations +"&RepID=" + repId + "&Comm_Comments=" + commComments + "&Tour_Detail=" + Tour_Details + "&Tour_Date=" + tourDate + "&Event_City=" + eventLocation + "&aac_hgh_scl_grd_dt=" + aac_hgh_scl_grd_dt + "&Citizenship=" + Citizenship + "&Event_Details=" + eventdetails + "&%23_of_Attendees=" + NumberofTourAttendees + "&Universal_LeadID=" + leadid_token);
                            if((!(FirstName.contains("AAU"))) && (!(LastName.contains("AAU")))) {/*
                            URL POSTurl = new URL(temp1, "");
                            URLConnection con = POSTurl.openConnection();
                            HttpURLConnection http = (HttpURLConnection) con;
                            http.setRequestMethod("POST"); // PUT is another valid option
                            http.setRequestProperty("User-Agent", USER_AGENT);
                            http.setDoOutput(true);
                            byte[] b = blank.getBytes("UTF-8");
                            try (DataOutputStream wr = new DataOutputStream(http.getOutputStream())) {
                                wr.write(b);
                            }
                            int responseCode = http.getResponseCode();
                            System.out.println("GET Response Code :: " + responseCode);
                            if (responseCode == 200) {
                                collection.drop();                         
                            }
                            else{
                                final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
                                Properties props = System.getProperties();
                                props.setProperty("mail.smtp.host", "smtp.gmail.com");
                                props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
                                props.setProperty("mail.smtp.socketFactory.fallback", "false");
                                props.setProperty("mail.smtp.port", "465");
                                props.setProperty("mail.smtp.socketFactory.port", "465");
                                props.put("mail.smtp.auth", "true");
                                props.put("mail.debug", "true");
                                props.put("mail.store.protocol", "pop3");
                                props.put("mail.transport.protocol", "smtp");
                                final String username = "aauwebservice@gmail.com";//
                                final String password = "w3bs78ff1";
                                try{
                                    Session session = Session.getDefaultInstance(props,
                                            new Authenticator(){
                                                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                                                    return new javax.mail.PasswordAuthentication(username, password);
                                                }});

                                    // -- Create a new message --
                                    Message msg = new MimeMessage(session);

                                    // -- Set the FROM and TO fields --
                                    msg.setFrom(new InternetAddress("webmaster@academyart.edu"));
                                    msg.setRecipients(Message.RecipientType.TO,
                                            InternetAddress.parse("websupport@academyart.edu",false));
                                    msg.setSubject("AAU Web Service Failed Lead");
                                    msg.setText(responseCode+": "+"Firstname=" + FirstName + "&Lastname=" + LastName + "&Email=" + Email + "&acad_career=" + acad_career + "&Country=" + Country + "&Country_Code=" + Country_Code + "&Address1=" + Address1 + "&Address2=" + Address2 + "&City=" + City + "&State=" + State + "&Zip=" + Zip + "&PrimaryPhone=" + PrimaryPhone + "&Program=" + Program + "&Comm_Key_2=" + comm_key_2 + "&Comm_Key=" + comm_key + "&Comm_Key_3=" + comm_key_3 + "&Comm_Key_4=" + comm_key_4 + "&aac_online_interst=" + aac_online_interst + "&Military_Status_Desc=" + Military_Status_Desc + "&Military=" + Military + "&Admin_Function_2=" + admin_function_2 + "&Admin_Function_3=" + admin_function_3 + "&Admin_Function_4=" + admin_function_4 + "&Admin_Function=" + admin_function + "&AnticipatedStartTimeFrame=" + AnticipatedStartTimeFrame + "&AnticipatedStartTerm=" + AnticipatedStartTerm + "&TCPAExpressConsent=" + TCPAExpressConsent + "&EducationLevel=" + EducationLevel + "&aac_100prct_online=" + aac_100prct_online + "&fin_aid_interest=" + fin_aid_interest + "&housing_interest=" + housing_interest + "&recruiting_status=" + recruiting_status + "&LeadProviderReceivedDate=" + LeadProviderReceivedDate + "&aac_intrnt_qstn=" + aac_intrnt_qstn + "&RequestedCampusType=" + RequestedCampusType + "&MarketingCode=" + MarketingCode + "&AdvertisingSource=" + AdvertisingSource + "&aac_srvc_ind_cd1=" + aac_srvc_ind_cd1 +"&aac_srvc_ind_rsn1=" + aac_srvc_ind_rsn1 + "&Special_Accommodations_Comments=" + specialAccommodations +"&RepID=" + repId + "&Comm_Comments=" + commComments + "&Tour_Detail=" + Tour_Details + "&Tour_Date=" + tourDate + "&Event_City=" + eventLocation + "&aac_hgh_scl_grd_dt=" + aac_hgh_scl_grd_dt + "&Citizenship=" + Citizenship + "&Event_Details=" + eventdetails + "&%23_of_Attendees=" + NumberofTourAttendees + "&Universal_LeadID=" + leadid_token);
                                    msg.setSentDate(new Date());
                                    Transport.send(msg);
                                    System.out.println("Message sent.");
                                    collection.drop(); 
                                }catch (MessagingException e){ System.out.println("Erreur d'envoi, cause: " + e);}
                            }
                            */}
                            else {
                            URL POSTurl = new URL(temp2, "");
                            URLConnection con = POSTurl.openConnection();
                            HttpURLConnection http = (HttpURLConnection) con;
                            http.setRequestMethod("POST"); // PUT is another valid option
                            http.setRequestProperty("User-Agent", USER_AGENT);
                            http.setDoOutput(true);
                            byte[] b = blank.getBytes("UTF-8");
                            try (DataOutputStream wr = new DataOutputStream(http.getOutputStream())) {
                                wr.write(b);
                            }
                            int responseCode = http.getResponseCode();
                            System.out.println("GET Response Code :: " + responseCode);
                            if (responseCode == 200) {
                                collection.drop();
                            }
                            else{
                                final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
                                // Get a Properties object
                                Properties props = System.getProperties();
                                props.setProperty("mail.smtp.host", "smtp.gmail.com");
                                props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
                                props.setProperty("mail.smtp.socketFactory.fallback", "false");
                                props.setProperty("mail.smtp.port", "465");
                                props.setProperty("mail.smtp.socketFactory.port", "465");
                                props.put("mail.smtp.auth", "true");
                                props.put("mail.debug", "true");
                                props.put("mail.store.protocol", "pop3");
                                props.put("mail.transport.protocol", "smtp");
                                final String username = "aauwebservice@gmail.com";//
                                final String password = "w3bs78ff1";
                                try{
                                    Session session = Session.getDefaultInstance(props,
                                            new Authenticator(){
                                                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                                                    return new javax.mail.PasswordAuthentication(username, password);
                                                }});

                                    // -- Create a new message --
                                    Message msg = new MimeMessage(session);

                                    // -- Set the FROM and TO fields --
                                    msg.setFrom(new InternetAddress("webmaster@academyart.edu"));
                                    msg.setRecipients(Message.RecipientType.TO,
                                            InternetAddress.parse("websupport@academyart.edu",false));
                                    msg.setSubject("AAU Web Service Failed Lead");
                                    msg.setText(temp2.toString());
                                    msg.setSentDate(new Date());
                                    Transport.send(msg);
                                    System.out.println("Message sent.");
                                    collection.drop(); 
                                }catch (MessagingException e){ System.out.println("Erreur d'envoi, cause: " + e);}
                            }
                            }
                            }
                        }
                    }
                 mongoClient.close();
                } catch (Exception e) {
                    final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
                            // Get a Properties object
                                Properties props = System.getProperties();
                                props.setProperty("mail.smtp.host", "smtp.gmail.com");
                                props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
                                props.setProperty("mail.smtp.socketFactory.fallback", "false");
                                props.setProperty("mail.smtp.port", "465");
                                props.setProperty("mail.smtp.socketFactory.port", "465");
                                props.put("mail.smtp.auth", "true");
                                props.put("mail.debug", "true");
                                props.put("mail.store.protocol", "pop3");
                                props.put("mail.transport.protocol", "smtp");
                                final String username = "aauwebservice@gmail.com";//
                                final String password = "w3bs78ff1";
                    try{
                                    Session session = Session.getDefaultInstance(props,
                                            new Authenticator(){
                                                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                                                    return new javax.mail.PasswordAuthentication(username, password);
                                                }});

                                    // -- Create a new message --
                                    Message msg = new MimeMessage(session);

                                    // -- Set the FROM and TO fields --
                                    msg.setFrom(new InternetAddress("webmaster@academyart.edu"));
                                    msg.setRecipients(Message.RecipientType.TO,
                                            InternetAddress.parse("webservicemonitor@art.edu",false));
                                    msg.setSubject("web service - UAT is Down");
                                    msg.setText("");
                                    msg.setSentDate(new Date());
                                    Transport.send(msg);
                                    System.out.println("Message sent.");
                    }catch (MessagingException ex){ System.out.println("Erreur d'envoi, cause: " + ex);}
                    throw new RuntimeException(e);
                }              
            }
        },
                0, 5000
        );

    }

}
