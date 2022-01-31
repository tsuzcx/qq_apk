package com.tencent.mobileqq.activity;

import aivm;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.provider.Settings.System;
import android.view.Window;
import azri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class QQLSUnlockActivity
  extends Activity
  implements Handler.Callback
{
  static int jdField_a_of_type_Int = 30000;
  Handler jdField_a_of_type_AndroidOsHandler;
  
  private int a()
  {
    int j = 10000;
    try
    {
      i = Settings.System.getInt(getContentResolver(), "screen_off_timeout");
      if (QLog.isDevelopLevel()) {
        QLog.d("QQLSActivity", 4, "getScreenOffTime " + i);
      }
      j = i;
      if (i > jdField_a_of_type_Int) {
        j = jdField_a_of_type_Int;
      }
      return j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = j;
        if (QLog.isDevelopLevel())
        {
          QLog.d("QQLSActivity", 4, "getScreenOffTime e=" + localException.getMessage());
          i = j;
        }
      }
    }
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("LSUnlockActivity", 2, "QQLSUnlockActivity finish");
      }
      finish();
    }
  }
  
  public void onBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LSUnlockActivity", 2, "onBackPressed ");
    }
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
    for (;;)
    {
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
          aivm.a((QQAppInterface)paramBundle, false);
        }
      }
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        getWindow().addFlags(4194304);
      } else {
        getWindow().addFlags(4718592);
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
    azri.a(this).c(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    azri.a(this).b(this);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LSUnlockActivity", 2, "onSaveInstanceState ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSUnlockActivity
 * JD-Core Version:    0.7.0.1
 */