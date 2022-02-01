package com.google.android.material.datepicker;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.google.android.material.internal.CheckableImageButton;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MaterialDatePicker$4
  implements View.OnClickListener
{
  MaterialDatePicker$4(MaterialDatePicker paramMaterialDatePicker) {}
  
  public void onClick(View paramView)
  {
    MaterialDatePicker.e(this.a).setEnabled(MaterialDatePicker.d(this.a).b());
    MaterialDatePicker.f(this.a).toggle();
    MaterialDatePicker localMaterialDatePicker = this.a;
    MaterialDatePicker.a(localMaterialDatePicker, MaterialDatePicker.f(localMaterialDatePicker));
    MaterialDatePicker.g(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialDatePicker.4
 * JD-Core Version:    0.7.0.1
 */