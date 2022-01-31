package com.tencent.mobileqq.app.automator.step;

import askp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class GetQZoneFeedCount
  extends AsyncStep
{
  public int a()
  {
    askp localaskp;
    if ((this.a != null) && (this.a.app != null))
    {
      localaskp = (askp)this.a.app.getManager(10);
      if (localaskp != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GetQZoneFeedCount", 2, "GetQZoneFeedCount isFirstGetUnread:" + localaskp.a() + ",isBackground_Pause:" + this.a.app.isBackground_Pause);
        }
        if (!localaskp.a()) {
          break label120;
        }
        localaskp.a(this.a.app.getAccount(), null);
      }
    }
    for (;;)
    {
      return 7;
      label120:
      if (this.a.app.isBackground_Pause) {
        localaskp.b(6);
      } else {
        localaskp.a(5);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetQZoneFeedCount
 * JD-Core Version:    0.7.0.1
 */