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
    if ((paramLong != null) && (paramLong.longValue() > 0L))
    {
      long l;
      if (String.valueOf(paramLong).length() == 13) {
        l = paramLong.longValue();
      } else {
        l = paramLong.longValue() * 1000L;
      }
      return paramSimpleDateFormat.format(new Date(l));
    }
    return "";
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
    StringBuilder localStringBuilder;
    if (l > 3600L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((int)(l / 3600L));
      localStringBuilder.append("小时前");
      return localStringBuilder.toString();
    }
    if (l > 60L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((int)(l / 60L));
      localStringBuilder.append("分钟前");
      return localStringBuilder.toString();
    }
    return "刚刚";
  }
  
  public static String getShortTime2(long paramLong)
  {
    if (paramLong == 0L) {
      return "";
    }
    paramLong = (Calendar.getInstance().getTimeInMillis() - paramLong) / 1000L;
    if (paramLong > 86400L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((int)(paramLong / 86400L));
      localStringBuilder.append("天");
      return localStringBuilder.toString();
    }
    if (paramLong > 3600L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((int)(paramLong / 3600L));
      localStringBuilder.append("小时");
      return localStringBuilder.toString();
    }
    if (paramLong > 60L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((int)(paramLong / 60L));
      localStringBuilder.append("分钟");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((int)paramLong);
    localStringBuilder.append("秒");
    return localStringBuilder.toString();
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
    Object localObject1;
    if (i >= 10)
    {
      localObject1 = String.valueOf(i);
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("0");
      ((StringBuilder)localObject1).append(String.valueOf(i));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2;
    if (paramInt >= 10)
    {
      localObject2 = String.valueOf(paramInt);
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("0");
      ((StringBuilder)localObject2).append(String.valueOf(paramInt));
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(":");
    localStringBuilder.append((String)localObject2);
    return localStringBuilder.toString();
  }
  
  public static String getWeek(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    int j = localCalendar.get(7) - 1;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    return new String[] { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" }[i];
  }
  
  public static int getYear()
  {
    return getTimeByType(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.utils.DateUtil
 * JD-Core Version:    0.7.0.1
 */