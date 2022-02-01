package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsDelMsgRsp;
import agci;
import agcs;
import android.os.Bundle;

public class ReminderCardItemPage$2$1
  implements Runnable
{
  public ReminderCardItemPage$2$1(agcs paramagcs, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    AcsDelMsgRsp localAcsDelMsgRsp;
    if (this.jdField_a_of_type_Int == 2001)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label69;
      }
      localAcsDelMsgRsp = (AcsDelMsgRsp)this.jdField_a_of_type_AndroidOsBundle.getSerializable("rsp");
      if (localAcsDelMsgRsp == null) {
        agci.a(ReminderCardItemPage.a(this.jdField_a_of_type_Agcs.a), -1);
      }
    }
    else
    {
      return;
    }
    int i = localAcsDelMsgRsp.ret_code;
    agci.a(ReminderCardItemPage.a(this.jdField_a_of_type_Agcs.a), i);
    return;
    label69:
    agci.a(ReminderCardItemPage.a(this.jdField_a_of_type_Agcs.a), -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderCardItemPage.2.1
 * JD-Core Version:    0.7.0.1
 */