package com.tencent.biz.webviewplugin;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;

class BusinessReportPlugin$1
  implements Runnable
{
  BusinessReportPlugin$1(BusinessReportPlugin paramBusinessReportPlugin, String paramString) {}
  
  public void run()
  {
    String str1 = this.a;
    String str2 = this.this$0.mRuntime.a().getUrl();
    this.this$0.postPluginAsyncTask(new BusinessReportPlugin.1.1(this, str1, str2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.BusinessReportPlugin.1
 * JD-Core Version:    0.7.0.1
 */