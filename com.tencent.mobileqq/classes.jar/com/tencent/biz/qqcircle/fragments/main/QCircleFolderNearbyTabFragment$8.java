package com.tencent.biz.qqcircle.fragments.main;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

class QCircleFolderNearbyTabFragment$8
  implements View.OnClickListener
{
  QCircleFolderNearbyTabFragment$8(QCircleFolderNearbyTabFragment paramQCircleFolderNearbyTabFragment) {}
  
  public void onClick(View paramView)
  {
    QCircleFolderNearbyTabFragment.l(this.a);
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(94).setSubActionType(6));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.QCircleFolderNearbyTabFragment.8
 * JD-Core Version:    0.7.0.1
 */