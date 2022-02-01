package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MMOptionPicker$4
  implements View.OnClickListener
{
  MMOptionPicker$4(MMOptionPicker paramMMOptionPicker) {}
  
  public void onClick(View paramView)
  {
    MMOptionPicker.a(this.a, false, null, null);
    MMOptionPicker.a(this.a, false, null, null, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.MMOptionPicker.4
 * JD-Core Version:    0.7.0.1
 */