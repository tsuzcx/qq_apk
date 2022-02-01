package com.tencent.mobileqq.activity.qcircle;

import com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl;
import com.tencent.mobileqq.activity.qcircle.handler.QCircleObserver;
import com.tencent.qphone.base.util.QLog;

class QCircleFrame$1
  extends QCircleObserver
{
  QCircleFrame$1(QCircleFrame paramQCircleFrame) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QCircleFrame", 2, "QCircleObserver onUpdateRedPoint " + paramInt);
    }
    if (QCircleFrame.a(this.a) != null) {
      QCircleInjectImpl.c(QCircleFrame.a(this.a), "mQCircleRedDotObserver");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.QCircleFrame.1
 * JD-Core Version:    0.7.0.1
 */