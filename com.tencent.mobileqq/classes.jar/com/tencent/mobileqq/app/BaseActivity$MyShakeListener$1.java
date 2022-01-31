package com.tencent.mobileqq.app;

import alkg;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.SystemClock;
import bczj;
import bdlw;
import bdlz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;

public class BaseActivity$MyShakeListener$1
  implements Runnable
{
  public BaseActivity$MyShakeListener$1(alkg paramalkg, BaseActivity paramBaseActivity) {}
  
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
    if ((bool) && (SettingCloneUtil.readValue(this.a, null, this.a.getString(2131695442), "qqsetting_screenshot_key", false)) && (bczj.a(BaseApplicationImpl.sApplication)))
    {
      if (!this.a.isSupportScreenShot())
      {
        ScreenShot.a("MyShakeListener - not support screen shot");
        return;
      }
      if (this.a.screenShot == null) {
        if (this.a.isResume()) {
          break label195;
        }
      }
      label195:
      for (localObject = this.a.getApplicationContext();; localObject = this.a)
      {
        this.a.screenShot = new ScreenShot((Context)localObject, this.a.getWindow());
        if (!this.a.screenShot.a()) {
          break;
        }
        bool = this.a.screenShot.b();
        if (!bool) {
          break label204;
        }
        ScreenShot.a("MyShakeListener - screenshot is showing");
        return;
      }
      label204:
      if (this.a.screenShot.c()) {
        break label299;
      }
      ScreenShot.a("MyShakeListener - screenshot cant activate");
      BaseActivity.access$000(this.a);
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
      label299:
      if ((!bdlz.g) && (Build.VERSION.SDK_INT < 11)) {
        bdlw.a().a(this.a.getWindow());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity.MyShakeListener.1
 * JD-Core Version:    0.7.0.1
 */