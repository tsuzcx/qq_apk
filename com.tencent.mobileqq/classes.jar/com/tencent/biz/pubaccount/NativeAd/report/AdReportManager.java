package com.tencent.biz.pubaccount.NativeAd.report;

import android.os.Bundle;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
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
    boolean bool2 = false;
    if (localAladdinConfig.getIntegerFromString("ad_new_report", 0) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_Boolean = bool1;
    boolean bool1 = bool2;
    if (localAladdinConfig.getIntegerFromString("soft_new_report", 0) == 1) {
      bool1 = true;
    }
    this.b = bool1;
  }
  
  public static AdReportManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountNativeAdReportAdReportManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentBizPubaccountNativeAdReportAdReportManager == null) {
          jdField_a_of_type_ComTencentBizPubaccountNativeAdReportAdReportManager = new AdReportManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentBizPubaccountNativeAdReportAdReportManager;
  }
  
  private static String a(AdReportData paramAdReportData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AdReportUtil.b(paramAdReportData));
    localStringBuilder.append("_");
    localStringBuilder.append(AdReportUtil.a(paramAdReportData));
    localStringBuilder.append("_");
    localStringBuilder.append(paramAdReportData.a());
    return localStringBuilder.toString();
  }
  
  private void a(String paramString, ReportData paramReportData, ReportAction paramReportAction)
  {
    Bundle localBundle1 = new Bundle();
    HttpUtil.addCookie(localBundle1);
    Bundle localBundle2 = new Bundle();
    Object localObject = paramReportData.a().keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localBundle2.putString(str, (String)paramReportData.a().get(str));
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("action:");
    ((StringBuilder)localObject).append(paramReportAction.getValue());
    ((StringBuilder)localObject).append(",reportUrl:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",reportData:");
    a(((StringBuilder)localObject).toString(), paramReportData.a());
    localBundle2.putInt("PostBodyType", 1);
    paramString = HttpUtil.postUrlForByteWithJson(BaseApplication.getContext(), paramString, paramReportData.a(), localBundle1);
    if (paramString == null)
    {
      paramString = new StringBuilder();
      paramString.append("action:");
      paramString.append(paramReportAction.getValue());
      paramString.append(",report result: ");
      a(paramString.toString(), "bytes null");
      return;
    }
    paramString = new String(paramString);
    paramReportData = new StringBuilder();
    paramReportData.append("action:");
    paramReportData.append(paramReportAction.getValue());
    paramReportData.append(",report result:");
    a(paramReportData.toString(), paramString);
  }
  
  private void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    QLog.d("AdReportManager", 2, localStringBuilder.toString());
  }
  
  public static boolean a(AdReportData paramAdReportData)
  {
    ActionEntity localActionEntity1 = paramAdReportData.a();
    ActionEntity localActionEntity2 = ActionEntity.PKMiddlePage;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localActionEntity2 != localActionEntity1)
    {
      bool1 = bool2;
      if (ActionEntity.ImaxPic != localActionEntity1)
      {
        if (ActionEntity.ImaxVideo == localActionEntity1) {
          return false;
        }
        bool1 = bool2;
        if (AdReportUtil.a(paramAdReportData) == ReportAction.EXPOSE)
        {
          bool1 = bool2;
          if (jdField_a_of_type_JavaUtilVector.contains(a(paramAdReportData))) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean b(AdReportData paramAdReportData)
  {
    if (AdReportUtil.a(paramAdReportData) != ReportAction.EXPOSE) {
      return false;
    }
    ??? = AdReportUtil.a(paramAdReportData);
    if ((ActionEntity.PKMiddlePage != ???) && (ActionEntity.ImaxPic != ???))
    {
      if (ActionEntity.ImaxVideo == ???) {
        return false;
      }
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (!jdField_a_of_type_JavaUtilVector.contains(a(paramAdReportData)))
        {
          jdField_a_of_type_JavaUtilVector.add(a(paramAdReportData));
          return false;
        }
        return true;
      }
    }
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.AdReportManager
 * JD-Core Version:    0.7.0.1
 */