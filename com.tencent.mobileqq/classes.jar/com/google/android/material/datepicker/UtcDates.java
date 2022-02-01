package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R.string;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

class UtcDates
{
  static AtomicReference<TimeSource> a = new AtomicReference();
  
  private static int a(@NonNull String paramString1, @NonNull String paramString2, int paramInt1, int paramInt2)
  {
    while ((paramInt2 >= 0) && (paramInt2 < paramString1.length()) && (paramString2.indexOf(paramString1.charAt(paramInt2)) == -1))
    {
      int i = paramInt2;
      if (paramString1.charAt(paramInt2) == '\'') {
        do
        {
          paramInt2 += paramInt1;
          i = paramInt2;
          if (paramInt2 < 0) {
            break;
          }
          i = paramInt2;
          if (paramInt2 >= paramString1.length()) {
            break;
          }
          i = paramInt2;
        } while (paramString1.charAt(paramInt2) != '\'');
      }
      paramInt2 = i + paramInt1;
    }
    return paramInt2;
  }
  
  static long a(long paramLong)
  {
    Calendar localCalendar = c();
    localCalendar.setTimeInMillis(paramLong);
    return b(localCalendar).getTimeInMillis();
  }
  
  @TargetApi(24)
  private static android.icu.text.DateFormat a(String paramString, Locale paramLocale)
  {
    paramString = android.icu.text.DateFormat.getInstanceForSkeleton(paramString, paramLocale);
    paramString.setTimeZone(f());
    return paramString;
  }
  
  @TargetApi(24)
  static android.icu.text.DateFormat a(Locale paramLocale)
  {
    return a("yMMMd", paramLocale);
  }
  
  static TimeSource a()
  {
    TimeSource localTimeSource2 = (TimeSource)a.get();
    TimeSource localTimeSource1 = localTimeSource2;
    if (localTimeSource2 == null) {
      localTimeSource1 = TimeSource.a();
    }
    return localTimeSource1;
  }
  
  static String a(Resources paramResources, SimpleDateFormat paramSimpleDateFormat)
  {
    paramSimpleDateFormat = paramSimpleDateFormat.toLocalizedPattern();
    String str1 = paramResources.getString(R.string.M);
    String str2 = paramResources.getString(R.string.L);
    return paramSimpleDateFormat.replaceAll("d", paramResources.getString(R.string.K)).replaceAll("M", str2).replaceAll("y", str1);
  }
  
  @NonNull
  private static String a(@NonNull String paramString)
  {
    int i = a(paramString, "yY", 1, 0);
    if (i >= paramString.length()) {
      return paramString;
    }
    Object localObject = "EMd";
    int j = a(paramString, "EMd", 1, i);
    if (j < paramString.length())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("EMd");
      ((StringBuilder)localObject).append(",");
      localObject = ((StringBuilder)localObject).toString();
    }
    return paramString.replace(paramString.substring(a(paramString, (String)localObject, -1, i) + 1, j), " ").trim();
  }
  
  private static java.text.DateFormat a(int paramInt, Locale paramLocale)
  {
    paramLocale = java.text.DateFormat.getDateInstance(paramInt, paramLocale);
    paramLocale.setTimeZone(e());
    return paramLocale;
  }
  
  static Calendar a(@Nullable Calendar paramCalendar)
  {
    Calendar localCalendar = Calendar.getInstance(e());
    if (paramCalendar == null)
    {
      localCalendar.clear();
      return localCalendar;
    }
    localCalendar.setTimeInMillis(paramCalendar.getTimeInMillis());
    return localCalendar;
  }
  
  @TargetApi(24)
  static android.icu.text.DateFormat b(Locale paramLocale)
  {
    return a("MMMd", paramLocale);
  }
  
  static Calendar b()
  {
    Calendar localCalendar = a().b();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    localCalendar.setTimeZone(e());
    return localCalendar;
  }
  
  static Calendar b(Calendar paramCalendar)
  {
    paramCalendar = a(paramCalendar);
    Calendar localCalendar = c();
    localCalendar.set(paramCalendar.get(1), paramCalendar.get(2), paramCalendar.get(5));
    return localCalendar;
  }
  
  @TargetApi(24)
  static android.icu.text.DateFormat c(Locale paramLocale)
  {
    return a("MMMEd", paramLocale);
  }
  
  static Calendar c()
  {
    return a(null);
  }
  
  @TargetApi(24)
  static android.icu.text.DateFormat d(Locale paramLocale)
  {
    return a("yMMMEd", paramLocale);
  }
  
  static SimpleDateFormat d()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(((SimpleDateFormat)java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toLocalizedPattern().replaceAll("\\s+", ""), Locale.getDefault());
    localSimpleDateFormat.setTimeZone(e());
    localSimpleDateFormat.setLenient(false);
    return localSimpleDateFormat;
  }
  
  static java.text.DateFormat e(Locale paramLocale)
  {
    return a(2, paramLocale);
  }
  
  private static java.util.TimeZone e()
  {
    return java.util.TimeZone.getTimeZone("UTC");
  }
  
  @TargetApi(24)
  private static android.icu.util.TimeZone f()
  {
    return android.icu.util.TimeZone.getTimeZone("UTC");
  }
  
  static java.text.DateFormat f(Locale paramLocale)
  {
    paramLocale = (SimpleDateFormat)e(paramLocale);
    paramLocale.applyPattern(a(paramLocale.toPattern()));
    return paramLocale;
  }
  
  static java.text.DateFormat g(Locale paramLocale)
  {
    return a(0, paramLocale);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.UtcDates
 * JD-Core Version:    0.7.0.1
 */