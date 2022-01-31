import android.annotation.TargetApi;
import android.net.SSLCertificateSocketFactory;
import android.os.Build.VERSION;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class bdqb
  extends SSLSocketFactory
{
  private final String jdField_a_of_type_JavaLangString = "SniSSLSocketFactory";
  HostnameVerifier jdField_a_of_type_JavaxNetSslHostnameVerifier;
  private String b;
  
  public bdqb(String paramString, HostnameVerifier paramHostnameVerifier)
  {
    this.b = paramString;
    this.jdField_a_of_type_JavaxNetSslHostnameVerifier = paramHostnameVerifier;
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
  
  @TargetApi(17)
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    paramString = paramSocket.getInetAddress();
    if (paramBoolean) {
      paramSocket.close();
    }
    SSLCertificateSocketFactory localSSLCertificateSocketFactory = (SSLCertificateSocketFactory)SSLCertificateSocketFactory.getDefault(0);
    paramSocket = (SSLSocket)localSSLCertificateSocketFactory.createSocket(paramString, paramInt);
    paramSocket.setEnabledProtocols(paramSocket.getSupportedProtocols());
    if (Build.VERSION.SDK_INT >= 17) {
      localSSLCertificateSocketFactory.setHostname(paramSocket, this.b);
    }
    for (;;)
    {
      paramString = paramSocket.getSession();
      if (this.jdField_a_of_type_JavaxNetSslHostnameVerifier == null) {
        this.jdField_a_of_type_JavaxNetSslHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
      }
      if (this.jdField_a_of_type_JavaxNetSslHostnameVerifier.verify(this.b, paramString)) {
        break;
      }
      throw new SSLPeerUnverifiedException("Cannot verify hostname: " + this.b);
      try
      {
        paramSocket.getClass().getMethod("setHostname", new Class[] { String.class }).invoke(paramSocket, new Object[] { this.b });
      }
      catch (Exception paramString) {}
    }
    return paramSocket;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqb
 * JD-Core Version:    0.7.0.1
 */