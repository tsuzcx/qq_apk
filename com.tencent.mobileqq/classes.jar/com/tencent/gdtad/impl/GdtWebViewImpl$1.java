package com.tencent.gdtad.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.inject.IGdtWebViewListener;
import com.tencent.gdtad.views.videoceiling.GdtWebViewBuilder;
import com.tencent.smtt.sdk.WebView;

class GdtWebViewImpl$1
  extends GdtWebViewBuilder
{
  GdtWebViewImpl$1(GdtWebViewImpl paramGdtWebViewImpl, Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface, IGdtWebViewListener paramIGdtWebViewListener)
  {
    super(paramContext, paramActivity, paramIntent, paramAppInterface);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    IGdtWebViewListener localIGdtWebViewListener = this.a;
    if (localIGdtWebViewListener != null) {
      localIGdtWebViewListener.b(paramWebView, paramString);
    }
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    IGdtWebViewListener localIGdtWebViewListener = this.a;
    if (localIGdtWebViewListener != null) {
      localIGdtWebViewListener.a(paramWebView, paramString, paramBitmap);
    }
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    IGdtWebViewListener localIGdtWebViewListener = this.a;
    if (localIGdtWebViewListener != null) {
      localIGdtWebViewListener.a(paramWebView, paramInt);
    }
    super.onProgressChanged(paramWebView, paramInt);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    IGdtWebViewListener localIGdtWebViewListener = this.a;
    if (localIGdtWebViewListener != null) {
      localIGdtWebViewListener.a(paramWebView, paramInt, paramString1, paramString2);
    }
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    IGdtWebViewListener localIGdtWebViewListener = this.a;
    if (localIGdtWebViewListener != null) {
      localIGdtWebViewListener.c(paramWebView, paramString);
    }
    super.onReceivedTitle(paramWebView, paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    IGdtWebViewListener localIGdtWebViewListener = this.a;
    if ((localIGdtWebViewListener != null) && (localIGdtWebViewListener.a(paramWebView, paramString))) {
      return true;
    }
    return a(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.impl.GdtWebViewImpl.1
 * JD-Core Version:    0.7.0.1
 */