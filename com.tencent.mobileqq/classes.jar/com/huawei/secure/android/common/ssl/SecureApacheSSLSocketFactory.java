package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.a;
import com.huawei.secure.android.common.ssl.util.c;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class SecureApacheSSLSocketFactory
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
  public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();
  private static final String i = SecureApacheSSLSocketFactory.class.getSimpleName();
  private static volatile SecureApacheSSLSocketFactory j = null;
  private SSLContext a;
  private SSLSocket b = null;
  private Context c;
  private String[] d;
  private X509TrustManager e;
  private String[] f;
  private String[] g;
  private String[] h;
  
  private SecureApacheSSLSocketFactory(KeyStore paramKeyStore)
  {
    super(paramKeyStore);
  }
  
  private SecureApacheSSLSocketFactory(KeyStore paramKeyStore, Context paramContext)
  {
    super(paramKeyStore);
    if (paramContext == null)
    {
      g.b(i, "SecureSSLSocketFactory: context is null");
      return;
    }
    setContext(paramContext);
    setSslContext(SSLUtil.setSSLContext());
    this.e = SecureX509SingleInstance.getInstance(paramContext);
    this.a.init(null, new X509TrustManager[] { this.e }, null);
  }
  
  public SecureApacheSSLSocketFactory(KeyStore paramKeyStore, InputStream paramInputStream, String paramString)
  {
    super(paramKeyStore);
    this.a = SSLUtil.setSSLContext();
    paramKeyStore = new HiCloudX509TrustManager(paramInputStream, paramString);
    setX509TrustManager(paramKeyStore);
    this.a.init(null, new X509TrustManager[] { paramKeyStore }, null);
  }
  
  public SecureApacheSSLSocketFactory(KeyStore paramKeyStore, X509TrustManager paramX509TrustManager)
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
    g.c(i, "sasf update socket factory trust manager");
    try
    {
      j = new SecureApacheSSLSocketFactory(null, paramX509TrustManager);
      return;
    }
    catch (NoSuchAlgorithmException paramX509TrustManager)
    {
      break label66;
    }
    catch (KeyManagementException paramX509TrustManager)
    {
      break label57;
    }
    catch (UnrecoverableKeyException paramX509TrustManager)
    {
      break label48;
    }
    catch (KeyStoreException paramX509TrustManager)
    {
      break label39;
    }
    catch (CertificateException paramX509TrustManager)
    {
      break label30;
    }
    catch (IOException paramX509TrustManager)
    {
      label21:
      break label21;
    }
    g.b(i, "IOException");
    return;
    label30:
    g.b(i, "CertificateException");
    return;
    label39:
    g.b(i, "KeyStoreException");
    return;
    label48:
    g.b(i, "UnrecoverableKeyException");
    return;
    label57:
    g.b(i, "KeyManagementException");
    return;
    label66:
    g.b(i, "NoSuchAlgorithmException");
  }
  
  public static SecureApacheSSLSocketFactory getInstance(KeyStore paramKeyStore, Context paramContext)
  {
    c.a(paramContext);
    if (j == null) {
      try
      {
        if (j == null) {
          j = new SecureApacheSSLSocketFactory(paramKeyStore, paramContext);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.SecureApacheSSLSocketFactory
 * JD-Core Version:    0.7.0.1
 */