package com.tencent.biz.qqcircle.immersive.tab;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

class QFSNearbyTabFragment$7
  implements View.OnClickListener
{
  QFSNearbyTabFragment$7(QFSNearbyTabFragment paramQFSNearbyTabFragment) {}
  
  public void onClick(View paramView)
  {
    QFSNearbyTabFragment.e(this.a);
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(94).setSubActionType(6));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.tab.QFSNearbyTabFragment.7
 * JD-Core Version:    0.7.0.1
 */