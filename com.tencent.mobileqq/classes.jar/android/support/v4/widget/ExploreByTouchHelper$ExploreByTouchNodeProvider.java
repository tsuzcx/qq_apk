package android.support.v4.widget;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;

class ExploreByTouchHelper$ExploreByTouchNodeProvider
  extends AccessibilityNodeProviderCompat
{
  private ExploreByTouchHelper$ExploreByTouchNodeProvider(ExploreByTouchHelper paramExploreByTouchHelper) {}
  
  public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int paramInt)
  {
    return ExploreByTouchHelper.access$100(this.this$0, paramInt);
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return ExploreByTouchHelper.access$200(this.this$0, paramInt1, paramInt2, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom1.jar
 * Qualified Name:     android.support.v4.widget.ExploreByTouchHelper.ExploreByTouchNodeProvider
 * JD-Core Version:    0.7.0.1
 */