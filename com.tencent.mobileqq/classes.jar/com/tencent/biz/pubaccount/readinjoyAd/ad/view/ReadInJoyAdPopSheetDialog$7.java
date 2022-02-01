package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.views.videoceiling.GdtWebViewBuilder;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

class ReadInJoyAdPopSheetDialog$7
  extends GdtWebViewBuilder
{
  ReadInJoyAdPopSheetDialog$7(ReadInJoyAdPopSheetDialog paramReadInJoyAdPopSheetDialog, Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramIntent, paramAppInterface);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (QLog.isColorLevel())
    {
      paramWebView = ReadInJoyAdPopSheetDialog.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadForm onPageFinished url:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", costTime:");
      localStringBuilder.append(SystemClock.currentThreadTimeMillis() - ReadInJoyAdPopSheetDialog.f(this.a));
      QLog.d(paramWebView, 2, localStringBuilder.toString());
      paramWebView = ReadInJoyAdPopSheetDialog.a();
      paramString = new StringBuilder();
      paramString.append("onPageFinished: TOTAL costTime=");
      paramString.append(SystemClock.currentThreadTimeMillis() - ReadInJoyAdPopSheetDialog.g(this.a));
      QLog.d(paramWebView, 2, paramString.toString());
    }
    if (ReadInJoyAdPopSheetDialog.h(this.a) != null) {
      ReadInJoyAdPopSheetDialog.h(this.a).a((byte)2);
    }
    if (ReadInJoyAdPopSheetDialog.i(this.a) != null) {
      ReadInJoyAdPopSheetDialog.i(this.a).setVisibility(8);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramWebView = ReadInJoyAdPopSheetDialog.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceivedError:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("，");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramString2);
      QLog.d(paramWebView, 2, localStringBuilder.toString());
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = ReadInJoyAdPopSheetDialog.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shouldOverrideUrlLoading url:");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("jsbridge://"))) {
      return true;
    }
    Object localObject = ((CustomWebView)paramWebView).getPluginEngine();
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
          return false;
        }
        catch (ActivityNotFoundException paramWebView)
        {
          Log.e("AbsWebView", paramWebView.toString());
        }
      }
      return false;
    }
    return (localObject != null) && (((WebViewPluginEngine)localObject).a(paramString, 16L, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdPopSheetDialog.7
 * JD-Core Version:    0.7.0.1
 */