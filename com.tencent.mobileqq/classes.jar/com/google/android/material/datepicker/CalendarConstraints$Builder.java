package com.google.android.material.datepicker;

import android.os.Bundle;
import androidx.annotation.NonNull;

public final class CalendarConstraints$Builder
{
  static final long jdField_a_of_type_Long = UtcDates.a(Month.a(1900, 0).jdField_a_of_type_Long);
  static final long b = UtcDates.a(Month.a(2100, 11).jdField_a_of_type_Long);
  private CalendarConstraints.DateValidator jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints$DateValidator = DateValidatorPointForward.a(-9223372036854775808L);
  private Long jdField_a_of_type_JavaLangLong;
  private long c = jdField_a_of_type_Long;
  private long d = b;
  
  public CalendarConstraints$Builder() {}
  
  CalendarConstraints$Builder(@NonNull CalendarConstraints paramCalendarConstraints)
  {
    this.c = CalendarConstraints.a(paramCalendarConstraints).jdField_a_of_type_Long;
    this.d = CalendarConstraints.b(paramCalendarConstraints).jdField_a_of_type_Long;
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(CalendarConstraints.c(paramCalendarConstraints).jdField_a_of_type_Long);
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints$DateValidator = CalendarConstraints.a(paramCalendarConstraints);
  }
  
  @NonNull
  public Builder a(long paramLong)
  {
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
    return this;
  }
  
  @NonNull
  public CalendarConstraints a()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putParcelable("DEEP_COPY_VALIDATOR_KEY", this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints$DateValidator);
    Month localMonth1 = Month.a(this.c);
    Month localMonth2 = Month.a(this.d);
    CalendarConstraints.DateValidator localDateValidator = (CalendarConstraints.DateValidator)((Bundle)localObject).getParcelable("DEEP_COPY_VALIDATOR_KEY");
    localObject = this.jdField_a_of_type_JavaLangLong;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = Month.a(((Long)localObject).longValue());
    }
    return new CalendarConstraints(localMonth1, localMonth2, localDateValidator, (Month)localObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.CalendarConstraints.Builder
 * JD-Core Version:    0.7.0.1
 */