package com.google.android.material.timepicker;

import com.google.android.material.R.id;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener;

class TimePickerView$2
  implements MaterialButtonToggleGroup.OnButtonCheckedListener
{
  TimePickerView$2(TimePickerView paramTimePickerView) {}
  
  public void a(MaterialButtonToggleGroup paramMaterialButtonToggleGroup, int paramInt, boolean paramBoolean)
  {
    if (paramInt == R.id.p) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((TimePickerView.b(this.a) != null) && (paramBoolean)) {
      TimePickerView.b(this.a).b(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.timepicker.TimePickerView.2
 * JD-Core Version:    0.7.0.1
 */