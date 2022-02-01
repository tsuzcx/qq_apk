package com.tencent.mobileqq.apollo.web.api.impl;

import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

class ApolloJsPluginImpl$6
  implements Runnable
{
  ApolloJsPluginImpl$6(ApolloJsPluginImpl paramApolloJsPluginImpl, int paramInt) {}
  
  public void run()
  {
    if ((this.this$0.mRuntime != null) && (this.this$0.mRuntime.a() != null))
    {
      TouchWebView localTouchWebView = (TouchWebView)this.this$0.mRuntime.a();
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[IPC_APOLLO_DOWNLOAD_GAME] callJs: window.onGameDownloadProgress(");
        localStringBuilder.append(this.a);
        localStringBuilder.append(")");
        QLog.d("[cmshow]ApolloJsPlugin", 2, localStringBuilder.toString());
      }
      if (localTouchWebView != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("window.onGameDownloadProgress &&　window.onGameDownloadProgress(");
        localStringBuilder.append(this.a);
        localStringBuilder.append(")");
        localTouchWebView.callJs(localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl.6
 * JD-Core Version:    0.7.0.1
 */