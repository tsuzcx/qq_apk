package com.tencent.comic;

import com.tencent.comic.api.IQQDcReporter;
import com.tencent.comic.data.VipComicDC01327ReportData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;

public class VipComicShareReportUtils
{
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (a(paramString6))
    {
      ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC01327(paramAppInterface, new VipComicDC01327ReportData().a(paramString1).b("3").c("39815").d(paramString2).e(paramString3).a(new String[] { paramString4 }));
      return;
    }
    ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(paramAppInterface, paramString1, "3", "300392", paramString3, new String[] { paramString5, paramString4 });
  }
  
  private static boolean a(String paramString)
  {
    return ("detail".equals(paramString)) || ("tag".equals(paramString)) || ("topic".equals(paramString));
  }
  
  public static void b(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (a(paramString6))
    {
      ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC01327(paramAppInterface, new VipComicDC01327ReportData().a(paramString1).b("3").c("39816").d(paramString2).e(paramString3).a(new String[] { paramString4 }));
      return;
    }
    ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(paramAppInterface, paramString1, "3", "300393", paramString3, new String[] { paramString5, paramString4 });
  }
  
  public static void c(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (a(paramString6))
    {
      ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC01327(paramAppInterface, new VipComicDC01327ReportData().a(paramString1).b("2").c("200778").d(paramString2).e(paramString3).a(new String[] { paramString4 }));
      return;
    }
    ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(paramAppInterface, paramString1, "2", "210393", paramString3, new String[] { paramString5, paramString4 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.VipComicShareReportUtils
 * JD-Core Version:    0.7.0.1
 */