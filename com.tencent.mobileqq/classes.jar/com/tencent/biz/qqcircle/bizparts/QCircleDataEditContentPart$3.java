package com.tencent.biz.qqcircle.bizparts;

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
import java.util.List;

class QCircleDataEditContentPart$3
  implements QCircleTroopTagListView.EventListener
{
  QCircleDataEditContentPart$3(QCircleDataEditContentPart paramQCircleDataEditContentPart) {}
  
  public void a(long paramLong)
  {
    if (QCircleDataEditContentPart.c(this.a) != null)
    {
      QCircleDataEditContentPart.c(this.a).remove(Long.valueOf(paramLong));
      QCircleDataEditContentPart.d(this.a);
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(QCircleDataEditContentPart.b(this.a).id.get()).setActionType(11).setSubActionType(25).setThrActionType(7).setExt2(String.valueOf(paramLong)).setPageId(this.a.f()));
    }
  }
  
  public void b(long paramLong)
  {
    Bundle localBundle = HostStaticInvokeHelper.getTroopProfileExtra(String.valueOf(paramLong));
    localBundle.putBoolean(QCircleHostConstants.AppConstants.Key.TROOP_INFO_FROM_TROOPSETTING(), true);
    localBundle.putInt("exposureSource", 3);
    HostRouteUtils.openTroopInfoActivity(this.a.g(), localBundle);
    VSNetworkHelper.getInstance().sendRequest(this.a.g(), new QCircleJoinGroupReportRequest(paramLong), new QCircleDataEditContentPart.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleDataEditContentPart.3
 * JD-Core Version:    0.7.0.1
 */