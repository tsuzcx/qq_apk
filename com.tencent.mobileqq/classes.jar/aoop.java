import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public final class aoop
  implements HostnameVerifier
{
  public aoop(boolean paramBoolean, URL paramURL) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return (this.jdField_a_of_type_Boolean) || (HttpsURLConnection.getDefaultHostnameVerifier().verify(this.jdField_a_of_type_JavaNetURL.getHost(), paramSSLSession));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoop
 * JD-Core Version:    0.7.0.1
 */