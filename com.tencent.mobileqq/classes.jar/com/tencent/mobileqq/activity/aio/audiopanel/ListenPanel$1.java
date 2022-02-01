package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;

class ListenPanel$1
  extends AccessibilityDelegateCompat
{
  ListenPanel$1(ListenPanel paramListenPanel) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if (ListenPanel.a(this.a) < 1000.0D) {}
    for (int i = 0;; i = (int)(ListenPanel.a(this.a) / 1000.0D + 0.5D))
    {
      paramAccessibilityNodeInfoCompat.setContentDescription(i + this.a.getContext().getString(2131691193));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenPanel.1
 * JD-Core Version:    0.7.0.1
 */