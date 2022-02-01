package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleFeedBase.StImageBusiData;
import qqcircle.QQCircleFeedBase.StSimulateData;

class QCircleFeedItemPicPresenter$MultiPicAdapter$4
  implements View.OnClickListener
{
  QCircleFeedItemPicPresenter$MultiPicAdapter$4(QCircleFeedItemPicPresenter.MultiPicAdapter paramMultiPicAdapter, QQCircleFeedBase.StImageBusiData paramStImageBusiData) {}
  
  public void onClick(View paramView)
  {
    boolean bool = QCircleConfigHelper.aE();
    String str = "";
    if (bool)
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
      ((QCirclePolymerizationBean)localObject2).setExt1From(1);
      QCircleLauncher.a(paramView.getContext(), (QCirclePolymerizationBean)localObject2);
    }
    if (this.b.a.mReportInfo != null) {
      localObject1 = this.b.a.mReportInfo.mFeed;
    } else {
      localObject1 = null;
    }
    Object localObject2 = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject1).setActionType(86).setSubActionType(2);
    Object localObject1 = str;
    if (this.b.a.mReportInfo != null)
    {
      localObject1 = str;
      if (this.b.a.mReportInfo.mFeed != null) {
        localObject1 = this.b.a.mReportInfo.mFeed.poster.id.get();
      }
    }
    localObject1 = ((QCircleLpReportDc05501.DataBuilder)localObject2).setToUin((String)localObject1);
    int i;
    if (this.b.a.mReportInfo != null) {
      i = this.b.a.mReportInfo.mDataPosition;
    } else {
      i = -1;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject1).setIndex(i).setPageId(this.b.a.getPageId())));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemPicPresenter.MultiPicAdapter.4
 * JD-Core Version:    0.7.0.1
 */