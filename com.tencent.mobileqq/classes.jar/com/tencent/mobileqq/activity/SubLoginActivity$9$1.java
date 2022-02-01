package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;

class SubLoginActivity$9$1
  implements Runnable
{
  SubLoginActivity$9$1(SubLoginActivity.9 param9, String paramString) {}
  
  public void run()
  {
    SubAccountManager localSubAccountManager = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqActivitySubLoginActivity$9.a.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    if (localSubAccountManager != null) {
      localSubAccountManager.a(this.jdField_a_of_type_JavaLangString, 0, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubLoginActivity.9.1
 * JD-Core Version:    0.7.0.1
 */