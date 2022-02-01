package com.google.android.material.datepicker;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R.string;

class MaterialCalendar$5
  extends AccessibilityDelegateCompat
{
  MaterialCalendar$5(MaterialCalendar paramMaterialCalendar) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, @NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if (MaterialCalendar.f(this.a).getVisibility() == 0) {
      paramView = this.a.getString(R.string.Q);
    } else {
      paramView = this.a.getString(R.string.O);
    }
    paramAccessibilityNodeInfoCompat.setHintText(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.MaterialCalendar.5
 * JD-Core Version:    0.7.0.1
 */