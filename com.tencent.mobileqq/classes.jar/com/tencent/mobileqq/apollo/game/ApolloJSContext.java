package com.tencent.mobileqq.apollo.game;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;
import yvy;
import yvz;

public class ApolloJSContext
{
  private IApolloGameInterface jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  public String a;
  
  public ApolloJSContext(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface = new ApolloGameInterfaceProxy(this, paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface.a(this);
      return;
    }
    QLog.e("ApolloJSContext", 1, "[onLoadFinish] interface null ");
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (ApolloGameTool.a(this.jdField_a_of_type_JavaLangString))
    {
      paramString2 = ApolloGameTool.b(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJSContext", 1, "[notifyJSEVent] " + paramString1 + " " + paramString2);
      }
      a(String.format("if(window.__dispatchEvent){window.__dispatchEvent(%s,'%s','%s')}", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 }), new yvz(this));
      return;
    }
    QLog.e("ApolloJSContext", 1, "[notifyJSEVent] game not running " + paramString1 + " " + paramString2);
  }
  
  public void a(WebView paramWebView)
  {
    if ((paramWebView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJSContext", 2, "register success");
      }
      this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
      if (Build.VERSION.SDK_INT > 17)
      {
        paramWebView.addJavascriptInterface(this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface, "__browserMsg");
        return;
      }
      paramWebView.evaluateJavascript("window.__browserMsg =new function(){};window.__browserMsg.send=function(data,cmd){window.location='jsbridge://apolloGame/send?p='+JSON.stringify({dataStr:data,cmd:cmd});}\n", null);
      return;
    }
    QLog.e("ApolloJSContext", 1, "[registeJSContext] failed");
  }
  
  public void a(String paramString, ValueCallback paramValueCallback)
  {
    if ((this.jdField_a_of_type_ComTencentSmttSdkWebView != null) && (!TextUtils.isEmpty(paramString)))
    {
      new Handler(Looper.getMainLooper()).post(new yvy(this, paramString, paramValueCallback));
      return;
    }
    QLog.e("ApolloJSContext", 1, "[execScript] context is null");
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface != null) && ((this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface instanceof ApolloGameInterfaceProxy))) {
      ((ApolloGameInterfaceProxy)this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface).send(paramString2, paramString1);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentSmttSdkWebView = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface != null) && ((this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface instanceof ApolloGameInterfaceProxy))) {
      ((ApolloGameInterfaceProxy)this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface).h();
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloJSContext
 * JD-Core Version:    0.7.0.1
 */