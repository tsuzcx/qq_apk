package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.View;

class ViewCompat$LollipopViewCompatImpl
  extends ViewCompat.KitKatViewCompatImpl
{
  public WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    return ViewCompatLollipop.dispatchApplyWindowInsets(paramView, paramWindowInsetsCompat);
  }
  
  public boolean dispatchNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return ViewCompatLollipop.dispatchNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return ViewCompatLollipop.dispatchNestedPreFling(paramView, paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return ViewCompatLollipop.dispatchNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return ViewCompatLollipop.dispatchNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public ColorStateList getBackgroundTintList(View paramView)
  {
    return ViewCompatLollipop.getBackgroundTintList(paramView);
  }
  
  public PorterDuff.Mode getBackgroundTintMode(View paramView)
  {
    return ViewCompatLollipop.getBackgroundTintMode(paramView);
  }
  
  public float getElevation(View paramView)
  {
    return ViewCompatLollipop.getElevation(paramView);
  }
  
  public String getTransitionName(View paramView)
  {
    return ViewCompatLollipop.getTransitionName(paramView);
  }
  
  public float getTranslationZ(View paramView)
  {
    return ViewCompatLollipop.getTranslationZ(paramView);
  }
  
  public float getZ(View paramView)
  {
    return ViewCompatLollipop.getZ(paramView);
  }
  
  public boolean hasNestedScrollingParent(View paramView)
  {
    return ViewCompatLollipop.hasNestedScrollingParent(paramView);
  }
  
  public boolean isImportantForAccessibility(View paramView)
  {
    return ViewCompatLollipop.isImportantForAccessibility(paramView);
  }
  
  public boolean isNestedScrollingEnabled(View paramView)
  {
    return ViewCompatLollipop.isNestedScrollingEnabled(paramView);
  }
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    return ViewCompatLollipop.onApplyWindowInsets(paramView, paramWindowInsetsCompat);
  }
  
  public void requestApplyInsets(View paramView)
  {
    ViewCompatLollipop.requestApplyInsets(paramView);
  }
  
  public void setBackgroundTintList(View paramView, ColorStateList paramColorStateList)
  {
    ViewCompatLollipop.setBackgroundTintList(paramView, paramColorStateList);
  }
  
  public void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode)
  {
    ViewCompatLollipop.setBackgroundTintMode(paramView, paramMode);
  }
  
  public void setElevation(View paramView, float paramFloat)
  {
    ViewCompatLollipop.setElevation(paramView, paramFloat);
  }
  
  public void setNestedScrollingEnabled(View paramView, boolean paramBoolean)
  {
    ViewCompatLollipop.setNestedScrollingEnabled(paramView, paramBoolean);
  }
  
  public void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    ViewCompatLollipop.setOnApplyWindowInsetsListener(paramView, paramOnApplyWindowInsetsListener);
  }
  
  public void setTransitionName(View paramView, String paramString)
  {
    ViewCompatLollipop.setTransitionName(paramView, paramString);
  }
  
  public void setTranslationZ(View paramView, float paramFloat)
  {
    ViewCompatLollipop.setTranslationZ(paramView, paramFloat);
  }
  
  public boolean startNestedScroll(View paramView, int paramInt)
  {
    return ViewCompatLollipop.startNestedScroll(paramView, paramInt);
  }
  
  public void stopNestedScroll(View paramView)
  {
    ViewCompatLollipop.stopNestedScroll(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.LollipopViewCompatImpl
 * JD-Core Version:    0.7.0.1
 */