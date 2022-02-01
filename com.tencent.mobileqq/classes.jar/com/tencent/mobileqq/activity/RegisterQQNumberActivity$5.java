package com.tencent.mobileqq.activity;

import bjbs;

class RegisterQQNumberActivity$5
  implements Runnable
{
  RegisterQQNumberActivity$5(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  public void run()
  {
    try
    {
      if ((RegisterQQNumberActivity.a(this.this$0) == null) && (!this.this$0.isFinishing()))
      {
        RegisterQQNumberActivity.a(this.this$0, new bjbs(this.this$0.getActivity(), this.this$0.getTitleBarHeight()));
        RegisterQQNumberActivity.a(this.this$0).c(2131694176);
      }
      if ((RegisterQQNumberActivity.a(this.this$0) != null) && (!RegisterQQNumberActivity.a(this.this$0).isShowing())) {
        RegisterQQNumberActivity.a(this.this$0).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterQQNumberActivity.5
 * JD-Core Version:    0.7.0.1
 */