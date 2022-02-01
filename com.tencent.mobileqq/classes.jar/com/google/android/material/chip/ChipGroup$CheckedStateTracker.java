package com.google.android.material.chip;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import androidx.annotation.NonNull;
import java.util.List;

class ChipGroup$CheckedStateTracker
  implements CompoundButton.OnCheckedChangeListener
{
  private ChipGroup$CheckedStateTracker(ChipGroup paramChipGroup) {}
  
  public void onCheckedChanged(@NonNull CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (ChipGroup.a(this.a)) {
      return;
    }
    if ((this.a.a().isEmpty()) && (ChipGroup.b(this.a)))
    {
      ChipGroup.a(this.a, paramCompoundButton.getId(), true);
      ChipGroup.b(this.a, paramCompoundButton.getId(), false);
      return;
    }
    int i = paramCompoundButton.getId();
    if (paramBoolean)
    {
      if ((ChipGroup.a(this.a) != -1) && (ChipGroup.a(this.a) != i) && (ChipGroup.c(this.a)))
      {
        paramCompoundButton = this.a;
        ChipGroup.a(paramCompoundButton, ChipGroup.a(paramCompoundButton), false);
      }
      ChipGroup.a(this.a, i);
      return;
    }
    if (ChipGroup.a(this.a) == i) {
      ChipGroup.a(this.a, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.chip.ChipGroup.CheckedStateTracker
 * JD-Core Version:    0.7.0.1
 */