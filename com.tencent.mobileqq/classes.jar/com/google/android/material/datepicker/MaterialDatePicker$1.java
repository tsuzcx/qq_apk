package com.google.android.material.datepicker;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.Iterator;
import java.util.LinkedHashSet;

class MaterialDatePicker$1
  implements View.OnClickListener
{
  MaterialDatePicker$1(MaterialDatePicker paramMaterialDatePicker) {}
  
  public void onClick(View paramView)
  {
    paramView = MaterialDatePicker.a(this.a).iterator();
    while (paramView.hasNext()) {
      ((MaterialPickerOnPositiveButtonClickListener)paramView.next()).a(this.a.a());
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialDatePicker.1
 * JD-Core Version:    0.7.0.1
 */