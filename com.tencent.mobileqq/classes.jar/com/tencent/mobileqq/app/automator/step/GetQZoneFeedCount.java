package com.tencent.mobileqq.app.automator.step;

import axft;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class GetQZoneFeedCount
  extends AsyncStep
{
  public int a()
  {
    axft localaxft;
    if ((this.a != null) && (this.a.app != null))
    {
      localaxft = (axft)this.a.app.getManager(10);
      if (localaxft != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GetQZoneFeedCount", 2, "GetQZoneFeedCount isFirstGetUnread:" + localaxft.a() + ",isBackground_Pause:" + this.a.app.isBackgroundPause);
        }
        if (!localaxft.a()) {
          break label120;
        }
        localaxft.a(this.a.app.getAccount(), null);
      }
    }
    for (;;)
    {
      return 7;
      label120:
      if (this.a.app.isBackgroundPause) {
        localaxft.b(6);
      } else {
        localaxft.a(5);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetQZoneFeedCount
 * JD-Core Version:    0.7.0.1
 */