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
    int i;
    if (this.d.a.k.mn_appid == 0) {
      i = 0;
    } else {
      i = 1;
    }
    if (this.a == 2001)
    {
      if (this.b)
      {
        AcsDelMsgRsp localAcsDelMsgRsp = (AcsDelMsgRsp)this.c.getSerializable("rsp");
        if (localAcsDelMsgRsp == null)
        {
          QQNotifyHelper.a(ReminderCardItemPage.a(this.d.a), -1, i);
          return;
        }
        int j = localAcsDelMsgRsp.ret_code;
        QQNotifyHelper.a(ReminderCardItemPage.a(this.d.a), j, i);
        return;
      }
      QQNotifyHelper.a(ReminderCardItemPage.a(this.d.a), -1, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderCardItemPage.2.1
 * JD-Core Version:    0.7.0.1
 */