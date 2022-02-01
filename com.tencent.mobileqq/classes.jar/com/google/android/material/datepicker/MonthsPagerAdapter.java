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
  private final int jdField_a_of_type_Int;
  private final Context jdField_a_of_type_AndroidContentContext;
  @NonNull
  private final CalendarConstraints jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints;
  private final DateSelector<?> jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector;
  private final MaterialCalendar.OnDayClickListener jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendar$OnDayClickListener;
  
  MonthsPagerAdapter(@NonNull Context paramContext, DateSelector<?> paramDateSelector, @NonNull CalendarConstraints paramCalendarConstraints, MaterialCalendar.OnDayClickListener paramOnDayClickListener)
  {
    Month localMonth1 = paramCalendarConstraints.a();
    Month localMonth2 = paramCalendarConstraints.b();
    Month localMonth3 = paramCalendarConstraints.c();
    if (localMonth1.a(localMonth3) <= 0)
    {
      if (localMonth3.a(localMonth2) <= 0)
      {
        int j = MonthAdapter.jdField_a_of_type_Int;
        int k = MaterialCalendar.a(paramContext);
        int i;
        if (MaterialDatePicker.a(paramContext)) {
          i = MaterialCalendar.a(paramContext);
        } else {
          i = 0;
        }
        this.jdField_a_of_type_AndroidContentContext = paramContext;
        this.jdField_a_of_type_Int = (j * k + i);
        this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints = paramCalendarConstraints;
        this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector = paramDateSelector;
        this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendar$OnDayClickListener = paramOnDayClickListener;
        setHasStableIds(true);
        return;
      }
      throw new IllegalArgumentException("currentPage cannot be after lastPage");
    }
    throw new IllegalArgumentException("firstPage cannot be after currentPage");
  }
  
  int a(@NonNull Month paramMonth)
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints.a().b(paramMonth);
  }
  
  @NonNull
  Month a(int paramInt)
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints.a().a(paramInt);
  }
  
  @NonNull
  public MonthsPagerAdapter.ViewHolder a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.w, paramViewGroup, false);
    if (MaterialDatePicker.a(paramViewGroup.getContext()))
    {
      localLinearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.jdField_a_of_type_Int));
      return new MonthsPagerAdapter.ViewHolder(localLinearLayout, true);
    }
    return new MonthsPagerAdapter.ViewHolder(localLinearLayout, false);
  }
  
  @NonNull
  CharSequence a(int paramInt)
  {
    return a(paramInt).a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(@NonNull MonthsPagerAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    Month localMonth = this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints.a().a(paramInt);
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMonth.a(paramViewHolder.itemView.getContext()));
    paramViewHolder = (MaterialCalendarGridView)paramViewHolder.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendarGridView.findViewById(R.id.C);
    if ((paramViewHolder.a() != null) && (localMonth.equals(paramViewHolder.a().jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth)))
    {
      paramViewHolder.invalidate();
      paramViewHolder.a().a(paramViewHolder);
    }
    else
    {
      MonthAdapter localMonthAdapter = new MonthAdapter(localMonth, this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerDateSelector, this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints);
      paramViewHolder.setNumColumns(localMonth.c);
      paramViewHolder.setAdapter(localMonthAdapter);
    }
    paramViewHolder.setOnItemClickListener(new MonthsPagerAdapter.1(this, paramViewHolder));
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints.a();
  }
  
  public long getItemId(int paramInt)
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints.a().a(paramInt).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.MonthsPagerAdapter
 * JD-Core Version:    0.7.0.1
 */