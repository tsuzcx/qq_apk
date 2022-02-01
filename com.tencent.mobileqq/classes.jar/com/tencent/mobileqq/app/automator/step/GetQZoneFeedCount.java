package com.tencent.mobileqq.app.automator.step;

import awzb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.whitelist.QCirclePreLoadManager;

public class GetQZoneFeedCount
  extends AsyncStep
{
  public int a()
  {
    awzb localawzb;
    if ((this.a != null) && (this.a.app != null))
    {
      localawzb = (awzb)this.a.app.getManager(QQManagerFactory.QZONE_MANAGER);
      if (localawzb != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GetQZoneFeedCount", 2, "GetQZoneFeedCount isFirstGetUnread:" + localawzb.a() + ",isBackground_Pause:" + this.a.app.isBackgroundPause);
        }
        if (!localawzb.a()) {
          break label137;
        }
        localawzb.a(this.a.app.getAccount(), null);
      }
    }
    for (;;)
    {
      QCirclePreLoadManager.getInstance().requestWhiteList(this.a.app.getCurrentUin());
      return 7;
      label137:
      if (this.a.app.isBackgroundPause) {
        localawzb.b(6);
      } else {
        localawzb.a(5);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetQZoneFeedCount
 * JD-Core Version:    0.7.0.1
 */