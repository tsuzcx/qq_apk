package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import java.util.Locale;

abstract class YADatePicker$AbstractDatePickerDelegate
  implements YADatePicker.DatePickerDelegate
{
  protected YADatePicker a;
  protected Context b;
  protected Locale c;
  protected YADatePicker.OnDateChangedListener d;
  protected YADatePicker.ValidationCallback e;
  
  protected YADatePicker$AbstractDatePickerDelegate(YADatePicker paramYADatePicker, Context paramContext)
  {
    this.a = paramYADatePicker;
    this.b = paramContext;
    a(Locale.getDefault());
  }
  
  protected void a(Locale paramLocale)
  {
    if (!paramLocale.equals(this.c))
    {
      this.c = paramLocale;
      b(paramLocale);
    }
  }
  
  protected void b(Locale paramLocale) {}
  
  public void setValidationCallback(YADatePicker.ValidationCallback paramValidationCallback)
  {
    this.e = paramValidationCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.YADatePicker.AbstractDatePickerDelegate
 * JD-Core Version:    0.7.0.1
 */