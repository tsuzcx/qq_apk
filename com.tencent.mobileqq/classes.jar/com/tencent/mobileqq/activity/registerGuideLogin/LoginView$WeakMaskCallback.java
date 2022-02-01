package com.tencent.mobileqq.activity.registerGuideLogin;

import com.tencent.mobileqq.app.identity.LocalPhoneModule.MaskPhoneCallback;
import com.tencent.mobileqq.util.PhoneNumQuickLoginManager;
import com.tencent.mobileqq.util.QuickLoginReporter;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import tencent.im.login.GetLocalPhone.MaskPhoneData;

public class LoginView$WeakMaskCallback
  implements LocalPhoneModule.MaskPhoneCallback
{
  private final WeakReference<LoginView> a;
  private final boolean b;
  
  public LoginView$WeakMaskCallback(LoginView paramLoginView, boolean paramBoolean)
  {
    this.a = new WeakReference(paramLoginView);
    this.b = paramBoolean;
  }
  
  private boolean a()
  {
    if (this.a.get() == null)
    {
      QLog.d("LoginActivity.LoginView", 1, "curContextInvalid, fragment is null");
      return true;
    }
    return ((LoginView)this.a.get()).m() ^ true;
  }
  
  public void a(int paramInt, Exception paramException)
  {
    QLog.e("LoginActivity.LoginView", 1, new Object[] { "getMaskPhoneNum error : ", Integer.valueOf(paramInt), " exception : ", paramException, " userClick: ", Boolean.valueOf(this.b) });
    if (a())
    {
      QLog.d("LoginActivity.LoginView", 1, "onException, current context invalid");
      return;
    }
    QuickLoginReporter.a(paramInt, paramException.getMessage());
    paramException = (LoginView)this.a.get();
    LoginView.h(paramException, false);
    paramException.b(4);
    if (!this.b) {
      return;
    }
    PhoneNumQuickLoginManager.a(paramException.b, LoginView.B(paramException));
  }
  
  public void a(GetLocalPhone.MaskPhoneData paramMaskPhoneData)
  {
    if (a())
    {
      QLog.d("LoginActivity.LoginView", 1, "getMaskPhoneSuccess, current context invalid");
      return;
    }
    QuickLoginReporter.a(0, "SUCCESS");
    LoginView localLoginView = (LoginView)this.a.get();
    localLoginView.b(4);
    LoginView.a(localLoginView, paramMaskPhoneData);
    LoginView.h(localLoginView, false);
    if ((!this.b) && (localLoginView.B)) {
      return;
    }
    localLoginView.a(paramMaskPhoneData, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.WeakMaskCallback
 * JD-Core Version:    0.7.0.1
 */