package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.view.View;

class AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanImpl
  extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoIcsImpl
{
  public void addChild(Object paramObject, View paramView, int paramInt)
  {
    AccessibilityNodeInfoCompatJellyBean.addChild(paramObject, paramView, paramInt);
  }
  
  public Object findFocus(Object paramObject, int paramInt)
  {
    return AccessibilityNodeInfoCompatJellyBean.findFocus(paramObject, paramInt);
  }
  
  public Object focusSearch(Object paramObject, int paramInt)
  {
    return AccessibilityNodeInfoCompatJellyBean.focusSearch(paramObject, paramInt);
  }
  
  public int getMovementGranularities(Object paramObject)
  {
    return AccessibilityNodeInfoCompatJellyBean.getMovementGranularities(paramObject);
  }
  
  public boolean isAccessibilityFocused(Object paramObject)
  {
    return AccessibilityNodeInfoCompatJellyBean.isAccessibilityFocused(paramObject);
  }
  
  public boolean isVisibleToUser(Object paramObject)
  {
    return AccessibilityNodeInfoCompatJellyBean.isVisibleToUser(paramObject);
  }
  
  public Object obtain(View paramView, int paramInt)
  {
    return AccessibilityNodeInfoCompatJellyBean.obtain(paramView, paramInt);
  }
  
  public boolean performAction(Object paramObject, int paramInt, Bundle paramBundle)
  {
    return AccessibilityNodeInfoCompatJellyBean.performAction(paramObject, paramInt, paramBundle);
  }
  
  public void setAccessibilityFocused(Object paramObject, boolean paramBoolean)
  {
    AccessibilityNodeInfoCompatJellyBean.setAccesibilityFocused(paramObject, paramBoolean);
  }
  
  public void setMovementGranularities(Object paramObject, int paramInt)
  {
    AccessibilityNodeInfoCompatJellyBean.setMovementGranularities(paramObject, paramInt);
  }
  
  public void setParent(Object paramObject, View paramView, int paramInt)
  {
    AccessibilityNodeInfoCompatJellyBean.setParent(paramObject, paramView, paramInt);
  }
  
  public void setSource(Object paramObject, View paramView, int paramInt)
  {
    AccessibilityNodeInfoCompatJellyBean.setSource(paramObject, paramView, paramInt);
  }
  
  public void setVisibleToUser(Object paramObject, boolean paramBoolean)
  {
    AccessibilityNodeInfoCompatJellyBean.setVisibleToUser(paramObject, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanImpl
 * JD-Core Version:    0.7.0.1
 */