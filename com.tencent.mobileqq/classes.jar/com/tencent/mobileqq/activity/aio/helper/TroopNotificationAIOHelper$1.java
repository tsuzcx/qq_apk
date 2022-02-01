package com.tencent.mobileqq.activity.aio.helper;

import agwx;
import bgtr;
import bgts;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class TroopNotificationAIOHelper$1
  implements Runnable
{
  public TroopNotificationAIOHelper$1(agwx paramagwx) {}
  
  public void run()
  {
    if (agwx.a(this.this$0) == null) {}
    bgtr localbgtr;
    do
    {
      do
      {
        return;
      } while (agwx.a(this.this$0).a == null);
      localbgtr = bgts.a(agwx.a(this.this$0).a, agwx.a(this.this$0).a());
    } while ((localbgtr == null) || (localbgtr.a != 0));
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationAIOHelper", 2, "handleTroopNotificationOnResume, readTroopNotification.");
    }
    bgts.d(agwx.a(this.this$0).a, agwx.a(this.this$0).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.1
 * JD-Core Version:    0.7.0.1
 */