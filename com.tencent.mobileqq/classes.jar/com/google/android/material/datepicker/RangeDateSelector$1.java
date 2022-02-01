package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;

class RangeDateSelector$1
  extends DateFormatTextWatcher
{
  RangeDateSelector$1(RangeDateSelector paramRangeDateSelector, String paramString, DateFormat paramDateFormat, TextInputLayout paramTextInputLayout1, CalendarConstraints paramCalendarConstraints, TextInputLayout paramTextInputLayout2, TextInputLayout paramTextInputLayout3, OnSelectionChangedListener paramOnSelectionChangedListener)
  {
    super(paramString, paramDateFormat, paramTextInputLayout1, paramCalendarConstraints);
  }
  
  void a()
  {
    RangeDateSelector.a(this.d, null);
    RangeDateSelector.a(this.d, this.a, this.b, this.c);
  }
  
  void a(@Nullable Long paramLong)
  {
    RangeDateSelector.a(this.d, paramLong);
    RangeDateSelector.a(this.d, this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.RangeDateSelector.1
 * JD-Core Version:    0.7.0.1
 */