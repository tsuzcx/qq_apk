package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;

abstract interface AccessibilityEventCompat$AccessibilityEventVersionImpl
{
  public abstract void appendRecord(AccessibilityEvent paramAccessibilityEvent, Object paramObject);
  
  public abstract int getContentChangeTypes(AccessibilityEvent paramAccessibilityEvent);
  
  public abstract Object getRecord(AccessibilityEvent paramAccessibilityEvent, int paramInt);
  
  public abstract int getRecordCount(AccessibilityEvent paramAccessibilityEvent);
  
  public abstract void setContentChangeTypes(AccessibilityEvent paramAccessibilityEvent, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventVersionImpl
 * JD-Core Version:    0.7.0.1
 */