package com.tencent.biz.pubaccount.NativeAd.report;

import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoySessionManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class AdSessionManager
{
  private static volatile AdSessionManager a;
  private static final SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
  private int c = 0;
  private int d = 0;
  
  private AdSessionManager()
  {
    try
    {
      this.d = Integer.parseInt(SharePreferenceUtils.a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getApplication(), a("refreshSeriesNum")));
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static AdSessionManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new AdSessionManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private static String a(String paramString)
  {
    String str1 = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getAccount();
    String str2 = b.format(new Date());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(str2);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public String b()
  {
    String str2 = ((IReadInJoySessionManager)QRoute.api(IReadInJoySessionManager.class)).getSceneTraceID();
    String str1 = str2;
    if (str2.isEmpty()) {
      str1 = "";
    }
    return str1;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public void d()
  {
    this.d += 1;
    MobileQQ localMobileQQ = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getApplication();
    String str = a("refreshSeriesNum");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.d);
    SharePreferenceUtils.a(localMobileQQ, str, localStringBuilder.toString());
  }
  
  public int e()
  {
    return ((IReadInJoySessionManager)QRoute.api(IReadInJoySessionManager.class)).getSceneSeriesNum();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.AdSessionManager
 * JD-Core Version:    0.7.0.1
 */