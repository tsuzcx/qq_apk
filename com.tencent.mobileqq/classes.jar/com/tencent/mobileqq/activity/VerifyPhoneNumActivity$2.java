package com.tencent.mobileqq.activity;

import android.app.Dialog;

class VerifyPhoneNumActivity$2
  implements Runnable
{
  VerifyPhoneNumActivity$2(VerifyPhoneNumActivity paramVerifyPhoneNumActivity) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.isShowing()) && (!this.this$0.isFinishing())) {
      this.this$0.a.dismiss();
    }
    this.this$0.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyPhoneNumActivity.2
 * JD-Core Version:    0.7.0.1
 */