package com.tencent.biz.qqcircle.immersive.tab;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

class QFSNearbyTabFragment$2
  implements View.OnClickListener
{
  QFSNearbyTabFragment$2(QFSNearbyTabFragment paramQFSNearbyTabFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.m != null)
    {
      this.a.m.c("publish_on_click", null);
      QLog.d(QFSNearbyTabFragment.x, 1, "onClick jump btn in empty view");
    }
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(94).setSubActionType(5));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.tab.QFSNearbyTabFragment.2
 * JD-Core Version:    0.7.0.1
 */