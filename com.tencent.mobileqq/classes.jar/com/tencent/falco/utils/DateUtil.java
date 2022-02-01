package com.tencent.falco.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public final class DateUtil
{
  public static final String FORMAT_DATE = "yyyy-MM-dd";
  public static final String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
  public static final String FORMAT_TIME = "HH:mm:ss";
  
  public static Date addDay(long paramLong, int paramInt)
  {
    return addDay(new Date(paramLong), paramInt);
  }
  
  public static Date addDay(Date paramDate, int paramInt)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.setTime(paramDate);
    localGregorianCalendar.add(5, paramInt);
    return localGregorianCalendar.getTime();
  }
  
  public static String formatDate(String paramString, Long paramLong)
  {
    return formatDate(new SimpleDateFormat(paramString, Locale.CHINA), paramLong);
  }
  
  public static String formatDate(SimpleDateFormat paramSimpleDateFormat, Long paramLong)
  {
    if ((paramLong == null) || (paramLong.longValue() <= 0L)) {
      return "";
    }
    if (String.valueOf(paramLong).length() == 13) {}
    for (long l = paramLong.longValue();; l = paramLong.longValue() * 1000L) {
      return paramSimpleDateFormat.format(new Date(l));
    }
  }
  
  public static int getDay()
  {
    return getTimeByType(5);
  }
  
  public static Date getFirstDayByMonth(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.add(2, -1);
    localCalendar.add(5, 1);
    return localCalendar.getTime();
  }
  
  public static Date getFirstDayByWeek(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.add(7, localCalendar.getActualMinimum(7) - localCalendar.get(7));
    return localCalendar.getTime();
  }
  
  public static int getHours()
  {
    return getTimeByType(11);
  }
  
  public static Date getLastDayByMonth(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.add(2, 1);
    localCalendar.add(5, -1);
    return localCalendar.getTime();
  }
  
  public static Date getLastDayByWeek(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.add(7, localCalendar.getActualMinimum(7) - localCalendar.get(7) + 6);
    return localCalendar.getTime();
  }
  
  public static int getMaxDayByMonth(int paramInt1, int paramInt2)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.clear();
    localCalendar.set(1, paramInt1);
    localCalendar.set(2, paramInt2);
    return localCalendar.getActualMaximum(5);
  }
  
  public static int getMinutes()
  {
    return getTimeByType(12);
  }
  
  public static int getMonth()
  {
    return getTimeByType(2);
  }
  
  public static int getSeconds()
  {
    return getTimeByType(13);
  }
  
  public static String getShortTime(long paramLong)
  {
    if (paramLong == 0L) {
      return "";
    }
    long l = (Calendar.getInstance().getTimeInMillis() - paramLong) / 1000L;
    if (l > 31536000L) {
      return formatDate("yyyy-MM-dd", Long.valueOf(paramLong));
    }
    if ((l > 86400L) && ((int)(l / 86400L) == 2)) {
      return "前天";
    }
    if ((l > 86400L) && ((int)(l / 86400L) == 1)) {
      return "昨天";
    }
    if (l > 3600L) {
      return (int)(l / 3600L) + "小时前";
    }
    if (l > 60L) {
      return (int)(l / 60L) + "分钟前";
    }
    return "刚刚";
  }
  
  public static String getShortTime2(long paramLong)
  {
    if (paramLong == 0L) {
      return "";
    }
    paramLong = (Calendar.getInstance().getTimeInMillis() - paramLong) / 1000L;
    if (paramLong > 86400L) {
      return (int)(paramLong / 86400L) + "天";
    }
    if (paramLong > 3600L) {
      return (int)(paramLong / 3600L) + "小时";
    }
    if (paramLong > 60L) {
      return (int)(paramLong / 60L) + "分钟";
    }
    return (int)paramLong + "秒";
  }
  
  private static int getTimeByType(int paramInt)
  {
    return Calendar.getInstance().get(paramInt);
  }
  
  public static String getTimeFromInt(int paramInt)
  {
    if (paramInt <= 0) {
      return "00:00";
    }
    int i = paramInt / 60;
    paramInt %= 60;
    String str1;
    if (i >= 10)
    {
      str1 = String.valueOf(i);
      if (paramInt < 10) {
        break label89;
      }
    }
    label89:
    for (String str2 = String.valueOf(paramInt);; str2 = "0" + String.valueOf(paramInt))
    {
      return str1 + ":" + str2;
      str1 = "0" + String.valueOf(i);
      break;
    }
  }
  
  public static String getWeek(Date paramDate)
  {
    int i = 0;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    int j = localCalendar.get(7) - 1;
    if (j < 0) {}
    for (;;)
    {
      return new String[] { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" }[i];
      i = j;
    }
  }
  
  public static int getYear()
  {
    return getTimeByType(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.utils.DateUtil
 * JD-Core Version:    0.7.0.1
 */