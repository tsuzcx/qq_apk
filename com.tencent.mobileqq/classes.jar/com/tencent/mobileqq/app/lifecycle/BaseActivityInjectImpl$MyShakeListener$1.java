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
    Object localObject;
    boolean bool;
    if (!this.a.isResume())
    {
      localObject = this.a.getSharedPreferences("screen_shot", 4).getString("currentactivity", null);
      bool = this.a.getClass().getName().equals(localObject);
    }
    else
    {
      bool = true;
    }
    if (bool)
    {
      localObject = this.a;
      if ((SettingCloneUtil.readValue((Context)localObject, null, ((QBaseActivity)localObject).getString(2131694975), "qqsetting_screenshot_key", false)) && (ReflectionUtil.a(BaseApplicationImpl.sApplication)))
      {
        if (!this.a.isSupportScreenShot())
        {
          ScreenShot.a("MyShakeListener - not support screen shot");
          return;
        }
        if (this.a.screenShot == null)
        {
          if (!this.a.isResume()) {
            localObject = this.a.getApplicationContext();
          } else {
            localObject = this.a;
          }
          IScreenShotService localIScreenShotService = (IScreenShotService)QRoute.api(IScreenShotService.class);
          QBaseActivity localQBaseActivity = this.a;
          localQBaseActivity.screenShot = localIScreenShotService.newInstance((Context)localObject, localQBaseActivity.getWindow());
        }
        if (!this.a.screenShot.a()) {
          return;
        }
        bool = this.a.screenShot.c();
        if (bool)
        {
          ScreenShot.a("MyShakeListener - screenshot is showing");
          return;
        }
        if (!this.a.screenShot.b())
        {
          ScreenShot.a("MyShakeListener - screenshot cant activate");
          this.a.cleanScreenShot();
        }
        else if ((!MobileIssueSettings.g) && (Build.VERSION.SDK_INT < 11))
        {
          KapalaiAdapterUtil.a().a(this.a.getWindow());
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("snapshot activate ");
          ((StringBuilder)localObject).append(bool);
          QLog.d("BaseActivity", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cost:");
      ((StringBuilder)localObject).append(l2 - l1);
      QLog.d("qqBaseActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.lifecycle.BaseActivityInjectImpl.MyShakeListener.1
 * JD-Core Version:    0.7.0.1
 */