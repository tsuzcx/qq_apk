package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StUser;

class QCircleBaseMessagePresenter$4
  implements View.OnClickListener
{
  QCircleBaseMessagePresenter$4(QCircleBaseMessagePresenter paramQCircleBaseMessagePresenter) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.d != null) && (!TextUtils.isEmpty(this.a.d.operation.opUser.id.get())))
    {
      if (paramView.getId() == 2131436271) {
        this.a.a(8);
      } else if (paramView.getId() == 2131448603) {
        this.a.a(9);
      }
      QCircleInitBean localQCircleInitBean = new QCircleInitBean();
      localQCircleInitBean.setUin(this.a.d.operation.opUser.id.get());
      localQCircleInitBean.setFromReportBean(this.a.d().clone());
      if (!TextUtils.isEmpty(this.a.d.operation.opUser.jumpUrl.get()))
      {
        this.a.b();
        QCircleLauncher.a(paramView.getContext(), this.a.d.operation.opUser.jumpUrl.get());
      }
      else
      {
        QCircleLauncher.b(paramView.getContext(), localQCircleInitBean);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleBaseMessagePresenter.4
 * JD-Core Version:    0.7.0.1
 */