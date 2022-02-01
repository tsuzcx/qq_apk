package com.tencent.mobileqq.activity;

import aesx;
import android.widget.TextView;
import anxl;
import arpq;
import bcvr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.report.lp.LinkReport;
import java.util.HashMap;

class Leba$31
  implements Runnable
{
  Leba$31(Leba paramLeba, arpq paramarpq) {}
  
  public void run()
  {
    boolean bool = true;
    if ((Leba.a(this.this$0) != null) && (Leba.a(this.this$0).getVisibility() == 0)) {}
    try
    {
      this.this$0.a(null, true, this.a);
      ThreadRegulator.a().a(4);
      ThreadRegulator.a().a(4, 2000L);
      Leba.d(this.this$0, true);
      bcvr localbcvr = (bcvr)this.this$0.a.getManager(QQManagerFactory.QZONE_MANAGER);
      if (localbcvr != null)
      {
        if ((localbcvr.a(1) <= 0) && (localbcvr.a(2) <= 0))
        {
          Object localObject = new QZoneClickReport.ReportInfo();
          ((QZoneClickReport.ReportInfo)localObject).actionType = "1";
          ((QZoneClickReport.ReportInfo)localObject).subactionType = "0";
          ((QZoneClickReport.ReportInfo)localObject).tabletype = 4;
          ((QZoneClickReport.ReportInfo)localObject).sourceType = "3";
          ((QZoneClickReport.ReportInfo)localObject).sourceFrom = "mainEntrance";
          ((QZoneClickReport.ReportInfo)localObject).sourceTo = "activefeed";
          QZoneClickReport.report(this.this$0.a.getAccount(), (QZoneClickReport.ReportInfo)localObject, false);
          localObject = new HashMap();
          ((HashMap)localObject).put("source_type", "3");
          ((HashMap)localObject).put("source_from", "mainEntrance");
          ((HashMap)localObject).put("source_to", "activefeed");
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.this$0.a.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject, null);
        }
        if ((this.this$0.a.getLebaHelper() == null) || (!this.this$0.a.getLebaHelper().a())) {
          break label322;
        }
        aesx.a(localbcvr, false, bool);
        if ((Leba.b(this.this$0) != null) && (Leba.b(this.this$0).getVisibility() == 0))
        {
          localbcvr.c(3);
          localbcvr.c(61);
          localbcvr.c(6);
        }
      }
      LinkReport.reportClickQZoneEntry(this.this$0.a.getCurrentUin());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.i("Leba", 1, "clickAction", localException);
        continue;
        label322:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.31
 * JD-Core Version:    0.7.0.1
 */