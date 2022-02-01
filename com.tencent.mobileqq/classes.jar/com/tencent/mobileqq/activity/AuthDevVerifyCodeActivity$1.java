package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.widget.TextView;

class AuthDevVerifyCodeActivity$1
  implements Runnable
{
  AuthDevVerifyCodeActivity$1(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void run()
  {
    if (AuthDevVerifyCodeActivity.mSecond <= 1)
    {
      AuthDevVerifyCodeActivity.access$000(this.this$0).setText(2131716973);
      AuthDevVerifyCodeActivity.access$000(this.this$0).setEnabled(true);
      AuthDevVerifyCodeActivity.access$000(this.this$0).setClickable(true);
      return;
    }
    AuthDevVerifyCodeActivity.mSecond -= 1;
    AuthDevVerifyCodeActivity.access$000(this.this$0).setText(this.this$0.getString(2131716973) + "(" + AuthDevVerifyCodeActivity.mSecond + ")");
    this.this$0.mHandler.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity.1
 * JD-Core Version:    0.7.0.1
 */