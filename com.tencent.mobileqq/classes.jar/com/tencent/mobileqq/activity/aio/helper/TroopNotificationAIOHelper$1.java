package com.tencent.mobileqq.activity.aio.helper;

import aftg;
import bfdf;
import bfdg;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class TroopNotificationAIOHelper$1
  implements Runnable
{
  public TroopNotificationAIOHelper$1(aftg paramaftg) {}
  
  public void run()
  {
    if (aftg.a(this.this$0) == null) {}
    bfdf localbfdf;
    do
    {
      do
      {
        return;
      } while (aftg.a(this.this$0).app == null);
      localbfdf = bfdg.a(aftg.a(this.this$0).app, aftg.a(this.this$0).getCurFriendUin());
    } while ((localbfdf == null) || (localbfdf.a != 0));
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationAIOHelper", 2, "handleTroopNotificationOnResume, readTroopNotification.");
    }
    bfdg.d(aftg.a(this.this$0).app, aftg.a(this.this$0).getCurFriendUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.1
 * JD-Core Version:    0.7.0.1
 */