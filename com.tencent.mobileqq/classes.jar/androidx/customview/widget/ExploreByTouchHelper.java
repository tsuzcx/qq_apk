package androidx.customview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewParentCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import java.util.ArrayList;
import java.util.List;

public abstract class ExploreByTouchHelper
  extends AccessibilityDelegateCompat
{
  private static final String DEFAULT_CLASS_NAME = "android.view.View";
  public static final int HOST_ID = -1;
  public static final int INVALID_ID = -2147483648;
  private static final Rect INVALID_PARENT_BOUNDS = new Rect(2147483647, 2147483647, -2147483648, -2147483648);
  private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER = new ExploreByTouchHelper.1();
  private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER = new ExploreByTouchHelper.2();
  int mAccessibilityFocusedVirtualViewId = -2147483648;
  private final View mHost;
  private int mHoveredVirtualViewId = -2147483648;
  int mKeyboardFocusedVirtualViewId = -2147483648;
  private final AccessibilityManager mManager;
  private ExploreByTouchHelper.MyNodeProvider mNodeProvider;
  private final int[] mTempGlobalRect = new int[2];
  private final Rect mTempParentRect = new Rect();
  private final Rect mTempScreenRect = new Rect();
  private final Rect mTempVisibleRect = new Rect();
  
  public ExploreByTouchHelper(@NonNull View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("View may not be null");
    }
    this.mHost = paramView;
    this.mManager = ((AccessibilityManager)paramView.getContext().getSystemService("accessibility"));
    paramView.setFocusable(true);
    if (ViewCompat.getImportantForAccessibility(paramView) == 0) {
      ViewCompat.setImportantForAccessibility(paramView, 1);
    }
  }
  
  private boolean clearAccessibilityFocus(int paramInt)
  {
    if (this.mAccessibilityFocusedVirtualViewId == paramInt)
    {
      this.mAccessibilityFocusedVirtualViewId = -2147483648;
      this.mHost.invalidate();
      sendEventForVirtualView(paramInt, 65536);
      return true;
    }
    return false;
  }
  
  private boolean clickKeyboardFocusedVirtualView()
  {
    return (this.mKeyboardFocusedVirtualViewId != -2147483648) && (onPerformActionForVirtualView(this.mKeyboardFocusedVirtualViewId, 16, null));
  }
  
  private AccessibilityEvent createEvent(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return createEventForChild(paramInt1, paramInt2);
    }
    return createEventForHost(paramInt2);
  }
  
  private AccessibilityEvent createEventForChild(int paramInt1, int paramInt2)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = obtainAccessibilityNodeInfo(paramInt1);
    localAccessibilityEvent.getText().add(localAccessibilityNodeInfoCompat.getText());
    localAccessibilityEvent.setContentDescription(localAccessibilityNodeInfoCompat.getContentDescription());
    localAccessibilityEvent.setScrollable(localAccessibilityNodeInfoCompat.isScrollable());
    localAccessibilityEvent.setPassword(localAccessibilityNodeInfoCompat.isPassword());
    localAccessibilityEvent.setEnabled(localAccessibilityNodeInfoCompat.isEnabled());
    localAccessibilityEvent.setChecked(localAccessibilityNodeInfoCompat.isChecked());
    onPopulateEventForVirtualView(paramInt1, localAccessibilityEvent);
    if ((localAccessibilityEvent.getText().isEmpty()) && (localAccessibilityEvent.getContentDescription() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }
    localAccessibilityEvent.setClassName(localAccessibilityNodeInfoCompat.getClassName());
    AccessibilityRecordCompat.setSource(localAccessibilityEvent, this.mHost, paramInt1);
    localAccessibilityEvent.setPackageName(this.mHost.getContext().getPackageName());
    return localAccessibilityEvent;
  }
  
  private AccessibilityEvent createEventForHost(int paramInt)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt);
    this.mHost.onInitializeAccessibilityEvent(localAccessibilityEvent);
    return localAccessibilityEvent;
  }
  
  @NonNull
  private AccessibilityNodeInfoCompat createNodeForChild(int paramInt)
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat1 = AccessibilityNodeInfoCompat.obtain();
    localAccessibilityNodeInfoCompat1.setEnabled(true);
    localAccessibilityNodeInfoCompat1.setFocusable(true);
    localAccessibilityNodeInfoCompat1.setClassName("android.view.View");
    localAccessibilityNodeInfoCompat1.setBoundsInParent(INVALID_PARENT_BOUNDS);
    localAccessibilityNodeInfoCompat1.setBoundsInScreen(INVALID_PARENT_BOUNDS);
    localAccessibilityNodeInfoCompat1.setParent(this.mHost);
    onPopulateNodeForVirtualView(paramInt, localAccessibilityNodeInfoCompat1);
    if ((localAccessibilityNodeInfoCompat1.getText() == null) && (localAccessibilityNodeInfoCompat1.getContentDescription() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
    }
    localAccessibilityNodeInfoCompat1.getBoundsInParent(this.mTempParentRect);
    if (this.mTempParentRect.equals(INVALID_PARENT_BOUNDS)) {
      throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }
    int i = localAccessibilityNodeInfoCompat1.getActions();
    if ((i & 0x40) != 0) {
      throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }
    if ((i & 0x80) != 0) {
      throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }
    localAccessibilityNodeInfoCompat1.setPackageName(this.mHost.getContext().getPackageName());
    localAccessibilityNodeInfoCompat1.setSource(this.mHost, paramInt);
    boolean bool;
    if (this.mAccessibilityFocusedVirtualViewId == paramInt)
    {
      localAccessibilityNodeInfoCompat1.setAccessibilityFocused(true);
      localAccessibilityNodeInfoCompat1.addAction(128);
      if (this.mKeyboardFocusedVirtualViewId != paramInt) {
        break label379;
      }
      bool = true;
      label216:
      if (!bool) {
        break label384;
      }
      localAccessibilityNodeInfoCompat1.addAction(2);
    }
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat2;
    for (;;)
    {
      localAccessibilityNodeInfoCompat1.setFocused(bool);
      this.mHost.getLocationOnScreen(this.mTempGlobalRect);
      localAccessibilityNodeInfoCompat1.getBoundsInScreen(this.mTempScreenRect);
      if (!this.mTempScreenRect.equals(INVALID_PARENT_BOUNDS)) {
        break label441;
      }
      localAccessibilityNodeInfoCompat1.getBoundsInParent(this.mTempScreenRect);
      if (localAccessibilityNodeInfoCompat1.mParentVirtualDescendantId == -1) {
        break label406;
      }
      localAccessibilityNodeInfoCompat2 = AccessibilityNodeInfoCompat.obtain();
      for (paramInt = localAccessibilityNodeInfoCompat1.mParentVirtualDescendantId; paramInt != -1; paramInt = localAccessibilityNodeInfoCompat2.mParentVirtualDescendantId)
      {
        localAccessibilityNodeInfoCompat2.setParent(this.mHost, -1);
        localAccessibilityNodeInfoCompat2.setBoundsInParent(INVALID_PARENT_BOUNDS);
        onPopulateNodeForVirtualView(paramInt, localAccessibilityNodeInfoCompat2);
        localAccessibilityNodeInfoCompat2.getBoundsInParent(this.mTempParentRect);
        this.mTempScreenRect.offset(this.mTempParentRect.left, this.mTempParentRect.top);
      }
      localAccessibilityNodeInfoCompat1.setAccessibilityFocused(false);
      localAccessibilityNodeInfoCompat1.addAction(64);
      break;
      label379:
      bool = false;
      break label216;
      label384:
      if (localAccessibilityNodeInfoCompat1.isFocusable()) {
        localAccessibilityNodeInfoCompat1.addAction(1);
      }
    }
    localAccessibilityNodeInfoCompat2.recycle();
    label406:
    this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
    label441:
    if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect))
    {
      this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
      if (this.mTempScreenRect.intersect(this.mTempVisibleRect))
      {
        localAccessibilityNodeInfoCompat1.setBoundsInScreen(this.mTempScreenRect);
        if (isVisibleToUser(this.mTempScreenRect)) {
          localAccessibilityNodeInfoCompat1.setVisibleToUser(true);
        }
      }
    }
    return localAccessibilityNodeInfoCompat1;
  }
  
  @NonNull
  private AccessibilityNodeInfoCompat createNodeForHost()
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(this.mHost);
    ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, localAccessibilityNodeInfoCompat);
    ArrayList localArrayList = new ArrayList();
    getVisibleVirtualViews(localArrayList);
    if ((localAccessibilityNodeInfoCompat.getChildCount() > 0) && (localArrayList.size() > 0)) {
      throw new RuntimeException("Views cannot have both real and virtual children");
    }
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      localAccessibilityNodeInfoCompat.addChild(this.mHost, ((Integer)localArrayList.get(i)).intValue());
      i += 1;
    }
    return localAccessibilityNodeInfoCompat;
  }
  
  private SparseArrayCompat<AccessibilityNodeInfoCompat> getAllNodes()
  {
    ArrayList localArrayList = new ArrayList();
    getVisibleVirtualViews(localArrayList);
    SparseArrayCompat localSparseArrayCompat = new SparseArrayCompat();
    int i = 0;
    while (i < localArrayList.size())
    {
      localSparseArrayCompat.put(i, createNodeForChild(i));
      i += 1;
    }
    return localSparseArrayCompat;
  }
  
  private void getBoundsInParent(int paramInt, Rect paramRect)
  {
    obtainAccessibilityNodeInfo(paramInt).getBoundsInParent(paramRect);
  }
  
  private static Rect guessPreviouslyFocusedRect(@NonNull View paramView, int paramInt, @NonNull Rect paramRect)
  {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
      paramRect.set(i, 0, i, j);
      return paramRect;
    case 33: 
      paramRect.set(0, j, i, j);
      return paramRect;
    case 66: 
      paramRect.set(-1, 0, -1, j);
      return paramRect;
    }
    paramRect.set(0, -1, i, -1);
    return paramRect;
  }
  
  private boolean isVisibleToUser(Rect paramRect)
  {
    if ((paramRect == null) || (paramRect.isEmpty())) {}
    while (this.mHost.getWindowVisibility() != 0) {
      return false;
    }
    for (paramRect = this.mHost.getParent();; paramRect = paramRect.getParent())
    {
      if (!(paramRect instanceof View)) {
        break label67;
      }
      paramRect = (View)paramRect;
      if ((paramRect.getAlpha() <= 0.0F) || (paramRect.getVisibility() != 0)) {
        break;
      }
    }
    label67:
    if (paramRect != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static int keyToDirection(int paramInt)
  {
    switch (paramInt)
    {
    case 20: 
    default: 
      return 130;
    case 21: 
      return 17;
    case 19: 
      return 33;
    }
    return 66;
  }
  
  private boolean moveFocus(int paramInt, @Nullable Rect paramRect)
  {
    boolean bool = true;
    SparseArrayCompat localSparseArrayCompat = getAllNodes();
    int i = this.mKeyboardFocusedVirtualViewId;
    if (i == -2147483648) {}
    for (AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = null;; localAccessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat)localSparseArrayCompat.get(i)) {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      }
    }
    if (ViewCompat.getLayoutDirection(this.mHost) == 1)
    {
      paramRect = (AccessibilityNodeInfoCompat)FocusStrategy.findNextFocusInRelativeDirection(localSparseArrayCompat, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, localAccessibilityNodeInfoCompat, paramInt, bool, false);
      if (paramRect != null) {
        break label238;
      }
    }
    label238:
    for (paramInt = -2147483648;; paramInt = localSparseArrayCompat.keyAt(localSparseArrayCompat.indexOfValue(paramRect)))
    {
      return requestKeyboardFocusForVirtualView(paramInt);
      bool = false;
      break;
      Rect localRect = new Rect();
      if (this.mKeyboardFocusedVirtualViewId != -2147483648) {
        getBoundsInParent(this.mKeyboardFocusedVirtualViewId, localRect);
      }
      for (;;)
      {
        paramRect = (AccessibilityNodeInfoCompat)FocusStrategy.findNextFocusInAbsoluteDirection(localSparseArrayCompat, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, localAccessibilityNodeInfoCompat, localRect, paramInt);
        break;
        if (paramRect != null) {
          localRect.set(paramRect);
        } else {
          guessPreviouslyFocusedRect(this.mHost, paramInt, localRect);
        }
      }
    }
  }
  
  private boolean performActionForChild(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    switch (paramInt2)
    {
    default: 
      return onPerformActionForVirtualView(paramInt1, paramInt2, paramBundle);
    case 64: 
      return requestAccessibilityFocus(paramInt1);
    case 128: 
      return clearAccessibilityFocus(paramInt1);
    case 1: 
      return requestKeyboardFocusForVirtualView(paramInt1);
    }
    return clearKeyboardFocusForVirtualView(paramInt1);
  }
  
  private boolean performActionForHost(int paramInt, Bundle paramBundle)
  {
    return ViewCompat.performAccessibilityAction(this.mHost, paramInt, paramBundle);
  }
  
  private boolean requestAccessibilityFocus(int paramInt)
  {
    if ((!this.mManager.isEnabled()) || (!this.mManager.isTouchExplorationEnabled())) {}
    while (this.mAccessibilityFocusedVirtualViewId == paramInt) {
      return false;
    }
    if (this.mAccessibilityFocusedVirtualViewId != -2147483648) {
      clearAccessibilityFocus(this.mAccessibilityFocusedVirtualViewId);
    }
    this.mAccessibilityFocusedVirtualViewId = paramInt;
    this.mHost.invalidate();
    sendEventForVirtualView(paramInt, 32768);
    return true;
  }
  
  private void updateHoveredVirtualView(int paramInt)
  {
    if (this.mHoveredVirtualViewId == paramInt) {
      return;
    }
    int i = this.mHoveredVirtualViewId;
    this.mHoveredVirtualViewId = paramInt;
    sendEventForVirtualView(paramInt, 128);
    sendEventForVirtualView(i, 256);
  }
  
  public final boolean clearKeyboardFocusForVirtualView(int paramInt)
  {
    if (this.mKeyboardFocusedVirtualViewId != paramInt) {
      return false;
    }
    this.mKeyboardFocusedVirtualViewId = -2147483648;
    onVirtualViewKeyboardFocusChanged(paramInt, false);
    sendEventForVirtualView(paramInt, 8);
    return true;
  }
  
  public final boolean dispatchHoverEvent(@NonNull MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((!this.mManager.isEnabled()) || (!this.mManager.isTouchExplorationEnabled())) {}
    do
    {
      return false;
      switch (paramMotionEvent.getAction())
      {
      case 8: 
      default: 
        return false;
      case 7: 
      case 9: 
        int i = getVirtualViewAt(paramMotionEvent.getX(), paramMotionEvent.getY());
        updateHoveredVirtualView(i);
        if (i != -2147483648) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
    } while (this.mHoveredVirtualViewId == -2147483648);
    updateHoveredVirtualView(-2147483648);
    return true;
  }
  
  public final boolean dispatchKeyEvent(@NonNull KeyEvent paramKeyEvent)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    int i;
    if (paramKeyEvent.getAction() != 1)
    {
      i = paramKeyEvent.getKeyCode();
      switch (i)
      {
      default: 
        bool2 = bool1;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool2;
            bool2 = bool1;
          } while (!paramKeyEvent.hasNoModifiers());
          int j = keyToDirection(i);
          int k = paramKeyEvent.getRepeatCount();
          i = 0;
          for (bool1 = bool3;; bool1 = true)
          {
            bool2 = bool1;
            if (i >= k + 1) {
              break;
            }
            bool2 = bool1;
            if (!moveFocus(j, null)) {
              break;
            }
            i += 1;
          }
          bool2 = bool1;
        } while (!paramKeyEvent.hasNoModifiers());
        bool2 = bool1;
      } while (paramKeyEvent.getRepeatCount() != 0);
      clickKeyboardFocusedVirtualView();
      return true;
      if (paramKeyEvent.hasNoModifiers()) {
        return moveFocus(2, null);
      }
      bool2 = bool1;
    } while (!paramKeyEvent.hasModifiers(1));
    return moveFocus(1, null);
  }
  
  public final int getAccessibilityFocusedVirtualViewId()
  {
    return this.mAccessibilityFocusedVirtualViewId;
  }
  
  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
  {
    if (this.mNodeProvider == null) {
      this.mNodeProvider = new ExploreByTouchHelper.MyNodeProvider(this);
    }
    return this.mNodeProvider;
  }
  
  @Deprecated
  public int getFocusedVirtualView()
  {
    return getAccessibilityFocusedVirtualViewId();
  }
  
  public final int getKeyboardFocusedVirtualViewId()
  {
    return this.mKeyboardFocusedVirtualViewId;
  }
  
  protected abstract int getVirtualViewAt(float paramFloat1, float paramFloat2);
  
  protected abstract void getVisibleVirtualViews(List<Integer> paramList);
  
  public final void invalidateRoot()
  {
    invalidateVirtualView(-1, 1);
  }
  
  public final void invalidateVirtualView(int paramInt)
  {
    invalidateVirtualView(paramInt, 0);
  }
  
  public final void invalidateVirtualView(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != -2147483648) && (this.mManager.isEnabled()))
    {
      ViewParent localViewParent = this.mHost.getParent();
      if (localViewParent != null)
      {
        AccessibilityEvent localAccessibilityEvent = createEvent(paramInt1, 2048);
        AccessibilityEventCompat.setContentChangeTypes(localAccessibilityEvent, paramInt2);
        ViewParentCompat.requestSendAccessibilityEvent(localViewParent, this.mHost, localAccessibilityEvent);
      }
    }
  }
  
  @NonNull
  AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int paramInt)
  {
    if (paramInt == -1) {
      return createNodeForHost();
    }
    return createNodeForChild(paramInt);
  }
  
  public final void onFocusChanged(boolean paramBoolean, int paramInt, @Nullable Rect paramRect)
  {
    if (this.mKeyboardFocusedVirtualViewId != -2147483648) {
      clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId);
    }
    if (paramBoolean) {
      moveFocus(paramInt, paramRect);
    }
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    onPopulateEventForHost(paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    onPopulateNodeForHost(paramAccessibilityNodeInfoCompat);
  }
  
  protected abstract boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, @Nullable Bundle paramBundle);
  
  protected void onPopulateEventForHost(@NonNull AccessibilityEvent paramAccessibilityEvent) {}
  
  protected void onPopulateEventForVirtualView(int paramInt, @NonNull AccessibilityEvent paramAccessibilityEvent) {}
  
  protected void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {}
  
  protected abstract void onPopulateNodeForVirtualView(int paramInt, @NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat);
  
  protected void onVirtualViewKeyboardFocusChanged(int paramInt, boolean paramBoolean) {}
  
  boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    switch (paramInt1)
    {
    default: 
      return performActionForChild(paramInt1, paramInt2, paramBundle);
    }
    return performActionForHost(paramInt2, paramBundle);
  }
  
  public final boolean requestKeyboardFocusForVirtualView(int paramInt)
  {
    if ((!this.mHost.isFocused()) && (!this.mHost.requestFocus())) {}
    while (this.mKeyboardFocusedVirtualViewId == paramInt) {
      return false;
    }
    if (this.mKeyboardFocusedVirtualViewId != -2147483648) {
      clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId);
    }
    this.mKeyboardFocusedVirtualViewId = paramInt;
    onVirtualViewKeyboardFocusChanged(paramInt, true);
    sendEventForVirtualView(paramInt, 8);
    return true;
  }
  
  public final boolean sendEventForVirtualView(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == -2147483648) || (!this.mManager.isEnabled())) {}
    ViewParent localViewParent;
    do
    {
      return false;
      localViewParent = this.mHost.getParent();
    } while (localViewParent == null);
    AccessibilityEvent localAccessibilityEvent = createEvent(paramInt1, paramInt2);
    return ViewParentCompat.requestSendAccessibilityEvent(localViewParent, this.mHost, localAccessibilityEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.customview.widget.ExploreByTouchHelper
 * JD-Core Version:    0.7.0.1
 */