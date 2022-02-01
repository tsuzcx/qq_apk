package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;

class QCircleDefaultMessagePresenter$2
  implements View.OnClickListener
{
  QCircleDefaultMessagePresenter$2(QCircleDefaultMessagePresenter paramQCircleDefaultMessagePresenter) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.a;
    boolean bool = false;
    localObject = QCircleDefaultMessagePresenter.a((QCircleDefaultMessagePresenter)localObject, false);
    if (localObject != null)
    {
      this.a.a(paramView);
      ((QCircleLayerBean)localObject).setFromReportBean(this.a.d().clone());
      if (QCircleConfigHelper.a("qqcircle", "qqcircle_push_feeddetail_recom", Integer.valueOf(0)).intValue() == 0) {
        bool = true;
      }
      ((QCircleLayerBean)localObject).setSingleFeed(bool);
      QCircleLauncher.a(paramView.getContext(), (QCircleInitBean)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleDefaultMessagePresenter.2
 * JD-Core Version:    0.7.0.1
 */