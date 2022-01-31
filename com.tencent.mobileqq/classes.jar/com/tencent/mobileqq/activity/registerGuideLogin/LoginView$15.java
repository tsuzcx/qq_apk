package com.tencent.mobileqq.activity.registerGuideLogin;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import bjeh;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

class LoginView$15
  implements Runnable
{
  LoginView$15(LoginView paramLoginView) {}
  
  public void run()
  {
    int i = LoginView.j(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "mSizeChangeOpenUpdateRunnable isArrowUP = " + LoginView.a(this.this$0) + " isScrolled = " + LoginView.b(this.this$0) + " isDestroyed:" + LoginView.c(this.this$0) + " current_H:" + i);
    }
    if ((LoginView.d(this.this$0)) || (LoginView.e(this.this$0)) || (LoginView.f(this.this$0))) {
      LoginView.a(this.this$0).setVisibility(8);
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(7, 2131303263);
    localLayoutParams.addRule(5, 2131303263);
    localLayoutParams.setMargins(0, (int)(13.0F * LoginView.a(this.this$0) + 0.5F), 0, 0);
    localLayoutParams.addRule(3, 2131303889);
    this.this$0.b.setLayoutParams(localLayoutParams);
    int j = (int)(35.0F * LoginView.a(this.this$0));
    int k = LoginView.a(this.this$0) - j;
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "mSizeChangeOpenUpdateRunnable bottomLine" + LoginView.a(this.this$0) + " mLoginHelpLayout.bottom:" + k + " curH:" + i);
    }
    if (k > i) {
      if (!this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow())
      {
        j = LoginView.a(this.this$0);
        k = (int)(5.0F * LoginView.a(this.this$0));
        LoginView.b(this.this$0, this.this$0.e.getScrollY());
        LoginView.c(this.this$0, j - i + k);
        LoginView.d(this.this$0, LoginView.a(this.this$0).topMargin);
        LoginView.e(this.this$0, (int)(24.0F * LoginView.a(this.this$0) + 0.5F));
        LoginView.f(this.this$0, LoginView.b(this.this$0).topMargin);
        LoginView.g(this.this$0, (int)(25.0F * LoginView.a(this.this$0) + 0.5F));
        LoginView.h(this.this$0, LoginView.c(this.this$0).topMargin);
        LoginView.i(this.this$0, (int)(148.0F * LoginView.a(this.this$0) + 0.5F));
        LoginView.c(this.this$0, true);
        LoginView.b(this.this$0);
        if (LoginView.a(this.this$0).isRunning()) {
          LoginView.a(this.this$0).cancel();
        }
        if ((this.this$0.getActivity() == null) || ((!ImmersiveUtils.a(this.this$0.getActivity())) && (!bjeh.a()))) {
          break label655;
        }
      }
    }
    label655:
    for (i = 40;; i = 0)
    {
      j = LoginView.d(this.this$0);
      k = LoginView.b(this.this$0);
      if (j < (int)((i + 12) * LoginView.a(this.this$0) + 0.5F) + k) {
        LoginView.d(this.this$0, true);
      }
      for (;;)
      {
        LoginView.e(this.this$0, true);
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.d();
        LoginView.b(this.this$0, true);
        LoginView.a(this.this$0).start();
        return;
        LoginView.d(this.this$0, false);
      }
      this.this$0.e.scrollTo(0, j);
      LoginView.c(this.this$0, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.15
 * JD-Core Version:    0.7.0.1
 */