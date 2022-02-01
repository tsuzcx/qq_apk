package com.tencent.mobileqq.activity.springfestival.report;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SpringHbReportManager$ReportInfo
  implements Serializable
{
  public int action;
  int count;
  public String eventName;
  boolean isRealTime;
  boolean isSending;
  long optime;
  String paramsStr;
  long reqSeq;
  int result;
  int retryCount;
  String strAction;
  
  public static ReportInfo create(String paramString1, int paramInt1, int paramInt2, Map<String, String> paramMap, String paramString2, boolean paramBoolean)
  {
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.eventName = paramString1;
    localReportInfo.action = paramInt1;
    localReportInfo.result = paramInt2;
    localReportInfo.optime = NetConnInfoCenter.getServerTimeMillis();
    localReportInfo.count = 1;
    localReportInfo.strAction = paramString2;
    paramString2 = new StringBuilder();
    paramString2.append("event=");
    paramString2.append(paramString1);
    paramString2.append("&action=");
    paramString2.append(paramInt1);
    paramString2.append("&result=");
    paramString2.append(paramInt2);
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      paramString1 = paramMap.entrySet().iterator();
      while (paramString1.hasNext())
      {
        paramMap = (Map.Entry)paramString1.next();
        paramString2.append("&");
        paramString2.append((String)paramMap.getKey());
        paramString2.append("=");
        paramString2.append((String)paramMap.getValue());
      }
    }
    localReportInfo.paramsStr = paramString2.toString();
    localReportInfo.isRealTime = paramBoolean;
    return localReportInfo;
  }
  
  public static boolean isOptimeCanMerged(long paramLong1, long paramLong2)
  {
    try
    {
      Calendar localCalendar1 = Calendar.getInstance();
      localCalendar1.setTime(new Date(paramLong1));
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar2.setTime(new Date(paramLong2));
      if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6)))
      {
        int i = localCalendar1.get(11);
        int j = localCalendar2.get(11);
        if (i == j) {
          return true;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public boolean isValid()
  {
    return TextUtils.isEmpty(this.eventName) ^ true;
  }
  
  public boolean merge(ReportInfo paramReportInfo)
  {
    if (paramReportInfo == null) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[merge] reportInfo ");
      localStringBuilder.append(paramReportInfo);
      QLog.d("shua2021report_SpringHbReportManager", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[merge] eventName ");
      localStringBuilder.append(this.eventName);
      localStringBuilder.append(" action ");
      localStringBuilder.append(this.action);
      localStringBuilder.append(" result ");
      localStringBuilder.append(this.result);
      localStringBuilder.append(" paramsStr ");
      localStringBuilder.append(this.paramsStr);
      localStringBuilder.append(" optime ");
      localStringBuilder.append(this.optime);
      localStringBuilder.append(" strAction ");
      localStringBuilder.append(this.strAction);
      QLog.d("shua2021report_SpringHbReportManager", 2, localStringBuilder.toString());
    }
    if (!TextUtils.equals(this.eventName, paramReportInfo.eventName)) {
      return false;
    }
    if (this.action != paramReportInfo.action) {
      return false;
    }
    if (this.result != paramReportInfo.result) {
      return false;
    }
    if (!TextUtils.equals(this.paramsStr, paramReportInfo.paramsStr))
    {
      if (QLog.isColorLevel()) {
        QLog.d("shua2021report_SpringHbReportManager", 2, "paramsStr is different");
      }
      return false;
    }
    if (!isOptimeCanMerged(this.optime, paramReportInfo.optime)) {
      return false;
    }
    if (!TextUtils.equals(this.strAction, paramReportInfo.strAction)) {
      return false;
    }
    this.optime = Math.max(this.optime, paramReportInfo.optime);
    this.count += paramReportInfo.count;
    if (QLog.isColorLevel())
    {
      paramReportInfo = new StringBuilder();
      paramReportInfo.append(" count ");
      paramReportInfo.append(this.count);
      QLog.d("shua2021report_SpringHbReportManager", 2, paramReportInfo.toString());
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReportInfo{eN = ");
    localStringBuilder.append(this.eventName);
    localStringBuilder.append('\n');
    localStringBuilder.append(", a = ");
    localStringBuilder.append(this.action);
    localStringBuilder.append(", r = ");
    localStringBuilder.append(this.result);
    localStringBuilder.append(", p = ");
    localStringBuilder.append(this.paramsStr);
    localStringBuilder.append(", sA= ");
    localStringBuilder.append(this.strAction);
    localStringBuilder.append("，time = ");
    localStringBuilder.append(this.optime);
    localStringBuilder.append(", iRT = ");
    localStringBuilder.append(this.isRealTime);
    localStringBuilder.append(", c : ");
    localStringBuilder.append(this.count);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.report.SpringHbReportManager.ReportInfo
 * JD-Core Version:    0.7.0.1
 */