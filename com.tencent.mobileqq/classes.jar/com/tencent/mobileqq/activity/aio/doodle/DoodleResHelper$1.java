package com.tencent.mobileqq.activity.aio.doodle;

import android.view.View;
import com.tencent.mobileqq.doodle.IScribbleResMgr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.scribble.ResCallback;
import mqq.app.MobileQQ;

class DoodleResHelper$1
  implements Runnable
{
  DoodleResHelper$1(DoodleResHelper paramDoodleResHelper, int paramInt1, int paramInt2, View paramView, ResCallback paramResCallback) {}
  
  public void run()
  {
    MobileQQ.sMobileQQ.waitAppRuntime(null);
    int i = this.a;
    if (i == 0)
    {
      ((IScribbleResMgr)QRoute.api(IScribbleResMgr.class)).StartDownloadRes(3, this.b, this.c, this.d);
      return;
    }
    if ((i == 1) || (i == 2)) {
      ((IScribbleResMgr)QRoute.api(IScribbleResMgr.class)).StartDownloadRes(4, this.b, this.c, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper.1
 * JD-Core Version:    0.7.0.1
 */