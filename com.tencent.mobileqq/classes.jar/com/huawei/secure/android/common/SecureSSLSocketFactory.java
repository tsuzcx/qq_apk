package com.huawei.secure.android.common;

import android.content.Context;
import com.huawei.secure.android.common.ssl.SSLUtil;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

@Deprecated
public class SecureSSLSocketFactory
  extends SSLSocketFactory
{
  public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
  public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();
  private static volatile SecureSSLSocketFactory c = null;
  private SSLContext a = null;
  private Context b;
  
  private SecureSSLSocketFactory(Context paramContext)
  {
    this.b = paramContext;
    this.a = SSLUtil.setSSLContext();
    paramContext = new SecureX509TrustManager(this.b);
    this.a.init(null, new X509TrustManager[] { paramContext }, null);
  }
  
  @Deprecated
  public SecureSSLSocketFactory(InputStream paramInputStream, String paramString)
  {
    this.a = SSLUtil.setSSLContext();
    paramInputStream = new HiCloudX509TrustManager(paramInputStream, paramString);
    this.a.init(null, new X509TrustManager[] { paramInputStream }, null);
  }
  
  private void a(Socket paramSocket)
  {
    paramSocket = (SSLSocket)paramSocket;
    SSLUtil.setEnabledProtocols(paramSocket);
    SSLUtil.setEnableSafeCipherSuites(paramSocket);
  }
  
  @Deprecated
  public static SecureSSLSocketFactory getInstance(Context paramContext)
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new SecureSSLSocketFactory(paramContext);
        }
      }
      finally {}
    }
    return c;
  }
  
  public Socket createSocket(String paramString, int paramInt)
  {
    paramString = this.a.getSocketFactory().createSocket(paramString, paramInt);
    if ((paramString instanceof SSLSocket)) {
      a(paramString);
    }
    return paramString;
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    return createSocket(paramString, paramInt1);
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    return createSocket(paramInetAddress.getHostAddress(), paramInt);
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    return createSocket(paramInetAddress1.getHostAddress(), paramInt1);
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    paramSocket = this.a.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    if ((paramSocket instanceof SSLSocket)) {
      a(paramSocket);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.SecureSSLSocketFactory
 * JD-Core Version:    0.7.0.1
 */