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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

class MonthAdapter
  extends BaseAdapter
{
  static final int a = UtcDates.c().getMaximum(4);
  final Month b;
  final DateSelector<?> c;
  CalendarStyle d;
  final CalendarConstraints e;
  private Collection<Long> f;
  
  MonthAdapter(Month paramMonth, DateSelector<?> paramDateSelector, CalendarConstraints paramCalendarConstraints)
  {
    this.b = paramMonth;
    this.c = paramDateSelector;
    this.e = paramCalendarConstraints;
    this.f = paramDateSelector.c();
  }
  
  private void a(Context paramContext)
  {
    if (this.d == null) {
      this.d = new CalendarStyle(paramContext);
    }
  }
  
  private void a(@Nullable TextView paramTextView, long paramLong)
  {
    if (paramTextView == null) {
      return;
    }
    CalendarItemStyle localCalendarItemStyle;
    if (this.e.a().a(paramLong))
    {
      paramTextView.setEnabled(true);
      if (a(paramLong)) {
        localCalendarItemStyle = this.d.b;
      } else if (UtcDates.b().getTimeInMillis() == paramLong) {
        localCalendarItemStyle = this.d.c;
      } else {
        localCalendarItemStyle = this.d.a;
      }
    }
    else
    {
      paramTextView.setEnabled(false);
      localCalendarItemStyle = this.d.g;
    }
    localCalendarItemStyle.a(paramTextView);
  }
  
  private void a(MaterialCalendarGridView paramMaterialCalendarGridView, long paramLong)
  {
    if (Month.a(paramLong).equals(this.b))
    {
      int i = this.b.b(paramLong);
      a((TextView)paramMaterialCalendarGridView.getChildAt(paramMaterialCalendarGridView.a().c(i) - paramMaterialCalendarGridView.getFirstVisiblePosition()), paramLong);
    }
  }
  
  private boolean a(long paramLong)
  {
    Iterator localIterator = this.c.c().iterator();
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
    return this.b.b();
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
    if ((i >= 0) && (i < this.b.d))
    {
      i += 1;
      localTextView.setTag(this.b);
      localTextView.setText(String.format(localTextView.getResources().getConfiguration().locale, "%d", new Object[] { Integer.valueOf(i) }));
      long l = this.b.a(i);
      if (this.b.b == Month.a().b) {
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
    Long localLong = a(paramInt);
    if (localLong != null) {
      a(localTextView, localLong.longValue());
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localTextView;
  }
  
  @Nullable
  public Long a(int paramInt)
  {
    if ((paramInt >= this.b.b()) && (paramInt <= b())) {
      return Long.valueOf(this.b.a(b(paramInt)));
    }
    return null;
  }
  
  public void a(MaterialCalendarGridView paramMaterialCalendarGridView)
  {
    Object localObject = this.f.iterator();
    while (((Iterator)localObject).hasNext()) {
      a(paramMaterialCalendarGridView, ((Long)((Iterator)localObject).next()).longValue());
    }
    localObject = this.c;
    if (localObject != null)
    {
      localObject = ((DateSelector)localObject).c().iterator();
      while (((Iterator)localObject).hasNext()) {
        a(paramMaterialCalendarGridView, ((Long)((Iterator)localObject).next()).longValue());
      }
      this.f = this.c.c();
    }
  }
  
  int b()
  {
    return this.b.b() + this.b.d - 1;
  }
  
  int b(int paramInt)
  {
    return paramInt - this.b.b() + 1;
  }
  
  int c(int paramInt)
  {
    return a() + (paramInt - 1);
  }
  
  boolean d(int paramInt)
  {
    return (paramInt >= a()) && (paramInt <= b());
  }
  
  boolean e(int paramInt)
  {
    return paramInt % this.b.c == 0;
  }
  
  boolean f(int paramInt)
  {
    return (paramInt + 1) % this.b.c == 0;
  }
  
  public int getCount()
  {
    return this.b.d + a();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt / this.b.c;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.MonthAdapter
 * JD-Core Version:    0.7.0.1
 */