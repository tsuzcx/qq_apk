package com.google.android.material.button;

import java.util.Comparator;

class MaterialButtonToggleGroup$1
  implements Comparator<MaterialButton>
{
  MaterialButtonToggleGroup$1(MaterialButtonToggleGroup paramMaterialButtonToggleGroup) {}
  
  public int a(MaterialButton paramMaterialButton1, MaterialButton paramMaterialButton2)
  {
    int i = Boolean.valueOf(paramMaterialButton1.isChecked()).compareTo(Boolean.valueOf(paramMaterialButton2.isChecked()));
    if (i != 0) {
      return i;
    }
    i = Boolean.valueOf(paramMaterialButton1.isPressed()).compareTo(Boolean.valueOf(paramMaterialButton2.isPressed()));
    if (i != 0) {
      return i;
    }
    return Integer.valueOf(this.a.indexOfChild(paramMaterialButton1)).compareTo(Integer.valueOf(this.a.indexOfChild(paramMaterialButton2)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.button.MaterialButtonToggleGroup.1
 * JD-Core Version:    0.7.0.1
 */