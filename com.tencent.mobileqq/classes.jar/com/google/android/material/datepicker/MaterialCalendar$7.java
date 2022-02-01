package com.google.android.material.datepicker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MaterialCalendar$7
  implements View.OnClickListener
{
  MaterialCalendar$7(MaterialCalendar paramMaterialCalendar) {}
  
  public void onClick(View paramView)
  {
    this.a.e();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialCalendar.7
 * JD-Core Version:    0.7.0.1
 */