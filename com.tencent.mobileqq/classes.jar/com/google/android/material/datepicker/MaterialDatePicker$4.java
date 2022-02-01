package com.google.android.material.datepicker;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.google.android.material.internal.CheckableImageButton;

class MaterialDatePicker$4
  implements View.OnClickListener
{
  MaterialDatePicker$4(MaterialDatePicker paramMaterialDatePicker) {}
  
  public void onClick(View paramView)
  {
    MaterialDatePicker.a(this.a).setEnabled(MaterialDatePicker.a(this.a).a());
    MaterialDatePicker.a(this.a).toggle();
    paramView = this.a;
    MaterialDatePicker.a(paramView, MaterialDatePicker.a(paramView));
    MaterialDatePicker.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialDatePicker.4
 * JD-Core Version:    0.7.0.1
 */