package com.tencent.biz.qqcircle.fragments.troop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.fragments.QCircleBlockMerger;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleTroopAggregationBodyPart$2
  implements View.OnClickListener
{
  QCircleTroopAggregationBodyPart$2(QCircleTroopAggregationBodyPart paramQCircleTroopAggregationBodyPart) {}
  
  public void onClick(View paramView)
  {
    if ((QCircleTroopAggregationBodyPart.a(this.a) != null) && (QCircleTroopAggregationBodyPart.b(this.a) != null))
    {
      QCircleTroopAggregationBodyPart.a(this.a).onRefreshData();
      QCircleTroopAggregationBodyPart.b(this.a).setVisibility(8);
      this.a.be_().getBlockMerger().a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.troop.QCircleTroopAggregationBodyPart.2
 * JD-Core Version:    0.7.0.1
 */