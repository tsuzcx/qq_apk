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
    paramWebView = new StringBuilder();
    paramWebView.append("GdtBaseHalfScreenFragment onReceivedTitle");
    paramWebView.append(paramString);
    GdtLog.b("AbsWebView", paramWebView.toString());
    if (GdtBaseHalfScreenFragment.b(this.a) != null) {
      GdtBaseHalfScreenFragment.b(this.a).setText(paramString);
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("jsbridge://"))) {
      return true;
    }
    Object localObject2 = ((CustomWebView)paramWebView).getPluginEngine();
    boolean bool = paramString.startsWith("file://");
    Object localObject1 = null;
    if ((!bool) && (!paramString.startsWith("data:")) && (!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
    {
      localObject2 = AdUriUtil.parse(paramString);
      paramString = localObject1;
      if (localObject2 != null) {
        paramString = ((Uri)localObject2).getScheme();
      }
      if (AuthorizeConfig.a().d(paramWebView.getUrl(), paramString).booleanValue())
      {
        paramWebView = new Intent("android.intent.action.VIEW", (Uri)localObject2);
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
    return (localObject2 != null) && (((WebViewPluginEngine)localObject2).a(paramString, 16L, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.halfScreen.GdtBaseHalfScreenFragment.3
 * JD-Core Version:    0.7.0.1
 */