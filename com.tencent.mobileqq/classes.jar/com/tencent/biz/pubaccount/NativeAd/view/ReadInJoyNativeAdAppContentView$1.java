package com.tencent.biz.pubaccount.NativeAd.view;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.videoceiling.GdtWebViewBuilder;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.smtt.sdk.WebView;

class ReadInJoyNativeAdAppContentView$1
  extends GdtWebViewBuilder
{
  ReadInJoyNativeAdAppContentView$1(ReadInJoyNativeAdAppContentView paramReadInJoyNativeAdAppContentView, Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramIntent, paramAppInterface);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    paramWebView = this.a.findViewById(2131428508);
    if ((paramWebView != null) && (ReadInJoyNativeAdAppContentView.a(this.a) != null))
    {
      ReadInJoyNativeAdAppContentView.a(this.a).setVisibility(8);
      paramWebView.setVisibility(0);
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("shouldOverrideUrlLoading:");
    ((StringBuilder)localObject).append(paramString);
    GdtLog.b("AbsWebView", ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("jsbridge://"))) {
      return true;
    }
    localObject = ((CustomWebView)paramWebView).getPluginEngine();
    if ((!paramString.startsWith("file://")) && (!paramString.startsWith("data:")) && (!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
    {
      paramString = Uri.parse(paramString);
      localObject = paramString.getScheme();
      if (AuthorizeConfig.a().d(paramWebView.getUrl(), (String)localObject).booleanValue())
      {
        paramWebView = new Intent("android.intent.action.VIEW", paramString);
        paramWebView.addFlags(268435456);
        try
        {
          this.mContext.startActivity(paramWebView);
          return true;
        }
        catch (ActivityNotFoundException paramWebView)
        {
          GdtLog.d("AbsWebView", paramWebView.toString());
        }
      }
      return true;
    }
    return (localObject != null) && (((WebViewPluginEngine)localObject).a(paramString, 16L, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppContentView.1
 * JD-Core Version:    0.7.0.1
 */