package com.tencent.biz.webviewplugin;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.QLog;

public class WebSoPlugin$WebSoJavaScriptObj
{
  private CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
  public volatile String a;
  
  public WebSoPlugin$WebSoJavaScriptObj(WebSoPlugin paramWebSoPlugin, CustomWebView paramCustomWebView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebSoPlugin", 2, "WebSoJavaScriptObj doCallback body: " + this.jdField_a_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    while (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.c("window._websoPageData=" + this.jdField_a_of_type_JavaLangString + "; if(window.silentCallback) {window.silentCallback(" + this.jdField_a_of_type_JavaLangString + " );}");
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebSoPlugin", 2, "WebSoJavaScriptObj onDataLoaded: " + paramString);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.WebSoPlugin.WebSoJavaScriptObj
 * JD-Core Version:    0.7.0.1
 */