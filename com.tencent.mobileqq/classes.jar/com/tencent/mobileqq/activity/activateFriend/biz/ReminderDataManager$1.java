package com.tencent.mobileqq.activity.activateFriend.biz;

import aewd;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class ReminderDataManager$1
  implements Runnable
{
  public ReminderDataManager$1(aewd paramaewd) {}
  
  public void run()
  {
    aewd.a(this.this$0, NetConnInfoCenter.getServerTime() - 86400L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.ReminderDataManager.1
 * JD-Core Version:    0.7.0.1
 */