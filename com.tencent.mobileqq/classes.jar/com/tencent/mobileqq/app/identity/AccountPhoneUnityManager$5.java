package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountPhoneUnityManager$5
  implements View.OnClickListener
{
  AccountPhoneUnityManager$5(AccountPhoneUnityManager paramAccountPhoneUnityManager, boolean paramBoolean, Activity paramActivity, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    AccountPhoneUnityManager.a(this.jdField_a_of_type_ComTencentMobileqqAppIdentityAccountPhoneUnityManager).dismiss();
    if (this.jdField_a_of_type_Boolean)
    {
      AccountManageActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    BannerManager.a().a(2, 2, null);
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = "0X800B3E8";; str = "0X800B3E5")
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.AccountPhoneUnityManager.5
 * JD-Core Version:    0.7.0.1
 */