package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import bkhg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import mqq.app.AppRuntime;

public class QzoneTiantaiTranslucentBrowserActivity
  extends QQTranslucentBrowserActivity
{
  private static volatile long jdField_a_of_type_Long;
  private bkhg jdField_a_of_type_Bkhg;
  
  private bkhg a()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      switch (localIntent.getIntExtra("translucent_controller", 0))
      {
      default: 
        return new bkhg(this);
      }
      return new bkhg(this);
    }
    return new bkhg(this);
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
    if (this.jdField_a_of_type_Bkhg != null) {
      this.jdField_a_of_type_Bkhg.e();
    }
  }
  
  public void doOnBackPressed()
  {
    if ((this.jdField_a_of_type_Bkhg != null) && (this.jdField_a_of_type_Bkhg.a())) {
      super.doOnBackPressed();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    if (this.jdField_a_of_type_Bkhg != null) {
      this.jdField_a_of_type_Bkhg.a();
    }
    return bool;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Bkhg != null) {
      this.jdField_a_of_type_Bkhg.d();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Bkhg != null) {
      this.jdField_a_of_type_Bkhg.b();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_Bkhg != null) {
      this.jdField_a_of_type_Bkhg.c();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Bkhg = a();
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QzoneTiantaiTranslucentBrowserActivity
 * JD-Core Version:    0.7.0.1
 */