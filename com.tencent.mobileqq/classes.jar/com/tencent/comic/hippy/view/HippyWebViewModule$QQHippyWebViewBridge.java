package com.tencent.comic.hippy.view;

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
    QQHippyWebView localQQHippyWebView = this.mHippyView;
    if (localQQHippyWebView != null) {
      localQQHippyWebView.postMessage(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.hippy.view.HippyWebViewModule.QQHippyWebViewBridge
 * JD-Core Version:    0.7.0.1
 */