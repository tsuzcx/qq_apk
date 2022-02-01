package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.VerifyCodeView;
import com.tencent.qphone.base.util.QLog;

class RegisterVerifyCodeActivity$4
  implements Runnable
{
  RegisterVerifyCodeActivity$4(RegisterVerifyCodeActivity paramRegisterVerifyCodeActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    QLog.d("RegisterVerifyCodeActivity", 1, "identifying code auto-fill start");
    String str = Utils.a(this.a, this.b);
    if ((str != null) && (str.length() == 6) && (RegisterVerifyCodeActivity.a(this.this$0) != null))
    {
      QLog.d("RegisterVerifyCodeActivity", 1, new Object[] { "get identifying code: ", str });
      if (!str.equals(RegisterVerifyCodeActivity.a(this.this$0)))
      {
        if (!TextUtils.isEmpty(RegisterVerifyCodeActivity.a(this.this$0).a())) {
          return;
        }
        RegisterVerifyCodeActivity.b(this.this$0, str);
        RegisterVerifyCodeActivity.a(this.this$0).setCode(str);
      }
      return;
    }
    QLog.e("RegisterVerifyCodeActivity", 1, "identifying code empty or invalid, auto-fill failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterVerifyCodeActivity.4
 * JD-Core Version:    0.7.0.1
 */