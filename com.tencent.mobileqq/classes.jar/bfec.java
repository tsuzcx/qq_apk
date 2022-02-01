import com.tencent.mobileqq.troop.utils.TroopUploadingThread;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class bfec
  implements HostnameVerifier
{
  public bfec(TroopUploadingThread paramTroopUploadingThread, HttpsURLConnection paramHttpsURLConnection) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    String str = this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.getRequestProperty("Host");
    paramString = str;
    if (str == null) {
      paramString = this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.getURL().getHost();
    }
    return HttpsURLConnection.getDefaultHostnameVerifier().verify(paramString, paramSSLSession);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfec
 * JD-Core Version:    0.7.0.1
 */