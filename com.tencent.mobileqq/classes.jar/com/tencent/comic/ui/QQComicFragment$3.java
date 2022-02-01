package com.tencent.comic.ui;

import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.smtt.sdk.WebView;

class QQComicFragment$3
  extends WebKernelCallBackProxy
{
  QQComicFragment$3(QQComicFragment paramQQComicFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public String getUAMark()
  {
    return "VipComic";
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
 * Qualified Name:     com.tencent.comic.ui.QQComicFragment.3
 * JD-Core Version:    0.7.0.1
 */