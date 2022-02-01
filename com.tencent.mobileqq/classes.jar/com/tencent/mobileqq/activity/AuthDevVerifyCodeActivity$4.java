package com.tencent.mobileqq.activity;

import android.widget.Button;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.ClearableEditText;

class AuthDevVerifyCodeActivity$4
  implements Runnable
{
  AuthDevVerifyCodeActivity$4(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = Utils.c(this.a, this.b);
    if ((str != null) && (str.length() > 0) && (AuthDevVerifyCodeActivity.access$200(this.this$0) != null))
    {
      AuthDevVerifyCodeActivity.access$200(this.this$0).setText(str);
      AuthDevVerifyCodeActivity.access$300(this.this$0).setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity.4
 * JD-Core Version:    0.7.0.1
 */