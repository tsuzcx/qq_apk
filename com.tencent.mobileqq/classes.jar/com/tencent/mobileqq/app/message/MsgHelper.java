package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import java.util.HashMap;

public class MsgHelper
{
  private static boolean a = false;
  private static boolean b = false;
  
  public static void a(MessageRecord paramMessageRecord)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("param_FailCode", String.valueOf(paramMessageRecord.istroop));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actInvalidMessageRecord", false, 0L, 0L, localHashMap, "");
  }
  
  public static void a(String paramString)
  {
    if (!a)
    {
      a = true;
      c("reportSaveInvalidUserError");
      CaughtExceptionReport.a(new RuntimeException(), paramString);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramInt == 1008) && (paramQQAppInterface != null))
    {
      paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(paramString);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.isFriend())) {
        return true;
      }
    }
    return false;
  }
  
  public static void b(String paramString)
  {
    if (!b)
    {
      b = true;
      c("reportInvalidRefredshLastMsg");
      CaughtExceptionReport.a(new RuntimeException(), paramString);
    }
  }
  
  public static void c(String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder(512);
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(arrayOfStackTraceElement[i].toString());
      localStringBuilder.append("\n");
      i += 1;
    }
    QLog.i(paramString, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.MsgHelper
 * JD-Core Version:    0.7.0.1
 */