package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.util.b;
import com.huawei.secure.android.common.ssl.util.g;
import com.huawei.secure.android.common.ssl.util.j;
import java.security.cert.X509Certificate;

public class WebViewSSLCheck
{
  private static final String TAG = WebViewSSLCheck.class.getSimpleName();
  
  public static void checkServerCertificateNew(SslErrorHandler paramSslErrorHandler, SslError paramSslError, Context paramContext)
  {
    checkServerCertificateNew(paramSslErrorHandler, paramSslError, null, paramContext, null);
  }
  
  public static void checkServerCertificateNew(SslErrorHandler paramSslErrorHandler, SslError paramSslError, String paramString, Context paramContext, WebViewSSLCheckThread.Callback paramCallback)
  {
    g.c(TAG, " error type : " + paramSslError.getPrimaryError());
    paramSslError = b.a(paramSslError.getCertificate());
    X509Certificate localX509Certificate = new j(paramContext).m();
    g.b(TAG, "checkServerCertificateNew: error certificate is : " + paramSslError);
    if (b.a(localX509Certificate, paramSslError))
    {
      g.c(TAG, "checkServerCertificateNew: proceed");
      if (paramCallback != null)
      {
        paramCallback.onProceed(paramContext, paramString);
        return;
      }
      paramSslErrorHandler.proceed();
      return;
    }
    g.e(TAG, "checkServerCertificateNew: cancel");
    if (paramCallback != null)
    {
      paramCallback.onCancel(paramContext, paramString);
      return;
    }
    paramSslErrorHandler.cancel();
  }
  
  public static boolean checkServerCertificateNew(String paramString, SslError paramSslError)
  {
    return checkServerCertificateNew(b.d(paramString), paramSslError);
  }
  
  public static boolean checkServerCertificateNew(X509Certificate paramX509Certificate, SslError paramSslError)
  {
    return b.a(paramX509Certificate, b.a(paramSslError.getCertificate()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.WebViewSSLCheck
 * JD-Core Version:    0.7.0.1
 */