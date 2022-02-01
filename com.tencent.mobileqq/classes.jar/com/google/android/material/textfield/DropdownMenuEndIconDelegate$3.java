package com.google.android.material.textfield;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

class DropdownMenuEndIconDelegate$3
  extends TextInputLayout.AccessibilityDelegate
{
  DropdownMenuEndIconDelegate$3(DropdownMenuEndIconDelegate paramDropdownMenuEndIconDelegate, TextInputLayout paramTextInputLayout)
  {
    super(paramTextInputLayout);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, @NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if (!DropdownMenuEndIconDelegate.a(this.a.a.a())) {
      paramAccessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
    }
    if (paramAccessibilityNodeInfoCompat.isShowingHintText()) {
      paramAccessibilityNodeInfoCompat.setHintText(null);
    }
  }
  
  public void onPopulateAccessibilityEvent(View paramView, @NonNull AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramView = DropdownMenuEndIconDelegate.a(this.a.a.a());
    if ((paramAccessibilityEvent.getEventType() == 1) && (DropdownMenuEndIconDelegate.a(this.a).isTouchExplorationEnabled()) && (!DropdownMenuEndIconDelegate.a(this.a.a.a()))) {
      DropdownMenuEndIconDelegate.a(this.a, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.DropdownMenuEndIconDelegate.3
 * JD-Core Version:    0.7.0.1
 */