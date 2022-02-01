package com.tencent.biz.qqcircle.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleTroopTagListView$RecommendLabelAdapter$TagViewHolder$2
  implements View.OnClickListener
{
  QCircleTroopTagListView$RecommendLabelAdapter$TagViewHolder$2(QCircleTroopTagListView.RecommendLabelAdapter.TagViewHolder paramTagViewHolder, long paramLong) {}
  
  public void onClick(View paramView)
  {
    if (QCircleTroopTagListView.b(this.b.e.b) != null) {
      QCircleTroopTagListView.b(this.b.e.b).a(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTroopTagListView.RecommendLabelAdapter.TagViewHolder.2
 * JD-Core Version:    0.7.0.1
 */