package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;

class ClickActionDelegate
  extends AccessibilityDelegateCompat
{
  private final AccessibilityNodeInfoCompat.AccessibilityActionCompat a;
  
  public ClickActionDelegate(Context paramContext, int paramInt)
  {
    this.a = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, paramContext.getString(paramInt));
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.addAction(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.timepicker.ClickActionDelegate
 * JD-Core Version:    0.7.0.1
 */