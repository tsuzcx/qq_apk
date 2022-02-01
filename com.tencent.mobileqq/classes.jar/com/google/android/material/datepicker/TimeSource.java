package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;

class TimeSource
{
  private static final TimeSource a = new TimeSource(null, null);
  @Nullable
  private final Long b;
  @Nullable
  private final TimeZone c;
  
  private TimeSource(@Nullable Long paramLong, @Nullable TimeZone paramTimeZone)
  {
    this.b = paramLong;
    this.c = paramTimeZone;
  }
  
  static TimeSource a()
  {
    return a;
  }
  
  Calendar a(@Nullable TimeZone paramTimeZone)
  {
    if (paramTimeZone == null) {
      paramTimeZone = Calendar.getInstance();
    } else {
      paramTimeZone = Calendar.getInstance(paramTimeZone);
    }
    Long localLong = this.b;
    if (localLong != null) {
      paramTimeZone.setTimeInMillis(localLong.longValue());
    }
    return paramTimeZone;
  }
  
  Calendar b()
  {
    return a(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.TimeSource
 * JD-Core Version:    0.7.0.1
 */