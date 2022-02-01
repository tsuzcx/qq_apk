package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;

class TimeSource
{
  private static final TimeSource jdField_a_of_type_ComGoogleAndroidMaterialDatepickerTimeSource = new TimeSource(null, null);
  @Nullable
  private final Long jdField_a_of_type_JavaLangLong;
  @Nullable
  private final TimeZone jdField_a_of_type_JavaUtilTimeZone;
  
  private TimeSource(@Nullable Long paramLong, @Nullable TimeZone paramTimeZone)
  {
    this.jdField_a_of_type_JavaLangLong = paramLong;
    this.jdField_a_of_type_JavaUtilTimeZone = paramTimeZone;
  }
  
  static TimeSource a()
  {
    return jdField_a_of_type_ComGoogleAndroidMaterialDatepickerTimeSource;
  }
  
  Calendar a()
  {
    return a(this.jdField_a_of_type_JavaUtilTimeZone);
  }
  
  Calendar a(@Nullable TimeZone paramTimeZone)
  {
    if (paramTimeZone == null) {
      paramTimeZone = Calendar.getInstance();
    } else {
      paramTimeZone = Calendar.getInstance(paramTimeZone);
    }
    Long localLong = this.jdField_a_of_type_JavaLangLong;
    if (localLong != null) {
      paramTimeZone.setTimeInMillis(localLong.longValue());
    }
    return paramTimeZone;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.TimeSource
 * JD-Core Version:    0.7.0.1
 */