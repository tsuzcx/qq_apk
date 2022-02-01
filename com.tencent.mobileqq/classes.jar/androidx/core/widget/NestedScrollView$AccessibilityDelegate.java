package androidx.core.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ScrollView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;

class NestedScrollView$AccessibilityDelegate
  extends AccessibilityDelegateCompat
{
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramView = (NestedScrollView)paramView;
    paramAccessibilityEvent.setClassName(ScrollView.class.getName());
    boolean bool;
    if (paramView.getScrollRange() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramAccessibilityEvent.setScrollable(bool);
    paramAccessibilityEvent.setScrollX(paramView.getScrollX());
    paramAccessibilityEvent.setScrollY(paramView.getScrollY());
    AccessibilityRecordCompat.setMaxScrollX(paramAccessibilityEvent, paramView.getScrollX());
    AccessibilityRecordCompat.setMaxScrollY(paramAccessibilityEvent, paramView.getScrollRange());
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramView = (NestedScrollView)paramView;
    paramAccessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
    if (paramView.isEnabled())
    {
      int i = paramView.getScrollRange();
      if (i > 0)
      {
        paramAccessibilityNodeInfoCompat.setScrollable(true);
        if (paramView.getScrollY() > 0)
        {
          paramAccessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
          paramAccessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
        }
        if (paramView.getScrollY() < i)
        {
          paramAccessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
          paramAccessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
        }
      }
    }
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
      return true;
    }
    paramView = (NestedScrollView)paramView;
    if (!paramView.isEnabled()) {
      return false;
    }
    if (paramInt != 4096) {
      if ((paramInt != 8192) && (paramInt != 16908344))
      {
        if (paramInt != 16908346) {
          return false;
        }
      }
      else
      {
        paramInt = paramView.getHeight();
        i = paramView.getPaddingBottom();
        j = paramView.getPaddingTop();
        paramInt = Math.max(paramView.getScrollY() - (paramInt - i - j), 0);
        if (paramInt != paramView.getScrollY())
        {
          paramView.smoothScrollTo(0, paramInt, true);
          return true;
        }
        return false;
      }
    }
    paramInt = paramView.getHeight();
    int i = paramView.getPaddingBottom();
    int j = paramView.getPaddingTop();
    paramInt = Math.min(paramView.getScrollY() + (paramInt - i - j), paramView.getScrollRange());
    if (paramInt != paramView.getScrollY())
    {
      paramView.smoothScrollTo(0, paramInt, true);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.widget.NestedScrollView.AccessibilityDelegate
 * JD-Core Version:    0.7.0.1
 */