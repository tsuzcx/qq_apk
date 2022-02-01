package com.google.android.material.datepicker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.LinkedHashSet;

class MaterialDatePicker$2
  implements View.OnClickListener
{
  MaterialDatePicker$2(MaterialDatePicker paramMaterialDatePicker) {}
  
  public void onClick(View paramView)
  {
    Iterator localIterator = MaterialDatePicker.b(this.a).iterator();
    while (localIterator.hasNext()) {
      ((View.OnClickListener)localIterator.next()).onClick(paramView);
    }
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialDatePicker.2
 * JD-Core Version:    0.7.0.1
 */