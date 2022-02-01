package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MMTimePicker$2
  implements View.OnClickListener
{
  MMTimePicker$2(MMTimePicker paramMMTimePicker) {}
  
  public void onClick(View paramView)
  {
    MMTimePicker.a(this.a, false, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.MMTimePicker.2
 * JD-Core Version:    0.7.0.1
 */