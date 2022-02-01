package com.google.android.material.timepicker;

import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.material.R.id;

class TimePickerView$1
  implements View.OnClickListener
{
  TimePickerView$1(TimePickerView paramTimePickerView) {}
  
  public void onClick(View paramView)
  {
    if (TimePickerView.a(this.a) != null) {
      TimePickerView.a(this.a).a(((Integer)paramView.getTag(R.id.aa)).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.timepicker.TimePickerView.1
 * JD-Core Version:    0.7.0.1
 */