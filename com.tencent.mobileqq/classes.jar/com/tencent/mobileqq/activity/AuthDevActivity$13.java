package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class AuthDevActivity$13
  implements Runnable
{
  AuthDevActivity$13(AuthDevActivity paramAuthDevActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevActivity.access$3100(this.this$0) == null) && (!this.this$0.isFinishing())) {
        AuthDevActivity.access$3102(this.this$0, new QQProgressDialog(this.this$0, this.this$0.getTitleBarHeight()));
      }
      if ((AuthDevActivity.access$3100(this.this$0) != null) && (!AuthDevActivity.access$3100(this.this$0).isShowing())) {
        AuthDevActivity.access$3100(this.this$0).show();
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
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity.13
 * JD-Core Version:    0.7.0.1
 */