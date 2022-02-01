package com.tencent.biz.qqcircle.richframework.util;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;

final class AccessibilityUtil$2
  extends View.AccessibilityDelegate
{
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    paramAccessibilityNodeInfo.setVisibleToUser(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.util.AccessibilityUtil.2
 * JD-Core Version:    0.7.0.1
 */