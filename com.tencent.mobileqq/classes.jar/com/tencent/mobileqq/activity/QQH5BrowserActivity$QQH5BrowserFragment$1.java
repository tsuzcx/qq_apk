package com.tencent.mobileqq.activity;

import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;

class QQH5BrowserActivity$QQH5BrowserFragment$1
  extends WebKernelCallBackProxy
{
  QQH5BrowserActivity$QQH5BrowserFragment$1(QQH5BrowserActivity.QQH5BrowserFragment paramQQH5BrowserFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public void onFinalState(Bundle paramBundle)
  {
    super.onFinalState(paramBundle);
    QQH5BrowserActivity.QQH5BrowserFragment.a(this.a, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQH5BrowserActivity.QQH5BrowserFragment.1
 * JD-Core Version:    0.7.0.1
 */