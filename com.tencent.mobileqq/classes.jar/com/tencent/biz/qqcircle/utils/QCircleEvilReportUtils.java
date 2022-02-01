package com.tencent.biz.qqcircle.utils;

import com.tencent.biz.qcircleshadow.lib.variation.HostEvilReportUtils;
import com.tencent.biz.qqcircle.beans.QCircleEvilReportInfo;
import com.tencent.qphone.base.util.QLog;

public class QCircleEvilReportUtils
{
  public static String a(String paramString)
  {
    try
    {
      paramString = Long.toString(Long.parseLong(paramString) * 2L - 12345L);
      return paramString;
    }
    catch (Exception paramString)
    {
      label18:
      break label18;
    }
    QLog.d("QCircleInformUtils", 1, "uin is error !");
    return null;
  }
  
  public static void a(QCircleEvilReportInfo paramQCircleEvilReportInfo)
  {
    HostEvilReportUtils.doEvilReport(paramQCircleEvilReportInfo.a, paramQCircleEvilReportInfo.b, paramQCircleEvilReportInfo.c, paramQCircleEvilReportInfo.d, paramQCircleEvilReportInfo.e, paramQCircleEvilReportInfo.f, paramQCircleEvilReportInfo.g, paramQCircleEvilReportInfo.h, paramQCircleEvilReportInfo.i, paramQCircleEvilReportInfo.j);
    QLog.d("QCircleInformUtils", 1, "report  success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleEvilReportUtils
 * JD-Core Version:    0.7.0.1
 */