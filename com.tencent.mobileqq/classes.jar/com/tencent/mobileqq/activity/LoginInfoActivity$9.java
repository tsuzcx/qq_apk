package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class LoginInfoActivity$9
  implements Runnable
{
  LoginInfoActivity$9(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void run()
  {
    try
    {
      if ((LoginInfoActivity.access$2200(this.this$0) != null) && (LoginInfoActivity.access$2200(this.this$0).isShowing()))
      {
        LoginInfoActivity.access$2200(this.this$0).dismiss();
        LoginInfoActivity.access$2200(this.this$0).cancel();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    LoginInfoActivity.access$2202(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.9
 * JD-Core Version:    0.7.0.1
 */