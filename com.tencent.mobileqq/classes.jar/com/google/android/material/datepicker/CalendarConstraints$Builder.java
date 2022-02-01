package com.google.android.material.datepicker;

import android.os.Bundle;
import androidx.annotation.NonNull;

public final class CalendarConstraints$Builder
{
  static final long a = UtcDates.a(Month.a(1900, 0).e);
  static final long b = UtcDates.a(Month.a(2100, 11).e);
  private long c = a;
  private long d = b;
  private Long e;
  private CalendarConstraints.DateValidator f = DateValidatorPointForward.b(-9223372036854775808L);
  
  public CalendarConstraints$Builder() {}
  
  CalendarConstraints$Builder(@NonNull CalendarConstraints paramCalendarConstraints)
  {
    this.c = CalendarConstraints.a(paramCalendarConstraints).e;
    this.d = CalendarConstraints.b(paramCalendarConstraints).e;
    this.e = Long.valueOf(CalendarConstraints.c(paramCalendarConstraints).e);
    this.f = CalendarConstraints.d(paramCalendarConstraints);
  }
  
  @NonNull
  public Builder a(long paramLong)
  {
    this.e = Long.valueOf(paramLong);
    return this;
  }
  
  @NonNull
  public CalendarConstraints a()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f);
    Month localMonth1 = Month.a(this.c);
    Month localMonth2 = Month.a(this.d);
    CalendarConstraints.DateValidator localDateValidator = (CalendarConstraints.DateValidator)((Bundle)localObject).getParcelable("DEEP_COPY_VALIDATOR_KEY");
    localObject = this.e;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = Month.a(((Long)localObject).longValue());
    }
    return new CalendarConstraints(localMonth1, localMonth2, localDateValidator, (Month)localObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.CalendarConstraints.Builder
 * JD-Core Version:    0.7.0.1
 */