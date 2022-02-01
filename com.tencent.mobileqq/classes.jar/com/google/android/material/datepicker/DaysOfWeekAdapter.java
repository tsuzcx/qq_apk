package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R.layout;
import com.google.android.material.R.string;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;
import java.util.Locale;

class DaysOfWeekAdapter
  extends BaseAdapter
{
  private static final int d;
  @NonNull
  private final Calendar a = UtcDates.c();
  private final int b = this.a.getMaximum(7);
  private final int c = this.a.getFirstDayOfWeek();
  
  static
  {
    int i;
    if (Build.VERSION.SDK_INT >= 26) {
      i = 4;
    } else {
      i = 1;
    }
    d = i;
  }
  
  private int b(int paramInt)
  {
    int i = paramInt + this.c;
    int j = this.b;
    paramInt = i;
    if (i > j) {
      paramInt = i - j;
    }
    return paramInt;
  }
  
  @Nullable
  public Integer a(int paramInt)
  {
    if (paramInt >= this.b) {
      return null;
    }
    return Integer.valueOf(b(paramInt));
  }
  
  public int getCount()
  {
    return this.b;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  @SuppressLint({"WrongConstant"})
  @Nullable
  public View getView(int paramInt, @Nullable View paramView, @NonNull ViewGroup paramViewGroup)
  {
    TextView localTextView = (TextView)paramView;
    if (paramView == null) {
      localTextView = (TextView)LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.u, paramViewGroup, false);
    }
    this.a.set(7, b(paramInt));
    Locale localLocale = localTextView.getResources().getConfiguration().locale;
    localTextView.setText(this.a.getDisplayName(7, d, localLocale));
    localTextView.setContentDescription(String.format(paramViewGroup.getContext().getString(R.string.z), new Object[] { this.a.getDisplayName(7, 2, Locale.getDefault()) }));
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.DaysOfWeekAdapter
 * JD-Core Version:    0.7.0.1
 */