package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;

class MonthsPagerAdapter
  extends RecyclerView.Adapter<MonthsPagerAdapter.ViewHolder>
{
  private final Context a;
  @NonNull
  private final CalendarConstraints b;
  private final DateSelector<?> c;
  private final MaterialCalendar.OnDayClickListener d;
  private final int e;
  
  MonthsPagerAdapter(@NonNull Context paramContext, DateSelector<?> paramDateSelector, @NonNull CalendarConstraints paramCalendarConstraints, MaterialCalendar.OnDayClickListener paramOnDayClickListener)
  {
    Month localMonth1 = paramCalendarConstraints.b();
    Month localMonth2 = paramCalendarConstraints.c();
    Month localMonth3 = paramCalendarConstraints.d();
    if (localMonth1.a(localMonth3) <= 0)
    {
      if (localMonth3.a(localMonth2) <= 0)
      {
        int j = MonthAdapter.a;
        int k = MaterialCalendar.a(paramContext);
        int i;
        if (MaterialDatePicker.a(paramContext)) {
          i = MaterialCalendar.a(paramContext);
        } else {
          i = 0;
        }
        this.a = paramContext;
        this.e = (j * k + i);
        this.b = paramCalendarConstraints;
        this.c = paramDateSelector;
        this.d = paramOnDayClickListener;
        setHasStableIds(true);
        return;
      }
      throw new IllegalArgumentException("currentPage cannot be after lastPage");
    }
    throw new IllegalArgumentException("firstPage cannot be after currentPage");
  }
  
  int a(@NonNull Month paramMonth)
  {
    return this.b.b().b(paramMonth);
  }
  
  @NonNull
  public MonthsPagerAdapter.ViewHolder a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.w, paramViewGroup, false);
    if (MaterialDatePicker.a(paramViewGroup.getContext()))
    {
      localLinearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.e));
      return new MonthsPagerAdapter.ViewHolder(localLinearLayout, true);
    }
    return new MonthsPagerAdapter.ViewHolder(localLinearLayout, false);
  }
  
  @NonNull
  CharSequence a(int paramInt)
  {
    return b(paramInt).a(this.a);
  }
  
  public void a(@NonNull MonthsPagerAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    Month localMonth = this.b.b().b(paramInt);
    paramViewHolder.a.setText(localMonth.a(paramViewHolder.itemView.getContext()));
    paramViewHolder = (MaterialCalendarGridView)paramViewHolder.b.findViewById(R.id.C);
    if ((paramViewHolder.a() != null) && (localMonth.equals(paramViewHolder.a().b)))
    {
      paramViewHolder.invalidate();
      paramViewHolder.a().a(paramViewHolder);
    }
    else
    {
      MonthAdapter localMonthAdapter = new MonthAdapter(localMonth, this.c, this.b);
      paramViewHolder.setNumColumns(localMonth.c);
      paramViewHolder.setAdapter(localMonthAdapter);
    }
    paramViewHolder.setOnItemClickListener(new MonthsPagerAdapter.1(this, paramViewHolder));
  }
  
  @NonNull
  Month b(int paramInt)
  {
    return this.b.b().b(paramInt);
  }
  
  public int getItemCount()
  {
    return this.b.e();
  }
  
  public long getItemId(int paramInt)
  {
    return this.b.b().b(paramInt).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.MonthsPagerAdapter
 * JD-Core Version:    0.7.0.1
 */