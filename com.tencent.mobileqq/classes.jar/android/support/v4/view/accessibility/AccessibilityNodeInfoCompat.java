package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityNodeInfoCompat
{
  public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
  public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
  public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
  public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
  public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
  public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
  public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
  public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
  public static final int ACTION_CLEAR_FOCUS = 2;
  public static final int ACTION_CLEAR_SELECTION = 8;
  public static final int ACTION_CLICK = 16;
  public static final int ACTION_COPY = 16384;
  public static final int ACTION_CUT = 65536;
  public static final int ACTION_FOCUS = 1;
  public static final int ACTION_LONG_CLICK = 32;
  public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
  public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
  public static final int ACTION_PASTE = 32768;
  public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
  public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
  public static final int ACTION_SCROLL_BACKWARD = 8192;
  public static final int ACTION_SCROLL_FORWARD = 4096;
  public static final int ACTION_SELECT = 4;
  public static final int ACTION_SET_SELECTION = 131072;
  public static final int ACTION_SET_TEXT = 2097152;
  public static final int FOCUS_ACCESSIBILITY = 2;
  public static final int FOCUS_INPUT = 1;
  private static final AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl IMPL = new AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl();
  public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
  public static final int MOVEMENT_GRANULARITY_LINE = 4;
  public static final int MOVEMENT_GRANULARITY_PAGE = 16;
  public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
  public static final int MOVEMENT_GRANULARITY_WORD = 2;
  private final Object mInfo;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      IMPL = new AccessibilityNodeInfoCompat.AccessibilityNodeInfoKitKatImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      IMPL = new AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanMr2Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      IMPL = new AccessibilityNodeInfoCompat.AccessibilityNodeInfoIcsImpl();
      return;
    }
  }
  
  public AccessibilityNodeInfoCompat(Object paramObject)
  {
    this.mInfo = paramObject;
  }
  
  private static String getActionSymbolicName(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        switch (paramInt)
        {
        default: 
          return "ACTION_UNKNOWN";
        case 131072: 
          return "ACTION_SET_SELECTION";
        case 65536: 
          return "ACTION_CUT";
        case 32768: 
          return "ACTION_PASTE";
        case 16384: 
          return "ACTION_COPY";
        case 8192: 
          return "ACTION_SCROLL_BACKWARD";
        case 4096: 
          return "ACTION_SCROLL_FORWARD";
        case 2048: 
          return "ACTION_PREVIOUS_HTML_ELEMENT";
        case 1024: 
          return "ACTION_NEXT_HTML_ELEMENT";
        case 512: 
          return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
        case 256: 
          return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
        case 128: 
          return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
        case 64: 
          return "ACTION_ACCESSIBILITY_FOCUS";
        case 32: 
          return "ACTION_LONG_CLICK";
        case 16: 
          return "ACTION_CLICK";
        case 8: 
          return "ACTION_CLEAR_SELECTION";
        }
        return "ACTION_SELECT";
      }
      return "ACTION_CLEAR_FOCUS";
    }
    return "ACTION_FOCUS";
  }
  
  public static AccessibilityNodeInfoCompat obtain()
  {
    return wrapNonNullInstance(IMPL.obtain());
  }
  
  public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    return wrapNonNullInstance(IMPL.obtain(paramAccessibilityNodeInfoCompat.mInfo));
  }
  
  public static AccessibilityNodeInfoCompat obtain(View paramView)
  {
    return wrapNonNullInstance(IMPL.obtain(paramView));
  }
  
  public static AccessibilityNodeInfoCompat obtain(View paramView, int paramInt)
  {
    return wrapNonNullInstance(IMPL.obtain(paramView, paramInt));
  }
  
  static AccessibilityNodeInfoCompat wrapNonNullInstance(Object paramObject)
  {
    if (paramObject != null) {
      return new AccessibilityNodeInfoCompat(paramObject);
    }
    return null;
  }
  
  public void addAction(int paramInt)
  {
    IMPL.addAction(this.mInfo, paramInt);
  }
  
  public void addChild(View paramView)
  {
    IMPL.addChild(this.mInfo, paramView);
  }
  
  public void addChild(View paramView, int paramInt)
  {
    IMPL.addChild(this.mInfo, paramView, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (AccessibilityNodeInfoCompat)paramObject;
    Object localObject = this.mInfo;
    if (localObject == null)
    {
      if (paramObject.mInfo != null) {
        return false;
      }
    }
    else if (!localObject.equals(paramObject.mInfo)) {
      return false;
    }
    return true;
  }
  
  public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = IMPL.findAccessibilityNodeInfosByText(this.mInfo, paramString);
    int j = paramString.size();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new AccessibilityNodeInfoCompat(paramString.get(i)));
      i += 1;
    }
    return localArrayList;
  }
  
  public AccessibilityNodeInfoCompat findFocus(int paramInt)
  {
    return wrapNonNullInstance(IMPL.findFocus(this.mInfo, paramInt));
  }
  
  public AccessibilityNodeInfoCompat focusSearch(int paramInt)
  {
    return wrapNonNullInstance(IMPL.focusSearch(this.mInfo, paramInt));
  }
  
  public List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = IMPL.getActionList(this.mInfo);
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(localList.get(i), null));
      i += 1;
    }
    return localArrayList;
  }
  
  public int getActions()
  {
    return IMPL.getActions(this.mInfo);
  }
  
  public void getBoundsInParent(Rect paramRect)
  {
    IMPL.getBoundsInParent(this.mInfo, paramRect);
  }
  
  public void getBoundsInScreen(Rect paramRect)
  {
    IMPL.getBoundsInScreen(this.mInfo, paramRect);
  }
  
  public AccessibilityNodeInfoCompat getChild(int paramInt)
  {
    return wrapNonNullInstance(IMPL.getChild(this.mInfo, paramInt));
  }
  
  public int getChildCount()
  {
    return IMPL.getChildCount(this.mInfo);
  }
  
  public CharSequence getClassName()
  {
    return IMPL.getClassName(this.mInfo);
  }
  
  public AccessibilityNodeInfoCompat.CollectionInfoCompat getCollectionInfo()
  {
    Object localObject = IMPL.getCollectionInfo(this.mInfo);
    if (localObject == null) {
      return null;
    }
    return new AccessibilityNodeInfoCompat.CollectionInfoCompat(localObject, null);
  }
  
  public AccessibilityNodeInfoCompat.CollectionItemInfoCompat getCollectionItemInfo()
  {
    Object localObject = IMPL.getCollectionItemInfo(this.mInfo);
    if (localObject == null) {
      return null;
    }
    return new AccessibilityNodeInfoCompat.CollectionItemInfoCompat(localObject, null);
  }
  
  public CharSequence getContentDescription()
  {
    return IMPL.getContentDescription(this.mInfo);
  }
  
  public Object getInfo()
  {
    return this.mInfo;
  }
  
  public int getLiveRegion()
  {
    return IMPL.getLiveRegion(this.mInfo);
  }
  
  public int getMovementGranularities()
  {
    return IMPL.getMovementGranularities(this.mInfo);
  }
  
  public CharSequence getPackageName()
  {
    return IMPL.getPackageName(this.mInfo);
  }
  
  public AccessibilityNodeInfoCompat getParent()
  {
    return wrapNonNullInstance(IMPL.getParent(this.mInfo));
  }
  
  public AccessibilityNodeInfoCompat.RangeInfoCompat getRangeInfo()
  {
    Object localObject = IMPL.getRangeInfo(this.mInfo);
    if (localObject == null) {
      return null;
    }
    return new AccessibilityNodeInfoCompat.RangeInfoCompat(localObject, null);
  }
  
  public CharSequence getText()
  {
    return IMPL.getText(this.mInfo);
  }
  
  public String getViewIdResourceName()
  {
    return IMPL.getViewIdResourceName(this.mInfo);
  }
  
  public int getWindowId()
  {
    return IMPL.getWindowId(this.mInfo);
  }
  
  public int hashCode()
  {
    Object localObject = this.mInfo;
    if (localObject == null) {
      return 0;
    }
    return localObject.hashCode();
  }
  
  public boolean isAccessibilityFocused()
  {
    return IMPL.isAccessibilityFocused(this.mInfo);
  }
  
  public boolean isCheckable()
  {
    return IMPL.isCheckable(this.mInfo);
  }
  
  public boolean isChecked()
  {
    return IMPL.isChecked(this.mInfo);
  }
  
  public boolean isClickable()
  {
    return IMPL.isClickable(this.mInfo);
  }
  
  public boolean isEnabled()
  {
    return IMPL.isEnabled(this.mInfo);
  }
  
  public boolean isFocusable()
  {
    return IMPL.isFocusable(this.mInfo);
  }
  
  public boolean isFocused()
  {
    return IMPL.isFocused(this.mInfo);
  }
  
  public boolean isLongClickable()
  {
    return IMPL.isLongClickable(this.mInfo);
  }
  
  public boolean isPassword()
  {
    return IMPL.isPassword(this.mInfo);
  }
  
  public boolean isScrollable()
  {
    return IMPL.isScrollable(this.mInfo);
  }
  
  public boolean isSelected()
  {
    return IMPL.isSelected(this.mInfo);
  }
  
  public boolean isVisibleToUser()
  {
    return IMPL.isVisibleToUser(this.mInfo);
  }
  
  public boolean performAction(int paramInt)
  {
    return IMPL.performAction(this.mInfo, paramInt);
  }
  
  public boolean performAction(int paramInt, Bundle paramBundle)
  {
    return IMPL.performAction(this.mInfo, paramInt, paramBundle);
  }
  
  public void recycle()
  {
    IMPL.recycle(this.mInfo);
  }
  
  public void setAccessibilityFocused(boolean paramBoolean)
  {
    IMPL.setAccessibilityFocused(this.mInfo, paramBoolean);
  }
  
  public void setBoundsInParent(Rect paramRect)
  {
    IMPL.setBoundsInParent(this.mInfo, paramRect);
  }
  
  public void setBoundsInScreen(Rect paramRect)
  {
    IMPL.setBoundsInScreen(this.mInfo, paramRect);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    IMPL.setCheckable(this.mInfo, paramBoolean);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    IMPL.setChecked(this.mInfo, paramBoolean);
  }
  
  public void setClassName(CharSequence paramCharSequence)
  {
    IMPL.setClassName(this.mInfo, paramCharSequence);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    IMPL.setClickable(this.mInfo, paramBoolean);
  }
  
  public void setCollectionInfo(Object paramObject)
  {
    IMPL.setCollectionInfo(this.mInfo, ((AccessibilityNodeInfoCompat.CollectionInfoCompat)paramObject).mInfo);
  }
  
  public void setCollectionItemInfo(Object paramObject)
  {
    IMPL.setCollectionItemInfo(this.mInfo, AccessibilityNodeInfoCompat.CollectionItemInfoCompat.access$200((AccessibilityNodeInfoCompat.CollectionItemInfoCompat)paramObject));
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    IMPL.setContentDescription(this.mInfo, paramCharSequence);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    IMPL.setEnabled(this.mInfo, paramBoolean);
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    IMPL.setFocusable(this.mInfo, paramBoolean);
  }
  
  public void setFocused(boolean paramBoolean)
  {
    IMPL.setFocused(this.mInfo, paramBoolean);
  }
  
  public void setLiveRegion(int paramInt)
  {
    IMPL.setLiveRegion(this.mInfo, paramInt);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    IMPL.setLongClickable(this.mInfo, paramBoolean);
  }
  
  public void setMovementGranularities(int paramInt)
  {
    IMPL.setMovementGranularities(this.mInfo, paramInt);
  }
  
  public void setPackageName(CharSequence paramCharSequence)
  {
    IMPL.setPackageName(this.mInfo, paramCharSequence);
  }
  
  public void setParent(View paramView)
  {
    IMPL.setParent(this.mInfo, paramView);
  }
  
  public void setParent(View paramView, int paramInt)
  {
    IMPL.setParent(this.mInfo, paramView, paramInt);
  }
  
  public void setPassword(boolean paramBoolean)
  {
    IMPL.setPassword(this.mInfo, paramBoolean);
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    IMPL.setScrollable(this.mInfo, paramBoolean);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    IMPL.setSelected(this.mInfo, paramBoolean);
  }
  
  public void setSource(View paramView)
  {
    IMPL.setSource(this.mInfo, paramView);
  }
  
  public void setSource(View paramView, int paramInt)
  {
    IMPL.setSource(this.mInfo, paramView, paramInt);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    IMPL.setText(this.mInfo, paramCharSequence);
  }
  
  public void setViewIdResourceName(String paramString)
  {
    IMPL.setViewIdResourceName(this.mInfo, paramString);
  }
  
  public void setVisibleToUser(boolean paramBoolean)
  {
    IMPL.setVisibleToUser(this.mInfo, paramBoolean);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(super.toString());
    Object localObject = new Rect();
    getBoundsInParent((Rect)localObject);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("; boundsInParent: ");
    localStringBuilder2.append(localObject);
    localStringBuilder1.append(localStringBuilder2.toString());
    getBoundsInScreen((Rect)localObject);
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("; boundsInScreen: ");
    localStringBuilder2.append(localObject);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("; packageName: ");
    localStringBuilder1.append(getPackageName());
    localStringBuilder1.append("; className: ");
    localStringBuilder1.append(getClassName());
    localStringBuilder1.append("; text: ");
    localStringBuilder1.append(getText());
    localStringBuilder1.append("; contentDescription: ");
    localStringBuilder1.append(getContentDescription());
    localStringBuilder1.append("; viewId: ");
    localStringBuilder1.append(getViewIdResourceName());
    localStringBuilder1.append("; checkable: ");
    localStringBuilder1.append(isCheckable());
    localStringBuilder1.append("; checked: ");
    localStringBuilder1.append(isChecked());
    localStringBuilder1.append("; focusable: ");
    localStringBuilder1.append(isFocusable());
    localStringBuilder1.append("; focused: ");
    localStringBuilder1.append(isFocused());
    localStringBuilder1.append("; selected: ");
    localStringBuilder1.append(isSelected());
    localStringBuilder1.append("; clickable: ");
    localStringBuilder1.append(isClickable());
    localStringBuilder1.append("; longClickable: ");
    localStringBuilder1.append(isLongClickable());
    localStringBuilder1.append("; enabled: ");
    localStringBuilder1.append(isEnabled());
    localStringBuilder1.append("; password: ");
    localStringBuilder1.append(isPassword());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("; scrollable: ");
    ((StringBuilder)localObject).append(isScrollable());
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localStringBuilder1.append("; [");
    int i = getActions();
    while (i != 0)
    {
      int k = 1 << Integer.numberOfTrailingZeros(i);
      int j = i & (k ^ 0xFFFFFFFF);
      localStringBuilder1.append(getActionSymbolicName(k));
      i = j;
      if (j != 0)
      {
        localStringBuilder1.append(", ");
        i = j;
      }
    }
    localStringBuilder1.append("]");
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat
 * JD-Core Version:    0.7.0.1
 */