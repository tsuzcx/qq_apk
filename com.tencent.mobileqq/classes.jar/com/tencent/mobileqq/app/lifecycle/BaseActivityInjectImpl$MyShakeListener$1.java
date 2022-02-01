package com.tencent.mobileqq.app.lifecycle;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.mobileqq.app.api.IScreenShot;
import com.tencent.mobileqq.app.api.IScreenShotService;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.ReflectionUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.QLog;

class BaseActivityInjectImpl$MyShakeListener$1
  implements Runnable
{
  BaseActivityInjectImpl$MyShakeListener$1(BaseActivityInjectImpl.MyShakeListener paramMyShakeListener, QBaseActivity paramQBaseActivity) {}
  
  public void run()
  {
    long l1 = SystemClock.uptimeMillis();
    boolean bool = true;
    Object localObject;
    if (!this.a.isResume())
    {
      localObject = this.a.getSharedPreferences("screen_shot", 4).getString("currentactivity", null);
      bool = this.a.getClass().getName().equals(localObject);
    }
    if ((bool) && (SettingCloneUtil.readValue(this.a, null, this.a.getString(2131694985), "qqsetting_screenshot_key", false)) && (ReflectionUtil.a(BaseApplicationImpl.sApplication)))
    {
      if (!this.a.isSupportScreenShot())
      {
        ScreenShot.a("MyShakeListener - not support screen shot");
        return;
      }
      if (this.a.screenShot == null) {
        if (this.a.isResume()) {
          break label209;
        }
      }
      label209:
      for (localObject = this.a.getApplicationContext();; localObject = this.a)
      {
        IScreenShotService localIScreenShotService = (IScreenShotService)QRoute.api(IScreenShotService.class);
        this.a.screenShot = localIScreenShotService.newInstance((Context)localObject, this.a.getWindow());
        if (!this.a.screenShot.a()) {
          break;
        }
        bool = this.a.screenShot.c();
        if (!bool) {
          break label218;
        }
        ScreenShot.a("MyShakeListener - screenshot is showing");
        return;
      }
      label218:
      if (this.a.screenShot.b()) {
        break label315;
      }
      ScreenShot.a("MyShakeListener - screenshot cant activate");
      this.a.cleanScreenShot();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseActivity", 2, "snapshot activate " + bool);
      }
      long l2 = SystemClock.uptimeMillis();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("qqBaseActivity", 2, "cost:" + (l2 - l1));
      return;
      label315:
      if ((!MobileIssueSettings.g) && (Build.VERSION.SDK_INT < 11)) {
        KapalaiAdapterUtil.a().a(this.a.getWindow());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.lifecycle.BaseActivityInjectImpl.MyShakeListener.1
 * JD-Core Version:    0.7.0.1
 */