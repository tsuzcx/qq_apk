package com.tencent.biz.qcircleshadow.lib.variation;

import com.tencent.biz.subscribe.utils.EvilReportUtil;
import com.tencent.biz.subscribe.utils.EvilReportUtil.EvilReportParams;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class HostEvilReportUtils
{
  public static void doEvilReport(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    EvilReportUtil.EvilReportParams localEvilReportParams = new EvilReportUtil.EvilReportParams();
    localEvilReportParams.a = paramString1;
    localEvilReportParams.b = paramString2;
    localEvilReportParams.c = paramString3;
    localEvilReportParams.e = paramString4;
    localEvilReportParams.f = paramString5;
    localEvilReportParams.g = paramString6;
    localEvilReportParams.h = paramString7;
    localEvilReportParams.d = paramString8;
    localEvilReportParams.j = paramString9;
    localEvilReportParams.i = paramString10;
    QLog.d("QCircleEvilReport", 1, "start report");
    EvilReportUtil.a(MobileQQ.sMobileQQ, localEvilReportParams);
    QLog.d("QCircleEvilReport", 1, "end report");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.variation.HostEvilReportUtils
 * JD-Core Version:    0.7.0.1
 */