package com.tencent.avgame.util;

import android.content.Intent;
import android.text.TextUtils;
import bdmc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AVGameNodeReportUtil
{
  public static AVGameNodeReportUtil.ReportData a = new AVGameNodeReportUtil.ReportData();
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return -99;
    case -1: 
    case 1: 
      return 1;
    case -2: 
    case 2: 
      return -10;
    case 3: 
      return -11;
    case 4: 
      return -12;
    case 6: 
      return -13;
    case 7: 
      return -15;
    case 5: 
      return -16;
    case 9: 
      return -17;
    case 10: 
      return -18;
    }
    return -19;
  }
  
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
    a.curNode = 3;
    a.n3GameType = paramInt1;
    a.n3MemberCount = paramInt2;
    a.n3BeginTime = System.currentTimeMillis();
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
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    long l = Long.valueOf((String)paramHashMap.get("duration")).longValue();
    boolean bool = TextUtils.equals((CharSequence)paramHashMap.get("success"), "true");
    String str = (String)paramHashMap.get("uin");
    paramHashMap.remove("uin");
    paramHashMap.remove("success");
    paramHashMap.remove("duration");
    bdmc.a(localBaseApplicationImpl).a(str, "actAVGameNodeReport", bool, l, 1L, paramHashMap, "", true);
    if (QLog.isColorLevel()) {
      QLog.i("actAVGameNodeReport", 1, "realReport sReportData:" + a);
    }
  }
  
  public static void b()
  {
    a.n2EnterAvBeginTime = System.currentTimeMillis();
  }
  
  public static void b(int paramInt)
  {
    a.endCode = paramInt;
    a.endNode = a.curNode;
    a.exit();
    if ((a.isAgain) && (a.endNode == 2) && (a.endCode == 1)) {}
    while (paramInt == 2)
    {
      a.again();
      return;
      if (a.endNode > 0) {
        a(a.buildRealReportData());
      }
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
    a.curNode = 2;
    a.n2BeginTime = System.currentTimeMillis();
    if (a.n1BeginTime > 0L)
    {
      a.n1Cost = (System.currentTimeMillis() - a.n1BeginTime);
      return;
    }
    a.n1Cost = 0L;
  }
  
  public static void c()
  {
    a.n2EnterAvEndTime = System.currentTimeMillis();
    if (a.n2EnterAvBeginTime > 0L)
    {
      a.n2AvEnterCost = (a.n2EnterAvEndTime - a.n2EnterAvBeginTime);
      a.n2EnterAvBeginTime = 0L;
      a.n2EnterAvEndTime = 0L;
      return;
    }
    a.n2AvEnterCost = 0L;
  }
  
  public static void d()
  {
    if (a.curNode >= 4) {
      return;
    }
    a.curNode = 4;
    a.n4BeginTime = System.currentTimeMillis();
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
    a.curNode = 5;
    a.n5BeginTime = System.currentTimeMillis();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.util.AVGameNodeReportUtil
 * JD-Core Version:    0.7.0.1
 */