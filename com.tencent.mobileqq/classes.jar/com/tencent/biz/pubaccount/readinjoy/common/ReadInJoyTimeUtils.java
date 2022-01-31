package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReadInJoyTimeUtils
{
  public static long a()
  {
    return NetConnInfoCenter.getServerTime();
  }
  
  static String a(int paramInt)
  {
    if (paramInt < 10) {
      return '0' + String.valueOf(paramInt);
    }
    return String.valueOf(paramInt);
  }
  
  public static String a(long paramLong)
  {
    return new SimpleDateFormat("MM月dd日").format(Long.valueOf(1000L * paramLong));
  }
  
  public static String a(long paramLong, boolean paramBoolean)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(1000L * paramLong);
    if (paramBoolean) {}
    long l1;
    int i;
    int j;
    int k;
    int n;
    for (paramLong = a() * 1000L;; paramLong = localCalendar1.getTimeInMillis())
    {
      if (paramLong != localCalendar1.getTimeInMillis()) {
        localCalendar1.setTimeInMillis(paramLong);
      }
      long l2 = localCalendar1.get(11) * 60 * 60 * 1000;
      long l3 = localCalendar1.get(12) * 60 * 1000;
      long l4 = localCalendar1.get(13) * 1000;
      l1 = paramLong - localCalendar2.getTimeInMillis();
      paramLong = paramLong - l2 - l3 - l4 - localCalendar2.getTimeInMillis();
      if (l1 >= 0L) {
        break label361;
      }
      i = localCalendar2.get(1);
      j = localCalendar2.get(2);
      k = localCalendar2.get(5);
      int m = localCalendar1.get(1);
      n = localCalendar1.get(5);
      if (m == i) {
        break;
      }
      return i + "-" + a(j + 1) + "-" + a(k);
    }
    if (k != n) {
      return a(localCalendar2.get(2) + 1) + "-" + a(localCalendar2.get(5)) + " " + a(localCalendar2.get(11)) + ":" + a(localCalendar2.get(12));
    }
    return "今天" + a(localCalendar2.get(11)) + ":" + a(localCalendar2.get(12));
    label361:
    l1 /= 1000L;
    if ((l1 >= 0L) && (l1 < 60L)) {
      return "刚刚";
    }
    if ((l1 >= 60L) && (l1 < 3600L)) {
      return l1 / 60L + "分钟前";
    }
    if ((l1 >= 3600L) && (l1 < 86400L)) {
      return l1 / 3600L + "小时前";
    }
    if ((paramLong >= 0L) && (paramLong < 86400000L)) {
      return "昨天";
    }
    if (paramLong >= 86400000L)
    {
      i = localCalendar2.get(1);
      j = localCalendar2.get(2) + 1;
      k = localCalendar2.get(5);
      if (localCalendar1.get(1) != i) {
        return i + "-" + a(j) + "-" + a(k);
      }
      return a(j) + "-" + a(k);
    }
    return "";
  }
  
  public static String b(long paramLong)
  {
    paramLong *= 1000L;
    Object localObject1 = null;
    try
    {
      Object localObject2 = new Date(paramLong);
      localObject2 = new SimpleDateFormat("yyyy-MM-dd").format((Date)localObject2);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ReadInJoyTimeUtils", 2, "getDateTimeString() ERROR millisTime=" + paramLong);
    }
    return localObject1;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils
 * JD-Core Version:    0.7.0.1
 */