package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.widget.EditText;
import bhbx;

class RegisterVerifyCodeActivity$4
  implements Runnable
{
  RegisterVerifyCodeActivity$4(RegisterVerifyCodeActivity paramRegisterVerifyCodeActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    int j = 0;
    String str = bhbx.a(this.a, this.b);
    if ((str != null) && (str.length() == 6) && (RegisterVerifyCodeActivity.a(this.this$0) != null) && (!str.equals(RegisterVerifyCodeActivity.a(this.this$0))))
    {
      RegisterVerifyCodeActivity.e(this.this$0, str);
      i = 0;
      if (i >= 6) {
        break label160;
      }
      Editable localEditable = RegisterVerifyCodeActivity.a(this.this$0)[i].getText();
      if ((localEditable == null) || (localEditable.toString().length() <= 0)) {}
    }
    label160:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        i = j;
        for (;;)
        {
          if (i < 6)
          {
            RegisterVerifyCodeActivity.a(this.this$0)[i].setText(str.substring(i, i + 1));
            i += 1;
            continue;
            i += 1;
            break;
          }
        }
        RegisterVerifyCodeActivity.a(this.this$0)[5].setSelection(1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterVerifyCodeActivity.4
 * JD-Core Version:    0.7.0.1
 */