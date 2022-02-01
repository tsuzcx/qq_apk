package com.tencent.biz.qqcircle.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleDitto.StBackCardDP;

class QCircleFatePersonView$4
  implements View.OnClickListener
{
  QCircleFatePersonView$4(QCircleFatePersonView paramQCircleFatePersonView, QQCircleDitto.StBackCardDP paramStBackCardDP) {}
  
  public void onClick(View paramView)
  {
    QCircleLayerBean localQCircleLayerBean = new QCircleLayerBean();
    localQCircleLayerBean.setFeed((FeedCloudMeta.StFeed)this.a.recomFeed.get());
    localQCircleLayerBean.setSingleFeed(true);
    QCircleLauncher.a(this.b.getContext(), localQCircleLayerBean);
    if ((QCircleFatePersonView.a(this.b) != null) && (QCircleFatePersonView.b(this.b) != null)) {
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(QCircleFatePersonView.a(this.b)).setToUin(QCircleFatePersonView.b(this.b).id.get()).setActionType(101).setSubActionType(5).setIndex(0).setPageId(this.b.getPageId())));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFatePersonView.4
 * JD-Core Version:    0.7.0.1
 */