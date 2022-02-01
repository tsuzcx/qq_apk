package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MultiPicker$2
  implements View.OnClickListener
{
  MultiPicker$2(MultiPicker paramMultiPicker) {}
  
  public void onClick(View paramView)
  {
    MultiPicker localMultiPicker = this.a;
    MultiPicker.a(localMultiPicker, true, MultiPicker.a(localMultiPicker).getSelectedItem());
    this.a.hide();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.MultiPicker.2
 * JD-Core Version:    0.7.0.1
 */