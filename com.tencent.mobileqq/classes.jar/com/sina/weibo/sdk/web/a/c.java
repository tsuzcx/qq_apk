package com.sina.weibo.sdk.web.a;

import Override;
import android.graphics.Bitmap;
import android.webkit.WebView;
import com.sina.weibo.sdk.web.WebActivity;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

public final class c
  extends b
{
  public c(WebActivity paramWebActivity, com.sina.weibo.sdk.web.b.b paramb)
  {
    super(paramWebActivity, null, paramb);
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.web.a.c
 * JD-Core Version:    0.7.0.1
 */