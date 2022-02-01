package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.a;
import com.huawei.secure.android.common.ssl.util.c;
import com.huawei.secure.android.common.ssl.util.g;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class SSFCompatiableSystemCA
  extends SSLSocketFactory
{
  private static volatile SSFCompatiableSystemCA A = null;
  private static final String TAG = SSFCompatiableSystemCA.class.getSimpleName();
  private SSLContext g = null;
  private SSLSocket t = null;
  private Context u;
  private String[] v;
  private X509TrustManager w;
  private String[] x;
  private String[] y;
  private String[] z;
  
  private SSFCompatiableSystemCA(Context paramContext)
  {
    if (paramContext == null)
    {
      g.e(TAG, "SecureSSLSocketFactory: context is null");
      return;
    }
    setContext(paramContext);
    setSslContext(SSLUtil.setSSLContext());
    this.w = SSFSecureX509SingleInstance.getInstance(paramContext);
    paramContext = this.g;
    X509TrustManager localX509TrustManager = this.w;
    SecureRandom localSecureRandom = new SecureRandom();
    paramContext.init(null, new X509TrustManager[] { localX509TrustManager }, localSecureRandom);
  }
  
  public SSFCompatiableSystemCA(X509TrustManager paramX509TrustManager)
  {
    this.g = SSLUtil.setSSLContext();
    setX509TrustManager(paramX509TrustManager);
    SSLContext localSSLContext = this.g;
    SecureRandom localSecureRandom = new SecureRandom();
    localSSLContext.init(null, new X509TrustManager[] { paramX509TrustManager }, localSecureRandom);
  }
  
  static void a(X509TrustManager paramX509TrustManager)
  {
    g.c(TAG, "ssfc update socket factory trust manager");
    try
    {
      A = new SSFCompatiableSystemCA(paramX509TrustManager);
      return;
    }
    catch (NoSuchAlgorithmException paramX509TrustManager)
    {
      g.e(TAG, "NoSuchAlgorithmException");
      return;
    }
    catch (KeyManagementException paramX509TrustManager)
    {
      g.e(TAG, "KeyManagementException");
    }
  }
  
  private void b(Socket paramSocket)
  {
    int j = 0;
    if (!a.a(this.z))
    {
      g.c(TAG, "set protocols");
      SSLUtil.setEnabledProtocols((SSLSocket)paramSocket, this.z);
    }
    for (int i = 1;; i = 0)
    {
      if ((!a.a(this.y)) || (!a.a(this.x)))
      {
        g.c(TAG, "set white cipher or black cipher");
        SSLUtil.setEnabledProtocols((SSLSocket)paramSocket);
        if (a.a(this.y)) {
          break label132;
        }
        SSLUtil.setWhiteListCipherSuites((SSLSocket)paramSocket, this.y);
      }
      for (;;)
      {
        j = 1;
        if (i == 0)
        {
          g.c(TAG, "set default protocols");
          SSLUtil.setEnabledProtocols((SSLSocket)paramSocket);
        }
        if (j == 0)
        {
          g.c(TAG, "set default cipher suites");
          SSLUtil.setEnableSafeCipherSuites((SSLSocket)paramSocket);
        }
        return;
        label132:
        SSLUtil.setBlackListCipherSuites((SSLSocket)paramSocket, this.x);
      }
    }
  }
  
  public static SSFCompatiableSystemCA getInstance(Context paramContext)
  {
    c.setContext(paramContext);
    if (A == null) {}
    try
    {
      if (A == null) {
        A = new SSFCompatiableSystemCA(paramContext);
      }
      if ((A.u == null) && (paramContext != null)) {
        A.setContext(paramContext);
      }
      return A;
    }
    finally {}
  }
  
  public Socket createSocket(String paramString, int paramInt)
  {
    g.c(TAG, "createSocket: host , port");
    paramString = this.g.getSocketFactory().createSocket(paramString, paramInt);
    if ((paramString instanceof SSLSocket))
    {
      b(paramString);
      this.t = ((SSLSocket)paramString);
      this.v = ((String[])this.t.getEnabledCipherSuites().clone());
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
    g.c(TAG, "createSocket: s , host , port , autoClose");
    paramSocket = this.g.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    if ((paramSocket instanceof SSLSocket))
    {
      b(paramSocket);
      this.t = ((SSLSocket)paramSocket);
      this.v = ((String[])this.t.getEnabledCipherSuites().clone());
    }
    return paramSocket;
  }
  
  public String[] getBlackCiphers()
  {
    return this.x;
  }
  
  public X509Certificate[] getChain()
  {
    if ((this.w instanceof SecureX509TrustManager)) {
      return ((SecureX509TrustManager)this.w).getChain();
    }
    return new X509Certificate[0];
  }
  
  public Context getContext()
  {
    return this.u;
  }
  
  public String[] getDefaultCipherSuites()
  {
    return new String[0];
  }
  
  public String[] getProtocols()
  {
    return this.z;
  }
  
  public SSLContext getSslContext()
  {
    return this.g;
  }
  
  public SSLSocket getSslSocket()
  {
    return this.t;
  }
  
  public String[] getSupportedCipherSuites()
  {
    if (this.v != null) {
      return this.v;
    }
    return new String[0];
  }
  
  public String[] getWhiteCiphers()
  {
    return this.y;
  }
  
  public X509TrustManager getX509TrustManager()
  {
    return this.w;
  }
  
  public void setBlackCiphers(String[] paramArrayOfString)
  {
    this.x = paramArrayOfString;
  }
  
  public void setContext(Context paramContext)
  {
    this.u = paramContext.getApplicationContext();
  }
  
  public void setProtocols(String[] paramArrayOfString)
  {
    this.z = paramArrayOfString;
  }
  
  public void setSslContext(SSLContext paramSSLContext)
  {
    this.g = paramSSLContext;
  }
  
  public void setWhiteCiphers(String[] paramArrayOfString)
  {
    this.y = paramArrayOfString;
  }
  
  public void setX509TrustManager(X509TrustManager paramX509TrustManager)
  {
    this.w = paramX509TrustManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.SSFCompatiableSystemCA
 * JD-Core Version:    0.7.0.1
 */