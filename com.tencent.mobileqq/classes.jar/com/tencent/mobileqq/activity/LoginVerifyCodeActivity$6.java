package com.tencent.mobileqq.activity;

import bbms;

class LoginVerifyCodeActivity$6
  implements Runnable
{
  public void run()
  {
    try
    {
      if ((LoginVerifyCodeActivity.a(this.this$0) != null) && (LoginVerifyCodeActivity.a(this.this$0).isShowing()))
      {
        LoginVerifyCodeActivity.a(this.this$0).dismiss();
        LoginVerifyCodeActivity.a(this.this$0).cancel();
      }
      LoginVerifyCodeActivity.a(this.this$0, null);
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
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity.6
 * JD-Core Version:    0.7.0.1
 */