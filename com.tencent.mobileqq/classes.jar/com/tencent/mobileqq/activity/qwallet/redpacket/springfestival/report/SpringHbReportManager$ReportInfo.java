package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
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
  
  public static ReportInfo create(String paramString, int paramInt1, int paramInt2, Map<String, String> paramMap, boolean paramBoolean)
  {
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.eventName = paramString;
    localReportInfo.action = paramInt1;
    localReportInfo.result = paramInt2;
    localReportInfo.optime = NetConnInfoCenter.getServerTimeMillis();
    localReportInfo.count = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("event=").append(paramString).append("&action=").append(paramInt1).append("&result=").append(paramInt2);
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      paramString = paramMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        paramMap = (Map.Entry)paramString.next();
        localStringBuilder.append("&").append((String)paramMap.getKey()).append("=").append((String)paramMap.getValue());
      }
    }
    localReportInfo.paramsStr = localStringBuilder.toString();
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
    while ((!TextUtils.equals(this.eventName, paramReportInfo.eventName)) || (this.action != paramReportInfo.action) || (this.result != paramReportInfo.result) || (!TextUtils.equals(this.paramsStr, paramReportInfo.paramsStr)) || (!isOptimeCanMerged(this.optime, paramReportInfo.optime))) {
      return false;
    }
    this.optime = Math.max(this.optime, paramReportInfo.optime);
    this.count += paramReportInfo.count;
    return true;
  }
  
  public String toString()
  {
    return "ReportInfo{eN='" + this.eventName + '\'' + ", a=" + this.action + ", r=" + this.result + ", p=" + this.paramsStr + ", iRT=" + this.isRealTime + ",c:" + this.count + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbReportManager.ReportInfo
 * JD-Core Version:    0.7.0.1
 */