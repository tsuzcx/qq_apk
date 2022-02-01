import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

class bhux
  implements HostnameVerifier
{
  bhux(bhuw parambhuw, String paramString, bhva parambhva) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    boolean bool = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.jdField_a_of_type_JavaLangString, paramSSLSession);
    this.jdField_a_of_type_Bhuw.a(this.jdField_a_of_type_Bhva, "httpsSSLProcess,HostnameVerifier", "reqhost = " + this.jdField_a_of_type_JavaLangString + ",address = " + paramSSLSession.getPeerHost() + "result:isverify = " + bool);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhux
 * JD-Core Version:    0.7.0.1
 */