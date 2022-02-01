package com.tencent.comic.webbundle;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.smtt.sdk.WebView;
import com.tencent.webbundle.sdk.WebBundleClient;

class WebBundleFragment$1
  extends WebKernelCallBackProxy
{
  WebBundleFragment$1(WebBundleFragment paramWebBundleFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public String getUAMark()
  {
    return "VipComic";
  }
  
  public boolean interceptStartLoadUrl()
  {
    if (((WebBundleFragment.a(this.a) == null) || (!WebBundleFragment.a(this.a).interceptLoadUrl(WebBundleFragment.b(this.a)))) && (!TextUtils.isEmpty(WebBundleFragment.c(this.a)))) {
      WebBundleFragment.e(this.a).loadUrl(WebBundleFragment.d(this.a));
    }
    return true;
  }
  
  public void onDataInit(Bundle paramBundle)
  {
    Object localObject = this.a;
    WebBundleFragment.a((WebBundleFragment)localObject, WebBundleFragment.f((WebBundleFragment)localObject).getStringExtra("real_url"));
    localObject = this.a;
    WebBundleFragment.b((WebBundleFragment)localObject, WebBundleFragment.g((WebBundleFragment)localObject).getStringExtra("preload_url"));
    localObject = WebBundleFragment.h(this.a).getStringExtra("bundle_data");
    if ((!TextUtils.isEmpty(WebBundleFragment.i(this.a))) && (!TextUtils.isEmpty(WebBundleFragment.j(this.a))) && (!TextUtils.isEmpty((CharSequence)localObject))) {
      WebBundleFragment.a(this.a, new WebBundleClient("comic"));
    }
    super.onDataInit(paramBundle);
  }
  
  public void onFinalState(Bundle paramBundle)
  {
    this.a.a(paramBundle, this.webViewKernelCallBack);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    this.a.a(paramWebView, paramString, this.webViewKernelCallBack);
  }
  
  public void onWebViewInit(Bundle paramBundle, TouchWebView paramTouchWebView)
  {
    this.a.a(paramBundle, paramTouchWebView, this.webViewKernelCallBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.webbundle.WebBundleFragment.1
 * JD-Core Version:    0.7.0.1
 */