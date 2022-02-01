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
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "mSizeChangeCloseUpdateRunnable isArrowUP = " + LoginView.b(this.this$0) + " isScrolled = " + LoginView.c(this.this$0) + " isDestroyed:" + LoginView.d(this.this$0) + " isInMultiWindow:" + this.this$0.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow());
    }
    if (LoginView.d(this.this$0)) {}
    int[] arrayOfInt;
    do
    {
      do
      {
        return;
        if ((LoginView.e(this.this$0)) || (LoginView.f(this.this$0)) || (LoginView.g(this.this$0)) || (LoginView.h(this.this$0))) {
          LoginView.b(this.this$0).setVisibility(0);
        }
        if (LoginView.c(this.this$0))
        {
          LoginView.d(this.this$0, false);
          localObject = new RelativeLayout.LayoutParams(-1, -2);
          ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
          ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131370090);
          this.this$0.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
          if (LoginView.i(this.this$0))
          {
            localObject = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, (int)(22.0F * LoginView.a(this.this$0) + 0.5F));
            ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131370130);
            ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
            LoginView.a(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
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
          if ((!this.this$0.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow()) && ((this.this$0.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) || (this.this$0.jdField_a_of_type_AndroidWidgetImageView.getAlpha() < 0.999F))) {
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
      } while ((!this.this$0.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow()) || (!LoginView.i(this.this$0)));
      localObject = new int[2];
      arrayOfInt = new int[2];
      LoginView.a(this.this$0).getLocationOnScreen((int[])localObject);
      this.this$0.c.getLocationOnScreen(arrayOfInt);
    } while (arrayOfInt[1] + this.this$0.c.getHeight() < localObject[1]);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)(13.0F * LoginView.a(this.this$0) + 0.5F), 0, (int)(9.0F * LoginView.a(this.this$0) + 0.5F));
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131370819);
    ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
    LoginView.a(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.19
 * JD-Core Version:    0.7.0.1
 */