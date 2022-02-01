package com.google.android.material.chip;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;
import androidx.core.view.ViewCompat;

class ChipGroup$PassThroughHierarchyChangeListener
  implements ViewGroup.OnHierarchyChangeListener
{
  private ViewGroup.OnHierarchyChangeListener jdField_a_of_type_AndroidViewViewGroup$OnHierarchyChangeListener;
  
  private ChipGroup$PassThroughHierarchyChangeListener(ChipGroup paramChipGroup) {}
  
  public void onChildViewAdded(View paramView1, View paramView2)
  {
    if ((paramView1 == this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipGroup) && ((paramView2 instanceof Chip)))
    {
      if (paramView2.getId() == -1) {
        paramView2.setId(ViewCompat.generateViewId());
      }
      localObject = (Chip)paramView2;
      if (((Chip)localObject).isChecked()) {
        ((ChipGroup)paramView1).a(((Chip)localObject).getId());
      }
      ((Chip)localObject).a(ChipGroup.a(this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipGroup));
    }
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup$OnHierarchyChangeListener;
    if (localObject != null) {
      ((ViewGroup.OnHierarchyChangeListener)localObject).onChildViewAdded(paramView1, paramView2);
    }
  }
  
  public void onChildViewRemoved(View paramView1, View paramView2)
  {
    if ((paramView1 == this.jdField_a_of_type_ComGoogleAndroidMaterialChipChipGroup) && ((paramView2 instanceof Chip))) {
      ((Chip)paramView2).a(null);
    }
    ViewGroup.OnHierarchyChangeListener localOnHierarchyChangeListener = this.jdField_a_of_type_AndroidViewViewGroup$OnHierarchyChangeListener;
    if (localOnHierarchyChangeListener != null) {
      localOnHierarchyChangeListener.onChildViewRemoved(paramView1, paramView2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.chip.ChipGroup.PassThroughHierarchyChangeListener
 * JD-Core Version:    0.7.0.1
 */