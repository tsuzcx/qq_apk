package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MMDatePicker$3
  implements View.OnClickListener
{
  MMDatePicker$3(MMDatePicker paramMMDatePicker) {}
  
  public void onClick(View paramView)
  {
    MMDatePicker localMMDatePicker = this.a;
    MMDatePicker.a(localMMDatePicker, true, MMDatePicker.a(localMMDatePicker).getYear(), MMDatePicker.a(this.a).getMonth(), MMDatePicker.a(this.a).getDayOfMonth());
    this.a.hide();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.MMDatePicker.3
 * JD-Core Version:    0.7.0.1
 */