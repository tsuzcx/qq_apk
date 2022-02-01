package com.tencent.mobileqq.activity.registerGuideLogin;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;

class LoginView$18
  implements Runnable
{
  LoginView$18(LoginView paramLoginView) {}
  
  public void run()
  {
    int j = LoginView.j(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "mSizeChangeOpenUpdateRunnable isArrowUP = " + LoginView.b(this.this$0) + " isScrolled = " + LoginView.c(this.this$0) + " isDestroyed:" + LoginView.d(this.this$0) + " current_H:" + j);
    }
    if ((LoginView.e(this.this$0)) || (LoginView.f(this.this$0)) || (LoginView.g(this.this$0)) || (LoginView.h(this.this$0))) {
      LoginView.b(this.this$0).setVisibility(8);
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(0, (int)(LoginView.a(this.this$0) * 13.0F + 0.5F), 0, 0);
    int k;
    if (LoginView.i(this.this$0))
    {
      i = 2131375180;
      localLayoutParams.addRule(3, i);
      this.this$0.b.setLayoutParams(localLayoutParams);
      if (LoginView.i(this.this$0))
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.setMargins(0, (int)(LoginView.a(this.this$0) * 13.0F + 0.5F), 0, (int)(9.0F * LoginView.a(this.this$0) + 0.5F));
        localLayoutParams.addRule(3, 2131370819);
        localLayoutParams.addRule(14, -1);
        LoginView.a(this.this$0).setLayoutParams(localLayoutParams);
      }
      i = (int)(35.0F * LoginView.a(this.this$0));
      k = LoginView.a(this.this$0) - i;
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.LoginView", 2, "mSizeChangeOpenUpdateRunnable bottomLine" + LoginView.a(this.this$0) + " mLoginHelpLayout.bottom:" + k + " curH:" + j);
      }
      if (k <= j) {
        break label730;
      }
      if (!this.this$0.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow())
      {
        i = LoginView.a(this.this$0);
        k = (int)(5.0F * LoginView.a(this.this$0));
        LoginView.b(this.this$0, this.this$0.e.getScrollY());
        LoginView.c(this.this$0, i - j + k);
        LoginView.d(this.this$0, LoginView.a(this.this$0).topMargin);
        LoginView.e(this.this$0, (int)(24.0F * LoginView.a(this.this$0) + 0.5F));
        LoginView.f(this.this$0, LoginView.b(this.this$0).topMargin);
        LoginView.g(this.this$0, (int)(25.0F * LoginView.a(this.this$0) + 0.5F));
        LoginView.h(this.this$0, LoginView.c(this.this$0).topMargin);
        LoginView.i(this.this$0, (int)(148.0F * LoginView.a(this.this$0) + 0.5F));
        LoginView.d(this.this$0, true);
        LoginView.b(this.this$0);
        if (LoginView.a(this.this$0).isRunning()) {
          LoginView.a(this.this$0).cancel();
        }
        if ((this.this$0.getActivity() == null) || ((!LiuHaiUtils.b(this.this$0.getActivity())) && (!LiuHaiUtils.a()))) {
          break label761;
        }
      }
    }
    label730:
    label761:
    for (int i = 40;; i = 0)
    {
      j = LoginView.d(this.this$0);
      k = LoginView.b(this.this$0);
      if (j < (int)((i + 12) * LoginView.a(this.this$0) + 0.5F) + k) {
        LoginView.e(this.this$0, true);
      }
      for (;;)
      {
        LoginView.f(this.this$0, true);
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.d();
        LoginView.c(this.this$0, true);
        LoginView.a(this.this$0).start();
        return;
        i = 2131370819;
        break;
        LoginView.e(this.this$0, false);
      }
      this.this$0.e.scrollTo(0, i);
      LoginView.d(this.this$0, true);
      LoginView.c(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.18
 * JD-Core Version:    0.7.0.1
 */