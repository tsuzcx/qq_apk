package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsDelMsgRsp;
import Wallet.AcsMsg;
import android.os.Bundle;

class ReminderCardItemPage$2$1
  implements Runnable
{
  ReminderCardItemPage$2$1(ReminderCardItemPage.2 param2, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderCardItemPage$2.a.a.mn_appid == 0) {}
    AcsDelMsgRsp localAcsDelMsgRsp;
    for (int i = 0;; i = 1)
    {
      if (this.jdField_a_of_type_Int == 2001)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label94;
        }
        localAcsDelMsgRsp = (AcsDelMsgRsp)this.jdField_a_of_type_AndroidOsBundle.getSerializable("rsp");
        if (localAcsDelMsgRsp != null) {
          break;
        }
        QQNotifyHelper.a(ReminderCardItemPage.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderCardItemPage$2.a), -1, i);
      }
      return;
    }
    int j = localAcsDelMsgRsp.ret_code;
    QQNotifyHelper.a(ReminderCardItemPage.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderCardItemPage$2.a), j, i);
    return;
    label94:
    QQNotifyHelper.a(ReminderCardItemPage.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderCardItemPage$2.a), -1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderCardItemPage.2.1
 * JD-Core Version:    0.7.0.1
 */