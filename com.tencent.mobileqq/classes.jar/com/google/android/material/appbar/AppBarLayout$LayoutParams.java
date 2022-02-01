package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.RequiresApi;
import com.google.android.material.R.styleable;

public class AppBarLayout$LayoutParams
  extends LinearLayout.LayoutParams
{
  int jdField_a_of_type_Int = 1;
  Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  
  public AppBarLayout$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public AppBarLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.c);
    this.jdField_a_of_type_Int = paramAttributeSet.getInt(R.styleable.i, 0);
    if (paramAttributeSet.hasValue(R.styleable.j)) {
      this.jdField_a_of_type_AndroidViewAnimationInterpolator = AnimationUtils.loadInterpolator(paramContext, paramAttributeSet.getResourceId(R.styleable.j, 0));
    }
    paramAttributeSet.recycle();
  }
  
  public AppBarLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public AppBarLayout$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  @RequiresApi(19)
  public AppBarLayout$LayoutParams(LinearLayout.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Interpolator a()
  {
    return this.jdField_a_of_type_AndroidViewAnimationInterpolator;
  }
  
  boolean a()
  {
    int i = this.jdField_a_of_type_Int;
    return ((i & 0x1) == 1) && ((i & 0xA) != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.appbar.AppBarLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */