package com.tencent.biz.qqcircle.richframework.util;

import android.view.View;
import android.view.View.AccessibilityDelegate;

final class AccessibilityUtil$6
  extends View.AccessibilityDelegate
{
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    super.sendAccessibilityEvent(paramView, paramInt);
    if (paramInt == 1)
    {
      AccessibilityUtil.ViewOnClickListener localViewOnClickListener = this.a;
      if (localViewOnClickListener != null) {
        localViewOnClickListener.onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.util.AccessibilityUtil.6
 * JD-Core Version:    0.7.0.1
 */