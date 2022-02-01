package com.sina.weibo.sdk.web;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

final class WebActivity$4
  extends WebChromeClient
{
  WebActivity$4(WebActivity paramWebActivity) {}
  
  public final void onProgressChanged(WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    super.onProgressChanged(paramWebView, paramInt);
    WebActivity.e(this.aA).setProgress(paramInt);
    if (paramInt == 100)
    {
      WebActivity.e(this.aA).setVisibility(4);
      return;
    }
    WebActivity.e(this.aA).setVisibility(0);
  }
  
  public final void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.web.WebActivity.4
 * JD-Core Version:    0.7.0.1
 */