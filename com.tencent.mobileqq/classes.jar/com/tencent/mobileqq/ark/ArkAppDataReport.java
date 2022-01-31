package com.tencent.mobileqq.ark;

import aaue;
import android.text.TextUtils;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ArkAppReportController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ArkAppDataReport
{
  public static int a;
  private static boolean a;
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  public static int e = 4;
  public static int f;
  public static int g = 1;
  public static int h = 2;
  public static int i = 3;
  
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      return -1;
    case 0: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 3;
    case 3: 
      return 4;
    }
    return 5;
  }
  
  public static void a()
  {
    b("0X8007BE8");
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, "BabyqAtShowBubble", "com.tencent.ark.babyq", null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    a(paramQQAppInterface, "BabyqClickNoResultItem", "com.tencent.ark.babyq", null, paramInt, 0, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (paramInt1 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramQQAppInterface, "QQ/UpdateApp", bool, paramInt1, 0, paramString1);
      a(paramQQAppInterface, paramString1, "UpdateLocalApp", paramInt1, a(paramInt2), paramInt3, 0L, 0L, "", paramString2);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, "AIOInputSendMessage", paramString, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    a(paramQQAppInterface, "BabyqShowGrayTip", paramString, null, paramInt, 0, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    a(paramQQAppInterface, "AIOMsgShowIcon", paramString, null, paramInt1, paramInt2, 0);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800776F", paramString1, paramInt1, 1, paramInt2, Integer.toString(paramInt3), Integer.toString(paramInt4), paramString2, paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    a(paramQQAppInterface, "AIOMsgClickIcon", paramString1, paramString2, paramInt1, paramInt2, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ArkAppCenter.b("ArkApp.DataReport", "report_getAppPathByNameResult, appName is empty");
      return;
    }
    if (paramInt1 == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramQQAppInterface, "QQ/GetAppByName", bool, paramInt1, (int)paramLong, paramString);
      a(paramQQAppInterface, paramString, "GetAppPathByName", paramInt1, a(paramInt2), paramLong, 0L, 0L, "", "");
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramString1, "MsgMetaContainsInvalidURL", 0, 0, 0L, 0L, 0L, paramString2, "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    a(paramQQAppInterface, paramString1, "PerfCreateView", 0, 0, paramInt, 0L, 0L, paramString2, "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, String paramString3, String paramString4)
  {
    if ((TextUtils.isEmpty(paramString1)) || (!ArkLocalAppMgr.a(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      ArkAppCenter.b("ArkApp.DataReport", String.format("platformEventReport, invalid args, app-name=%s, op-name=%s", new Object[] { paramString1, paramString2 }));
      return;
    }
    ArkAppCenter.b("ArkApp.DataReport", String.format("platformEventReport, app=%s, op-name=%s, entry=%d, result=%d, r1=%d, r2=%d, r3=%s, r4=%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), paramString3, paramString4 }));
    ArkAppReportController.a(paramQQAppInterface, paramString1, "__platform__", paramString2, paramInt1, paramInt2, paramLong1, paramLong2, paramLong3, paramString3, paramString4);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (paramString3 == null) {
      paramString3 = "";
    }
    for (;;)
    {
      a(paramQQAppInterface, paramString2, paramString1, 0, 0, 0L, 0L, 0L, paramString3, "");
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (paramString3 == null) {
      paramString3 = "";
    }
    for (;;)
    {
      a(paramQQAppInterface, paramString2, paramString1, 0, paramInt3, 0L, paramInt1, paramInt2, paramString3, "");
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    if (paramBoolean) {}
    for (int j = 1;; j = 2)
    {
      a(paramQQAppInterface, paramString1, "PerfGetApp", 0, j, paramInt, 0L, 0L, paramString2, "");
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, boolean paramBoolean, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      return;
      if ((paramString1 != null) && (paramString1.length() != 0))
      {
        String str1 = paramQQAppInterface.c();
        Object localObject = new HashMap();
        ((HashMap)localObject).put("domain", "ark.qq.com");
        ((HashMap)localObject).put("cgi", paramString1);
        if (paramBoolean) {}
        for (paramString1 = "1";; paramString1 = "2")
        {
          ((HashMap)localObject).put("type", paramString1);
          ((HashMap)localObject).put("code", Integer.toString(paramInt1));
          ((HashMap)localObject).put("time", Integer.toString(paramInt2));
          ((HashMap)localObject).put("uin", str1);
          if (paramString2 != null) {
            ((HashMap)localObject).put("data", paramString2);
          }
          paramString1 = new StringBuilder();
          paramString2 = ((HashMap)localObject).keySet().iterator();
          while (paramString2.hasNext())
          {
            str1 = (String)paramString2.next();
            String str2 = (String)((HashMap)localObject).get(str1);
            if (paramString1.length() > 0) {
              paramString1.append('&');
            }
            try
            {
              paramString1.append(String.format("%s=%s", new Object[] { URLEncoder.encode(str1, "UTF-8"), URLEncoder.encode(str2, "UTF-8") }));
            }
            catch (Exception localException)
            {
              ArkAppCenter.b("ArkApp.DataReport", "report_realtime_monitor, URLEncoder fail, msg=" + localException.getMessage());
            }
          }
        }
        paramString2 = "http://c.isdspeed.qq.com/code.cgi?" + paramString1.toString();
        localObject = new ByteArrayOutputStream();
        paramString1 = new HttpNetReq();
        paramString1.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
        paramString1.jdField_a_of_type_Int = 0;
        paramString1.jdField_a_of_type_JavaLangString = paramString2;
        paramString1.e = 1;
        paramString1.c = 30L;
        paramString1.jdField_a_of_type_JavaIoOutputStream = ((OutputStream)localObject);
        paramString1.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new aaue();
        paramString2 = (NetEngineFactory)paramQQAppInterface.getManager(20);
        if (paramString2 != null) {}
        for (paramQQAppInterface = paramString2.a(paramQQAppInterface, 0); paramQQAppInterface != null; paramQQAppInterface = null)
        {
          paramQQAppInterface.a(paramString1);
          return;
        }
      }
    }
  }
  
  public static void a(String paramString)
  {
    a(null, paramString, 0, 0, 0, 0, "", "");
  }
  
  public static void a(String paramString, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X80088D4", paramString, paramInt, 0, "", "", "", "");
  }
  
  public static void b()
  {
    b("0X8007BE9");
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, "BabyqInputShowSpan", "com.tencent.ark.babyq", null);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, "AIOInputPannelTabClick", paramString, null);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    a(paramQQAppInterface, "BabyqClickGrayTip", paramString, null, paramInt, 0, 0);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    a(paramQQAppInterface, "AIOMsgClickCloseIcon", paramString, null, paramInt1, paramInt2, 0);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    a(paramQQAppInterface, "AIOMsgClickUnderline", paramString1, paramString2, paramInt1, paramInt2, 0);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, "AIOInputSearchKeyword", paramString1, paramString2);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    a(paramQQAppInterface, paramString1, "PerfDisplayView", 0, 0, paramInt, 0L, 0L, paramString2, "");
  }
  
  private static void b(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void c()
  {
    if (a) {
      return;
    }
    a = true;
    if (ArkEnvironmentManager.getInstance().isHardwareAcceleration())
    {
      a(null, "ark.lib.hardware.rendering", 0, 0, 0, 0, "", "");
      return;
    }
    a(null, "ark.lib.software.rendering", 0, 0, 0, 0, "", "");
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, "BabyqInputClickBubble", "com.tencent.ark.babyq", null);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "com.tencent.ark.babyq";
    }
    a(paramQQAppInterface, "BabyqRecvReplyMessage", str, null);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    a(paramQQAppInterface, "FullScreenClickOper", paramString, null, paramInt, 0, 0);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    a(paramQQAppInterface, "AIOMsgShowUnderline", paramString, null, paramInt1, paramInt2, 0);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    a(paramQQAppInterface, "AIOMsgShowIconEach", paramString1, paramString2, paramInt1, paramInt2, 0);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, "ScriptError", paramString1, paramString2);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    a(paramQQAppInterface, paramString1, "PerfSurfacePrepare", 0, 0, paramInt, 0L, 0L, paramString2, "");
  }
  
  public static void d(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, "BabyqInputSearchText", "com.tencent.ark.babyq", null);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, "BabyqShowArkCard", paramString, null);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    a(paramQQAppInterface, "ShowView", paramString, null, paramInt1, 0, paramInt2);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    a(paramQQAppInterface, "AIOMsgShowUnderlineEach", paramString1, paramString2, paramInt1, paramInt2, 0);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    a(paramQQAppInterface, paramString1, "PerfCreateContext", 0, 0, paramInt, 0L, 0L, paramString2, "");
  }
  
  public static void e(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, "BabyqSendAtMessage", "com.tencent.ark.babyq", null);
  }
  
  public static void e(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, "AIOCardSendMessage", paramString, null);
  }
  
  public static void e(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    a(paramQQAppInterface, "ShowSdkArkView", paramString, null, paramInt1, 0, paramInt2);
  }
  
  public static void e(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    a(paramQQAppInterface, paramString1, "PerfFirstDraw", 0, 0, paramInt, 0L, 0L, paramString2, "");
  }
  
  public static void f(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, "BabyqRecvReplyNoResult", "com.tencent.ark.babyq", null);
  }
  
  public static void f(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, "AIOMsgRemindShow", paramString, null);
  }
  
  public static void f(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    a(paramQQAppInterface, paramString1, "PerfDisplayTotalCost", 0, 0, paramInt, 0L, 0L, paramString2, "");
  }
  
  public static void g(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, "AIOMsgRemindClick", paramString, null);
  }
  
  public static void g(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    a(paramQQAppInterface, "AIOInputShowBubble", paramString1, paramString2, 0, paramInt, 0);
  }
  
  public static void h(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, "AIOStatusBarShow", paramString, null);
  }
  
  public static void h(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    a(paramQQAppInterface, "AIOInputClickBubble", paramString1, paramString2, 0, paramInt, 0);
  }
  
  public static void i(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, "AIOStatusBarClick", paramString, null);
  }
  
  public static void i(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    a(paramQQAppInterface, "AIOInputEchoSearch", paramString1, paramString2, paramInt, 0, 0);
  }
  
  public static void j(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, "FullScreenOrH5Show", paramString, null);
  }
  
  public static void j(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    a(paramQQAppInterface, "AIOInputEchoClickBubble", paramString1, paramString2, paramInt, 0, 0);
  }
  
  public static void k(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, "FullScreenOrH5ShowForAI", paramString, null);
  }
  
  public static void k(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if ((!ArkLocalAppMgr.a(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      ArkAppCenter.b("ArkApp.DataReport", String.format("appInsideClickReport, invalid args, app=%s, opName=%s, entry=%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
      return;
    }
    ArkAppCenter.b("ArkApp.DataReport", String.format("appInsideClickReport, app=%s, op-name=%s, entry=%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
    ArkAppReportController.a(paramQQAppInterface, paramString1, "__app__", paramString2, 0L, paramInt, 0L, 0L, 0L, "", "");
  }
  
  public static void l(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, "FullScreenShareOper", paramString, null);
  }
  
  public static void m(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, "FullScreenShareSuccess", paramString, null);
  }
  
  public static void n(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, "AIOInputBubbleRealShow", paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppDataReport
 * JD-Core Version:    0.7.0.1
 */