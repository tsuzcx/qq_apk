package com.tencent.biz.qqcircle.fragments.content.stick;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;

class QCircleExpandStickView$2
  implements View.OnClickListener
{
  QCircleExpandStickView$2(QCircleExpandStickView paramQCircleExpandStickView, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    QLog.d("Stick-QCircleExpandStickView", 1, new Object[] { "[showGuideBubble] click feed id: ", QCircleExpandStickView.a(this.b) });
    QCircleExpandStickView localQCircleExpandStickView = this.b;
    QCircleExpandStickView.a(localQCircleExpandStickView, localQCircleExpandStickView.getContext(), this.a);
    QCircleExpandStickView.b(this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.stick.QCircleExpandStickView.2
 * JD-Core Version:    0.7.0.1
 */