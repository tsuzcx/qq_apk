package com.tencent.biz.pubaccount.api.impl;

import android.os.Bundle;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.smtt.sdk.WebView;

class PublicAccountBrowserImpl$PublicAccountBrowserFragment$5
  extends WebKernelCallBackProxy
{
  PublicAccountBrowserImpl$PublicAccountBrowserFragment$5(PublicAccountBrowserImpl.PublicAccountBrowserFragment paramPublicAccountBrowserFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public boolean afterWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString)
  {
    return this.a.a(paramWebView, paramString);
  }
  
  public String getUAMark()
  {
    return "PA";
  }
  
  public void onFinalState(Bundle paramBundle)
  {
    super.onFinalState(paramBundle);
    this.a.a(paramBundle);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    if (paramInt == -8) {
      QRUtils.a(1, 2131695210);
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return this.a.a(paramWebView, paramString, this.webViewKernelCallBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl.PublicAccountBrowserFragment.5
 * JD-Core Version:    0.7.0.1
 */