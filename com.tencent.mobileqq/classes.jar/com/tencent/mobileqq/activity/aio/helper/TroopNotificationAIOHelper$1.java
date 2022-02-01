package com.tencent.mobileqq.activity.aio.helper;

import agla;
import bgll;
import bglm;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class TroopNotificationAIOHelper$1
  implements Runnable
{
  public TroopNotificationAIOHelper$1(agla paramagla) {}
  
  public void run()
  {
    if (agla.a(this.this$0) == null) {}
    bgll localbgll;
    do
    {
      do
      {
        return;
      } while (agla.a(this.this$0).app == null);
      localbgll = bglm.a(agla.a(this.this$0).app, agla.a(this.this$0).getCurFriendUin());
    } while ((localbgll == null) || (localbgll.a != 0));
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationAIOHelper", 2, "handleTroopNotificationOnResume, readTroopNotification.");
    }
    bglm.d(agla.a(this.this$0).app, agla.a(this.this$0).getCurFriendUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.1
 * JD-Core Version:    0.7.0.1
 */