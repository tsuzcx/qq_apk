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
    if (LoginUserPrivateHelper.b(this.a) != null) {
      LoginUserPrivateHelper.b(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginUserPrivateHelper.2
 * JD-Core Version:    0.7.0.1
 */