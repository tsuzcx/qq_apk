package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.util.ReflectionUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class BaseActivity2$MyShakeListener
  extends ShakeListener
{
  public void a()
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = BaseApplicationImpl.sApplication;
    if (i > 10) {
      i = 4;
    } else {
      i = 0;
    }
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("screen_shot", i).getString("currentactivity", null);
    if ((BaseActivity2.q != null) && (BaseActivity2.q.getClass().getName().equals(localObject)))
    {
      boolean bool1 = SettingCloneUtil.readValue(BaseApplicationImpl.sApplication, null, BaseApplicationImpl.sApplication.getString(2131892702), "qqsetting_screenshot_key", false);
      boolean bool2 = ReflectionUtil.a(BaseApplication.getContext());
      if ((bool1) && (bool2))
      {
        if (BaseActivity2.q.r == null)
        {
          if (BaseActivity2.q.s) {
            localObject = BaseActivity2.q.getApplicationContext();
          } else {
            localObject = BaseActivity2.q;
          }
          BaseActivity2.q.r = new ScreenShot((Context)localObject, BaseActivity2.q.getWindow());
        }
        bool1 = BaseActivity2.q.r.b();
        if (bool1)
        {
          ScreenShot.a("BaseActivity2 is showing");
          return;
        }
        if (!BaseActivity2.q.r.c()) {
          BaseActivity2.a(BaseActivity2.q);
        } else if ((!MobileIssueSettings.g) && (Build.VERSION.SDK_INT < 11)) {
          KapalaiAdapterUtil.a().a(BaseActivity2.q.getWindow());
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("snapshot activate ");
          ((StringBuilder)localObject).append(bool1);
          QLog.d("BaseActivity", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity2.MyShakeListener
 * JD-Core Version:    0.7.0.1
 */