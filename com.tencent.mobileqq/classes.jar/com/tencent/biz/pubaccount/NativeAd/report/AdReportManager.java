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
  private static volatile AdReportManager a;
  private static final Vector<String> d = new Vector();
  private static final Object e = new Object();
  private boolean b;
  private boolean c;
  
  private AdReportManager()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(371);
    boolean bool2 = false;
    if (localAladdinConfig.getIntegerFromString("ad_new_report", 0) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.b = bool1;
    boolean bool1 = bool2;
    if (localAladdinConfig.getIntegerFromString("soft_new_report", 0) == 1) {
      bool1 = true;
    }
    this.c = bool1;
  }
  
  public static AdReportManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new AdReportManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(String paramString, ReportData paramReportData, ReportAction paramReportAction)
  {
    Bundle localBundle1 = new Bundle();
    HttpUtil.addCookie(localBundle1);
    Bundle localBundle2 = new Bundle();
    Object localObject = paramReportData.c().keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localBundle2.putString(str, (String)paramReportData.c().get(str));
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("action:");
    ((StringBuilder)localObject).append(paramReportAction.getValue());
    ((StringBuilder)localObject).append(",reportUrl:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",reportData:");
    a(((StringBuilder)localObject).toString(), paramReportData.b());
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
  
  public static boolean b(AdReportData paramAdReportData)
  {
    ActionEntity localActionEntity1 = paramAdReportData.v();
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
          if (d.contains(d(paramAdReportData))) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean c(AdReportData paramAdReportData)
  {
    if (AdReportUtil.a(paramAdReportData) != ReportAction.EXPOSE) {
      return false;
    }
    ??? = AdReportUtil.b(paramAdReportData);
    if ((ActionEntity.PKMiddlePage != ???) && (ActionEntity.ImaxPic != ???))
    {
      if (ActionEntity.ImaxVideo == ???) {
        return false;
      }
      synchronized (e)
      {
        if (!d.contains(d(paramAdReportData)))
        {
          d.add(d(paramAdReportData));
          return false;
        }
        return true;
      }
    }
    return false;
  }
  
  private static String d(AdReportData paramAdReportData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AdReportUtil.e(paramAdReportData));
    localStringBuilder.append("_");
    localStringBuilder.append(AdReportUtil.b(paramAdReportData));
    localStringBuilder.append("_");
    localStringBuilder.append(paramAdReportData.t());
    return localStringBuilder.toString();
  }
  
  public void a(AdReportData paramAdReportData)
  {
    if (paramAdReportData == null) {
      return;
    }
    ThreadManager.post(new AdReportManager.1(this, paramAdReportData), 5, null, true);
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.AdReportManager
 * JD-Core Version:    0.7.0.1
 */