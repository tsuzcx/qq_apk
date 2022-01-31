package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import nfo;
import xaz;

public final class BusinessReporter$1
  implements Runnable
{
  public BusinessReporter$1(String paramString, WebViewPluginEngine paramWebViewPluginEngine) {}
  
  public void run()
  {
    
    if ((nfo.a(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(new String[] { "JD_REPORT" });
      WebViewPlugin localWebViewPlugin = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a("JD_REPORT");
      if (localWebViewPlugin != null) {
        ((xaz)localWebViewPlugin).b(this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.BusinessReporter.1
 * JD-Core Version:    0.7.0.1
 */