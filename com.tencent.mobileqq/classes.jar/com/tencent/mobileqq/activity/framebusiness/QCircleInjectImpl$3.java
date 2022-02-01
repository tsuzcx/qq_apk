package com.tencent.mobileqq.activity.framebusiness;

import android.os.Handler;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class QCircleInjectImpl$3
  implements Runnable
{
  QCircleInjectImpl$3(FrameFragment paramFrameFragment) {}
  
  public void run()
  {
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = QCircleFrame.c(this.a.v() instanceof QCircleFrame);
    if (localRedTypeInfo == null)
    {
      QLog.i("updateQCircleRedDot", 1, "redInfo is null");
      return;
    }
    if (this.a.G == null) {
      return;
    }
    RedTouch localRedTouch = (RedTouch)this.a.G.get(FrameControllerUtil.r);
    if ((localRedTouch != null) && (this.a.q != null)) {
      this.a.q.post(new QCircleInjectImpl.3.1(this, localRedTouch, localRedTypeInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.3
 * JD-Core Version:    0.7.0.1
 */