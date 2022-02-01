package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.biz.webviewplugin.BusinessReportPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;

final class BusinessReporter$1
  implements Runnable
{
  BusinessReporter$1(String paramString, WebViewPluginEngine paramWebViewPluginEngine) {}
  
  public void run()
  {
    
    if (BusinessReporter.a(this.a))
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        ((WebViewPluginEngine)localObject).a(new String[] { "JD_REPORT" });
        localObject = this.b.b("JD_REPORT");
        if (localObject != null) {
          ((BusinessReportPlugin)localObject).b(this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.BusinessReporter.1
 * JD-Core Version:    0.7.0.1
 */