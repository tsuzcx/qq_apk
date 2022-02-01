package com.tencent.av.widget.shimmer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.TextView;
import mvc;
import mvd;
import mve;

public class ShimmerTextView
  extends TextView
{
  int jdField_a_of_type_Int = 0;
  private mvd jdField_a_of_type_Mvd;
  
  public ShimmerTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Mvd = new mvd(this, getPaint(), null);
    this.jdField_a_of_type_Mvd.a(getCurrentTextColor());
    ViewCompat.setAccessibilityDelegate(this, new mvc(this));
  }
  
  public ShimmerTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Mvd = new mvd(this, getPaint(), paramAttributeSet);
    this.jdField_a_of_type_Mvd.a(getCurrentTextColor());
    ViewCompat.setAccessibilityDelegate(this, new mvc(this));
  }
  
  public ShimmerTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Mvd = new mvd(this, getPaint(), paramAttributeSet);
    this.jdField_a_of_type_Mvd.a(getCurrentTextColor());
    ViewCompat.setAccessibilityDelegate(this, new mvc(this));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Mvd.a();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    setShimmering(true);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    setShimmering(false);
  }
  
  @SuppressLint({"WrongCall", "DrawAllocation"})
  public void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Mvd != null) {
      this.jdField_a_of_type_Mvd.b();
    }
    super.onDraw(paramCanvas);
    if (a()) {
      postDelayed(new ShimmerTextView.onDrawRunnable(this), 40L);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_Mvd != null) {
      this.jdField_a_of_type_Mvd.a();
    }
  }
  
  public void setAnimationSetupCallback(mve parammve)
  {
    this.jdField_a_of_type_Mvd.a(parammve);
  }
  
  public void setGradientX(float paramFloat)
  {
    this.jdField_a_of_type_Mvd.a(paramFloat);
  }
  
  public void setPrimaryColor(int paramInt)
  {
    this.jdField_a_of_type_Mvd.a(paramInt);
  }
  
  public void setReflectionColor(int paramInt)
  {
    this.jdField_a_of_type_Mvd.b(paramInt);
  }
  
  public void setShimmering(boolean paramBoolean)
  {
    this.jdField_a_of_type_Mvd.a(paramBoolean);
    super.postInvalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    super.setTextColor(paramInt);
    if (this.jdField_a_of_type_Mvd != null) {
      this.jdField_a_of_type_Mvd.a(getCurrentTextColor());
    }
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    super.setTextColor(paramColorStateList);
    if (this.jdField_a_of_type_Mvd != null) {
      this.jdField_a_of_type_Mvd.a(getCurrentTextColor());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.widget.shimmer.ShimmerTextView
 * JD-Core Version:    0.7.0.1
 */