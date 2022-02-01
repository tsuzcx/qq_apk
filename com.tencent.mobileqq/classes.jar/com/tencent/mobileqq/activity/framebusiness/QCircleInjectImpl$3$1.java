package com.tencent.mobileqq.activity.framebusiness;

import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.qroute.QRoute;

class QCircleInjectImpl$3$1
  implements Runnable
{
  QCircleInjectImpl$3$1(QCircleInjectImpl.3 param3) {}
  
  public void run()
  {
    if (this.this$0.a.isAdded()) {
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).setFrames(this.this$0.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.3.1
 * JD-Core Version:    0.7.0.1
 */