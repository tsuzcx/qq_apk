package com.google.android.material.bottomsheet;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

class BottomSheetDialog$2
  extends AccessibilityDelegateCompat
{
  BottomSheetDialog$2(BottomSheetDialog paramBottomSheetDialog) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, @NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if (this.a.b)
    {
      paramAccessibilityNodeInfoCompat.addAction(1048576);
      paramAccessibilityNodeInfoCompat.setDismissable(true);
      return;
    }
    paramAccessibilityNodeInfoCompat.setDismissable(false);
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if ((paramInt == 1048576) && (this.a.b))
    {
      this.a.cancel();
      return true;
    }
    return super.performAccessibilityAction(paramView, paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomsheet.BottomSheetDialog.2
 * JD-Core Version:    0.7.0.1
 */