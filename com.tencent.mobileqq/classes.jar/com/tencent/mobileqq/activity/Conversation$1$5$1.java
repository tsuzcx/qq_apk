package com.tencent.mobileqq.activity;

import adyo;
import akyh;
import android.os.Message;
import bcst;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import mqq.os.MqqHandler;

class Conversation$1$5$1
  implements Runnable
{
  Conversation$1$5$1(Conversation.1.5 param5, UpgradeTIMWrapper paramUpgradeTIMWrapper) {}
  
  public void run()
  {
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityConversation$1$5.a.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage();
    localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper;
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation$1$5.a.a.jdField_a_of_type_Akyh.a(27, 2);
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation$1$5.a.a.jdField_a_of_type_Akyh.a(27, localMessage);
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqActivityConversation$1$5.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8008658", "0X8008658", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.1.5.1
 * JD-Core Version:    0.7.0.1
 */