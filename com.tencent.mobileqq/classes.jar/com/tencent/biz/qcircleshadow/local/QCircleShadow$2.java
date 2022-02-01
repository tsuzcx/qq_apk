package com.tencent.biz.qcircleshadow.local;

import com.tencent.mobileqq.qcircle.tempapi.interfaces.QCircleVideoSdkInitListener;
import com.tencent.qphone.base.util.QLog;

class QCircleShadow$2
  implements QCircleVideoSdkInitListener
{
  QCircleShadow$2(QCircleShadow paramQCircleShadow) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    QLog.d("QCIRCLE_PLUGIN", 4, "preload play SDK success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCircleShadow.2
 * JD-Core Version:    0.7.0.1
 */