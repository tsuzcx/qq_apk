package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.R.styleable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;

class RadialViewGroup
  extends ConstraintLayout
{
  private final Runnable a;
  private int b;
  private MaterialShapeDrawable c;
  
  public RadialViewGroup(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RadialViewGroup(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RadialViewGroup(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(R.layout.o, this);
    ViewCompat.setBackground(this, c());
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.fL, paramInt, 0);
    this.b = paramContext.getDimensionPixelSize(R.styleable.fM, 0);
    this.a = new RadialViewGroup.1(this);
    paramContext.recycle();
  }
  
  private static boolean a(View paramView)
  {
    return "skip".equals(paramView.getTag());
  }
  
  private Drawable c()
  {
    this.c = new MaterialShapeDrawable();
    this.c.a(new RelativeCornerSize(0.5F));
    this.c.g(ColorStateList.valueOf(-1));
    return this.c;
  }
  
  private void d()
  {
    Handler localHandler = getHandler();
    if (localHandler != null)
    {
      localHandler.removeCallbacks(this.a);
      localHandler.post(this.a);
    }
  }
  
  protected void a()
  {
    int n = getChildCount();
    int m = 0;
    int j = 0;
    int k;
    for (int i = 1; j < n; i = k)
    {
      k = i;
      if (a(getChildAt(j))) {
        k = i + 1;
      }
      j += 1;
    }
    ConstraintSet localConstraintSet = new ConstraintSet();
    localConstraintSet.clone(this);
    float f1 = 0.0F;
    j = m;
    while (j < n)
    {
      View localView = getChildAt(j);
      float f2 = f1;
      if (localView.getId() != R.id.b) {
        if (a(localView))
        {
          f2 = f1;
        }
        else
        {
          localConstraintSet.constrainCircle(localView.getId(), R.id.b, this.b, f1);
          f2 = f1 + 360.0F / (n - i);
        }
      }
      j += 1;
      f1 = f2;
    }
    localConstraintSet.applyTo(this);
  }
  
  public void a(@Dimension int paramInt)
  {
    this.b = paramInt;
    a();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if (paramView.getId() == -1) {
      paramView.setId(ViewCompat.generateViewId());
    }
    d();
  }
  
  @Dimension
  public int b()
  {
    return this.b;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    a();
  }
  
  public void onViewRemoved(View paramView)
  {
    super.onViewRemoved(paramView);
    d();
  }
  
  public void setBackgroundColor(@ColorInt int paramInt)
  {
    this.c.g(ColorStateList.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.timepicker.RadialViewGroup
 * JD-Core Version:    0.7.0.1
 */