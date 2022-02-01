package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.b;
import com.huawei.secure.android.common.ssl.util.g;
import com.huawei.secure.android.common.ssl.util.j;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.X509TrustManager;

public class c
  implements X509TrustManager
{
  private static final String TAG = "WebViewX509TrustManger";
  private X509Certificate V;
  private List<X509TrustManager> c = new ArrayList();
  
  public c(Context paramContext)
  {
    if (paramContext == null) {
      throw new NullPointerException("WebViewX509TrustManger context is null");
    }
    com.huawei.secure.android.common.ssl.util.c.setContext(paramContext);
    this.V = new j(paramContext).l();
    if (this.V == null) {
      throw new NullPointerException("WebViewX509TrustManger cannot get cbg root ca");
    }
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    g.c("WebViewX509TrustManger", "checkClientTrusted");
    if (!this.c.isEmpty())
    {
      ((X509TrustManager)this.c.get(0)).checkClientTrusted(paramArrayOfX509Certificate, paramString);
      return;
    }
    throw new CertificateException("checkClientTrusted CertificateException");
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    int k = 0;
    int j = 0;
    g.c("WebViewX509TrustManger", "checkServerTrusted");
    int i = 0;
    while (i < paramArrayOfX509Certificate.length)
    {
      g.b("WebViewX509TrustManger", "checkServerTrusted " + i + " : " + paramArrayOfX509Certificate[i].getIssuerDN().getName());
      i += 1;
    }
    paramString = new X509Certificate[paramArrayOfX509Certificate.length];
    i = 0;
    while (i < paramArrayOfX509Certificate.length)
    {
      paramString[i] = paramArrayOfX509Certificate[(paramArrayOfX509Certificate.length - 1 - i)];
      i += 1;
    }
    paramArrayOfX509Certificate = new CertificateException("CBG root CA CertificateException");
    try
    {
      boolean bool = b.a(this.V, paramString);
      i = j;
      if (bool) {
        i = 1;
      }
    }
    catch (NoSuchProviderException paramString)
    {
      for (;;)
      {
        g.e("WebViewX509TrustManger", "checkServerTrusted NoSuchProviderException: " + paramString.getMessage());
        i = k;
      }
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;)
      {
        g.e("WebViewX509TrustManger", "checkServerTrusted NoSuchAlgorithmException: " + paramString.getMessage());
        i = k;
      }
    }
    catch (InvalidKeyException paramString)
    {
      for (;;)
      {
        g.e("WebViewX509TrustManger", "checkServerTrusted InvalidKeyException: " + paramString.getMessage());
        i = k;
      }
    }
    catch (SignatureException paramString)
    {
      for (;;)
      {
        g.e("WebViewX509TrustManger", "checkServerTrusted SignatureException: " + paramString.getMessage());
        i = k;
      }
    }
    catch (CertificateException paramArrayOfX509Certificate)
    {
      for (;;)
      {
        g.e("WebViewX509TrustManger", "checkServerTrusted CertificateException: " + paramArrayOfX509Certificate.getMessage());
        i = k;
      }
    }
    if (i == 0) {
      throw paramArrayOfX509Certificate;
    }
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        localArrayList.addAll(Arrays.asList(((X509TrustManager)localIterator.next()).getAcceptedIssuers()));
      }
      arrayOfX509Certificate = (X509Certificate[])localException.toArray(new X509Certificate[localException.size()]);
    }
    catch (Exception localException)
    {
      g.e("WebViewX509TrustManger", "getAcceptedIssuers exception : " + localException.getMessage());
      return new X509Certificate[0];
    }
    X509Certificate[] arrayOfX509Certificate;
    return arrayOfX509Certificate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.c
 * JD-Core Version:    0.7.0.1
 */