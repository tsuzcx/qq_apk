package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.widget.TextView;

class RegisterVerifyCodeActivity$1
  implements Runnable
{
  RegisterVerifyCodeActivity$1(RegisterVerifyCodeActivity paramRegisterVerifyCodeActivity) {}
  
  public void run()
  {
    if (RegisterVerifyCodeActivity.a(this.this$0) == 1)
    {
      RegisterVerifyCodeActivity.a(this.this$0).setText(2131717532);
      RegisterVerifyCodeActivity.a(this.this$0).setEnabled(true);
      RegisterVerifyCodeActivity.a(this.this$0).setClickable(true);
      return;
    }
    RegisterVerifyCodeActivity.b(this.this$0);
    RegisterVerifyCodeActivity.a(this.this$0).setText(this.this$0.getString(2131717532) + "(" + RegisterVerifyCodeActivity.a(this.this$0) + "s)");
    this.this$0.a.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterVerifyCodeActivity.1
 * JD-Core Version:    0.7.0.1
 */