package com.tencent.biz.webviewplugin;

import android.text.TextUtils;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState.WebSo3;
import com.tencent.mobileqq.webview.webso.WebSoUtils;

class WebSoPlugin$WebSo3Helper
{
  private WebSoService.WebSoState.WebSo3 a;
  private String b;
  
  private void a(WebSoPlugin paramWebSoPlugin, String paramString, WebSoService.WebSoState.WebSo3 paramWebSo3)
  {
    if ((paramWebSo3 != null) && (!TextUtils.isEmpty(paramString)))
    {
      WebSoUtils.m("callJs");
      try
      {
        paramWebSoPlugin.callJs(paramString, new String[] { this.a.b() });
      }
      catch (Exception paramWebSoPlugin)
      {
        paramWebSoPlugin.printStackTrace();
      }
      this.b = null;
    }
  }
  
  public void a()
  {
    WebSoUtils.m("clearJsCallback");
    this.b = null;
    this.a = null;
  }
  
  public void a(WebSoPlugin paramWebSoPlugin, WebSoService.WebSoState.WebSo3 paramWebSo3)
  {
    WebSoUtils.m("setUpWebso3");
    this.a = paramWebSo3;
    a(paramWebSoPlugin, this.b, this.a);
  }
  
  public void a(WebSoPlugin paramWebSoPlugin, String paramString)
  {
    WebSoUtils.m("registerGetData");
    this.b = paramString;
    a(paramWebSoPlugin, this.b, this.a);
  }
  
  public WebSoService.WebSoState.WebSo3 b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.WebSoPlugin.WebSo3Helper
 * JD-Core Version:    0.7.0.1
 */