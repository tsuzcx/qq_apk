package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class SimpleSlidingIndicator$1
  extends View.AccessibilityDelegate
{
  SimpleSlidingIndicator$1(SimpleSlidingIndicator paramSimpleSlidingIndicator) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 4096) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.1
 * JD-Core Version:    0.7.0.1
 */