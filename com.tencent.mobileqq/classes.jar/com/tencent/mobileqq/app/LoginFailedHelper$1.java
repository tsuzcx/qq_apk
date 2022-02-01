package com.tencent.mobileqq.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mqq.app.AppRuntime;

class LoginFailedHelper$1
  implements DialogInterface.OnClickListener
{
  LoginFailedHelper$1(LoginFailedHelper paramLoginFailedHelper, AppRuntime paramAppRuntime, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    LoginFailedHelper.a(this.d, this.a, this.b, this.c, "0X800B8F6");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.LoginFailedHelper.1
 * JD-Core Version:    0.7.0.1
 */