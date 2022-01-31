package com.tencent.mobileqq.activity.aio.helper;

import adjo;
import bamd;
import bame;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class TroopNotificationAIOHelper$1
  implements Runnable
{
  public TroopNotificationAIOHelper$1(adjo paramadjo) {}
  
  public void run()
  {
    if (adjo.a(this.this$0) == null) {}
    bamd localbamd;
    do
    {
      do
      {
        return;
      } while (adjo.a(this.this$0).a == null);
      localbamd = bame.a(adjo.a(this.this$0).a, adjo.a(this.this$0).a());
    } while ((localbamd == null) || (localbamd.a != 0));
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationAIOHelper", 2, "handleTroopNotificationOnResume, readTroopNotification.");
    }
    bame.d(adjo.a(this.this$0).a, adjo.a(this.this$0).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.1
 * JD-Core Version:    0.7.0.1
 */