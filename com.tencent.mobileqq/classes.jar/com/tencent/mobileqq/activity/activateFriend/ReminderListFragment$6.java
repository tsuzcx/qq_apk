package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsPullMsgRsp;
import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.reminder.OnGetReminderListByDayListener;
import java.util.ArrayList;

class ReminderListFragment$6
  implements OnGetReminderListByDayListener
{
  ReminderListFragment$6(ReminderListFragment paramReminderListFragment) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = (AcsPullMsgRsp)paramBundle.getSerializable("rsp");
      if (paramBundle != null)
      {
        paramBundle = paramBundle.msgs;
        if ((paramBundle != null) && (!paramBundle.isEmpty()))
        {
          ArrayList localArrayList = new ArrayList(paramBundle.size());
          ReminderListFragment.a(this.a, paramBundle, localArrayList, true);
          return;
        }
        ReminderListFragment.j(this.a);
        return;
      }
      ReminderListFragment.j(this.a);
      return;
    }
    ReminderListFragment.a(this.a, HardCodeUtil.a(2131910857));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.6
 * JD-Core Version:    0.7.0.1
 */