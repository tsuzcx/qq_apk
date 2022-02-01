package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import qqcircle.QQCircleFeedBase.StSimulateData;
import qqcircle.QQCircleFeedBase.StVideoBusiData;

class QCircleFeedItemVideoPresenter$1
  implements View.OnClickListener
{
  QCircleFeedItemVideoPresenter$1(QCircleFeedItemVideoPresenter paramQCircleFeedItemVideoPresenter, QQCircleFeedBase.StVideoBusiData paramStVideoBusiData) {}
  
  public void onClick(View paramView)
  {
    if (QCircleConfigHelper.aE())
    {
      QCircleLauncher.a(paramView.getContext(), this.a.simulate_date.simulate_schema.get());
    }
    else
    {
      QQCircleFeedBase.StSimulateData localStSimulateData = new QQCircleFeedBase.StSimulateData();
      localStSimulateData.material_id.set(this.a.simulate_date.material_id.get());
      localStSimulateData.simulate_name.set(this.a.simulate_date.simulate_name.get());
      localStSimulateData.simulate_schema.set(HostStaticInvokeHelper.getQCircleSchemeFromJumpUtil(this.a.simulate_date.material_id.get(), ""));
      QCirclePolymerizationBean localQCirclePolymerizationBean = new QCirclePolymerizationBean();
      localQCirclePolymerizationBean.setSimulateData(localStSimulateData);
      localQCirclePolymerizationBean.setPolymerizationType(20);
      localQCirclePolymerizationBean.setExt1From(1);
      QCircleLauncher.a(paramView.getContext(), localQCirclePolymerizationBean);
    }
    QCircleFeedItemVideoPresenter.access$000(this.b, 86, 2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemVideoPresenter.1
 * JD-Core Version:    0.7.0.1
 */