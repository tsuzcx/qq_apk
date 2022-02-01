package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class FabTransformationBehavior$1
  extends AnimatorListenerAdapter
{
  FabTransformationBehavior$1(FabTransformationBehavior paramFabTransformationBehavior, boolean paramBoolean, View paramView1, View paramView2) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.a)
    {
      this.b.setVisibility(4);
      this.c.setAlpha(1.0F);
      this.c.setVisibility(0);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a)
    {
      this.b.setVisibility(0);
      this.c.setAlpha(0.0F);
      this.c.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transformation.FabTransformationBehavior.1
 * JD-Core Version:    0.7.0.1
 */