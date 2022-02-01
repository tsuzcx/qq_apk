package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import android.view.accessibility.AccessibilityNodeInfo.RangeInfo;
import android.view.accessibility.AccessibilityNodeInfo.TouchDelegateInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AccessibilityNodeInfoCompat
{
  public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
  public static final String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
  public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
  public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
  public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
  public static final String ACTION_ARGUMENT_MOVE_WINDOW_X = "ACTION_ARGUMENT_MOVE_WINDOW_X";
  public static final String ACTION_ARGUMENT_MOVE_WINDOW_Y = "ACTION_ARGUMENT_MOVE_WINDOW_Y";
  public static final String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
  public static final String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
  public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
  public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
  public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
  public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
  public static final int ACTION_CLEAR_FOCUS = 2;
  public static final int ACTION_CLEAR_SELECTION = 8;
  public static final int ACTION_CLICK = 16;
  public static final int ACTION_COLLAPSE = 524288;
  public static final int ACTION_COPY = 16384;
  public static final int ACTION_CUT = 65536;
  public static final int ACTION_DISMISS = 1048576;
  public static final int ACTION_EXPAND = 262144;
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
  private static final int BOOLEAN_PROPERTY_IS_HEADING = 2;
  private static final int BOOLEAN_PROPERTY_IS_SHOWING_HINT = 4;
  private static final int BOOLEAN_PROPERTY_IS_TEXT_ENTRY_KEY = 8;
  private static final String BOOLEAN_PROPERTY_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
  private static final int BOOLEAN_PROPERTY_SCREEN_READER_FOCUSABLE = 1;
  public static final int FOCUS_ACCESSIBILITY = 2;
  public static final int FOCUS_INPUT = 1;
  private static final String HINT_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY";
  public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
  public static final int MOVEMENT_GRANULARITY_LINE = 4;
  public static final int MOVEMENT_GRANULARITY_PAGE = 16;
  public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
  public static final int MOVEMENT_GRANULARITY_WORD = 2;
  private static final String PANE_TITLE_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY";
  private static final String ROLE_DESCRIPTION_KEY = "AccessibilityNodeInfo.roleDescription";
  private static final String SPANS_ACTION_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY";
  private static final String SPANS_END_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY";
  private static final String SPANS_FLAGS_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY";
  private static final String SPANS_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY";
  private static final String SPANS_START_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY";
  private static final String TOOLTIP_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY";
  private static int sClickableSpanId = 0;
  private final AccessibilityNodeInfo mInfo;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public int mParentVirtualDescendantId = -1;
  private int mVirtualDescendantId = -1;
  
  private AccessibilityNodeInfoCompat(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    this.mInfo = paramAccessibilityNodeInfo;
  }
  
  @Deprecated
  public AccessibilityNodeInfoCompat(Object paramObject)
  {
    this.mInfo = ((AccessibilityNodeInfo)paramObject);
  }
  
  private void addSpanLocationToExtras(ClickableSpan paramClickableSpan, Spanned paramSpanned, int paramInt)
  {
    extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(paramSpanned.getSpanStart(paramClickableSpan)));
    extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(paramSpanned.getSpanEnd(paramClickableSpan)));
    extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(paramSpanned.getSpanFlags(paramClickableSpan)));
    extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(paramInt));
  }
  
  private void clearExtrasSpans()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.mInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
      this.mInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
      this.mInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
      this.mInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }
  }
  
  private List<CharSequence> extrasCharSequenceList(String paramString)
  {
    if (Build.VERSION.SDK_INT < 19) {
      localObject = new ArrayList();
    }
    ArrayList localArrayList;
    do
    {
      return localObject;
      localArrayList = this.mInfo.getExtras().getCharSequenceArrayList(paramString);
      localObject = localArrayList;
    } while (localArrayList != null);
    Object localObject = new ArrayList();
    this.mInfo.getExtras().putCharSequenceArrayList(paramString, (ArrayList)localObject);
    return localObject;
  }
  
  private List<Integer> extrasIntList(String paramString)
  {
    if (Build.VERSION.SDK_INT < 19) {
      localObject = new ArrayList();
    }
    ArrayList localArrayList;
    do
    {
      return localObject;
      localArrayList = this.mInfo.getExtras().getIntegerArrayList(paramString);
      localObject = localArrayList;
    } while (localArrayList != null);
    Object localObject = new ArrayList();
    this.mInfo.getExtras().putIntegerArrayList(paramString, (ArrayList)localObject);
    return localObject;
  }
  
  private static String getActionSymbolicName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "ACTION_UNKNOWN";
    case 1: 
      return "ACTION_FOCUS";
    case 2: 
      return "ACTION_CLEAR_FOCUS";
    case 4: 
      return "ACTION_SELECT";
    case 8: 
      return "ACTION_CLEAR_SELECTION";
    case 16: 
      return "ACTION_CLICK";
    case 32: 
      return "ACTION_LONG_CLICK";
    case 64: 
      return "ACTION_ACCESSIBILITY_FOCUS";
    case 128: 
      return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
    case 256: 
      return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
    case 512: 
      return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
    case 1024: 
      return "ACTION_NEXT_HTML_ELEMENT";
    case 2048: 
      return "ACTION_PREVIOUS_HTML_ELEMENT";
    case 4096: 
      return "ACTION_SCROLL_FORWARD";
    case 8192: 
      return "ACTION_SCROLL_BACKWARD";
    case 65536: 
      return "ACTION_CUT";
    case 16384: 
      return "ACTION_COPY";
    case 32768: 
      return "ACTION_PASTE";
    case 131072: 
      return "ACTION_SET_SELECTION";
    case 262144: 
      return "ACTION_EXPAND";
    case 524288: 
      return "ACTION_COLLAPSE";
    case 2097152: 
      return "ACTION_SET_TEXT";
    case 16908344: 
      return "ACTION_SCROLL_UP";
    case 16908345: 
      return "ACTION_SCROLL_LEFT";
    case 16908346: 
      return "ACTION_SCROLL_DOWN";
    case 16908347: 
      return "ACTION_SCROLL_RIGHT";
    case 16908359: 
      return "ACTION_PAGE_DOWN";
    case 16908358: 
      return "ACTION_PAGE_UP";
    case 16908360: 
      return "ACTION_PAGE_LEFT";
    case 16908361: 
      return "ACTION_PAGE_RIGHT";
    case 16908342: 
      return "ACTION_SHOW_ON_SCREEN";
    case 16908343: 
      return "ACTION_SCROLL_TO_POSITION";
    case 16908348: 
      return "ACTION_CONTEXT_CLICK";
    case 16908349: 
      return "ACTION_SET_PROGRESS";
    case 16908354: 
      return "ACTION_MOVE_WINDOW";
    case 16908356: 
      return "ACTION_SHOW_TOOLTIP";
    }
    return "ACTION_HIDE_TOOLTIP";
  }
  
  private boolean getBooleanProperty(int paramInt)
  {
    Bundle localBundle = getExtras();
    if (localBundle == null) {}
    while ((localBundle.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & paramInt) != paramInt) {
      return false;
    }
    return true;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static ClickableSpan[] getClickableSpans(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof Spanned)) {
      return (ClickableSpan[])((Spanned)paramCharSequence).getSpans(0, paramCharSequence.length(), ClickableSpan.class);
    }
    return null;
  }
  
  private SparseArray<WeakReference<ClickableSpan>> getOrCreateSpansFromViewTags(View paramView)
  {
    SparseArray localSparseArray2 = getSpansFromViewTags(paramView);
    SparseArray localSparseArray1 = localSparseArray2;
    if (localSparseArray2 == null)
    {
      localSparseArray1 = new SparseArray();
      paramView.setTag(2131378448, localSparseArray1);
    }
    return localSparseArray1;
  }
  
  private SparseArray<WeakReference<ClickableSpan>> getSpansFromViewTags(View paramView)
  {
    return (SparseArray)paramView.getTag(2131378448);
  }
  
  private boolean hasSpans()
  {
    return !extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
  }
  
  private int idForClickableSpan(ClickableSpan paramClickableSpan, SparseArray<WeakReference<ClickableSpan>> paramSparseArray)
  {
    if (paramSparseArray != null)
    {
      i = 0;
      while (i < paramSparseArray.size())
      {
        if (paramClickableSpan.equals((ClickableSpan)((WeakReference)paramSparseArray.valueAt(i)).get())) {
          return paramSparseArray.keyAt(i);
        }
        i += 1;
      }
    }
    int i = sClickableSpanId;
    sClickableSpanId = i + 1;
    return i;
  }
  
  public static AccessibilityNodeInfoCompat obtain()
  {
    return wrap(AccessibilityNodeInfo.obtain());
  }
  
  public static AccessibilityNodeInfoCompat obtain(View paramView)
  {
    return wrap(AccessibilityNodeInfo.obtain(paramView));
  }
  
  public static AccessibilityNodeInfoCompat obtain(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return wrapNonNullInstance(AccessibilityNodeInfo.obtain(paramView, paramInt));
    }
    return null;
  }
  
  public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    return wrap(AccessibilityNodeInfo.obtain(paramAccessibilityNodeInfoCompat.mInfo));
  }
  
  private void removeCollectedSpans(View paramView)
  {
    int k = 0;
    paramView = getSpansFromViewTags(paramView);
    if (paramView != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= paramView.size()) {
          break;
        }
        if (((WeakReference)paramView.valueAt(i)).get() == null) {
          localArrayList.add(Integer.valueOf(i));
        }
        i += 1;
      }
      while (j < localArrayList.size())
      {
        paramView.remove(((Integer)localArrayList.get(j)).intValue());
        j += 1;
      }
    }
  }
  
  private void setBooleanProperty(int paramInt, boolean paramBoolean)
  {
    Bundle localBundle = getExtras();
    int j;
    if (localBundle != null)
    {
      j = localBundle.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0);
      if (!paramBoolean) {
        break label43;
      }
    }
    label43:
    for (int i = paramInt;; i = 0)
    {
      localBundle.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", j & (paramInt ^ 0xFFFFFFFF) | i);
      return;
    }
  }
  
  public static AccessibilityNodeInfoCompat wrap(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    return new AccessibilityNodeInfoCompat(paramAccessibilityNodeInfo);
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
    this.mInfo.addAction(paramInt);
  }
  
  public void addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat paramAccessibilityActionCompat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      this.mInfo.addAction((AccessibilityNodeInfo.AccessibilityAction)paramAccessibilityActionCompat.mAction);
    }
  }
  
  public void addChild(View paramView)
  {
    this.mInfo.addChild(paramView);
  }
  
  public void addChild(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.mInfo.addChild(paramView, paramInt);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void addSpansToExtras(CharSequence paramCharSequence, View paramView)
  {
    if ((Build.VERSION.SDK_INT >= 19) && (Build.VERSION.SDK_INT < 26))
    {
      clearExtrasSpans();
      removeCollectedSpans(paramView);
      ClickableSpan[] arrayOfClickableSpan = getClickableSpans(paramCharSequence);
      if ((arrayOfClickableSpan != null) && (arrayOfClickableSpan.length > 0))
      {
        getExtras().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", 2131361824);
        paramView = getOrCreateSpansFromViewTags(paramView);
        int i = 0;
        while ((arrayOfClickableSpan != null) && (i < arrayOfClickableSpan.length))
        {
          int j = idForClickableSpan(arrayOfClickableSpan[i], paramView);
          paramView.put(j, new WeakReference(arrayOfClickableSpan[i]));
          addSpanLocationToExtras(arrayOfClickableSpan[i], (Spanned)paramCharSequence, j);
          i += 1;
        }
      }
    }
  }
  
  public boolean canOpenPopup()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return this.mInfo.canOpenPopup();
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof AccessibilityNodeInfoCompat)) {
        return false;
      }
      paramObject = (AccessibilityNodeInfoCompat)paramObject;
      if (this.mInfo == null)
      {
        if (paramObject.mInfo != null) {
          return false;
        }
      }
      else if (!this.mInfo.equals(paramObject.mInfo)) {
        return false;
      }
      if (this.mVirtualDescendantId != paramObject.mVirtualDescendantId) {
        return false;
      }
    } while (this.mParentVirtualDescendantId == paramObject.mParentVirtualDescendantId);
    return false;
  }
  
  public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = this.mInfo.findAccessibilityNodeInfosByText(paramString);
    int j = paramString.size();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(wrap((AccessibilityNodeInfo)paramString.get(i)));
      i += 1;
    }
    return localArrayList;
  }
  
  public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      Object localObject = this.mInfo.findAccessibilityNodeInfosByViewId(paramString);
      paramString = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramString.add(wrap((AccessibilityNodeInfo)((Iterator)localObject).next()));
      }
      return paramString;
    }
    return Collections.emptyList();
  }
  
  public AccessibilityNodeInfoCompat findFocus(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return wrapNonNullInstance(this.mInfo.findFocus(paramInt));
    }
    return null;
  }
  
  public AccessibilityNodeInfoCompat focusSearch(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return wrapNonNullInstance(this.mInfo.focusSearch(paramInt));
    }
    return null;
  }
  
  public List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (List localList = this.mInfo.getActionList();; localList = null)
    {
      if (localList != null)
      {
        ArrayList localArrayList = new ArrayList();
        int j = localList.size();
        int i = 0;
        for (;;)
        {
          localObject = localArrayList;
          if (i >= j) {
            break;
          }
          localArrayList.add(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(localList.get(i)));
          i += 1;
        }
      }
      Object localObject = Collections.emptyList();
      return localObject;
    }
  }
  
  public int getActions()
  {
    return this.mInfo.getActions();
  }
  
  @Deprecated
  public void getBoundsInParent(Rect paramRect)
  {
    this.mInfo.getBoundsInParent(paramRect);
  }
  
  public void getBoundsInScreen(Rect paramRect)
  {
    this.mInfo.getBoundsInScreen(paramRect);
  }
  
  public AccessibilityNodeInfoCompat getChild(int paramInt)
  {
    return wrapNonNullInstance(this.mInfo.getChild(paramInt));
  }
  
  public int getChildCount()
  {
    return this.mInfo.getChildCount();
  }
  
  public CharSequence getClassName()
  {
    return this.mInfo.getClassName();
  }
  
  public AccessibilityNodeInfoCompat.CollectionInfoCompat getCollectionInfo()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      AccessibilityNodeInfo.CollectionInfo localCollectionInfo = this.mInfo.getCollectionInfo();
      if (localCollectionInfo != null) {
        return new AccessibilityNodeInfoCompat.CollectionInfoCompat(localCollectionInfo);
      }
    }
    return null;
  }
  
  public AccessibilityNodeInfoCompat.CollectionItemInfoCompat getCollectionItemInfo()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      AccessibilityNodeInfo.CollectionItemInfo localCollectionItemInfo = this.mInfo.getCollectionItemInfo();
      if (localCollectionItemInfo != null) {
        return new AccessibilityNodeInfoCompat.CollectionItemInfoCompat(localCollectionItemInfo);
      }
    }
    return null;
  }
  
  public CharSequence getContentDescription()
  {
    return this.mInfo.getContentDescription();
  }
  
  public int getDrawingOrder()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.mInfo.getDrawingOrder();
    }
    return 0;
  }
  
  public CharSequence getError()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return this.mInfo.getError();
    }
    return null;
  }
  
  public Bundle getExtras()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return this.mInfo.getExtras();
    }
    return new Bundle();
  }
  
  @Nullable
  public CharSequence getHintText()
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return this.mInfo.getHintText();
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return this.mInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY");
    }
    return null;
  }
  
  @Deprecated
  public Object getInfo()
  {
    return this.mInfo;
  }
  
  public int getInputType()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return this.mInfo.getInputType();
    }
    return 0;
  }
  
  public AccessibilityNodeInfoCompat getLabelFor()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return wrapNonNullInstance(this.mInfo.getLabelFor());
    }
    return null;
  }
  
  public AccessibilityNodeInfoCompat getLabeledBy()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return wrapNonNullInstance(this.mInfo.getLabeledBy());
    }
    return null;
  }
  
  public int getLiveRegion()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return this.mInfo.getLiveRegion();
    }
    return 0;
  }
  
  public int getMaxTextLength()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return this.mInfo.getMaxTextLength();
    }
    return -1;
  }
  
  public int getMovementGranularities()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return this.mInfo.getMovementGranularities();
    }
    return 0;
  }
  
  public CharSequence getPackageName()
  {
    return this.mInfo.getPackageName();
  }
  
  @Nullable
  public CharSequence getPaneTitle()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return this.mInfo.getPaneTitle();
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return this.mInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY");
    }
    return null;
  }
  
  public AccessibilityNodeInfoCompat getParent()
  {
    return wrapNonNullInstance(this.mInfo.getParent());
  }
  
  public AccessibilityNodeInfoCompat.RangeInfoCompat getRangeInfo()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      AccessibilityNodeInfo.RangeInfo localRangeInfo = this.mInfo.getRangeInfo();
      if (localRangeInfo != null) {
        return new AccessibilityNodeInfoCompat.RangeInfoCompat(localRangeInfo);
      }
    }
    return null;
  }
  
  @Nullable
  public CharSequence getRoleDescription()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return this.mInfo.getExtras().getCharSequence("AccessibilityNodeInfo.roleDescription");
    }
    return null;
  }
  
  public CharSequence getText()
  {
    if (hasSpans())
    {
      List localList1 = extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
      List localList2 = extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
      List localList3 = extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
      List localList4 = extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
      SpannableString localSpannableString = new SpannableString(TextUtils.substring(this.mInfo.getText(), 0, this.mInfo.getText().length()));
      int i = 0;
      while (i < localList1.size())
      {
        localSpannableString.setSpan(new AccessibilityClickableSpanCompat(((Integer)localList4.get(i)).intValue(), this, getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer)localList1.get(i)).intValue(), ((Integer)localList2.get(i)).intValue(), ((Integer)localList3.get(i)).intValue());
        i += 1;
      }
      return localSpannableString;
    }
    return this.mInfo.getText();
  }
  
  public int getTextSelectionEnd()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return this.mInfo.getTextSelectionEnd();
    }
    return -1;
  }
  
  public int getTextSelectionStart()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return this.mInfo.getTextSelectionStart();
    }
    return -1;
  }
  
  @Nullable
  public CharSequence getTooltipText()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return this.mInfo.getTooltipText();
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return this.mInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY");
    }
    return null;
  }
  
  @Nullable
  public AccessibilityNodeInfoCompat.TouchDelegateInfoCompat getTouchDelegateInfo()
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      AccessibilityNodeInfo.TouchDelegateInfo localTouchDelegateInfo = this.mInfo.getTouchDelegateInfo();
      if (localTouchDelegateInfo != null) {
        return new AccessibilityNodeInfoCompat.TouchDelegateInfoCompat(localTouchDelegateInfo);
      }
    }
    return null;
  }
  
  public AccessibilityNodeInfoCompat getTraversalAfter()
  {
    if (Build.VERSION.SDK_INT >= 22) {
      return wrapNonNullInstance(this.mInfo.getTraversalAfter());
    }
    return null;
  }
  
  public AccessibilityNodeInfoCompat getTraversalBefore()
  {
    if (Build.VERSION.SDK_INT >= 22) {
      return wrapNonNullInstance(this.mInfo.getTraversalBefore());
    }
    return null;
  }
  
  public String getViewIdResourceName()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return this.mInfo.getViewIdResourceName();
    }
    return null;
  }
  
  public AccessibilityWindowInfoCompat getWindow()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return AccessibilityWindowInfoCompat.wrapNonNullInstance(this.mInfo.getWindow());
    }
    return null;
  }
  
  public int getWindowId()
  {
    return this.mInfo.getWindowId();
  }
  
  public int hashCode()
  {
    if (this.mInfo == null) {
      return 0;
    }
    return this.mInfo.hashCode();
  }
  
  public boolean isAccessibilityFocused()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return this.mInfo.isAccessibilityFocused();
    }
    return false;
  }
  
  public boolean isCheckable()
  {
    return this.mInfo.isCheckable();
  }
  
  public boolean isChecked()
  {
    return this.mInfo.isChecked();
  }
  
  public boolean isClickable()
  {
    return this.mInfo.isClickable();
  }
  
  public boolean isContentInvalid()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return this.mInfo.isContentInvalid();
    }
    return false;
  }
  
  public boolean isContextClickable()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return this.mInfo.isContextClickable();
    }
    return false;
  }
  
  public boolean isDismissable()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return this.mInfo.isDismissable();
    }
    return false;
  }
  
  public boolean isEditable()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return this.mInfo.isEditable();
    }
    return false;
  }
  
  public boolean isEnabled()
  {
    return this.mInfo.isEnabled();
  }
  
  public boolean isFocusable()
  {
    return this.mInfo.isFocusable();
  }
  
  public boolean isFocused()
  {
    return this.mInfo.isFocused();
  }
  
  public boolean isHeading()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Build.VERSION.SDK_INT >= 28) {
      bool1 = this.mInfo.isHeading();
    }
    AccessibilityNodeInfoCompat.CollectionItemInfoCompat localCollectionItemInfoCompat;
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (getBooleanProperty(2));
      localCollectionItemInfoCompat = getCollectionItemInfo();
      if (localCollectionItemInfoCompat == null) {
        break;
      }
      bool1 = bool2;
    } while (localCollectionItemInfoCompat.isHeading());
    return false;
  }
  
  public boolean isImportantForAccessibility()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.mInfo.isImportantForAccessibility();
    }
    return true;
  }
  
  public boolean isLongClickable()
  {
    return this.mInfo.isLongClickable();
  }
  
  public boolean isMultiLine()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return this.mInfo.isMultiLine();
    }
    return false;
  }
  
  public boolean isPassword()
  {
    return this.mInfo.isPassword();
  }
  
  public boolean isScreenReaderFocusable()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return this.mInfo.isScreenReaderFocusable();
    }
    return getBooleanProperty(1);
  }
  
  public boolean isScrollable()
  {
    return this.mInfo.isScrollable();
  }
  
  public boolean isSelected()
  {
    return this.mInfo.isSelected();
  }
  
  public boolean isShowingHintText()
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return this.mInfo.isShowingHintText();
    }
    return getBooleanProperty(4);
  }
  
  public boolean isTextEntryKey()
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return this.mInfo.isTextEntryKey();
    }
    return getBooleanProperty(8);
  }
  
  public boolean isVisibleToUser()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return this.mInfo.isVisibleToUser();
    }
    return false;
  }
  
  public boolean performAction(int paramInt)
  {
    return this.mInfo.performAction(paramInt);
  }
  
  public boolean performAction(int paramInt, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return this.mInfo.performAction(paramInt, paramBundle);
    }
    return false;
  }
  
  public void recycle()
  {
    this.mInfo.recycle();
  }
  
  public boolean refresh()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return this.mInfo.refresh();
    }
    return false;
  }
  
  public boolean removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat paramAccessibilityActionCompat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return this.mInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction)paramAccessibilityActionCompat.mAction);
    }
    return false;
  }
  
  public boolean removeChild(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return this.mInfo.removeChild(paramView);
    }
    return false;
  }
  
  public boolean removeChild(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return this.mInfo.removeChild(paramView, paramInt);
    }
    return false;
  }
  
  public void setAccessibilityFocused(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.mInfo.setAccessibilityFocused(paramBoolean);
    }
  }
  
  @Deprecated
  public void setBoundsInParent(Rect paramRect)
  {
    this.mInfo.setBoundsInParent(paramRect);
  }
  
  public void setBoundsInScreen(Rect paramRect)
  {
    this.mInfo.setBoundsInScreen(paramRect);
  }
  
  public void setCanOpenPopup(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      this.mInfo.setCanOpenPopup(paramBoolean);
    }
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    this.mInfo.setCheckable(paramBoolean);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.mInfo.setChecked(paramBoolean);
  }
  
  public void setClassName(CharSequence paramCharSequence)
  {
    this.mInfo.setClassName(paramCharSequence);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    this.mInfo.setClickable(paramBoolean);
  }
  
  public void setCollectionInfo(Object paramObject)
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo;
    if (Build.VERSION.SDK_INT >= 19)
    {
      localAccessibilityNodeInfo = this.mInfo;
      if (paramObject != null) {
        break label25;
      }
    }
    label25:
    for (paramObject = null;; paramObject = (AccessibilityNodeInfo.CollectionInfo)((AccessibilityNodeInfoCompat.CollectionInfoCompat)paramObject).mInfo)
    {
      localAccessibilityNodeInfo.setCollectionInfo(paramObject);
      return;
    }
  }
  
  public void setCollectionItemInfo(Object paramObject)
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo;
    if (Build.VERSION.SDK_INT >= 19)
    {
      localAccessibilityNodeInfo = this.mInfo;
      if (paramObject != null) {
        break label25;
      }
    }
    label25:
    for (paramObject = null;; paramObject = (AccessibilityNodeInfo.CollectionItemInfo)((AccessibilityNodeInfoCompat.CollectionItemInfoCompat)paramObject).mInfo)
    {
      localAccessibilityNodeInfo.setCollectionItemInfo(paramObject);
      return;
    }
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    this.mInfo.setContentDescription(paramCharSequence);
  }
  
  public void setContentInvalid(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      this.mInfo.setContentInvalid(paramBoolean);
    }
  }
  
  public void setContextClickable(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      this.mInfo.setContextClickable(paramBoolean);
    }
  }
  
  public void setDismissable(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      this.mInfo.setDismissable(paramBoolean);
    }
  }
  
  public void setDrawingOrder(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      this.mInfo.setDrawingOrder(paramInt);
    }
  }
  
  public void setEditable(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.mInfo.setEditable(paramBoolean);
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.mInfo.setEnabled(paramBoolean);
  }
  
  public void setError(CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      this.mInfo.setError(paramCharSequence);
    }
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    this.mInfo.setFocusable(paramBoolean);
  }
  
  public void setFocused(boolean paramBoolean)
  {
    this.mInfo.setFocused(paramBoolean);
  }
  
  public void setHeading(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.mInfo.setHeading(paramBoolean);
      return;
    }
    setBooleanProperty(2, paramBoolean);
  }
  
  public void setHintText(@Nullable CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      this.mInfo.setHintText(paramCharSequence);
    }
    while (Build.VERSION.SDK_INT < 19) {
      return;
    }
    this.mInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", paramCharSequence);
  }
  
  public void setImportantForAccessibility(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      this.mInfo.setImportantForAccessibility(paramBoolean);
    }
  }
  
  public void setInputType(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      this.mInfo.setInputType(paramInt);
    }
  }
  
  public void setLabelFor(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      this.mInfo.setLabelFor(paramView);
    }
  }
  
  public void setLabelFor(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      this.mInfo.setLabelFor(paramView, paramInt);
    }
  }
  
  public void setLabeledBy(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      this.mInfo.setLabeledBy(paramView);
    }
  }
  
  public void setLabeledBy(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      this.mInfo.setLabeledBy(paramView, paramInt);
    }
  }
  
  public void setLiveRegion(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      this.mInfo.setLiveRegion(paramInt);
    }
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    this.mInfo.setLongClickable(paramBoolean);
  }
  
  public void setMaxTextLength(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      this.mInfo.setMaxTextLength(paramInt);
    }
  }
  
  public void setMovementGranularities(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.mInfo.setMovementGranularities(paramInt);
    }
  }
  
  public void setMultiLine(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      this.mInfo.setMultiLine(paramBoolean);
    }
  }
  
  public void setPackageName(CharSequence paramCharSequence)
  {
    this.mInfo.setPackageName(paramCharSequence);
  }
  
  public void setPaneTitle(@Nullable CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      this.mInfo.setPaneTitle(paramCharSequence);
    }
    while (Build.VERSION.SDK_INT < 19) {
      return;
    }
    this.mInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", paramCharSequence);
  }
  
  public void setParent(View paramView)
  {
    this.mParentVirtualDescendantId = -1;
    this.mInfo.setParent(paramView);
  }
  
  public void setParent(View paramView, int paramInt)
  {
    this.mParentVirtualDescendantId = paramInt;
    if (Build.VERSION.SDK_INT >= 16) {
      this.mInfo.setParent(paramView, paramInt);
    }
  }
  
  public void setPassword(boolean paramBoolean)
  {
    this.mInfo.setPassword(paramBoolean);
  }
  
  public void setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat paramRangeInfoCompat)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      this.mInfo.setRangeInfo((AccessibilityNodeInfo.RangeInfo)paramRangeInfoCompat.mInfo);
    }
  }
  
  public void setRoleDescription(@Nullable CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      this.mInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", paramCharSequence);
    }
  }
  
  public void setScreenReaderFocusable(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.mInfo.setScreenReaderFocusable(paramBoolean);
      return;
    }
    setBooleanProperty(1, paramBoolean);
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.mInfo.setScrollable(paramBoolean);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.mInfo.setSelected(paramBoolean);
  }
  
  public void setShowingHintText(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.mInfo.setShowingHintText(paramBoolean);
      return;
    }
    setBooleanProperty(4, paramBoolean);
  }
  
  public void setSource(View paramView)
  {
    this.mVirtualDescendantId = -1;
    this.mInfo.setSource(paramView);
  }
  
  public void setSource(View paramView, int paramInt)
  {
    this.mVirtualDescendantId = paramInt;
    if (Build.VERSION.SDK_INT >= 16) {
      this.mInfo.setSource(paramView, paramInt);
    }
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.mInfo.setText(paramCharSequence);
  }
  
  public void setTextEntryKey(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      this.mInfo.setTextEntryKey(paramBoolean);
      return;
    }
    setBooleanProperty(8, paramBoolean);
  }
  
  public void setTextSelection(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.mInfo.setTextSelection(paramInt1, paramInt2);
    }
  }
  
  public void setTooltipText(@Nullable CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      this.mInfo.setTooltipText(paramCharSequence);
    }
    while (Build.VERSION.SDK_INT < 19) {
      return;
    }
    this.mInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY", paramCharSequence);
  }
  
  public void setTouchDelegateInfo(@NonNull AccessibilityNodeInfoCompat.TouchDelegateInfoCompat paramTouchDelegateInfoCompat)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      this.mInfo.setTouchDelegateInfo(paramTouchDelegateInfoCompat.mInfo);
    }
  }
  
  public void setTraversalAfter(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 22) {
      this.mInfo.setTraversalAfter(paramView);
    }
  }
  
  public void setTraversalAfter(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 22) {
      this.mInfo.setTraversalAfter(paramView, paramInt);
    }
  }
  
  public void setTraversalBefore(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 22) {
      this.mInfo.setTraversalBefore(paramView);
    }
  }
  
  public void setTraversalBefore(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 22) {
      this.mInfo.setTraversalBefore(paramView, paramInt);
    }
  }
  
  public void setViewIdResourceName(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.mInfo.setViewIdResourceName(paramString);
    }
  }
  
  public void setVisibleToUser(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.mInfo.setVisibleToUser(paramBoolean);
    }
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    Object localObject = new Rect();
    getBoundsInParent((Rect)localObject);
    localStringBuilder.append("; boundsInParent: " + localObject);
    getBoundsInScreen((Rect)localObject);
    localStringBuilder.append("; boundsInScreen: " + localObject);
    localStringBuilder.append("; packageName: ").append(getPackageName());
    localStringBuilder.append("; className: ").append(getClassName());
    localStringBuilder.append("; text: ").append(getText());
    localStringBuilder.append("; contentDescription: ").append(getContentDescription());
    localStringBuilder.append("; viewId: ").append(getViewIdResourceName());
    localStringBuilder.append("; checkable: ").append(isCheckable());
    localStringBuilder.append("; checked: ").append(isChecked());
    localStringBuilder.append("; focusable: ").append(isFocusable());
    localStringBuilder.append("; focused: ").append(isFocused());
    localStringBuilder.append("; selected: ").append(isSelected());
    localStringBuilder.append("; clickable: ").append(isClickable());
    localStringBuilder.append("; longClickable: ").append(isLongClickable());
    localStringBuilder.append("; enabled: ").append(isEnabled());
    localStringBuilder.append("; password: ").append(isPassword());
    localStringBuilder.append("; scrollable: " + isScrollable());
    localStringBuilder.append("; [");
    List localList;
    int i;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localList = getActionList();
      i = 0;
      if (i >= localList.size()) {
        break label525;
      }
      AccessibilityNodeInfoCompat.AccessibilityActionCompat localAccessibilityActionCompat = (AccessibilityNodeInfoCompat.AccessibilityActionCompat)localList.get(i);
      localObject = getActionSymbolicName(localAccessibilityActionCompat.getId());
      if ((!((String)localObject).equals("ACTION_UNKNOWN")) || (localAccessibilityActionCompat.getLabel() == null)) {
        break label540;
      }
      localObject = localAccessibilityActionCompat.getLabel().toString();
    }
    label525:
    label540:
    for (;;)
    {
      localStringBuilder.append((String)localObject);
      if (i != localList.size() - 1) {
        localStringBuilder.append(", ");
      }
      i += 1;
      break;
      i = getActions();
      while (i != 0)
      {
        int k = 1 << Integer.numberOfTrailingZeros(i);
        int j = i & (k ^ 0xFFFFFFFF);
        localStringBuilder.append(getActionSymbolicName(k));
        i = j;
        if (j != 0)
        {
          localStringBuilder.append(", ");
          i = j;
        }
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public AccessibilityNodeInfo unwrap()
  {
    return this.mInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 * JD-Core Version:    0.7.0.1
 */