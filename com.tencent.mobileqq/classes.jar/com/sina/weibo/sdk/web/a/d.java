package com.sina.weibo.sdk.web.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.sina.weibo.sdk.c.e;
import com.sina.weibo.sdk.web.a;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

public final class d
  extends b
{
  public d(Activity paramActivity, a parama, com.sina.weibo.sdk.web.b.b paramb)
  {
    super(paramActivity, parama, paramb);
  }
  
  public final void m(String paramString)
  {
    k(paramString);
  }
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
  }
  
  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  @TargetApi(21)
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    paramWebView = paramWebResourceRequest.getUrl().toString();
    if ((!TextUtils.isEmpty(paramWebView)) && (paramWebView.startsWith("sinaweibo://browser/close")))
    {
      paramWebResourceRequest = e.g(paramWebView);
      if (paramWebResourceRequest != null)
      {
        paramWebView = paramWebResourceRequest.getString("code");
        paramWebResourceRequest = paramWebResourceRequest.getString("msg");
        if (TextUtils.isEmpty(paramWebView)) {
          l("code is null!!!");
        }
      }
      for (;;)
      {
        if (this.aF != null) {
          this.aF.t();
        }
        return true;
        if ("0".equals(paramWebView))
        {
          j(paramWebResourceRequest);
        }
        else
        {
          k(paramWebResourceRequest);
          continue;
          k("bundle is null!!!");
        }
      }
    }
    return false;
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("sinaweibo://browser/close")))
    {
      paramString = e.g(paramString);
      if (paramString != null)
      {
        paramWebView = paramString.getString("code");
        paramString = paramString.getString("msg");
        if ("0".equals(paramWebView)) {
          j(paramString);
        }
      }
      for (;;)
      {
        if (this.aF != null) {
          this.aF.t();
        }
        return true;
        k(paramString);
        continue;
        k("bundle is null!!!");
      }
    }
    return false;
  }
  
  public final void t()
  {
    l("cancel share!!!");
  }
  
  public final boolean v()
  {
    l("cancel share!!!");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.web.a.d
 * JD-Core Version:    0.7.0.1
 */