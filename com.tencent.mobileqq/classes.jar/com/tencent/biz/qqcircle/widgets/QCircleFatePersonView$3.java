package com.tencent.biz.qqcircle.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleDitto.StBackCardDP;
import qqcircle.QQCircleDitto.StButton;

class QCircleFatePersonView$3
  implements View.OnClickListener
{
  QCircleFatePersonView$3(QCircleFatePersonView paramQCircleFatePersonView, QQCircleDitto.StBackCardDP paramStBackCardDP) {}
  
  public void onClick(View paramView)
  {
    if (((QQCircleDitto.StButton)this.a.buttons.get(0)).jumpUrl.get().length() > 0) {
      QCircleHostLauncher.doJumpAction(this.b.getContext(), ((QQCircleDitto.StButton)this.a.buttons.get(0)).jumpUrl.get());
    } else {
      QLog.w(this.b.getLogTag(), 1, "back card button jumpUrl is invalid");
    }
    if ((QCircleFatePersonView.a(this.b) != null) && (QCircleFatePersonView.b(this.b) != null)) {
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(QCircleFatePersonView.a(this.b)).setToUin(QCircleFatePersonView.b(this.b).id.get()).setActionType(101).setSubActionType(4).setIndex(0).setPageId(this.b.getPageId())));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFatePersonView.3
 * JD-Core Version:    0.7.0.1
 */