package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class LoginVerifyCodeActivity$3
  implements Runnable
{
  public void run()
  {
    try
    {
      if ((LoginVerifyCodeActivity.n(this.this$0) == null) && (!this.this$0.isFinishing()))
      {
        LoginVerifyCodeActivity.a(this.this$0, new QQProgressDialog(this.this$0, this.this$0.getTitleBarHeight()));
        LoginVerifyCodeActivity.n(this.this$0).c(2131892360);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    if ((LoginVerifyCodeActivity.n(this.this$0) != null) && (!LoginVerifyCodeActivity.n(this.this$0).isShowing())) {
      LoginVerifyCodeActivity.n(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity.3
 * JD-Core Version:    0.7.0.1
 */