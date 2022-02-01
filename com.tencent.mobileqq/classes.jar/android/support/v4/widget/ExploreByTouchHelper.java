package android.support.v4.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class ExploreByTouchHelper
  extends AccessibilityDelegateCompat
{
  private static final String DEFAULT_CLASS_NAME = View.class.getName();
  public static final int INVALID_ID = -2147483648;
  private int mFocusedVirtualViewId = -2147483648;
  private int mHoveredVirtualViewId = -2147483648;
  private final AccessibilityManager mManager;
  private ExploreByTouchHelper.ExploreByTouchNodeProvider mNodeProvider;
  private final int[] mTempGlobalRect = new int[2];
  private final Rect mTempParentRect = new Rect();
  private final Rect mTempScreenRect = new Rect();
  private final Rect mTempVisibleRect = new Rect();
  private final View mView;
  
  public ExploreByTouchHelper(View paramView)
  {
    if (paramView != null)
    {
      this.mView = paramView;
      this.mManager = ((AccessibilityManager)paramView.getContext().getSystemService("accessibility"));
      return;
    }
    throw new IllegalArgumentException("View may not be null");
  }
  
  private boolean clearAccessibilityFocus(int paramInt)
  {
    if (isAccessibilityFocused(paramInt))
    {
      this.mFocusedVirtualViewId = -2147483648;
      this.mView.invalidate();
      sendEventForVirtualView(paramInt, 65536);
      return true;
    }
    return false;
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
    localAccessibilityEvent.setEnabled(true);
    localAccessibilityEvent.setClassName(DEFAULT_CLASS_NAME);
    onPopulateEventForVirtualView(paramInt1, localAccessibilityEvent);
    if ((localAccessibilityEvent.getText().isEmpty()) && (localAccessibilityEvent.getContentDescription() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }
    localAccessibilityEvent.setPackageName(this.mView.getContext().getPackageName());
    localAccessibilityEvent.setSource(this.mView, paramInt1);
    return localAccessibilityEvent;
  }
  
  private AccessibilityEvent createEventForHost(int paramInt)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt);
    ViewCompat.onInitializeAccessibilityEvent(this.mView, localAccessibilityEvent);
    return localAccessibilityEvent;
  }
  
  private AccessibilityNodeInfoCompat createNode(int paramInt)
  {
    if (paramInt != -1) {
      return createNodeForChild(paramInt);
    }
    return createNodeForHost();
  }
  
  private AccessibilityNodeInfoCompat createNodeForChild(int paramInt)
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain();
    localAccessibilityNodeInfoCompat.setEnabled(true);
    localAccessibilityNodeInfoCompat.setClassName(DEFAULT_CLASS_NAME);
    onPopulateNodeForVirtualView(paramInt, localAccessibilityNodeInfoCompat);
    if ((localAccessibilityNodeInfoCompat.getText() == null) && (localAccessibilityNodeInfoCompat.getContentDescription() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
    }
    localAccessibilityNodeInfoCompat.getBoundsInParent(this.mTempParentRect);
    if (!this.mTempParentRect.isEmpty())
    {
      int i = localAccessibilityNodeInfoCompat.getActions();
      if ((i & 0x40) == 0)
      {
        if ((i & 0x80) == 0)
        {
          localAccessibilityNodeInfoCompat.setPackageName(this.mView.getContext().getPackageName());
          localAccessibilityNodeInfoCompat.setSource(this.mView, paramInt);
          localAccessibilityNodeInfoCompat.setParent(this.mView);
          if (this.mFocusedVirtualViewId == paramInt)
          {
            localAccessibilityNodeInfoCompat.setAccessibilityFocused(true);
            localAccessibilityNodeInfoCompat.addAction(128);
          }
          else
          {
            localAccessibilityNodeInfoCompat.setAccessibilityFocused(false);
            localAccessibilityNodeInfoCompat.addAction(64);
          }
          if (intersectVisibleToUser(this.mTempParentRect))
          {
            localAccessibilityNodeInfoCompat.setVisibleToUser(true);
            localAccessibilityNodeInfoCompat.setBoundsInParent(this.mTempParentRect);
          }
          this.mView.getLocationOnScreen(this.mTempGlobalRect);
          localObject = this.mTempGlobalRect;
          paramInt = localObject[0];
          i = localObject[1];
          this.mTempScreenRect.set(this.mTempParentRect);
          this.mTempScreenRect.offset(paramInt, i);
          localAccessibilityNodeInfoCompat.setBoundsInScreen(this.mTempScreenRect);
          return localAccessibilityNodeInfoCompat;
        }
        throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
      }
      throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Callbacks must set parent bounds in populateNodeForVirtualViewId(), Rect(");
    ((StringBuilder)localObject).append(this.mTempParentRect.left);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(this.mTempParentRect.top);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(this.mTempParentRect.right);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(this.mTempParentRect.bottom);
    ((StringBuilder)localObject).append("), nodeText(");
    ((StringBuilder)localObject).append(localAccessibilityNodeInfoCompat.getContentDescription());
    ((StringBuilder)localObject).append(")");
    throw new RuntimeException(((StringBuilder)localObject).toString());
  }
  
  private AccessibilityNodeInfoCompat createNodeForHost()
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(this.mView);
    ViewCompat.onInitializeAccessibilityNodeInfo(this.mView, localAccessibilityNodeInfoCompat);
    Object localObject = new LinkedList();
    getVisibleVirtualViews((List)localObject);
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      localAccessibilityNodeInfoCompat.addChild(this.mView, localInteger.intValue());
    }
    return localAccessibilityNodeInfoCompat;
  }
  
  private boolean intersectVisibleToUser(Rect paramRect)
  {
    if (paramRect != null)
    {
      if (paramRect.isEmpty()) {
        return false;
      }
      if (this.mView.getWindowVisibility() != 0) {
        return false;
      }
      Object localObject = this.mView.getParent();
      while ((localObject instanceof View))
      {
        localObject = (View)localObject;
        if (((View)localObject).getAlpha() > 0.0F)
        {
          if (((View)localObject).getVisibility() != 0) {
            return false;
          }
          localObject = ((View)localObject).getParent();
        }
        else
        {
          return false;
        }
      }
      if (localObject == null) {
        return false;
      }
      if (!this.mView.getLocalVisibleRect(this.mTempVisibleRect)) {
        return false;
      }
      return paramRect.intersect(this.mTempVisibleRect);
    }
    return false;
  }
  
  private boolean isAccessibilityFocused(int paramInt)
  {
    return this.mFocusedVirtualViewId == paramInt;
  }
  
  private boolean manageFocusForChild(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramInt2 != 64)
    {
      if (paramInt2 != 128) {
        return false;
      }
      return clearAccessibilityFocus(paramInt1);
    }
    return requestAccessibilityFocus(paramInt1);
  }
  
  private boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramInt1 != -1) {
      return performActionForChild(paramInt1, paramInt2, paramBundle);
    }
    return performActionForHost(paramInt2, paramBundle);
  }
  
  private boolean performActionForChild(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if ((paramInt2 != 64) && (paramInt2 != 128)) {
      return onPerformActionForVirtualView(paramInt1, paramInt2, paramBundle);
    }
    return manageFocusForChild(paramInt1, paramInt2, paramBundle);
  }
  
  private boolean performActionForHost(int paramInt, Bundle paramBundle)
  {
    return ViewCompat.performAccessibilityAction(this.mView, paramInt, paramBundle);
  }
  
  private boolean requestAccessibilityFocus(int paramInt)
  {
    if (this.mManager.isEnabled())
    {
      if (!this.mManager.isTouchExplorationEnabled()) {
        return false;
      }
      if (!isAccessibilityFocused(paramInt))
      {
        this.mFocusedVirtualViewId = paramInt;
        this.mView.invalidate();
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
  
  public boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
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
        if (this.mFocusedVirtualViewId != -2147483648)
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
  
  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
  {
    if (this.mNodeProvider == null) {
      this.mNodeProvider = new ExploreByTouchHelper.ExploreByTouchNodeProvider(this, null);
    }
    return this.mNodeProvider;
  }
  
  public int getFocusedVirtualView()
  {
    return this.mFocusedVirtualViewId;
  }
  
  protected abstract int getVirtualViewAt(float paramFloat1, float paramFloat2);
  
  protected abstract void getVisibleVirtualViews(List<Integer> paramList);
  
  public void invalidateRoot()
  {
    invalidateVirtualView(-1);
  }
  
  public void invalidateVirtualView(int paramInt)
  {
    sendEventForVirtualView(paramInt, 2048);
  }
  
  protected abstract boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle);
  
  protected abstract void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent);
  
  protected abstract void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat);
  
  public boolean sendEventForVirtualView(int paramInt1, int paramInt2)
  {
    if (paramInt1 != -2147483648)
    {
      if (!this.mManager.isEnabled()) {
        return false;
      }
      ViewParent localViewParent = this.mView.getParent();
      if (localViewParent == null) {
        return false;
      }
      AccessibilityEvent localAccessibilityEvent = createEvent(paramInt1, paramInt2);
      return localViewParent.requestSendAccessibilityEvent(this.mView, localAccessibilityEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.widget.ExploreByTouchHelper
 * JD-Core Version:    0.7.0.1
 */