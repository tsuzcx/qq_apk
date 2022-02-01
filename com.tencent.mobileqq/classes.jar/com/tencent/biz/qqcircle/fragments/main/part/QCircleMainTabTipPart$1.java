package com.tencent.biz.qqcircle.fragments.main.part;

import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

class QCircleMainTabTipPart$1
  implements Runnable
{
  QCircleMainTabTipPart$1(QCircleMainTabTipPart paramQCircleMainTabTipPart, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a)
    {
      QCircleMainTabTipPart.a(this.this$0);
      return;
    }
    QCircleMainTabTipPart.b(this.this$0);
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(78).setSubActionType(4).setExt6("1"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.part.QCircleMainTabTipPart.1
 * JD-Core Version:    0.7.0.1
 */