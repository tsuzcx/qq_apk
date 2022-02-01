package com.tencent.biz.qqcircle.richframework.video;

import android.os.Handler;
import android.view.Surface;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.QCircleVideoSdkInitListener;
import com.tencent.qphone.base.util.QLog;

class QCirclePlayer$1
  implements QCircleVideoSdkInitListener
{
  QCirclePlayer$1(QCirclePlayer paramQCirclePlayer, Surface paramSurface) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      QLog.e("QCirclePlayer", 1, "onSDKInited failed");
      return;
    }
    RFThreadManager.getUIHandler().post(new QCirclePlayer.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.video.QCirclePlayer.1
 * JD-Core Version:    0.7.0.1
 */