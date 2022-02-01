package com.tencent.av.screenshare;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class ScreenShareReportHelper
{
  private static final ConcurrentHashMap<String, ScreenShareReportHelper.ScreenShareReportInfo> a = new ConcurrentHashMap();
  
  public static int a(SessionInfo paramSessionInfo)
  {
    int j = paramSessionInfo.d;
    int i = j;
    if (paramSessionInfo.c != null)
    {
      i = j;
      if (paramSessionInfo.c.startsWith(String.valueOf(100)))
      {
        if (j != 3) {
          break label40;
        }
        i = 1;
      }
    }
    label40:
    do
    {
      return i;
      i = j;
    } while (j != 4);
    return 2;
  }
  
  public static int a(String paramString)
  {
    paramString = a(paramString, false);
    if (paramString == null) {
      return 0;
    }
    return paramString.jdField_a_of_type_Int;
  }
  
  private static ScreenShareReportHelper.ScreenShareReportInfo a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    do
    {
      ScreenShareReportHelper.ScreenShareReportInfo localScreenShareReportInfo;
      do
      {
        return localObject;
        localScreenShareReportInfo = (ScreenShareReportHelper.ScreenShareReportInfo)a.get(paramString);
        localObject = localScreenShareReportInfo;
      } while (localScreenShareReportInfo != null);
      localObject = localScreenShareReportInfo;
    } while (!paramBoolean);
    Object localObject = new ScreenShareReportHelper.ScreenShareReportInfo(null);
    a.put(paramString, localObject);
    return localObject;
  }
  
  public static void a(String paramString)
  {
    a(paramString, a(SessionMgr.a().a()));
  }
  
  public static void a(String paramString, int paramInt)
  {
    b(paramString, paramInt, "");
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    ScreenShareReportHelper.ScreenShareReportInfo localScreenShareReportInfo = a(paramString1, true);
    if (localScreenShareReportInfo != null) {
      localScreenShareReportInfo.jdField_a_of_type_Int = paramInt;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ScreenShareReportHelper", 2, "saveScreenShareFromType, sessionId: " + paramString1 + ", screenShareFromType: " + paramInt + ", from: " + paramString2 + ", info: " + localScreenShareReportInfo);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    ScreenShareReportHelper.ScreenShareReportInfo localScreenShareReportInfo = a(paramString1, true);
    if ((localScreenShareReportInfo != null) && (localScreenShareReportInfo.jdField_a_of_type_Int == 0)) {
      localScreenShareReportInfo.jdField_a_of_type_Int = 2;
    }
    if ((localScreenShareReportInfo != null) && (!localScreenShareReportInfo.a()))
    {
      localScreenShareReportInfo.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      if (!ScreenShareCtrl.a(SessionMgr.a().c(paramString1))) {
        b("0X800BA72", 0, String.valueOf(localScreenShareReportInfo.jdField_a_of_type_Int));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ScreenShareReportHelper", 2, "markScreenShareStart, sessionId: " + paramString1 + ", from: " + paramString2 + ", info: " + localScreenShareReportInfo);
    }
  }
  
  public static void b(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScreenShareReportHelper", 2, String.format("doScreenShareReport, tag[%s], fromType[%s], r2[%s]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 }));
    }
    ReportController.b(null, "dc00898", "", "", paramString1, paramString1, paramInt, 0, paramString2, "", "", "");
  }
  
  public static void b(String paramString1, String paramString2)
  {
    long l1 = 0L;
    ScreenShareReportHelper.ScreenShareReportInfo localScreenShareReportInfo = a(paramString1, false);
    long l2 = l1;
    if (localScreenShareReportInfo != null)
    {
      if (localScreenShareReportInfo.jdField_a_of_type_Long != 0L)
      {
        l1 = Math.abs(localScreenShareReportInfo.jdField_a_of_type_Long - SystemClock.elapsedRealtime()) / 1000L;
        b("0X800BA73", 0, String.valueOf(l1));
      }
      a.remove(paramString1);
      l2 = l1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ScreenShareReportHelper", 2, "markScreenShareEnd, sessionId: " + paramString1 + ", from: " + paramString2 + ", cost: " + l2 + ", info: " + localScreenShareReportInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareReportHelper
 * JD-Core Version:    0.7.0.1
 */