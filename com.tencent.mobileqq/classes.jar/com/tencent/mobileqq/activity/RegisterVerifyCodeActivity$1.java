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
      RegisterVerifyCodeActivity.b(this.this$0).setText(2131914089);
      RegisterVerifyCodeActivity.b(this.this$0).setTextColor(-11692801);
      RegisterVerifyCodeActivity.b(this.this$0).setEnabled(true);
      RegisterVerifyCodeActivity.b(this.this$0).setClickable(true);
      return;
    }
    RegisterVerifyCodeActivity.c(this.this$0);
    TextView localTextView = RegisterVerifyCodeActivity.b(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.getString(2131914089));
    localStringBuilder.append(" (");
    localStringBuilder.append(RegisterVerifyCodeActivity.a(this.this$0));
    localStringBuilder.append("s)");
    localTextView.setText(localStringBuilder.toString());
    this.this$0.handler.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterVerifyCodeActivity.1
 * JD-Core Version:    0.7.0.1
 */