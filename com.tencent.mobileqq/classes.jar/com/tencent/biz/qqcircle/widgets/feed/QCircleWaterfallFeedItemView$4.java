package com.tencent.biz.qqcircle.widgets.feed;

import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;

class QCircleWaterfallFeedItemView$4
  extends QCirclePicStateListener
{
  QCircleWaterfallFeedItemView$4(QCircleWaterfallFeedItemView paramQCircleWaterfallFeedItemView) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    super.onStateChang(paramInt, paramOption);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramOption.getUrl());
    localStringBuilder.append("\n, state callback:");
    localStringBuilder.append(paramInt);
    QLog.d("QCircleWaterfallFeedItemView1", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleWaterfallFeedItemView.4
 * JD-Core Version:    0.7.0.1
 */