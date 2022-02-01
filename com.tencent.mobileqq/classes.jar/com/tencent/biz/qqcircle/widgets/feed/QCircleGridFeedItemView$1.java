package com.tencent.biz.qqcircle.widgets.feed;

import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;

class QCircleGridFeedItemView$1
  extends QCirclePicStateListener
{
  QCircleGridFeedItemView$1(QCircleGridFeedItemView paramQCircleGridFeedItemView, int paramInt) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    super.onStateChang(paramInt, paramOption);
    paramOption = new StringBuilder();
    paramOption.append("pos:");
    paramOption.append(this.val$pos);
    paramOption.append("state callback:");
    paramOption.append(paramInt);
    QLog.d("QCircleGridFeedItemView1", 4, paramOption.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleGridFeedItemView.1
 * JD-Core Version:    0.7.0.1
 */