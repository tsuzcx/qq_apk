package com.tencent.biz.qqcircle.bizparts;

import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;

class QCircleAchievementPopupWindowPart$1
  extends QCirclePicStateListener
{
  QCircleAchievementPopupWindowPart$1(QCircleAchievementPopupWindowPart paramQCircleAchievementPopupWindowPart) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    super.onStateChang(paramInt, paramOption);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramOption.getUrl());
    localStringBuilder.append("\n, state callback:");
    localStringBuilder.append(paramInt);
    QLog.d("QCircleAchievementPopupWindowPart", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleAchievementPopupWindowPart.1
 * JD-Core Version:    0.7.0.1
 */