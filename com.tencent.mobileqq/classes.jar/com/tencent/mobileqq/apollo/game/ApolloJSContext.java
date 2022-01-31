package com.tencent.mobileqq.apollo.game;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.process.sso.CmGameObserver;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import yml;
import ymm;

public class ApolloJSContext
  implements Handler.Callback, IApolloGameInterface
{
  public Bundle a;
  private IApolloGameInterface jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface = new ApolloGameInterfaceProxy(this);
  public CmGameInitParams a;
  private CmGameObserver jdField_a_of_type_ComTencentMobileqqApolloProcessSsoCmGameObserver = new yml(this);
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  public String a;
  
  public ApolloJSContext()
  {
    Object localObject = CmGameUtil.a();
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessSsoCmGameObserver != null)) {
      ((AppInterface)localObject).addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloProcessSsoCmGameObserver);
    }
    localObject = a();
    if ((localObject != null) && (((ApolloGameView)localObject).a() != 0) && ((this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface instanceof ApolloGameInterfaceProxy))) {
      ((ApolloGameInterfaceProxy)this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface).a((ApolloGameView)localObject);
    }
  }
  
  public ApolloGameView a()
  {
    if ((ApolloGameActivity.a != null) && (ApolloGameActivity.a.get() != null)) {
      return ((ApolloGameActivity)ApolloGameActivity.a.get()).a();
    }
    return null;
  }
  
  public void a()
  {
    a(0, "sc.game_shell_pack_up.local", "{}");
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface.a();
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (ApolloGameTool.a(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJSContext", 1, "[notifyJSEVent] " + paramString1 + " " + paramString2);
      }
      a(String.format("if(window.__dispatchEvent){window.__dispatchEvent(%s,'%s','%s')}", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 }), null);
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
      ApolloGameView localApolloGameView = a();
      if ((localApolloGameView != null) && (localApolloGameView.a() != 0))
      {
        if (Build.VERSION.SDK_INT < 19) {
          break label103;
        }
        paramWebView.setLayerType(2, null);
        if (Build.VERSION.SDK_INT <= 17) {
          break label112;
        }
        paramWebView.addJavascriptInterface(this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface, "__browserMsg");
      }
      for (;;)
      {
        localApolloGameView.a(this);
        this.jdField_a_of_type_AndroidOsBundle = localApolloGameView.a();
        this.jdField_a_of_type_JavaLangString = String.valueOf(localApolloGameView.a());
        return;
        label103:
        paramWebView.setLayerType(1, null);
        break;
        label112:
        paramWebView.evaluateJavascript("window.__browserMsg =new function(){};window.__browserMsg.send=function(data,cmd){window.location='jsbridge://apolloGame/send?p='+JSON.stringify({dataStr:data,cmd:cmd});}\n", null);
      }
    }
    QLog.e("ApolloJSContext", 1, "[registeJSContext] failed");
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof CmGameInitParams)))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = ((CmGameInitParams)paramObject);
      e();
    }
  }
  
  public void a(String paramString, ValueCallback paramValueCallback)
  {
    if ((this.jdField_a_of_type_ComTencentSmttSdkWebView != null) && (!TextUtils.isEmpty(paramString)))
    {
      new Handler(Looper.getMainLooper()).post(new ymm(this, paramString, paramValueCallback));
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
    a(0, "sc.game_shell_share.local", "{}");
  }
  
  public void c() {}
  
  public void d()
  {
    a(0, "sc.game_shell_close.local", "{}");
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface.d();
    }
  }
  
  public void e()
  {
    ApolloGameView localApolloGameView = a();
    if (localApolloGameView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams == null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = localApolloGameView.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJSContext", 1, "[onLoadFinish] " + this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null) && (localApolloGameView.b)) {
        a(0, "sc.init_global_var.local", CmGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams));
      }
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentSmttSdkWebView = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface != null) && ((this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface instanceof ApolloGameInterfaceProxy))) {
      ((ApolloGameInterfaceProxy)this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface).e();
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloGameIApolloGameInterface = null;
    this.jdField_a_of_type_AndroidOsBundle = null;
    AppInterface localAppInterface = CmGameUtil.a();
    if ((localAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessSsoCmGameObserver != null)) {
      localAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloProcessSsoCmGameObserver);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloJSContext
 * JD-Core Version:    0.7.0.1
 */