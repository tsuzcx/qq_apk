package com.tencent.gdtad.views.videoimax;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.ad.tangram.util.AdUriUtil;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingTitleBar;
import com.tencent.gdtad.views.videoceiling.GdtWebViewBuilder;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.smtt.sdk.WebView;

class GdtVideoImaxFragment$6
  extends GdtWebViewBuilder
{
  GdtVideoImaxFragment$6(GdtVideoImaxFragment paramGdtVideoImaxFragment, Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramIntent, paramAppInterface);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    paramWebView = new StringBuilder();
    paramWebView.append("onPageFinished:");
    paramWebView.append(paramString);
    GdtLog.b("AbsWebView", paramWebView.toString());
    GdtVideoImaxFragment.c(this.a, true);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    paramWebView = new StringBuilder();
    paramWebView.append("onPageStarted:");
    paramWebView.append(paramString);
    GdtLog.b("AbsWebView", paramWebView.toString());
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    GdtVideoImaxFragment.c(this.a, false);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
    paramWebView = new StringBuilder();
    paramWebView.append("onReceivedTitle: ");
    paramWebView.append(paramString);
    GdtLog.b("AbsWebView", paramWebView.toString());
    GdtVideoImaxFragment.j(this.a).setWebBarTitle(paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shouldOverrideUrlLoading:");
    localStringBuilder.append(paramString);
    GdtLog.b("AbsWebView", localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("jsbridge://"))) {
      return true;
    }
    Object localObject = ((CustomWebView)paramWebView).getPluginEngine();
    boolean bool = paramString.startsWith("file://");
    localStringBuilder = null;
    if ((!bool) && (!paramString.startsWith("data:")) && (!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
    {
      localObject = AdUriUtil.parse(paramString);
      paramString = localStringBuilder;
      if (localObject != null) {
        paramString = ((Uri)localObject).getScheme();
      }
      if (AuthorizeConfig.a().d(paramWebView.getUrl(), paramString).booleanValue())
      {
        paramWebView = new Intent("android.intent.action.VIEW", (Uri)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment.6
 * JD-Core Version:    0.7.0.1
 */