package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;

class PhoneUnityPhoneLoginActivity$1
  extends SecSvcObserver
{
  PhoneUnityPhoneLoginActivity$1(PhoneUnityPhoneLoginActivity paramPhoneUnityPhoneLoginActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt == 0) && (PhoneUnityPhoneLoginActivity.a(this.a) != null))
    {
      PhoneUnityPhoneLoginActivity.a(this.a).setOnCheckedChangeListener(null);
      PhoneUnityPhoneLoginActivity.a(this.a).setChecked(true);
      PhoneUnityPhoneLoginActivity.a(this.a).setOnCheckedChangeListener(this.a);
      return;
    }
    if (paramInt == 39)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8005BFD", "0X8005BFD", 0, 0, "", "", "", "");
      paramString = this.a;
      DialogUtil.a(paramString, 230, paramString.getString(2131892455), this.a.getString(2131892454), null, this.a.getString(2131888983), new PhoneUnityPhoneLoginActivity.1.1(this), null).show();
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = this.a.getString(2131892453);
    }
    QQToast.makeText(this.a, paramString, 0).show(this.a.getTitleBarHeight());
  }
  
  public void b(int paramInt, String paramString)
  {
    if ((paramInt == 0) && (PhoneUnityPhoneLoginActivity.a(this.a) != null))
    {
      PhoneUnityPhoneLoginActivity.a(this.a).setOnCheckedChangeListener(null);
      PhoneUnityPhoneLoginActivity.a(this.a).setChecked(false);
      PhoneUnityPhoneLoginActivity.a(this.a).setOnCheckedChangeListener(this.a);
      return;
    }
    String str;
    if (paramInt == 36)
    {
      str = this.a.getString(2131892459);
    }
    else
    {
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = this.a.getString(2131892458);
      }
    }
    QQToast.makeText(this.a, str, 0).show(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityPhoneLoginActivity.1
 * JD-Core Version:    0.7.0.1
 */