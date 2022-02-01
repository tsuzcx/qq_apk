package com.tencent.gdtad.views.videoceiling;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.smtt.sdk.WebView;

class GdtVideoCeilingView$1
  extends GdtWebViewBuilder
{
  GdtVideoCeilingView$1(GdtVideoCeilingView paramGdtVideoCeilingView, Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramIntent, paramAppInterface);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    GdtLog.b("GdtVideoCeilingView", "onPageFinished:" + paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    GdtLog.b("GdtVideoCeilingView", "onPageStarted:" + paramString);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
    GdtLog.b("GdtVideoCeilingView", "onReceivedTitle: " + paramString);
    GdtVideoCeilingView.a(this.a).setWebBarTitle(paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return a(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingView.1
 * JD-Core Version:    0.7.0.1
 */