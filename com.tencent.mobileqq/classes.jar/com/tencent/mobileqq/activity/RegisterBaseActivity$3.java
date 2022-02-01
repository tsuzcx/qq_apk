package com.tencent.mobileqq.activity;

import android.app.Dialog;

class RegisterBaseActivity$3
  implements Runnable
{
  RegisterBaseActivity$3(RegisterBaseActivity paramRegisterBaseActivity) {}
  
  public void run()
  {
    try
    {
      if ((this.this$0.a != null) && (this.this$0.a.isShowing())) {
        this.this$0.a.dismiss();
      }
      this.this$0.a = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterBaseActivity.3
 * JD-Core Version:    0.7.0.1
 */