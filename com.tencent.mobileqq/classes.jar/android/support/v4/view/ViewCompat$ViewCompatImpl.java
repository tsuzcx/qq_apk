package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

abstract interface ViewCompat$ViewCompatImpl
{
  public abstract ViewPropertyAnimatorCompat animate(View paramView);
  
  public abstract boolean canScrollHorizontally(View paramView, int paramInt);
  
  public abstract boolean canScrollVertically(View paramView, int paramInt);
  
  public abstract int combineMeasuredStates(int paramInt1, int paramInt2);
  
  public abstract WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat);
  
  public abstract void dispatchFinishTemporaryDetach(View paramView);
  
  public abstract boolean dispatchNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public abstract boolean dispatchNestedPreFling(View paramView, float paramFloat1, float paramFloat2);
  
  public abstract boolean dispatchNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public abstract boolean dispatchNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt);
  
  public abstract void dispatchStartTemporaryDetach(View paramView);
  
  public abstract int getAccessibilityLiveRegion(View paramView);
  
  public abstract AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView);
  
  public abstract float getAlpha(View paramView);
  
  public abstract ColorStateList getBackgroundTintList(View paramView);
  
  public abstract PorterDuff.Mode getBackgroundTintMode(View paramView);
  
  public abstract Rect getClipBounds(View paramView);
  
  public abstract float getElevation(View paramView);
  
  public abstract boolean getFitsSystemWindows(View paramView);
  
  public abstract int getImportantForAccessibility(View paramView);
  
  public abstract int getLabelFor(View paramView);
  
  public abstract int getLayerType(View paramView);
  
  public abstract int getLayoutDirection(View paramView);
  
  public abstract int getMeasuredHeightAndState(View paramView);
  
  public abstract int getMeasuredState(View paramView);
  
  public abstract int getMeasuredWidthAndState(View paramView);
  
  public abstract int getMinimumHeight(View paramView);
  
  public abstract int getMinimumWidth(View paramView);
  
  public abstract int getOverScrollMode(View paramView);
  
  public abstract int getPaddingEnd(View paramView);
  
  public abstract int getPaddingStart(View paramView);
  
  public abstract ViewParent getParentForAccessibility(View paramView);
  
  public abstract float getPivotX(View paramView);
  
  public abstract float getPivotY(View paramView);
  
  public abstract float getRotation(View paramView);
  
  public abstract float getRotationX(View paramView);
  
  public abstract float getRotationY(View paramView);
  
  public abstract float getScaleX(View paramView);
  
  public abstract float getScaleY(View paramView);
  
  public abstract int getScrollIndicators(View paramView);
  
  public abstract String getTransitionName(View paramView);
  
  public abstract float getTranslationX(View paramView);
  
  public abstract float getTranslationY(View paramView);
  
  public abstract float getTranslationZ(View paramView);
  
  public abstract int getWindowSystemUiVisibility(View paramView);
  
  public abstract float getX(View paramView);
  
  public abstract float getY(View paramView);
  
  public abstract float getZ(View paramView);
  
  public abstract boolean hasAccessibilityDelegate(View paramView);
  
  public abstract boolean hasNestedScrollingParent(View paramView);
  
  public abstract boolean hasOnClickListeners(View paramView);
  
  public abstract boolean hasOverlappingRendering(View paramView);
  
  public abstract boolean hasTransientState(View paramView);
  
  public abstract boolean isAttachedToWindow(View paramView);
  
  public abstract boolean isImportantForAccessibility(View paramView);
  
  public abstract boolean isLaidOut(View paramView);
  
  public abstract boolean isNestedScrollingEnabled(View paramView);
  
  public abstract boolean isOpaque(View paramView);
  
  public abstract boolean isPaddingRelative(View paramView);
  
  public abstract void jumpDrawablesToCurrentState(View paramView);
  
  public abstract void offsetLeftAndRight(View paramView, int paramInt);
  
  public abstract void offsetTopAndBottom(View paramView, int paramInt);
  
  public abstract WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat);
  
  public abstract void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent);
  
  public abstract void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat);
  
  public abstract void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent);
  
  public abstract boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle);
  
  public abstract void postInvalidateOnAnimation(View paramView);
  
  public abstract void postInvalidateOnAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void postOnAnimation(View paramView, Runnable paramRunnable);
  
  public abstract void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong);
  
  public abstract void requestApplyInsets(View paramView);
  
  public abstract int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void setAccessibilityDelegate(View paramView, @Nullable AccessibilityDelegateCompat paramAccessibilityDelegateCompat);
  
  public abstract void setAccessibilityLiveRegion(View paramView, int paramInt);
  
  public abstract void setActivated(View paramView, boolean paramBoolean);
  
  public abstract void setAlpha(View paramView, float paramFloat);
  
  public abstract void setBackgroundTintList(View paramView, ColorStateList paramColorStateList);
  
  public abstract void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode);
  
  public abstract void setChildrenDrawingOrderEnabled(ViewGroup paramViewGroup, boolean paramBoolean);
  
  public abstract void setClipBounds(View paramView, Rect paramRect);
  
  public abstract void setElevation(View paramView, float paramFloat);
  
  public abstract void setFitsSystemWindows(View paramView, boolean paramBoolean);
  
  public abstract void setHasTransientState(View paramView, boolean paramBoolean);
  
  public abstract void setImportantForAccessibility(View paramView, int paramInt);
  
  public abstract void setLabelFor(View paramView, int paramInt);
  
  public abstract void setLayerPaint(View paramView, Paint paramPaint);
  
  public abstract void setLayerType(View paramView, int paramInt, Paint paramPaint);
  
  public abstract void setLayoutDirection(View paramView, int paramInt);
  
  public abstract void setNestedScrollingEnabled(View paramView, boolean paramBoolean);
  
  public abstract void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener);
  
  public abstract void setOverScrollMode(View paramView, int paramInt);
  
  public abstract void setPaddingRelative(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setPivotX(View paramView, float paramFloat);
  
  public abstract void setPivotY(View paramView, float paramFloat);
  
  public abstract void setRotation(View paramView, float paramFloat);
  
  public abstract void setRotationX(View paramView, float paramFloat);
  
  public abstract void setRotationY(View paramView, float paramFloat);
  
  public abstract void setSaveFromParentEnabled(View paramView, boolean paramBoolean);
  
  public abstract void setScaleX(View paramView, float paramFloat);
  
  public abstract void setScaleY(View paramView, float paramFloat);
  
  public abstract void setScrollIndicators(View paramView, int paramInt);
  
  public abstract void setScrollIndicators(View paramView, int paramInt1, int paramInt2);
  
  public abstract void setTransitionName(View paramView, String paramString);
  
  public abstract void setTranslationX(View paramView, float paramFloat);
  
  public abstract void setTranslationY(View paramView, float paramFloat);
  
  public abstract void setTranslationZ(View paramView, float paramFloat);
  
  public abstract void setX(View paramView, float paramFloat);
  
  public abstract void setY(View paramView, float paramFloat);
  
  public abstract boolean startNestedScroll(View paramView, int paramInt);
  
  public abstract void stopNestedScroll(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.ViewCompatImpl
 * JD-Core Version:    0.7.0.1
 */