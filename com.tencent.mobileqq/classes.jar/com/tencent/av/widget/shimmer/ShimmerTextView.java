package com.tencent.av.widget.shimmer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.TextView;

public class ShimmerTextView
  extends TextView
  implements IShimmer
{
  int a = 0;
  private ShimmerViewHelper b;
  
  public ShimmerTextView(Context paramContext)
  {
    super(paramContext);
    this.b = new ShimmerViewHelper(this, getPaint(), null);
    this.b.a(getCurrentTextColor());
    ViewCompat.setAccessibilityDelegate(this, new ShimmerTextView.MyAccessibilityDelegate(this));
  }
  
  public ShimmerTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = new ShimmerViewHelper(this, getPaint(), paramAttributeSet);
    this.b.a(getCurrentTextColor());
    ViewCompat.setAccessibilityDelegate(this, new ShimmerTextView.MyAccessibilityDelegate(this));
  }
  
  public ShimmerTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = new ShimmerViewHelper(this, getPaint(), paramAttributeSet);
    this.b.a(getCurrentTextColor());
    ViewCompat.setAccessibilityDelegate(this, new ShimmerTextView.MyAccessibilityDelegate(this));
  }
  
  public boolean a()
  {
    ShimmerViewHelper localShimmerViewHelper = this.b;
    return (localShimmerViewHelper != null) && (localShimmerViewHelper.b());
  }
  
  public float getGradientX()
  {
    return this.b.a();
  }
  
  public int getPrimaryColor()
  {
    return this.b.c();
  }
  
  public int getReflectionColor()
  {
    return this.b.d();
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
    ShimmerViewHelper localShimmerViewHelper = this.b;
    if (localShimmerViewHelper != null) {
      localShimmerViewHelper.f();
    }
    super.onDraw(paramCanvas);
    if (a()) {
      postDelayed(new ShimmerTextView.OnDrawRunnable(this), 40L);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ShimmerViewHelper localShimmerViewHelper = this.b;
    if (localShimmerViewHelper != null) {
      localShimmerViewHelper.e();
    }
  }
  
  public void setAnimationSetupCallback(ShimmerViewHelper.AnimationSetupCallback paramAnimationSetupCallback)
  {
    this.b.a(paramAnimationSetupCallback);
  }
  
  public void setGradientX(float paramFloat)
  {
    this.b.a(paramFloat);
  }
  
  public void setPrimaryColor(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void setReflectionColor(int paramInt)
  {
    this.b.b(paramInt);
  }
  
  public void setShimmering(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
    super.postInvalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    super.setTextColor(paramInt);
    ShimmerViewHelper localShimmerViewHelper = this.b;
    if (localShimmerViewHelper != null) {
      localShimmerViewHelper.a(getCurrentTextColor());
    }
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    super.setTextColor(paramColorStateList);
    paramColorStateList = this.b;
    if (paramColorStateList != null) {
      paramColorStateList.a(getCurrentTextColor());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.widget.shimmer.ShimmerTextView
 * JD-Core Version:    0.7.0.1
 */