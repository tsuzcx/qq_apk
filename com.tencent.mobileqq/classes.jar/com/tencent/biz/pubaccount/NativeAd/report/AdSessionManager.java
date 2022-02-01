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
  private static volatile AdSessionManager jdField_a_of_type_ComTencentBizPubaccountNativeAdReportAdSessionManager;
  private static final SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
  private int jdField_a_of_type_Int = 0;
  private int b = 0;
  
  private AdSessionManager()
  {
    try
    {
      this.b = Integer.parseInt(SharePreferenceUtils.a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getApplication(), a("refreshSeriesNum")));
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static AdSessionManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountNativeAdReportAdSessionManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentBizPubaccountNativeAdReportAdSessionManager == null) {
          jdField_a_of_type_ComTencentBizPubaccountNativeAdReportAdSessionManager = new AdSessionManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentBizPubaccountNativeAdReportAdSessionManager;
  }
  
  private static String a(String paramString)
  {
    String str1 = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getAccount();
    String str2 = jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(str2);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public int a()
  {
    return this.b;
  }
  
  public String a()
  {
    String str2 = ((IReadInJoySessionManager)QRoute.api(IReadInJoySessionManager.class)).getSceneTraceID();
    String str1 = str2;
    if (str2.isEmpty()) {
      str1 = "";
    }
    return str1;
  }
  
  public void a()
  {
    this.b += 1;
    MobileQQ localMobileQQ = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getApplication();
    String str = a("refreshSeriesNum");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.b);
    SharePreferenceUtils.a(localMobileQQ, str, localStringBuilder.toString());
  }
  
  public int b()
  {
    return ((IReadInJoySessionManager)QRoute.api(IReadInJoySessionManager.class)).getSceneSeriesNum();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.AdSessionManager
 * JD-Core Version:    0.7.0.1
 */