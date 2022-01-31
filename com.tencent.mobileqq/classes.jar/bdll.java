import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class bdll
  implements HostnameVerifier
{
  public bdll(HttpCommunicator paramHttpCommunicator, String paramString, bdlo parambdlo) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    boolean bool = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.jdField_a_of_type_JavaLangString, paramSSLSession);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(this.jdField_a_of_type_Bdlo, "httpsSSLProcess,HostnameVerifier", "reqhost = " + this.jdField_a_of_type_JavaLangString + ",address = " + paramSSLSession.getPeerHost() + "result:isverify = " + bool);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdll
 * JD-Core Version:    0.7.0.1
 */