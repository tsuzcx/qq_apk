package com.google.android.material.chip;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ChipGroup$CheckedStateTracker
  implements CompoundButton.OnCheckedChangeListener
{
  private ChipGroup$CheckedStateTracker(ChipGroup paramChipGroup) {}
  
  public void onCheckedChanged(@NonNull CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!ChipGroup.a(this.a)) {
      if ((this.a.getCheckedChipIds().isEmpty()) && (ChipGroup.b(this.a)))
      {
        ChipGroup.a(this.a, paramCompoundButton.getId(), true);
        ChipGroup.b(this.a, paramCompoundButton.getId(), false);
      }
      else
      {
        int i = paramCompoundButton.getId();
        if (paramBoolean)
        {
          if ((ChipGroup.c(this.a) != -1) && (ChipGroup.c(this.a) != i) && (ChipGroup.d(this.a)))
          {
            ChipGroup localChipGroup = this.a;
            ChipGroup.a(localChipGroup, ChipGroup.c(localChipGroup), false);
          }
          ChipGroup.a(this.a, i);
        }
        else if (ChipGroup.c(this.a) == i)
        {
          ChipGroup.a(this.a, -1);
        }
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.chip.ChipGroup.CheckedStateTracker
 * JD-Core Version:    0.7.0.1
 */