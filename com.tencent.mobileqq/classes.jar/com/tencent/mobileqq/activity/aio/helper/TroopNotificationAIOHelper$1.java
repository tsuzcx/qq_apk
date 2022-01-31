package com.tencent.mobileqq.activity.aio.helper;

import afgm;
import bcoz;
import bcpa;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class TroopNotificationAIOHelper$1
  implements Runnable
{
  public TroopNotificationAIOHelper$1(afgm paramafgm) {}
  
  public void run()
  {
    if (afgm.a(this.this$0) == null) {}
    bcoz localbcoz;
    do
    {
      do
      {
        return;
      } while (afgm.a(this.this$0).a == null);
      localbcoz = bcpa.a(afgm.a(this.this$0).a, afgm.a(this.this$0).a());
    } while ((localbcoz == null) || (localbcoz.a != 0));
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationAIOHelper", 2, "handleTroopNotificationOnResume, readTroopNotification.");
    }
    bcpa.d(afgm.a(this.this$0).a, afgm.a(this.this$0).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.1
 * JD-Core Version:    0.7.0.1
 */