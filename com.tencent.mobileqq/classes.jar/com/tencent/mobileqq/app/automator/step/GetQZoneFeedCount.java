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
  protected int doStep()
  {
    if ((this.mAutomator != null) && (this.mAutomator.a != null))
    {
      QZoneManager localQZoneManager = (QZoneManager)this.mAutomator.a.getManager(QQManagerFactory.QZONE_MANAGER);
      if (localQZoneManager != null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("GetQZoneFeedCount isFirstGetUnread:");
          localStringBuilder.append(localQZoneManager.a());
          localStringBuilder.append(",isBackground_Pause:");
          localStringBuilder.append(this.mAutomator.a.isBackgroundPause);
          QLog.d("GetQZoneFeedCount", 2, localStringBuilder.toString());
        }
        if (localQZoneManager.a()) {
          localQZoneManager.a(this.mAutomator.a.getAccount(), null);
        } else if (this.mAutomator.a.isBackgroundPause) {
          localQZoneManager.b(6);
        } else {
          localQZoneManager.a(5);
        }
      }
      QCircleUtils.a().requestWhiteList(this.mAutomator.a.getCurrentUin());
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetQZoneFeedCount
 * JD-Core Version:    0.7.0.1
 */