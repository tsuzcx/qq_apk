package com.google.android.material.tabs;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;

class TabLayout$SlidingTabIndicator
  extends LinearLayout
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = -1;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private int b = -1;
  
  TabLayout$SlidingTabIndicator(TabLayout paramTabLayout, Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  private void a()
  {
    View localView = getChildAt(this.jdField_a_of_type_Int);
    TabIndicatorInterpolator localTabIndicatorInterpolator = TabLayout.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout);
    TabLayout localTabLayout = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout;
    localTabIndicatorInterpolator.a(localTabLayout, localView, localTabLayout.a);
  }
  
  private void a(View paramView1, View paramView2, float paramFloat)
  {
    int i;
    if ((paramView1 != null) && (paramView1.getWidth() > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      TabIndicatorInterpolator localTabIndicatorInterpolator = TabLayout.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout);
      TabLayout localTabLayout = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout;
      localTabIndicatorInterpolator.a(localTabLayout, paramView1, paramView2, paramFloat, localTabLayout.a);
    }
    else
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.a.setBounds(-1, this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.a.getBounds().top, -1, this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.a.getBounds().bottom);
    }
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject1 = getChildAt(this.jdField_a_of_type_Int);
    Object localObject2 = getChildAt(paramInt1);
    if (localObject2 == null)
    {
      a();
      return;
    }
    localObject1 = new TabLayout.SlidingTabIndicator.1(this, (View)localObject1, (View)localObject2);
    if (paramBoolean)
    {
      localObject2 = new ValueAnimator();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ((ValueAnimator)localObject2);
      ((ValueAnimator)localObject2).setInterpolator(AnimationUtils.b);
      ((ValueAnimator)localObject2).setDuration(paramInt2);
      ((ValueAnimator)localObject2).setFloatValues(new float[] { 0.0F, 1.0F });
      ((ValueAnimator)localObject2).addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject1);
      ((ValueAnimator)localObject2).addListener(new TabLayout.SlidingTabIndicator.2(this, paramInt1));
      ((ValueAnimator)localObject2).start();
      return;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject1);
  }
  
  void a(int paramInt)
  {
    Rect localRect = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.a.getBounds();
    this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.a.setBounds(localRect.left, 0, localRect.right, paramInt);
    requestLayout();
  }
  
  void a(int paramInt, float paramFloat)
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Float = paramFloat;
    a(getChildAt(this.jdField_a_of_type_Int), getChildAt(this.jdField_a_of_type_Int + 1), this.jdField_a_of_type_Float);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    a(true, paramInt1, paramInt2);
  }
  
  boolean a()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      if (getChildAt(i).getWidth() <= 0) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    int j = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.a.getBounds().height();
    int i = j;
    if (j < 0) {
      i = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.a.getIntrinsicHeight();
    }
    int m = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.j;
    int k = 0;
    if (m != 0)
    {
      if (m != 1)
      {
        j = k;
        if (m != 2) {
          if (m != 3)
          {
            i = 0;
            j = k;
          }
          else
          {
            i = getHeight();
            j = k;
          }
        }
      }
      else
      {
        j = (getHeight() - i) / 2;
        i = (getHeight() + i) / 2;
      }
    }
    else
    {
      j = getHeight() - i;
      i = getHeight();
    }
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.a.getBounds().width() > 0)
    {
      Object localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.a.getBounds();
      this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.a.setBounds(((Rect)localObject).left, j, ((Rect)localObject).right, i);
      Drawable localDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.a;
      localObject = localDrawable;
      if (TabLayout.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout) != 0)
      {
        localObject = DrawableCompat.wrap(localDrawable);
        if (Build.VERSION.SDK_INT == 21) {
          ((Drawable)localObject).setColorFilter(TabLayout.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout), PorterDuff.Mode.SRC_IN);
        } else {
          DrawableCompat.setTint((Drawable)localObject, TabLayout.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout));
        }
      }
      ((Drawable)localObject).draw(paramCanvas);
    }
    super.draw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning()))
    {
      a(false, this.jdField_a_of_type_Int, -1);
      return;
    }
    a();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
      return;
    }
    if ((this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.h == 1) || (this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.k == 2))
    {
      int n = getChildCount();
      int m = 0;
      int i = 0;
      int k;
      for (int j = 0; i < n; j = k)
      {
        localObject = getChildAt(i);
        k = j;
        if (((View)localObject).getVisibility() == 0) {
          k = Math.max(j, ((View)localObject).getMeasuredWidth());
        }
        i += 1;
      }
      if (j <= 0) {
        return;
      }
      i = (int)ViewUtils.a(getContext(), 16);
      if (j * n <= getMeasuredWidth() - i * 2)
      {
        i = 0;
        k = m;
        for (;;)
        {
          m = i;
          if (k >= n) {
            break;
          }
          localObject = (LinearLayout.LayoutParams)getChildAt(k).getLayoutParams();
          if ((((LinearLayout.LayoutParams)localObject).width != j) || (((LinearLayout.LayoutParams)localObject).weight != 0.0F))
          {
            ((LinearLayout.LayoutParams)localObject).width = j;
            ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
            i = 1;
          }
          k += 1;
        }
      }
      Object localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout;
      ((TabLayout)localObject).h = 0;
      ((TabLayout)localObject).a(false);
      m = 1;
      if (m != 0) {
        super.onMeasure(paramInt1, paramInt2);
      }
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    super.onRtlPropertiesChanged(paramInt);
    if ((Build.VERSION.SDK_INT < 23) && (this.b != paramInt))
    {
      requestLayout();
      this.b = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayout.SlidingTabIndicator
 * JD-Core Version:    0.7.0.1
 */