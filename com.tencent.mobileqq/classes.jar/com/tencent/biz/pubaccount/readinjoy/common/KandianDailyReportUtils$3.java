package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import ozh;

public final class KandianDailyReportUtils$3
  implements Runnable
{
  public KandianDailyReportUtils$3(ReportInfo paramReportInfo) {}
  
  public void run()
  {
    ozh.a().add(this.a);
    QLog.d("KandianDailyReportUtils", 1, "add feeds 64e exposure info " + this.a);
    if (!ozh.a())
    {
      ThreadManager.getSubThreadHandler().postDelayed(new KandianDailyReportUtils.3.1(this), 100L);
      ozh.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils.3
 * JD-Core Version:    0.7.0.1
 */