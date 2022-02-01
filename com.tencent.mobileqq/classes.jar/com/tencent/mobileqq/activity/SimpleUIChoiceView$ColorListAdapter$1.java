package com.tencent.mobileqq.activity;

import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;

class SimpleUIChoiceView$ColorListAdapter$1
  extends AccessibilityDelegateCompat
{
  SimpleUIChoiceView$ColorListAdapter$1(SimpleUIChoiceView.ColorListAdapter paramColorListAdapter) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setSelected(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SimpleUIChoiceView.ColorListAdapter.1
 * JD-Core Version:    0.7.0.1
 */