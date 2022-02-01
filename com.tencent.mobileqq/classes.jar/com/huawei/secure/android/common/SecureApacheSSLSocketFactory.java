package com.huawei.secure.android.common;

import android.content.Context;
import com.huawei.secure.android.common.ssl.SSLUtil;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

@Deprecated
public class SecureApacheSSLSocketFactory
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
  public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();
  private static volatile SecureApacheSSLSocketFactory c = null;
  private SSLContext a;
  private Context b;
  
  private SecureApacheSSLSocketFactory(KeyStore paramKeyStore)
  {
    super(paramKeyStore);
  }
  
  private SecureApacheSSLSocketFactory(KeyStore paramKeyStore, Context paramContext)
  {
    super(paramKeyStore);
    this.b = paramContext;
    this.a = SSLUtil.setSSLContext();
    paramKeyStore = new SecureX509TrustManager(this.b);
    this.a.init(null, new X509TrustManager[] { paramKeyStore }, null);
  }
  
  @Deprecated
  public SecureApacheSSLSocketFactory(KeyStore paramKeyStore, InputStream paramInputStream, String paramString)
  {
    super(paramKeyStore);
    this.a = SSLUtil.setSSLContext();
    paramKeyStore = new HiCloudX509TrustManager(paramInputStream, paramString);
    this.a.init(null, new X509TrustManager[] { paramKeyStore }, null);
  }
  
  private void a(Socket paramSocket)
  {
    paramSocket = (SSLSocket)paramSocket;
    SSLUtil.setEnabledProtocols(paramSocket);
    SSLUtil.setEnableSafeCipherSuites(paramSocket);
  }
  
  @Deprecated
  public static SecureApacheSSLSocketFactory getInstance(KeyStore paramKeyStore, Context paramContext)
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new SecureApacheSSLSocketFactory(paramKeyStore, paramContext);
        }
      }
      finally {}
    }
    return c;
  }
  
  public Socket createSocket()
  {
    Socket localSocket = this.a.getSocketFactory().createSocket();
    a(localSocket);
    return localSocket;
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    paramSocket = this.a.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    a(paramSocket);
    return paramSocket;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.SecureApacheSSLSocketFactory
 * JD-Core Version:    0.7.0.1
 */