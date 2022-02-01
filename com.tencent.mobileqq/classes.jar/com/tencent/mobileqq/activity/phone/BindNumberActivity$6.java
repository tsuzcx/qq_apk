package com.tencent.mobileqq.activity.phone;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.qphone.base.util.QLog;

class BindNumberActivity$6
  implements DialogInterface.OnClickListener
{
  BindNumberActivity$6(BindNumberActivity paramBindNumberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindNumberActivity", 2, "new user guild confirm unbind");
    }
    this.a.a("dc00898", "0X8009F16", 0);
    this.a.mPhoneContactService.sendRebindMobile(this.a.d, this.a.i, 0, this.a.l, this.a.m);
    this.a.showProgressDialog(2131916272, 1000L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberActivity.6
 * JD-Core Version:    0.7.0.1
 */