package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

class LoginVerifyCodeActivity$5
  implements Runnable
{
  LoginVerifyCodeActivity$5(LoginVerifyCodeActivity paramLoginVerifyCodeActivity) {}
  
  public void run()
  {
    int m = 1;
    int k = 0;
    QLog.d("LoginVerifyCodeActivity", 1, "start input code auto");
    String str = Utils.b(LoginVerifyCodeActivity.b(this.this$0), LoginVerifyCodeActivity.c(this.this$0));
    if ((str != null) && (str.length() == 6) && (LoginVerifyCodeActivity.a(this.this$0) != null))
    {
      QLog.d("LoginVerifyCodeActivity", 1, new Object[] { "getCode, code : ", str });
      if (!str.equals(LoginVerifyCodeActivity.d(this.this$0)))
      {
        LoginVerifyCodeActivity.a(this.this$0, str);
        int i = 0;
        for (;;)
        {
          int j = m;
          if (i < 6)
          {
            Editable localEditable = LoginVerifyCodeActivity.a(this.this$0)[i].getText();
            if ((localEditable != null) && (localEditable.toString().length() > 0)) {
              j = 0;
            }
          }
          else
          {
            if (j == 0) {
              break;
            }
            i = k;
            while (i < 6)
            {
              LoginVerifyCodeActivity.a(this.this$0)[i].setText(str.substring(i, i + 1));
              i += 1;
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity.5
 * JD-Core Version:    0.7.0.1
 */