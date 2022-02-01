package com.tencent.biz.qrcode;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

public class CustomAccessibilityDelegate$FocusNextAccessibiltyProvider
  extends AccessibilityNodeProvider
{
  public CustomAccessibilityDelegate$FocusNextAccessibiltyProvider(CustomAccessibilityDelegate paramCustomAccessibilityDelegate) {}
  
  public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
  {
    if ((paramInt == -1) && (CustomAccessibilityDelegate.a(this.a) != null))
    {
      AccessibilityNodeInfo localAccessibilityNodeInfo = AccessibilityNodeInfo.obtain(CustomAccessibilityDelegate.a(this.a));
      CustomAccessibilityDelegate.a(this.a).onInitializeAccessibilityNodeInfo(localAccessibilityNodeInfo);
      localAccessibilityNodeInfo.setText(CustomAccessibilityDelegate.a(this.a).getContentDescription());
      return localAccessibilityNodeInfo;
    }
    return null;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    boolean bool = CustomAccessibilityDelegate.a(this.a).performAccessibilityAction(paramInt2, paramBundle);
    if (paramInt2 == 128)
    {
      CustomAccessibilityDelegate.a(this.a).post(CustomAccessibilityDelegate.b(this.a));
      return bool;
    }
    if (paramInt2 == 64)
    {
      CustomAccessibilityDelegate.a(this.a).removeCallbacks(CustomAccessibilityDelegate.b(this.a));
      if (CustomAccessibilityDelegate.c(this.a) != null) {
        CustomAccessibilityDelegate.c(this.a).a();
      }
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.CustomAccessibilityDelegate.FocusNextAccessibiltyProvider
 * JD-Core Version:    0.7.0.1
 */