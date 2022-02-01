package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class VerifyPhoneNumActivity$7
  implements Runnable
{
  VerifyPhoneNumActivity$7(VerifyPhoneNumActivity paramVerifyPhoneNumActivity) {}
  
  public void run()
  {
    try
    {
      if ((VerifyPhoneNumActivity.a(this.this$0) == null) && (!this.this$0.isFinishing()))
      {
        VerifyPhoneNumActivity.a(this.this$0, new QQProgressDialog(this.this$0.getActivity(), this.this$0.getTitleBarHeight()));
        VerifyPhoneNumActivity.a(this.this$0).c(2131694668);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    if ((VerifyPhoneNumActivity.a(this.this$0) != null) && (!VerifyPhoneNumActivity.a(this.this$0).isShowing())) {
      VerifyPhoneNumActivity.a(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyPhoneNumActivity.7
 * JD-Core Version:    0.7.0.1
 */