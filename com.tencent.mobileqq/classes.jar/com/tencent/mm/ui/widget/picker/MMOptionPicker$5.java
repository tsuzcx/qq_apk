package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MMOptionPicker$5
  implements View.OnClickListener
{
  MMOptionPicker$5(MMOptionPicker paramMMOptionPicker) {}
  
  public void onClick(View paramView)
  {
    MMOptionPicker localMMOptionPicker = this.a;
    Object localObject = MMOptionPicker.e(localMMOptionPicker);
    String str2 = null;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = MMOptionPicker.e(this.a).currentValue();
    }
    String str1;
    if (MMOptionPicker.a(this.a) == null) {
      str1 = null;
    } else {
      str1 = MMOptionPicker.a(this.a).currentValue();
    }
    MMOptionPicker.a(localMMOptionPicker, true, localObject, str1);
    localMMOptionPicker = this.a;
    if (MMOptionPicker.e(localMMOptionPicker) == null) {
      localObject = null;
    } else {
      localObject = MMOptionPicker.e(this.a).currentValue();
    }
    if (MMOptionPicker.a(this.a) == null) {
      str1 = null;
    } else {
      str1 = MMOptionPicker.a(this.a).currentValue();
    }
    if (MMOptionPicker.c(this.a) != null) {
      str2 = MMOptionPicker.c(this.a).currentValue();
    }
    MMOptionPicker.a(localMMOptionPicker, true, localObject, str1, str2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.MMOptionPicker.5
 * JD-Core Version:    0.7.0.1
 */