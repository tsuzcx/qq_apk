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
    this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.showDialog(4);
    PhoneNumQuickLoginManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.a.jdField_a_of_type_MqqAppAppRuntime, LoginView.b(this.a), LoginView.a(this.a));
    PhoneNumQuickLoginManager.b("0X800B8CD");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.21
 * JD-Core Version:    0.7.0.1
 */