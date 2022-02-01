package com.tencent.biz.qqcircle.widgets.feed;

import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;

class QCircleTimeLineFeedItemView$QCircleInnerPicItemViewHolder$1
  extends QCirclePicStateListener
{
  QCircleTimeLineFeedItemView$QCircleInnerPicItemViewHolder$1(QCircleTimeLineFeedItemView.QCircleInnerPicItemViewHolder paramQCircleInnerPicItemViewHolder) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    super.onStateChang(paramInt, paramOption);
    paramOption = new StringBuilder();
    paramOption.append("state callback:");
    paramOption.append(paramInt);
    QLog.d("QCircleTimeLineFeedItemView1", 4, paramOption.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView.QCircleInnerPicItemViewHolder.1
 * JD-Core Version:    0.7.0.1
 */