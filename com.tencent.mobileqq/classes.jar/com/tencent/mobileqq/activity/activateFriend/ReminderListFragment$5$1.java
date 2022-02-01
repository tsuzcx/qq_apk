package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsDelMsgRsp;
import Wallet.AcsMsg;
import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.statistics.ReportController;

class ReminderListFragment$5$1
  implements Runnable
{
  ReminderListFragment$5$1(ReminderListFragment.5 param5, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.a == 2001)
    {
      if (this.b)
      {
        AcsDelMsgRsp localAcsDelMsgRsp = (AcsDelMsgRsp)this.c.getSerializable("rsp");
        if ((localAcsDelMsgRsp != null) && (localAcsDelMsgRsp.ret_code == 0))
        {
          ReportController.b(ReminderListFragment.f(this.d.c), "P_CliOper", "QQnotice", "", "", "QQnotice.set.delete", 0, 0, "", "", this.d.a.busi_id, this.d.a.msg_id);
          ReminderListFragment.g(this.d.c).a(this.d.b);
          ReminderListFragment.h(this.d.c).deleteReminderByMsgId(QQNotifyHelper.a(this.d.a), new ReminderListFragment.5.1.1(this));
          return;
        }
        ReminderListFragment.a(this.d.c, HardCodeUtil.a(2131910854));
        return;
      }
      ReminderListFragment.a(this.d.c, HardCodeUtil.a(2131910851));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.5.1
 * JD-Core Version:    0.7.0.1
 */