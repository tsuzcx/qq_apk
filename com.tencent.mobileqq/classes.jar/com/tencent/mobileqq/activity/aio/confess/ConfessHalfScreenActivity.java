package com.tencent.mobileqq.activity.aio.confess;

import acrx;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ConfessHalfScreenActivity
  extends QQBrowserActivity
{
  private int jdField_a_of_type_Int;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  
  public ConfessHalfScreenActivity()
  {
    this.jdField_a_of_type_JavaLangClass = ConfessHalfScreenActivity.ConfessBrowserFragment.class;
  }
  
  public static void a()
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.action.ACTION_CONFESS_START_EVENT");
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131101491);
    paramBundle = findViewById(2131297873);
    if (paramBundle != null) {
      paramBundle.setBackgroundResource(2131101491);
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
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new acrx(this);
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
      QLog.e("WebLog_QQBrowserActivity", 1, "register mFinishReceiver receiver exception.");
    }
    return bool;
  }
  
  public void doOnDestroy()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
      {
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
      super.doOnDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("WebLog_QQBrowserActivity", 2, "doOnDestroy mFinishReceiver unregisterReceiver, e:" + localException.getMessage());
        }
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ThreadManager.executeOnSubThread(new ConfessHalfScreenActivity.2(this));
    new Handler().postDelayed(new ConfessHalfScreenActivity.3(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity
 * JD-Core Version:    0.7.0.1
 */