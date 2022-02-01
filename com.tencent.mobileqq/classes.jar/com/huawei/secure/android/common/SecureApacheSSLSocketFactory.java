package com.huawei.secure.android.common;

import android.content.Context;
import android.os.Build.VERSION;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
  private static final String d = "TLS";
  private static final String[] e = { "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", "TLS_RSA" };
  private static volatile SecureApacheSSLSocketFactory f = null;
  private SSLContext g;
  private Context mContext;
  
  private SecureApacheSSLSocketFactory(KeyStore paramKeyStore)
  {
    super(paramKeyStore);
  }
  
  private SecureApacheSSLSocketFactory(KeyStore paramKeyStore, Context paramContext)
  {
    super(paramKeyStore);
    this.mContext = paramContext;
    this.g = SSLContext.getInstance("TLS");
    paramKeyStore = new SecureX509TrustManager(this.mContext);
    paramContext = this.g;
    SecureRandom localSecureRandom = new SecureRandom();
    paramContext.init(null, new X509TrustManager[] { paramKeyStore }, localSecureRandom);
  }
  
  @Deprecated
  public SecureApacheSSLSocketFactory(KeyStore paramKeyStore, InputStream paramInputStream, String paramString)
  {
    super(paramKeyStore);
    this.g = SSLContext.getInstance("TLS");
    paramKeyStore = new HiCloudX509TrustManager(paramInputStream, paramString);
    paramInputStream = this.g;
    paramString = new SecureRandom();
    paramInputStream.init(null, new X509TrustManager[] { paramKeyStore }, paramString);
  }
  
  private void a(Socket paramSocket)
  {
    if ((paramSocket != null) && ((paramSocket instanceof SSLSocket)))
    {
      setEnabledProtocols((SSLSocket)paramSocket);
      setEnableSafeCipherSuites((SSLSocket)paramSocket);
    }
  }
  
  @Deprecated
  public static SecureApacheSSLSocketFactory getInstance(KeyStore paramKeyStore, Context paramContext)
  {
    if (f == null) {}
    try
    {
      if (f == null) {
        f = new SecureApacheSSLSocketFactory(paramKeyStore, paramContext);
      }
      return f;
    }
    finally {}
  }
  
  private static void setEnableSafeCipherSuites(SSLSocket paramSSLSocket)
  {
    if (paramSSLSocket == null) {}
    String[] arrayOfString1;
    do
    {
      return;
      arrayOfString1 = paramSSLSocket.getEnabledCipherSuites();
    } while ((arrayOfString1 == null) || (arrayOfString1.length == 0));
    ArrayList localArrayList = new ArrayList();
    int k = arrayOfString1.length;
    int i = 0;
    String str1;
    if (i < k)
    {
      str1 = arrayOfString1[i];
      String str2 = str1.toUpperCase(Locale.ENGLISH);
      String[] arrayOfString2 = e;
      int m = arrayOfString2.length;
      j = 0;
      label70:
      if (j >= m) {
        break label149;
      }
      if (!str2.contains(arrayOfString2[j].toUpperCase(Locale.ENGLISH))) {}
    }
    label149:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        localArrayList.add(str1);
      }
      i += 1;
      break;
      j += 1;
      break label70;
      paramSSLSocket.setEnabledCipherSuites((String[])localArrayList.toArray(new String[localArrayList.size()]));
      return;
    }
  }
  
  private void setEnabledProtocols(SSLSocket paramSSLSocket)
  {
    if ((paramSSLSocket != null) && (Build.VERSION.SDK_INT >= 16)) {
      paramSSLSocket.setEnabledProtocols(new String[] { "TLSv1.1", "TLSv1.2" });
    }
  }
  
  public Socket createSocket()
  {
    Socket localSocket = this.g.getSocketFactory().createSocket();
    a(localSocket);
    return localSocket;
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    paramSocket = this.g.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    a(paramSocket);
    return paramSocket;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.SecureApacheSSLSocketFactory
 * JD-Core Version:    0.7.0.1
 */