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
      AuthDevVerifyCodeActivity.access$000(this.this$0).setText(2131914089);
      AuthDevVerifyCodeActivity.access$000(this.this$0).setTextColor(-11692801);
      AuthDevVerifyCodeActivity.access$000(this.this$0).setEnabled(true);
      AuthDevVerifyCodeActivity.access$000(this.this$0).setClickable(true);
      return;
    }
    AuthDevVerifyCodeActivity.mSecond -= 1;
    TextView localTextView = AuthDevVerifyCodeActivity.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.getString(2131914089));
    localStringBuilder.append(" (");
    localStringBuilder.append(AuthDevVerifyCodeActivity.mSecond);
    localStringBuilder.append("s)");
    localTextView.setText(localStringBuilder.toString());
    AuthDevVerifyCodeActivity.access$000(this.this$0).setTextColor(-7894119);
    this.this$0.mHandler.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity.1
 * JD-Core Version:    0.7.0.1
 */