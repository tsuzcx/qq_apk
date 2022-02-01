package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.google.android.material.R.layout;
import com.google.android.material.R.string;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

class YearGridAdapter
  extends RecyclerView.Adapter<YearGridAdapter.ViewHolder>
{
  private final MaterialCalendar<?> a;
  
  YearGridAdapter(MaterialCalendar<?> paramMaterialCalendar)
  {
    this.a = paramMaterialCalendar;
  }
  
  @NonNull
  private View.OnClickListener a(int paramInt)
  {
    return new YearGridAdapter.1(this, paramInt);
  }
  
  int a(int paramInt)
  {
    return paramInt - this.a.a().a().b;
  }
  
  @NonNull
  public YearGridAdapter.ViewHolder a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new YearGridAdapter.ViewHolder((TextView)LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.y, paramViewGroup, false));
  }
  
  public void a(@NonNull YearGridAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    paramInt = b(paramInt);
    Object localObject = paramViewHolder.a.getContext().getString(R.string.E);
    paramViewHolder.a.setText(String.format(Locale.getDefault(), "%d", new Object[] { Integer.valueOf(paramInt) }));
    paramViewHolder.a.setContentDescription(String.format((String)localObject, new Object[] { Integer.valueOf(paramInt) }));
    CalendarStyle localCalendarStyle = this.a.a();
    Calendar localCalendar = UtcDates.a();
    if (localCalendar.get(1) == paramInt) {
      localObject = localCalendarStyle.f;
    } else {
      localObject = localCalendarStyle.d;
    }
    Iterator localIterator = this.a.a().a().iterator();
    while (localIterator.hasNext())
    {
      localCalendar.setTimeInMillis(((Long)localIterator.next()).longValue());
      if (localCalendar.get(1) == paramInt) {
        localObject = localCalendarStyle.e;
      }
    }
    ((CalendarItemStyle)localObject).a(paramViewHolder.a);
    paramViewHolder.a.setOnClickListener(a(paramInt));
  }
  
  int b(int paramInt)
  {
    return this.a.a().a().b + paramInt;
  }
  
  public int getItemCount()
  {
    return this.a.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.YearGridAdapter
 * JD-Core Version:    0.7.0.1
 */