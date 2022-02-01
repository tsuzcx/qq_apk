package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

final class QCircleFeedItemBottomPresenter$5
  implements DialogInterface.OnClickListener
{
  QCircleFeedItemBottomPresenter$5(Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QCircleFeedItemBottomPresenter.access$202(false);
    if (paramInt == 1)
    {
      paramDialogInterface = QCirclePluginConfig.a();
      if (paramDialogInterface != null)
      {
        paramDialogInterface = paramDialogInterface.v();
        QCircleLauncher.a(this.a, paramDialogInterface, null, -1);
      }
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(53).setSubActionType(2).setThrActionType(0));
      return;
    }
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(53).setSubActionType(3).setThrActionType(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemBottomPresenter.5
 * JD-Core Version:    0.7.0.1
 */