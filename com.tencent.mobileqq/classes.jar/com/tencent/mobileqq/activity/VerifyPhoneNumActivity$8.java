package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

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
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    VerifyPhoneNumActivity.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyPhoneNumActivity.8
 * JD-Core Version:    0.7.0.1
 */