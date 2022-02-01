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
    if (paramView != null)
    {
      this.mHost = paramView;
      this.mManager = ((AccessibilityManager)paramView.getContext().getSystemService("accessibility"));
      paramView.setFocusable(true);
      if (ViewCompat.getImportantForAccessibility(paramView) == 0) {
        ViewCompat.setImportantForAccessibility(paramView, 1);
      }
      return;
    }
    throw new IllegalArgumentException("View may not be null");
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
    int i = this.mKeyboardFocusedVirtualViewId;
    return (i != -2147483648) && (onPerformActionForVirtualView(i, 16, null));
  }
  
  private AccessibilityEvent createEvent(int paramInt1, int paramInt2)
  {
    if (paramInt1 != -1) {
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
    Object localObject = AccessibilityNodeInfoCompat.obtain();
    ((AccessibilityNodeInfoCompat)localObject).setEnabled(true);
    ((AccessibilityNodeInfoCompat)localObject).setFocusable(true);
    ((AccessibilityNodeInfoCompat)localObject).setClassName("android.view.View");
    ((AccessibilityNodeInfoCompat)localObject).setBoundsInParent(INVALID_PARENT_BOUNDS);
    ((AccessibilityNodeInfoCompat)localObject).setBoundsInScreen(INVALID_PARENT_BOUNDS);
    ((AccessibilityNodeInfoCompat)localObject).setParent(this.mHost);
    onPopulateNodeForVirtualView(paramInt, (AccessibilityNodeInfoCompat)localObject);
    if ((((AccessibilityNodeInfoCompat)localObject).getText() == null) && (((AccessibilityNodeInfoCompat)localObject).getContentDescription() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
    }
    ((AccessibilityNodeInfoCompat)localObject).getBoundsInParent(this.mTempParentRect);
    if (!this.mTempParentRect.equals(INVALID_PARENT_BOUNDS))
    {
      int i = ((AccessibilityNodeInfoCompat)localObject).getActions();
      if ((i & 0x40) == 0)
      {
        if ((i & 0x80) == 0)
        {
          ((AccessibilityNodeInfoCompat)localObject).setPackageName(this.mHost.getContext().getPackageName());
          ((AccessibilityNodeInfoCompat)localObject).setSource(this.mHost, paramInt);
          if (this.mAccessibilityFocusedVirtualViewId == paramInt)
          {
            ((AccessibilityNodeInfoCompat)localObject).setAccessibilityFocused(true);
            ((AccessibilityNodeInfoCompat)localObject).addAction(128);
          }
          else
          {
            ((AccessibilityNodeInfoCompat)localObject).setAccessibilityFocused(false);
            ((AccessibilityNodeInfoCompat)localObject).addAction(64);
          }
          boolean bool;
          if (this.mKeyboardFocusedVirtualViewId == paramInt) {
            bool = true;
          } else {
            bool = false;
          }
          if (bool) {
            ((AccessibilityNodeInfoCompat)localObject).addAction(2);
          } else if (((AccessibilityNodeInfoCompat)localObject).isFocusable()) {
            ((AccessibilityNodeInfoCompat)localObject).addAction(1);
          }
          ((AccessibilityNodeInfoCompat)localObject).setFocused(bool);
          this.mHost.getLocationOnScreen(this.mTempGlobalRect);
          ((AccessibilityNodeInfoCompat)localObject).getBoundsInScreen(this.mTempScreenRect);
          if (this.mTempScreenRect.equals(INVALID_PARENT_BOUNDS))
          {
            ((AccessibilityNodeInfoCompat)localObject).getBoundsInParent(this.mTempScreenRect);
            if (((AccessibilityNodeInfoCompat)localObject).mParentVirtualDescendantId != -1)
            {
              AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain();
              for (paramInt = ((AccessibilityNodeInfoCompat)localObject).mParentVirtualDescendantId; paramInt != -1; paramInt = localAccessibilityNodeInfoCompat.mParentVirtualDescendantId)
              {
                localAccessibilityNodeInfoCompat.setParent(this.mHost, -1);
                localAccessibilityNodeInfoCompat.setBoundsInParent(INVALID_PARENT_BOUNDS);
                onPopulateNodeForVirtualView(paramInt, localAccessibilityNodeInfoCompat);
                localAccessibilityNodeInfoCompat.getBoundsInParent(this.mTempParentRect);
                this.mTempScreenRect.offset(this.mTempParentRect.left, this.mTempParentRect.top);
              }
              localAccessibilityNodeInfoCompat.recycle();
            }
            this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
          }
          if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect))
          {
            this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
            if (this.mTempScreenRect.intersect(this.mTempVisibleRect))
            {
              ((AccessibilityNodeInfoCompat)localObject).setBoundsInScreen(this.mTempScreenRect);
              if (isVisibleToUser(this.mTempScreenRect)) {
                ((AccessibilityNodeInfoCompat)localObject).setVisibleToUser(true);
              }
            }
          }
          return localObject;
        }
        throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
      }
      throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }
    localObject = new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
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
    int i = 0;
    int j = localArrayList.size();
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
    if (paramInt != 17)
    {
      if (paramInt != 33)
      {
        if (paramInt != 66)
        {
          if (paramInt == 130)
          {
            paramRect.set(0, -1, i, -1);
            return paramRect;
          }
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        paramRect.set(-1, 0, -1, j);
        return paramRect;
      }
      paramRect.set(0, j, i, j);
      return paramRect;
    }
    paramRect.set(i, 0, i, j);
    return paramRect;
  }
  
  private boolean isVisibleToUser(Rect paramRect)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramRect != null)
    {
      if (paramRect.isEmpty()) {
        return false;
      }
      if (this.mHost.getWindowVisibility() != 0) {
        return false;
      }
      paramRect = this.mHost.getParent();
      while ((paramRect instanceof View))
      {
        paramRect = (View)paramRect;
        if (paramRect.getAlpha() > 0.0F)
        {
          if (paramRect.getVisibility() != 0) {
            return false;
          }
          paramRect = paramRect.getParent();
        }
        else
        {
          return false;
        }
      }
      bool1 = bool2;
      if (paramRect != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static int keyToDirection(int paramInt)
  {
    if (paramInt != 19)
    {
      if (paramInt != 21)
      {
        if (paramInt != 22) {
          return 130;
        }
        return 66;
      }
      return 17;
    }
    return 33;
  }
  
  private boolean moveFocus(int paramInt, @Nullable Rect paramRect)
  {
    SparseArrayCompat localSparseArrayCompat = getAllNodes();
    int j = this.mKeyboardFocusedVirtualViewId;
    int i = -2147483648;
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat;
    if (j == -2147483648) {
      localAccessibilityNodeInfoCompat = null;
    } else {
      localAccessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat)localSparseArrayCompat.get(j);
    }
    if ((paramInt != 1) && (paramInt != 2))
    {
      if ((paramInt != 17) && (paramInt != 33) && (paramInt != 66) && (paramInt != 130)) {
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      }
      Rect localRect = new Rect();
      j = this.mKeyboardFocusedVirtualViewId;
      if (j != -2147483648) {
        getBoundsInParent(j, localRect);
      } else if (paramRect != null) {
        localRect.set(paramRect);
      } else {
        guessPreviouslyFocusedRect(this.mHost, paramInt, localRect);
      }
      paramRect = (AccessibilityNodeInfoCompat)FocusStrategy.findNextFocusInAbsoluteDirection(localSparseArrayCompat, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, localAccessibilityNodeInfoCompat, localRect, paramInt);
    }
    else
    {
      boolean bool;
      if (ViewCompat.getLayoutDirection(this.mHost) == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramRect = (AccessibilityNodeInfoCompat)FocusStrategy.findNextFocusInRelativeDirection(localSparseArrayCompat, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, localAccessibilityNodeInfoCompat, paramInt, bool, false);
    }
    if (paramRect == null) {
      paramInt = i;
    } else {
      paramInt = localSparseArrayCompat.keyAt(localSparseArrayCompat.indexOfValue(paramRect));
    }
    return requestKeyboardFocusForVirtualView(paramInt);
  }
  
  private boolean performActionForChild(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramInt2 != 1)
    {
      if (paramInt2 != 2)
      {
        if (paramInt2 != 64)
        {
          if (paramInt2 != 128) {
            return onPerformActionForVirtualView(paramInt1, paramInt2, paramBundle);
          }
          return clearAccessibilityFocus(paramInt1);
        }
        return requestAccessibilityFocus(paramInt1);
      }
      return clearKeyboardFocusForVirtualView(paramInt1);
    }
    return requestKeyboardFocusForVirtualView(paramInt1);
  }
  
  private boolean performActionForHost(int paramInt, Bundle paramBundle)
  {
    return ViewCompat.performAccessibilityAction(this.mHost, paramInt, paramBundle);
  }
  
  private boolean requestAccessibilityFocus(int paramInt)
  {
    if (this.mManager.isEnabled())
    {
      if (!this.mManager.isTouchExplorationEnabled()) {
        return false;
      }
      int i = this.mAccessibilityFocusedVirtualViewId;
      if (i != paramInt)
      {
        if (i != -2147483648) {
          clearAccessibilityFocus(i);
        }
        this.mAccessibilityFocusedVirtualViewId = paramInt;
        this.mHost.invalidate();
        sendEventForVirtualView(paramInt, 32768);
        return true;
      }
    }
    return false;
  }
  
  private void updateHoveredVirtualView(int paramInt)
  {
    int i = this.mHoveredVirtualViewId;
    if (i == paramInt) {
      return;
    }
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
    boolean bool3 = this.mManager.isEnabled();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      if (!this.mManager.isTouchExplorationEnabled()) {
        return false;
      }
      int i = paramMotionEvent.getAction();
      if ((i != 7) && (i != 9))
      {
        if (i != 10) {
          return false;
        }
        if (this.mHoveredVirtualViewId != -2147483648)
        {
          updateHoveredVirtualView(-2147483648);
          return true;
        }
        return false;
      }
      i = getVirtualViewAt(paramMotionEvent.getX(), paramMotionEvent.getY());
      updateHoveredVirtualView(i);
      bool1 = bool2;
      if (i != -2147483648) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean dispatchKeyEvent(@NonNull KeyEvent paramKeyEvent)
  {
    int j = paramKeyEvent.getAction();
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = bool2;
    if (j != 1)
    {
      j = paramKeyEvent.getKeyCode();
      if (j != 61)
      {
        if (j != 66)
        {
          switch (j)
          {
          default: 
            return false;
          case 19: 
          case 20: 
          case 21: 
          case 22: 
            bool1 = bool2;
            if (!paramKeyEvent.hasNoModifiers()) {
              break;
            }
            j = keyToDirection(j);
            int k = paramKeyEvent.getRepeatCount();
            for (bool1 = false; (i < k + 1) && (moveFocus(j, null)); bool1 = true) {
              i += 1;
            }
            return bool1;
          }
        }
        else
        {
          bool1 = bool2;
          if (paramKeyEvent.hasNoModifiers())
          {
            bool1 = bool2;
            if (paramKeyEvent.getRepeatCount() == 0)
            {
              clickKeyboardFocusedVirtualView();
              return true;
            }
          }
        }
      }
      else
      {
        if (paramKeyEvent.hasNoModifiers()) {
          return moveFocus(2, null);
        }
        bool1 = bool2;
        if (paramKeyEvent.hasModifiers(1)) {
          bool1 = moveFocus(1, null);
        }
      }
    }
    return bool1;
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
    int i = this.mKeyboardFocusedVirtualViewId;
    if (i != -2147483648) {
      clearKeyboardFocusForVirtualView(i);
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
    if (paramInt1 != -1) {
      return performActionForChild(paramInt1, paramInt2, paramBundle);
    }
    return performActionForHost(paramInt2, paramBundle);
  }
  
  public final boolean requestKeyboardFocusForVirtualView(int paramInt)
  {
    if ((!this.mHost.isFocused()) && (!this.mHost.requestFocus())) {
      return false;
    }
    int i = this.mKeyboardFocusedVirtualViewId;
    if (i == paramInt) {
      return false;
    }
    if (i != -2147483648) {
      clearKeyboardFocusForVirtualView(i);
    }
    this.mKeyboardFocusedVirtualViewId = paramInt;
    onVirtualViewKeyboardFocusChanged(paramInt, true);
    sendEventForVirtualView(paramInt, 8);
    return true;
  }
  
  public final boolean sendEventForVirtualView(int paramInt1, int paramInt2)
  {
    if (paramInt1 != -2147483648)
    {
      if (!this.mManager.isEnabled()) {
        return false;
      }
      ViewParent localViewParent = this.mHost.getParent();
      if (localViewParent == null) {
        return false;
      }
      AccessibilityEvent localAccessibilityEvent = createEvent(paramInt1, paramInt2);
      return ViewParentCompat.requestSendAccessibilityEvent(localViewParent, this.mHost, localAccessibilityEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.customview.widget.ExploreByTouchHelper
 * JD-Core Version:    0.7.0.1
 */