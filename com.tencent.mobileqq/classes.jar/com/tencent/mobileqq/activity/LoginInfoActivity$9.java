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
      LoginInfoActivity.access$2202(this.this$0, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.9
 * JD-Core Version:    0.7.0.1
 */