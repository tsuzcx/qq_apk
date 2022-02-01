package com.tencent.biz.qqcircle.widgets.feed;

import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;

class QCircleWaterfallFeedItemView$3
  extends QCirclePicStateListener
{
  QCircleWaterfallFeedItemView$3(QCircleWaterfallFeedItemView paramQCircleWaterfallFeedItemView) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    super.onStateChang(paramInt, paramOption);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramOption.getUrl());
    localStringBuilder.append("\n, state callback:");
    localStringBuilder.append(paramInt);
    QLog.d("QCircleWaterfallFeedItemView", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleWaterfallFeedItemView.3
 * JD-Core Version:    0.7.0.1
 */