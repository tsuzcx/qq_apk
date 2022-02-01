package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.net.http.SslCertificate;
import android.net.http.SslCertificate.DName;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.util.b;
import com.huawei.secure.android.common.ssl.util.g;
import com.huawei.secure.android.common.ssl.util.j;
import java.security.cert.X509Certificate;

public class WebViewSSLCheck
{
  private static final String a = "WebViewSSLCheck";
  
  public static void checkServerCertificateNew(SslErrorHandler paramSslErrorHandler, SslError paramSslError, Context paramContext)
  {
    checkServerCertificateNew(paramSslErrorHandler, paramSslError, null, paramContext, null);
  }
  
  public static void checkServerCertificateNew(SslErrorHandler paramSslErrorHandler, SslError paramSslError, String paramString, Context paramContext, WebViewSSLCheckThread.Callback paramCallback)
  {
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" error type : ");
    ((StringBuilder)localObject2).append(paramSslError.getPrimaryError());
    ((StringBuilder)localObject2).append(" , cn is : ");
    ((StringBuilder)localObject2).append(paramSslError.getCertificate().getIssuedTo().getCName());
    g.c((String)localObject1, ((StringBuilder)localObject2).toString());
    paramSslError = b.a(paramSslError.getCertificate());
    localObject1 = new j(paramContext).a();
    localObject2 = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkServerCertificateNew: error certificate is : ");
    localStringBuilder.append(paramSslError);
    g.a((String)localObject2, localStringBuilder.toString());
    if (b.a((X509Certificate)localObject1, paramSslError))
    {
      g.c(a, "checkServerCertificateNew: proceed");
      if (paramCallback != null)
      {
        paramCallback.onProceed(paramContext, paramString);
        return;
      }
      paramSslErrorHandler.proceed();
      return;
    }
    g.b(a, "checkServerCertificateNew: cancel");
    if (paramCallback != null)
    {
      paramCallback.onCancel(paramContext, paramString);
      return;
    }
    paramSslErrorHandler.cancel();
  }
  
  public static boolean checkServerCertificateNew(String paramString, SslError paramSslError)
  {
    return checkServerCertificateNew(b.a(paramString), paramSslError);
  }
  
  public static boolean checkServerCertificateNew(X509Certificate paramX509Certificate, SslError paramSslError)
  {
    return b.a(paramX509Certificate, b.a(paramSslError.getCertificate()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.WebViewSSLCheck
 * JD-Core Version:    0.7.0.1
 */