package com.tencent.hippy.qq.view.boodo;

import android.webkit.JavascriptInterface;

class HippyWebViewModule$QQHippyWebViewBridge
{
  private QQHippyWebView mHippyView;
  
  public HippyWebViewModule$QQHippyWebViewBridge(QQHippyWebView paramQQHippyWebView)
  {
    this.mHippyView = paramQQHippyWebView;
  }
  
  @JavascriptInterface
  public void postMessage(String paramString)
  {
    if (this.mHippyView != null) {
      this.mHippyView.postMessage(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.boodo.HippyWebViewModule.QQHippyWebViewBridge
 * JD-Core Version:    0.7.0.1
 */