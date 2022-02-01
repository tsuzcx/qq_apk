package com.tencent.mobileqq.activity;

import android.app.Dialog;

class RegisterNewBaseActivity$3
  implements Runnable
{
  RegisterNewBaseActivity$3(RegisterNewBaseActivity paramRegisterNewBaseActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterNewBaseActivity.3
 * JD-Core Version:    0.7.0.1
 */