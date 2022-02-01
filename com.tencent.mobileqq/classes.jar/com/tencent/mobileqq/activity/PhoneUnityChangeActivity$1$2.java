package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;

class PhoneUnityChangeActivity$1$2
  implements DialogInterface.OnClickListener
{
  PhoneUnityChangeActivity$1$2(PhoneUnityChangeActivity.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (!NetworkUtil.isNetSupport(this.a.a))
    {
      PhoneUnityChangeActivity.a(this.a.a, 2131694475);
      return;
    }
    if (this.a.a.b == null)
    {
      this.a.a.b = new PhoneUnityChangeActivity.1.2.1(this);
      this.a.a.app.registObserver(this.a.a.b);
    }
    PhoneUnityChangeActivity.a(this.a.a).unbindMobile(true, false);
    PhoneUnityChangeActivity.a(this.a.a, 2131718766, 0L, true);
    ReportController.b(this.a.a.app, "CliOper", "", "", "0X8005B81", "0X8005B81", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityChangeActivity.1.2
 * JD-Core Version:    0.7.0.1
 */