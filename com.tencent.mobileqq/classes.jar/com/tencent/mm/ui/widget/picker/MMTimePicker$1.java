package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MMTimePicker$1
  implements View.OnClickListener
{
  MMTimePicker$1(MMTimePicker paramMMTimePicker) {}
  
  public void onClick(View paramView)
  {
    MMTimePicker localMMTimePicker = this.a;
    String str;
    if (MMTimePicker.a(localMMTimePicker) == null) {
      str = null;
    } else {
      str = MMTimePicker.a(this.a).currentValue();
    }
    MMTimePicker.a(localMMTimePicker, true, str);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.MMTimePicker.1
 * JD-Core Version:    0.7.0.1
 */