package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.view.View;
import java.util.List;

class AccessibilityNodeInfoCompat$AccessibilityNodeInfoIcsImpl
  extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl
{
  public void addAction(Object paramObject, int paramInt)
  {
    AccessibilityNodeInfoCompatIcs.addAction(paramObject, paramInt);
  }
  
  public void addAction(Object paramObject, int paramInt, CharSequence paramCharSequence)
  {
    if (Integer.bitCount(paramInt) == 1) {
      addAction(paramObject, paramInt);
    }
  }
  
  public void addChild(Object paramObject, View paramView)
  {
    AccessibilityNodeInfoCompatIcs.addChild(paramObject, paramView);
  }
  
  public List<Object> findAccessibilityNodeInfosByText(Object paramObject, String paramString)
  {
    return AccessibilityNodeInfoCompatIcs.findAccessibilityNodeInfosByText(paramObject, paramString);
  }
  
  public int getActions(Object paramObject)
  {
    return AccessibilityNodeInfoCompatIcs.getActions(paramObject);
  }
  
  public void getBoundsInParent(Object paramObject, Rect paramRect)
  {
    AccessibilityNodeInfoCompatIcs.getBoundsInParent(paramObject, paramRect);
  }
  
  public void getBoundsInScreen(Object paramObject, Rect paramRect)
  {
    AccessibilityNodeInfoCompatIcs.getBoundsInScreen(paramObject, paramRect);
  }
  
  public Object getChild(Object paramObject, int paramInt)
  {
    return AccessibilityNodeInfoCompatIcs.getChild(paramObject, paramInt);
  }
  
  public int getChildCount(Object paramObject)
  {
    return AccessibilityNodeInfoCompatIcs.getChildCount(paramObject);
  }
  
  public CharSequence getClassName(Object paramObject)
  {
    return AccessibilityNodeInfoCompatIcs.getClassName(paramObject);
  }
  
  public CharSequence getContentDescription(Object paramObject)
  {
    return AccessibilityNodeInfoCompatIcs.getContentDescription(paramObject);
  }
  
  public CharSequence getPackageName(Object paramObject)
  {
    return AccessibilityNodeInfoCompatIcs.getPackageName(paramObject);
  }
  
  public Object getParent(Object paramObject)
  {
    return AccessibilityNodeInfoCompatIcs.getParent(paramObject);
  }
  
  public CharSequence getText(Object paramObject)
  {
    return AccessibilityNodeInfoCompatIcs.getText(paramObject);
  }
  
  public int getWindowId(Object paramObject)
  {
    return AccessibilityNodeInfoCompatIcs.getWindowId(paramObject);
  }
  
  public boolean isCheckable(Object paramObject)
  {
    return AccessibilityNodeInfoCompatIcs.isCheckable(paramObject);
  }
  
  public boolean isChecked(Object paramObject)
  {
    return AccessibilityNodeInfoCompatIcs.isChecked(paramObject);
  }
  
  public boolean isClickable(Object paramObject)
  {
    return AccessibilityNodeInfoCompatIcs.isClickable(paramObject);
  }
  
  public boolean isEnabled(Object paramObject)
  {
    return AccessibilityNodeInfoCompatIcs.isEnabled(paramObject);
  }
  
  public boolean isFocusable(Object paramObject)
  {
    return AccessibilityNodeInfoCompatIcs.isFocusable(paramObject);
  }
  
  public boolean isFocused(Object paramObject)
  {
    return AccessibilityNodeInfoCompatIcs.isFocused(paramObject);
  }
  
  public boolean isLongClickable(Object paramObject)
  {
    return AccessibilityNodeInfoCompatIcs.isLongClickable(paramObject);
  }
  
  public boolean isPassword(Object paramObject)
  {
    return AccessibilityNodeInfoCompatIcs.isPassword(paramObject);
  }
  
  public boolean isScrollable(Object paramObject)
  {
    return AccessibilityNodeInfoCompatIcs.isScrollable(paramObject);
  }
  
  public boolean isSelected(Object paramObject)
  {
    return AccessibilityNodeInfoCompatIcs.isSelected(paramObject);
  }
  
  public Object obtain()
  {
    return AccessibilityNodeInfoCompatIcs.obtain();
  }
  
  public Object obtain(View paramView)
  {
    return AccessibilityNodeInfoCompatIcs.obtain(paramView);
  }
  
  public Object obtain(Object paramObject)
  {
    return AccessibilityNodeInfoCompatIcs.obtain(paramObject);
  }
  
  public boolean performAction(Object paramObject, int paramInt)
  {
    return AccessibilityNodeInfoCompatIcs.performAction(paramObject, paramInt);
  }
  
  public void recycle(Object paramObject)
  {
    AccessibilityNodeInfoCompatIcs.recycle(paramObject);
  }
  
  public void setBoundsInParent(Object paramObject, Rect paramRect)
  {
    AccessibilityNodeInfoCompatIcs.setBoundsInParent(paramObject, paramRect);
  }
  
  public void setBoundsInScreen(Object paramObject, Rect paramRect)
  {
    AccessibilityNodeInfoCompatIcs.setBoundsInScreen(paramObject, paramRect);
  }
  
  public void setCheckable(Object paramObject, boolean paramBoolean)
  {
    AccessibilityNodeInfoCompatIcs.setCheckable(paramObject, paramBoolean);
  }
  
  public void setChecked(Object paramObject, boolean paramBoolean)
  {
    AccessibilityNodeInfoCompatIcs.setChecked(paramObject, paramBoolean);
  }
  
  public void setClassName(Object paramObject, CharSequence paramCharSequence)
  {
    AccessibilityNodeInfoCompatIcs.setClassName(paramObject, paramCharSequence);
  }
  
  public void setClickable(Object paramObject, boolean paramBoolean)
  {
    AccessibilityNodeInfoCompatIcs.setClickable(paramObject, paramBoolean);
  }
  
  public void setContentDescription(Object paramObject, CharSequence paramCharSequence)
  {
    AccessibilityNodeInfoCompatIcs.setContentDescription(paramObject, paramCharSequence);
  }
  
  public void setEnabled(Object paramObject, boolean paramBoolean)
  {
    AccessibilityNodeInfoCompatIcs.setEnabled(paramObject, paramBoolean);
  }
  
  public void setFocusable(Object paramObject, boolean paramBoolean)
  {
    AccessibilityNodeInfoCompatIcs.setFocusable(paramObject, paramBoolean);
  }
  
  public void setFocused(Object paramObject, boolean paramBoolean)
  {
    AccessibilityNodeInfoCompatIcs.setFocused(paramObject, paramBoolean);
  }
  
  public void setLongClickable(Object paramObject, boolean paramBoolean)
  {
    AccessibilityNodeInfoCompatIcs.setLongClickable(paramObject, paramBoolean);
  }
  
  public void setPackageName(Object paramObject, CharSequence paramCharSequence)
  {
    AccessibilityNodeInfoCompatIcs.setPackageName(paramObject, paramCharSequence);
  }
  
  public void setParent(Object paramObject, View paramView)
  {
    AccessibilityNodeInfoCompatIcs.setParent(paramObject, paramView);
  }
  
  public void setPassword(Object paramObject, boolean paramBoolean)
  {
    AccessibilityNodeInfoCompatIcs.setPassword(paramObject, paramBoolean);
  }
  
  public void setScrollable(Object paramObject, boolean paramBoolean)
  {
    AccessibilityNodeInfoCompatIcs.setScrollable(paramObject, paramBoolean);
  }
  
  public void setSelected(Object paramObject, boolean paramBoolean)
  {
    AccessibilityNodeInfoCompatIcs.setSelected(paramObject, paramBoolean);
  }
  
  public void setSource(Object paramObject, View paramView)
  {
    AccessibilityNodeInfoCompatIcs.setSource(paramObject, paramView);
  }
  
  public void setText(Object paramObject, CharSequence paramCharSequence)
  {
    AccessibilityNodeInfoCompatIcs.setText(paramObject, paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoIcsImpl
 * JD-Core Version:    0.7.0.1
 */