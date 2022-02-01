package com.tencent.biz.qqcircle.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.QCircleJsUrlConfig;
import com.tencent.biz.qqcircle.bizparts.QCircleTagHeaderPart;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleFuelTopView$1
  implements View.OnClickListener
{
  QCircleFuelTopView$1(QCircleFuelTopView paramQCircleFuelTopView) {}
  
  public void onClick(View paramView)
  {
    if (QCircleFuelTopView.a(this.a) != null)
    {
      QCircleFuelTopView localQCircleFuelTopView = this.a;
      QCircleFuelTopView.a(localQCircleFuelTopView, 89, 2, ((QCircleTagHeaderPart)QCircleFuelTopView.a(localQCircleFuelTopView)).i());
    }
    if (QCircleFuelTopView.b(this.a) != null) {
      QCircleLauncher.a(this.a.getContext(), QCircleJsUrlConfig.a(QCircleFuelTopView.b(this.a), "tagFuelRankUrl"), null, -1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFuelTopView.1
 * JD-Core Version:    0.7.0.1
 */