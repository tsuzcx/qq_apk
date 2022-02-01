package com.google.android.material.datepicker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.LinkedHashSet;

class MaterialDatePicker$1
  implements View.OnClickListener
{
  MaterialDatePicker$1(MaterialDatePicker paramMaterialDatePicker) {}
  
  public void onClick(View paramView)
  {
    Iterator localIterator = MaterialDatePicker.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((MaterialPickerOnPositiveButtonClickListener)localIterator.next()).a(this.a.b());
    }
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialDatePicker.1
 * JD-Core Version:    0.7.0.1
 */