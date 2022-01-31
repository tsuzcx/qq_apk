package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class UserguideActivity
  extends FragmentActivity
{
  public static boolean a;
  private static boolean c;
  boolean b = false;
  
  public static boolean a(Context paramContext, String paramString)
  {
    return a;
  }
  
  public static boolean a(SplashActivity paramSplashActivity)
  {
    if ((AppSetting.b) || (Build.VERSION.SDK_INT < 14) || (c)) {}
    for (;;)
    {
      return false;
      c = true;
      try
      {
        bool = paramSplashActivity.getIntent().getBooleanExtra("k_from_login", false);
        a = false;
        if (bool) {
          continue;
        }
        SharedPreferences localSharedPreferences = paramSplashActivity.getSharedPreferences("UserGuide", 0);
        String str = localSharedPreferences.getString("qq_version", null);
        if (QLog.isColorLevel()) {
          QLog.e("UserGuide", 2, "pkg build num is 3560, local build num is " + str);
        }
        if (!"3560".equals(str))
        {
          localHashMap = new HashMap();
          if (TextUtils.isEmpty(str))
          {
            if (QLog.isColorLevel()) {
              QLog.e("UserGuide", 2, "this is a new install");
            }
            localHashMap.put("userguide_update_type", "2");
            StatisticCollector.a(paramSplashActivity).a(null, "userguide_update2", true, 0L, 0L, localHashMap, "", false);
            paramSplashActivity = localSharedPreferences.edit();
            paramSplashActivity.putString("qq_version", "3560");
            paramSplashActivity.commit();
          }
        }
        else
        {
          QLog.e("UserGuide", 1, "showUserGuide " + a + ", " + str + ", " + "3560");
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          HashMap localHashMap;
          if (QLog.isDevelopLevel()) {
            localException.printStackTrace();
          }
          boolean bool = false;
          continue;
          if (QLog.isColorLevel()) {
            QLog.e("UserGuide", 2, "this is a old install");
          }
          localHashMap.put("userguide_update_type", "1");
        }
      }
    }
  }
  
  public void a()
  {
    Intent localIntent = getIntent();
    if ((getAppRuntime() != null) && (getAppRuntime().isLogin()))
    {
      localIntent.setClass(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.a);
    }
    for (;;)
    {
      localIntent.addFlags(67108864);
      startActivity(localIntent);
      return;
      localIntent.setClass(this, LoginActivity.class);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(null);
    setContentView(null);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isDevelopLevel()) {
      QLog.d("UserGuide", 4, "UserguideActivity.doOnDestroy()");
    }
    a = false;
    this.b = true;
    System.gc();
  }
  
  public void finish()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("UserGuide", 4, "UserguideActivity.finish()");
    }
    if (isFinishing()) {
      return;
    }
    a();
    a = false;
    super.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UserguideActivity
 * JD-Core Version:    0.7.0.1
 */