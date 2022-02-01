package com.rookery.translate.widget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout.LayoutParams;

public class BubbleResizeAnimation
  extends Animation
{
  private View a;
  private RelativeLayout.LayoutParams b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public BubbleResizeAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    setDuration(paramInt1);
    this.a = paramView;
    this.b = ((RelativeLayout.LayoutParams)paramView.getLayoutParams());
    this.d = paramView.getMeasuredHeight();
    this.c = paramView.getMeasuredWidth();
    this.f = (this.d + paramInt3);
    this.e = (this.c + paramInt2);
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    if (paramFloat < 1.0F)
    {
      paramTransformation = this.b;
      int i = this.d;
      paramTransformation.height = (i + (int)((this.f - i) * paramFloat));
      i = this.c;
      paramTransformation.width = (i + (int)((this.e - i) * paramFloat));
      this.a.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.translate.widget.BubbleResizeAnimation
 * JD-Core Version:    0.7.0.1
 */