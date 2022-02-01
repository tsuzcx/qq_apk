package com.google.android.material.timepicker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.Set;

class MaterialTimePicker$2
  implements View.OnClickListener
{
  MaterialTimePicker$2(MaterialTimePicker paramMaterialTimePicker) {}
  
  public void onClick(View paramView)
  {
    Iterator localIterator = MaterialTimePicker.c(this.a).iterator();
    while (localIterator.hasNext()) {
      ((View.OnClickListener)localIterator.next()).onClick(paramView);
    }
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.timepicker.MaterialTimePicker.2
 * JD-Core Version:    0.7.0.1
 */