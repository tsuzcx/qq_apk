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
      QLog.i("SecSvcObserver", 2, String.format(Locale.getDefault(), "onGetPhoneUnityLocalData data: %s, create: %s, count: %s", new Object[] { paramObject, Boolean.valueOf(this.a.jdField_a_of_type_Boolean), Integer.valueOf(this.a.jdField_a_of_type_Int) }));
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
        bool2 = ((PhoneUnityBannerData)paramObject).b;
      }
    }
    paramObject = this.a.findViewById(2131374449);
    if (paramObject != null) {
      if (bool2)
      {
        paramObject.setVisibility(0);
        if (this.a.jdField_a_of_type_Boolean)
        {
          this.a.a(true);
        }
        else if (this.a.jdField_a_of_type_Int == 0)
        {
          this.a.a(false);
        }
        else
        {
          paramObject = (PhoneUnityManager)this.a.app.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
          if (paramObject.a != null) {
            QQSettingSettingActivity.a(this.a, true, paramObject.a);
          }
        }
      }
      else
      {
        paramObject.setVisibility(8);
      }
    }
    this.a.jdField_a_of_type_Boolean = false;
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
      paramString = this.a.getString(2131692031);
      QQToast.a(this.a.getApplicationContext(), paramString, 0).b(this.a.getTitleBarHeight());
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
    if (QQSettingSettingActivity.b(this.a)) {
      if (QQSettingSettingActivity.c(this.a)) {
        QQSettingSettingActivity.c(this.a);
      } else if (this.a.isResume()) {
        QQToast.a(this.a.getApplicationContext(), this.a.getString(2131694768), 0).b(this.a.getTitleBarHeight());
      }
    }
    QQSettingSettingActivity.c(this.a, false);
    if (this.a.isResume())
    {
      paramBundle = this.a;
      paramBundle.jdField_a_of_type_Int -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity.3
 * JD-Core Version:    0.7.0.1
 */