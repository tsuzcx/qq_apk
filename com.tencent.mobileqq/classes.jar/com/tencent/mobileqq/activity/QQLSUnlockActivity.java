package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.provider.Settings.System;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPayApi;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.monitor.crash.tools.ActivityLifeCycleInfoRecordHelper;
import com.tencent.widget.immersive.ImmersiveUtils;

public class QQLSUnlockActivity
  extends Activity
  implements Handler.Callback
{
  static int jdField_a_of_type_Int = 30000;
  Handler jdField_a_of_type_AndroidOsHandler;
  
  private int a()
  {
    int i;
    try
    {
      i = Settings.System.getInt(getContentResolver(), "screen_off_timeout");
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getScreenOffTime e=");
        localStringBuilder2.append(localException.getMessage());
        QLog.d("QQLSActivity", 4, localStringBuilder2.toString());
      }
      i = 10000;
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("getScreenOffTime ");
      localStringBuilder1.append(i);
      QLog.d("QQLSActivity", 4, localStringBuilder1.toString());
    }
    int j = jdField_a_of_type_Int;
    if (i > j) {
      return j;
    }
    return i;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LSUnlockActivity", 2, "QQLSUnlockActivity finish");
      }
      finish();
    }
    return false;
  }
  
  public void onBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LSUnlockActivity", 2, "onBackPressed ");
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
    BaseApplicationImpl.getApplication().addOtherTypeActivity(this);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramBundle = (KeyguardManager)getSystemService("keyguard");
      if (paramBundle != null) {
        paramBundle.requestDismissKeyguard(this, null);
      }
    }
    else if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().addFlags(4194304);
    }
    else
    {
      getWindow().addFlags(4718592);
    }
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      getWindow().addFlags(67108864);
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "enter QQLSUnlockActivity");
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) {
      ((PowerManager)getSystemService("power")).newWakeLock(268435462, "test").acquire(a());
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 1500L);
    if (getIntent().getBooleanExtra("key_wallet_unlock", false))
    {
      QQNotificationManager.getInstance().cancel("QQLSActivity", 238);
      paramBundle = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramBundle instanceof QQAppInterface)) {
        ((IQWalletPayApi)QRoute.api(IQWalletPayApi.class)).onQQForeground((QQAppInterface)paramBundle, false);
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    BaseApplicationImpl.getApplication().removeOtherTypeActivity(this);
  }
  
  protected void onPause()
  {
    super.onPause();
    ActivityLifeCycleInfoRecordHelper.c(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    ActivityLifeCycleInfoRecordHelper.b(this);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LSUnlockActivity", 2, "onSaveInstanceState ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSUnlockActivity
 * JD-Core Version:    0.7.0.1
 */