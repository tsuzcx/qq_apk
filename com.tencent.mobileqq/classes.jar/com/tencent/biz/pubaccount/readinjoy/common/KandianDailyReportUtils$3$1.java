package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import oab;
import ogy;

class KandianDailyReportUtils$3$1
  implements Runnable
{
  KandianDailyReportUtils$3$1(KandianDailyReportUtils.3 param3) {}
  
  public void run()
  {
    oab.a(false);
    if (oab.a().isEmpty()) {
      return;
    }
    ogy.a().a(oab.a());
    QLog.d("KandianDailyReportUtils", 1, "execute feeds 64e export, size : " + oab.a().size());
    oab.a().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils.3.1
 * JD-Core Version:    0.7.0.1
 */