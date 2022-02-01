package com.tencent.mobileqq.activity;

import bjbs;

class LoginInfoActivity$10
  implements Runnable
{
  LoginInfoActivity$10(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void run()
  {
    try
    {
      if ((LoginInfoActivity.a(this.this$0) != null) && (LoginInfoActivity.a(this.this$0).isShowing()))
      {
        LoginInfoActivity.a(this.this$0).dismiss();
        LoginInfoActivity.a(this.this$0).cancel();
      }
      LoginInfoActivity.a(this.this$0, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.10
 * JD-Core Version:    0.7.0.1
 */