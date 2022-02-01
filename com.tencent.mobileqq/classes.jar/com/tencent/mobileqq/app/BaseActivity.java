package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

@Deprecated
public class BaseActivity
  extends QBaseActivity
{
  public static final String TAG = "qqBaseActivity";
  public static BaseActivity sTopActivity;
  public QQAppInterface app;
  private String className = getClass().getSimpleName();
  
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
    super.doOnBackPressed();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    return super.doOnCreate(paramBundle);
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (sTopActivity == this) {
      sTopActivity = null;
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  @TargetApi(9)
  public void doOnResume()
  {
    super.doOnResume();
    sTopActivity = this;
  }
  
  public void doOnStart()
  {
    super.doOnStart();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
  }
  
  public String getActivityName()
  {
    return this.className;
  }
  
  public AppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof AppInterface)) {
      return (AppInterface)localAppRuntime;
    }
    return null;
  }
  
  public String getCurrentAccountUin()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if (localAppRuntime == null) {
      return "";
    }
    if ((localAppRuntime instanceof AppInterface)) {
      return ((AppInterface)localAppRuntime).getCurrentAccountUin();
    }
    return localAppRuntime.getAccount();
  }
  
  public String getPreProcess()
  {
    return null;
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299166);
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onAccountChanged ");
      if (getAppRuntime() != null) {
        break label51;
      }
    }
    label51:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("qqBaseActivity", 2, bool);
      updateAppRuntime();
      return;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void updateAppRuntime()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      this.app = ((QQAppInterface)localAppRuntime);
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 4, "updateAppRuntime, " + localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity
 * JD-Core Version:    0.7.0.1
 */