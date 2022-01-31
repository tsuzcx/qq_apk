package com.tencent.biz.qqstory.widget.circularreveal;

import android.animation.Animator;
import android.view.View;
import owp;
import owr;

public final class ViewAnimationCompatUtils
{
  public static Animator a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    return a(paramView, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, 2);
  }
  
  public static Animator a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10)
  {
    return a(paramView, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, 2);
  }
  
  public static Animator a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, int paramInt)
  {
    RectangleRevealAnimator localRectangleRevealAnimator = new RectangleRevealAnimator(paramView, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10);
    if (paramInt != paramView.getLayerType()) {
      localRectangleRevealAnimator.addListener(new owr(paramView, paramInt));
    }
    return localRectangleRevealAnimator;
  }
  
  public static Animator a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt)
  {
    owp localowp = owp.a(paramView, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    if (paramInt != paramView.getLayerType()) {
      localowp.addListener(new owr(paramView, paramInt));
    }
    return localowp;
  }
  
  public static Animator a(View paramView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    return a(paramView, paramInt1, paramInt2, paramFloat1, paramFloat2, 2);
  }
  
  public static Animator a(View paramView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3)
  {
    owp localowp = owp.a(paramView, paramInt1, paramInt2, paramFloat1, paramFloat2);
    if (paramInt3 != paramView.getLayerType()) {
      localowp.addListener(new owr(paramView, paramInt3));
    }
    return localowp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.circularreveal.ViewAnimationCompatUtils
 * JD-Core Version:    0.7.0.1
 */