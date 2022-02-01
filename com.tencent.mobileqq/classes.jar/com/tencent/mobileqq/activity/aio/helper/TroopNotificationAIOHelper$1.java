package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.troop.utils.TroopNotificationFlagMsg;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.qphone.base.util.QLog;

class TroopNotificationAIOHelper$1
  implements Runnable
{
  TroopNotificationAIOHelper$1(TroopNotificationAIOHelper paramTroopNotificationAIOHelper) {}
  
  public void run()
  {
    if (TroopNotificationAIOHelper.a(this.this$0) == null) {
      return;
    }
    if (TroopNotificationAIOHelper.a(this.this$0).a == null) {
      return;
    }
    TroopNotificationFlagMsg localTroopNotificationFlagMsg = TroopNotificationHelper.a(TroopNotificationAIOHelper.a(this.this$0).a, TroopNotificationAIOHelper.a(this.this$0).b());
    if ((localTroopNotificationFlagMsg != null) && (localTroopNotificationFlagMsg.a == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationAIOHelper", 2, "handleTroopNotificationOnResume, readTroopNotification.");
      }
      TroopNotificationHelper.d(TroopNotificationAIOHelper.a(this.this$0).a, TroopNotificationAIOHelper.a(this.this$0).b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.1
 * JD-Core Version:    0.7.0.1
 */