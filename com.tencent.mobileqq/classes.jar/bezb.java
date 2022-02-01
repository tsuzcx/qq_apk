import android.net.SSLCertificateSocketFactory;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class bezb
  extends SSLSocketFactory
{
  private final String jdField_a_of_type_JavaLangString = bezb.class.getSimpleName();
  HostnameVerifier jdField_a_of_type_JavaxNetSslHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
  private HttpsURLConnection jdField_a_of_type_JavaxNetSslHttpsURLConnection;
  
  public bezb(HttpsURLConnection paramHttpsURLConnection)
  {
    this.jdField_a_of_type_JavaxNetSslHttpsURLConnection = paramHttpsURLConnection;
  }
  
  public Socket createSocket()
  {
    return null;
  }
  
  public Socket createSocket(String paramString, int paramInt)
  {
    return null;
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    return null;
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    return null;
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    return null;
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.getRequestProperty("Host");
    if (localObject == null) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "customized createSocket. host: " + paramString);
      }
      localObject = paramSocket.getInetAddress();
      if (paramBoolean) {
        paramSocket.close();
      }
      SSLCertificateSocketFactory localSSLCertificateSocketFactory = (SSLCertificateSocketFactory)SSLCertificateSocketFactory.getDefault(0);
      paramSocket = (SSLSocket)localSSLCertificateSocketFactory.createSocket((InetAddress)localObject, paramInt);
      paramSocket.setEnabledProtocols(paramSocket.getSupportedProtocols());
      if (Build.VERSION.SDK_INT >= 17)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Setting SNI hostname");
        }
        localSSLCertificateSocketFactory.setHostname(paramSocket, paramString);
      }
      for (;;)
      {
        localObject = paramSocket.getSession();
        if (this.jdField_a_of_type_JavaxNetSslHostnameVerifier.verify(paramString, (SSLSession)localObject)) {
          break;
        }
        paramSocket.close();
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + paramString);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "No documented SNI support on Android <4.2, trying with reflection");
        }
        try
        {
          paramSocket.getClass().getMethod("setHostname", new Class[] { String.class }).invoke(paramSocket, new Object[] { paramString });
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Established " + localException.getProtocol() + " connection with " + localException.getPeerHost() + " using " + localException.getCipherSuite());
      }
      return paramSocket;
      paramString = localException;
    }
  }
  
  public String[] getDefaultCipherSuites()
  {
    return new String[0];
  }
  
  public String[] getSupportedCipherSuites()
  {
    return new String[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bezb
 * JD-Core Version:    0.7.0.1
 */