package com.tencent.mobileqq.activity.phone;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class BindNumberActivity$2
  implements DialogInterface.OnClickListener
{
  BindNumberActivity$2(BindNumberActivity paramBindNumberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BindNumberActivity.a(this.a);
    paramDialogInterface.dismiss();
    paramDialogInterface = this.a.getIntent();
    if (paramDialogInterface.getBooleanExtra("kFPhoneChange", false)) {
      this.a.a("CliOper", "0X8005DE9", 1);
    }
    if (paramDialogInterface.getBooleanExtra("kUnityOther", false)) {
      this.a.a("CliOper", "0X8005DE9", 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberActivity.2
 * JD-Core Version:    0.7.0.1
 */