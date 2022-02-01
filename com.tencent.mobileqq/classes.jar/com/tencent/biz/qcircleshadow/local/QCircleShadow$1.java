package com.tencent.biz.qcircleshadow.local;

import com.tencent.mobileqq.qcircle.api.IQQFrontBackListener;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class QCircleShadow$1
  implements IQQFrontBackListener
{
  QCircleShadow$1(QCircleShadow paramQCircleShadow) {}
  
  public void onQQEnterBackground()
  {
    if (QCircleShadow.a(this.a))
    {
      long l = System.currentTimeMillis();
      QLog.d("QCIRCLE_PLUGIN", 4, "on QQ background start");
      QCirclePluginEnter.preloadQCirclePlugin(MobileQQ.getContext(), new QCircleShadow.1.1(this, l));
    }
  }
  
  public void onQQEnterForeground() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCircleShadow.1
 * JD-Core Version:    0.7.0.1
 */