package com.tencent.mobileqq.activity;

import Override;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import bctj;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class UserguideActivity
  extends FragmentActivity
{
  public static boolean a;
  public static boolean b;
  private static boolean d;
  boolean c = false;
  
  public static void a()
  {
    if (b) {
      QLog.w("UserGuide", 1, "clearIsUserGuiderShowed");
    }
    b = false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return a;
  }
  
  public static boolean a(SplashActivity paramSplashActivity)
  {
    if ((AppSetting.c) || (Build.VERSION.SDK_INT < 14) || (d))
    {
      if (QLog.isColorLevel()) {
        QLog.i("UserGuide", 2, String.format("showUserGuide [%s, %s, %s]", new Object[] { Boolean.valueOf(AppSetting.c), Integer.valueOf(Build.VERSION.SDK_INT), Boolean.valueOf(d) }));
      }
      return false;
    }
    d = true;
    boolean bool2 = false;
    try
    {
      bool1 = paramSplashActivity.getIntent().getBooleanExtra("k_from_login", false);
      if (QLog.isColorLevel()) {
        QLog.i("UserGuide", 2, String.format("showUserGuide noNeedShowGuide[%s]", new Object[] { Boolean.valueOf(bool1) }));
      }
      a = false;
      if (!bool1)
      {
        Object localObject = paramSplashActivity.getSharedPreferences("UserGuide", 0);
        String str1 = ((SharedPreferences)localObject).getString("qq_version", "");
        String str2 = ((SharedPreferences)localObject).getString("qq_version_full", "");
        if (QLog.isColorLevel()) {
          QLog.e("UserGuide", 2, "pkg build num is 4680, local build num is " + str1);
        }
        if (!"4680".equals(str1))
        {
          localHashMap = new HashMap();
          if (!TextUtils.isEmpty(str1)) {
            break label424;
          }
          if (QLog.isColorLevel()) {
            QLog.e("UserGuide", 2, "this is a new install");
          }
          localHashMap.put("userguide_update_type", "2");
          bctj.a(paramSplashActivity).a(null, "userguide_update2", true, 0L, 0L, localHashMap, "", false);
          paramSplashActivity = ((SharedPreferences)localObject).edit();
          localObject = AppSetting.a();
          paramSplashActivity.putString("qq_version_pre", str1);
          paramSplashActivity.putString("qq_version_full_pre", str2);
          paramSplashActivity.putString("qq_version", "4680");
          paramSplashActivity.putString("qq_version_full", (String)localObject);
          paramSplashActivity.commit();
          if (QLog.isColorLevel()) {
            QLog.i("UserGuide", 2, String.format("update version pre[%s, %s], cur[%s, %s]", new Object[] { str1, str2, "4680", localObject }));
          }
        }
        QLog.e("UserGuide", 1, "showUserGuide " + a + ", " + str1 + ", " + "4680");
      }
      else
      {
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        HashMap localHashMap;
        boolean bool1 = bool2;
        if (QLog.isDevelopLevel())
        {
          localException.printStackTrace();
          bool1 = bool2;
          continue;
          label424:
          if (QLog.isColorLevel()) {
            QLog.e("UserGuide", 2, "this is a old install");
          }
          localHashMap.put("userguide_update_type", "1");
        }
      }
    }
  }
  
  public void b()
  {
    Intent localIntent = getIntent();
    if ((getAppRuntime() != null) && (getAppRuntime().isLogin()))
    {
      localIntent.setClass(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.b);
    }
    for (;;)
    {
      localIntent.addFlags(67108864);
      startActivity(localIntent);
      return;
      localIntent.setClass(this, LoginActivity.class);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(null);
    setContentView(null);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isDevelopLevel()) {
      QLog.d("UserGuide", 4, "UserguideActivity.doOnDestroy()");
    }
    a = false;
    this.c = true;
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
    b();
    a = false;
    super.finish();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UserguideActivity
 * JD-Core Version:    0.7.0.1
 */