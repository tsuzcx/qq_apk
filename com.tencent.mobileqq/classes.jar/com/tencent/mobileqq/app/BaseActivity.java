package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import androidx.fragment.app.FragmentManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatFragment;
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
  QBaseFragment.IFragmentAttachCallback mIFragmentAttachCallback;
  
  protected void beforeDoOnCreate()
  {
    super.beforeDoOnCreate();
    updateAppRuntime();
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
    super.doOnBackPressed();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    return super.doOnCreate(paramBundle);
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (sTopActivity == this) {
      sTopActivity = null;
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  @TargetApi(9)
  protected void doOnResume()
  {
    super.doOnResume();
    sTopActivity = this;
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
  }
  
  protected void doOnStop()
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
  
  @Nullable
  public ChatFragment getChatFragment()
  {
    QBaseFragment localQBaseFragment = (QBaseFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localQBaseFragment != null) {
      return (ChatFragment)localQBaseFragment;
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
    return getResources().getDimensionPixelSize(2131299168);
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAccountChanged ");
      boolean bool;
      if (getAppRuntime() == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("qqBaseActivity", 2, localStringBuilder.toString());
    }
    updateAppRuntime();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void setFragmentAttachListener(QBaseFragment.IFragmentAttachCallback paramIFragmentAttachCallback)
  {
    this.mIFragmentAttachCallback = paramIFragmentAttachCallback;
  }
  
  public void updateAppRuntime()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      this.app = ((QQAppInterface)localAppRuntime);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateAppRuntime, ");
      localStringBuilder.append(localAppRuntime);
      QLog.i("qqBaseActivity", 4, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity
 * JD-Core Version:    0.7.0.1
 */