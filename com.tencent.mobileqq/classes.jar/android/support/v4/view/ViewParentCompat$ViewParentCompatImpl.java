package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

abstract interface ViewParentCompat$ViewParentCompatImpl
{
  public abstract void notifySubtreeAccessibilityStateChanged(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt);
  
  public abstract boolean onNestedFling(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public abstract boolean onNestedPreFling(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2);
  
  public abstract void onNestedPreScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt);
  
  public abstract void onNestedScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void onNestedScrollAccepted(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt);
  
  public abstract boolean onStartNestedScroll(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt);
  
  public abstract void onStopNestedScroll(ViewParent paramViewParent, View paramView);
  
  public abstract boolean requestSendAccessibilityEvent(ViewParent paramViewParent, View paramView, AccessibilityEvent paramAccessibilityEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.ViewParentCompat.ViewParentCompatImpl
 * JD-Core Version:    0.7.0.1
 */