package com.tencent.mobileqq.activity.framebusiness;

import android.os.Handler;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class QCircleInjectImpl$1
  implements Runnable
{
  QCircleInjectImpl$1(FrameFragment paramFrameFragment) {}
  
  public void run()
  {
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = QCircleFrame.a(this.a.a() instanceof QCircleFrame);
    if (localRedTypeInfo == null) {
      QLog.i("updateQCircleRedDot", 1, "redInfo is null");
    }
    RedTouch localRedTouch;
    do
    {
      do
      {
        return;
      } while (this.a.jdField_a_of_type_JavaUtilHashMap == null);
      localRedTouch = (RedTouch)this.a.jdField_a_of_type_JavaUtilHashMap.get(FrameControllerUtil.g);
    } while ((localRedTouch == null) || (this.a.jdField_a_of_type_AndroidOsHandler == null));
    this.a.jdField_a_of_type_AndroidOsHandler.post(new QCircleInjectImpl.1.1(this, localRedTouch, localRedTypeInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.1
 * JD-Core Version:    0.7.0.1
 */