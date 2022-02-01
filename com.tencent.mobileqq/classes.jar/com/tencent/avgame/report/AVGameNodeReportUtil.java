package com.tencent.avgame.report;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class AVGameNodeReportUtil
{
  public static AVGameNodeReportUtil.ReportData a = new AVGameNodeReportUtil.ReportData();
  
  public static void a()
  {
    a.reset();
    a.createTime = System.currentTimeMillis();
    a.n1BeginTime = System.currentTimeMillis();
    a.curNode = 1;
  }
  
  public static void a(int paramInt)
  {
    a.n1EnterGameRoomRetCode = paramInt;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (a.curNode >= 3) {
      return;
    }
    AVGameNodeReportUtil.ReportData localReportData = a;
    localReportData.curNode = 3;
    localReportData.n3GameType = paramInt1;
    localReportData.n3MemberCount = paramInt2;
    localReportData.n3BeginTime = System.currentTimeMillis();
    if (a.n2BeginTime > 0L)
    {
      a.n2Cost = (System.currentTimeMillis() - a.n2BeginTime);
      return;
    }
    a.n2Cost = 0L;
  }
  
  public static void a(Intent paramIntent)
  {
    paramIntent.putExtra("report_node_data", a);
    a.n1EndTime = System.currentTimeMillis();
  }
  
  public static void a(String paramString)
  {
    a.roomId = paramString;
  }
  
  private static void a(HashMap<String, String> paramHashMap)
  {
    Context localContext = MobileQQ.sMobileQQ.getApplicationContext();
    long l = Long.valueOf((String)paramHashMap.get("duration")).longValue();
    boolean bool = TextUtils.equals((CharSequence)paramHashMap.get("success"), "true");
    String str = (String)paramHashMap.get("uin");
    paramHashMap.remove("uin");
    paramHashMap.remove("success");
    paramHashMap.remove("duration");
    StatisticCollector.getInstance(localContext).collectPerformance(str, "actAVGameNodeReport", bool, l, 1L, paramHashMap, "", true);
    if (QLog.isColorLevel())
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("realReport sReportData:");
      paramHashMap.append(a);
      QLog.i("actAVGameNodeReport", 1, paramHashMap.toString());
    }
  }
  
  public static void b()
  {
    a.n2EnterAvBeginTime = System.currentTimeMillis();
  }
  
  public static void b(int paramInt)
  {
    AVGameNodeReportUtil.ReportData localReportData = a;
    localReportData.endCode = paramInt;
    localReportData.endNode = localReportData.curNode;
    a.exit();
    if (((!a.isAgain) || (a.endNode != 2) || (a.endCode != 1)) && (a.endNode > 0)) {
      a(a.buildRealReportData());
    }
    if (paramInt == 2)
    {
      a.again();
      return;
    }
    a.reset();
  }
  
  public static void b(Intent paramIntent)
  {
    AVGameNodeReportUtil.ReportData localReportData = (AVGameNodeReportUtil.ReportData)paramIntent.getSerializableExtra("report_node_data");
    if ((!TextUtils.equals(paramIntent.getStringExtra("key_room_id"), a.roomId)) && (!TextUtils.isEmpty(a.roomId))) {
      b(-20);
    }
    if (a.curNode >= 2) {
      return;
    }
    if (localReportData != null) {
      a.copyFromMain(localReportData);
    }
    paramIntent = a;
    paramIntent.curNode = 2;
    paramIntent.n2BeginTime = System.currentTimeMillis();
    if (a.n1BeginTime > 0L)
    {
      a.n1Cost = (System.currentTimeMillis() - a.n1BeginTime);
      return;
    }
    a.n1Cost = 0L;
  }
  
  public static int c(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return -99;
    case 10: 
      return -18;
    case 9: 
      return -17;
    case 8: 
      return -19;
    case 7: 
      return -15;
    case 6: 
      return -13;
    case 5: 
      return -16;
    case 4: 
      return -12;
    case 3: 
      return -11;
    case -1: 
    case 1: 
      return 1;
    }
    return -10;
  }
  
  public static void c()
  {
    a.n2EnterAvEndTime = System.currentTimeMillis();
    if (a.n2EnterAvBeginTime > 0L)
    {
      AVGameNodeReportUtil.ReportData localReportData = a;
      localReportData.n2AvEnterCost = (localReportData.n2EnterAvEndTime - a.n2EnterAvBeginTime);
      localReportData = a;
      localReportData.n2EnterAvBeginTime = 0L;
      localReportData.n2EnterAvEndTime = 0L;
      return;
    }
    a.n2AvEnterCost = 0L;
  }
  
  public static void d()
  {
    if (a.curNode >= 4) {
      return;
    }
    AVGameNodeReportUtil.ReportData localReportData = a;
    localReportData.curNode = 4;
    localReportData.n4BeginTime = System.currentTimeMillis();
    if (a.n3BeginTime > 0L)
    {
      a.n3Cost = (System.currentTimeMillis() - a.n3BeginTime);
      return;
    }
    a.n3Cost = 0L;
  }
  
  public static void e()
  {
    if (a.curNode >= 5) {
      return;
    }
    AVGameNodeReportUtil.ReportData localReportData = a;
    localReportData.curNode = 5;
    localReportData.n5BeginTime = System.currentTimeMillis();
    if (a.n4BeginTime > 0L)
    {
      a.n4Cost = (System.currentTimeMillis() - a.n4BeginTime);
      return;
    }
    a.n4Cost = 0L;
  }
  
  public static void f()
  {
    b(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.report.AVGameNodeReportUtil
 * JD-Core Version:    0.7.0.1
 */