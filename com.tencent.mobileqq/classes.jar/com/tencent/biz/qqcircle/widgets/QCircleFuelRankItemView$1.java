package com.tencent.biz.qqcircle.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.bizparts.QCircleTagHeaderPart;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StRankingItem;

class QCircleFuelRankItemView$1
  implements View.OnClickListener
{
  QCircleFuelRankItemView$1(QCircleFuelRankItemView paramQCircleFuelRankItemView, FeedCloudMeta.StRankingItem paramStRankingItem) {}
  
  public void onClick(View paramView)
  {
    if (QCircleFuelRankItemView.a(this.b) != null)
    {
      localObject = this.b;
      QCircleFuelRankItemView.a((QCircleFuelRankItemView)localObject, "", 89, 1, ((QCircleTagHeaderPart)QCircleFuelRankItemView.a((QCircleFuelRankItemView)localObject)).i());
    }
    Object localObject = new QCircleInitBean();
    ((QCircleInitBean)localObject).setUser(this.a.user);
    ((QCircleInitBean)localObject).setFromReportBean(this.b.getReportBean().clone());
    QCircleLauncher.b(paramView.getContext(), (QCircleInitBean)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFuelRankItemView.1
 * JD-Core Version:    0.7.0.1
 */