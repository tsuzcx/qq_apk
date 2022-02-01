package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.format.DateUtils;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

class DateStrings
{
  static Pair<String, String> a(@Nullable Long paramLong1, @Nullable Long paramLong2)
  {
    return a(paramLong1, paramLong2, null);
  }
  
  static Pair<String, String> a(@Nullable Long paramLong1, @Nullable Long paramLong2, @Nullable SimpleDateFormat paramSimpleDateFormat)
  {
    if ((paramLong1 == null) && (paramLong2 == null)) {
      return Pair.create(null, null);
    }
    if (paramLong1 == null) {
      return Pair.create(null, a(paramLong2.longValue(), paramSimpleDateFormat));
    }
    if (paramLong2 == null) {
      return Pair.create(a(paramLong1.longValue(), paramSimpleDateFormat), null);
    }
    Calendar localCalendar1 = UtcDates.a();
    Calendar localCalendar2 = UtcDates.b();
    localCalendar2.setTimeInMillis(paramLong1.longValue());
    Calendar localCalendar3 = UtcDates.b();
    localCalendar3.setTimeInMillis(paramLong2.longValue());
    if (paramSimpleDateFormat != null)
    {
      paramLong1 = new Date(paramLong1.longValue());
      paramLong2 = new Date(paramLong2.longValue());
      return Pair.create(paramSimpleDateFormat.format(paramLong1), paramSimpleDateFormat.format(paramLong2));
    }
    if (localCalendar2.get(1) == localCalendar3.get(1))
    {
      if (localCalendar2.get(1) == localCalendar1.get(1)) {
        return Pair.create(b(paramLong1.longValue(), Locale.getDefault()), b(paramLong2.longValue(), Locale.getDefault()));
      }
      return Pair.create(b(paramLong1.longValue(), Locale.getDefault()), a(paramLong2.longValue(), Locale.getDefault()));
    }
    return Pair.create(a(paramLong1.longValue(), Locale.getDefault()), a(paramLong2.longValue(), Locale.getDefault()));
  }
  
  static String a(long paramLong)
  {
    return a(paramLong, Locale.getDefault());
  }
  
  static String a(long paramLong, @Nullable SimpleDateFormat paramSimpleDateFormat)
  {
    Calendar localCalendar1 = UtcDates.a();
    Calendar localCalendar2 = UtcDates.b();
    localCalendar2.setTimeInMillis(paramLong);
    if (paramSimpleDateFormat != null) {
      return paramSimpleDateFormat.format(new Date(paramLong));
    }
    if (localCalendar1.get(1) == localCalendar2.get(1)) {
      return b(paramLong);
    }
    return a(paramLong);
  }
  
  static String a(long paramLong, Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return UtcDates.a(paramLocale).format(new Date(paramLong));
    }
    return UtcDates.a(paramLocale).format(new Date(paramLong));
  }
  
  static String a(Context paramContext, long paramLong)
  {
    return DateUtils.formatDateTime(paramContext, paramLong - TimeZone.getDefault().getOffset(paramLong), 36);
  }
  
  static String b(long paramLong)
  {
    return b(paramLong, Locale.getDefault());
  }
  
  static String b(long paramLong, Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return UtcDates.b(paramLocale).format(new Date(paramLong));
    }
    return UtcDates.b(paramLocale).format(new Date(paramLong));
  }
  
  static String c(long paramLong)
  {
    return c(paramLong, Locale.getDefault());
  }
  
  static String c(long paramLong, Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return UtcDates.c(paramLocale).format(new Date(paramLong));
    }
    return UtcDates.c(paramLocale).format(new Date(paramLong));
  }
  
  static String d(long paramLong)
  {
    return d(paramLong, Locale.getDefault());
  }
  
  static String d(long paramLong, Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return UtcDates.d(paramLocale).format(new Date(paramLong));
    }
    return UtcDates.c(paramLocale).format(new Date(paramLong));
  }
  
  static String e(long paramLong)
  {
    return a(paramLong, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.DateStrings
 * JD-Core Version:    0.7.0.1
 */