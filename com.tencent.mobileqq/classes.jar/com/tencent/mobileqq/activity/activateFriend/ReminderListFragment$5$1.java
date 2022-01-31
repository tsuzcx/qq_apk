package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsDelMsgRsp;
import Wallet.AcsMsg;
import achp;
import achq;
import acht;
import acic;
import ajjy;
import android.os.Bundle;
import awqx;

public class ReminderListFragment$5$1
  implements Runnable
{
  public ReminderListFragment$5$1(achp paramachp, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
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
        awqx.b(ReminderListFragment.a(this.jdField_a_of_type_Achp.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment), "P_CliOper", "QQnotice", "", "", "QQnotice.set.delete", 0, 0, "", "", this.jdField_a_of_type_Achp.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_Achp.jdField_a_of_type_WalletAcsMsg.msg_id);
        ReminderListFragment.a(this.jdField_a_of_type_Achp.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment).a(this.jdField_a_of_type_Achp.jdField_a_of_type_JavaLangString);
        ReminderListFragment.a(this.jdField_a_of_type_Achp.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment).a(this.jdField_a_of_type_Achp.jdField_a_of_type_JavaLangString, new achq(this));
      }
    }
    else
    {
      return;
    }
    ReminderListFragment.a(this.jdField_a_of_type_Achp.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, ajjy.a(2131647587));
    return;
    label155:
    ReminderListFragment.a(this.jdField_a_of_type_Achp.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, ajjy.a(2131647584));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.5.1
 * JD-Core Version:    0.7.0.1
 */