package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.TextWatcherAdapter;

class ChipTextInputComboView$TextFormatter
  extends TextWatcherAdapter
{
  private ChipTextInputComboView$TextFormatter(ChipTextInputComboView paramChipTextInputComboView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (TextUtils.isEmpty(paramEditable))
    {
      ChipTextInputComboView.a(this.a).setText(ChipTextInputComboView.a(this.a, "00"));
      return;
    }
    ChipTextInputComboView.a(this.a).setText(ChipTextInputComboView.a(this.a, paramEditable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.timepicker.ChipTextInputComboView.TextFormatter
 * JD-Core Version:    0.7.0.1
 */