package com.tencent.mobileqq.activity.aio.doodle;

import android.view.View;
import com.tencent.mobileqq.doodle.IScribbleResMgr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.scribble.ResCallback;

class DoodleResHelper$2
  implements Runnable
{
  DoodleResHelper$2(DoodleResHelper paramDoodleResHelper, int paramInt1, int paramInt2, View paramView, ResCallback paramResCallback) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 0)
    {
      ((IScribbleResMgr)QRoute.api(IScribbleResMgr.class)).StartDownloadRes(1, this.b, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqScribbleResCallback);
      return;
    }
    if ((i == 1) || (i == 2)) {
      ((IScribbleResMgr)QRoute.api(IScribbleResMgr.class)).StartDownloadRes(2, this.b, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqScribbleResCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper.2
 * JD-Core Version:    0.7.0.1
 */