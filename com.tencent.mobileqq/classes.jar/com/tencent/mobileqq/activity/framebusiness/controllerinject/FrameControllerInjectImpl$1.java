package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.kandian.biz.tab.api.IRIJTabInject;
import com.tencent.mobileqq.qroute.QRoute;

class FrameControllerInjectImpl$1
  implements Runnable
{
  FrameControllerInjectImpl$1(FrameControllerInjectImpl paramFrameControllerInjectImpl, FrameFragment paramFrameFragment) {}
  
  public void run()
  {
    ((IRIJTabInject)QRoute.api(IRIJTabInject.class)).updateKanDianRedTouch(this.a);
    ((IRIJTabInject)QRoute.api(IRIJTabInject.class)).kanDianTabExposure(this.a.jdField_a_of_type_JavaUtilHashMap, this.a.jdField_a_of_type_ArrayOfAndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.controllerinject.FrameControllerInjectImpl.1
 * JD-Core Version:    0.7.0.1
 */