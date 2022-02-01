package com.tencent.biz.qqcircle.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.QCircleJsUrlConfig;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.utils.StringUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import java.util.List;
import qqcircle.QQCircleDitto.StItemContainer;

class QCirclePushRankTopView$1
  implements View.OnClickListener
{
  QCirclePushRankTopView$1(QCirclePushRankTopView paramQCirclePushRankTopView) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.getData() != null) && (QCirclePushRankTopView.c(this.a) != null) && (QCirclePushRankTopView.c(this.a).size() > QCirclePushRankTopView.d(this.a)) && (QCirclePushRankTopView.c(this.a).get(QCirclePushRankTopView.d(this.a)) != null))
    {
      Object localObject = QCircleJsUrlConfig.a(((QQCircleDitto.StItemContainer)QCirclePushRankTopView.c(this.a).get(QCirclePushRankTopView.d(this.a))).urlInfo.get(), "RankItemUrl");
      if (StringUtil.a((String)localObject)) {
        QLog.w("QCirclePushRankTopView", 1, "rank url is empty");
      }
      QCircleLauncher.a(this.a.getContext(), (String)localObject, null, -1);
      localObject = new QCircleLpReportDc05504.DataBuilder().setActionType(9).setSubActionType(4).setThrActionType(0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((QQCircleDitto.StItemContainer)QCirclePushRankTopView.c(this.a).get(QCirclePushRankTopView.d(this.a))).containerType.get());
      localStringBuilder.append("");
      QCircleLpReportDc05504.report(((QCircleLpReportDc05504.DataBuilder)localObject).setExt1(localStringBuilder.toString()).setFeedReportInfo(QCirclePushRankTopView.e(this.a)).setPageId(this.a.getPageId()));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushRankTopView.1
 * JD-Core Version:    0.7.0.1
 */