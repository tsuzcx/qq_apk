package com.tencent.mobileqq.activity.registerGuideLogin;

import com.tencent.mobileqq.app.identity.LocalPhoneModule.MaskPhoneCallback;
import com.tencent.mobileqq.util.PhoneNumQuickLoginManager;
import com.tencent.mobileqq.util.QuickLoginReporter;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import tencent.im.login.GetLocalPhone.MaskPhoneData;

class LoginView$WeakMaskCallback
  implements LocalPhoneModule.MaskPhoneCallback
{
  private final WeakReference<LoginView> jdField_a_of_type_MqqUtilWeakReference;
  private final boolean jdField_a_of_type_Boolean;
  
  public LoginView$WeakMaskCallback(LoginView paramLoginView, boolean paramBoolean)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramLoginView);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)
    {
      QLog.d("LoginActivity.LoginView", 1, "curContextInvalid, fragment is null");
      return true;
    }
    return LoginView.a((LoginView)this.jdField_a_of_type_MqqUtilWeakReference.get()) ^ true;
  }
  
  public void a(int paramInt, Exception paramException)
  {
    QLog.e("LoginActivity.LoginView", 1, new Object[] { "getMaskPhoneNum error : ", Integer.valueOf(paramInt), " exception : ", paramException, " userClick: ", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if (a())
    {
      QLog.d("LoginActivity.LoginView", 1, "onException, current context invalid");
      return;
    }
    QuickLoginReporter.a(paramInt, paramException.getMessage());
    paramException = (LoginView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    LoginView.i(paramException, false);
    LoginView.a(paramException, 4);
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    PhoneNumQuickLoginManager.a(paramException.a, LoginView.b(paramException));
  }
  
  public void a(GetLocalPhone.MaskPhoneData paramMaskPhoneData)
  {
    if (a())
    {
      QLog.d("LoginActivity.LoginView", 1, "getMaskPhoneSuccess, current context invalid");
      return;
    }
    QuickLoginReporter.a(0, "SUCCESS");
    LoginView localLoginView = (LoginView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    LoginView.a(localLoginView, 4);
    LoginView.a(localLoginView, paramMaskPhoneData);
    LoginView.i(localLoginView, false);
    if ((!this.jdField_a_of_type_Boolean) && (LoginView.l(localLoginView))) {
      return;
    }
    LoginView.a(localLoginView, paramMaskPhoneData, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.WeakMaskCallback
 * JD-Core Version:    0.7.0.1
 */