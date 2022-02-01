package com.google.android.material.timepicker;

import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import com.google.android.material.R.id;

class ClockFaceView$2
  extends AccessibilityDelegateCompat
{
  ClockFaceView$2(ClockFaceView paramClockFaceView) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, @NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    int i = ((Integer)paramView.getTag(R.id.B)).intValue();
    if (i > 0) {
      paramAccessibilityNodeInfoCompat.setTraversalAfter((View)ClockFaceView.c(this.a).get(i - 1));
    }
    paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, i, 1, false, paramView.isSelected()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.timepicker.ClockFaceView.2
 * JD-Core Version:    0.7.0.1
 */