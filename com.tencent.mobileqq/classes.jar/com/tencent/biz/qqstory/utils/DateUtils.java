package com.tencent.biz.qqstory.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class DateUtils
{
  private static final DateFormat a = new SimpleDateFormat("MM月/dd");
  private static final DateFormat b = new SimpleDateFormat("yyyy");
  private static final DateFormat c = new SimpleDateFormat("HH:mm");
  private static final DateFormat d = new SimpleDateFormat("MM月dd日");
  private static final DateFormat e = new SimpleDateFormat("yyyy年MM月dd日");
  private static final ThreadLocal<DateFormat> f = new DateUtils.1();
  private static final ThreadLocal<DateFormat> g = new DateUtils.2();
  
  public static String a()
  {
    long l = System.currentTimeMillis();
    return ((DateFormat)f.get()).format(Long.valueOf(l));
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong1);
    int i = localCalendar.get(1);
    localCalendar.setTimeInMillis(paramLong2);
    return localCalendar.get(1) == i;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Calendar localCalendar = Calendar.getInstance();
    paramString = b(paramString);
    return (localCalendar.get(1) == paramString[0]) && (localCalendar.get(2) + 1 == paramString[1]) && (localCalendar.get(5) == paramString[2]);
  }
  
  public static String[] a(long paramLong)
  {
    String[] arrayOfString = new String[2];
    int i = (int)((System.currentTimeMillis() - paramLong) / 86400000L);
    if (i == 0)
    {
      arrayOfString[1] = HardCodeUtil.a(2131917319);
      return arrayOfString;
    }
    if (i == 1)
    {
      arrayOfString[1] = HardCodeUtil.a(2131918208);
      return arrayOfString;
    }
    return a.format(Long.valueOf(paramLong)).split("/");
  }
  
  public static long b()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(localCalendar.get(1), 0, 1, 0, 0, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public static String b(long paramLong)
  {
    return ((DateFormat)g.get()).format(Long.valueOf(TimeUnit.SECONDS.toMillis(paramLong)));
  }
  
  public static int[] b(String paramString)
  {
    try
    {
      paramString = i(Long.valueOf(paramString).longValue());
      return paramString;
    }
    catch (Exception paramString)
    {
      label13:
      break label13;
    }
    return new int[] { 0, 0, 0 };
  }
  
  public static final long c()
  {
    Calendar localCalendar = Calendar.getInstance();
    return localCalendar.getTimeInMillis() - localCalendar.get(11) * 60 * 60 * 1000 - localCalendar.get(12) * 60 * 1000 - localCalendar.get(13) * 1000 - localCalendar.get(14);
  }
  
  public static String c(long paramLong)
  {
    long l = System.currentTimeMillis();
    int i = (int)((l - paramLong) / 86400000L);
    if (i == 0) {
      return HardCodeUtil.a(2131917319);
    }
    if (i == 1) {
      return HardCodeUtil.a(2131918208);
    }
    if (a(l, paramLong)) {
      return d.format(Long.valueOf(paramLong));
    }
    return e.format(Long.valueOf(paramLong));
  }
  
  public static String d(long paramLong)
  {
    return b.format(Long.valueOf(paramLong));
  }
  
  public static String e(long paramLong)
  {
    return c.format(Long.valueOf(paramLong));
  }
  
  public static boolean f(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int i = localCalendar.get(1);
    localCalendar.setTimeInMillis(System.currentTimeMillis());
    return localCalendar.get(1) == i;
  }
  
  public static boolean g(long paramLong)
  {
    return (int)((System.currentTimeMillis() - paramLong) / 86400000L) == 0;
  }
  
  public static boolean h(long paramLong)
  {
    return (int)((System.currentTimeMillis() - paramLong) / 86400000L) == 1;
  }
  
  public static int[] i(long paramLong)
  {
    return new int[] { (int)(paramLong / 10000L), (int)(paramLong % 10000L / 100L), (int)(paramLong % 100L) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.DateUtils
 * JD-Core Version:    0.7.0.1
 */