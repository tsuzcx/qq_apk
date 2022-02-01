package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.VerifyCodeView;

class AuthDevVerifyCodeActivity$6
  implements Runnable
{
  AuthDevVerifyCodeActivity$6(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = Utils.c(this.a, this.b);
    if ((str != null) && (str.length() > 0) && (AuthDevVerifyCodeActivity.access$400(this.this$0) != null)) {
      AuthDevVerifyCodeActivity.access$400(this.this$0).setCode(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity.6
 * JD-Core Version:    0.7.0.1
 */