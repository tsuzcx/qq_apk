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
import java.util.Calendar;
import java.util.Locale;

class DaysOfWeekAdapter
  extends BaseAdapter
{
  private static final int c;
  private final int jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilCalendar.getMaximum(7);
  @NonNull
  private final Calendar jdField_a_of_type_JavaUtilCalendar = UtcDates.b();
  private final int b = this.jdField_a_of_type_JavaUtilCalendar.getFirstDayOfWeek();
  
  static
  {
    int i;
    if (Build.VERSION.SDK_INT >= 26) {
      i = 4;
    } else {
      i = 1;
    }
    c = i;
  }
  
  private int a(int paramInt)
  {
    int i = paramInt + this.b;
    int j = this.jdField_a_of_type_Int;
    paramInt = i;
    if (i > j) {
      paramInt = i - j;
    }
    return paramInt;
  }
  
  @Nullable
  public Integer a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_Int) {
      return null;
    }
    return Integer.valueOf(a(paramInt));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Int;
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
    this.jdField_a_of_type_JavaUtilCalendar.set(7, a(paramInt));
    paramView = localTextView.getResources().getConfiguration().locale;
    localTextView.setText(this.jdField_a_of_type_JavaUtilCalendar.getDisplayName(7, c, paramView));
    localTextView.setContentDescription(String.format(paramViewGroup.getContext().getString(R.string.z), new Object[] { this.jdField_a_of_type_JavaUtilCalendar.getDisplayName(7, 2, Locale.getDefault()) }));
    return localTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.DaysOfWeekAdapter
 * JD-Core Version:    0.7.0.1
 */