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
  protected WebViewPluginEngine a;
  
  public CustomWebViewClient(WebViewPluginEngine paramWebViewPluginEngine)
  {
    this.a = paramWebViewPluginEngine;
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WEBVIEWCHECK", 2, "CustomWebView loadUrl url:" + paramString);
    }
    super.onLoadResource(paramWebView, paramString);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (this.a != null) {
      this.a.a(paramString, 8589934594L, null);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    if (this.a != null) {
      this.a.a(paramString, 8589934593L, null);
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WEBVIEWCHECK", 2, "CustomWebViewClient onReceivedError errorCode:" + paramInt + ", description:" + paramString1 + ", failingUrl:" + paramString2);
    }
    if (this.a != null) {
      this.a.a(paramString2, 8589934595L, paramInt);
    }
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    if (this.a != null) {
      try
      {
        paramWebView = (WebResourceResponse)this.a.a(paramString, 8L);
        return paramWebView;
      }
      catch (Exception paramWebView)
      {
        QLog.e("WEBVIEWCHECK", 1, "shouldInterceptRequest error:" + paramWebView.toString());
      }
    }
    return null;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.a != null) && (this.a.a(paramString))) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramString == null);
        if (paramString.startsWith("http")) {
          break;
        }
        bool1 = bool2;
      } while (!paramString.startsWith("data:"));
      bool1 = bool2;
    } while (paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"));
    CustomWebView.addContextLog(Util.b(paramString, new String[0]));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.ui.CustomWebViewClient
 * JD-Core Version:    0.7.0.1
 */