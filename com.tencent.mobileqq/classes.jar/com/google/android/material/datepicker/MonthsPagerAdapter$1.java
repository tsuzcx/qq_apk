package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class MonthsPagerAdapter$1
  implements AdapterView.OnItemClickListener
{
  MonthsPagerAdapter$1(MonthsPagerAdapter paramMonthsPagerAdapter, MaterialCalendarGridView paramMaterialCalendarGridView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendarGridView.a().a(paramInt)) {
      MonthsPagerAdapter.a(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonthsPagerAdapter).a(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendarGridView.a().a(paramInt).longValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.MonthsPagerAdapter.1
 * JD-Core Version:    0.7.0.1
 */