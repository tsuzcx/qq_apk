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
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerOnSelectionChangedListener.a();
  }
  
  void a(@Nullable Long paramLong)
  {
    if (paramLong == null) {
      SingleDateSelector.a(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerSingleDateSelector);
    } else {
      this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerSingleDateSelector.a(paramLong.longValue());
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerOnSelectionChangedListener.a(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerSingleDateSelector.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.SingleDateSelector.1
 * JD-Core Version:    0.7.0.1
 */