package com.tencent.mobileqq.activity.aio.helper;

import afbx;
import bckq;
import bckr;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class TroopNotificationAIOHelper$1
  implements Runnable
{
  public TroopNotificationAIOHelper$1(afbx paramafbx) {}
  
  public void run()
  {
    if (afbx.a(this.this$0) == null) {}
    bckq localbckq;
    do
    {
      do
      {
        return;
      } while (afbx.a(this.this$0).a == null);
      localbckq = bckr.a(afbx.a(this.this$0).a, afbx.a(this.this$0).a());
    } while ((localbckq == null) || (localbckq.a != 0));
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationAIOHelper", 2, "handleTroopNotificationOnResume, readTroopNotification.");
    }
    bckr.d(afbx.a(this.this$0).a, afbx.a(this.this$0).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.1
 * JD-Core Version:    0.7.0.1
 */