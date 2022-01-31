package com.tencent.mobileqq.activity;

import bcpq;

class LoginVerifyCodeActivity2$5
  implements Runnable
{
  public void run()
  {
    try
    {
      if ((LoginVerifyCodeActivity2.a(this.this$0) != null) && (LoginVerifyCodeActivity2.a(this.this$0).isShowing()))
      {
        LoginVerifyCodeActivity2.a(this.this$0).dismiss();
        LoginVerifyCodeActivity2.a(this.this$0).cancel();
      }
      LoginVerifyCodeActivity2.a(this.this$0, null);
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
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity2.5
 * JD-Core Version:    0.7.0.1
 */