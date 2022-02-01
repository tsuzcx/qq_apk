package com.tencent.biz.qqcircle.report;

import com.tencent.biz.qqcircle.utils.QCircleProtoUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReporter;
import java.util.ArrayList;
import java.util.List;

class QCircleVideoReporter$2
  implements Runnable
{
  QCircleVideoReporter$2(QCircleVideoReporter paramQCircleVideoReporter) {}
  
  public void run()
  {
    if (QCircleVideoReporter.a(this.this$0) != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("flushVideoReportEvents event size:");
      ((StringBuilder)localObject).append(QCircleVideoReporter.a(this.this$0).size());
      QLog.d("QCircleVideoReporter", 1, ((StringBuilder)localObject).toString());
      localObject = new ArrayList(QCircleVideoReporter.a(this.this$0));
      QCircleReporter.getInstance().flushVideoReportByByte(QCircleProtoUtil.c((List)localObject));
      QCircleVideoReporter.a(this.this$0).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleVideoReporter.2
 * JD-Core Version:    0.7.0.1
 */