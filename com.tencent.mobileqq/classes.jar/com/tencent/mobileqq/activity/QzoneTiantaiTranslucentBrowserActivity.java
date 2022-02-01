package com.tencent.mobileqq.activity;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import bnxi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import mqq.app.AppRuntime;

public class QzoneTiantaiTranslucentBrowserActivity
  extends QQTranslucentBrowserActivity
{
  private static volatile long jdField_a_of_type_Long;
  private bnxi jdField_a_of_type_Bnxi;
  
  private bnxi a()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      switch (localIntent.getIntExtra("translucent_controller", 0))
      {
      default: 
        return new bnxi(this);
      }
      return new bnxi(this);
    }
    return new bnxi(this);
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
    Object localObject = null;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = localObject;
      if (BaseApplicationImpl.getApplication() != null)
      {
        paramQQAppInterface = localObject;
        if (BaseApplicationImpl.getApplication().getRuntime() == null) {}
      }
    }
    for (paramQQAppInterface = (WebProcessManager)BaseApplicationImpl.getApplication().getRuntime().getManager(13);; paramQQAppInterface = (WebProcessManager)paramQQAppInterface.getManager(13))
    {
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(1);
      }
      return;
    }
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    if (this.jdField_a_of_type_Bnxi != null) {
      this.jdField_a_of_type_Bnxi.e();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    if ((this.jdField_a_of_type_Bnxi != null) && (this.jdField_a_of_type_Bnxi.a())) {
      super.doOnBackPressed();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    if (this.jdField_a_of_type_Bnxi != null) {
      this.jdField_a_of_type_Bnxi.a();
    }
    return bool;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Bnxi != null) {
      this.jdField_a_of_type_Bnxi.d();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Bnxi != null) {
      this.jdField_a_of_type_Bnxi.b();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_Bnxi != null) {
      this.jdField_a_of_type_Bnxi.c();
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
    this.jdField_a_of_type_Bnxi = a();
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QzoneTiantaiTranslucentBrowserActivity
 * JD-Core Version:    0.7.0.1
 */