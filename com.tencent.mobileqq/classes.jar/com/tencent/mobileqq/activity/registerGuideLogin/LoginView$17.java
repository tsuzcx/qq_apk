package com.tencent.mobileqq.activity.registerGuideLogin;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class LoginView$17
  implements Runnable
{
  LoginView$17(LoginView paramLoginView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "mSizeChangeCloseUpdateRunnable isArrowUP = " + LoginView.a(this.this$0) + " isScrolled = " + LoginView.b(this.this$0) + " isDestroyed:" + LoginView.c(this.this$0) + " isInMultiWindow:" + this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow());
    }
    if (LoginView.c(this.this$0)) {}
    do
    {
      return;
      if ((LoginView.d(this.this$0)) || (LoginView.e(this.this$0)) || (LoginView.f(this.this$0))) {
        LoginView.a(this.this$0).setVisibility(0);
      }
    } while (LoginView.b(this.this$0) != true);
    LoginView.d(this.this$0, false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(7, 2131369567);
    localLayoutParams.addRule(5, 2131369567);
    localLayoutParams.setMargins(0, 0, 0, 0);
    localLayoutParams.addRule(2, 2131369567);
    this.this$0.b.setLayoutParams(localLayoutParams);
    LoginView.b(this.this$0, this.this$0.e.getScrollY());
    LoginView.c(this.this$0, 0);
    LoginView.d(this.this$0, LoginView.a(this.this$0).topMargin);
    LoginView.e(this.this$0, (int)(57.0F * LoginView.a(this.this$0) + 0.5F));
    LoginView.f(this.this$0, LoginView.b(this.this$0).topMargin);
    LoginView.g(this.this$0, (int)(32.0F * LoginView.a(this.this$0) + 0.5F));
    LoginView.h(this.this$0, LoginView.c(this.this$0).topMargin);
    LoginView.i(this.this$0, (int)(108.0F * LoginView.a(this.this$0) + 0.5F));
    LoginView.b(this.this$0);
    if (LoginView.a(this.this$0).isRunning()) {
      LoginView.a(this.this$0).cancel();
    }
    if ((!this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow()) && ((this.this$0.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) || (this.this$0.jdField_a_of_type_AndroidWidgetImageView.getAlpha() < 0.999F))) {
      LoginView.e(this.this$0, true);
    }
    for (;;)
    {
      LoginView.f(this.this$0, false);
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.d();
      LoginView.a(this.this$0).start();
      return;
      LoginView.e(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.17
 * JD-Core Version:    0.7.0.1
 */