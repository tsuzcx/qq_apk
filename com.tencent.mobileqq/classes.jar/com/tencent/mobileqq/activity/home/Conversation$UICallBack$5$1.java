package com.tencent.mobileqq.activity.home;

import android.os.Message;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import mqq.os.MqqHandler;

class Conversation$UICallBack$5$1
  implements Runnable
{
  Conversation$UICallBack$5$1(Conversation.UICallBack.5 param5, UpgradeTIMWrapper paramUpgradeTIMWrapper) {}
  
  public void run()
  {
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$UICallBack$5.a.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage();
    localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper;
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$UICallBack$5.a.a.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(29, 2, localMessage);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$UICallBack$5.a.a.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8008658", "0X8008658", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.UICallBack.5.1
 * JD-Core Version:    0.7.0.1
 */