package com.tencent.biz.qqcircle.widgets;

import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;

class QCirclePublishGuideView$1
  extends QCirclePicStateListener
{
  QCirclePublishGuideView$1(QCirclePublishGuideView paramQCirclePublishGuideView) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    if (paramInt == 6)
    {
      paramOption = new StringBuilder();
      paramOption.append("onStateChang success:");
      paramOption.append(QCirclePublishGuideView.a(this.a).getHeight());
      QLog.d("QCirclePublishGuideView", 4, paramOption.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePublishGuideView.1
 * JD-Core Version:    0.7.0.1
 */