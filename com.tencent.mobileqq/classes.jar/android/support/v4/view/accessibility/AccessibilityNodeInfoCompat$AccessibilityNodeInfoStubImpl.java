package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import java.util.Collections;
import java.util.List;

class AccessibilityNodeInfoCompat$AccessibilityNodeInfoStubImpl
  implements AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
{
  public void addAction(Object paramObject, int paramInt) {}
  
  public void addAction(Object paramObject, int paramInt, CharSequence paramCharSequence) {}
  
  public void addChild(Object paramObject, View paramView) {}
  
  public void addChild(Object paramObject, View paramView, int paramInt) {}
  
  public List<Object> findAccessibilityNodeInfosByText(Object paramObject, String paramString)
  {
    return Collections.emptyList();
  }
  
  public Object findFocus(Object paramObject, int paramInt)
  {
    return null;
  }
  
  public Object focusSearch(Object paramObject, int paramInt)
  {
    return null;
  }
  
  public List<Object> getActionList(Object paramObject)
  {
    return null;
  }
  
  public int getActions(Object paramObject)
  {
    return 0;
  }
  
  public void getBoundsInParent(Object paramObject, Rect paramRect) {}
  
  public void getBoundsInScreen(Object paramObject, Rect paramRect) {}
  
  public Object getChild(Object paramObject, int paramInt)
  {
    return null;
  }
  
  public int getChildCount(Object paramObject)
  {
    return 0;
  }
  
  public CharSequence getClassName(Object paramObject)
  {
    return null;
  }
  
  public Object getCollectionInfo(Object paramObject)
  {
    return null;
  }
  
  public int getCollectionInfoColumnCount(Object paramObject)
  {
    return 0;
  }
  
  public int getCollectionInfoRowCount(Object paramObject)
  {
    return 0;
  }
  
  public int getCollectionItemColumnIndex(Object paramObject)
  {
    return 0;
  }
  
  public int getCollectionItemColumnSpan(Object paramObject)
  {
    return 0;
  }
  
  public Object getCollectionItemInfo(Object paramObject)
  {
    return null;
  }
  
  public int getCollectionItemRowIndex(Object paramObject)
  {
    return 0;
  }
  
  public int getCollectionItemRowSpan(Object paramObject)
  {
    return 0;
  }
  
  public CharSequence getContentDescription(Object paramObject)
  {
    return null;
  }
  
  public int getLiveRegion(Object paramObject)
  {
    return 0;
  }
  
  public int getMovementGranularities(Object paramObject)
  {
    return 0;
  }
  
  public CharSequence getPackageName(Object paramObject)
  {
    return null;
  }
  
  public Object getParent(Object paramObject)
  {
    return null;
  }
  
  public Object getRangeInfo(Object paramObject)
  {
    return null;
  }
  
  public CharSequence getText(Object paramObject)
  {
    return null;
  }
  
  public String getViewIdResourceName(Object paramObject)
  {
    return null;
  }
  
  public int getWindowId(Object paramObject)
  {
    return 0;
  }
  
  public boolean isAccessibilityFocused(Object paramObject)
  {
    return false;
  }
  
  public boolean isCheckable(Object paramObject)
  {
    return false;
  }
  
  public boolean isChecked(Object paramObject)
  {
    return false;
  }
  
  public boolean isClickable(Object paramObject)
  {
    return false;
  }
  
  public boolean isCollectionInfoHierarchical(Object paramObject)
  {
    return false;
  }
  
  public boolean isCollectionItemHeading(Object paramObject)
  {
    return false;
  }
  
  public boolean isCollectionItemSelected(Object paramObject)
  {
    return false;
  }
  
  public boolean isEnabled(Object paramObject)
  {
    return false;
  }
  
  public boolean isFocusable(Object paramObject)
  {
    return false;
  }
  
  public boolean isFocused(Object paramObject)
  {
    return false;
  }
  
  public boolean isLongClickable(Object paramObject)
  {
    return false;
  }
  
  public boolean isPassword(Object paramObject)
  {
    return false;
  }
  
  public boolean isScrollable(Object paramObject)
  {
    return false;
  }
  
  public boolean isSelected(Object paramObject)
  {
    return false;
  }
  
  public boolean isVisibleToUser(Object paramObject)
  {
    return false;
  }
  
  public Object obtain()
  {
    return null;
  }
  
  public Object obtain(View paramView)
  {
    return null;
  }
  
  public Object obtain(View paramView, int paramInt)
  {
    return null;
  }
  
  public Object obtain(Object paramObject)
  {
    return null;
  }
  
  public Object obtainCollectionInfo(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    return null;
  }
  
  public Object obtainCollectionItemInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    return null;
  }
  
  public boolean performAction(Object paramObject, int paramInt)
  {
    return false;
  }
  
  public boolean performAction(Object paramObject, int paramInt, Bundle paramBundle)
  {
    return false;
  }
  
  public void recycle(Object paramObject) {}
  
  public void setAccessibilityFocused(Object paramObject, boolean paramBoolean) {}
  
  public void setBoundsInParent(Object paramObject, Rect paramRect) {}
  
  public void setBoundsInScreen(Object paramObject, Rect paramRect) {}
  
  public void setCheckable(Object paramObject, boolean paramBoolean) {}
  
  public void setChecked(Object paramObject, boolean paramBoolean) {}
  
  public void setClassName(Object paramObject, CharSequence paramCharSequence) {}
  
  public void setClickable(Object paramObject, boolean paramBoolean) {}
  
  public void setCollectionInfo(Object paramObject1, Object paramObject2) {}
  
  public void setCollectionItemInfo(Object paramObject1, Object paramObject2) {}
  
  public void setContentDescription(Object paramObject, CharSequence paramCharSequence) {}
  
  public void setEnabled(Object paramObject, boolean paramBoolean) {}
  
  public void setFocusable(Object paramObject, boolean paramBoolean) {}
  
  public void setFocused(Object paramObject, boolean paramBoolean) {}
  
  public void setLiveRegion(Object paramObject, int paramInt) {}
  
  public void setLongClickable(Object paramObject, boolean paramBoolean) {}
  
  public void setMovementGranularities(Object paramObject, int paramInt) {}
  
  public void setPackageName(Object paramObject, CharSequence paramCharSequence) {}
  
  public void setParent(Object paramObject, View paramView) {}
  
  public void setParent(Object paramObject, View paramView, int paramInt) {}
  
  public void setPassword(Object paramObject, boolean paramBoolean) {}
  
  public void setScrollable(Object paramObject, boolean paramBoolean) {}
  
  public void setSelected(Object paramObject, boolean paramBoolean) {}
  
  public void setSource(Object paramObject, View paramView) {}
  
  public void setSource(Object paramObject, View paramView, int paramInt) {}
  
  public void setText(Object paramObject, CharSequence paramCharSequence) {}
  
  public void setViewIdResourceName(Object paramObject, String paramString) {}
  
  public void setVisibleToUser(Object paramObject, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl
 * JD-Core Version:    0.7.0.1
 */