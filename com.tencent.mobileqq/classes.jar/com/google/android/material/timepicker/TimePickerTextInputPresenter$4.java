package com.google.android.material.timepicker;

import com.google.android.material.R.id;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener;

class TimePickerTextInputPresenter$4
  implements MaterialButtonToggleGroup.OnButtonCheckedListener
{
  TimePickerTextInputPresenter$4(TimePickerTextInputPresenter paramTimePickerTextInputPresenter) {}
  
  public void a(MaterialButtonToggleGroup paramMaterialButtonToggleGroup, int paramInt, boolean paramBoolean)
  {
    if (paramInt == R.id.p) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    TimePickerTextInputPresenter.a(this.a).c(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.timepicker.TimePickerTextInputPresenter.4
 * JD-Core Version:    0.7.0.1
 */