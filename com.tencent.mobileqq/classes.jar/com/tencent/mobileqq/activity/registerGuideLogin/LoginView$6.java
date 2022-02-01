package com.tencent.mobileqq.activity.registerGuideLogin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.AutoCompleteTextView;

class LoginView$6
  implements DialogInterface.OnClickListener
{
  LoginView$6(LoginView paramLoginView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.a.getText().toString();
    if (!TextUtils.isEmpty(paramDialogInterface)) {
      this.a.a(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.6
 * JD-Core Version:    0.7.0.1
 */