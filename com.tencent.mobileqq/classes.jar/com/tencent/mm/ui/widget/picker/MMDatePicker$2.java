package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MMDatePicker$2
  implements View.OnClickListener
{
  MMDatePicker$2(MMDatePicker paramMMDatePicker) {}
  
  public void onClick(View paramView)
  {
    MMDatePicker.a(this.a, false, 0, 0, 0);
    this.a.hide();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.MMDatePicker.2
 * JD-Core Version:    0.7.0.1
 */