package com.tencent.biz.qqstory.widget.circularreveal;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import owu;

public class RectangleRevealAnimator
  extends ValueAnimator
{
  private ValueAnimator.AnimatorUpdateListener a;
  
  public RectangleRevealAnimator(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10)
  {
    setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("top", new float[] { paramFloat1, paramFloat6 }), PropertyValuesHolder.ofFloat("left", new float[] { paramFloat2, paramFloat7 }), PropertyValuesHolder.ofFloat("width", new float[] { paramFloat3, paramFloat8 }), PropertyValuesHolder.ofFloat("height", new float[] { paramFloat4, paramFloat9 }), PropertyValuesHolder.ofFloat("radius", new float[] { paramFloat5, paramFloat10 }) });
    this.a = new owu(this, a(paramView));
    addUpdateListener(this.a);
  }
  
  private CircularRevealCompatLayout a(View paramView)
  {
    if ((paramView instanceof CircularRevealCompatLayout)) {
      return (CircularRevealCompatLayout)paramView;
    }
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if ((localViewGroup instanceof CircularRevealCompatLayout)) {
      return (CircularRevealCompatLayout)localViewGroup;
    }
    CircularRevealCompatLayout localCircularRevealCompatLayout = new CircularRevealCompatLayout(paramView.getContext());
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    int i = localViewGroup.indexOfChild(paramView);
    localViewGroup.removeView(paramView);
    localCircularRevealCompatLayout.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
    localViewGroup.addView(localCircularRevealCompatLayout, i, localLayoutParams);
    return localCircularRevealCompatLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.circularreveal.RectangleRevealAnimator
 * JD-Core Version:    0.7.0.1
 */