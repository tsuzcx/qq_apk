package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.viewpager.widget.PagerAdapter;

class XViewPager$MyAccessibilityDelegate
  extends AccessibilityDelegateCompat
{
  XViewPager$MyAccessibilityDelegate(XViewPager paramXViewPager) {}
  
  private boolean a()
  {
    return (XViewPager.a(this.a) != null) && (XViewPager.a(this.a).getCount() > 1);
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(XViewPager.class.getName());
    paramView = AccessibilityRecordCompat.obtain();
    paramView.setScrollable(a());
    if ((paramAccessibilityEvent.getEventType() == 4096) && (XViewPager.a(this.a) != null))
    {
      paramView.setItemCount(XViewPager.a(this.a).getCount());
      paramView.setFromIndex(XViewPager.a(this.a));
      paramView.setToIndex(XViewPager.a(this.a));
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setClassName(XViewPager.class.getName());
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
    if (paramInt != 4096)
    {
      if (paramInt != 8192) {
        return false;
      }
      if (this.a.canScrollHorizontally(-1))
      {
        paramView = this.a;
        paramView.setCurrentItem(XViewPager.a(paramView) - 1);
        return true;
      }
      return false;
    }
    if (this.a.canScrollHorizontally(1))
    {
      paramView = this.a;
      paramView.setCurrentItem(XViewPager.a(paramView) + 1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager.MyAccessibilityDelegate
 * JD-Core Version:    0.7.0.1
 */