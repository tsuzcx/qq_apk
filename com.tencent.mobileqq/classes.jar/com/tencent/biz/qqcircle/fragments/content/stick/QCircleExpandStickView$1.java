package com.tencent.biz.qqcircle.fragments.content.stick;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.widgets.QCircleGuideBubbleView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;

class QCircleExpandStickView$1
  implements View.OnClickListener
{
  QCircleExpandStickView$1(QCircleExpandStickView paramQCircleExpandStickView, FeedCloudMeta.StFeed paramStFeed, QCircleGuideBubbleView paramQCircleGuideBubbleView) {}
  
  public void onClick(View paramView)
  {
    QCircleExpandStickView.a(this.c, this.a, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.stick.QCircleExpandStickView.1
 * JD-Core Version:    0.7.0.1
 */