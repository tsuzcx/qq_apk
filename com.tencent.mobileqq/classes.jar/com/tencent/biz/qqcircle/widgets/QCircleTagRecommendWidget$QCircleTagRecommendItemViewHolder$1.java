package com.tencent.biz.qqcircle.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleTagRecommendWidget$QCircleTagRecommendItemViewHolder$1
  implements View.OnClickListener
{
  QCircleTagRecommendWidget$QCircleTagRecommendItemViewHolder$1(QCircleTagRecommendWidget.QCircleTagRecommendItemViewHolder paramQCircleTagRecommendItemViewHolder) {}
  
  public void onClick(View paramView)
  {
    QCircleTagRecommendWidget.QCircleTagRecommendItemViewHolder.a(this.a, paramView.getContext());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTagRecommendWidget.QCircleTagRecommendItemViewHolder.1
 * JD-Core Version:    0.7.0.1
 */