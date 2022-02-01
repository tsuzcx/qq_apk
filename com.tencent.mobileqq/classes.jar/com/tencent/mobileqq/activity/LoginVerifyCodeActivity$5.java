package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.VerifyCodeView;
import com.tencent.qphone.base.util.QLog;

class LoginVerifyCodeActivity$5
  implements Runnable
{
  LoginVerifyCodeActivity$5(LoginVerifyCodeActivity paramLoginVerifyCodeActivity) {}
  
  public void run()
  {
    QLog.d("LoginVerifyCodeActivity", 1, "identifying code auto-fill start");
    String str = Utils.b(LoginVerifyCodeActivity.o(this.this$0), LoginVerifyCodeActivity.p(this.this$0));
    if ((str != null) && (str.length() == 6) && (LoginVerifyCodeActivity.g(this.this$0) != null))
    {
      QLog.d("LoginVerifyCodeActivity", 1, new Object[] { "get identifying code: ", str });
      if ((!str.equals(LoginVerifyCodeActivity.q(this.this$0))) && (TextUtils.isEmpty(LoginVerifyCodeActivity.g(this.this$0).getCode())))
      {
        LoginVerifyCodeActivity.a(this.this$0, str);
        LoginVerifyCodeActivity.g(this.this$0).setCode(str);
        return;
      }
      QLog.d("LoginVerifyCodeActivity", 1, "identifying code same with last one, or user already has inputs, auto-fill skipped.");
      return;
    }
    QLog.e("LoginVerifyCodeActivity", 1, "identifying code empty or invalid, auto-fill failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity.5
 * JD-Core Version:    0.7.0.1
 */