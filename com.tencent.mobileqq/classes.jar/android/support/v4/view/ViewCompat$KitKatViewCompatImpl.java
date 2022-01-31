package android.support.v4.view;

import android.view.View;

class ViewCompat$KitKatViewCompatImpl
  extends ViewCompat.JbMr2ViewCompatImpl
{
  public int getAccessibilityLiveRegion(View paramView)
  {
    return ViewCompatKitKat.getAccessibilityLiveRegion(paramView);
  }
  
  public boolean isAttachedToWindow(View paramView)
  {
    return ViewCompatKitKat.isAttachedToWindow(paramView);
  }
  
  public boolean isLaidOut(View paramView)
  {
    return ViewCompatKitKat.isLaidOut(paramView);
  }
  
  public void setAccessibilityLiveRegion(View paramView, int paramInt)
  {
    ViewCompatKitKat.setAccessibilityLiveRegion(paramView, paramInt);
  }
  
  public void setImportantForAccessibility(View paramView, int paramInt)
  {
    ViewCompatJB.setImportantForAccessibility(paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.KitKatViewCompatImpl
 * JD-Core Version:    0.7.0.1
 */