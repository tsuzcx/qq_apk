package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

class ViewCompat$BaseViewCompatImpl
  implements ViewCompat.ViewCompatImpl
{
  private Method mDispatchFinishTemporaryDetach;
  private Method mDispatchStartTemporaryDetach;
  private boolean mTempDetachBound;
  WeakHashMap<View, ViewPropertyAnimatorCompat> mViewPropertyAnimatorCompatMap = null;
  
  private void bindTempDetach()
  {
    try
    {
      this.mDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
      this.mDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
      this.mTempDetachBound = true;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Log.e("ViewCompat", "Couldn't find method", localNoSuchMethodException);
      }
    }
  }
  
  private boolean canScrollingViewScrollHorizontally(ScrollingView paramScrollingView, int paramInt)
  {
    boolean bool = true;
    int i = paramScrollingView.computeHorizontalScrollOffset();
    int j = paramScrollingView.computeHorizontalScrollRange() - paramScrollingView.computeHorizontalScrollExtent();
    if (j == 0) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (paramInt >= 0) {
          break;
        }
      } while (i > 0);
      return false;
    } while (i < j - 1);
    return false;
  }
  
  private boolean canScrollingViewScrollVertically(ScrollingView paramScrollingView, int paramInt)
  {
    boolean bool = true;
    int i = paramScrollingView.computeVerticalScrollOffset();
    int j = paramScrollingView.computeVerticalScrollRange() - paramScrollingView.computeVerticalScrollExtent();
    if (j == 0) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (paramInt >= 0) {
          break;
        }
      } while (i > 0);
      return false;
    } while (i < j - 1);
    return false;
  }
  
  public ViewPropertyAnimatorCompat animate(View paramView)
  {
    return new ViewPropertyAnimatorCompat(paramView);
  }
  
  public boolean canScrollHorizontally(View paramView, int paramInt)
  {
    return ((paramView instanceof ScrollingView)) && (canScrollingViewScrollHorizontally((ScrollingView)paramView, paramInt));
  }
  
  public boolean canScrollVertically(View paramView, int paramInt)
  {
    return ((paramView instanceof ScrollingView)) && (canScrollingViewScrollVertically((ScrollingView)paramView, paramInt));
  }
  
  public int combineMeasuredStates(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }
  
  public WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    return paramWindowInsetsCompat;
  }
  
  public void dispatchFinishTemporaryDetach(View paramView)
  {
    if (!this.mTempDetachBound) {
      bindTempDetach();
    }
    if (this.mDispatchFinishTemporaryDetach != null) {
      try
      {
        this.mDispatchFinishTemporaryDetach.invoke(paramView, new Object[0]);
        return;
      }
      catch (Exception paramView)
      {
        Log.d("ViewCompat", "Error calling dispatchFinishTemporaryDetach", paramView);
        return;
      }
    }
    paramView.onFinishTemporaryDetach();
  }
  
  public boolean dispatchNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    }
    return false;
  }
  
  public boolean dispatchNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).dispatchNestedPreFling(paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public boolean dispatchNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    }
    return false;
  }
  
  public boolean dispatchNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    }
    return false;
  }
  
  public void dispatchStartTemporaryDetach(View paramView)
  {
    if (!this.mTempDetachBound) {
      bindTempDetach();
    }
    if (this.mDispatchStartTemporaryDetach != null) {
      try
      {
        this.mDispatchStartTemporaryDetach.invoke(paramView, new Object[0]);
        return;
      }
      catch (Exception paramView)
      {
        Log.d("ViewCompat", "Error calling dispatchStartTemporaryDetach", paramView);
        return;
      }
    }
    paramView.onStartTemporaryDetach();
  }
  
  public int getAccessibilityLiveRegion(View paramView)
  {
    return 0;
  }
  
  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
  {
    return null;
  }
  
  public float getAlpha(View paramView)
  {
    return 1.0F;
  }
  
  public ColorStateList getBackgroundTintList(View paramView)
  {
    return ViewCompatBase.getBackgroundTintList(paramView);
  }
  
  public PorterDuff.Mode getBackgroundTintMode(View paramView)
  {
    return ViewCompatBase.getBackgroundTintMode(paramView);
  }
  
  public Rect getClipBounds(View paramView)
  {
    return null;
  }
  
  public float getElevation(View paramView)
  {
    return 0.0F;
  }
  
  public boolean getFitsSystemWindows(View paramView)
  {
    return false;
  }
  
  long getFrameTime()
  {
    return 10L;
  }
  
  public int getImportantForAccessibility(View paramView)
  {
    return 0;
  }
  
  public int getLabelFor(View paramView)
  {
    return 0;
  }
  
  public int getLayerType(View paramView)
  {
    return 0;
  }
  
  public int getLayoutDirection(View paramView)
  {
    return 0;
  }
  
  public int getMeasuredHeightAndState(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  public int getMeasuredState(View paramView)
  {
    return 0;
  }
  
  public int getMeasuredWidthAndState(View paramView)
  {
    return paramView.getMeasuredWidth();
  }
  
  public int getMinimumHeight(View paramView)
  {
    return ViewCompatBase.getMinimumHeight(paramView);
  }
  
  public int getMinimumWidth(View paramView)
  {
    return ViewCompatBase.getMinimumWidth(paramView);
  }
  
  public int getOverScrollMode(View paramView)
  {
    return 2;
  }
  
  public int getPaddingEnd(View paramView)
  {
    return paramView.getPaddingRight();
  }
  
  public int getPaddingStart(View paramView)
  {
    return paramView.getPaddingLeft();
  }
  
  public ViewParent getParentForAccessibility(View paramView)
  {
    return paramView.getParent();
  }
  
  public float getPivotX(View paramView)
  {
    return 0.0F;
  }
  
  public float getPivotY(View paramView)
  {
    return 0.0F;
  }
  
  public float getRotation(View paramView)
  {
    return 0.0F;
  }
  
  public float getRotationX(View paramView)
  {
    return 0.0F;
  }
  
  public float getRotationY(View paramView)
  {
    return 0.0F;
  }
  
  public float getScaleX(View paramView)
  {
    return 0.0F;
  }
  
  public float getScaleY(View paramView)
  {
    return 0.0F;
  }
  
  public int getScrollIndicators(View paramView)
  {
    return 0;
  }
  
  public String getTransitionName(View paramView)
  {
    return null;
  }
  
  public float getTranslationX(View paramView)
  {
    return 0.0F;
  }
  
  public float getTranslationY(View paramView)
  {
    return 0.0F;
  }
  
  public float getTranslationZ(View paramView)
  {
    return 0.0F;
  }
  
  public int getWindowSystemUiVisibility(View paramView)
  {
    return 0;
  }
  
  public float getX(View paramView)
  {
    return 0.0F;
  }
  
  public float getY(View paramView)
  {
    return 0.0F;
  }
  
  public float getZ(View paramView)
  {
    return getTranslationZ(paramView) + getElevation(paramView);
  }
  
  public boolean hasAccessibilityDelegate(View paramView)
  {
    return false;
  }
  
  public boolean hasNestedScrollingParent(View paramView)
  {
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).hasNestedScrollingParent();
    }
    return false;
  }
  
  public boolean hasOnClickListeners(View paramView)
  {
    return false;
  }
  
  public boolean hasOverlappingRendering(View paramView)
  {
    return true;
  }
  
  public boolean hasTransientState(View paramView)
  {
    return false;
  }
  
  public boolean isAttachedToWindow(View paramView)
  {
    return ViewCompatBase.isAttachedToWindow(paramView);
  }
  
  public boolean isImportantForAccessibility(View paramView)
  {
    return true;
  }
  
  public boolean isLaidOut(View paramView)
  {
    return ViewCompatBase.isLaidOut(paramView);
  }
  
  public boolean isNestedScrollingEnabled(View paramView)
  {
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).isNestedScrollingEnabled();
    }
    return false;
  }
  
  public boolean isOpaque(View paramView)
  {
    boolean bool2 = false;
    paramView = paramView.getBackground();
    boolean bool1 = bool2;
    if (paramView != null)
    {
      bool1 = bool2;
      if (paramView.getOpacity() == -1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isPaddingRelative(View paramView)
  {
    return false;
  }
  
  public void jumpDrawablesToCurrentState(View paramView) {}
  
  public void offsetLeftAndRight(View paramView, int paramInt)
  {
    ViewCompatBase.offsetLeftAndRight(paramView, paramInt);
  }
  
  public void offsetTopAndBottom(View paramView, int paramInt)
  {
    ViewCompatBase.offsetTopAndBottom(paramView, paramInt);
  }
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    return paramWindowInsetsCompat;
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {}
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {}
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    return false;
  }
  
  public void postInvalidateOnAnimation(View paramView)
  {
    paramView.invalidate();
  }
  
  public void postInvalidateOnAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.invalidate(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    paramView.postDelayed(paramRunnable, getFrameTime());
  }
  
  public void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
  {
    paramView.postDelayed(paramRunnable, getFrameTime() + paramLong);
  }
  
  public void requestApplyInsets(View paramView) {}
  
  public int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
  {
    return View.resolveSize(paramInt1, paramInt2);
  }
  
  public void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat) {}
  
  public void setAccessibilityLiveRegion(View paramView, int paramInt) {}
  
  public void setActivated(View paramView, boolean paramBoolean) {}
  
  public void setAlpha(View paramView, float paramFloat) {}
  
  public void setBackgroundTintList(View paramView, ColorStateList paramColorStateList)
  {
    ViewCompatBase.setBackgroundTintList(paramView, paramColorStateList);
  }
  
  public void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode)
  {
    ViewCompatBase.setBackgroundTintMode(paramView, paramMode);
  }
  
  public void setChildrenDrawingOrderEnabled(ViewGroup paramViewGroup, boolean paramBoolean) {}
  
  public void setClipBounds(View paramView, Rect paramRect) {}
  
  public void setElevation(View paramView, float paramFloat) {}
  
  public void setFitsSystemWindows(View paramView, boolean paramBoolean) {}
  
  public void setHasTransientState(View paramView, boolean paramBoolean) {}
  
  public void setImportantForAccessibility(View paramView, int paramInt) {}
  
  public void setLabelFor(View paramView, int paramInt) {}
  
  public void setLayerPaint(View paramView, Paint paramPaint) {}
  
  public void setLayerType(View paramView, int paramInt, Paint paramPaint) {}
  
  public void setLayoutDirection(View paramView, int paramInt) {}
  
  public void setNestedScrollingEnabled(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof NestedScrollingChild)) {
      ((NestedScrollingChild)paramView).setNestedScrollingEnabled(paramBoolean);
    }
  }
  
  public void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener) {}
  
  public void setOverScrollMode(View paramView, int paramInt) {}
  
  public void setPaddingRelative(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setPivotX(View paramView, float paramFloat) {}
  
  public void setPivotY(View paramView, float paramFloat) {}
  
  public void setRotation(View paramView, float paramFloat) {}
  
  public void setRotationX(View paramView, float paramFloat) {}
  
  public void setRotationY(View paramView, float paramFloat) {}
  
  public void setSaveFromParentEnabled(View paramView, boolean paramBoolean) {}
  
  public void setScaleX(View paramView, float paramFloat) {}
  
  public void setScaleY(View paramView, float paramFloat) {}
  
  public void setScrollIndicators(View paramView, int paramInt) {}
  
  public void setScrollIndicators(View paramView, int paramInt1, int paramInt2) {}
  
  public void setTransitionName(View paramView, String paramString) {}
  
  public void setTranslationX(View paramView, float paramFloat) {}
  
  public void setTranslationY(View paramView, float paramFloat) {}
  
  public void setTranslationZ(View paramView, float paramFloat) {}
  
  public void setX(View paramView, float paramFloat) {}
  
  public void setY(View paramView, float paramFloat) {}
  
  public boolean startNestedScroll(View paramView, int paramInt)
  {
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).startNestedScroll(paramInt);
    }
    return false;
  }
  
  public void stopNestedScroll(View paramView)
  {
    if ((paramView instanceof NestedScrollingChild)) {
      ((NestedScrollingChild)paramView).stopNestedScroll();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.BaseViewCompatImpl
 * JD-Core Version:    0.7.0.1
 */