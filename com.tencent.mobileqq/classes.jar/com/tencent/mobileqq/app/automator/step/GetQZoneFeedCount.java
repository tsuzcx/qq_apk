package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.qphone.base.util.QLog;

public class GetQZoneFeedCount
  extends AsyncStep
{
  protected int a()
  {
    QZoneManager localQZoneManager;
    if ((this.a != null) && (this.a.b != null))
    {
      localQZoneManager = (QZoneManager)this.a.b.getManager(9);
      if (localQZoneManager != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GetQZoneFeedCount", 2, "GetQZoneFeedCount isFirstGetUnread:" + localQZoneManager.a() + ",isBackground_Pause:" + this.a.b.isBackground_Pause);
        }
        if (!localQZoneManager.a()) {
          break label120;
        }
        localQZoneManager.a(this.a.b.getAccount(), null);
      }
    }
    for (;;)
    {
      return 7;
      label120:
      if (this.a.b.isBackground_Pause) {
        localQZoneManager.b(6);
      } else {
        localQZoneManager.a(5);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetQZoneFeedCount
 * JD-Core Version:    0.7.0.1
 */