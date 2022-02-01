package com.tencent.biz.qqcircle.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

class QCircleLightInteractPolyLikeWidget$2
  implements View.OnClickListener
{
  QCircleLightInteractPolyLikeWidget$2(QCircleLightInteractPolyLikeWidget paramQCircleLightInteractPolyLikeWidget, FeedCloudMeta.StUser paramStUser) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new QCircleInitBean();
    ((QCircleInitBean)localObject).setUser(this.a);
    ((QCircleInitBean)localObject).setFromReportBean(this.b.getReportBean().clone());
    QCircleLauncher.b(paramView.getContext(), (QCircleInitBean)localObject);
    if (this.b.d != null) {
      localObject = this.b.d.mFeed;
    } else {
      localObject = null;
    }
    localObject = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject);
    int i;
    if (paramView == QCircleLightInteractPolyLikeWidget.a(this.b)) {
      i = 71;
    } else {
      i = 72;
    }
    QCircleLpReportDc05501.DataBuilder localDataBuilder = ((QCircleLpReportDc05501.DataBuilder)localObject).setActionType(i).setSubActionType(2);
    if ((this.b.d != null) && (this.b.d.mFeed != null)) {
      localObject = this.b.d.mFeed.poster.id.get();
    } else {
      localObject = "";
    }
    localObject = localDataBuilder.setToUin((String)localObject);
    if (this.b.d != null) {
      i = this.b.d.mDataPosition;
    } else {
      i = -1;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject).setIndex(i).setPageId(this.b.getPageId())));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleLightInteractPolyLikeWidget.2
 * JD-Core Version:    0.7.0.1
 */