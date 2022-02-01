package com.tencent.biz.qqcircle.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StUser;

class QCircleFatePersonView$8
  implements View.OnClickListener
{
  QCircleFatePersonView$8(QCircleFatePersonView paramQCircleFatePersonView) {}
  
  public void onClick(View paramView)
  {
    if (QCircleFatePersonView.b(this.a) != null)
    {
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(QCircleFatePersonView.a(this.a)).setToUin(QCircleFatePersonView.b(this.a).id.get()).setActionType(101).setSubActionType(4).setIndex(0).setPageId(this.a.getPageId())));
      QCircleInitBean localQCircleInitBean = new QCircleInitBean();
      localQCircleInitBean.setUser((FeedCloudMeta.StUser)QCircleFatePersonView.b(this.a).get());
      QCircleLauncher.b(this.a.getContext(), localQCircleInitBean);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFatePersonView.8
 * JD-Core Version:    0.7.0.1
 */