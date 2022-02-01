package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MultiPicker$3
  implements View.OnClickListener
{
  MultiPicker$3(MultiPicker paramMultiPicker) {}
  
  public void onClick(View paramView)
  {
    MultiPicker.a(this.a, false, null);
    this.a.hide();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.MultiPicker.3
 * JD-Core Version:    0.7.0.1
 */