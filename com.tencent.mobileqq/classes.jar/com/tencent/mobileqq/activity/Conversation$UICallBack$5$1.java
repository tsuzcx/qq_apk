package com.tencent.mobileqq.activity;

import aejr;
import aljw;
import android.os.Message;
import bdll;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import mqq.os.MqqHandler;

class Conversation$UICallBack$5$1
  implements Runnable
{
  Conversation$UICallBack$5$1(Conversation.UICallBack.5 param5, UpgradeTIMWrapper paramUpgradeTIMWrapper) {}
  
  public void run()
  {
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityConversation$UICallBack$5.a.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage();
    localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper;
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation$UICallBack$5.a.a.jdField_a_of_type_Aljw.a(27, 2);
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation$UICallBack$5.a.a.jdField_a_of_type_Aljw.a(27, localMessage);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityConversation$UICallBack$5.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8008658", "0X8008658", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.UICallBack.5.1
 * JD-Core Version:    0.7.0.1
 */