package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountIdentityManager$4
  implements View.OnClickListener
{
  AccountIdentityManager$4(AccountIdentityManager paramAccountIdentityManager, Activity paramActivity, String paramString, boolean paramBoolean, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
    if (AccountIdentityManager.a(this.jdField_a_of_type_ComTencentMobileqqAppIdentityAccountIdentityManager) == null)
    {
      AccountIdentityManager.a(this.jdField_a_of_type_ComTencentMobileqqAppIdentityAccountIdentityManager, new AccountIdentityManager.AccountIdentityFinishReceiver(null));
      localObject = new IntentFilter("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify");
      this.jdField_a_of_type_AndroidAppActivity.registerReceiver(AccountIdentityManager.a(this.jdField_a_of_type_ComTencentMobileqqAppIdentityAccountIdentityManager), (IntentFilter)localObject);
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (localObject = "0X800B277";; localObject = "0X800B274")
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.AccountIdentityManager.4
 * JD-Core Version:    0.7.0.1
 */