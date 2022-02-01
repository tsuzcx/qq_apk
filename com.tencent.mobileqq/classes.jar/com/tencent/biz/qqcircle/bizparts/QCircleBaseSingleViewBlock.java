package com.tencent.biz.qqcircle.bizparts;

import android.os.Bundle;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.richframework.part.extendsblock.SingleViewBlock;
import cooperation.qqcircle.report.QCircleReportBean;

public abstract class QCircleBaseSingleViewBlock
  extends SingleViewBlock
  implements ReportBean<QCircleReportBean>
{
  protected QCircleReportBean b;
  
  public QCircleBaseSingleViewBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected abstract String a();
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.b = QCircleReportBean.setReportBean(a(), paramQCircleReportBean);
  }
  
  public QCircleReportBean d()
  {
    if (this.b == null) {
      this.b = new QCircleReportBean();
    }
    return QCircleReportBean.getReportBean(a(), this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleBaseSingleViewBlock
 * JD-Core Version:    0.7.0.1
 */