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
  private static volatile long b;
  private BaseTranslucentController a;
  
  private BaseTranslucentController a()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      if (localIntent.getIntExtra("translucent_controller", 0) != 0) {
        return new BaseTranslucentController(this);
      }
      return new BaseTranslucentController(this);
    }
    return new BaseTranslucentController(this);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    long l = System.currentTimeMillis();
    if (l - b > 60000L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("  nowCallTime =");
      localStringBuilder.append(l);
      localStringBuilder.append("gLastLoadToolsProcessTime =");
      localStringBuilder.append(b);
      QLog.e("WebLog_QQBrowserActivity", 1, localStringBuilder.toString());
      b = l;
      b(paramQQAppInterface);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    QLog.i("WebLog_QQBrowserActivity", 1, "preloadToolsProcessImpl running");
    if (paramQQAppInterface == null)
    {
      if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null)) {
        paramQQAppInterface = (IWebProcessManagerService)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IWebProcessManagerService.class, "multi");
      } else {
        paramQQAppInterface = null;
      }
    }
    else {
      paramQQAppInterface = (IWebProcessManagerService)paramQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
    }
    if (paramQQAppInterface != null) {
      paramQQAppInterface.startWebProcess(1, null);
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
    BaseTranslucentController localBaseTranslucentController = this.a;
    if ((localBaseTranslucentController != null) && (localBaseTranslucentController.f())) {
      super.doOnBackPressed();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    paramBundle = this.a;
    if (paramBundle != null) {
      paramBundle.a();
    }
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    BaseTranslucentController localBaseTranslucentController = this.a;
    if (localBaseTranslucentController != null) {
      localBaseTranslucentController.d();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    BaseTranslucentController localBaseTranslucentController = this.a;
    if (localBaseTranslucentController != null) {
      localBaseTranslucentController.b();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    BaseTranslucentController localBaseTranslucentController = this.a;
    if (localBaseTranslucentController != null) {
      localBaseTranslucentController.c();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.a = a();
    super.onCreate(paramBundle);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    paramWebView = this.a;
    if (paramWebView != null) {
      paramWebView.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QzoneTiantaiTranslucentBrowserActivity
 * JD-Core Version:    0.7.0.1
 */