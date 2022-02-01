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
  private int jdField_a_of_type_Int;
  private MaterialShapeDrawable jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
  private final Runnable jdField_a_of_type_JavaLangRunnable;
  
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
    ViewCompat.setBackground(this, a());
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.al, paramInt, 0);
    this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(R.styleable.dO, 0);
    this.jdField_a_of_type_JavaLangRunnable = new RadialViewGroup.1(this);
    paramContext.recycle();
  }
  
  private Drawable a()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable = new MaterialShapeDrawable();
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.a(new RelativeCornerSize(0.5F));
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.g(ColorStateList.valueOf(-1));
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
  }
  
  private static boolean a(View paramView)
  {
    return "skip".equals(paramView.getTag());
  }
  
  private void b()
  {
    Handler localHandler = getHandler();
    if (localHandler != null)
    {
      localHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      localHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  @Dimension
  public int a()
  {
    return this.jdField_a_of_type_Int;
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
          localConstraintSet.constrainCircle(localView.getId(), R.id.b, this.jdField_a_of_type_Int, f1);
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
    this.jdField_a_of_type_Int = paramInt;
    a();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if (paramView.getId() == -1) {
      paramView.setId(ViewCompat.generateViewId());
    }
    b();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    a();
  }
  
  public void onViewRemoved(View paramView)
  {
    super.onViewRemoved(paramView);
    b();
  }
  
  public void setBackgroundColor(@ColorInt int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.g(ColorStateList.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.timepicker.RadialViewGroup
 * JD-Core Version:    0.7.0.1
 */