package com.tencent.biz.qqcircle.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.QCircleJsUrlConfig;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import qqcircle.QQCircleDitto.StItemContainer;

class QCircleTagRecommendWidget$1
  implements View.OnClickListener
{
  QCircleTagRecommendWidget$1(QCircleTagRecommendWidget paramQCircleTagRecommendWidget) {}
  
  public void onClick(View paramView)
  {
    if (QCircleTagRecommendWidget.a(this.a) != null) {
      QCircleLauncher.a(this.a.getContext(), QCircleJsUrlConfig.a(QCircleTagRecommendWidget.a(this.a).urlInfo.get(), "smallWordRecomListUrl"), null, -1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTagRecommendWidget.1
 * JD-Core Version:    0.7.0.1
 */