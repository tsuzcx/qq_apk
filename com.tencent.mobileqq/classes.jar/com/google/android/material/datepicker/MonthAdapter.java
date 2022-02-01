package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R.layout;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

class MonthAdapter
  extends BaseAdapter
{
  static final int jdField_a_of_type_Int = UtcDates.b().getMaximum(4);
  final CalendarConstraints jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints;
  CalendarStyle jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarStyle;
  final DateSelector<?> jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector;
  final Month jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth;
  private Collection<Long> jdField_a_of_type_JavaUtilCollection;
  
  MonthAdapter(Month paramMonth, DateSelector<?> paramDateSelector, CalendarConstraints paramCalendarConstraints)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth = paramMonth;
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector = paramDateSelector;
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints = paramCalendarConstraints;
    this.jdField_a_of_type_JavaUtilCollection = paramDateSelector.a();
  }
  
  private void a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarStyle == null) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarStyle = new CalendarStyle(paramContext);
    }
  }
  
  private void a(@Nullable TextView paramTextView, long paramLong)
  {
    if (paramTextView == null) {
      return;
    }
    CalendarItemStyle localCalendarItemStyle;
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints.a().a(paramLong))
    {
      paramTextView.setEnabled(true);
      if (a(paramLong)) {
        localCalendarItemStyle = this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarStyle.b;
      } else if (UtcDates.a().getTimeInMillis() == paramLong) {
        localCalendarItemStyle = this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarStyle.c;
      } else {
        localCalendarItemStyle = this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarStyle.a;
      }
    }
    else
    {
      paramTextView.setEnabled(false);
      localCalendarItemStyle = this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarStyle.g;
    }
    localCalendarItemStyle.a(paramTextView);
  }
  
  private void a(MaterialCalendarGridView paramMaterialCalendarGridView, long paramLong)
  {
    if (Month.a(paramLong).equals(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth))
    {
      int i = this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth.a(paramLong);
      a((TextView)paramMaterialCalendarGridView.getChildAt(paramMaterialCalendarGridView.a().b(i) - paramMaterialCalendarGridView.getFirstVisiblePosition()), paramLong);
    }
  }
  
  private boolean a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector.a().iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      if (UtcDates.a(paramLong) == UtcDates.a(l)) {
        return true;
      }
    }
    return false;
  }
  
  int a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth.a();
  }
  
  int a(int paramInt)
  {
    return paramInt - this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth.a() + 1;
  }
  
  @NonNull
  public TextView a(int paramInt, @Nullable View paramView, @NonNull ViewGroup paramViewGroup)
  {
    a(paramViewGroup.getContext());
    TextView localTextView = (TextView)paramView;
    if (paramView == null) {
      localTextView = (TextView)LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.t, paramViewGroup, false);
    }
    int i = paramInt - a();
    if ((i >= 0) && (i < this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth.d))
    {
      i += 1;
      localTextView.setTag(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth);
      localTextView.setText(String.format(localTextView.getResources().getConfiguration().locale, "%d", new Object[] { Integer.valueOf(i) }));
      long l = this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth.a(i);
      if (this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth.b == Month.a().b) {
        localTextView.setContentDescription(DateStrings.c(l));
      } else {
        localTextView.setContentDescription(DateStrings.d(l));
      }
      localTextView.setVisibility(0);
      localTextView.setEnabled(true);
    }
    else
    {
      localTextView.setVisibility(8);
      localTextView.setEnabled(false);
    }
    paramView = a(paramInt);
    if (paramView == null) {
      return localTextView;
    }
    a(localTextView, paramView.longValue());
    return localTextView;
  }
  
  @Nullable
  public Long a(int paramInt)
  {
    if ((paramInt >= this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth.a()) && (paramInt <= b())) {
      return Long.valueOf(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth.a(a(paramInt)));
    }
    return null;
  }
  
  public void a(MaterialCalendarGridView paramMaterialCalendarGridView)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilCollection.iterator();
    while (((Iterator)localObject).hasNext()) {
      a(paramMaterialCalendarGridView, ((Long)((Iterator)localObject).next()).longValue());
    }
    localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector;
    if (localObject != null)
    {
      localObject = ((DateSelector)localObject).a().iterator();
      while (((Iterator)localObject).hasNext()) {
        a(paramMaterialCalendarGridView, ((Long)((Iterator)localObject).next()).longValue());
      }
      this.jdField_a_of_type_JavaUtilCollection = this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector.a();
    }
  }
  
  boolean a(int paramInt)
  {
    return (paramInt >= a()) && (paramInt <= b());
  }
  
  int b()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth.a() + this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth.d - 1;
  }
  
  int b(int paramInt)
  {
    return a() + (paramInt - 1);
  }
  
  boolean b(int paramInt)
  {
    return paramInt % this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth.c == 0;
  }
  
  boolean c(int paramInt)
  {
    return (paramInt + 1) % this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth.c == 0;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth.d + a();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt / this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth.c;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.MonthAdapter
 * JD-Core Version:    0.7.0.1
 */