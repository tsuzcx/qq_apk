package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

class PhoneUnityBindInfoActivity$17
  implements DialogInterface.OnClickListener
{
  PhoneUnityBindInfoActivity$17(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (PhoneUnityBindInfoActivity.access$2700(this.a) != null) {
      PhoneUnityBindInfoActivity.access$2700(this.a).dismiss();
    }
    this.a.resetContactSwitch(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity.17
 * JD-Core Version:    0.7.0.1
 */