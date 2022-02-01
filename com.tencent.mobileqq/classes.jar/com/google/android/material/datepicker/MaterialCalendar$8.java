package com.google.android.material.datepicker;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MaterialCalendar$8
  implements View.OnClickListener
{
  MaterialCalendar$8(MaterialCalendar paramMaterialCalendar, MonthsPagerAdapter paramMonthsPagerAdapter) {}
  
  public void onClick(View paramView)
  {
    int i = this.b.f().findFirstVisibleItemPosition() + 1;
    if (i < MaterialCalendar.a(this.b).getAdapter().getItemCount()) {
      this.b.a(this.a.b(i));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialCalendar.8
 * JD-Core Version:    0.7.0.1
 */