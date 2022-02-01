package com.google.android.material.snackbar;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

class BaseTransientBottomBar$5
  extends AccessibilityDelegateCompat
{
  public void onInitializeAccessibilityNodeInfo(View paramView, @NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.addAction(1048576);
    paramAccessibilityNodeInfoCompat.setDismissable(true);
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if (paramInt == 1048576)
    {
      this.a.a();
      return true;
    }
    return super.performAccessibilityAction(paramView, paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.5
 * JD-Core Version:    0.7.0.1
 */