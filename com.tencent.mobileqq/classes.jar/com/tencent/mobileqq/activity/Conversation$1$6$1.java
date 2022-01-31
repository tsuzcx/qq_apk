package com.tencent.mobileqq.activity;

import acrh;
import ajgb;
import android.os.Message;
import azqs;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMWrapper;
import mqq.os.MqqHandler;

class Conversation$1$6$1
  implements Runnable
{
  Conversation$1$6$1(Conversation.1.6 param6, UpgradeTIMWrapper paramUpgradeTIMWrapper) {}
  
  public void run()
  {
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityConversation$1$6.a.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage();
    localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeTIMWrapper;
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation$1$6.a.a.jdField_a_of_type_Ajgb.a(26, 2);
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation$1$6.a.a.jdField_a_of_type_Ajgb.a(26, localMessage);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityConversation$1$6.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8008658", "0X8008658", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.1.6.1
 * JD-Core Version:    0.7.0.1
 */