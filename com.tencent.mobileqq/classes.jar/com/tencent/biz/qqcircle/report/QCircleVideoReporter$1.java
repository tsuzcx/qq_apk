package com.tencent.biz.qqcircle.report;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

class QCircleVideoReporter$1
  implements Runnable
{
  QCircleVideoReporter$1(QCircleVideoReporter paramQCircleVideoReporter, Object paramObject, long paramLong, String paramString, List paramList) {}
  
  public void run()
  {
    QQCircleReport.SingleDcData localSingleDcData = new QQCircleReport.SingleDcData();
    localSingleDcData.dcid.set(5530);
    if (this.a == null)
    {
      QLog.w("QCircleVideoReporter", 1, "reportVideoEvent feed is null");
      return;
    }
    localSingleDcData.report_data.addAll(QCircleVideoReporter.a(this.b, this.c, this.a));
    List localList = this.d;
    if ((localList != null) && (!localList.isEmpty())) {
      localSingleDcData.report_data.addAll(this.d);
    }
    QCircleVideoReporter.a(this.this$0).add(localSingleDcData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleVideoReporter.1
 * JD-Core Version:    0.7.0.1
 */