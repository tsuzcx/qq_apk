package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountPhoneUnityManager$6
  implements View.OnClickListener
{
  AccountPhoneUnityManager$6(AccountPhoneUnityManager paramAccountPhoneUnityManager, Activity paramActivity, boolean paramBoolean, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - AccountPhoneUnityManager.a(this.jdField_a_of_type_ComTencentMobileqqAppIdentityAccountPhoneUnityManager) < 1000L)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    AccountPhoneUnityManager.a(this.jdField_a_of_type_ComTencentMobileqqAppIdentityAccountPhoneUnityManager, System.currentTimeMillis());
    Object localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, PhoneUnityBindInfoActivity.class);
    this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
    if (this.jdField_a_of_type_Boolean) {}
    for (localObject = "0X800B3E7";; localObject = "0X800B3E4")
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.AccountPhoneUnityManager.6
 * JD-Core Version:    0.7.0.1
 */