package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.QCircleJsUrlConfig;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleFeedBase.StNoticeBusiData;

class QCircleKolMessagePresenter$1
  implements View.OnClickListener
{
  QCircleKolMessagePresenter$1(QCircleKolMessagePresenter paramQCircleKolMessagePresenter, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if ((this.b.e != null) && (this.b.e.busiInfo.get() != null))
    {
      Object localObject = QCircleJsUrlConfig.a(this.b.e.busiInfo.get(), "noticeFeedJumpUrl");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clickSystemMessage get jumpUrl");
      localStringBuilder.append((String)localObject);
      QLog.i("QCircleKolMessagePresenter", 1, localStringBuilder.toString());
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        QCircleLauncher.a(this.a, (String)localObject);
      }
      if (this.b.d != null)
      {
        localObject = new QCircleLpReportDc05504.DataBuilder().setToUin(this.b.d.operation.opUser.id.get()).setActionType(17).setSubActionType(18).setThrActionType(1);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.b.l);
        localStringBuilder.append("");
        QCircleLpReportDc05504.report(((QCircleLpReportDc05504.DataBuilder)localObject).setExt5(localStringBuilder.toString()).setExt6(this.b.d.operation.opUser.id.get()).setPageId(0).setfPageId(0));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleKolMessagePresenter.1
 * JD-Core Version:    0.7.0.1
 */