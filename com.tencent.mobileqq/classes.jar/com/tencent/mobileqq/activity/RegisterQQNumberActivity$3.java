package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class RegisterQQNumberActivity$3
  implements Runnable
{
  RegisterQQNumberActivity$3(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  public void run()
  {
    try
    {
      if ((RegisterQQNumberActivity.c(this.this$0) == null) && (!this.this$0.isFinishing()))
      {
        RegisterQQNumberActivity.a(this.this$0, new QQProgressDialog(this.this$0, this.this$0.getTitleBarHeight()));
        RegisterQQNumberActivity.c(this.this$0).c(2131892360);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    if ((RegisterQQNumberActivity.c(this.this$0) != null) && (!RegisterQQNumberActivity.c(this.this$0).isShowing())) {
      RegisterQQNumberActivity.c(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterQQNumberActivity.3
 * JD-Core Version:    0.7.0.1
 */