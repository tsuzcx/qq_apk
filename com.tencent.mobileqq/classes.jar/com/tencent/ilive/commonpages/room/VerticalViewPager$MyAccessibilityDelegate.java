package com.tencent.ilive.commonpages.room;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

class VerticalViewPager$MyAccessibilityDelegate
  extends AccessibilityDelegateCompat
{
  VerticalViewPager$MyAccessibilityDelegate(VerticalViewPager paramVerticalViewPager) {}
  
  private boolean canScroll()
  {
    return (VerticalViewPager.access$200(this.this$0) != null) && (VerticalViewPager.access$200(this.this$0).getCount() > 1);
  }
  
  @SuppressLint({"WrongConstant"})
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(ViewPager.class.getName());
    paramView = AccessibilityRecordCompat.obtain();
    paramView.setScrollable(canScroll());
    if ((paramAccessibilityEvent.getEventType() == 4096) && (VerticalViewPager.access$200(this.this$0) != null))
    {
      paramView.setItemCount(VerticalViewPager.access$200(this.this$0).getCount());
      paramView.setFromIndex(VerticalViewPager.access$300(this.this$0));
      paramView.setToIndex(VerticalViewPager.access$300(this.this$0));
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
    paramAccessibilityNodeInfoCompat.setScrollable(canScroll());
    if (this.this$0.internalCanScrollVertically(1)) {
      paramAccessibilityNodeInfoCompat.addAction(4096);
    }
    if (this.this$0.internalCanScrollVertically(-1)) {
      paramAccessibilityNodeInfoCompat.addAction(8192);
    }
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
      return true;
    }
    if (paramInt != 4096)
    {
      if (paramInt != 8192) {
        return false;
      }
      if (this.this$0.internalCanScrollVertically(-1))
      {
        paramView = this.this$0;
        paramView.setCurrentItem(VerticalViewPager.access$300(paramView) - 1);
        return true;
      }
      return false;
    }
    if (this.this$0.internalCanScrollVertically(1))
    {
      paramView = this.this$0;
      paramView.setCurrentItem(VerticalViewPager.access$300(paramView) + 1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.commonpages.room.VerticalViewPager.MyAccessibilityDelegate
 * JD-Core Version:    0.7.0.1
 */