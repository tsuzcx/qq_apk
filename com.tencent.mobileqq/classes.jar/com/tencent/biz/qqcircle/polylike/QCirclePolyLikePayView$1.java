package com.tencent.biz.qqcircle.polylike;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;

class QCirclePolyLikePayView$1
  implements DialogInterface.OnClickListener
{
  QCirclePolyLikePayView$1(QCirclePolyLikePayView paramQCirclePolyLikePayView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QCirclePolyLikePayView.a(this.a).cancel();
    paramDialogInterface = this.a;
    QCirclePolyLikePayView.a(paramDialogInterface, 95, 2, paramDialogInterface.getQCircleExtraTypeInfo());
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(this.a.getFeed()).setToUin(String.valueOf(QCirclePluginUtil.c())).setActionType(95).setSubActionType(2).setIndex(QCirclePolyLikePayView.b(this.a)).setPageId(this.a.getReportBean().getPageId())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikePayView.1
 * JD-Core Version:    0.7.0.1
 */