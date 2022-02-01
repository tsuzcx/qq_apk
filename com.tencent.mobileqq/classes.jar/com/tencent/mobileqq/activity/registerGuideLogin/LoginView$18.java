package com.tencent.mobileqq.activity.registerGuideLogin;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mSizeChangeOpenUpdateRunnable isArrowUP = ");
      ((StringBuilder)localObject).append(LoginView.b(this.this$0));
      ((StringBuilder)localObject).append(" isScrolled = ");
      ((StringBuilder)localObject).append(LoginView.c(this.this$0));
      ((StringBuilder)localObject).append(" isDestroyed:");
      ((StringBuilder)localObject).append(LoginView.d(this.this$0));
      ((StringBuilder)localObject).append(" currentH:");
      ((StringBuilder)localObject).append(j);
      QLog.d("LoginActivity.LoginView", 2, ((StringBuilder)localObject).toString());
    }
    if ((LoginView.e(this.this$0)) || (LoginView.f(this.this$0)) || (LoginView.g(this.this$0)) || (LoginView.h(this.this$0))) {
      LoginView.b(this.this$0).setVisibility(8);
    }
    Object localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)(LoginView.a(this.this$0) * 13.0F + 0.5F), 0, 0);
    if (LoginView.i(this.this$0)) {
      i = 2131374695;
    } else {
      i = 2131370450;
    }
    ((RelativeLayout.LayoutParams)localObject).addRule(3, i);
    this.this$0.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (LoginView.i(this.this$0))
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)(LoginView.a(this.this$0) * 13.0F + 0.5F), 0, (int)(LoginView.a(this.this$0) * 9.0F + 0.5F));
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131370450);
      ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
      LoginView.a(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int i = (int)(LoginView.a(this.this$0) * 35.0F);
    int k = LoginView.a(this.this$0) - i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mSizeChangeOpenUpdateRunnable bottomLine");
      ((StringBuilder)localObject).append(LoginView.a(this.this$0));
      ((StringBuilder)localObject).append(" mLoginHelpLayout.bottom:");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(" curH:");
      ((StringBuilder)localObject).append(j);
      QLog.d("LoginActivity.LoginView", 2, ((StringBuilder)localObject).toString());
    }
    if (k > j)
    {
      if (!this.this$0.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow())
      {
        i = LoginView.a(this.this$0);
        k = (int)(LoginView.a(this.this$0) * 5.0F);
        localObject = this.this$0;
        LoginView.b((LoginView)localObject, ((LoginView)localObject).e.getScrollY());
        LoginView.c(this.this$0, i - j + k);
        localObject = this.this$0;
        LoginView.d((LoginView)localObject, LoginView.a((LoginView)localObject).topMargin);
        localObject = this.this$0;
        LoginView.e((LoginView)localObject, (int)(LoginView.a((LoginView)localObject) * 24.0F + 0.5F));
        localObject = this.this$0;
        LoginView.f((LoginView)localObject, LoginView.b((LoginView)localObject).topMargin);
        localObject = this.this$0;
        LoginView.g((LoginView)localObject, (int)(LoginView.a((LoginView)localObject) * 25.0F + 0.5F));
        localObject = this.this$0;
        LoginView.h((LoginView)localObject, LoginView.c((LoginView)localObject).topMargin);
        localObject = this.this$0;
        LoginView.i((LoginView)localObject, (int)(LoginView.a((LoginView)localObject) * 148.0F + 0.5F));
        LoginView.d(this.this$0, true);
        LoginView.b(this.this$0);
        if (LoginView.a(this.this$0).isRunning()) {
          LoginView.a(this.this$0).cancel();
        }
        if ((this.this$0.getQBaseActivity() != null) && ((LiuHaiUtils.b(this.this$0.getQBaseActivity())) || (LiuHaiUtils.a()))) {
          i = 40;
        } else {
          i = 0;
        }
        if (LoginView.d(this.this$0) < LoginView.b(this.this$0) + (int)((i + 12) * LoginView.a(this.this$0) + 0.5F)) {
          LoginView.e(this.this$0, true);
        } else {
          LoginView.e(this.this$0, false);
        }
        LoginView.f(this.this$0, true);
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.d();
        LoginView.c(this.this$0, true);
        LoginView.a(this.this$0).start();
      }
    }
    else
    {
      this.this$0.e.scrollTo(0, i);
      LoginView.d(this.this$0, true);
      LoginView.c(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.18
 * JD-Core Version:    0.7.0.1
 */