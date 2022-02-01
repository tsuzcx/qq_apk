package com.tencent.biz.qqcircle.widgets.pymk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCirclePYMKRecommendItemViewHolder$1
  implements View.OnClickListener
{
  QCirclePYMKRecommendItemViewHolder$1(QCirclePYMKRecommendItemViewHolder paramQCirclePYMKRecommendItemViewHolder) {}
  
  public void onClick(View paramView)
  {
    QCirclePYMKRecommendItemViewHolder.a(this.a, paramView.getContext());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendItemViewHolder.1
 * JD-Core Version:    0.7.0.1
 */