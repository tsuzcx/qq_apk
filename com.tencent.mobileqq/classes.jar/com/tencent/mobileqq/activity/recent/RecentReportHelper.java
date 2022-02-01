package com.tencent.mobileqq.activity.recent;

import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public final class RecentReportHelper
{
  public static SparseIntArray a = new RecentReportHelper.1();
  
  private static int a(RecentBaseData paramRecentBaseData, RecentUser paramRecentUser)
  {
    if (paramRecentUser == null)
    {
      if (QLog.isDevelopLevel())
      {
        paramRecentUser = new StringBuilder();
        paramRecentUser.append("getReportID: null RecentUser for ");
        paramRecentUser.append(paramRecentBaseData);
        QLog.d("RecentReportHelper", 4, paramRecentUser.toString());
      }
      return 0;
    }
    int j = a.get(paramRecentUser.getType());
    int i = j;
    if (j == 0)
    {
      i = j;
      if (paramRecentUser.getType() == 1008) {
        if ("2909288299".equals(paramRecentUser.uin))
        {
          i = 27;
        }
        else
        {
          i = j;
          if ("2010741172".equals(paramRecentUser.uin)) {
            i = 28;
          }
        }
      }
    }
    if (QLog.isDevelopLevel())
    {
      paramRecentBaseData = new StringBuilder();
      paramRecentBaseData.append("getReportID:");
      paramRecentBaseData.append(i);
      paramRecentBaseData.append(", for uin:");
      paramRecentBaseData.append(paramRecentUser.uin);
      paramRecentBaseData.append(" and type:");
      paramRecentBaseData.append(paramRecentUser.getType());
      QLog.d("RecentReportHelper", 4, paramRecentBaseData.toString());
    }
    return i;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData, RecentUser paramRecentUser)
  {
    int i = a(paramRecentBaseData, paramRecentUser);
    if (i > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8006824", "0X8006824", 0, 0, localStringBuilder.toString(), "", "", "");
      if ((a(paramRecentUser)) && (paramRecentBaseData.getUnreadNum() > 0)) {
        PublicAccountEventReport.a(-1, "", "", 8);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData, RecentUser paramRecentUser, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private static boolean a(RecentUser paramRecentUser)
  {
    return (paramRecentUser != null) && ((paramRecentUser.getType() == 1008) || (paramRecentUser.getType() == 7230));
  }
  
  public static void b(QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData, RecentUser paramRecentUser)
  {
    if (paramRecentBaseData.getUnreadNum() <= 0) {
      return;
    }
    int i = a(paramRecentBaseData, paramRecentUser);
    if (i > 0)
    {
      paramRecentBaseData = new StringBuilder();
      paramRecentBaseData.append("");
      paramRecentBaseData.append(i);
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8006823", "0X8006823", 0, 0, paramRecentBaseData.toString(), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentReportHelper
 * JD-Core Version:    0.7.0.1
 */