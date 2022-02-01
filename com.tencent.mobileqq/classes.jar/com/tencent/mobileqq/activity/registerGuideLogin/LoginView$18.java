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
    int j = LoginView.n(this.this$0);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mSizeChangeOpenUpdateRunnable isArrowUP = ");
    ((StringBuilder)localObject).append(LoginView.o(this.this$0));
    ((StringBuilder)localObject).append(" isScrolled = ");
    ((StringBuilder)localObject).append(LoginView.p(this.this$0));
    ((StringBuilder)localObject).append(" isDestroyed:");
    ((StringBuilder)localObject).append(LoginView.q(this.this$0));
    ((StringBuilder)localObject).append(" currentH:");
    ((StringBuilder)localObject).append(j);
    QLog.d("LoginActivity.LoginView", 1, ((StringBuilder)localObject).toString());
    if ((LoginView.r(this.this$0)) || (LoginView.s(this.this$0)) || (this.this$0.z) || (LoginView.t(this.this$0))) {
      LoginView.u(this.this$0).setVisibility(8);
    }
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)(LoginView.a(this.this$0) * 13.0F + 0.5F), 0, 0);
    if (LoginView.v(this.this$0)) {
      i = 2131442877;
    } else {
      i = 2131437718;
    }
    ((RelativeLayout.LayoutParams)localObject).addRule(3, i);
    this.this$0.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (LoginView.v(this.this$0))
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)(LoginView.a(this.this$0) * 13.0F + 0.5F), 0, (int)(LoginView.a(this.this$0) * 9.0F + 0.5F));
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131437718);
      ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
      LoginView.e(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int i = (int)(LoginView.a(this.this$0) * 35.0F);
    int k = LoginView.b(this.this$0) - i;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mSizeChangeOpenUpdateRunnable bottomLine");
    ((StringBuilder)localObject).append(LoginView.b(this.this$0));
    ((StringBuilder)localObject).append(" mLoginHelpLayout.bottom:");
    ((StringBuilder)localObject).append(k);
    ((StringBuilder)localObject).append(" curH:");
    ((StringBuilder)localObject).append(j);
    QLog.d("LoginActivity.LoginView", 1, ((StringBuilder)localObject).toString());
    if (k > j)
    {
      if (!this.this$0.b.isInMultiWindow())
      {
        i = LoginView.b(this.this$0);
        k = (int)(LoginView.a(this.this$0) * 5.0F);
        localObject = this.this$0;
        LoginView.b((LoginView)localObject, ((LoginView)localObject).o.getScrollY());
        LoginView.c(this.this$0, i - j + k);
        localObject = this.this$0;
        LoginView.d((LoginView)localObject, LoginView.w((LoginView)localObject).topMargin);
        localObject = this.this$0;
        LoginView.e((LoginView)localObject, (int)(LoginView.a((LoginView)localObject) * 24.0F + 0.5F));
        localObject = this.this$0;
        LoginView.f((LoginView)localObject, LoginView.x((LoginView)localObject).topMargin);
        localObject = this.this$0;
        LoginView.g((LoginView)localObject, (int)(LoginView.a((LoginView)localObject) * 25.0F + 0.5F));
        localObject = this.this$0;
        LoginView.h((LoginView)localObject, LoginView.y((LoginView)localObject).topMargin);
        localObject = this.this$0;
        LoginView.i((LoginView)localObject, (int)(LoginView.a((LoginView)localObject) * 148.0F + 0.5F));
        LoginView.d(this.this$0, true);
        LoginView.z(this.this$0);
        if (LoginView.A(this.this$0).isRunning()) {
          LoginView.A(this.this$0).cancel();
        }
        if ((this.this$0.getQBaseActivity() != null) && ((LiuHaiUtils.b(this.this$0.getQBaseActivity())) || (LiuHaiUtils.a()))) {
          i = 40;
        } else {
          i = 0;
        }
        if (LoginView.h(this.this$0) < LoginView.f(this.this$0) + (int)((i + 12) * LoginView.a(this.this$0) + 0.5F)) {
          LoginView.e(this.this$0, true);
        } else {
          LoginView.e(this.this$0, false);
        }
        LoginView.f(this.this$0, true);
        this.this$0.k.d();
        LoginView.c(this.this$0, true);
        LoginView.A(this.this$0).start();
      }
    }
    else
    {
      this.this$0.o.scrollTo(0, i);
      LoginView.d(this.this$0, true);
      LoginView.c(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.18
 * JD-Core Version:    0.7.0.1
 */