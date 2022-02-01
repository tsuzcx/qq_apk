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
    paramWebView = new StringBuilder();
    paramWebView.append("onPageFinished:");
    paramWebView.append(paramString);
    GdtLog.b("GdtVideoCeilingView", paramWebView.toString());
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    paramWebView = new StringBuilder();
    paramWebView.append("onPageStarted:");
    paramWebView.append(paramString);
    GdtLog.b("GdtVideoCeilingView", paramWebView.toString());
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
    paramWebView = new StringBuilder();
    paramWebView.append("onReceivedTitle: ");
    paramWebView.append(paramString);
    GdtLog.b("GdtVideoCeilingView", paramWebView.toString());
    GdtVideoCeilingView.a(this.a).setWebBarTitle(paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return a(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingView.1
 * JD-Core Version:    0.7.0.1
 */