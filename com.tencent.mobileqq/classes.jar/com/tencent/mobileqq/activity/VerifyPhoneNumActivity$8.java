package com.tencent.mobileqq.activity;

import bety;

class VerifyPhoneNumActivity$8
  implements Runnable
{
  VerifyPhoneNumActivity$8(VerifyPhoneNumActivity paramVerifyPhoneNumActivity) {}
  
  public void run()
  {
    try
    {
      if ((VerifyPhoneNumActivity.a(this.this$0) != null) && (VerifyPhoneNumActivity.a(this.this$0).isShowing()))
      {
        VerifyPhoneNumActivity.a(this.this$0).dismiss();
        VerifyPhoneNumActivity.a(this.this$0).cancel();
      }
      VerifyPhoneNumActivity.a(this.this$0, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyPhoneNumActivity.8
 * JD-Core Version:    0.7.0.1
 */