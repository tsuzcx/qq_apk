package com.tencent.mobileqq.activity.registerGuideLogin;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;

class LoginView$19
  implements Runnable
{
  LoginView$19(LoginView paramLoginView) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mSizeChangeCloseUpdateRunnable isArrowUP = ");
      ((StringBuilder)localObject).append(LoginView.b(this.this$0));
      ((StringBuilder)localObject).append(" isScrolled = ");
      ((StringBuilder)localObject).append(LoginView.c(this.this$0));
      ((StringBuilder)localObject).append(" isDestroyed:");
      ((StringBuilder)localObject).append(LoginView.d(this.this$0));
      ((StringBuilder)localObject).append(" isInMultiWindow:");
      ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow());
      QLog.d("LoginActivity.LoginView", 2, ((StringBuilder)localObject).toString());
    }
    if (LoginView.d(this.this$0)) {
      return;
    }
    if ((LoginView.e(this.this$0)) || (LoginView.f(this.this$0)) || (LoginView.g(this.this$0)) || (LoginView.h(this.this$0))) {
      LoginView.b(this.this$0).setVisibility(0);
    }
    if (LoginView.c(this.this$0))
    {
      LoginView.d(this.this$0, false);
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131369768);
      this.this$0.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (LoginView.i(this.this$0))
      {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, (int)(LoginView.a(this.this$0) * 22.0F + 0.5F));
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131369801);
        ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
        LoginView.a(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = this.this$0;
      LoginView.b((LoginView)localObject, ((LoginView)localObject).e.getScrollY());
      LoginView.c(this.this$0, 0);
      localObject = this.this$0;
      LoginView.d((LoginView)localObject, LoginView.a((LoginView)localObject).topMargin);
      localObject = this.this$0;
      LoginView.e((LoginView)localObject, (int)(LoginView.a((LoginView)localObject) * 57.0F + 0.5F));
      localObject = this.this$0;
      LoginView.f((LoginView)localObject, LoginView.b((LoginView)localObject).topMargin);
      localObject = this.this$0;
      LoginView.g((LoginView)localObject, (int)(LoginView.a((LoginView)localObject) * 32.0F + 0.5F));
      localObject = this.this$0;
      LoginView.h((LoginView)localObject, LoginView.c((LoginView)localObject).topMargin);
      localObject = this.this$0;
      LoginView.i((LoginView)localObject, (int)(LoginView.a((LoginView)localObject) * 108.0F + 0.5F));
      LoginView.b(this.this$0);
      if (LoginView.a(this.this$0).isRunning()) {
        LoginView.a(this.this$0).cancel();
      }
      if ((!this.this$0.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow()) && ((this.this$0.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) || (this.this$0.jdField_a_of_type_AndroidWidgetImageView.getAlpha() < 0.999F))) {
        LoginView.e(this.this$0, true);
      } else {
        LoginView.e(this.this$0, false);
      }
      LoginView.f(this.this$0, false);
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.d();
      LoginView.a(this.this$0).start();
      return;
    }
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow()) && (LoginView.i(this.this$0)))
    {
      localObject = new int[2];
      int[] arrayOfInt = new int[2];
      LoginView.a(this.this$0).getLocationOnScreen((int[])localObject);
      this.this$0.c.getLocationOnScreen(arrayOfInt);
      if (arrayOfInt[1] + this.this$0.c.getHeight() >= localObject[1])
      {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)(LoginView.a(this.this$0) * 13.0F + 0.5F), 0, (int)(LoginView.a(this.this$0) * 9.0F + 0.5F));
        ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131370450);
        ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
        LoginView.a(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.19
 * JD-Core Version:    0.7.0.1
 */