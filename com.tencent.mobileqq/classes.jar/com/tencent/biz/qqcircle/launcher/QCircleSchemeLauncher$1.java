package com.tencent.biz.qqcircle.launcher;

import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import cooperation.qqcircle.report.datong.QCircleDTLoginReporter;
import java.util.HashMap;

final class QCircleSchemeLauncher$1
  implements Runnable
{
  QCircleSchemeLauncher$1(QCircleSchemeBean paramQCircleSchemeBean) {}
  
  public void run()
  {
    QCircleSchemeBean localQCircleSchemeBean = this.a;
    if ((localQCircleSchemeBean != null) && (localQCircleSchemeBean.getAttrs() != null))
    {
      if (this.a.getAttrs().containsKey("hydtgzh")) {
        QCircleHostLauncher.reportDC02880(2, 2, null, (String)this.a.getAttrs().get("hydtgzh"), (String)this.a.getAttrs().get("reverses6"));
      }
      QCircleDTLoginReporter.daTongLoginReport(this.a.getSchemeAction(), this.a.getAttrs());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher.1
 * JD-Core Version:    0.7.0.1
 */