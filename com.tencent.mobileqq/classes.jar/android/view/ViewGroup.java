package android.view;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LayoutAnimationController;
import android.view.animation.Transformation;
import java.util.ArrayList;

@SuppressLint({"NewApi"})
public abstract class ViewGroup
  extends View
  implements ViewManager, ViewParent
{
  protected static final int CLIP_TO_PADDING_MASK = 34;
  public static final int FOCUS_AFTER_DESCENDANTS = 262144;
  public static final int FOCUS_BEFORE_DESCENDANTS = 131072;
  public static final int FOCUS_BLOCK_DESCENDANTS = 393216;
  public static final int PERSISTENT_ALL_CACHES = 3;
  public static final int PERSISTENT_ANIMATION_CACHE = 1;
  public static final int PERSISTENT_NO_CACHE = 0;
  public static final int PERSISTENT_SCROLLING_CACHE = 2;
  public int mGroupFlags;
  public int mPersistentDrawingCache;
  
  public ViewGroup(Context paramContext)
  {
    super((Context)null, (AttributeSet)null, 0);
    throw new RuntimeException("Stub!");
  }
  
  public ViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super((Context)null, (AttributeSet)null, 0);
    throw new RuntimeException("Stub!");
  }
  
  public ViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super((Context)null, (AttributeSet)null, 0);
    throw new RuntimeException("Stub!");
  }
  
  public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean addStatesFromChildren()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void addView(View paramView)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void addView(View paramView, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void addView(View paramView, int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void attachLayoutAnimationParameters(View paramView, ViewGroup.LayoutParams paramLayoutParams, int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void bringChildToFront(View paramView)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean canAnimate()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean canResolveLayoutDirection()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean canResolveTextAlignment()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean canResolveTextDirection()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void childDrawableStateChanged(View paramView)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void childHasTransientStateChanged(View paramView, boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void cleanupLayoutState(View paramView)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void clearChildFocus(View paramView)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void clearDisappearingChildren()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void clearFocus()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void debug(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void detachAllViewsFromParent()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void detachViewFromParent(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void detachViewFromParent(View paramView)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void detachViewsFromParent(int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void dispatchDisplayHint(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean dispatchDragEvent(DragEvent paramDragEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void dispatchFreezeSelfOnly(SparseArray<Parcelable> paramSparseArray)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean dispatchGenericFocusedEvent(MotionEvent paramMotionEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean dispatchGenericPointerEvent(MotionEvent paramMotionEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void dispatchSetActivated(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void dispatchSetPressed(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void dispatchSetSelected(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void dispatchSystemUiVisibilityChanged(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void dispatchThawSelfOnly(SparseArray<Parcelable> paramSparseArray)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean dispatchUnhandledMove(View paramView, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void dispatchVisibilityChanged(View paramView, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void dispatchWindowFocusChanged(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void dispatchWindowVisibilityChanged(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void drawableStateChanged()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void endViewTransition(View paramView)
  {
    throw new RuntimeException("Stub!");
  }
  
  public View findFocus()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void findViewsWithText(ArrayList<View> paramArrayList, CharSequence paramCharSequence, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    throw new RuntimeException("Stub!");
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void focusableViewAvailable(View paramView)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean gatherTransparentRegion(Region paramRegion)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    throw new RuntimeException("Stub!");
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  public View getChildAt(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getChildCount()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean getChildVisibleRect(View paramView, Rect paramRect, Point paramPoint)
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty(category="focus", mapping={@ViewDebug.IntToString(from=131072, to="FOCUS_BEFORE_DESCENDANTS"), @ViewDebug.IntToString(from=262144, to="FOCUS_AFTER_DESCENDANTS"), @ViewDebug.IntToString(from=393216, to="FOCUS_BLOCK_DESCENDANTS")})
  public int getDescendantFocusability()
  {
    throw new RuntimeException("Stub!");
  }
  
  public View getFocusedChild()
  {
    throw new RuntimeException("Stub!");
  }
  
  public LayoutAnimationController getLayoutAnimation()
  {
    throw new RuntimeException("Stub!");
  }
  
  public Animation.AnimationListener getLayoutAnimationListener()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getLayoutDirection()
  {
    throw new RuntimeException("Stub!");
  }
  
  public LayoutTransition getLayoutTransition()
  {
    throw new RuntimeException("Stub!");
  }
  
  public ViewParent getParentForAccessibility()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty(category="drawing", mapping={@ViewDebug.IntToString(from=0, to="NONE"), @ViewDebug.IntToString(from=1, to="ANIMATION"), @ViewDebug.IntToString(from=2, to="SCROLLING"), @ViewDebug.IntToString(from=3, to="ALL")})
  public int getPersistentDrawingCache()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getTextAlignment()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getTextDirection()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean hasFocus()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean hasFocusable()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int indexOfChild(View paramView)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void invalidateChild(View paramView, Rect paramRect)
  {
    throw new RuntimeException("Stub!");
  }
  
  public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty(category="drawing")
  public boolean isAlwaysDrawnWithCacheEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty
  public boolean isAnimationCacheEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty(category="drawing")
  protected boolean isChildrenDrawingOrderEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  @ViewDebug.ExportedProperty(category="drawing")
  protected boolean isChildrenDrawnWithCacheEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isLayoutDirectionResolved()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isMotionEventSplittingEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isTextAlignmentResolved()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isTextDirectionResolved()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void jumpDrawablesToCurrentState()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void layout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void measureChildren(int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void notifySubtreeAccessibilityStateChanged(View paramView1, View paramView2, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void offsetChildrenTopAndBottom(int paramInt) {}
  
  public final void offsetDescendantRectToMyCoords(View paramView, Rect paramRect)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final void offsetRectIntoDescendantCoords(View paramView, Rect paramRect)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void onAnimationEnd()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void onAnimationStart()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean onInterceptHoverEvent(MotionEvent paramMotionEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected abstract void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean onNestedPrePerformAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean onRequestSendAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void onStopNestedScroll(View paramView)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void recomputeViewAttributes(View paramView)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void removeAllViews()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void removeAllViewsInLayout()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void removeDetachedView(View paramView, boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void removeView(View paramView)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void removeViewAt(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void removeViewInLayout(View paramView)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void removeViews(int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void removeViewsInLayout(int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void requestFitSystemWindows()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean requestSendAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void requestTransparentRegion(View paramView)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void resetResolvedLayoutDirection()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void resetResolvedTextDirection()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void scheduleLayoutAnimation()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setAddStatesFromChildren(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setAlwaysDrawnWithCacheEnabled(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setAnimationCacheEnabled(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setChildrenDrawingCacheEnabled(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setChildrenDrawingOrderEnabled(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setChildrenDrawnWithCacheEnabled(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setClipChildren(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setDescendantFocusability(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setLayoutAnimation(LayoutAnimationController paramLayoutAnimationController)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setLayoutAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setLayoutTransition(LayoutTransition paramLayoutTransition)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setMotionEventSplittingEnabled(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setPersistentDrawingCache(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void setStaticTransformationsEnabled(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean shouldDelayChildPressedState()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean showContextMenuForChild(View paramView)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean showContextMenuForChild(View paramView, float paramFloat1, float paramFloat2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback)
  {
    throw new RuntimeException("Stub!");
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback, int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void startLayoutAnimation()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void startViewTransition(View paramView)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.view.ViewGroup
 * JD-Core Version:    0.7.0.1
 */