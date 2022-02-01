package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;

@RequiresApi(19)
class AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19
  extends AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi16
{
  AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat paramAccessibilityNodeProviderCompat)
  {
    super(paramAccessibilityNodeProviderCompat);
  }
  
  public AccessibilityNodeInfo findFocus(int paramInt)
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = this.mCompat.findFocus(paramInt);
    if (localAccessibilityNodeInfoCompat == null) {
      return null;
    }
    return localAccessibilityNodeInfoCompat.unwrap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi19
 * JD-Core Version:    0.7.0.1
 */