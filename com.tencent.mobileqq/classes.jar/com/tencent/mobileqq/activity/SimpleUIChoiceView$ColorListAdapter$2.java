package com.tencent.mobileqq.activity;

import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;

class SimpleUIChoiceView$ColorListAdapter$2
  extends AccessibilityDelegateCompat
{
  SimpleUIChoiceView$ColorListAdapter$2(SimpleUIChoiceView.ColorListAdapter paramColorListAdapter) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SimpleUIChoiceView.ColorListAdapter.2
 * JD-Core Version:    0.7.0.1
 */