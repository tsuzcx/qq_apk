package com.tencent.mobileqq.apollo.api.web.impl;

import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

class ApolloJsPluginImpl$14
  implements Runnable
{
  ApolloJsPluginImpl$14(ApolloJsPluginImpl paramApolloJsPluginImpl, int paramInt) {}
  
  public void run()
  {
    if ((this.this$0.mRuntime != null) && (this.this$0.mRuntime.a() != null))
    {
      TouchWebView localTouchWebView = (TouchWebView)this.this$0.mRuntime.a();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, "[IPC_APOLLO_DOWNLOAD_GAME] callJs: window.onGameDownloadProgress(" + this.a + ")");
      }
      if (localTouchWebView != null) {
        localTouchWebView.callJs("window.onGameDownloadProgress &&　window.onGameDownloadProgress(" + this.a + ")");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl.14
 * JD-Core Version:    0.7.0.1
 */