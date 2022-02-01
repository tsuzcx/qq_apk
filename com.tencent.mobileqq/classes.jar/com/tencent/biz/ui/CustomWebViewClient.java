package com.tencent.biz.ui;

import android.graphics.Bitmap;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class CustomWebViewClient
  extends WebViewClient
{
  protected WebViewPluginEngine b;
  
  public CustomWebViewClient(WebViewPluginEngine paramWebViewPluginEngine)
  {
    this.b = paramWebViewPluginEngine;
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CustomWebView loadUrl url:");
      localStringBuilder.append(paramString);
      QLog.d("WEBVIEWCHECK", 2, localStringBuilder.toString());
    }
    super.onLoadResource(paramWebView, paramString);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    paramWebView = this.b;
    if (paramWebView != null) {
      paramWebView.a(paramString, 8589934594L, null);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    paramWebView = this.b;
    if (paramWebView != null) {
      paramWebView.a(paramString, 8589934593L, null);
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramWebView = new StringBuilder();
      paramWebView.append("CustomWebViewClient onReceivedError errorCode:");
      paramWebView.append(paramInt);
      paramWebView.append(", description:");
      paramWebView.append(paramString1);
      paramWebView.append(", failingUrl:");
      paramWebView.append(paramString2);
      QLog.d("WEBVIEWCHECK", 2, paramWebView.toString());
    }
    paramWebView = this.b;
    if (paramWebView != null) {
      paramWebView.a(paramString2, 8589934595L, paramInt);
    }
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    paramWebView = this.b;
    if (paramWebView != null) {
      try
      {
        paramWebView = (WebResourceResponse)paramWebView.a(paramString, 8L);
        return paramWebView;
      }
      catch (Exception paramWebView)
      {
        paramString = new StringBuilder();
        paramString.append("shouldInterceptRequest error:");
        paramString.append(paramWebView.toString());
        QLog.e("WEBVIEWCHECK", 1, paramString.toString());
      }
    }
    return null;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    paramWebView = this.b;
    if ((paramWebView != null) && (paramWebView.a(paramString))) {
      return true;
    }
    if ((paramString != null) && ((paramString.startsWith("http")) || (paramString.startsWith("data:"))) && (!paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
      CustomWebView.addContextLog(Util.b(paramString, new String[0]));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.ui.CustomWebViewClient
 * JD-Core Version:    0.7.0.1
 */