package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import cooperation.vip.webview.controller.BaseTranslucentController;
import mqq.app.AppRuntime;

public class QzoneTiantaiTranslucentBrowserActivity
  extends QQTranslucentBrowserActivity
{
  private static volatile long jdField_a_of_type_Long = 0L;
  private BaseTranslucentController jdField_a_of_type_CooperationVipWebviewControllerBaseTranslucentController;
  
  private BaseTranslucentController a()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      switch (localIntent.getIntExtra("translucent_controller", 0))
      {
      default: 
        return new BaseTranslucentController(this);
      }
      return new BaseTranslucentController(this);
    }
    return new BaseTranslucentController(this);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long > 60000L)
    {
      QLog.e("WebLog_QQBrowserActivity", 1, "  nowCallTime =" + l + "gLastLoadToolsProcessTime =" + jdField_a_of_type_Long);
      jdField_a_of_type_Long = l;
      b(paramQQAppInterface);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    QLog.i("WebLog_QQBrowserActivity", 1, "preloadToolsProcessImpl running");
    if (paramQQAppInterface == null)
    {
      if ((BaseApplicationImpl.getApplication() == null) || (BaseApplicationImpl.getApplication().getRuntime() == null)) {
        break label72;
      }
      paramQQAppInterface = (IWebProcessManagerService)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IWebProcessManagerService.class, "multi");
    }
    for (;;)
    {
      if (paramQQAppInterface != null) {
        paramQQAppInterface.startWebProcess(1, null);
      }
      return;
      paramQQAppInterface = (IWebProcessManagerService)paramQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
      continue;
      label72:
      paramQQAppInterface = null;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    if ((this.jdField_a_of_type_CooperationVipWebviewControllerBaseTranslucentController != null) && (this.jdField_a_of_type_CooperationVipWebviewControllerBaseTranslucentController.a())) {
      super.doOnBackPressed();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    if (this.jdField_a_of_type_CooperationVipWebviewControllerBaseTranslucentController != null) {
      this.jdField_a_of_type_CooperationVipWebviewControllerBaseTranslucentController.a();
    }
    return bool;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_CooperationVipWebviewControllerBaseTranslucentController != null) {
      this.jdField_a_of_type_CooperationVipWebviewControllerBaseTranslucentController.d();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_CooperationVipWebviewControllerBaseTranslucentController != null) {
      this.jdField_a_of_type_CooperationVipWebviewControllerBaseTranslucentController.b();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_CooperationVipWebviewControllerBaseTranslucentController != null) {
      this.jdField_a_of_type_CooperationVipWebviewControllerBaseTranslucentController.c();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_CooperationVipWebviewControllerBaseTranslucentController = a();
    super.onCreate(paramBundle);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (this.jdField_a_of_type_CooperationVipWebviewControllerBaseTranslucentController != null) {
      this.jdField_a_of_type_CooperationVipWebviewControllerBaseTranslucentController.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QzoneTiantaiTranslucentBrowserActivity
 * JD-Core Version:    0.7.0.1
 */