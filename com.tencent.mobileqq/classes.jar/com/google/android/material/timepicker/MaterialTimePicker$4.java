package com.google.android.material.timepicker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MaterialTimePicker$4
  implements View.OnClickListener
{
  MaterialTimePicker$4(MaterialTimePicker paramMaterialTimePicker) {}
  
  public void onClick(View paramView)
  {
    MaterialTimePicker localMaterialTimePicker = this.a;
    int i;
    if (MaterialTimePicker.e(localMaterialTimePicker) == 0) {
      i = 1;
    } else {
      i = 0;
    }
    MaterialTimePicker.a(localMaterialTimePicker, i);
    localMaterialTimePicker = this.a;
    MaterialTimePicker.a(localMaterialTimePicker, MaterialTimePicker.a(localMaterialTimePicker));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.timepicker.MaterialTimePicker.4
 * JD-Core Version:    0.7.0.1
 */