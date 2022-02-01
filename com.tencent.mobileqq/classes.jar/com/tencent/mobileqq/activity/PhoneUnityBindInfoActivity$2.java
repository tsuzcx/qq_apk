package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
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
    PhoneUnityBindInfoActivity.access$700(this.a).setOnCheckedChangeListener(null);
    if (paramInt != 0)
    {
      if (paramInt == 39)
      {
        paramString = this.a;
        DialogUtil.a(paramString, 230, paramString.getString(2131694771), this.a.getString(2131694774), null, this.a.getString(2131692016), new PhoneUnityBindInfoActivity.2.2(this), null).show();
      }
      else
      {
        String str = paramString;
        if (TextUtils.isEmpty(paramString)) {
          str = this.a.getString(2131694750);
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("bindPhoneNumLogin fail retCode: ");
          paramString.append(paramInt);
          QLog.d("SecSvcObserver", 4, paramString.toString());
        }
        QQToast.a(this.a, str, 0).b(this.a.getTitleBarHeight());
      }
      PhoneUnityBindInfoActivity.access$800(this.a).a = false;
      PhoneUnityBindInfoActivity.access$700(this.a).setChecked(false);
      ReportController.b(this.a.app, "dc00898", "", "", "0X800B320", "0X800B320", 0, 0, "", "", "", "");
    }
    else
    {
      PhoneUnityBindInfoActivity.access$800(this.a).a = true;
      PhoneUnityBindInfoActivity.access$700(this.a).setChecked(true);
      ReportController.b(this.a.app, "dc00898", "", "", "0X800B31E", "0X800B31E", 0, 0, "", "", "", "");
    }
    PhoneUnityBindInfoActivity.access$700(this.a).setOnCheckedChangeListener(this.a);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a.isFinishing()) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetPhoneUnityInfo, success=");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("SecSvcObserver", 1, ((StringBuilder)localObject).toString());
    if ((paramBoolean) && (paramBundle != null) && (paramBundle.getBoolean("is_all_phone_get", true)))
    {
      localObject = this.a.mActionSheet;
      if (localObject != null) {
        ((ActionSheet)localObject).dismiss();
      }
      PhoneUnityBindInfoActivity.access$100(this.a, paramBoolean, paramBundle);
      PhoneUnityBindInfoActivity.access$200(this.a);
      PhoneUnityBindInfoActivity.access$302(this.a, false);
      return;
    }
    if (!PhoneUnityBindInfoActivity.access$300(this.a))
    {
      QLog.i("SecSvcObserver", 1, "onGetPhoneUnityInfo: re-pull PhoneUnityInfo");
      this.a.refreshServerData(1, null);
      PhoneUnityBindInfoActivity.access$302(this.a, true);
    }
    else
    {
      QLog.i("SecSvcObserver", 1, "onGetPhoneUnityInfo: re-pull PhoneUnityInfo fail, close self");
      PhoneUnityBindInfoActivity.access$400(this.a, 2131694769);
      PhoneUnityBindInfoActivity.access$200(this.a);
      if (PhoneUnityBindInfoActivity.access$500(this.a) == null) {
        PhoneUnityBindInfoActivity.access$502(this.a, new PhoneUnityBindInfoActivity.2.1(this));
      }
      PhoneUnityBindInfoActivity.access$600(this.a).postDelayed(PhoneUnityBindInfoActivity.access$500(this.a), 2000L);
    }
    PhoneUnityBindInfoActivity.access$100(this.a, false, null);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    PhoneUnityBindInfoActivity.access$1300(this.a).setOnCheckedChangeListener(null);
    if (paramBoolean2)
    {
      PhoneUnityBindInfoActivity.access$1300(this.a).setChecked(paramBoolean1);
      PhoneUnityBindInfoActivity.access$800(this.a).c = paramBoolean1;
      PhoneUnityBindInfoActivity.access$800(this.a).b = paramBoolean1;
      if (paramBoolean1) {
        ReportController.b(this.a.app, "dc00898", "", "", "0X800B31A", "0X800B31A", 0, 0, "", "", "", "");
      }
    }
    else
    {
      PhoneUnityBindInfoActivity.access$1300(this.a).setChecked(paramBoolean1 ^ true);
      PhoneUnityBindInfoActivity.access$800(this.a).b = (paramBoolean1 ^ true);
      if (paramBoolean1) {
        ReportController.b(this.a.app, "dc00898", "", "", "0X800B31B", "0X800B31B", 0, 0, "", "", "", "");
      }
    }
    PhoneUnityBindInfoActivity.access$1300(this.a).setOnCheckedChangeListener(this.a);
  }
  
  protected void b(int paramInt, String paramString)
  {
    super.b(paramInt, paramString);
    PhoneUnityBindInfoActivity.access$700(this.a).setOnCheckedChangeListener(null);
    PhoneUnityBindInfoActivity.access$900(this.a);
    if (paramInt == 0)
    {
      PhoneUnityBindInfoActivity.access$700(this.a).setChecked(false);
      PhoneUnityBindInfoActivity.access$800(this.a).a = false;
      ReportController.b(this.a.app, "dc00898", "", "", "0X800B31F", "0X800B31F", 0, 0, "", "", "", "");
    }
    else
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("UnbindPhoneNumLogin error ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" errMsg: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("PhoneUnityBindInfoActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (!PhoneUnityBindInfoActivity.access$1000(this.a)) {
        if (paramInt == 36)
        {
          PhoneUnityBindInfoActivity.access$1100(this.a);
        }
        else
        {
          localObject = paramString;
          if (TextUtils.isEmpty(paramString)) {
            localObject = this.a.getString(2131694767);
          }
          QQToast.a(this.a, (CharSequence)localObject, 0).b(this.a.getTitleBarHeight());
        }
      }
      PhoneUnityBindInfoActivity.access$700(this.a).setChecked(true);
      PhoneUnityBindInfoActivity.access$800(this.a).a = true;
      ReportController.b(this.a.app, "dc00898", "", "", "0X800B321", "0X800B321", 0, 0, "", "", "", "");
    }
    PhoneUnityBindInfoActivity.access$700(this.a).setOnCheckedChangeListener(this.a);
    PhoneUnityBindInfoActivity.access$1200(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity.2
 * JD-Core Version:    0.7.0.1
 */