package com.tencent.mobileqq.ark.secure;

import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.ark.api.IArkService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ArkSecurityReporter
{
  private static final HashMap<String, Integer> a = new HashMap(8);
  private static final HashMap<String, Integer> b = new HashMap(8);
  private static final Object c = new Object();
  private static String d = "";
  
  private static void a(ArkSecurityReporter.ReportItem paramReportItem)
  {
    if (paramReportItem == null) {
      return;
    }
    paramReportItem = paramReportItem.toString();
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report reportRealTime content=", paramReportItem });
    }
    if (MobileQQ.sProcessId == 1) {
      ((IArkService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IArkService.class, "")).doURLReport(paramReportItem);
    }
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      synchronized (c)
      {
        Integer localInteger = (Integer)a.get(paramString);
        if (localInteger != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report valid resource app=", paramString, ", count=", localInteger, ", result=0 , QQVersion=", b() });
          }
          ReportController.b(null, "dc00898", "", "", "0X8009BCF", "0X8009BCF", 0, localInteger.intValue(), 0, b(), "", paramString, "");
          a.remove(paramString);
          synchronized (c)
          {
            localInteger = (Integer)b.get(paramString);
            if (localInteger != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report valid navigation app=", paramString, ", count=", localInteger, ", result=0, r3=1, QQVersion=", b() });
              }
              ReportController.b(null, "dc00898", "", "", "0X8009BD0", "0X8009BD0", 0, localInteger.intValue(), 0, b(), "1", paramString, "");
              b.remove(paramString);
            }
            return;
          }
        }
      }
    }
  }
  
  public static void a(String paramString1, String arg1, int paramInt1, int paramInt2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(???)) {
        return;
      }
      if (paramInt2 == 0) {
        synchronized (c)
        {
          paramString3 = (Integer)a.get(paramString1);
          if (paramString3 != null)
          {
            paramInt1 = paramString3.intValue();
            a.put(paramString1, Integer.valueOf(paramInt1 + 1));
          }
          else
          {
            a.put(paramString1, Integer.valueOf(1));
          }
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report invalid resource url app=", paramString1, ", count=1, result=", Integer.valueOf(paramInt2), ",validType=", Integer.valueOf(paramInt1), ",sender uin=", paramString3, " ,url=", Util.b(???, new String[0]), " ,QQVersion=", b() });
      }
      ReportController.a(null, "dc00898", "", paramString3, "0X8009BCF", "0X8009BCF", paramInt1, paramInt2, b(), "0", paramString1, ???);
      paramString3 = new ArkSecurityReporter.ReportItem();
      paramString3.b = paramString1;
      paramString3.c = ???;
      paramString3.e = 0;
      paramString3.f = paramInt1;
      paramString3.d = paramInt2;
      a(paramString3);
    }
  }
  
  private static String b()
  {
    if (TextUtils.isEmpty(d))
    {
      try
      {
        String[] arrayOfString = "8.8.17".split("\\.");
        if (arrayOfString != null) {
          if (arrayOfString.length >= 3) {
            d = String.format("%d%02d%02d", new Object[] { Integer.valueOf(Integer.parseInt(arrayOfString[0])), Integer.valueOf(Integer.parseInt(arrayOfString[1])), Integer.valueOf(Integer.parseInt(arrayOfString[2])) });
          } else if (arrayOfString.length == 2) {
            d = String.format("%d%02d00", new Object[] { Integer.valueOf(Integer.parseInt(arrayOfString[0])), Integer.valueOf(Integer.parseInt(arrayOfString[1])) });
          }
        }
      }
      catch (Exception localException)
      {
        QLog.d("ArkApp.ArkSecurityReporter", 2, "ArkSafe", localException);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report get QQVersion=", d });
      }
    }
    return d;
  }
  
  public static void b(String paramString1, String arg1, int paramInt1, int paramInt2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(???)) {
        return;
      }
      if (paramInt2 == 0) {
        synchronized (c)
        {
          paramString3 = (Integer)b.get(paramString1);
          if (paramString3 != null)
          {
            paramInt1 = paramString3.intValue();
            b.put(paramString1, Integer.valueOf(paramInt1 + 1));
          }
          else
          {
            b.put(paramString1, Integer.valueOf(1));
          }
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report invalid navigation url app=", paramString1, ",count=1, result=", Integer.valueOf(paramInt2), ",validType=", Integer.valueOf(paramInt1), ",sender uin=", paramString3, ",r3=1 ,url=", Util.b(???, new String[0]), " ,QQVersion=", b() });
      }
      ReportController.a(null, "dc00898", "", paramString3, "0X8009BD0", "0X8009BD0", paramInt1, paramInt2, b(), "1", paramString1, ???);
      paramString3 = new ArkSecurityReporter.ReportItem();
      paramString3.b = paramString1;
      paramString3.c = ???;
      paramString3.e = 1;
      paramString3.f = paramInt1;
      paramString3.d = paramInt2;
      a(paramString3);
    }
  }
  
  public static void c(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      if (paramInt2 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report web url app=", paramString1, ", count=1, result=0, r3=2, url=", Util.b(paramString2, new String[0]), ",QQVersion=", b() });
        }
        ReportController.a(null, "dc00898", "", "", "0X8009BD0", "0X8009BD0", 0, 0, b(), "2", paramString1, "");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report web url app=", paramString1, ", count=1, result=", Integer.valueOf(paramInt2), ",validType=", Integer.valueOf(paramInt1), " ,sender uin=", paramString3, " ,r3=2 ,url=", Util.b(paramString2, new String[0]), " ,QQVersion=", b() });
      }
      ReportController.a(null, "dc00898", "", paramString3, "0X8009BD0", "0X8009BD0", paramInt1, paramInt2, b(), "2", paramString1, paramString2);
      paramString3 = new ArkSecurityReporter.ReportItem();
      paramString3.b = paramString1;
      paramString3.c = paramString2;
      paramString3.d = paramInt2;
      paramString3.e = 2;
      paramString3.f = paramInt1;
      paramString3.d = paramInt2;
      a(paramString3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.secure.ArkSecurityReporter
 * JD-Core Version:    0.7.0.1
 */