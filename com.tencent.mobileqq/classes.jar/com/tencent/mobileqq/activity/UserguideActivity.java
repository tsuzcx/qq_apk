package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class UserguideActivity
  extends BaseActivity
{
  public static boolean a = false;
  public static boolean b = false;
  private static boolean d = false;
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
    if ((!AppSetting.e) && (Build.VERSION.SDK_INT >= 14) && (!d))
    {
      d = true;
      boolean bool;
      try
      {
        bool = paramSplashActivity.getIntent().getBooleanExtra("k_from_login", false);
      }
      catch (Exception localException)
      {
        if (QLog.isDevelopLevel()) {
          localException.printStackTrace();
        }
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("UserGuide", 2, String.format("showUserGuide noNeedShowGuide[%s]", new Object[] { Boolean.valueOf(bool) }));
      }
      a = false;
      if (!bool)
      {
        Object localObject1 = paramSplashActivity.getSharedPreferences("UserGuide", 0);
        String str1 = ((SharedPreferences)localObject1).getString("qq_version", "");
        String str2 = ((SharedPreferences)localObject1).getString("qq_version_full", "");
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("pkg build num is 5770, local build num is ");
          ((StringBuilder)localObject2).append(str1);
          QLog.e("UserGuide", 2, ((StringBuilder)localObject2).toString());
        }
        if (!"5770".equals(str1))
        {
          localObject2 = new HashMap();
          if (TextUtils.isEmpty(str1))
          {
            if (QLog.isColorLevel()) {
              QLog.e("UserGuide", 2, "this is a new install");
            }
            ((HashMap)localObject2).put("userguide_update_type", "2");
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.e("UserGuide", 2, "this is a old install");
            }
            ((HashMap)localObject2).put("userguide_update_type", "1");
          }
          StatisticCollector.getInstance(paramSplashActivity).collectPerformance(null, "userguide_update2", true, 0L, 0L, (HashMap)localObject2, "", false);
          paramSplashActivity = ((SharedPreferences)localObject1).edit();
          localObject1 = AppSetting.b();
          paramSplashActivity.putString("qq_version_pre", str1);
          paramSplashActivity.putString("qq_version_full_pre", str2);
          paramSplashActivity.putString("qq_version", "5770");
          paramSplashActivity.putString("qq_version_full", (String)localObject1);
          paramSplashActivity.commit();
          if (QLog.isColorLevel()) {
            QLog.i("UserGuide", 2, String.format("update version pre[%s, %s], cur[%s, %s]", new Object[] { str1, str2, "5770", localObject1 }));
          }
        }
        paramSplashActivity = new StringBuilder();
        paramSplashActivity.append("showUserGuide ");
        paramSplashActivity.append(a);
        paramSplashActivity.append(", ");
        paramSplashActivity.append(str1);
        paramSplashActivity.append(", ");
        paramSplashActivity.append("5770");
        QLog.e("UserGuide", 1, paramSplashActivity.toString());
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("UserGuide", 2, String.format("showUserGuide [%s, %s, %s]", new Object[] { Boolean.valueOf(AppSetting.e), Integer.valueOf(Build.VERSION.SDK_INT), Boolean.valueOf(d) }));
    }
    return false;
  }
  
  public void b()
  {
    Intent localIntent = getIntent();
    if ((getAppRuntime() != null) && (getAppRuntime().isLogin()))
    {
      localIntent.setClass(this, SplashActivity.class);
      localIntent.putExtra("tab_index", FrameControllerUtil.a);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
      return;
    }
    localIntent.addFlags(67108864);
    RouteUtils.a(this, localIntent, "/base/login");
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UserguideActivity
 * JD-Core Version:    0.7.0.1
 */