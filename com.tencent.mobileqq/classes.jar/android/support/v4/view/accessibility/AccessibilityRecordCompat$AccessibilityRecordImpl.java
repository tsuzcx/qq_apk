package android.support.v4.view.accessibility;

import android.os.Parcelable;
import android.view.View;
import java.util.List;

abstract interface AccessibilityRecordCompat$AccessibilityRecordImpl
{
  public abstract int getAddedCount(Object paramObject);
  
  public abstract CharSequence getBeforeText(Object paramObject);
  
  public abstract CharSequence getClassName(Object paramObject);
  
  public abstract CharSequence getContentDescription(Object paramObject);
  
  public abstract int getCurrentItemIndex(Object paramObject);
  
  public abstract int getFromIndex(Object paramObject);
  
  public abstract int getItemCount(Object paramObject);
  
  public abstract int getMaxScrollX(Object paramObject);
  
  public abstract int getMaxScrollY(Object paramObject);
  
  public abstract Parcelable getParcelableData(Object paramObject);
  
  public abstract int getRemovedCount(Object paramObject);
  
  public abstract int getScrollX(Object paramObject);
  
  public abstract int getScrollY(Object paramObject);
  
  public abstract AccessibilityNodeInfoCompat getSource(Object paramObject);
  
  public abstract List<CharSequence> getText(Object paramObject);
  
  public abstract int getToIndex(Object paramObject);
  
  public abstract int getWindowId(Object paramObject);
  
  public abstract boolean isChecked(Object paramObject);
  
  public abstract boolean isEnabled(Object paramObject);
  
  public abstract boolean isFullScreen(Object paramObject);
  
  public abstract boolean isPassword(Object paramObject);
  
  public abstract boolean isScrollable(Object paramObject);
  
  public abstract Object obtain();
  
  public abstract Object obtain(Object paramObject);
  
  public abstract void recycle(Object paramObject);
  
  public abstract void setAddedCount(Object paramObject, int paramInt);
  
  public abstract void setBeforeText(Object paramObject, CharSequence paramCharSequence);
  
  public abstract void setChecked(Object paramObject, boolean paramBoolean);
  
  public abstract void setClassName(Object paramObject, CharSequence paramCharSequence);
  
  public abstract void setContentDescription(Object paramObject, CharSequence paramCharSequence);
  
  public abstract void setCurrentItemIndex(Object paramObject, int paramInt);
  
  public abstract void setEnabled(Object paramObject, boolean paramBoolean);
  
  public abstract void setFromIndex(Object paramObject, int paramInt);
  
  public abstract void setFullScreen(Object paramObject, boolean paramBoolean);
  
  public abstract void setItemCount(Object paramObject, int paramInt);
  
  public abstract void setMaxScrollX(Object paramObject, int paramInt);
  
  public abstract void setMaxScrollY(Object paramObject, int paramInt);
  
  public abstract void setParcelableData(Object paramObject, Parcelable paramParcelable);
  
  public abstract void setPassword(Object paramObject, boolean paramBoolean);
  
  public abstract void setRemovedCount(Object paramObject, int paramInt);
  
  public abstract void setScrollX(Object paramObject, int paramInt);
  
  public abstract void setScrollY(Object paramObject, int paramInt);
  
  public abstract void setScrollable(Object paramObject, boolean paramBoolean);
  
  public abstract void setSource(Object paramObject, View paramView);
  
  public abstract void setSource(Object paramObject, View paramView, int paramInt);
  
  public abstract void setToIndex(Object paramObject, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityRecordCompat.AccessibilityRecordImpl
 * JD-Core Version:    0.7.0.1
 */