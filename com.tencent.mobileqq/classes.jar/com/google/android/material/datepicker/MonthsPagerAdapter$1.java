package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MonthsPagerAdapter$1
  implements AdapterView.OnItemClickListener
{
  MonthsPagerAdapter$1(MonthsPagerAdapter paramMonthsPagerAdapter, MaterialCalendarGridView paramMaterialCalendarGridView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.a().d(paramInt)) {
      MonthsPagerAdapter.a(this.b).a(this.a.a().a(paramInt).longValue());
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.MonthsPagerAdapter.1
 * JD-Core Version:    0.7.0.1
 */