import com.tencent.mobileqq.servlet.LoginVerifyServlet.3;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class azbq
  implements HostnameVerifier
{
  public azbq(LoginVerifyServlet.3 param3, URL paramURL) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    boolean bool = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.jdField_a_of_type_JavaNetURL.getHost(), paramSSLSession);
    if (!bool) {
      QLog.d("LoginVerifyServlet", 1, new Object[] { "OpenVirtual.HostnameVerifier.host:", this.jdField_a_of_type_JavaNetURL.getHost(), ",address:", paramSSLSession.getPeerHost(), ",isverify:", Boolean.valueOf(bool) });
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azbq
 * JD-Core Version:    0.7.0.1
 */