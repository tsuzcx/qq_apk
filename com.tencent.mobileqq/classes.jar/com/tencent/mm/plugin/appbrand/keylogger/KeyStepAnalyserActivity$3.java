package com.tencent.mm.plugin.appbrand.keylogger;

import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;
import java.util.Calendar;

class KeyStepAnalyserActivity$3
  implements DatePickerDialog.OnDateSetListener
{
  KeyStepAnalyserActivity$3(KeyStepAnalyserActivity paramKeyStepAnalyserActivity) {}
  
  public void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    paramDatePicker = Calendar.getInstance();
    KeyStepAnalyserActivity.a(this.a, paramInt1);
    KeyStepAnalyserActivity.b(this.a, paramInt2);
    KeyStepAnalyserActivity.c(this.a, paramInt3);
    paramDatePicker.set(paramInt1, paramInt2, paramInt3);
    KeyStepAnalyserActivity.a(this.a, paramDatePicker.getTimeInMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserActivity.3
 * JD-Core Version:    0.7.0.1
 */