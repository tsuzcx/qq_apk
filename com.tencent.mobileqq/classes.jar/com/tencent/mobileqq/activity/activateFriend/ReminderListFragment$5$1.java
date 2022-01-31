package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsDelMsgRsp;
import Wallet.AcsMsg;
import acsa;
import acsb;
import acse;
import acsn;
import ajya;
import android.os.Bundle;
import axqy;

public class ReminderListFragment$5$1
  implements Runnable
{
  public ReminderListFragment$5$1(acsa paramacsa, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
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
        axqy.b(ReminderListFragment.a(this.jdField_a_of_type_Acsa.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment), "P_CliOper", "QQnotice", "", "", "QQnotice.set.delete", 0, 0, "", "", this.jdField_a_of_type_Acsa.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_Acsa.jdField_a_of_type_WalletAcsMsg.msg_id);
        ReminderListFragment.a(this.jdField_a_of_type_Acsa.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment).a(this.jdField_a_of_type_Acsa.jdField_a_of_type_JavaLangString);
        ReminderListFragment.a(this.jdField_a_of_type_Acsa.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment).a(this.jdField_a_of_type_Acsa.jdField_a_of_type_JavaLangString, new acsb(this));
      }
    }
    else
    {
      return;
    }
    ReminderListFragment.a(this.jdField_a_of_type_Acsa.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, ajya.a(2131713386));
    return;
    label155:
    ReminderListFragment.a(this.jdField_a_of_type_Acsa.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, ajya.a(2131713383));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.5.1
 * JD-Core Version:    0.7.0.1
 */