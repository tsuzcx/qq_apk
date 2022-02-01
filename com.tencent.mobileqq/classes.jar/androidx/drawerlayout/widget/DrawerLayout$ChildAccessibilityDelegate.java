package androidx.drawerlayout.widget;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

final class DrawerLayout$ChildAccessibilityDelegate
  extends AccessibilityDelegateCompat
{
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if (!DrawerLayout.includeChildForAccessibility(paramView)) {
      paramAccessibilityNodeInfoCompat.setParent(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.drawerlayout.widget.DrawerLayout.ChildAccessibilityDelegate
 * JD-Core Version:    0.7.0.1
 */