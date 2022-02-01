package com.tencent.mobileqq.activity.registerGuideLogin;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.widget.PastablePwdEditText;
import mqq.app.MobileQQ;

class LoginView$26
  implements TextWatcher
{
  LoginView$26(LoginView paramLoginView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    LoginView.a(this.a, null);
    this.a.b();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    LoginView.a(this.a, paramCharSequence.toString());
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.w != null)
    {
      paramCharSequence = paramCharSequence.toString();
      if ((paramCharSequence != null) && (LoginView.D(this.a) != null) && (LoginView.D(this.a).length() != paramCharSequence.length()) && (paramInt3 != 0)) {
        MobileQQ.sMobileQQ.refreAccountList();
      }
      LoginView.a(this.a, null);
      if (LoginView.D(this.a) != null)
      {
        if (LoginView.D(this.a).length() == 0) {
          return;
        }
        if ((paramCharSequence != null) && (paramCharSequence.length() != 0) && (paramCharSequence.length() == LoginView.D(this.a).length() + 1))
        {
          if ((paramCharSequence.startsWith(LoginView.D(this.a))) && (this.a.h != null))
          {
            paramCharSequence = paramCharSequence.substring(LoginView.D(this.a).length());
            if (paramCharSequence != null)
            {
              if (paramCharSequence.length() != 1) {
                return;
              }
              this.a.h.setText(paramCharSequence);
              this.a.h.setSelection(1);
              this.a.b();
            }
          }
        }
        else {
          MobileQQ.sMobileQQ.refreAccountList();
        }
      }
      else
      {
        return;
      }
    }
    LoginView.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.26
 * JD-Core Version:    0.7.0.1
 */