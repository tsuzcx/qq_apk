package com.tencent.mobileqq.activity.aio.helper;

import agns;
import bftq;
import bftr;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class TroopNotificationAIOHelper$1
  implements Runnable
{
  public TroopNotificationAIOHelper$1(agns paramagns) {}
  
  public void run()
  {
    if (agns.a(this.this$0) == null) {}
    bftq localbftq;
    do
    {
      do
      {
        return;
      } while (agns.a(this.this$0).a == null);
      localbftq = bftr.a(agns.a(this.this$0).a, agns.a(this.this$0).a());
    } while ((localbftq == null) || (localbftq.a != 0));
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationAIOHelper", 2, "handleTroopNotificationOnResume, readTroopNotification.");
    }
    bftr.d(agns.a(this.this$0).a, agns.a(this.this$0).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.1
 * JD-Core Version:    0.7.0.1
 */