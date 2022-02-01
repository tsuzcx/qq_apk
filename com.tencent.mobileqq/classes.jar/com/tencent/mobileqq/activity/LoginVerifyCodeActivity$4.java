package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class LoginVerifyCodeActivity$4
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
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    LoginVerifyCodeActivity.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity.4
 * JD-Core Version:    0.7.0.1
 */