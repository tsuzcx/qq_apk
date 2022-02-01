package com.tencent.mobileqq.activity;

import bjbs;

class AuthDevVerifyCodeActivity$7
  implements Runnable
{
  AuthDevVerifyCodeActivity$7(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevVerifyCodeActivity.a(this.this$0) != null) && (AuthDevVerifyCodeActivity.a(this.this$0).isShowing()))
      {
        AuthDevVerifyCodeActivity.a(this.this$0).dismiss();
        AuthDevVerifyCodeActivity.a(this.this$0).cancel();
      }
      AuthDevVerifyCodeActivity.a(this.this$0, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity.7
 * JD-Core Version:    0.7.0.1
 */