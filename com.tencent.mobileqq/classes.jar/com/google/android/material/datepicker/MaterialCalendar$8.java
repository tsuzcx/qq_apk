package com.google.android.material.datepicker;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

class MaterialCalendar$8
  implements View.OnClickListener
{
  MaterialCalendar$8(MaterialCalendar paramMaterialCalendar, MonthsPagerAdapter paramMonthsPagerAdapter) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendar.a().findFirstVisibleItemPosition() + 1;
    if (i < MaterialCalendar.a(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendar).getAdapter().getItemCount()) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMaterialCalendar.a(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonthsPagerAdapter.a(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialCalendar.8
 * JD-Core Version:    0.7.0.1
 */