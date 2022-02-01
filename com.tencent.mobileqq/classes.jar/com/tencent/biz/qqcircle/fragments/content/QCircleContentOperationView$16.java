package com.tencent.biz.qqcircle.fragments.content;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import qqcircle.QQCircleFeedBase.StSimulateData;
import qqcircle.QQCircleFeedBase.StVideoBusiData;

class QCircleContentOperationView$16
  implements View.OnClickListener
{
  QCircleContentOperationView$16(QCircleContentOperationView paramQCircleContentOperationView, QQCircleFeedBase.StVideoBusiData paramStVideoBusiData) {}
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if (QCircleConfigHelper.aE())
    {
      QCircleLauncher.a(paramView.getContext(), this.a.simulate_date.simulate_schema.get());
    }
    else
    {
      localObject1 = new QQCircleFeedBase.StSimulateData();
      ((QQCircleFeedBase.StSimulateData)localObject1).material_id.set(this.a.simulate_date.material_id.get());
      ((QQCircleFeedBase.StSimulateData)localObject1).simulate_name.set(this.a.simulate_date.simulate_name.get());
      ((QQCircleFeedBase.StSimulateData)localObject1).simulate_schema.set(HostStaticInvokeHelper.getQCircleSchemeFromJumpUtil(this.a.simulate_date.material_id.get(), ""));
      localObject2 = new QCirclePolymerizationBean();
      ((QCirclePolymerizationBean)localObject2).setSimulateData((QQCircleFeedBase.StSimulateData)localObject1);
      ((QCirclePolymerizationBean)localObject2).setPolymerizationType(20);
      ((QCirclePolymerizationBean)localObject2).setExt1From(2);
      QCircleLauncher.a(paramView.getContext(), (QCirclePolymerizationBean)localObject2);
    }
    Object localObject2 = this.b;
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = ((QCircleContentOperationView)localObject2).getExtraTypeInfo();
    if (QCircleContentOperationView.a(this.b)) {
      localObject1 = "1";
    } else {
      localObject1 = "2";
    }
    QCircleContentOperationView.a((QCircleContentOperationView)localObject2, 83, 2, localQCircleExtraTypeInfo, (String)localObject1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView.16
 * JD-Core Version:    0.7.0.1
 */