package com.tencent.mobileqq.activity.framebusiness;

import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;

class QCircleInjectImpl$1$1
  implements Runnable
{
  QCircleInjectImpl$1$1(QCircleInjectImpl.1 param1, RedTouch paramRedTouch, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo) {}
  
  public void run()
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateRedTouch(this.this$0.a, 40, this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch, this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.1.1
 * JD-Core Version:    0.7.0.1
 */