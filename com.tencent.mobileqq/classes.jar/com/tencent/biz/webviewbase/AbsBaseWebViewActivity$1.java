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
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;

class AbsBaseWebViewActivity$1
  extends CustomWebChromeClient
{
  private View jdField_a_of_type_AndroidViewView;
  private IX5WebChromeClient.CustomViewCallback jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private int c;
  
  AbsBaseWebViewActivity$1(AbsBaseWebViewActivity paramAbsBaseWebViewActivity) {}
  
  private void a(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "show custom view called");
    }
    if (this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback != null)
    {
      paramCustomViewCallback.onCustomViewHidden();
      return;
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.getRequestedOrientation();
    this.c = (this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.getWindow().getAttributes().flags & 0x400);
    if (this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.customContainer == null)
    {
      this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.customContainer = new FrameLayout(this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity);
      this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.customContainer.setBackgroundColor(-16777216);
      ((ViewGroup)this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.getWindow().getDecorView()).addView(this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.customContainer, new ViewGroup.LayoutParams(-1, -1));
    }
    if (!this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.mUIStyle.A) {
      this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.getWindow().setFlags(1024, 1024);
    }
    this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.setRequestedOrientation(paramInt);
    this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.isVideoPlaying = true;
    this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.customContainer.addView(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback = paramCustomViewCallback;
    this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.customContainer.setVisibility(0);
  }
  
  @SuppressLint({"InflateParams"})
  public View getVideoLoadingProgressView()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity).inflate(2131563197, null);
    }
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "onGeolocationPermissionsShowPrompt:" + paramString);
    }
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.indexOf(':') == -1)
      {
        str = paramString;
        if (this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.mWebViewInstance != null)
        {
          str = paramString;
          if (this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.mWebViewInstance.getX5WebViewExtension() != null) {
            str = "https://" + paramString + "/";
          }
        }
      }
    }
    paramGeolocationPermissionsCallback.invoke(str, this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.authConfig.a(str, "publicAccount.getLocation"), false);
  }
  
  public void onHideCustomView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "hide custom view called");
    }
    if (this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setKeepScreenOn(false);
    this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.customContainer.setVisibility(8);
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback.onCustomViewHidden();
    try
    {
      this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.customContainer.removeAllViews();
      label61:
      if (!this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.mUIStyle.A) {
        this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.getWindow().setFlags(this.c, 1024);
      }
      this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.setRequestedOrientation(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback = null;
      this.jdField_b_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.isVideoPlaying = false;
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
  
  @Override
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    if (JsBridgeController.getInstance().shouldIntercept(paramWebView, paramString2, paramString1, paramJsPromptResult)) {
      return true;
    }
    return super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "onProgressChanged:" + paramInt);
    }
    this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.onProgressChanged(paramWebView, paramInt);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.onReceivedTitle(paramWebView, paramString);
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
    if (this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.mFileChooserHelper == null) {
      this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.mFileChooserHelper = new FileChooserHelper();
    }
    this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity.mFileChooserHelper.a(this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity, 0, paramValueCallback, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewbase.AbsBaseWebViewActivity.1
 * JD-Core Version:    0.7.0.1
 */