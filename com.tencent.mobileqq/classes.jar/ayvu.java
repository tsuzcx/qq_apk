import android.annotation.TargetApi;
import android.net.SSLCertificateSocketFactory;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.params.HttpParams;

@TargetApi(17)
public class ayvu
  implements LayeredSocketFactory
{
  static final HostnameVerifier jdField_a_of_type_JavaxNetSslHostnameVerifier = new StrictHostnameVerifier();
  SSLCertificateSocketFactory jdField_a_of_type_AndroidNetSSLCertificateSocketFactory = (SSLCertificateSocketFactory)SSLCertificateSocketFactory.getInsecure(0, null);
  private String jdField_a_of_type_JavaLangString;
  
  public ayvu(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, HttpParams paramHttpParams)
  {
    paramSocket.connect(new InetSocketAddress(paramString, paramInt1));
    return paramSocket;
  }
  
  public Socket createSocket()
  {
    return new Socket();
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SNISocketFactory", 2, "createSocket " + paramSocket.toString() + " host:" + paramString + " port:" + paramInt + " autoClose:" + paramBoolean);
    }
    paramSocket = (SSLSocket)this.jdField_a_of_type_AndroidNetSSLCertificateSocketFactory.createSocket(paramSocket, paramString, paramInt, paramBoolean);
    paramSocket.setEnabledProtocols(paramSocket.getSupportedProtocols());
    int i = 10;
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SNISocketFactory", 2, "Setting SNI hostname");
      }
      this.jdField_a_of_type_AndroidNetSSLCertificateSocketFactory.setHostname(paramSocket, paramString);
    }
    for (;;)
    {
      SSLSession localSSLSession = paramSocket.getSession();
      if (jdField_a_of_type_JavaxNetSslHostnameVerifier.verify(paramString, localSSLSession)) {
        break;
      }
      ayrp.a(i + 4, paramString, paramInt, this.jdField_a_of_type_JavaLangString);
      paramSocket.close();
      throw new SSLPeerUnverifiedException("Cannot verify hostname: " + paramString);
      if (QLog.isColorLevel()) {
        QLog.i("SNISocketFactory", 2, "No documented SNI support on Android <4.2, trying with reflection");
      }
      i = 20;
      int j;
      try
      {
        paramSocket.getClass().getMethod("setHostname", new Class[] { String.class }).invoke(paramSocket, new Object[] { paramString });
      }
      catch (Exception localException)
      {
        j = 30;
        i = j;
      }
      if (QLog.isColorLevel())
      {
        QLog.i("SNISocketFactory", 2, "SNI not useable");
        i = j;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("SNISocketFactory", 2, "Established " + localException.getProtocol() + " connection with " + localException.getPeerHost() + " using " + localException.getCipherSuite());
    }
    ayrp.a(i, paramString, paramInt, this.jdField_a_of_type_JavaLangString);
    return paramSocket;
  }
  
  public boolean isSecure(Socket paramSocket)
  {
    if ((paramSocket instanceof SSLSocket)) {
      return ((SSLSocket)paramSocket).isConnected();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayvu
 * JD-Core Version:    0.7.0.1
 */