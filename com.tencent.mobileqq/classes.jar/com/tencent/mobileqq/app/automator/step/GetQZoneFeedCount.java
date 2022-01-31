package com.tencent.mobileqq.app.automator.step;

import aroj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class GetQZoneFeedCount
  extends AsyncStep
{
  public int a()
  {
    aroj localaroj;
    if ((this.a != null) && (this.a.app != null))
    {
      localaroj = (aroj)this.a.app.getManager(10);
      if (localaroj != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GetQZoneFeedCount", 2, "GetQZoneFeedCount isFirstGetUnread:" + localaroj.a() + ",isBackground_Pause:" + this.a.app.isBackground_Pause);
        }
        if (!localaroj.a()) {
          break label120;
        }
        localaroj.a(this.a.app.getAccount(), null);
      }
    }
    for (;;)
    {
      return 7;
      label120:
      if (this.a.app.isBackground_Pause) {
        localaroj.b(6);
      } else {
        localaroj.a(5);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetQZoneFeedCount
 * JD-Core Version:    0.7.0.1
 */