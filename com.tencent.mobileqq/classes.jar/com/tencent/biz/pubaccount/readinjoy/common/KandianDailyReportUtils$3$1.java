package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import oyc;
import pfa;

class KandianDailyReportUtils$3$1
  implements Runnable
{
  KandianDailyReportUtils$3$1(KandianDailyReportUtils.3 param3) {}
  
  public void run()
  {
    oyc.a(false);
    if (oyc.a().isEmpty()) {
      return;
    }
    pfa.a().a(oyc.a());
    QLog.d("KandianDailyReportUtils", 1, "execute feeds 64e export, size : " + oyc.a().size());
    oyc.a().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils.3.1
 * JD-Core Version:    0.7.0.1
 */