package com.tencent.mobileqq.activity.framebusiness;

import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;

class QCircleInjectImpl$3$1
  implements Runnable
{
  QCircleInjectImpl$3$1(QCircleInjectImpl.3 param3, RedTouch paramRedTouch, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo) {}
  
  public void run()
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateRedTouch(this.this$0.a, 40, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.3.1
 * JD-Core Version:    0.7.0.1
 */