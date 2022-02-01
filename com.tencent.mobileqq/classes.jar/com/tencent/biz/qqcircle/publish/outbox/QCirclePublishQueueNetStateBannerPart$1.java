package com.tencent.biz.qqcircle.publish.outbox;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.publish.outbox.banner.NetStateCheckBanner;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCirclePublishQueueNetStateBannerPart$1
  implements View.OnClickListener
{
  QCirclePublishQueueNetStateBannerPart$1(QCirclePublishQueueNetStateBannerPart paramQCirclePublishQueueNetStateBannerPart) {}
  
  public void onClick(View paramView)
  {
    this.a.a.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.outbox.QCirclePublishQueueNetStateBannerPart.1
 * JD-Core Version:    0.7.0.1
 */