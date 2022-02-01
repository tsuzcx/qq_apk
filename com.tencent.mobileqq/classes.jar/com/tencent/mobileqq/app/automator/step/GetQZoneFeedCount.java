package com.tencent.mobileqq.app.automator.step;

import avta;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class GetQZoneFeedCount
  extends AsyncStep
{
  public int a()
  {
    avta localavta;
    if ((this.a != null) && (this.a.app != null))
    {
      localavta = (avta)this.a.app.getManager(10);
      if (localavta != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GetQZoneFeedCount", 2, "GetQZoneFeedCount isFirstGetUnread:" + localavta.a() + ",isBackground_Pause:" + this.a.app.isBackgroundPause);
        }
        if (!localavta.a()) {
          break label120;
        }
        localavta.a(this.a.app.getAccount(), null);
      }
    }
    for (;;)
    {
      return 7;
      label120:
      if (this.a.app.isBackgroundPause) {
        localavta.b(6);
      } else {
        localavta.a(5);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetQZoneFeedCount
 * JD-Core Version:    0.7.0.1
 */