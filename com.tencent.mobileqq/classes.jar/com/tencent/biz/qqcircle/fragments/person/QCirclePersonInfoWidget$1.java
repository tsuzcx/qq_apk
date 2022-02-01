package com.tencent.biz.qqcircle.fragments.person;

import android.os.Bundle;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.AppConstants.Key;
import com.tencent.biz.qcircleshadow.lib.variation.HostRouteUtils;
import com.tencent.biz.qqcircle.requests.QCircleJoinGroupReportRequest;
import com.tencent.biz.qqcircle.widgets.QCircleTroopTagListView.EventListener;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StUser;

class QCirclePersonInfoWidget$1
  implements QCircleTroopTagListView.EventListener
{
  QCirclePersonInfoWidget$1(QCirclePersonInfoWidget paramQCirclePersonInfoWidget) {}
  
  public void a(long paramLong) {}
  
  public void b(long paramLong)
  {
    Bundle localBundle = HostStaticInvokeHelper.getTroopProfileExtra(String.valueOf(paramLong));
    localBundle.putBoolean(QCircleHostConstants.AppConstants.Key.TROOP_INFO_FROM_TROOPSETTING(), true);
    localBundle.putInt("exposureSource", 3);
    HostRouteUtils.openTroopInfoActivity(this.a.getContext(), localBundle);
    VSNetworkHelper.getInstance().sendRequest(this.a.getContext(), new QCircleJoinGroupReportRequest(paramLong), new QCirclePersonInfoWidget.1.1(this));
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(QCirclePersonInfoWidget.b(this.a).id.get()).setActionType(11).setSubActionType(31).setThrActionType(2).setPageId(QCirclePersonInfoWidget.a(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonInfoWidget.1
 * JD-Core Version:    0.7.0.1
 */