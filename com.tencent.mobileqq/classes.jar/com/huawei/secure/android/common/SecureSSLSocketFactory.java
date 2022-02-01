package com.huawei.secure.android.common;

import android.content.Context;
import android.os.Build.VERSION;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
  private static final String d = "TLS";
  private static final String[] h = { "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", "TLS_RSA" };
  private static volatile SecureSSLSocketFactory i = null;
  private static String[] j = null;
  private SSLContext g = null;
  private Context mContext;
  
  private SecureSSLSocketFactory(Context paramContext)
  {
    this.mContext = paramContext;
    this.g = SSLContext.getInstance("TLS");
    paramContext = new SecureX509TrustManager(this.mContext);
    this.g.init(null, new X509TrustManager[] { paramContext }, null);
  }
  
  @Deprecated
  public SecureSSLSocketFactory(InputStream paramInputStream, String paramString)
  {
    this.g = SSLContext.getInstance("TLS");
    paramInputStream = new HiCloudX509TrustManager(paramInputStream, paramString);
    this.g.init(null, new X509TrustManager[] { paramInputStream }, null);
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
  public static SecureSSLSocketFactory getInstance(Context paramContext)
  {
    if (i == null) {}
    try
    {
      if (i == null) {
        i = new SecureSSLSocketFactory(paramContext);
      }
      return i;
    }
    finally {}
  }
  
  private static void setEnableSafeCipherSuites(SSLSocket paramSSLSocket)
  {
    if (paramSSLSocket == null) {
      return;
    }
    String[] arrayOfString1 = paramSSLSocket.getEnabledCipherSuites();
    ArrayList localArrayList = new ArrayList();
    int n = arrayOfString1.length;
    int k = 0;
    String str1;
    if (k < n)
    {
      str1 = arrayOfString1[k];
      String str2 = str1.toUpperCase(Locale.ENGLISH);
      String[] arrayOfString2 = h;
      int i1 = arrayOfString2.length;
      m = 0;
      label59:
      if (m >= i1) {
        break label144;
      }
      if (!str2.contains(arrayOfString2[m].toUpperCase(Locale.ENGLISH))) {}
    }
    label144:
    for (int m = 1;; m = 0)
    {
      if (m == 0) {
        localArrayList.add(str1);
      }
      k += 1;
      break;
      m += 1;
      break label59;
      j = (String[])localArrayList.toArray(new String[localArrayList.size()]);
      paramSSLSocket.setEnabledCipherSuites(j);
      return;
    }
  }
  
  private void setEnabledProtocols(SSLSocket paramSSLSocket)
  {
    if ((paramSSLSocket != null) && (Build.VERSION.SDK_INT >= 16)) {
      paramSSLSocket.setEnabledProtocols(new String[] { "TLSv1.1", "TLSv1.2" });
    }
  }
  
  public Socket createSocket(String paramString, int paramInt)
  {
    paramString = this.g.getSocketFactory().createSocket(paramString, paramInt);
    a(paramString);
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
    paramSocket = this.g.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    a(paramSocket);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.SecureSSLSocketFactory
 * JD-Core Version:    0.7.0.1
 */