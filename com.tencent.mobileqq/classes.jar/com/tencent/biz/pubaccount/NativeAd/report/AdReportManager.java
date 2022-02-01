package com.tencent.biz.pubaccount.NativeAd.report;

import android.os.Bundle;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.report.util.AdReportUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class AdReportManager
{
  private static volatile AdReportManager jdField_a_of_type_ComTencentBizPubaccountNativeAdReportAdReportManager;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static final Vector<String> jdField_a_of_type_JavaUtilVector = new Vector();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private AdReportManager()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(371);
    if (localAladdinConfig.getIntegerFromString("ad_new_report", 0) == 1)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (localAladdinConfig.getIntegerFromString("soft_new_report", 0) != 1) {
        break label55;
      }
    }
    label55:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.b = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public static AdReportManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountNativeAdReportAdReportManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountNativeAdReportAdReportManager == null) {
        jdField_a_of_type_ComTencentBizPubaccountNativeAdReportAdReportManager = new AdReportManager();
      }
      return jdField_a_of_type_ComTencentBizPubaccountNativeAdReportAdReportManager;
    }
    finally {}
  }
  
  private static String a(AdReportData paramAdReportData)
  {
    return AdReportUtil.b(paramAdReportData) + "_" + AdReportUtil.a(paramAdReportData) + "_" + paramAdReportData.a();
  }
  
  private void a(String paramString, ReportData paramReportData, ReportAction paramReportAction)
  {
    Bundle localBundle1 = new Bundle();
    HttpUtil.addCookie(localBundle1);
    Bundle localBundle2 = new Bundle();
    Iterator localIterator = paramReportData.a().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localBundle2.putString(str, (String)paramReportData.a().get(str));
    }
    a("action:" + paramReportAction.getValue() + ",reportUrl:" + paramString + ",reportData:", paramReportData.a());
    localBundle2.putInt("PostBodyType", 1);
    paramString = HttpUtil.postUrlForByteWithJson(BaseApplication.getContext(), paramString, paramReportData.a(), localBundle1);
    if (paramString == null)
    {
      a("action:" + paramReportAction.getValue() + ",report result: ", "bytes null");
      return;
    }
    paramString = new String(paramString);
    a("action:" + paramReportAction.getValue() + ",report result:", paramString);
  }
  
  private void a(String paramString1, String paramString2)
  {
    QLog.d("AdReportManager", 2, paramString1 + paramString2);
  }
  
  public static boolean a(AdReportData paramAdReportData)
  {
    return (AdReportUtil.a(paramAdReportData) == ReportAction.EXPOSE) && (jdField_a_of_type_JavaUtilVector.contains(a(paramAdReportData)));
  }
  
  public static boolean b(AdReportData paramAdReportData)
  {
    if (AdReportUtil.a(paramAdReportData) != ReportAction.EXPOSE) {
      return false;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (!jdField_a_of_type_JavaUtilVector.contains(a(paramAdReportData)))
      {
        jdField_a_of_type_JavaUtilVector.add(a(paramAdReportData));
        return false;
      }
    }
    return true;
  }
  
  public void a(AdReportData paramAdReportData)
  {
    if (paramAdReportData == null) {
      return;
    }
    ThreadManager.post(new AdReportManager.1(this, paramAdReportData), 5, null, true);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.AdReportManager
 * JD-Core Version:    0.7.0.1
 */