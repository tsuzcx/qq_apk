package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class AuthDevVerifyCodeActivity$3
  implements DialogInterface.OnClickListener
{
  AuthDevVerifyCodeActivity$3(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.report898("0X800BB52");
    AuthDevVerifyCodeActivity.access$201(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity.3
 * JD-Core Version:    0.7.0.1
 */