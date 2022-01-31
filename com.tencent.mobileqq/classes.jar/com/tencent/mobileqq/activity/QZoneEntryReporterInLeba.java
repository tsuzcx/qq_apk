package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import java.util.ArrayList;

public class QZoneEntryReporterInLeba
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneEntryReporterInLeba", 2, "leba 曝光上报");
    }
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.c = "637";
    localReportInfo.d = "10";
    QZoneClickReport.report(paramQQAppInterface.getAccount(), localReportInfo, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneEntryReporterInLeba", 2, "主动红点曝光上报 要播放的头像个数num：" + paramInt);
    }
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.c = "637";
    localReportInfo.d = "11";
    localReportInfo.e = "1";
    localReportInfo.a = new ArrayList();
    localReportInfo.a.add(String.valueOf(paramInt));
    QZoneClickReport.report(paramQQAppInterface.getAccount(), localReportInfo, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneEntryReporterInLeba", 2, String.format("有头像的点击上报 头像总计：%d,已经播放：%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
    }
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.c = "637";
    localReportInfo.d = "11";
    localReportInfo.e = "2";
    localReportInfo.a = new ArrayList();
    localReportInfo.a.add(String.valueOf(paramInt2));
    localReportInfo.a.add(String.valueOf(paramInt1));
    QZoneClickReport.report(paramQQAppInterface.getAccount(), localReportInfo, true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.c = "637";
    localReportInfo.d = "13";
    localReportInfo.e = "1";
    QZoneClickReport.report(paramQQAppInterface.getAccount(), localReportInfo, true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneEntryReporterInLeba", 2, String.format("被动曝光上报 红点数字是：%d", new Object[] { Integer.valueOf(paramInt) }));
    }
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.c = "637";
    localReportInfo.d = "12";
    localReportInfo.e = "1";
    localReportInfo.a = new ArrayList();
    localReportInfo.a.add(String.valueOf(paramInt));
    QZoneClickReport.report(paramQQAppInterface.getAccount(), localReportInfo, true);
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.c = "637";
    localReportInfo.d = "13";
    localReportInfo.e = "2";
    QZoneClickReport.report(paramQQAppInterface.getAccount(), localReportInfo, true);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneEntryReporterInLeba", 2, "被动红点的点击上报 num:" + paramInt);
    }
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.c = "637";
    localReportInfo.d = "12";
    localReportInfo.e = "2";
    localReportInfo.a = new ArrayList();
    localReportInfo.a.add(String.valueOf(paramInt));
    QZoneClickReport.report(paramQQAppInterface.getAccount(), localReportInfo, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QZoneEntryReporterInLeba
 * JD-Core Version:    0.7.0.1
 */