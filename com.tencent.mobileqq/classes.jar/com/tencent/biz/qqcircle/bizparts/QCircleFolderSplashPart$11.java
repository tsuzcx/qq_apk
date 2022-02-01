package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.QCirclePopupWindowHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

class QCircleFolderSplashPart$11
  implements View.OnClickListener
{
  QCircleFolderSplashPart$11(QCircleFolderSplashPart paramQCircleFolderSplashPart) {}
  
  public void onClick(View paramView)
  {
    QLog.d("QCircleFolderSplashPart", 4, "btn onClick");
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(19).setSubActionType(13).setThrActionType(0));
    QCirclePopupWindowHelper.a().a(false);
    QCircleFolderSplashPart.d(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleFolderSplashPart.11
 * JD-Core Version:    0.7.0.1
 */