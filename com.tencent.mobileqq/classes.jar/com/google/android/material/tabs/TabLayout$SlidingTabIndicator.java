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
  ValueAnimator a;
  int b = -1;
  float c;
  private int e = -1;
  
  TabLayout$SlidingTabIndicator(TabLayout paramTabLayout, Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
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
      TabIndicatorInterpolator localTabIndicatorInterpolator = TabLayout.a(this.d);
      TabLayout localTabLayout = this.d;
      localTabIndicatorInterpolator.a(localTabLayout, paramView1, paramView2, paramFloat, localTabLayout.j);
    }
    else
    {
      this.d.j.setBounds(-1, this.d.j.getBounds().top, -1, this.d.j.getBounds().bottom);
    }
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject1 = getChildAt(this.b);
    Object localObject2 = getChildAt(paramInt1);
    if (localObject2 == null)
    {
      b();
      return;
    }
    localObject1 = new TabLayout.SlidingTabIndicator.1(this, (View)localObject1, (View)localObject2);
    if (paramBoolean)
    {
      localObject2 = new ValueAnimator();
      this.a = ((ValueAnimator)localObject2);
      ((ValueAnimator)localObject2).setInterpolator(AnimationUtils.b);
      ((ValueAnimator)localObject2).setDuration(paramInt2);
      ((ValueAnimator)localObject2).setFloatValues(new float[] { 0.0F, 1.0F });
      ((ValueAnimator)localObject2).addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject1);
      ((ValueAnimator)localObject2).addListener(new TabLayout.SlidingTabIndicator.2(this, paramInt1));
      ((ValueAnimator)localObject2).start();
      return;
    }
    this.a.removeAllUpdateListeners();
    this.a.addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject1);
  }
  
  private void b()
  {
    View localView = getChildAt(this.b);
    TabIndicatorInterpolator localTabIndicatorInterpolator = TabLayout.a(this.d);
    TabLayout localTabLayout = this.d;
    localTabIndicatorInterpolator.a(localTabLayout, localView, localTabLayout.j);
  }
  
  void a(int paramInt)
  {
    Rect localRect = this.d.j.getBounds();
    this.d.j.setBounds(localRect.left, 0, localRect.right, paramInt);
    requestLayout();
  }
  
  void a(int paramInt, float paramFloat)
  {
    ValueAnimator localValueAnimator = this.a;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.a.cancel();
    }
    this.b = paramInt;
    this.c = paramFloat;
    a(getChildAt(this.b), getChildAt(this.b + 1), this.c);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    ValueAnimator localValueAnimator = this.a;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.a.cancel();
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
    int j = this.d.j.getBounds().height();
    int i = j;
    if (j < 0) {
      i = this.d.j.getIntrinsicHeight();
    }
    int m = this.d.r;
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
    if (this.d.j.getBounds().width() > 0)
    {
      Object localObject = this.d.j.getBounds();
      this.d.j.setBounds(((Rect)localObject).left, j, ((Rect)localObject).right, i);
      Drawable localDrawable = this.d.j;
      localObject = localDrawable;
      if (TabLayout.b(this.d) != 0)
      {
        localObject = DrawableCompat.wrap(localDrawable);
        if (Build.VERSION.SDK_INT == 21) {
          ((Drawable)localObject).setColorFilter(TabLayout.b(this.d), PorterDuff.Mode.SRC_IN);
        } else {
          DrawableCompat.setTint((Drawable)localObject, TabLayout.b(this.d));
        }
      }
      ((Drawable)localObject).draw(paramCanvas);
    }
    super.draw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ValueAnimator localValueAnimator = this.a;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning()))
    {
      a(false, this.b, -1);
      return;
    }
    b();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
      return;
    }
    if ((this.d.p == 1) || (this.d.s == 2))
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
      Object localObject = this.d;
      ((TabLayout)localObject).p = 0;
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
    if ((Build.VERSION.SDK_INT < 23) && (this.e != paramInt))
    {
      requestLayout();
      this.e = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayout.SlidingTabIndicator
 * JD-Core Version:    0.7.0.1
 */