package com.sina.weibo.sdk.web.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.share.ShareResultActivity;
import com.sina.weibo.sdk.web.a;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

public abstract class b
  extends WebViewClient
{
  protected com.sina.weibo.sdk.auth.b aD = com.sina.weibo.sdk.auth.b.f();
  protected Activity aE;
  protected a aF;
  protected com.sina.weibo.sdk.web.b.b aG;
  protected WbAuthListener aH;
  
  public b(Activity paramActivity, a parama, com.sina.weibo.sdk.web.b.b paramb)
  {
    this.aE = paramActivity;
    this.aF = parama;
    this.aG = paramb;
  }
  
  private void b(int paramInt, String paramString)
  {
    Bundle localBundle = this.aE.getIntent().getExtras();
    if (localBundle == null) {
      return;
    }
    Intent localIntent = new Intent(this.aE, ShareResultActivity.class);
    localIntent.setAction("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY");
    localIntent.putExtras(localBundle);
    localIntent.putExtra("_weibo_resp_errcode", paramInt);
    localIntent.putExtra("_weibo_resp_errstr", paramString);
    this.aE.startActivity(localIntent);
  }
  
  protected final void j(String paramString)
  {
    b(0, paramString);
  }
  
  protected final void k(String paramString)
  {
    b(2, paramString);
  }
  
  protected final void l(String paramString)
  {
    b(1, paramString);
  }
  
  public void m(String paramString) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  @TargetApi(23)
  public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    super.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
    paramWebView = this.aF;
    if (paramWebView != null)
    {
      paramWebResourceError.getErrorCode();
      paramWebResourceError.getDescription().toString();
      paramWebResourceRequest.getUrl().toString();
      paramWebView.s();
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return super.shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest);
  }
  
  public void t() {}
  
  public boolean v()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.web.a.b
 * JD-Core Version:    0.7.0.1
 */