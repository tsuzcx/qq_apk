package com.google.android.material.internal;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

class CheckableImageButton$1
  extends AccessibilityDelegateCompat
{
  CheckableImageButton$1(CheckableImageButton paramCheckableImageButton) {}
  
  public void onInitializeAccessibilityEvent(View paramView, @NonNull AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setChecked(this.a.isChecked());
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, @NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setCheckable(this.a.a());
    paramAccessibilityNodeInfoCompat.setChecked(this.a.isChecked());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.CheckableImageButton.1
 * JD-Core Version:    0.7.0.1
 */