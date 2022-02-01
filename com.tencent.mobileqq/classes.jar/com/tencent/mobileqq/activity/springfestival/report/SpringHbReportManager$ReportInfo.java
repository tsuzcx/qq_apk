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
    paramString2.append("event=").append(paramString1).append("&action=").append(paramInt1).append("&result=").append(paramInt2);
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      paramString1 = paramMap.entrySet().iterator();
      while (paramString1.hasNext())
      {
        paramMap = (Map.Entry)paramString1.next();
        paramString2.append("&").append((String)paramMap.getKey()).append("=").append((String)paramMap.getValue());
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
    return !TextUtils.isEmpty(this.eventName);
  }
  
  public boolean merge(ReportInfo paramReportInfo)
  {
    if (paramReportInfo == null) {}
    do
    {
      do
      {
        do
        {
          return false;
          if (QLog.isColorLevel())
          {
            QLog.d("shua2021report_SpringHbReportManager", 2, "[merge] reportInfo " + paramReportInfo);
            QLog.d("shua2021report_SpringHbReportManager", 2, "[merge] eventName " + this.eventName + " action " + this.action + " result " + this.result + " paramsStr " + this.paramsStr + " optime " + this.optime + " strAction " + this.strAction);
          }
        } while ((!TextUtils.equals(this.eventName, paramReportInfo.eventName)) || (this.action != paramReportInfo.action) || (this.result != paramReportInfo.result));
        if (TextUtils.equals(this.paramsStr, paramReportInfo.paramsStr)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("shua2021report_SpringHbReportManager", 2, "paramsStr is different");
      return false;
    } while ((!isOptimeCanMerged(this.optime, paramReportInfo.optime)) || (!TextUtils.equals(this.strAction, paramReportInfo.strAction)));
    this.optime = Math.max(this.optime, paramReportInfo.optime);
    this.count += paramReportInfo.count;
    if (QLog.isColorLevel()) {
      QLog.d("shua2021report_SpringHbReportManager", 2, " count " + this.count);
    }
    return true;
  }
  
  public String toString()
  {
    return "ReportInfo{eN = " + this.eventName + '\n' + ", a = " + this.action + ", r = " + this.result + ", p = " + this.paramsStr + ", sA= " + this.strAction + "，time = " + this.optime + ", iRT = " + this.isRealTime + ", c : " + this.count + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.report.SpringHbReportManager.ReportInfo
 * JD-Core Version:    0.7.0.1
 */