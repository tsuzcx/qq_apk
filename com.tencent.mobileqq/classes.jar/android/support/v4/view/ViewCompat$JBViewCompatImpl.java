package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewParent;

class ViewCompat$JBViewCompatImpl
  extends ViewCompat.ICSMr1ViewCompatImpl
{
  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
  {
    paramView = ViewCompatJB.getAccessibilityNodeProvider(paramView);
    if (paramView != null) {
      return new AccessibilityNodeProviderCompat(paramView);
    }
    return null;
  }
  
  public boolean getFitsSystemWindows(View paramView)
  {
    return ViewCompatJB.getFitsSystemWindows(paramView);
  }
  
  public int getImportantForAccessibility(View paramView)
  {
    return ViewCompatJB.getImportantForAccessibility(paramView);
  }
  
  public int getMinimumHeight(View paramView)
  {
    return ViewCompatJB.getMinimumHeight(paramView);
  }
  
  public int getMinimumWidth(View paramView)
  {
    return ViewCompatJB.getMinimumWidth(paramView);
  }
  
  public ViewParent getParentForAccessibility(View paramView)
  {
    return ViewCompatJB.getParentForAccessibility(paramView);
  }
  
  public boolean hasOverlappingRendering(View paramView)
  {
    return ViewCompatJB.hasOverlappingRendering(paramView);
  }
  
  public boolean hasTransientState(View paramView)
  {
    return ViewCompatJB.hasTransientState(paramView);
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    return ViewCompatJB.performAccessibilityAction(paramView, paramInt, paramBundle);
  }
  
  public void postInvalidateOnAnimation(View paramView)
  {
    ViewCompatJB.postInvalidateOnAnimation(paramView);
  }
  
  public void postInvalidateOnAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewCompatJB.postInvalidateOnAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    ViewCompatJB.postOnAnimation(paramView, paramRunnable);
  }
  
  public void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
  {
    ViewCompatJB.postOnAnimationDelayed(paramView, paramRunnable, paramLong);
  }
  
  public void requestApplyInsets(View paramView)
  {
    ViewCompatJB.requestApplyInsets(paramView);
  }
  
  public void setHasTransientState(View paramView, boolean paramBoolean)
  {
    ViewCompatJB.setHasTransientState(paramView, paramBoolean);
  }
  
  public void setImportantForAccessibility(View paramView, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 4) {
      i = 2;
    }
    ViewCompatJB.setImportantForAccessibility(paramView, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.JBViewCompatImpl
 * JD-Core Version:    0.7.0.1
 */