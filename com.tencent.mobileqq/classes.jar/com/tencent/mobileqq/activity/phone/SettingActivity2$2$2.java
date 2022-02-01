package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.utils.NetworkUtil;

class SettingActivity2$2$2
  implements DialogInterface.OnClickListener
{
  SettingActivity2$2$2(SettingActivity2.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.b.h == 2) {
      this.a.b.a("0X8005B8A", 1);
    } else if (this.a.b.h == 6) {
      this.a.b.a("0X8005B8A", 2);
    } else if (this.a.b.h == 7) {
      this.a.b.a("0X8005B8A", 3);
    }
    paramDialogInterface.dismiss();
    if (!NetworkUtil.isNetSupport(this.a.b))
    {
      this.a.b.showToast(2131892157);
      return;
    }
    paramDialogInterface = this.a.b.mPhoneContactService.getSelfBindInfo();
    if ((paramDialogInterface != null) && (paramDialogInterface.nationCode != null) && (paramDialogInterface.mobileNo != null))
    {
      if (this.a.b.d == null)
      {
        this.a.b.d = new SettingActivity2.2.2.1(this);
        this.a.b.app.registObserver(this.a.b.d);
      }
      this.a.b.mPhoneContactService.disableMobileMatch(paramDialogInterface.nationCode, paramDialogInterface.mobileNo);
      this.a.b.showProgressDialog(2131916272, 300L, true);
      return;
    }
    this.a.b.setResult(0);
    this.a.b.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2.2.2
 * JD-Core Version:    0.7.0.1
 */