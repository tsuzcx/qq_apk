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
      if ((VerifyPhoneNumActivity.d(this.this$0) != null) && (VerifyPhoneNumActivity.d(this.this$0).isShowing()))
      {
        VerifyPhoneNumActivity.d(this.this$0).dismiss();
        VerifyPhoneNumActivity.d(this.this$0).cancel();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    VerifyPhoneNumActivity.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyPhoneNumActivity.8
 * JD-Core Version:    0.7.0.1
 */