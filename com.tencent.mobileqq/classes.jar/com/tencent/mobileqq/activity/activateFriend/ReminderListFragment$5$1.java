package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsDelMsgRsp;
import Wallet.AcsMsg;
import aenz;
import aeoa;
import aeod;
import aeom;
import alud;
import android.os.Bundle;
import azqs;

public class ReminderListFragment$5$1
  implements Runnable
{
  public ReminderListFragment$5$1(aenz paramaenz, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 2001)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label155;
      }
      AcsDelMsgRsp localAcsDelMsgRsp = (AcsDelMsgRsp)this.jdField_a_of_type_AndroidOsBundle.getSerializable("rsp");
      if ((localAcsDelMsgRsp != null) && (localAcsDelMsgRsp.ret_code == 0))
      {
        azqs.b(ReminderListFragment.a(this.jdField_a_of_type_Aenz.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment), "P_CliOper", "QQnotice", "", "", "QQnotice.set.delete", 0, 0, "", "", this.jdField_a_of_type_Aenz.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_Aenz.jdField_a_of_type_WalletAcsMsg.msg_id);
        ReminderListFragment.a(this.jdField_a_of_type_Aenz.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment).a(this.jdField_a_of_type_Aenz.jdField_a_of_type_JavaLangString);
        ReminderListFragment.a(this.jdField_a_of_type_Aenz.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment).a(this.jdField_a_of_type_Aenz.jdField_a_of_type_JavaLangString, new aeoa(this));
      }
    }
    else
    {
      return;
    }
    ReminderListFragment.a(this.jdField_a_of_type_Aenz.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, alud.a(2131713770));
    return;
    label155:
    ReminderListFragment.a(this.jdField_a_of_type_Aenz.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, alud.a(2131713767));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.5.1
 * JD-Core Version:    0.7.0.1
 */