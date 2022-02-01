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
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt == -1)
    {
      localObject1 = localObject2;
      if (CustomAccessibilityDelegate.a(this.a) != null)
      {
        localObject1 = AccessibilityNodeInfo.obtain(CustomAccessibilityDelegate.a(this.a));
        CustomAccessibilityDelegate.a(this.a).onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo)localObject1);
        ((AccessibilityNodeInfo)localObject1).setText(CustomAccessibilityDelegate.a(this.a).getContentDescription());
      }
    }
    return localObject1;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    boolean bool = CustomAccessibilityDelegate.a(this.a).performAccessibilityAction(paramInt2, paramBundle);
    if (paramInt2 == 128) {
      CustomAccessibilityDelegate.a(this.a).post(CustomAccessibilityDelegate.a(this.a));
    }
    do
    {
      do
      {
        return bool;
      } while (paramInt2 != 64);
      CustomAccessibilityDelegate.a(this.a).removeCallbacks(CustomAccessibilityDelegate.a(this.a));
    } while (CustomAccessibilityDelegate.a(this.a) == null);
    CustomAccessibilityDelegate.a(this.a).a();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.CustomAccessibilityDelegate.FocusNextAccessibiltyProvider
 * JD-Core Version:    0.7.0.1
 */