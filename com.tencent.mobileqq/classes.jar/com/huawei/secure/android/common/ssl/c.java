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
  private static final String c = "WebViewX509TrustManger";
  private X509Certificate a;
  private List<X509TrustManager> b = new ArrayList();
  
  public c(Context paramContext)
  {
    if (paramContext != null)
    {
      com.huawei.secure.android.common.ssl.util.c.a(paramContext);
      this.a = new j(paramContext).b();
      if (this.a != null) {
        return;
      }
      throw new NullPointerException("WebViewX509TrustManger cannot get cbg root ca");
    }
    throw new NullPointerException("WebViewX509TrustManger context is null");
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    g.c("WebViewX509TrustManger", "checkClientTrusted");
    if (!this.b.isEmpty())
    {
      ((X509TrustManager)this.b.get(0)).checkClientTrusted(paramArrayOfX509Certificate, paramString);
      return;
    }
    throw new CertificateException("checkClientTrusted CertificateException");
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    g.c("WebViewX509TrustManger", "checkServerTrusted");
    int j = 0;
    int i = 0;
    while (i < paramArrayOfX509Certificate.length)
    {
      paramString = new StringBuilder();
      paramString.append("checkServerTrusted ");
      paramString.append(i);
      paramString.append(" : ");
      paramString.append(paramArrayOfX509Certificate[i].getIssuerDN().getName());
      g.a("WebViewX509TrustManger", paramString.toString());
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
      boolean bool = b.a(this.a, paramString);
      j = bool;
    }
    catch (CertificateException paramArrayOfX509Certificate)
    {
      paramString = new StringBuilder();
      paramString.append("checkServerTrusted CertificateException: ");
      paramString.append(paramArrayOfX509Certificate.getMessage());
      g.b("WebViewX509TrustManger", paramString.toString());
    }
    catch (SignatureException paramString)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkServerTrusted SignatureException: ");
      localStringBuilder.append(paramString.getMessage());
      g.b("WebViewX509TrustManger", localStringBuilder.toString());
    }
    catch (InvalidKeyException paramString)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkServerTrusted InvalidKeyException: ");
      localStringBuilder.append(paramString.getMessage());
      g.b("WebViewX509TrustManger", localStringBuilder.toString());
    }
    catch (NoSuchAlgorithmException paramString)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkServerTrusted NoSuchAlgorithmException: ");
      localStringBuilder.append(paramString.getMessage());
      g.b("WebViewX509TrustManger", localStringBuilder.toString());
    }
    catch (NoSuchProviderException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkServerTrusted NoSuchProviderException: ");
      localStringBuilder.append(paramString.getMessage());
      g.b("WebViewX509TrustManger", localStringBuilder.toString());
    }
    if (j != 0) {
      return;
    }
    for (;;)
    {
      throw paramArrayOfX509Certificate;
    }
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    try
    {
      Object localObject1 = new ArrayList();
      localObject2 = this.b.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).addAll(Arrays.asList(((X509TrustManager)((Iterator)localObject2).next()).getAcceptedIssuers()));
      }
      localObject1 = (X509Certificate[])((ArrayList)localObject1).toArray(new X509Certificate[((ArrayList)localObject1).size()]);
      return localObject1;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAcceptedIssuers exception : ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      g.b("WebViewX509TrustManger", ((StringBuilder)localObject2).toString());
    }
    return new X509Certificate[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.c
 * JD-Core Version:    0.7.0.1
 */