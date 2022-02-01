package com.google.android.material.datepicker;

import com.google.android.material.textfield.TextInputLayout;

class DateFormatTextWatcher$2
  implements Runnable
{
  DateFormatTextWatcher$2(DateFormatTextWatcher paramDateFormatTextWatcher, long paramLong) {}
  
  public void run()
  {
    DateFormatTextWatcher.a(this.this$0).setError(String.format(DateFormatTextWatcher.c(this.this$0), new Object[] { DateStrings.e(this.a) }));
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.DateFormatTextWatcher.2
 * JD-Core Version:    0.7.0.1
 */