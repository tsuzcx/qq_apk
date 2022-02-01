package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class RegisterQQNumberActivity$4
  implements Runnable
{
  RegisterQQNumberActivity$4(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  public void run()
  {
    try
    {
      if ((RegisterQQNumberActivity.a(this.this$0) != null) && (RegisterQQNumberActivity.a(this.this$0).isShowing()))
      {
        RegisterQQNumberActivity.a(this.this$0).dismiss();
        RegisterQQNumberActivity.a(this.this$0).cancel();
      }
      RegisterQQNumberActivity.a(this.this$0, null);
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
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterQQNumberActivity.4
 * JD-Core Version:    0.7.0.1
 */