package com.google.android.material.datepicker;

import android.content.Context;
import com.google.android.material.R.string;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

class DateFormatTextWatcher$1
  implements Runnable
{
  DateFormatTextWatcher$1(DateFormatTextWatcher paramDateFormatTextWatcher, String paramString) {}
  
  public void run()
  {
    TextInputLayout localTextInputLayout = DateFormatTextWatcher.a(this.this$0);
    Object localObject1 = DateFormatTextWatcher.a(this.this$0);
    Object localObject2 = localTextInputLayout.getContext();
    String str1 = ((Context)localObject2).getString(R.string.A);
    String str2 = String.format(((Context)localObject2).getString(R.string.C), new Object[] { this.a });
    localObject1 = String.format(((Context)localObject2).getString(R.string.B), new Object[] { ((DateFormat)localObject1).format(new Date(UtcDates.a().getTimeInMillis())) });
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append("\n");
    ((StringBuilder)localObject2).append(str2);
    ((StringBuilder)localObject2).append("\n");
    ((StringBuilder)localObject2).append((String)localObject1);
    localTextInputLayout.setError(((StringBuilder)localObject2).toString());
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.DateFormatTextWatcher.1
 * JD-Core Version:    0.7.0.1
 */