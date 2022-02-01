package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;

class SingleDateSelector$1
  extends DateFormatTextWatcher
{
  SingleDateSelector$1(SingleDateSelector paramSingleDateSelector, String paramString, DateFormat paramDateFormat, TextInputLayout paramTextInputLayout, CalendarConstraints paramCalendarConstraints, OnSelectionChangedListener paramOnSelectionChangedListener)
  {
    super(paramString, paramDateFormat, paramTextInputLayout, paramCalendarConstraints);
  }
  
  void a()
  {
    this.a.a();
  }
  
  void a(@Nullable Long paramLong)
  {
    if (paramLong == null) {
      SingleDateSelector.a(this.b);
    } else {
      this.b.a(paramLong.longValue());
    }
    this.a.a(this.b.e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.SingleDateSelector.1
 * JD-Core Version:    0.7.0.1
 */