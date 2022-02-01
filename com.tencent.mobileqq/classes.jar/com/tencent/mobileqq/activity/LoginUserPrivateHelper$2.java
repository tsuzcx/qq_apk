package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class LoginUserPrivateHelper$2
  implements DialogInterface.OnClickListener
{
  LoginUserPrivateHelper$2(LoginUserPrivateHelper paramLoginUserPrivateHelper) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.b();
      return;
    }
    if (LoginUserPrivateHelper.a(this.a) != null) {
      LoginUserPrivateHelper.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginUserPrivateHelper.2
 * JD-Core Version:    0.7.0.1
 */