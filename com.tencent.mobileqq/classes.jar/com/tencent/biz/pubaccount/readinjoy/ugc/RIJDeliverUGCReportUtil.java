package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

public class RIJDeliverUGCReportUtil
{
  public static void a()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B26E", "0X800B26E", 0, 0, "", "", "", "", false);
  }
  
  public static void a(String paramString)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B25C", "0X800B25C", 0, 0, paramString, "", "", "", false);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B26D", "0X800B26D", 0, 0, paramString1, String.valueOf(paramInt), "", paramString2, false);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B264", "0X800B264", 0, 0, paramString1, paramString2, "", "", false);
  }
  
  public static boolean a(char paramChar)
  {
    return (paramChar == 0) || (paramChar == '\t') || (paramChar == '\n') || (paramChar == '\r') || ((paramChar >= ' ') && (paramChar <= 55295)) || ((paramChar >= 57344) && (paramChar <= 65533)) || ((paramChar >= 65536) && (paramChar <= 1114111));
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (!a(paramString.charAt(i))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static void b()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B25D", "0X800B25D", 0, 0, "", "", "", "", false);
  }
  
  public static void b(String paramString)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B262", "0X800B262", 0, 0, paramString, "", "", "", false);
  }
  
  public static void c()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B25E", "0X800B25E", 0, 0, "", "", "", "", false);
  }
  
  public static void c(String paramString)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B267", "0X800B267", 0, 0, paramString, "", "", "", false);
  }
  
  public static void d()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B25F", "0X800B25F", 0, 0, "", "", "", "", false);
  }
  
  public static void d(String paramString)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B26C", "0X800B26C", 0, 0, paramString, "", "", "", false);
  }
  
  public static void e()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B260", "0X800B260", 0, 0, "", "", "", "", false);
  }
  
  public static void f()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B261", "0X800B261", 0, 0, "", "", "", "", false);
  }
  
  public static void g()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B263", "0X800B263", 0, 0, "", "", "", "", false);
  }
  
  public static void h()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B265", "0X800B265", 0, 0, "", "", "", "", false);
  }
  
  public static void i()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B266", "0X800B266", 0, 0, "", "", "", "", false);
  }
  
  public static void j()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B268", "0X800B268", 0, 0, "", "", "", "", false);
  }
  
  public static void k()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B269", "0X800B269", 0, 0, "", "", "", "", false);
  }
  
  public static void l()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B26A", "0X800B26A", 0, 0, "", "", "", "", false);
  }
  
  public static void m()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B26B", "0X800B26B", 0, 0, "", "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.RIJDeliverUGCReportUtil
 * JD-Core Version:    0.7.0.1
 */