package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsDelMsgRsp;
import Wallet.AcsMsg;
import agci;
import agcw;
import agcx;
import agda;
import agdj;
import android.os.Bundle;
import anzj;
import bdll;

public class ReminderListFragment$5$1
  implements Runnable
{
  public ReminderListFragment$5$1(agcw paramagcw, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 2001)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label158;
      }
      AcsDelMsgRsp localAcsDelMsgRsp = (AcsDelMsgRsp)this.jdField_a_of_type_AndroidOsBundle.getSerializable("rsp");
      if ((localAcsDelMsgRsp != null) && (localAcsDelMsgRsp.ret_code == 0))
      {
        bdll.b(ReminderListFragment.a(this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment), "P_CliOper", "QQnotice", "", "", "QQnotice.set.delete", 0, 0, "", "", this.jdField_a_of_type_Agcw.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_Agcw.jdField_a_of_type_WalletAcsMsg.msg_id);
        ReminderListFragment.a(this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment).a(this.jdField_a_of_type_Agcw.jdField_a_of_type_JavaLangString);
        ReminderListFragment.a(this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment).a(agci.a(this.jdField_a_of_type_Agcw.jdField_a_of_type_WalletAcsMsg), new agcx(this));
      }
    }
    else
    {
      return;
    }
    ReminderListFragment.a(this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, anzj.a(2131712258));
    return;
    label158:
    ReminderListFragment.a(this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, anzj.a(2131712255));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.5.1
 * JD-Core Version:    0.7.0.1
 */