package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityBannerData;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class QQSettingSettingActivity$3
  extends SecSvcObserver
{
  QQSettingSettingActivity$3(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  protected void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SecSvcObserver", 2, String.format(Locale.getDefault(), "onGetPhoneUnityLocalData data: %s, create: %s, count: %s", new Object[] { paramObject, Boolean.valueOf(this.a.i), Integer.valueOf(this.a.s) }));
    }
    boolean bool1;
    if (paramObject == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if ((paramObject instanceof PhoneUnityBannerData)) {
        bool2 = ((PhoneUnityBannerData)paramObject).i;
      }
    }
    paramObject = this.a.findViewById(2131442619);
    if (paramObject != null) {
      if (bool2)
      {
        paramObject.setVisibility(0);
        if (this.a.i)
        {
          this.a.a(true);
        }
        else if (this.a.s == 0)
        {
          this.a.a(false);
        }
        else
        {
          paramObject = (PhoneUnityManager)this.a.app.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
          if (paramObject.h != null) {
            QQSettingSettingActivity.a(this.a, true, paramObject.h);
          }
        }
      }
      else
      {
        paramObject.setVisibility(8);
      }
    }
    this.a.i = false;
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    if (this.a.isFinishing()) {
      return;
    }
    boolean bool = false;
    if (paramBoolean)
    {
      paramString = this.a;
      paramBoolean = bool;
      if (paramInt == 1) {
        paramBoolean = true;
      }
      QQSettingSettingActivity.a(paramString, paramBoolean);
      return;
    }
    if (this.a.isResume())
    {
      paramString = this.a.getString(2131888998);
      QQToast.makeText(this.a.getApplicationContext(), paramString, 0).show(this.a.getTitleBarHeight());
    }
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetPhoneUnityInfo isSuc: ");
      localStringBuilder.append(paramBoolean);
      QLog.i("SecSvcObserver", 2, localStringBuilder.toString());
    }
    if (this.a.isFinishing()) {
      return;
    }
    QQSettingSettingActivity.b(this.a, false);
    QQSettingSettingActivity.a(this.a, paramBoolean, paramBundle);
    if (QQSettingSettingActivity.e(this.a)) {
      if (QQSettingSettingActivity.f(this.a)) {
        QQSettingSettingActivity.g(this.a);
      } else if (this.a.isResume()) {
        QQToast.makeText(this.a.getApplicationContext(), this.a.getString(2131892471), 0).show(this.a.getTitleBarHeight());
      }
    }
    QQSettingSettingActivity.c(this.a, false);
    if (this.a.isResume())
    {
      paramBundle = this.a;
      paramBundle.s -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity.3
 * JD-Core Version:    0.7.0.1
 */