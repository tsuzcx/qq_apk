package com.tencent.biz.webviewbase;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.FileChooserHelper;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;

class AbsBaseWebViewActivity$4
  extends CustomWebChromeClient
{
  private View g;
  private IX5WebChromeClient.CustomViewCallback h;
  private View i;
  private int j;
  private int k;
  
  AbsBaseWebViewActivity$4(AbsBaseWebViewActivity paramAbsBaseWebViewActivity) {}
  
  private void a(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "show custom view called");
    }
    if (this.h != null)
    {
      paramCustomViewCallback.onCustomViewHidden();
      return;
    }
    this.j = this.f.getRequestedOrientation();
    this.k = (this.f.getWindow().getAttributes().flags & 0x400);
    if (this.f.customContainer == null)
    {
      localAbsBaseWebViewActivity = this.f;
      localAbsBaseWebViewActivity.customContainer = new FrameLayout(localAbsBaseWebViewActivity);
      this.f.customContainer.setBackgroundColor(-16777216);
      ((ViewGroup)this.f.getWindow().getDecorView()).addView(this.f.customContainer, new ViewGroup.LayoutParams(-1, -1));
    }
    if (!this.f.mUIStyle.L) {
      this.f.getWindow().setFlags(1024, 1024);
    }
    this.f.setRequestedOrientation(paramInt);
    AbsBaseWebViewActivity localAbsBaseWebViewActivity = this.f;
    localAbsBaseWebViewActivity.isVideoPlaying = true;
    localAbsBaseWebViewActivity.customContainer.addView(paramView);
    this.g = paramView;
    this.h = paramCustomViewCallback;
    this.f.customContainer.setVisibility(0);
  }
  
  @SuppressLint({"InflateParams"})
  public View getVideoLoadingProgressView()
  {
    if (this.i == null) {
      this.i = LayoutInflater.from(this.f).inflate(2131629632, null);
    }
    return this.i;
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGeolocationPermissionsShowPrompt:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("WebLog_WebViewBase", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.indexOf(':') == -1)
      {
        localObject = paramString;
        if (this.f.mWebViewInstance != null)
        {
          localObject = paramString;
          if (this.f.mWebViewInstance.getX5WebViewExtension() != null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("https://");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append("/");
            localObject = ((StringBuilder)localObject).toString();
          }
        }
      }
    }
    paramGeolocationPermissionsCallback.invoke((String)localObject, this.f.authConfig.a((String)localObject, "publicAccount.getLocation"), false);
  }
  
  public void onHideCustomView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "hide custom view called");
    }
    if (this.h == null) {
      return;
    }
    this.g.setKeepScreenOn(false);
    this.f.customContainer.setVisibility(8);
    this.h.onCustomViewHidden();
    try
    {
      this.f.customContainer.removeAllViews();
      label61:
      if (!this.f.mUIStyle.L) {
        this.f.getWindow().setFlags(this.k, 1024);
      }
      this.f.setRequestedOrientation(this.j);
      this.g = null;
      this.h = null;
      this.i = null;
      this.f.isVideoPlaying = false;
      return;
    }
    catch (Exception localException)
    {
      break label61;
    }
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return super.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onProgressChanged:");
      localStringBuilder.append(paramInt);
      QLog.d("WebLog_WebViewBase", 2, localStringBuilder.toString());
    }
    this.f.onProgressChanged(paramWebView, paramInt);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    this.f.onReceivedTitle(paramWebView, paramString);
  }
  
  public void onShowCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    a(paramView, paramInt, paramCustomViewCallback);
  }
  
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    a(paramView, 10, paramCustomViewCallback);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    if (this.f.mFileChooserHelper == null) {
      this.f.mFileChooserHelper = new FileChooserHelper();
    }
    this.f.mFileChooserHelper.a(this.f, 0, paramValueCallback, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewbase.AbsBaseWebViewActivity.4
 * JD-Core Version:    0.7.0.1
 */