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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mSizeChangeCloseUpdateRunnable isArrowUP = ");
    ((StringBuilder)localObject).append(LoginView.o(this.this$0));
    ((StringBuilder)localObject).append(" isScrolled = ");
    ((StringBuilder)localObject).append(LoginView.p(this.this$0));
    ((StringBuilder)localObject).append(" isDestroyed:");
    ((StringBuilder)localObject).append(LoginView.q(this.this$0));
    ((StringBuilder)localObject).append(" isInMultiWindow:");
    ((StringBuilder)localObject).append(this.this$0.b.isInMultiWindow());
    QLog.d("LoginActivity.LoginView", 1, ((StringBuilder)localObject).toString());
    if (LoginView.q(this.this$0)) {
      return;
    }
    if ((LoginView.r(this.this$0)) || (LoginView.s(this.this$0)) || (this.this$0.z) || (LoginView.t(this.this$0))) {
      LoginView.u(this.this$0).setVisibility(0);
    }
    if (LoginView.p(this.this$0))
    {
      LoginView.d(this.this$0, false);
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131436896);
      this.this$0.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (LoginView.v(this.this$0))
      {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, (int)(LoginView.a(this.this$0) * 22.0F + 0.5F));
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131436933);
        ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
        LoginView.e(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = this.this$0;
      LoginView.b((LoginView)localObject, ((LoginView)localObject).o.getScrollY());
      LoginView.c(this.this$0, 0);
      localObject = this.this$0;
      LoginView.d((LoginView)localObject, LoginView.w((LoginView)localObject).topMargin);
      localObject = this.this$0;
      LoginView.e((LoginView)localObject, (int)(LoginView.a((LoginView)localObject) * 57.0F + 0.5F));
      localObject = this.this$0;
      LoginView.f((LoginView)localObject, LoginView.x((LoginView)localObject).topMargin);
      localObject = this.this$0;
      LoginView.g((LoginView)localObject, (int)(LoginView.a((LoginView)localObject) * 32.0F + 0.5F));
      localObject = this.this$0;
      LoginView.h((LoginView)localObject, LoginView.y((LoginView)localObject).topMargin);
      localObject = this.this$0;
      LoginView.i((LoginView)localObject, (int)(LoginView.a((LoginView)localObject) * 108.0F + 0.5F));
      LoginView.z(this.this$0);
      if (LoginView.A(this.this$0).isRunning()) {
        LoginView.A(this.this$0).cancel();
      }
      if ((!this.this$0.b.isInMultiWindow()) && ((this.this$0.g.getVisibility() != 0) || (this.this$0.g.getAlpha() < 0.999F))) {
        LoginView.e(this.this$0, true);
      } else {
        LoginView.e(this.this$0, false);
      }
      LoginView.f(this.this$0, false);
      this.this$0.k.d();
      LoginView.A(this.this$0).start();
      return;
    }
    if ((this.this$0.b.isInMultiWindow()) && (LoginView.v(this.this$0)))
    {
      localObject = new int[2];
      int[] arrayOfInt = new int[2];
      LoginView.e(this.this$0).getLocationOnScreen((int[])localObject);
      this.this$0.m.getLocationOnScreen(arrayOfInt);
      if (arrayOfInt[1] + this.this$0.m.getHeight() >= localObject[1])
      {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)(LoginView.a(this.this$0) * 13.0F + 0.5F), 0, (int)(LoginView.a(this.this$0) * 9.0F + 0.5F));
        ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131437718);
        ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
        LoginView.e(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.19
 * JD-Core Version:    0.7.0.1
 */