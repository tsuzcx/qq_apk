import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;

public class aulu
  extends AccessibilityDelegateCompat
{
  public aulu(MultiAIOBaseViewPager paramMultiAIOBaseViewPager) {}
  
  private boolean a()
  {
    return (this.a.a != null) && (this.a.a.getCount() > 1);
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(MultiAIOBaseViewPager.class.getName());
    paramAccessibilityEvent.setScrollable(a());
    if ((paramAccessibilityEvent.getEventType() == 4096) && (this.a.a != null))
    {
      paramAccessibilityEvent.setItemCount(this.a.a.getCount());
      paramAccessibilityEvent.setFromIndex(this.a.b);
      paramAccessibilityEvent.setToIndex(this.a.b);
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setClassName(MultiAIOBaseViewPager.class.getName());
    paramAccessibilityNodeInfoCompat.setScrollable(a());
    if (this.a.canScrollHorizontally(1)) {
      paramAccessibilityNodeInfoCompat.addAction(4096);
    }
    if (this.a.canScrollHorizontally(-1)) {
      paramAccessibilityNodeInfoCompat.addAction(8192);
    }
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
      return true;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 4096: 
      if (this.a.canScrollHorizontally(1))
      {
        this.a.setCurrentItem(this.a.b + 1);
        return true;
      }
      return false;
    }
    if (this.a.canScrollHorizontally(-1))
    {
      this.a.setCurrentItem(this.a.b - 1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aulu
 * JD-Core Version:    0.7.0.1
 */