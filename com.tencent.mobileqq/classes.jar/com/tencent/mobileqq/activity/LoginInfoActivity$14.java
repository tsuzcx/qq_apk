package com.tencent.mobileqq.activity;

import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.utils.IdentificationUtils.ErrorRunnable;
import com.tencent.mobileqq.widget.QQToast;

class LoginInfoActivity$14
  implements IdentificationUtils.ErrorRunnable
{
  LoginInfoActivity$14(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void a(String paramString)
  {
    LoginInfoActivity.access$2800(this.a).setClickable(true);
    QQToast.makeText(this.a, paramString, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.14
 * JD-Core Version:    0.7.0.1
 */