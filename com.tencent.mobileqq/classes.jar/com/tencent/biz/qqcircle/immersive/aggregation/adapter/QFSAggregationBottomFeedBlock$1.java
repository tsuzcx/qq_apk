package com.tencent.biz.qqcircle.immersive.aggregation.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFSAggregationBottomFeedBlock$1
  implements View.OnClickListener
{
  QFSAggregationBottomFeedBlock$1(QFSAggregationBottomFeedBlock paramQFSAggregationBottomFeedBlock, int paramInt, FeedBlockData paramFeedBlockData) {}
  
  public void onClick(View paramView)
  {
    if (QFSAggregationBottomFeedBlock.a(this.c) != null) {
      QFSAggregationBottomFeedBlock.a(this.c).a(this.a, this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.aggregation.adapter.QFSAggregationBottomFeedBlock.1
 * JD-Core Version:    0.7.0.1
 */