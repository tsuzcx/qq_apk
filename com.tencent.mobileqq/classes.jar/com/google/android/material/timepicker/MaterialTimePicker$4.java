package com.google.android.material.timepicker;

import android.view.View;
import android.view.View.OnClickListener;

class MaterialTimePicker$4
  implements View.OnClickListener
{
  MaterialTimePicker$4(MaterialTimePicker paramMaterialTimePicker) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    int i;
    if (MaterialTimePicker.a(paramView) == 0) {
      i = 1;
    } else {
      i = 0;
    }
    MaterialTimePicker.a(paramView, i);
    paramView = this.a;
    MaterialTimePicker.a(paramView, MaterialTimePicker.a(paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.timepicker.MaterialTimePicker.4
 * JD-Core Version:    0.7.0.1
 */