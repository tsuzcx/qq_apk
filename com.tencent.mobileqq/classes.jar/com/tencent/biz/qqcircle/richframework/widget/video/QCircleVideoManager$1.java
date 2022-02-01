package com.tencent.biz.qqcircle.richframework.widget.video;

import com.tencent.mobileqq.qcircle.tempapi.interfaces.QCircleVideoSdkInitListener;
import com.tencent.qphone.base.util.QLog;

class QCircleVideoManager$1
  implements QCircleVideoSdkInitListener
{
  QCircleVideoManager$1(QCircleVideoManager paramQCircleVideoManager) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    if (!paramBoolean) {
      QLog.e("QCircleVideoManager", 1, "onSDKInited failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.video.QCircleVideoManager.1
 * JD-Core Version:    0.7.0.1
 */