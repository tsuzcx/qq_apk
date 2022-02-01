package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.comment.QCircleBaseInputPopupWindow.EventListener;
import com.tencent.biz.qqcircle.fragments.person.QCircleTroopAddPopupWindow;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StUser;
import java.util.Collections;
import java.util.List;

class QCircleDataEditContentPart$5
  implements QCircleBaseInputPopupWindow.EventListener
{
  QCircleDataEditContentPart$5(QCircleDataEditContentPart paramQCircleDataEditContentPart) {}
  
  public void a()
  {
    QLog.d("QCircleDataEditContentP", 1, "onClickSend()");
    if ((!this.a.c().isFinishing()) && (QCircleDataEditContentPart.e(this.a) != null))
    {
      String str = QCircleDataEditContentPart.e(this.a).g();
      if (TextUtils.isEmpty(str.trim()))
      {
        QCircleToast.a(this.a.c().getString(2131895931), 0);
      }
      else if (!HostNetworkUtils.isNetworkAvailable())
      {
        QCircleToast.a(QCircleToast.c, this.a.c().getString(2131892113), 0);
      }
      else if (QCircleDataEditContentPart.c(this.a).contains(Long.valueOf(Long.parseLong(str))))
      {
        QCircleToast.a(QCircleToast.c, this.a.c().getString(2131895933), 0);
      }
      else
      {
        QCircleDataEditContentPart.e(this.a).k();
        QCircleDataEditContentPart.e(this.a).d("");
        QCircleDataEditContentPart.a(this.a, Collections.singletonList(Long.valueOf(Long.parseLong(str))));
      }
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(QCircleDataEditContentPart.b(this.a).id.get()).setActionType(11).setSubActionType(25).setThrActionType(5).setExt2(str).setPageId(this.a.f()));
      return;
    }
    QLog.d("QCircleDataEditContentP", 1, "onCommentSend(): mTroopAddInputPopupWindow null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleDataEditContentPart.5
 * JD-Core Version:    0.7.0.1
 */