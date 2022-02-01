package com.tencent.biz.webviewbase;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.injector.IAbsBaseWebViewActivityInjector;
import com.tencent.mobileqq.webview.swift.utils.BaseOpenWebMonitor;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.HitTestResult;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.sonic.sdk.SonicSession;
import java.util.HashMap;
import java.util.Map;

class AbsBaseWebViewActivity$WebViewClientImpl
  extends WebViewClient
{
  private ArrayMap<String, Object> a;
  
  private AbsBaseWebViewActivity$WebViewClientImpl(AbsBaseWebViewActivity paramAbsBaseWebViewActivity) {}
  
  private String a(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.startsWith("https://jsbridge/")) {
        return paramString.replace("https://jsbridge/", "jsbridge://");
      }
      str = paramString;
      if (paramString.startsWith("http://jsbridge/")) {
        str = paramString.replace("http://jsbridge/", "jsbridge://");
      }
    }
    return str;
  }
  
  private void b(WebView paramWebView, String paramString)
  {
    paramString = Uri.parse(paramString);
    String str = paramString.getScheme();
    if ((this.b.isResume()) && ((System.currentTimeMillis() - this.b.mLastTouchTime < 1000L) || (this.b.authConfig.d(paramWebView.getUrl(), str).booleanValue())))
    {
      paramWebView = new Intent("android.intent.action.VIEW", paramString);
      paramWebView.addFlags(268435456);
    }
    try
    {
      this.b.startActivity(paramWebView);
      return;
    }
    catch (ActivityNotFoundException paramWebView) {}
  }
  
  protected WebResourceResponse a(WebView paramWebView, String paramString)
  {
    if ((AbsBaseWebViewActivity.access$000(this.b) != null) && (AbsBaseWebViewActivity.access$000(this.b).a(paramString))) {
      return AbsBaseWebViewActivity.access$000(this.b).b(paramString);
    }
    WebViewPluginEngine localWebViewPluginEngine = ((CustomWebView)paramWebView).getPluginEngine();
    Object localObject2 = null;
    StringBuilder localStringBuilder = null;
    if (localWebViewPluginEngine == null) {
      return null;
    }
    Object localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.startsWith("https://jsbridge/"))
      {
        paramWebView = paramString.replace("https://jsbridge/", "jsbridge://");
      }
      else
      {
        paramWebView = paramString;
        if (paramString.startsWith("http://jsbridge/")) {
          paramWebView = paramString.replace("http://jsbridge/", "jsbridge://");
        }
      }
      localObject1 = paramWebView;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("doInterceptRequest: jsapi request with http(s), url = ");
        paramString.append(paramWebView);
        QLog.d("WebLog_WebViewBase", 2, paramString.toString());
        localObject1 = paramWebView;
      }
    }
    else
    {
      localObject1 = paramString;
      if (QLog.isColorLevel())
      {
        paramWebView = new StringBuilder();
        paramWebView.append("doInterceptRequest: default request, url = ");
        paramWebView.append(paramString);
        QLog.d("WebLog_WebViewBase", 2, paramWebView.toString());
        localObject1 = paramString;
      }
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).startsWith("jsbridge:")))
    {
      this.b.mHandler.post(new AbsBaseWebViewActivity.WebViewClientImpl.1(this, localWebViewPluginEngine, (String)localObject1));
      localObject1 = new WebResourceResponse("text/html", "utf-8", null);
      paramString = ((WebResourceResponse)localObject1).getResponseHeaders();
      paramWebView = paramString;
      if (paramString == null) {
        paramWebView = new HashMap();
      }
      paramWebView.put("cache-control", "must-revalidate，no-store");
      ((WebResourceResponse)localObject1).setResponseHeaders(paramWebView);
      return localObject1;
    }
    for (;;)
    {
      try
      {
        if (this.b.sonicClient == null) {
          break label436;
        }
        paramString = this.b.sonicClient.getSession().onClientRequestResource((String)localObject1);
        paramWebView = localObject2;
        if (!(paramString instanceof WebResourceResponse)) {
          break label383;
        }
        paramWebView = (WebResourceResponse)paramString;
        try
        {
          QLog.i("WebLog_WebViewBase", 1, "doInterceptRequest: resource intercept by sonic.");
        }
        catch (Exception paramString) {}
        localStringBuilder = new StringBuilder();
      }
      catch (Exception paramString)
      {
        paramWebView = localStringBuilder;
      }
      localStringBuilder.append("shouldInterceptRequest:resource intercept by sonic error -> ");
      localStringBuilder.append(paramString.getMessage());
      QLog.e("WebLog_WebViewBase", 1, localStringBuilder.toString());
      label383:
      if (paramWebView == null) {
        try
        {
          paramString = localWebViewPluginEngine.a((String)localObject1, 8L);
          if ((paramString instanceof WebResourceResponse))
          {
            paramString = (WebResourceResponse)paramString;
            return paramString;
          }
        }
        catch (Exception paramString)
        {
          QLog.e("WebLog_WebViewBase", 1, new Object[] { "shouldInterceptRequest error:!", paramString.getMessage() });
        }
      }
      return paramWebView;
      label436:
      paramString = null;
    }
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDetectedBlankScreen, status: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", url:");
    localStringBuilder.append(paramString);
    QLog.i("WebLog_WebViewBase", 1, localStringBuilder.toString());
    this.b.mStatistics.a(paramString, paramInt);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if ((!this.b.isDestroyed) && (!this.b.isFinishing()))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPageFinished:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("WebLog_WebViewBase", 1, ((StringBuilder)localObject).toString());
      super.onPageFinished(paramWebView, paramString);
      this.b.onPageFinished(paramWebView, paramString);
      if (this.b.sonicClient != null) {
        this.b.sonicClient.getSession().onClientPageFinished(paramString);
      }
      localObject = ((CustomWebView)paramWebView).getPluginEngine();
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).a(paramString, 8589934594L, null);
      }
      if ((Build.VERSION.SDK_INT >= 19) && (!this.b.isDestroyed) && (this.b.mChromeClient != null))
      {
        paramString = paramWebView.getTitle();
        this.b.mChromeClient.onReceivedTitle(paramWebView, paramString);
      }
      BaseOpenWebMonitor.b(this.b.getIntent());
      return;
    }
    QLog.e("WebLog_WebViewBase", 1, "call onPageFinished after destroy.");
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    if ((!this.b.isDestroyed) && (!this.b.isFinishing()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageStarted:");
      localStringBuilder.append(paramString);
      QLog.d("WebLog_WebViewBase", 1, localStringBuilder.toString());
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      this.b.onPageStarted(paramWebView, paramString, paramBitmap);
      paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
      if (paramWebView != null) {
        paramWebView.a(paramString, 8589934593L, null);
      }
    }
    else
    {
      QLog.e("WebLog_WebViewBase", 1, "call onPageStarted after destroy.");
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((!this.b.isDestroyed) && (!this.b.isFinishing()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceivedError:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", desc=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", url=");
      localStringBuilder.append(paramString2);
      QLog.e("WebLog_WebViewBase", 1, localStringBuilder.toString());
      this.b.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
      if (paramWebView != null) {
        paramWebView.a(paramString2, 8589934595L, paramInt);
      }
    }
    else
    {
      QLog.e("WebLog_WebViewBase", 1, "call onReceivedError after destroy.");
    }
  }
  
  public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    if ((!this.b.isDestroyed) && (!this.b.isFinishing()))
    {
      if ((paramWebView != null) && (paramWebResourceRequest != null) && (paramWebResourceResponse != null))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onReceivedHttpError:");
        ((StringBuilder)localObject).append(paramWebResourceRequest.getUrl());
        ((StringBuilder)localObject).append("Occur error, resp code=");
        ((StringBuilder)localObject).append(paramWebResourceResponse.getStatusCode());
        QLog.e("WebLog_WebViewBase", 1, ((StringBuilder)localObject).toString());
        localObject = paramWebView.getUrl();
        if ((localObject != null) && (AuthorizeConfig.a().a((String)localObject)))
        {
          paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
          if (paramWebView != null)
          {
            if (this.a == null) {
              this.a = new ArrayMap(4);
            }
            this.a.put("requestData", paramWebResourceRequest);
            this.a.put("responseData", paramWebResourceResponse);
            this.a.put("errorCode", Integer.valueOf(paramWebResourceResponse.getStatusCode()));
            paramWebView.a((String)localObject, 64L, this.a);
          }
        }
      }
    }
    else {
      QLog.e("WebLog_WebViewBase", 1, "call onReceivedHttpError after destroy.");
    }
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if ((!this.b.isDestroyed) && (!this.b.isFinishing()))
    {
      SslCertificate localSslCertificate = paramSslError.getCertificate();
      String str = paramWebView.getUrl();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceivedSslError:");
      localStringBuilder.append(paramSslError.getPrimaryError());
      localStringBuilder.append(", cert=");
      if (localSslCertificate == null) {
        paramWebView = "null";
      } else {
        paramWebView = localSslCertificate.toString();
      }
      localStringBuilder.append(paramWebView);
      localStringBuilder.append(", pageUrl=");
      localStringBuilder.append(Util.b(str, new String[0]));
      QLog.e("WebLog_WebViewBase", 1, localStringBuilder.toString());
      paramSslErrorHandler.cancel();
      return;
    }
    QLog.e("WebLog_WebViewBase", 1, "call onReceivedSslError after destroy.");
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((!this.b.isDestroyed) && (!this.b.isFinishing()))
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("shouldOverrideUrlLoading:");
        ((StringBuilder)localObject1).append(Util.b(paramString, new String[0]));
        QLog.d("WebLog_WebViewBase", 2, ((StringBuilder)localObject1).toString());
      }
      paramString = a(paramString);
      BaseOpenWebMonitor.b(this.b.getIntent(), paramString);
      if ((!TextUtils.isEmpty(paramString)) && (!"about:blank;".equals(paramString)))
      {
        if ("about:blank".equals(paramString)) {
          return true;
        }
        localObject1 = SwiftWebViewUtils.b(paramString);
        if ((("http".equals(localObject1)) || ("data".equals(localObject1))) && (!paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
          CustomWebView.addContextLog(Util.b(paramString, new String[0]));
        }
        try
        {
          boolean bool = "http".equals(localObject1);
          if ((bool) || ("https".equals(localObject1)))
          {
            localObject2 = paramWebView.getHitTestResult();
            if ((localObject2 != null) && (((WebView.HitTestResult)localObject2).getType() == 0))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("shouldOverrideUrlLoading detect 302, url: ");
              ((StringBuilder)localObject2).append(paramString);
              QLog.i("WebLog_WebViewBase", 1, ((StringBuilder)localObject2).toString());
              this.b.mRedirect302Url = paramString;
              SwiftBrowserCookieMonster.d();
              this.b.mStatistics.e(paramString);
            }
          }
          Object localObject2 = ((CustomWebView)paramWebView).getPluginEngine();
          if ((localObject2 != null) && (((WebViewPluginEngine)localObject2).a(paramString))) {
            return true;
          }
          if (this.b.shouldOverrideUrlLoading(paramWebView, paramString)) {
            return true;
          }
          if ((!"http".equals(localObject1)) && (!"https".equals(localObject1)) && (!"data".equals(localObject1)) && (!"file".equals(localObject1)))
          {
            b(paramWebView, paramString);
            return true;
          }
          if (localObject2 != null)
          {
            bool = ((WebViewPluginEngine)localObject2).a(paramString, 16L, null);
            if (bool) {
              return true;
            }
          }
          return false;
        }
        catch (RuntimeException paramWebView)
        {
          paramString = QLog.getStackTraceString(paramWebView);
          if (paramString.length() > 255) {
            paramWebView = paramString.substring(0, 255);
          } else {
            paramWebView = paramString;
          }
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "webview", "exception", 0, 1, 0, paramWebView, "", "", "");
          QLog.e("WebLog_WebViewBase", 1, paramString);
        }
      }
      return true;
    }
    QLog.e("WebLog_WebViewBase", 1, "call shouldOverrideUrlLoading after destroy.");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewbase.AbsBaseWebViewActivity.WebViewClientImpl
 * JD-Core Version:    0.7.0.1
 */