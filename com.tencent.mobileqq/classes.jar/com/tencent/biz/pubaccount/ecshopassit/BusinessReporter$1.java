package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.biz.webviewplugin.BusinessReportPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;

final class BusinessReporter$1
  implements Runnable
{
  BusinessReporter$1(String paramString, WebViewPluginEngine paramWebViewPluginEngine) {}
  
  public void run()
  {
    
    if (BusinessReporter.a(this.jdField_a_of_type_JavaLangString))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine;
      if (localObject != null)
      {
        ((WebViewPluginEngine)localObject).a(new String[] { "JD_REPORT" });
        localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a("JD_REPORT");
        if (localObject != null) {
          ((BusinessReportPlugin)localObject).b(this.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.BusinessReporter.1
 * JD-Core Version:    0.7.0.1
 */