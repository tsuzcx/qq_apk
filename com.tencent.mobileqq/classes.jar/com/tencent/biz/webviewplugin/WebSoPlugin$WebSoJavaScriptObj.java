package com.tencent.biz.webviewplugin;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState.WebSo3;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.qphone.base.util.QLog;

public class WebSoPlugin$WebSoJavaScriptObj
{
  private CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
  public volatile String a;
  public volatile boolean a;
  
  public WebSoPlugin$WebSoJavaScriptObj(WebSoPlugin paramWebSoPlugin, CustomWebView paramCustomWebView)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
  }
  
  private void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("WebSoJavaScriptObj doCallback body: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.i("WebSoPlugin", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("window._websoPageData=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("; if(window.silentCallback) {window.silentCallback(");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" );}");
      ((CustomWebView)localObject).callJs(localStringBuilder.toString());
      this.jdField_a_of_type_JavaLangString = null;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WebSoJavaScriptObj onDataLoaded: ");
      localStringBuilder.append(paramString);
      QLog.i("WebSoPlugin", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      a();
    }
  }
  
  @JavascriptInterface
  public void catchHtml(String paramString)
  {
    paramString = WebSoUtils.g(paramString);
    WebSoUtils.a("catchHtml");
    WebSoService.WebSoState.WebSo3 localWebSo3 = WebSoPlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin).a();
    if (localWebSo3 != null)
    {
      WebSoService.a(paramString, localWebSo3.jdField_a_of_type_JavaLangString, localWebSo3.b, Uri.parse(localWebSo3.d));
      return;
    }
    WebSoUtils.a("return webSo3 == null");
  }
  
  @JavascriptInterface
  public void didDOMContentLoaded()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebSoPlugin", 2, "WebSoJavaScriptObj didDOMContentLoaded.");
    }
    this.jdField_a_of_type_Boolean = true;
    a();
  }
  
  @JavascriptInterface
  public void didEventFiredWithParams(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WebSoJavaScriptObj didEventFiredWithParams, envent: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" param: ");
      localStringBuilder.append(paramString2);
      QLog.i("WebSoPlugin", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.WebSoPlugin.WebSoJavaScriptObj
 * JD-Core Version:    0.7.0.1
 */