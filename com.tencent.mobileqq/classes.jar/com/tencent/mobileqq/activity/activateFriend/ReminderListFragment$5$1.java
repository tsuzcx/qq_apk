package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsDelMsgRsp;
import Wallet.AcsMsg;
import afmn;
import afnb;
import afnc;
import afnf;
import afno;
import android.os.Bundle;
import anvx;
import bdla;

public class ReminderListFragment$5$1
  implements Runnable
{
  public ReminderListFragment$5$1(afnb paramafnb, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
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
        bdla.b(ReminderListFragment.a(this.jdField_a_of_type_Afnb.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment), "P_CliOper", "QQnotice", "", "", "QQnotice.set.delete", 0, 0, "", "", this.jdField_a_of_type_Afnb.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_Afnb.jdField_a_of_type_WalletAcsMsg.msg_id);
        ReminderListFragment.a(this.jdField_a_of_type_Afnb.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment).a(this.jdField_a_of_type_Afnb.jdField_a_of_type_JavaLangString);
        ReminderListFragment.a(this.jdField_a_of_type_Afnb.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment).a(afmn.a(this.jdField_a_of_type_Afnb.jdField_a_of_type_WalletAcsMsg), new afnc(this));
      }
    }
    else
    {
      return;
    }
    ReminderListFragment.a(this.jdField_a_of_type_Afnb.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, anvx.a(2131712837));
    return;
    label158:
    ReminderListFragment.a(this.jdField_a_of_type_Afnb.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, anvx.a(2131712834));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.5.1
 * JD-Core Version:    0.7.0.1
 */