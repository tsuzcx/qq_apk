package com.tencent.biz.qqcircle.immersive.aggregation.part;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFSAggregationPublishPart$1
  implements View.OnClickListener
{
  QFSAggregationPublishPart$1(QFSAggregationPublishPart paramQFSAggregationPublishPart) {}
  
  public void onClick(View paramView)
  {
    QFSAggregationPublishPart.a(this.a, paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.aggregation.part.QFSAggregationPublishPart.1
 * JD-Core Version:    0.7.0.1
 */