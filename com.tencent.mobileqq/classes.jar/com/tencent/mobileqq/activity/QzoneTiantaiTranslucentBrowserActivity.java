package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import bkcz;
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
  private bkcz jdField_a_of_type_Bkcz;
  
  private bkcz a()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      switch (localIntent.getIntExtra("translucent_controller", 0))
      {
      default: 
        return new bkcz(this);
      }
      return new bkcz(this);
    }
    return new bkcz(this);
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
    if (this.jdField_a_of_type_Bkcz != null) {
      this.jdField_a_of_type_Bkcz.e();
    }
  }
  
  public void doOnBackPressed()
  {
    if ((this.jdField_a_of_type_Bkcz != null) && (this.jdField_a_of_type_Bkcz.a())) {
      super.doOnBackPressed();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    if (this.jdField_a_of_type_Bkcz != null) {
      this.jdField_a_of_type_Bkcz.a();
    }
    return bool;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Bkcz != null) {
      this.jdField_a_of_type_Bkcz.d();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Bkcz != null) {
      this.jdField_a_of_type_Bkcz.b();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_Bkcz != null) {
      this.jdField_a_of_type_Bkcz.c();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Bkcz = a();
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QzoneTiantaiTranslucentBrowserActivity
 * JD-Core Version:    0.7.0.1
 */