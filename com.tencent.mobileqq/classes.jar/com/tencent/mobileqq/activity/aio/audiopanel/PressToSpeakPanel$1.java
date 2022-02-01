package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.util.AccessibilityUtils;

class PressToSpeakPanel$1
  extends AccessibilityDelegateCompat
{
  PressToSpeakPanel$1(PressToSpeakPanel paramPressToSpeakPanel) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if ((AppSetting.e) && (PressToSpeakPanel.a(this.a) > 0) && (!PressToSpeakPanel.b(this.a)) && (PressToSpeakPanel.c(this.a).getCurrentItem() == 1))
    {
      PressToSpeakPanel.a(this.a, true);
      PressToSpeakPanel.d(this.a);
      paramView = this.a;
      AccessibilityUtils.a(paramView, paramView.getContext().getString(2131888057));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel.1
 * JD-Core Version:    0.7.0.1
 */