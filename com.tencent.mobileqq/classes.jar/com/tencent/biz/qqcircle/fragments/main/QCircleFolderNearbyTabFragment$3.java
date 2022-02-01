package com.tencent.biz.qqcircle.fragments.main;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

class QCircleFolderNearbyTabFragment$3
  implements View.OnClickListener
{
  QCircleFolderNearbyTabFragment$3(QCircleFolderNearbyTabFragment paramQCircleFolderNearbyTabFragment) {}
  
  public void onClick(View paramView)
  {
    if (QCircleFolderNearbyTabFragment.f(this.a) != null)
    {
      QCircleFolderNearbyTabFragment.g(this.a).c("publish_on_click", null);
      QLog.d(QCircleFolderNearbyTabFragment.B, 1, "onClick jump btn in empty view");
    }
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(94).setSubActionType(5));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.QCircleFolderNearbyTabFragment.3
 * JD-Core Version:    0.7.0.1
 */