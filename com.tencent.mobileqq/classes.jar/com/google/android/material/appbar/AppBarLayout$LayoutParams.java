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
  int a = 1;
  Interpolator b;
  
  public AppBarLayout$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public AppBarLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.u);
    this.a = paramAttributeSet.getInt(R.styleable.v, 0);
    if (paramAttributeSet.hasValue(R.styleable.w)) {
      this.b = AnimationUtils.loadInterpolator(paramContext, paramAttributeSet.getResourceId(R.styleable.w, 0));
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
    return this.a;
  }
  
  public Interpolator b()
  {
    return this.b;
  }
  
  boolean c()
  {
    int i = this.a;
    return ((i & 0x1) == 1) && ((i & 0xA) != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.appbar.AppBarLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */