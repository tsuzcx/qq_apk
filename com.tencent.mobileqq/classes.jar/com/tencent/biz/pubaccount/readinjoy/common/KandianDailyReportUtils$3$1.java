package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class KandianDailyReportUtils$3$1
  implements Runnable
{
  KandianDailyReportUtils$3$1(KandianDailyReportUtils.3 param3) {}
  
  public void run()
  {
    KandianDailyReportUtils.a(false);
    if (KandianDailyReportUtils.a().isEmpty()) {
      return;
    }
    ReadInJoyLogicEngine.a().a(KandianDailyReportUtils.a());
    QLog.d("KandianDailyReportUtils", 1, "execute feeds 64e export, size : " + KandianDailyReportUtils.a().size());
    KandianDailyReportUtils.a().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils.3.1
 * JD-Core Version:    0.7.0.1
 */