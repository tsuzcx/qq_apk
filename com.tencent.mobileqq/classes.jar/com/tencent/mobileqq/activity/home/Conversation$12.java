package com.tencent.mobileqq.activity.home;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.UpgradeTIMManager;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import mqq.app.AppRuntime;

class Conversation$12
  implements DialogInterface.OnClickListener
{
  Conversation$12(Conversation paramConversation, UpgradeTIMWrapper paramUpgradeTIMWrapper) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Conversation.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation, null);
    ((UpgradeTIMManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a.getManager(QQManagerFactory.TIM_UPGRADE_DOWNLOAD_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(), this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper.c);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a, "CliOper", "", "", "0X800815D", "0X800815D", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a, "CliOper", "", "", "0X8008657", "0X8008657", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.12
 * JD-Core Version:    0.7.0.1
 */