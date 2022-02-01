package com.tencent.mm.ui.widget.picker;

import android.widget.NumberPicker.Formatter;
import java.util.Formatter;
import java.util.Locale;

final class TwoDigitFormatter
  implements NumberPicker.Formatter
{
  final StringBuilder a = new StringBuilder();
  final Object[] b = new Object[1];
  char c;
  Formatter d;
  
  TwoDigitFormatter()
  {
    b(Locale.getDefault());
  }
  
  private static char a(Locale paramLocale)
  {
    return '0';
  }
  
  private void b(Locale paramLocale)
  {
    this.d = c(paramLocale);
    this.c = a(paramLocale);
  }
  
  private Formatter c(Locale paramLocale)
  {
    return new Formatter(this.a, paramLocale);
  }
  
  public String format(int paramInt)
  {
    Object localObject = Locale.getDefault();
    if (this.c != a((Locale)localObject)) {
      b((Locale)localObject);
    }
    this.b[0] = Integer.valueOf(paramInt);
    localObject = this.a;
    ((StringBuilder)localObject).delete(0, ((StringBuilder)localObject).length());
    this.d.format("%02d", this.b);
    return this.d.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.TwoDigitFormatter
 * JD-Core Version:    0.7.0.1
 */