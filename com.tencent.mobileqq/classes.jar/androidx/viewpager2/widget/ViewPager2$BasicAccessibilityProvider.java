package androidx.viewpager2.widget;

import androidx.annotation.NonNull;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;

class ViewPager2$BasicAccessibilityProvider
  extends ViewPager2.AccessibilityProvider
{
  ViewPager2$BasicAccessibilityProvider(ViewPager2 paramViewPager2)
  {
    super(paramViewPager2, null);
  }
  
  public boolean handlesLmPerformAccessibilityAction(int paramInt)
  {
    return ((paramInt == 8192) || (paramInt == 4096)) && (!this.this$0.isUserInputEnabled());
  }
  
  public boolean handlesRvGetAccessibilityClassName()
  {
    return true;
  }
  
  public void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    if (!this.this$0.isUserInputEnabled())
    {
      paramAccessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
      paramAccessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
      paramAccessibilityNodeInfoCompat.setScrollable(false);
    }
  }
  
  public boolean onLmPerformAccessibilityAction(int paramInt)
  {
    if (handlesLmPerformAccessibilityAction(paramInt)) {
      return false;
    }
    throw new IllegalStateException();
  }
  
  public CharSequence onRvGetAccessibilityClassName()
  {
    if (handlesRvGetAccessibilityClassName()) {
      return "androidx.viewpager.widget.ViewPager";
    }
    throw new IllegalStateException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.viewpager2.widget.ViewPager2.BasicAccessibilityProvider
 * JD-Core Version:    0.7.0.1
 */