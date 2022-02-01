package com.tencent.luggage.wxa.bm;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

class c$2
  extends WebViewClient
{
  c$2(c paramc, g.b paramb) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    this.a.a();
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  @TargetApi(21)
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if (this.a.a(paramWebResourceRequest.getUrl().toString()))
    {
      paramWebView = this.a.c(g.b.b);
      return new WebResourceResponse(paramWebView.a, paramWebView.b, paramWebView.c);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bm.c.2
 * JD-Core Version:    0.7.0.1
 */