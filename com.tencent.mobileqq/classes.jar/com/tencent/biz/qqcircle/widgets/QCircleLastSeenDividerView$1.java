package com.tencent.biz.qqcircle.widgets;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.event.QCircleSelectTabEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;

class QCircleLastSeenDividerView$1
  implements View.OnClickListener
{
  QCircleLastSeenDividerView$1(QCircleLastSeenDividerView paramQCircleLastSeenDividerView, String paramString, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    if (TextUtils.isEmpty(this.a)) {
      SimpleEventBus.getInstance().dispatchEvent(new QCircleSelectTabEvent(6));
    } else {
      QCircleLauncher.a(this.c.getContext(), this.a);
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(this.b).setActionType(120).setSubActionType(2).setPageId(this.c.getPageId())));
    QCircleLastSeenDividerView.a(this.c);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleLastSeenDividerView.1
 * JD-Core Version:    0.7.0.1
 */