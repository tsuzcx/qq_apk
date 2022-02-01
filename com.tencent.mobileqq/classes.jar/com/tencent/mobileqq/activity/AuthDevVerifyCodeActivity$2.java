package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class AuthDevVerifyCodeActivity$2
  implements DialogInterface.OnClickListener
{
  AuthDevVerifyCodeActivity$2(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    AuthDevVerifyCodeActivity.access$102(this.a, true);
    this.a.report898("0X800BB53");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity.2
 * JD-Core Version:    0.7.0.1
 */