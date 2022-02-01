package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import com.google.android.material.internal.TextWatcherAdapter;

class TimePickerTextInputPresenter$2
  extends TextWatcherAdapter
{
  TimePickerTextInputPresenter$2(TimePickerTextInputPresenter paramTimePickerTextInputPresenter) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    try
    {
      if (TextUtils.isEmpty(paramEditable))
      {
        TimePickerTextInputPresenter.a(this.a).a(0);
        return;
      }
      int i = Integer.parseInt(paramEditable.toString());
      TimePickerTextInputPresenter.a(this.a).a(i);
      return;
    }
    catch (NumberFormatException paramEditable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.timepicker.TimePickerTextInputPresenter.2
 * JD-Core Version:    0.7.0.1
 */