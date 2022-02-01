package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class AccountIdentityManager$3
  implements View.OnClickListener
{
  AccountIdentityManager$3(AccountIdentityManager paramAccountIdentityManager, boolean paramBoolean, Activity paramActivity, AppRuntime paramAppRuntime) {}
  
  public void onClick(View paramView)
  {
    AccountIdentityManager.a(this.jdField_a_of_type_ComTencentMobileqqAppIdentityAccountIdentityManager).dismiss();
    if (this.jdField_a_of_type_Boolean) {
      ((ILoginRegisterApi)QRoute.api(ILoginRegisterApi.class)).logout(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_MqqAppAppRuntime, true);
    }
    String str;
    if (this.jdField_a_of_type_Boolean) {
      str = "0X800B276";
    } else {
      str = "0X800B273";
    }
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.AccountIdentityManager.3
 * JD-Core Version:    0.7.0.1
 */