package com.tencent.av.widget.shimmer;

import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;

class ShimmerTextView$MyAccessibilityDelegate
  extends AccessibilityDelegateCompat
{
  ShimmerTextView$MyAccessibilityDelegate(ShimmerTextView paramShimmerTextView) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setVisibleToUser(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.widget.shimmer.ShimmerTextView.MyAccessibilityDelegate
 * JD-Core Version:    0.7.0.1
 */