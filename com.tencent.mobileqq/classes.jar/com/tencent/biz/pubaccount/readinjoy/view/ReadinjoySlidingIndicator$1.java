package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class ReadinjoySlidingIndicator$1
  extends View.AccessibilityDelegate
{
  ReadinjoySlidingIndicator$1(ReadinjoySlidingIndicator paramReadinjoySlidingIndicator) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 4096) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoySlidingIndicator.1
 * JD-Core Version:    0.7.0.1
 */