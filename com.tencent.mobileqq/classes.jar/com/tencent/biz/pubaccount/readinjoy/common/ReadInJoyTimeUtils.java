package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReadInJoyTimeUtils
{
  public static final String a = HardCodeUtil.a(2131712704);
  public static final String b = HardCodeUtil.a(2131712903);
  public static final String c = HardCodeUtil.a(2131712935);
  public static final String d = HardCodeUtil.a(2131712688);
  public static final String e = HardCodeUtil.a(2131713047);
  public static final String f = HardCodeUtil.a(2131712950);
  public static final String g = HardCodeUtil.a(2131712799);
  public static final String h = HardCodeUtil.a(2131712724);
  public static final String i = HardCodeUtil.a(2131712718);
  public static final String j = HardCodeUtil.a(2131713025);
  public static final String k = HardCodeUtil.a(2131712941);
  public static final String l = HardCodeUtil.a(2131712737);
  public static final String m = HardCodeUtil.a(2131712753);
  public static final String n = HardCodeUtil.a(2131712759);
  public static final String o = HardCodeUtil.a(2131712734);
  public static final String p = HardCodeUtil.a(2131712898);
  
  public static long a()
  {
    return NetConnInfoCenter.getServerTime();
  }
  
  public static String a(long paramLong)
  {
    return new SimpleDateFormat("MM月dd日").format(Long.valueOf(1000L * paramLong));
  }
  
  public static String a(long paramLong, boolean paramBoolean)
  {
    return b(paramLong, paramBoolean);
  }
  
  public static String a(Calendar paramCalendar)
  {
    return new SimpleDateFormat("HH:mm").format(paramCalendar.getTime());
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6));
  }
  
  public static String b(long paramLong)
  {
    Date localDate = new Date(1000L * paramLong);
    return new SimpleDateFormat("yyyy-MM-dd").format(localDate);
  }
  
  private static String b(long paramLong, boolean paramBoolean)
  {
    long l1 = paramLong * 1000L;
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    long l2;
    String str;
    if (paramBoolean)
    {
      paramLong = a() * 1000L;
      if (paramLong != localCalendar1.getTimeInMillis()) {
        localCalendar1.setTimeInMillis(paramLong);
      }
      localCalendar2.setTimeInMillis(l1);
      l2 = (paramLong - l1) / 1000L;
      str = c(localCalendar2);
      if (l2 >= 0L) {
        break label138;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyTimeUtils", 2, new Object[] { "getRelativeDisplayTimeString = ", str, ", now = ", c(localCalendar1), ", publish = ", c(localCalendar2) });
      }
      return str;
      paramLong = localCalendar1.getTimeInMillis();
      break;
      label138:
      if (a(l1, paramLong))
      {
        if (l2 < 60L) {
          str = a;
        } else if (l2 < 3600L) {
          str = l2 / 60L + b;
        } else if (l2 < 86400L) {
          str = l2 / 3600L + c;
        }
      }
      else if (c(l1, paramLong)) {
        str = e + " " + a(localCalendar2);
      } else if (b(l1, paramLong)) {
        str = b(localCalendar2);
      } else {}
    }
  }
  
  public static String b(Calendar paramCalendar)
  {
    return new SimpleDateFormat("MM-dd HH:mm").format(paramCalendar.getTime());
  }
  
  public static boolean b(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return localCalendar1.get(1) == localCalendar2.get(1);
  }
  
  public static String c(Calendar paramCalendar)
  {
    return new SimpleDateFormat("yy-MM-dd HH:mm").format(paramCalendar.getTime());
  }
  
  public static boolean c(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong2);
    localCalendar1.add(6, -1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong1);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils
 * JD-Core Version:    0.7.0.1
 */