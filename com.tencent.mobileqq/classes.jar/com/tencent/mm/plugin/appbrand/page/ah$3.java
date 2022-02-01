package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

class ah$3
  extends WebViewClient
{
  ah$3(ah paramah) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    ah.a(this.a).c(paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    ah.a(this.a).b(paramString);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if (paramSslError.getPrimaryError() == 3)
    {
      if (ah.a(this.a).a(paramSslError.getCertificate()))
      {
        paramSslErrorHandler.proceed();
        return;
      }
      paramSslErrorHandler.cancel();
      return;
    }
    paramSslErrorHandler.cancel();
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return null;
    }
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null))
    {
      if (af.c(paramWebResourceRequest.getUrl().toString())) {
        return null;
      }
      paramWebView = paramWebResourceRequest.getUrl().toString();
      return ah.a(this.a).e(paramWebView);
    }
    return null;
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    if (af.c(paramString)) {
      return null;
    }
    return ah.a(this.a).e(paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ah.3
 * JD-Core Version:    0.7.0.1
 */