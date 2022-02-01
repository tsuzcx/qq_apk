package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager.PhoneUnityData;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

class PhoneUnityBindInfoActivity$2
  extends SecSvcObserver
{
  PhoneUnityBindInfoActivity$2(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    PhoneUnityBindInfoActivity.a(this.a).setOnCheckedChangeListener(null);
    if (paramInt != 0) {
      if (paramInt == 39)
      {
        DialogUtil.a(this.a, 230, this.a.getString(2131694785), this.a.getString(2131694788), null, this.a.getString(2131692097), new PhoneUnityBindInfoActivity.2.2(this), null).show();
        PhoneUnityBindInfoActivity.a(this.a).a = false;
        PhoneUnityBindInfoActivity.a(this.a).setChecked(false);
        ReportController.b(this.a.app, "dc00898", "", "", "0X800B320", "0X800B320", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      PhoneUnityBindInfoActivity.a(this.a).setOnCheckedChangeListener(this.a);
      return;
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = this.a.getString(2131694766);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SecSvcObserver", 4, "bindPhoneNumLogin fail retCode: " + paramInt);
      }
      QQToast.a(this.a, str, 0).b(this.a.getTitleBarHeight());
      break;
      PhoneUnityBindInfoActivity.a(this.a).a = true;
      PhoneUnityBindInfoActivity.a(this.a).setChecked(true);
      ReportController.b(this.a.app, "dc00898", "", "", "0X800B31E", "0X800B31E", 0, 0, "", "", "", "");
    }
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a.isFinishing()) {
      return;
    }
    QLog.i("SecSvcObserver", 1, "onGetPhoneUnityInfo, success=" + paramBoolean);
    if ((paramBoolean) && (paramBundle != null) && (paramBundle.getBoolean("is_all_phone_get", true)))
    {
      ActionSheet localActionSheet = this.a.a;
      if (localActionSheet != null) {
        localActionSheet.dismiss();
      }
      PhoneUnityBindInfoActivity.a(this.a, paramBoolean, paramBundle);
      PhoneUnityBindInfoActivity.a(this.a);
      PhoneUnityBindInfoActivity.a(this.a, false);
      return;
    }
    if (!PhoneUnityBindInfoActivity.a(this.a))
    {
      QLog.i("SecSvcObserver", 1, "onGetPhoneUnityInfo: re-pull PhoneUnityInfo");
      this.a.a(1, null);
      PhoneUnityBindInfoActivity.a(this.a, true);
    }
    for (;;)
    {
      PhoneUnityBindInfoActivity.a(this.a, false, null);
      return;
      QLog.i("SecSvcObserver", 1, "onGetPhoneUnityInfo: re-pull PhoneUnityInfo fail, close self");
      PhoneUnityBindInfoActivity.a(this.a, 2131694783);
      PhoneUnityBindInfoActivity.a(this.a);
      if (PhoneUnityBindInfoActivity.a(this.a) == null) {
        PhoneUnityBindInfoActivity.a(this.a, new PhoneUnityBindInfoActivity.2.1(this));
      }
      PhoneUnityBindInfoActivity.a(this.a).postDelayed(PhoneUnityBindInfoActivity.a(this.a), 2000L);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    PhoneUnityBindInfoActivity.b(this.a).setOnCheckedChangeListener(null);
    if (paramBoolean2)
    {
      PhoneUnityBindInfoActivity.b(this.a).setChecked(paramBoolean1);
      PhoneUnityBindInfoActivity.a(this.a).c = paramBoolean1;
      PhoneUnityBindInfoActivity.a(this.a).b = paramBoolean1;
      if (paramBoolean1) {
        ReportController.b(this.a.app, "dc00898", "", "", "0X800B31A", "0X800B31A", 0, 0, "", "", "", "");
      }
      PhoneUnityBindInfoActivity.b(this.a).setOnCheckedChangeListener(this.a);
      return;
    }
    Object localObject = PhoneUnityBindInfoActivity.b(this.a);
    if (!paramBoolean1)
    {
      paramBoolean2 = true;
      label114:
      ((FormSwitchItem)localObject).setChecked(paramBoolean2);
      localObject = PhoneUnityBindInfoActivity.a(this.a);
      if (paramBoolean1) {
        break label183;
      }
    }
    label183:
    for (paramBoolean2 = bool;; paramBoolean2 = false)
    {
      ((PhoneUnityManager.PhoneUnityData)localObject).b = paramBoolean2;
      if (!paramBoolean1) {
        break;
      }
      ReportController.b(this.a.app, "dc00898", "", "", "0X800B31B", "0X800B31B", 0, 0, "", "", "", "");
      break;
      paramBoolean2 = false;
      break label114;
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    super.b(paramInt, paramString);
    PhoneUnityBindInfoActivity.a(this.a).setOnCheckedChangeListener(null);
    PhoneUnityBindInfoActivity.b(this.a);
    if (paramInt == 0)
    {
      PhoneUnityBindInfoActivity.a(this.a).setChecked(false);
      PhoneUnityBindInfoActivity.a(this.a).a = false;
      ReportController.b(this.a.app, "dc00898", "", "", "0X800B31F", "0X800B31F", 0, 0, "", "", "", "");
      PhoneUnityBindInfoActivity.a(this.a).setOnCheckedChangeListener(this.a);
      PhoneUnityBindInfoActivity.d(this.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneUnityBindInfoActivity", 2, "UnbindPhoneNumLogin error " + paramInt + " errMsg: " + paramString);
    }
    if (!PhoneUnityBindInfoActivity.b(this.a))
    {
      if (paramInt != 36) {
        break label220;
      }
      PhoneUnityBindInfoActivity.c(this.a);
    }
    for (;;)
    {
      PhoneUnityBindInfoActivity.a(this.a).setChecked(true);
      PhoneUnityBindInfoActivity.a(this.a).a = true;
      ReportController.b(this.a.app, "dc00898", "", "", "0X800B321", "0X800B321", 0, 0, "", "", "", "");
      break;
      label220:
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = this.a.getString(2131694781);
      }
      QQToast.a(this.a, str, 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity.2
 * JD-Core Version:    0.7.0.1
 */