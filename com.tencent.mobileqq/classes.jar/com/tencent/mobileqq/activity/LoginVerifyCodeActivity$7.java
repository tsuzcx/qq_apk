package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.widget.EditText;
import bbbd;

class LoginVerifyCodeActivity$7
  implements Runnable
{
  LoginVerifyCodeActivity$7(LoginVerifyCodeActivity paramLoginVerifyCodeActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    int k = 0;
    String str = bbbd.b(this.a, this.b);
    if ((str != null) && (str.length() == 6) && (LoginVerifyCodeActivity.a(this.this$0) != null) && (!str.equals(LoginVerifyCodeActivity.b(this.this$0))))
    {
      LoginVerifyCodeActivity.a(this.this$0, str);
      int m = 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity.7
 * JD-Core Version:    0.7.0.1
 */