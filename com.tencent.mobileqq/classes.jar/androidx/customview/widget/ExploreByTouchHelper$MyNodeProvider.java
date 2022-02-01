package androidx.customview.widget;

import android.os.Bundle;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;

class ExploreByTouchHelper$MyNodeProvider
  extends AccessibilityNodeProviderCompat
{
  ExploreByTouchHelper$MyNodeProvider(ExploreByTouchHelper paramExploreByTouchHelper) {}
  
  public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int paramInt)
  {
    return AccessibilityNodeInfoCompat.obtain(this.this$0.obtainAccessibilityNodeInfo(paramInt));
  }
  
  public AccessibilityNodeInfoCompat findFocus(int paramInt)
  {
    if (paramInt == 2) {
      paramInt = this.this$0.mAccessibilityFocusedVirtualViewId;
    } else {
      paramInt = this.this$0.mKeyboardFocusedVirtualViewId;
    }
    if (paramInt == -2147483648) {
      return null;
    }
    return createAccessibilityNodeInfo(paramInt);
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return this.this$0.performAction(paramInt1, paramInt2, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.customview.widget.ExploreByTouchHelper.MyNodeProvider
 * JD-Core Version:    0.7.0.1
 */