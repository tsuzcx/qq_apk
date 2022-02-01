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
    if (this.a.a.a == 2) {
      this.a.a.a("0X8005B8A", 1);
    } else if (this.a.a.a == 6) {
      this.a.a.a("0X8005B8A", 2);
    } else if (this.a.a.a == 7) {
      this.a.a.a("0X8005B8A", 3);
    }
    paramDialogInterface.dismiss();
    if (!NetworkUtil.isNetSupport(this.a.a))
    {
      this.a.a.showToast(2131694475);
      return;
    }
    paramDialogInterface = this.a.a.mPhoneContactService.getSelfBindInfo();
    if ((paramDialogInterface != null) && (paramDialogInterface.nationCode != null) && (paramDialogInterface.mobileNo != null))
    {
      if (this.a.a.b == null)
      {
        this.a.a.b = new SettingActivity2.2.2.1(this);
        this.a.a.app.registObserver(this.a.a.b);
      }
      this.a.a.mPhoneContactService.disableMobileMatch(paramDialogInterface.nationCode, paramDialogInterface.mobileNo);
      this.a.a.showProgressDialog(2131718766, 300L, true);
      return;
    }
    this.a.a.setResult(0);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2.2.2
 * JD-Core Version:    0.7.0.1
 */