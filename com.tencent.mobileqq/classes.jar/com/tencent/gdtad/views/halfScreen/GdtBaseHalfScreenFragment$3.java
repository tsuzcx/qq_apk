package com.tencent.gdtad.views.halfScreen;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.ad.tangram.util.AdUriUtil;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.videoceiling.GdtWebViewBuilder;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.smtt.sdk.WebView;

class GdtBaseHalfScreenFragment$3
  extends GdtWebViewBuilder
{
  GdtBaseHalfScreenFragment$3(GdtBaseHalfScreenFragment paramGdtBaseHalfScreenFragment, Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramIntent, paramAppInterface);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
    GdtLog.b("AbsWebView", "GdtBaseHalfScreenFragment onReceivedTitle" + paramString);
    if (GdtBaseHalfScreenFragment.a(this.a) != null) {
      GdtBaseHalfScreenFragment.a(this.a).setText(paramString);
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("jsbridge://"))) {}
    for (;;)
    {
      return true;
      Object localObject = ((CustomWebView)paramWebView).getPluginEngine();
      if ((paramString.startsWith("file://")) || (paramString.startsWith("data:")) || (paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        if ((localObject != null) && (((WebViewPluginEngine)localObject).a(paramString, 16L, null))) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
      localObject = AdUriUtil.parse(paramString);
      if (localObject != null) {}
      for (paramString = ((Uri)localObject).getScheme(); AuthorizeConfig.a().a(paramWebView.getUrl(), paramString).booleanValue(); paramString = null)
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
          return true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.views.halfScreen.GdtBaseHalfScreenFragment.3
 * JD-Core Version:    0.7.0.1
 */