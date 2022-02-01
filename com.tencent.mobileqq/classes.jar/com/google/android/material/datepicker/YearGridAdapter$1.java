package com.google.android.material.datepicker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class YearGridAdapter$1
  implements View.OnClickListener
{
  YearGridAdapter$1(YearGridAdapter paramYearGridAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Month localMonth = Month.a(this.a, YearGridAdapter.a(this.b).a().a);
    localMonth = YearGridAdapter.a(this.b).b().a(localMonth);
    YearGridAdapter.a(this.b).a(localMonth);
    YearGridAdapter.a(this.b).a(MaterialCalendar.CalendarSelector.DAY);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.YearGridAdapter.1
 * JD-Core Version:    0.7.0.1
 */