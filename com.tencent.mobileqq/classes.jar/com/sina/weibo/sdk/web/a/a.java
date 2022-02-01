package com.sina.weibo.sdk.web.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.c.e;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.web.WebData;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

public final class a
  extends b
{
  public a(Activity paramActivity, com.sina.weibo.sdk.web.a parama, com.sina.weibo.sdk.web.b.b paramb)
  {
    super(paramActivity, parama, paramb);
  }
  
  private boolean i(String paramString)
  {
    AuthInfo localAuthInfo = this.aG.x().a();
    if ((localAuthInfo != null) && (paramString.startsWith(localAuthInfo.getRedirectUrl())))
    {
      paramString = e.f(paramString);
      if ((paramString != null) && (!TextUtils.isEmpty(paramString.getString("access_token")))) {
        return true;
      }
    }
    return false;
  }
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    paramWebView = this.aG.x().a();
    if ((paramWebView != null) && (paramString.startsWith(paramWebView.getRedirectUrl())))
    {
      paramWebView = this.aG.x().u();
      if (!TextUtils.isEmpty(paramWebView))
      {
        this.aH = this.aD.a(paramWebView);
        if (this.aH != null)
        {
          paramString = e.f(paramString);
          if (paramString != null)
          {
            String str1 = paramString.getString("error");
            String str2 = paramString.getString("error_code");
            String str3 = paramString.getString("error_description");
            if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)))
            {
              paramString = Oauth2AccessToken.parseAccessToken(paramString);
              AccessTokenHelper.writeAccessToken(this.aE, paramString);
              this.aH.onComplete(paramString);
            }
            else
            {
              this.aH.onError(new UiError(-1, str2, str3));
            }
          }
          else
          {
            this.aH.onError(new UiError(-1, "bundle is null", "parse url error"));
          }
          this.aD.b(paramWebView);
        }
      }
      if (this.aF != null) {
        this.aF.t();
      }
    }
  }
  
  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return i(paramWebResourceRequest.getUrl().toString());
    }
    return false;
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return i(paramString);
  }
  
  public final void t()
  {
    super.t();
    String str = this.aG.x().u();
    if (!TextUtils.isEmpty(str))
    {
      this.aH = this.aD.a(str);
      if (this.aH != null) {
        this.aH.onCancel();
      }
      this.aD.b(str);
    }
    if (this.aF != null) {
      this.aF.t();
    }
  }
  
  public final boolean v()
  {
    t();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.web.a.a
 * JD-Core Version:    0.7.0.1
 */