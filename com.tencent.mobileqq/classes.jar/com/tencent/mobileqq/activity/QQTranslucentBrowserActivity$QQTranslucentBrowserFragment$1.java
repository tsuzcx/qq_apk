package com.tencent.mobileqq.activity;

import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;

class QQTranslucentBrowserActivity$QQTranslucentBrowserFragment$1
  extends WebKernelCallBackProxy
{
  QQTranslucentBrowserActivity$QQTranslucentBrowserFragment$1(QQTranslucentBrowserActivity.QQTranslucentBrowserFragment paramQQTranslucentBrowserFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public void onFinalState(Bundle paramBundle)
  {
    this.a.onFinalState(paramBundle, this.webViewKernelCallBack);
  }
  
  public void onInitUIContent(Bundle paramBundle)
  {
    this.a.onInitUIContent(paramBundle, this.webViewKernelCallBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment.1
 * JD-Core Version:    0.7.0.1
 */