package android.support.v4.view;

import android.support.annotation.Nullable;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

class ViewCompat$ICSViewCompatImpl
  extends ViewCompat.HCViewCompatImpl
{
  static boolean accessibilityDelegateCheckFailed = false;
  static Field mAccessibilityDelegateField;
  
  public ViewPropertyAnimatorCompat animate(View paramView)
  {
    if (this.mViewPropertyAnimatorCompatMap == null) {
      this.mViewPropertyAnimatorCompatMap = new WeakHashMap();
    }
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat2 = (ViewPropertyAnimatorCompat)this.mViewPropertyAnimatorCompatMap.get(paramView);
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat1 = localViewPropertyAnimatorCompat2;
    if (localViewPropertyAnimatorCompat2 == null)
    {
      localViewPropertyAnimatorCompat1 = new ViewPropertyAnimatorCompat(paramView);
      this.mViewPropertyAnimatorCompatMap.put(paramView, localViewPropertyAnimatorCompat1);
    }
    return localViewPropertyAnimatorCompat1;
  }
  
  public boolean canScrollHorizontally(View paramView, int paramInt)
  {
    return ViewCompatICS.canScrollHorizontally(paramView, paramInt);
  }
  
  public boolean canScrollVertically(View paramView, int paramInt)
  {
    return ViewCompatICS.canScrollVertically(paramView, paramInt);
  }
  
  public boolean hasAccessibilityDelegate(View paramView)
  {
    boolean bool2 = accessibilityDelegateCheckFailed;
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (mAccessibilityDelegateField == null) {}
    try
    {
      mAccessibilityDelegateField = View.class.getDeclaredField("mAccessibilityDelegate");
      mAccessibilityDelegateField.setAccessible(true);
    }
    catch (Throwable paramView)
    {
      label38:
      label60:
      break label38;
    }
    accessibilityDelegateCheckFailed = true;
    return false;
    try
    {
      paramView = mAccessibilityDelegateField.get(paramView);
      if (paramView != null) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Throwable paramView)
    {
      break label60;
    }
    accessibilityDelegateCheckFailed = true;
    return false;
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    ViewCompatICS.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    ViewCompatICS.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat.getInfo());
  }
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    ViewCompatICS.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void setAccessibilityDelegate(View paramView, @Nullable AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    if (paramAccessibilityDelegateCompat == null) {
      paramAccessibilityDelegateCompat = null;
    } else {
      paramAccessibilityDelegateCompat = paramAccessibilityDelegateCompat.getBridge();
    }
    ViewCompatICS.setAccessibilityDelegate(paramView, paramAccessibilityDelegateCompat);
  }
  
  public void setFitsSystemWindows(View paramView, boolean paramBoolean)
  {
    ViewCompatICS.setFitsSystemWindows(paramView, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.ICSViewCompatImpl
 * JD-Core Version:    0.7.0.1
 */