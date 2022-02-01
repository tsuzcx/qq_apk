package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class AuthDevVerifyCodeActivity$3
  implements Runnable
{
  AuthDevVerifyCodeActivity$3(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevVerifyCodeActivity.access$100(this.this$0) != null) && (AuthDevVerifyCodeActivity.access$100(this.this$0).isShowing()))
      {
        AuthDevVerifyCodeActivity.access$100(this.this$0).dismiss();
        AuthDevVerifyCodeActivity.access$100(this.this$0).cancel();
      }
      AuthDevVerifyCodeActivity.access$102(this.this$0, null);
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
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity.3
 * JD-Core Version:    0.7.0.1
 */