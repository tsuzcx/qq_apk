package com.huawei.secure.android.common.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

final class SafeWebView$c
  extends WebViewClient
{
  private WebViewClient O;
  private boolean P;
  
  private SafeWebView$c(SafeWebView paramSafeWebView, WebViewClient paramWebViewClient, boolean paramBoolean)
  {
    this.O = paramWebViewClient;
    this.P = paramBoolean;
  }
  
  public void doUpdateVisitedHistory(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    WebViewClient localWebViewClient = this.O;
    if (localWebViewClient != null)
    {
      localWebViewClient.doUpdateVisitedHistory(paramWebView, paramString, paramBoolean);
      return;
    }
    super.doUpdateVisitedHistory(paramWebView, paramString, paramBoolean);
  }
  
  public void onFormResubmission(WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    WebViewClient localWebViewClient = this.O;
    if (localWebViewClient != null)
    {
      localWebViewClient.onFormResubmission(paramWebView, paramMessage1, paramMessage2);
      return;
    }
    super.onFormResubmission(paramWebView, paramMessage1, paramMessage2);
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    WebViewClient localWebViewClient = this.O;
    if (localWebViewClient != null)
    {
      localWebViewClient.onLoadResource(paramWebView, paramString);
      return;
    }
    super.onLoadResource(paramWebView, paramString);
  }
  
  @TargetApi(23)
  public void onPageCommitVisible(WebView paramWebView, String paramString)
  {
    WebViewClient localWebViewClient = this.O;
    if (localWebViewClient != null)
    {
      localWebViewClient.onPageCommitVisible(paramWebView, paramString);
      return;
    }
    super.onPageCommitVisible(paramWebView, paramString);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    WebViewClient localWebViewClient = this.O;
    if (localWebViewClient != null)
    {
      localWebViewClient.onPageFinished(paramWebView, paramString);
      return;
    }
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    WebViewClient localWebViewClient = this.O;
    if ((localWebViewClient != null) && (!this.P))
    {
      localWebViewClient.onPageStarted(paramWebView, paramString, paramBitmap);
      return;
    }
    if (!this.Q.isWhiteListUrl(paramString))
    {
      this.Q.onCheckError(paramWebView, paramString);
      return;
    }
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  @TargetApi(21)
  public void onReceivedClientCertRequest(WebView paramWebView, ClientCertRequest paramClientCertRequest)
  {
    WebViewClient localWebViewClient = this.O;
    if (localWebViewClient != null)
    {
      localWebViewClient.onReceivedClientCertRequest(paramWebView, paramClientCertRequest);
      return;
    }
    super.onReceivedClientCertRequest(paramWebView, paramClientCertRequest);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    WebViewClient localWebViewClient = this.O;
    if (localWebViewClient != null)
    {
      localWebViewClient.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      return;
    }
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  @TargetApi(23)
  public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    WebViewClient localWebViewClient = this.O;
    if (localWebViewClient != null)
    {
      localWebViewClient.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
      return;
    }
    super.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
  }
  
  public void onReceivedHttpAuthRequest(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    WebViewClient localWebViewClient = this.O;
    if (localWebViewClient != null)
    {
      localWebViewClient.onReceivedHttpAuthRequest(paramWebView, paramHttpAuthHandler, paramString1, paramString2);
      return;
    }
    super.onReceivedHttpAuthRequest(paramWebView, paramHttpAuthHandler, paramString1, paramString2);
  }
  
  @TargetApi(23)
  public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    WebViewClient localWebViewClient = this.O;
    if (localWebViewClient != null)
    {
      localWebViewClient.onReceivedHttpError(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
      return;
    }
    super.onReceivedHttpError(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
  }
  
  @TargetApi(12)
  public void onReceivedLoginRequest(WebView paramWebView, String paramString1, String paramString2, String paramString3)
  {
    WebViewClient localWebViewClient = this.O;
    if (localWebViewClient != null)
    {
      localWebViewClient.onReceivedLoginRequest(paramWebView, paramString1, paramString2, paramString3);
      return;
    }
    super.onReceivedLoginRequest(paramWebView, paramString1, paramString2, paramString3);
  }
  
  @TargetApi(8)
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    WebViewClient localWebViewClient = this.O;
    if (localWebViewClient != null)
    {
      localWebViewClient.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
      return;
    }
    super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
  }
  
  @SuppressLint({"NewApi"})
  public boolean onRenderProcessGone(WebView paramWebView, RenderProcessGoneDetail paramRenderProcessGoneDetail)
  {
    WebViewClient localWebViewClient = this.O;
    if (localWebViewClient != null) {
      return localWebViewClient.onRenderProcessGone(paramWebView, paramRenderProcessGoneDetail);
    }
    return super.onRenderProcessGone(paramWebView, paramRenderProcessGoneDetail);
  }
  
  @SuppressLint({"NewApi"})
  public void onSafeBrowsingHit(WebView paramWebView, WebResourceRequest paramWebResourceRequest, int paramInt, SafeBrowsingResponse paramSafeBrowsingResponse)
  {
    WebViewClient localWebViewClient = this.O;
    if (localWebViewClient != null)
    {
      localWebViewClient.onSafeBrowsingHit(paramWebView, paramWebResourceRequest, paramInt, paramSafeBrowsingResponse);
      return;
    }
    super.onSafeBrowsingHit(paramWebView, paramWebResourceRequest, paramInt, paramSafeBrowsingResponse);
  }
  
  public void onScaleChanged(WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    WebViewClient localWebViewClient = this.O;
    if (localWebViewClient != null)
    {
      localWebViewClient.onScaleChanged(paramWebView, paramFloat1, paramFloat2);
      return;
    }
    super.onScaleChanged(paramWebView, paramFloat1, paramFloat2);
  }
  
  public void onTooManyRedirects(WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    WebViewClient localWebViewClient = this.O;
    if (localWebViewClient != null)
    {
      localWebViewClient.onTooManyRedirects(paramWebView, paramMessage1, paramMessage2);
      return;
    }
    super.onTooManyRedirects(paramWebView, paramMessage1, paramMessage2);
  }
  
  public void onUnhandledKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    WebViewClient localWebViewClient = this.O;
    if (localWebViewClient != null)
    {
      localWebViewClient.onUnhandledKeyEvent(paramWebView, paramKeyEvent);
      return;
    }
    super.onUnhandledKeyEvent(paramWebView, paramKeyEvent);
  }
  
  @TargetApi(21)
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    WebViewClient localWebViewClient = this.O;
    if (localWebViewClient != null) {
      return localWebViewClient.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
    }
    return super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
  }
  
  @TargetApi(11)
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    WebViewClient localWebViewClient = this.O;
    if (localWebViewClient != null) {
      return localWebViewClient.shouldInterceptRequest(paramWebView, paramString);
    }
    return super.shouldInterceptRequest(paramWebView, paramString);
  }
  
  public boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    WebViewClient localWebViewClient = this.O;
    if (localWebViewClient != null) {
      return localWebViewClient.shouldOverrideKeyEvent(paramWebView, paramKeyEvent);
    }
    return super.shouldOverrideKeyEvent(paramWebView, paramKeyEvent);
  }
  
  @TargetApi(24)
  public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    WebViewClient localWebViewClient = this.O;
    if (localWebViewClient != null) {
      return localWebViewClient.shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest);
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    WebViewClient localWebViewClient = this.O;
    if (localWebViewClient != null) {
      return localWebViewClient.shouldOverrideUrlLoading(paramWebView, paramString);
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.webview.SafeWebView.c
 * JD-Core Version:    0.7.0.1
 */