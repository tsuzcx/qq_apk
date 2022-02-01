package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsDelMsgRsp;
import Wallet.AcsMsg;
import aevc;
import aevq;
import aevr;
import aevu;
import aewd;
import amtj;
import android.os.Bundle;
import bcef;

public class ReminderListFragment$5$1
  implements Runnable
{
  public ReminderListFragment$5$1(aevq paramaevq, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
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
        bcef.b(ReminderListFragment.a(this.jdField_a_of_type_Aevq.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment), "P_CliOper", "QQnotice", "", "", "QQnotice.set.delete", 0, 0, "", "", this.jdField_a_of_type_Aevq.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_Aevq.jdField_a_of_type_WalletAcsMsg.msg_id);
        ReminderListFragment.a(this.jdField_a_of_type_Aevq.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment).a(this.jdField_a_of_type_Aevq.jdField_a_of_type_JavaLangString);
        ReminderListFragment.a(this.jdField_a_of_type_Aevq.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment).a(aevc.a(this.jdField_a_of_type_Aevq.jdField_a_of_type_WalletAcsMsg), new aevr(this));
      }
    }
    else
    {
      return;
    }
    ReminderListFragment.a(this.jdField_a_of_type_Aevq.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, amtj.a(2131712490));
    return;
    label158:
    ReminderListFragment.a(this.jdField_a_of_type_Aevq.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, amtj.a(2131712487));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.5.1
 * JD-Core Version:    0.7.0.1
 */