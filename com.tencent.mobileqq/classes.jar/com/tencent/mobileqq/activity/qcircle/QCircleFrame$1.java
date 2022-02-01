package com.tencent.mobileqq.activity.qcircle;

import com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl;
import com.tencent.mobileqq.qcircle.api.helper.QCircleObserver;
import com.tencent.qphone.base.util.QLog;

class QCircleFrame$1
  extends QCircleObserver
{
  QCircleFrame$1(QCircleFrame paramQCircleFrame) {}
  
  protected void onUpdateRedPoint(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QCircleObserver onUpdateRedPoint ");
      localStringBuilder.append(paramInt);
      QLog.e("QCircleFrame", 2, localStringBuilder.toString());
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