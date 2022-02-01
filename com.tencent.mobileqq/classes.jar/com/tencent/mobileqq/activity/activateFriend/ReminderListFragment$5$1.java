package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsDelMsgRsp;
import Wallet.AcsMsg;
import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.statistics.ReportController;

class ReminderListFragment$5$1
  implements Runnable
{
  ReminderListFragment$5$1(ReminderListFragment.5 param5, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 2001)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        AcsDelMsgRsp localAcsDelMsgRsp = (AcsDelMsgRsp)this.jdField_a_of_type_AndroidOsBundle.getSerializable("rsp");
        if ((localAcsDelMsgRsp != null) && (localAcsDelMsgRsp.ret_code == 0))
        {
          ReportController.b(ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment$5.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment), "P_CliOper", "QQnotice", "", "", "QQnotice.set.delete", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment$5.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment$5.jdField_a_of_type_WalletAcsMsg.msg_id);
          ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment$5.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment).a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment$5.jdField_a_of_type_JavaLangString);
          ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment$5.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment).deleteReminderByMsgId(QQNotifyHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment$5.jdField_a_of_type_WalletAcsMsg), new ReminderListFragment.5.1.1(this));
          return;
        }
        ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment$5.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, HardCodeUtil.a(2131713301));
        return;
      }
      ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment$5.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, HardCodeUtil.a(2131713298));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.5.1
 * JD-Core Version:    0.7.0.1
 */