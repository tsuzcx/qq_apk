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
    LoginView.c(this.a);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    LoginView.a(this.a, paramCharSequence.toString());
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null)
    {
      paramCharSequence = paramCharSequence.toString();
      if ((paramCharSequence != null) && (LoginView.a(this.a) != null) && (LoginView.a(this.a).length() != paramCharSequence.length()) && (paramInt3 != 0)) {
        MobileQQ.sMobileQQ.refreAccountList();
      }
      LoginView.a(this.a, null);
      if ((LoginView.a(this.a) == null) || (LoginView.a(this.a).length() == 0)) {}
      do
      {
        return;
        if ((paramCharSequence == null) || (paramCharSequence.length() == 0) || (paramCharSequence.length() != LoginView.a(this.a).length() + 1))
        {
          MobileQQ.sMobileQQ.refreAccountList();
          return;
        }
        if ((!paramCharSequence.startsWith(LoginView.a(this.a))) || (this.a.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText == null)) {
          break;
        }
        paramCharSequence = paramCharSequence.substring(LoginView.a(this.a).length());
      } while ((paramCharSequence == null) || (paramCharSequence.length() != 1));
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setText(paramCharSequence);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setSelection(1);
      LoginView.c(this.a);
    }
    LoginView.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.26
 * JD-Core Version:    0.7.0.1
 */