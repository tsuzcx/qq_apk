package com.tencent.mobileqq.activity.phone;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class BindVerifyActivity$5
  implements DialogInterface.OnClickListener
{
  BindVerifyActivity$5(BindVerifyActivity paramBindVerifyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindVerifyActivity", 2, "new user guild confirm unbind");
    }
    BindVerifyActivity.f(this.a);
    this.a.showProgressDialog(2131916272, 1000L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindVerifyActivity.5
 * JD-Core Version:    0.7.0.1
 */