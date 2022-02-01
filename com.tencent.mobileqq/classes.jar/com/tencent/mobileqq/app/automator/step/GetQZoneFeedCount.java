package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.qcircle.api.IQCirclePreLoaderService;
import com.tencent.qphone.base.util.QLog;

public class GetQZoneFeedCount
  extends AsyncStep
{
  public int a()
  {
    QZoneManager localQZoneManager;
    if ((this.a != null) && (this.a.a != null))
    {
      localQZoneManager = (QZoneManager)this.a.a.getManager(QQManagerFactory.QZONE_MANAGER);
      if (localQZoneManager != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GetQZoneFeedCount", 2, "GetQZoneFeedCount isFirstGetUnread:" + localQZoneManager.a() + ",isBackground_Pause:" + this.a.a.isBackgroundPause);
        }
        if (!localQZoneManager.a()) {
          break label139;
        }
        localQZoneManager.a(this.a.a.getAccount(), null);
      }
    }
    for (;;)
    {
      QCircleUtils.a().requestWhiteList(this.a.a.getCurrentUin());
      return 7;
      label139:
      if (this.a.a.isBackgroundPause) {
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