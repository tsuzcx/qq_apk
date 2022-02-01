package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.a;
import com.huawei.secure.android.common.ssl.util.c;
import com.huawei.secure.android.common.ssl.util.g;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

public class SASFCompatiableSystemCA
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  private static final String i = "SASFCompatiableSystemCA";
  private static volatile SASFCompatiableSystemCA j;
  private SSLContext a;
  private SSLSocket b = null;
  private Context c;
  private String[] d;
  private X509TrustManager e;
  private String[] f;
  private String[] g;
  private String[] h;
  
  private SASFCompatiableSystemCA(KeyStore paramKeyStore)
  {
    super(paramKeyStore);
  }
  
  private SASFCompatiableSystemCA(KeyStore paramKeyStore, Context paramContext)
  {
    super(paramKeyStore);
    if (paramContext == null)
    {
      g.b(i, "SecureSSLSocketFactory: context is null");
      return;
    }
    setContext(paramContext);
    setSslContext(SSLUtil.setSSLContext());
    this.e = SSFSecureX509SingleInstance.getInstance(paramContext);
    this.a.init(null, new X509TrustManager[] { this.e }, null);
  }
  
  public SASFCompatiableSystemCA(KeyStore paramKeyStore, X509TrustManager paramX509TrustManager)
  {
    super(paramKeyStore);
    this.a = SSLUtil.setSSLContext();
    setX509TrustManager(paramX509TrustManager);
    this.a.init(null, new X509TrustManager[] { paramX509TrustManager }, null);
  }
  
  private void a(Socket paramSocket)
  {
    boolean bool = a.a(this.h);
    int m = 1;
    int k;
    if (!bool)
    {
      g.c(i, "set protocols");
      SSLUtil.setEnabledProtocols((SSLSocket)paramSocket, this.h);
      k = 1;
    }
    else
    {
      k = 0;
    }
    if ((a.a(this.g)) && (a.a(this.f)))
    {
      m = 0;
    }
    else
    {
      g.c(i, "set white cipher or black cipher");
      SSLSocket localSSLSocket = (SSLSocket)paramSocket;
      SSLUtil.setEnabledProtocols(localSSLSocket);
      if (!a.a(this.g)) {
        SSLUtil.setWhiteListCipherSuites(localSSLSocket, this.g);
      } else {
        SSLUtil.setBlackListCipherSuites(localSSLSocket, this.f);
      }
    }
    if (k == 0)
    {
      g.c(i, "set default protocols");
      SSLUtil.setEnabledProtocols((SSLSocket)paramSocket);
    }
    if (m == 0)
    {
      g.c(i, "set default cipher suites");
      SSLUtil.setEnableSafeCipherSuites((SSLSocket)paramSocket);
    }
  }
  
  static void a(X509TrustManager paramX509TrustManager)
  {
    g.c(i, "sasfc update socket factory trust manager");
    long l = System.currentTimeMillis();
    try
    {
      j = new SASFCompatiableSystemCA(null, paramX509TrustManager);
    }
    catch (NoSuchAlgorithmException paramX509TrustManager)
    {
      StringBuilder localStringBuilder;
      break label60;
    }
    catch (KeyManagementException paramX509TrustManager)
    {
      break label49;
    }
    catch (UnrecoverableKeyException paramX509TrustManager)
    {
      break label38;
    }
    catch (KeyStoreException paramX509TrustManager)
    {
      label27:
      break label27;
    }
    g.b(i, "KeyStoreException");
    break label68;
    label38:
    g.b(i, "UnrecoverableKeyException");
    break label68;
    label49:
    g.b(i, "KeyManagementException");
    break label68;
    label60:
    g.b(i, "NoSuchAlgorithmException");
    label68:
    paramX509TrustManager = i;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("sasf system ca update: cost : ");
    localStringBuilder.append(System.currentTimeMillis() - l);
    localStringBuilder.append(" ms");
    g.a(paramX509TrustManager, localStringBuilder.toString());
  }
  
  public static SASFCompatiableSystemCA getInstance(KeyStore paramKeyStore, Context paramContext)
  {
    c.a(paramContext);
    if (j == null) {
      try
      {
        if (j == null) {
          j = new SASFCompatiableSystemCA(paramKeyStore, paramContext);
        }
      }
      finally {}
    }
    return j;
  }
  
  public Socket createSocket()
  {
    g.c(i, "createSocket: ");
    Socket localSocket = this.a.getSocketFactory().createSocket();
    if ((localSocket instanceof SSLSocket))
    {
      a(localSocket);
      this.b = ((SSLSocket)localSocket);
      this.d = ((String[])this.b.getEnabledCipherSuites().clone());
    }
    return localSocket;
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    g.c(i, "createSocket: socket host port autoClose");
    paramSocket = this.a.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    if ((paramSocket instanceof SSLSocket))
    {
      a(paramSocket);
      this.b = ((SSLSocket)paramSocket);
      this.d = ((String[])this.b.getEnabledCipherSuites().clone());
    }
    return paramSocket;
  }
  
  public String[] getBlackCiphers()
  {
    return this.f;
  }
  
  public X509Certificate[] getChain()
  {
    X509TrustManager localX509TrustManager = this.e;
    if ((localX509TrustManager instanceof SecureX509TrustManager)) {
      return ((SecureX509TrustManager)localX509TrustManager).getChain();
    }
    return new X509Certificate[0];
  }
  
  public Context getContext()
  {
    return this.c;
  }
  
  public String[] getProtocols()
  {
    return this.h;
  }
  
  public SSLContext getSslContext()
  {
    return this.a;
  }
  
  public SSLSocket getSslSocket()
  {
    return this.b;
  }
  
  public String[] getSupportedCipherSuites()
  {
    String[] arrayOfString = this.d;
    if (arrayOfString != null) {
      return arrayOfString;
    }
    return new String[0];
  }
  
  public String[] getWhiteCiphers()
  {
    return this.g;
  }
  
  public X509TrustManager getX509TrustManager()
  {
    return this.e;
  }
  
  public void setBlackCiphers(String[] paramArrayOfString)
  {
    this.f = paramArrayOfString;
  }
  
  public void setContext(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
  }
  
  public void setProtocols(String[] paramArrayOfString)
  {
    this.h = paramArrayOfString;
  }
  
  public void setSslContext(SSLContext paramSSLContext)
  {
    this.a = paramSSLContext;
  }
  
  public void setSslSocket(SSLSocket paramSSLSocket)
  {
    this.b = paramSSLSocket;
  }
  
  public void setWhiteCiphers(String[] paramArrayOfString)
  {
    this.g = paramArrayOfString;
  }
  
  public void setX509TrustManager(X509TrustManager paramX509TrustManager)
  {
    this.e = paramX509TrustManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.SASFCompatiableSystemCA
 * JD-Core Version:    0.7.0.1
 */