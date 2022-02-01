package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.richframework.part.Part;
import cooperation.qqcircle.report.QCircleReportBean;

public abstract class QCircleBasePart
  extends Part
  implements ReportBean<QCircleReportBean>
{
  protected QCircleReportBean b;
  
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
  
  protected int e()
  {
    return QCircleReportBean.getParentPageId(a(), this.b);
  }
  
  protected int f()
  {
    return QCircleReportBean.getPageId(a(), this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleBasePart
 * JD-Core Version:    0.7.0.1
 */