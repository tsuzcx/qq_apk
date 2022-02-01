package com.tencent.biz.qqcircle.richframework.util;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;

final class AccessibilityUtil$7
  extends View.AccessibilityDelegate
{
  AccessibilityUtil$7(CharSequence paramCharSequence, String paramString) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
    paramView = this.a;
    if (paramView != null) {
      paramAccessibilityNodeInfo.setContentDescription(paramView);
    }
    paramAccessibilityNodeInfo.setClassName(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.util.AccessibilityUtil.7
 * JD-Core Version:    0.7.0.1
 */