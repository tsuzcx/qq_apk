package com.tencent.biz.pubaccount.NativeAd.report;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import mqq.app.AppRuntime;

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
      this.jdField_a_of_type_Int = Integer.parseInt(SharePreferenceUtils.a(ReadInJoyUtils.a().getApplication(), a("sceneSeriesNum")));
      try
      {
        label35:
        this.b = Integer.parseInt(SharePreferenceUtils.a(ReadInJoyUtils.a().getApplication(), a("refreshSeriesNum")));
        return;
      }
      catch (Throwable localThrowable1) {}
    }
    catch (Throwable localThrowable2)
    {
      break label35;
    }
  }
  
  public static AdSessionManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountNativeAdReportAdSessionManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountNativeAdReportAdSessionManager == null) {
        jdField_a_of_type_ComTencentBizPubaccountNativeAdReportAdSessionManager = new AdSessionManager();
      }
      return jdField_a_of_type_ComTencentBizPubaccountNativeAdReportAdSessionManager;
    }
    finally {}
  }
  
  private static String a(String paramString)
  {
    String str1 = ReadInJoyUtils.a().getAccount();
    String str2 = jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date());
    return str1 + str2 + paramString;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public String a()
  {
    return ReadinjoyReportUtils.a;
  }
  
  public void a()
  {
    this.b += 1;
    SharePreferenceUtils.a(ReadInJoyUtils.a().getApplication(), a("refreshSeriesNum"), "" + this.b);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int += 1;
    SharePreferenceUtils.a(ReadInJoyUtils.a().getApplication(), a("sceneSeriesNum"), "" + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.AdSessionManager
 * JD-Core Version:    0.7.0.1
 */