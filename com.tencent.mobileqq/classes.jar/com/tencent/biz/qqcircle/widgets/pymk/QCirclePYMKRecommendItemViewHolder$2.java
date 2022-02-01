package com.tencent.biz.qqcircle.widgets.pymk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import qqcircle.QQCircleDitto.StItemInfo;

class QCirclePYMKRecommendItemViewHolder$2
  implements View.OnClickListener
{
  QCirclePYMKRecommendItemViewHolder$2(QCirclePYMKRecommendItemViewHolder paramQCirclePYMKRecommendItemViewHolder, QQCircleDitto.StItemInfo paramStItemInfo) {}
  
  public void onClick(View paramView)
  {
    QCirclePYMKRecommendItemViewHolder.a(this.b, paramView.getContext(), this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendItemViewHolder.2
 * JD-Core Version:    0.7.0.1
 */