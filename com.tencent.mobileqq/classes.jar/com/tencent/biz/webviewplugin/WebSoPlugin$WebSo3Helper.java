package com.tencent.biz.webviewplugin;

import android.text.TextUtils;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState.WebSo3;
import com.tencent.mobileqq.webview.webso.WebSoUtils;

class WebSoPlugin$WebSo3Helper
{
  private WebSoService.WebSoState.WebSo3 jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3;
  private String jdField_a_of_type_JavaLangString;
  
  private void a(WebSoPlugin paramWebSoPlugin, String paramString, WebSoService.WebSoState.WebSo3 paramWebSo3)
  {
    if ((paramWebSo3 != null) && (!TextUtils.isEmpty(paramString)))
    {
      WebSoUtils.a("callJs");
      try
      {
        paramWebSoPlugin.callJs(paramString, new String[] { this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.a() });
      }
      catch (Exception paramWebSoPlugin)
      {
        paramWebSoPlugin.printStackTrace();
      }
      this.jdField_a_of_type_JavaLangString = null;
    }
  }
  
  public WebSoService.WebSoState.WebSo3 a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3;
  }
  
  public void a()
  {
    WebSoUtils.a("clearJsCallback");
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3 = null;
  }
  
  public void a(WebSoPlugin paramWebSoPlugin, WebSoService.WebSoState.WebSo3 paramWebSo3)
  {
    WebSoUtils.a("setUpWebso3");
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3 = paramWebSo3;
    a(paramWebSoPlugin, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3);
  }
  
  public void a(WebSoPlugin paramWebSoPlugin, String paramString)
  {
    WebSoUtils.a("registerGetData");
    this.jdField_a_of_type_JavaLangString = paramString;
    a(paramWebSoPlugin, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.WebSoPlugin.WebSo3Helper
 * JD-Core Version:    0.7.0.1
 */