package com.google.android.material.timepicker;

import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.material.R.id;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TimePickerTextInputPresenter$3
  implements View.OnClickListener
{
  TimePickerTextInputPresenter$3(TimePickerTextInputPresenter paramTimePickerTextInputPresenter) {}
  
  public void onClick(View paramView)
  {
    this.a.a(((Integer)paramView.getTag(R.id.aa)).intValue());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.timepicker.TimePickerTextInputPresenter.3
 * JD-Core Version:    0.7.0.1
 */