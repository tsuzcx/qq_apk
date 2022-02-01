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
    if (this.a.w != null)
    {
      LoginView.a(this.a, null);
      return;
    }
    if (paramCharSequence == null) {
      return;
    }
    String str = paramCharSequence.toString();
    if (str != null)
    {
      if (str.length() == 0) {
        return;
      }
      if (this.a.v != null)
      {
        paramInt1 = 0;
        while (paramInt1 < this.a.v.size())
        {
          SimpleAccount localSimpleAccount = (SimpleAccount)this.a.v.get(paramInt1);
          if ((localSimpleAccount != null) && (localSimpleAccount.getUin() != null))
          {
            if (this.a.a == null) {
              paramCharSequence = localSimpleAccount.getUin();
            } else {
              paramCharSequence = LoginUtils.a(localSimpleAccount.getUin());
            }
            if (str.equals(paramCharSequence))
            {
              if ((localSimpleAccount != null) && (localSimpleAccount.isLogined()))
              {
                if (!LoginView.E(this.a))
                {
                  LoginView.g(this.a, true);
                  this.a.h.setTransformationMethod(PasswordTransformationMethod.getInstance());
                  paramCharSequence = this.a.j;
                  if ((!LoginView.r(this.a)) && (!LoginView.s(this.a)) && (!this.a.z) && (!LoginView.t(this.a))) {
                    paramInt1 = 2130846063;
                  } else {
                    paramInt1 = 2130848790;
                  }
                  paramCharSequence.setImageResource(paramInt1);
                  this.a.j.setContentDescription(HardCodeUtil.a(2131904276));
                }
                this.a.h.setText("!@#ewaGbhkc$!!=");
                this.a.w = localSimpleAccount;
              }
              this.a.b();
              this.a.h.setClearButtonVisible(false);
              return;
            }
          }
          paramInt1 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.27
 * JD-Core Version:    0.7.0.1
 */