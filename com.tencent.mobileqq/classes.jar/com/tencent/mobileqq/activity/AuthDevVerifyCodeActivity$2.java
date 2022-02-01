package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class AuthDevVerifyCodeActivity$2
  implements Runnable
{
  AuthDevVerifyCodeActivity$2(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevVerifyCodeActivity.access$100(this.this$0) == null) && (!this.this$0.isFinishing()))
      {
        AuthDevVerifyCodeActivity.access$102(this.this$0, new QQProgressDialog(this.this$0.getActivity(), this.this$0.getTitleBarHeight()));
        AuthDevVerifyCodeActivity.access$100(this.this$0).c(2131694694);
      }
      if ((AuthDevVerifyCodeActivity.access$100(this.this$0) != null) && (!AuthDevVerifyCodeActivity.access$100(this.this$0).isShowing())) {
        AuthDevVerifyCodeActivity.access$100(this.this$0).show();
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
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity.2
 * JD-Core Version:    0.7.0.1
 */