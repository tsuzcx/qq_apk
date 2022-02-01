package com.tencent.mobileqq.activity.framebusiness;

import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class QCircleInjectImpl$7$1
  implements Runnable
{
  QCircleInjectImpl$7$1(QCircleInjectImpl.7 param7, MainFragment paramMainFragment) {}
  
  public void run()
  {
    if (this.a.isAdded())
    {
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).setFrames(this.a, false);
      QLog.d("QCircleThirdTabConfig", 1, "notifyTabRefresh success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.7.1
 * JD-Core Version:    0.7.0.1
 */