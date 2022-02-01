package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import com.google.android.material.animation.AnimationUtils;

public class HideBottomViewOnScrollBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private int jdField_a_of_type_Int = 0;
  @Nullable
  private ViewPropertyAnimator jdField_a_of_type_AndroidViewViewPropertyAnimator;
  private int b = 2;
  private int c = 0;
  
  public HideBottomViewOnScrollBehavior() {}
  
  public HideBottomViewOnScrollBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(@NonNull V paramV, int paramInt, long paramLong, TimeInterpolator paramTimeInterpolator)
  {
    this.jdField_a_of_type_AndroidViewViewPropertyAnimator = paramV.animate().translationY(paramInt).setInterpolator(paramTimeInterpolator).setDuration(paramLong).setListener(new HideBottomViewOnScrollBehavior.1(this));
  }
  
  public void a(@NonNull V paramV)
  {
    if (this.b == 2) {
      return;
    }
    ViewPropertyAnimator localViewPropertyAnimator = this.jdField_a_of_type_AndroidViewViewPropertyAnimator;
    if (localViewPropertyAnimator != null)
    {
      localViewPropertyAnimator.cancel();
      paramV.clearAnimation();
    }
    this.b = 2;
    a(paramV, 0, 225L, AnimationUtils.d);
  }
  
  public void a(@NonNull V paramV, @Dimension int paramInt)
  {
    this.c = paramInt;
    if (this.b == 1) {
      paramV.setTranslationY(this.jdField_a_of_type_Int + this.c);
    }
  }
  
  public void b(@NonNull V paramV)
  {
    if (this.b == 1) {
      return;
    }
    ViewPropertyAnimator localViewPropertyAnimator = this.jdField_a_of_type_AndroidViewViewPropertyAnimator;
    if (localViewPropertyAnimator != null)
    {
      localViewPropertyAnimator.cancel();
      paramV.clearAnimation();
    }
    this.b = 1;
    a(paramV, this.jdField_a_of_type_Int + this.c, 175L, AnimationUtils.c);
  }
  
  public boolean onLayoutChild(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, int paramInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramV.getLayoutParams();
    this.jdField_a_of_type_Int = (paramV.getMeasuredHeight() + localMarginLayoutParams.bottomMargin);
    return super.onLayoutChild(paramCoordinatorLayout, paramV, paramInt);
  }
  
  public void onNestedScroll(CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @NonNull int[] paramArrayOfInt)
  {
    if (paramInt2 > 0)
    {
      b(paramV);
      return;
    }
    if (paramInt2 < 0) {
      a(paramV);
    }
  }
  
  public boolean onStartNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2)
  {
    return paramInt1 == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.behavior.HideBottomViewOnScrollBehavior
 * JD-Core Version:    0.7.0.1
 */