package com.tencent.mobileqq.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mqq.app.AppRuntime;

class LoginFailedHelper$2
  implements DialogInterface.OnClickListener
{
  LoginFailedHelper$2(LoginFailedHelper paramLoginFailedHelper, Runnable paramRunnable, AppRuntime paramAppRuntime, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.run();
    LoginFailedHelper.a(this.e, this.b, this.c, this.d, "0X800B8F7");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.LoginFailedHelper.2
 * JD-Core Version:    0.7.0.1
 */