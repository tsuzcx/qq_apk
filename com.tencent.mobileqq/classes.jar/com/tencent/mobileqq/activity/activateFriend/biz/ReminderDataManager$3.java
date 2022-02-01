package com.tencent.mobileqq.activity.activateFriend.biz;

import Wallet.AcsMsg;
import agdj;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ReminderDataManager$3
  implements Runnable
{
  public ReminderDataManager$3(agdj paramagdj, List paramList) {}
  
  public void run()
  {
    if ((this.a == null) || (this.a.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 1, "save reminder msg list is null or empty!");
      }
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        AcsMsg localAcsMsg = (AcsMsg)localIterator.next();
        agdj.a(this.this$0, localAcsMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.3
 * JD-Core Version:    0.7.0.1
 */