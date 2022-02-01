package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsDelMsgRsp;
import Wallet.AcsMsg;
import afmn;
import afmx;
import android.os.Bundle;

public class ReminderCardItemPage$2$1
  implements Runnable
{
  public ReminderCardItemPage$2$1(afmx paramafmx, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Afmx.a.a.mn_appid == 0) {}
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
        afmn.a(ReminderCardItemPage.a(this.jdField_a_of_type_Afmx.a), -1, i);
      }
      return;
    }
    int j = localAcsDelMsgRsp.ret_code;
    afmn.a(ReminderCardItemPage.a(this.jdField_a_of_type_Afmx.a), j, i);
    return;
    label94:
    afmn.a(ReminderCardItemPage.a(this.jdField_a_of_type_Afmx.a), -1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderCardItemPage.2.1
 * JD-Core Version:    0.7.0.1
 */