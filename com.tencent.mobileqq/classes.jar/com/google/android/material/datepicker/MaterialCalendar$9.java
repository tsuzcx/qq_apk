package com.google.android.material.datepicker;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.LinearLayoutManager;

class MaterialCalendar$9
  implements View.OnClickListener
{
  MaterialCalendar$9(MaterialCalendar paramMaterialCalendar, MonthsPagerAdapter paramMonthsPagerAdapter) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendar.a().findLastVisibleItemPosition() - 1;
    if (i >= 0) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendar.a(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonthsPagerAdapter.a(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialCalendar.9
 * JD-Core Version:    0.7.0.1
 */