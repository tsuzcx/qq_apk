package com.google.android.material.button;

import androidx.annotation.NonNull;

class MaterialButtonToggleGroup$CheckedStateTracker
  implements MaterialButton.OnCheckedChangeListener
{
  private MaterialButtonToggleGroup$CheckedStateTracker(MaterialButtonToggleGroup paramMaterialButtonToggleGroup) {}
  
  public void a(@NonNull MaterialButton paramMaterialButton, boolean paramBoolean)
  {
    if (MaterialButtonToggleGroup.a(this.a)) {
      return;
    }
    if (MaterialButtonToggleGroup.b(this.a))
    {
      MaterialButtonToggleGroup localMaterialButtonToggleGroup = this.a;
      int i;
      if (paramBoolean) {
        i = paramMaterialButton.getId();
      } else {
        i = -1;
      }
      MaterialButtonToggleGroup.a(localMaterialButtonToggleGroup, i);
    }
    if (MaterialButtonToggleGroup.a(this.a, paramMaterialButton.getId(), paramBoolean)) {
      MaterialButtonToggleGroup.a(this.a, paramMaterialButton.getId(), paramMaterialButton.isChecked());
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.button.MaterialButtonToggleGroup.CheckedStateTracker
 * JD-Core Version:    0.7.0.1
 */