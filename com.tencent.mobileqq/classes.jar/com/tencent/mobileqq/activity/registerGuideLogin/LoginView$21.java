package com.tencent.mobileqq.activity.registerGuideLogin;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.util.PhoneNumQuickLoginManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LoginView$21
  implements View.OnClickListener
{
  LoginView$21(LoginView paramLoginView) {}
  
  public void onClick(View paramView)
  {
    this.a.b.showDialog(4);
    PhoneNumQuickLoginManager.a(this.a.b, this.a.a, LoginView.B(this.a), this.a.K);
    PhoneNumQuickLoginManager.b("0X800B8CD");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.21
 * JD-Core Version:    0.7.0.1
 */