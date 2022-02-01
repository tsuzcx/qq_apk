package com.google.android.material.datepicker;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MaterialCalendar$9
  implements View.OnClickListener
{
  MaterialCalendar$9(MaterialCalendar paramMaterialCalendar, MonthsPagerAdapter paramMonthsPagerAdapter) {}
  
  public void onClick(View paramView)
  {
    int i = this.b.f().findLastVisibleItemPosition() - 1;
    if (i >= 0) {
      this.b.a(this.a.b(i));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialCalendar.9
 * JD-Core Version:    0.7.0.1
 */