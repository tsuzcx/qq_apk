package com.tencent.mm.ui.widget.picker;

import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;

class YADatePicker$DatePickerSpinnerDelegate$2
  implements CalendarView.OnDateChangeListener
{
  YADatePicker$DatePickerSpinnerDelegate$2(YADatePicker.DatePickerSpinnerDelegate paramDatePickerSpinnerDelegate) {}
  
  public void onSelectedDayChange(CalendarView paramCalendarView, int paramInt1, int paramInt2, int paramInt3)
  {
    YADatePicker.DatePickerSpinnerDelegate.a(this.a, paramInt1, paramInt2, paramInt3);
    YADatePicker.DatePickerSpinnerDelegate.d(this.a);
    YADatePicker.DatePickerSpinnerDelegate.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerSpinnerDelegate.2
 * JD-Core Version:    0.7.0.1
 */