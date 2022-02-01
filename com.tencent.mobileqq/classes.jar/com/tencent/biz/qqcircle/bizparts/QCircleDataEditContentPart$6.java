package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import com.tencent.biz.qqcircle.fragments.person.QCircleTroopAddPopupWindow;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleProfile.CheckBindGroupRsp;

class QCircleDataEditContentPart$6
  implements VSDispatchObserver.onVSRspCallBack<QQCircleProfile.CheckBindGroupRsp>
{
  QCircleDataEditContentPart$6(QCircleDataEditContentPart paramQCircleDataEditContentPart, List paramList) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleProfile.CheckBindGroupRsp paramCheckBindGroupRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramCheckBindGroupRsp != null))
    {
      paramBaseRequest = new StringBuilder();
      paramBaseRequest.append("requestCheckBindGroup success:");
      paramBaseRequest.append(paramLong);
      QLog.d("QCircleDataEditContentP", 1, paramBaseRequest.toString());
      QCircleDataEditContentPart.e(this.b).l();
      QCircleDataEditContentPart.e(this.b).d(this.b.c().getString(2131892267));
      QCircleDataEditContentPart.e(this.b).a("");
      QCircleDataEditContentPart.e(this.b).b(null);
      QCircleDataEditContentPart.e(this.b).dismiss();
      if (QCircleDataEditContentPart.c(this.b) == null) {
        QCircleDataEditContentPart.b(this.b, new ArrayList());
      }
      paramBaseRequest = this.a.iterator();
      while (paramBaseRequest.hasNext())
      {
        paramLong = ((Long)paramBaseRequest.next()).longValue();
        if (!QCircleDataEditContentPart.c(this.b).contains(Long.valueOf(paramLong))) {
          QCircleDataEditContentPart.c(this.b).add(Long.valueOf(paramLong));
        }
      }
      QCircleDataEditContentPart.d(this.b);
      QCircleToast.a(QCircleToast.d, this.b.c().getString(2131895934), 0);
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(QCircleDataEditContentPart.b(this.b).id.get()).setActionType(11).setSubActionType(25).setThrActionType(6).setExt2(String.valueOf(this.a.get(0))).setPageId(this.b.f()));
      return;
    }
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("requestCheckBindGroup error:");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append("  errorMsg:");
    paramBaseRequest.append(paramString);
    QLog.e("QCircleDataEditContentP", 1, paramBaseRequest.toString());
    QCircleDataEditContentPart.e(this.b).l();
    QCircleDataEditContentPart.e(this.b).d(this.b.c().getString(2131892267));
    QCircleToast.a(QCircleToast.c, paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleDataEditContentPart.6
 * JD-Core Version:    0.7.0.1
 */