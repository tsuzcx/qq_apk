package com.tencent.mobileqq.activity.qwallet.report;

import VACDReport.ReportHeader;
import akwc;
import akwd;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class VACDReportMgr$6
  implements Runnable
{
  public VACDReportMgr$6(akwd paramakwd, List paramList) {}
  
  public void run()
  {
    if ((this.a == null) || (this.a.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VACDReport", 2, "handleReponse headers is null or empty");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VACDReport", 2, "handleReponse, headers= " + this.a);
    }
    synchronized (akwd.a())
    {
      ArrayList localArrayList = new ArrayList(8);
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ReportHeader localReportHeader = (ReportHeader)localIterator.next();
        if (localReportHeader != null)
        {
          if (localReportHeader.result == 0)
          {
            localArrayList.add(Long.valueOf(localReportHeader.seqno));
            akwd.a(this.this$0).remove(Long.valueOf(localReportHeader.seqno));
          }
          akwd.b(this.this$0).remove(Long.valueOf(localReportHeader.seqno));
        }
      }
    }
    if (!localList.isEmpty()) {
      akwd.a(this.this$0).a(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.report.VACDReportMgr.6
 * JD-Core Version:    0.7.0.1
 */