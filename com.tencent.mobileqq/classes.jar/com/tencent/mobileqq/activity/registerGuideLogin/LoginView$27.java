package com.tencent.mobileqq.activity.registerGuideLogin;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.widget.ImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.widget.PastablePwdEditText;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

class LoginView$27
  implements TextWatcher
{
  LoginView$27(LoginView paramLoginView) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null) {
      LoginView.a(this.a, null);
    }
    String str;
    SimpleAccount localSimpleAccount;
    for (;;)
    {
      return;
      if (paramCharSequence != null)
      {
        str = paramCharSequence.toString();
        if ((str == null) || (str.length() == 0) || (this.a.jdField_a_of_type_JavaUtilList == null)) {
          break;
        }
        paramInt1 = 0;
        while (paramInt1 < this.a.jdField_a_of_type_JavaUtilList.size())
        {
          localSimpleAccount = (SimpleAccount)this.a.jdField_a_of_type_JavaUtilList.get(paramInt1);
          if ((localSimpleAccount != null) && (localSimpleAccount.getUin() != null)) {
            break label110;
          }
          paramInt1 += 1;
        }
      }
    }
    label110:
    if (this.a.jdField_a_of_type_MqqAppAppRuntime == null)
    {
      paramCharSequence = localSimpleAccount.getUin();
      label126:
      if (!str.equals(paramCharSequence)) {
        break label301;
      }
      if ((localSimpleAccount != null) && (localSimpleAccount.isLogined())) {
        if (!LoginView.j(this.a))
        {
          LoginView.g(this.a, true);
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
          paramCharSequence = this.a.c;
          if ((!LoginView.e(this.a)) && (!LoginView.f(this.a)) && (!LoginView.g(this.a)) && (!LoginView.h(this.a))) {
            break label303;
          }
        }
      }
    }
    label301:
    label303:
    for (paramInt1 = 2130847341;; paramInt1 = 2130844814)
    {
      paramCharSequence.setImageResource(paramInt1);
      this.a.c.setContentDescription(HardCodeUtil.a(2131706366));
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setText("!@#ewaGbhkc$!!=");
      this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = localSimpleAccount;
      LoginView.c(this.a);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setClearButtonVisible(false);
      return;
      paramCharSequence = LoginUtils.a(localSimpleAccount.getUin());
      break label126;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.27
 * JD-Core Version:    0.7.0.1
 */