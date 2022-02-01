package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class LoginVerifyCodeActivity$3
  implements Runnable
{
  public void run()
  {
    try
    {
      if ((LoginVerifyCodeActivity.a(this.this$0) == null) && (!this.this$0.isFinishing()))
      {
        LoginVerifyCodeActivity.a(this.this$0, new QQProgressDialog(this.this$0.getActivity(), this.this$0.getTitleBarHeight()));
        LoginVerifyCodeActivity.a(this.this$0).c(2131694694);
      }
      if ((LoginVerifyCodeActivity.a(this.this$0) != null) && (!LoginVerifyCodeActivity.a(this.this$0).isShowing())) {
        LoginVerifyCodeActivity.a(this.this$0).show();
      }
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
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity.3
 * JD-Core Version:    0.7.0.1
 */