package com.tencent.biz.qcircleshadow.local;

import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

class QCircleShadow$2
  implements SDKInitListener
{
  QCircleShadow$2(QCircleShadow paramQCircleShadow) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preload play SDK success：");
    localStringBuilder.append(paramBoolean);
    QLog.d("QCIRCLE_PLUGIN", 4, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCircleShadow.2
 * JD-Core Version:    0.7.0.1
 */