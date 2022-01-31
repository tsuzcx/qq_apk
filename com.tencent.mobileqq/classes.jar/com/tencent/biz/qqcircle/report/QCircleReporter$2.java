package com.tencent.biz.qqcircle.report;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;
import tzy;
import uab;

public class QCircleReporter$2
  implements Runnable
{
  public QCircleReporter$2(uab paramuab, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (uab.a(this.this$0).size() == 0) {
      return;
    }
    QLog.w("QCircleReporter", 2, "reportCacheDataListToServer size:" + uab.a(this.this$0).size());
    Iterator localIterator = uab.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((QQCircleReport.SingleDcData)localIterator.next()).byteExtinfo.add(tzy.a("SessionID", this.a));
    }
    uab.a(this.this$0, uab.a(this.this$0));
    uab.a(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleReporter.2
 * JD-Core Version:    0.7.0.1
 */