package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

class PhoneUnityBindInfoActivity$16
  implements DialogInterface.OnClickListener
{
  PhoneUnityBindInfoActivity$16(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (PhoneUnityBindInfoActivity.a(this.a) != null) {
      PhoneUnityBindInfoActivity.a(this.a).dismiss();
    }
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity.16
 * JD-Core Version:    0.7.0.1
 */