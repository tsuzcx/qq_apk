package com.tencent.mobileqq.activity.aio.upcoming;

import java.util.Calendar;
import java.util.Date;

public class DateUtils
{
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 7: 
      return "星期六";
    case 6: 
      return "星期五";
    case 5: 
      return "星期四";
    case 4: 
      return "星期三";
    case 3: 
      return "星期二";
    case 2: 
      return "星期一";
    }
    return "星期日";
  }
  
  public static String a(long paramLong)
  {
    long l = System.currentTimeMillis();
    String str1 = b(paramLong);
    String str2 = a(paramLong, a(paramLong, l) ^ true, true, true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str2);
    localStringBuilder.append(" ");
    localStringBuilder.append(str1);
    return localStringBuilder.toString();
  }
  
  public static String a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    StringBuilder localStringBuilder = new StringBuilder();
    String str = "";
    if (paramBoolean1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localCalendar.get(1));
      ((StringBuilder)localObject).append("-");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    if (paramBoolean2) {
      localObject = String.format("%02d-", new Object[] { Integer.valueOf(localCalendar.get(2) + 1) });
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    Object localObject = str;
    if (paramBoolean3) {
      localObject = String.format("%02d", new Object[] { Integer.valueOf(localCalendar.get(5)) });
    }
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return localCalendar1.get(1) == localCalendar2.get(1);
  }
  
  public static String b(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return String.format("%02d:%02d", new Object[] { Integer.valueOf(localDate.getHours()), Integer.valueOf(localDate.getMinutes()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.DateUtils
 * JD-Core Version:    0.7.0.1
 */