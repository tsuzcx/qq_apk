package com.tencent.mobileqq.activity.aio.rebuild.panel;

import com.tencent.aelight.camera.util.api.IAIOShortVideoUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class PtvPanelProviderHelper$1
  implements Runnable
{
  PtvPanelProviderHelper$1(PtvPanelProviderHelper paramPtvPanelProviderHelper) {}
  
  public void run()
  {
    if (!PtvPanelProviderHelper.a)
    {
      ((IAIOShortVideoUtil)QRoute.api(IAIOShortVideoUtil.class)).setClickCameraTime(System.currentTimeMillis());
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_CLICK_CAMERA ", Long.valueOf(((IAIOShortVideoUtil)QRoute.api(IAIOShortVideoUtil.class)).getClickCameraTime()) });
      this.this$0.a(false);
      PtvPanelProviderHelper.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.panel.PtvPanelProviderHelper.1
 * JD-Core Version:    0.7.0.1
 */