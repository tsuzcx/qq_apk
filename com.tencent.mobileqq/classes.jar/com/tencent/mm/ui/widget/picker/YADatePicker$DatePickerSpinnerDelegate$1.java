package com.tencent.mm.ui.widget.picker;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import java.util.Calendar;

class YADatePicker$DatePickerSpinnerDelegate$1
  implements NumberPicker.OnValueChangeListener
{
  YADatePicker$DatePickerSpinnerDelegate$1(YADatePicker.DatePickerSpinnerDelegate paramDatePickerSpinnerDelegate) {}
  
  public void onValueChange(NumberPicker paramNumberPicker, int paramInt1, int paramInt2)
  {
    YADatePicker.DatePickerSpinnerDelegate.a(this.a);
    YADatePicker.DatePickerSpinnerDelegate.c(this.a).setTimeInMillis(YADatePicker.DatePickerSpinnerDelegate.b(this.a).getTimeInMillis());
    if (paramNumberPicker == this.a.mDaySpinner)
    {
      int i = YADatePicker.DatePickerSpinnerDelegate.c(this.a).getActualMaximum(5);
      if ((paramInt1 == i) && (paramInt2 == 1)) {
        YADatePicker.DatePickerSpinnerDelegate.c(this.a).add(5, 1);
      } else if ((paramInt1 == 1) && (paramInt2 == i)) {
        YADatePicker.DatePickerSpinnerDelegate.c(this.a).add(5, -1);
      } else {
        YADatePicker.DatePickerSpinnerDelegate.c(this.a).add(5, paramInt2 - paramInt1);
      }
    }
    else if (paramNumberPicker == this.a.mMonthSpinner)
    {
      if ((paramInt1 == 11) && (paramInt2 == 0)) {
        YADatePicker.DatePickerSpinnerDelegate.c(this.a).add(2, 1);
      } else if ((paramInt1 == 0) && (paramInt2 == 11)) {
        YADatePicker.DatePickerSpinnerDelegate.c(this.a).add(2, -1);
      } else {
        YADatePicker.DatePickerSpinnerDelegate.c(this.a).add(2, paramInt2 - paramInt1);
      }
    }
    else
    {
      if (paramNumberPicker != this.a.mYearSpinner) {
        break label282;
      }
      YADatePicker.DatePickerSpinnerDelegate.c(this.a).set(1, paramInt2);
    }
    paramNumberPicker = this.a;
    YADatePicker.DatePickerSpinnerDelegate.a(paramNumberPicker, YADatePicker.DatePickerSpinnerDelegate.c(paramNumberPicker).get(1), YADatePicker.DatePickerSpinnerDelegate.c(this.a).get(2), YADatePicker.DatePickerSpinnerDelegate.c(this.a).get(5));
    YADatePicker.DatePickerSpinnerDelegate.d(this.a);
    YADatePicker.DatePickerSpinnerDelegate.e(this.a);
    YADatePicker.DatePickerSpinnerDelegate.f(this.a);
    return;
    label282:
    throw new IllegalArgumentException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerSpinnerDelegate.1
 * JD-Core Version:    0.7.0.1
 */