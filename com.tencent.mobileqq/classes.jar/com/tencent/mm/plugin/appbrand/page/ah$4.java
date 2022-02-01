package com.tencent.mm.plugin.appbrand.page;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

class ah$4
  extends WebChromeClient
{
  ah$4(ah paramah) {}
  
  @Override
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    super.onProgressChanged(paramWebView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ah.4
 * JD-Core Version:    0.7.0.1
 */