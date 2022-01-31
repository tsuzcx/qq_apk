package com.tencent.mobileqq.app.automator.step;

import aufx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class GetQZoneFeedCount
  extends AsyncStep
{
  public int a()
  {
    aufx localaufx;
    if ((this.a != null) && (this.a.app != null))
    {
      localaufx = (aufx)this.a.app.getManager(10);
      if (localaufx != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GetQZoneFeedCount", 2, "GetQZoneFeedCount isFirstGetUnread:" + localaufx.a() + ",isBackground_Pause:" + this.a.app.isBackground_Pause);
        }
        if (!localaufx.a()) {
          break label120;
        }
        localaufx.a(this.a.app.getAccount(), null);
      }
    }
    for (;;)
    {
      return 7;
      label120:
      if (this.a.app.isBackground_Pause) {
        localaufx.b(6);
      } else {
        localaufx.a(5);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetQZoneFeedCount
 * JD-Core Version:    0.7.0.1
 */