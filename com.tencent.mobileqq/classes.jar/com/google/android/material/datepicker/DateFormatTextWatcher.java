package com.google.android.material.datepicker;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R.string;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

abstract class DateFormatTextWatcher
  extends TextWatcherAdapter
{
  @NonNull
  private final TextInputLayout a;
  private final DateFormat b;
  private final CalendarConstraints c;
  private final String d;
  private final Runnable e;
  private Runnable f;
  
  DateFormatTextWatcher(String paramString, DateFormat paramDateFormat, @NonNull TextInputLayout paramTextInputLayout, CalendarConstraints paramCalendarConstraints)
  {
    this.b = paramDateFormat;
    this.a = paramTextInputLayout;
    this.c = paramCalendarConstraints;
    this.d = paramTextInputLayout.getContext().getString(R.string.F);
    this.e = new DateFormatTextWatcher.1(this, paramString);
  }
  
  private Runnable a(long paramLong)
  {
    return new DateFormatTextWatcher.2(this, paramLong);
  }
  
  void a() {}
  
  public void a(View paramView, Runnable paramRunnable)
  {
    paramView.postDelayed(paramRunnable, 1000L);
  }
  
  abstract void a(@Nullable Long paramLong);
  
  public void onTextChanged(@NonNull CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.removeCallbacks(this.e);
    this.a.removeCallbacks(this.f);
    this.a.setError(null);
    a(null);
    if (TextUtils.isEmpty(paramCharSequence)) {
      return;
    }
    try
    {
      paramCharSequence = this.b.parse(paramCharSequence.toString());
      this.a.setError(null);
      long l = paramCharSequence.getTime();
      if ((this.c.a().a(l)) && (this.c.a(l)))
      {
        a(Long.valueOf(paramCharSequence.getTime()));
        return;
      }
      this.f = a(l);
      a(this.a, this.f);
      return;
    }
    catch (ParseException paramCharSequence)
    {
      label137:
      break label137;
    }
    a(this.a, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.DateFormatTextWatcher
 * JD-Core Version:    0.7.0.1
 */