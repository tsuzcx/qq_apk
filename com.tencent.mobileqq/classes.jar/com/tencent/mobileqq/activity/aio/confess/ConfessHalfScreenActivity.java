package com.tencent.mobileqq.activity.aio.confess;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ConfessHalfScreenActivity
  extends QQBrowserActivity
{
  private int jdField_a_of_type_Int = 0;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  
  public ConfessHalfScreenActivity()
  {
    this.mFragmentClass = ConfessHalfScreenActivity.ConfessBrowserFragment.class;
  }
  
  public static void a()
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.action.ACTION_CONFESS_START_EVENT");
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131167333);
    paramBundle = findViewById(2131363807);
    if (paramBundle != null) {
      paramBundle.setBackgroundResource(2131167333);
    }
    this.jdField_a_of_type_Int = getIntent().getIntExtra("confessDstHeight", 0);
    if (this.jdField_a_of_type_Int <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_QQBrowserActivity", 2, "height==0");
      }
      finish();
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ConfessHalfScreenActivity.1(this);
    }
    try
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq.action.ACTION_CONFESS_FINISH_EVENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      return bool;
    }
    catch (Exception paramBundle)
    {
      label116:
      break label116;
    }
    QLog.e("WebLog_QQBrowserActivity", 1, "register mFinishReceiver receiver exception.");
    return bool;
  }
  
  protected void doOnDestroy()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
      {
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnDestroy mFinishReceiver unregisterReceiver, e:");
        localStringBuilder.append(localException.getMessage());
        QLog.e("WebLog_QQBrowserActivity", 2, localStringBuilder.toString());
      }
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ThreadManager.executeOnSubThread(new ConfessHalfScreenActivity.2(this));
    new Handler().postDelayed(new ConfessHalfScreenActivity.3(this), 200L);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity
 * JD-Core Version:    0.7.0.1
 */