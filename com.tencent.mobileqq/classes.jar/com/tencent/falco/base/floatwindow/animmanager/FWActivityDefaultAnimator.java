package com.tencent.falco.base.floatwindow.animmanager;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.falco.base.floatwindow.interfaces.OnActivityFloatWindowAnimator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FWActivityDefaultAnimator
  implements OnActivityFloatWindowAnimator
{
  private static final int ANIM_DURATION_MS = 300;
  private static final String TRANSLATION_X = "translationX";
  private static final String TRANSLATION_Y = "translationY";
  private int bottomDistance = 0;
  private Rect floatRect = new Rect();
  private int leftDistance = 0;
  private int minX = 0;
  private int minY = 0;
  private Rect parentRect = new Rect();
  private int rightDistance = 0;
  private int topDistance = 0;
  
  private FWActivityDefaultAnimator.AnimParams genAnimParams(View paramView, int paramInt)
  {
    FWActivityDefaultAnimator.AnimParams localAnimParams = new FWActivityDefaultAnimator.AnimParams();
    switch (paramInt)
    {
    }
    while (localAnimParams.animType.compareTo("translationX") == 0)
    {
      localAnimParams.endValue = paramView.getTranslationX();
      return localAnimParams;
      localAnimParams.animType = "translationX";
      localAnimParams.startValue = getLeftValue(paramView);
      continue;
      localAnimParams.animType = "translationX";
      localAnimParams.startValue = getRightValue(paramView);
      continue;
      localAnimParams.animType = "translationY";
      localAnimParams.startValue = getTopValue(paramView);
      continue;
      localAnimParams.animType = "translationY";
      localAnimParams.startValue = getRightValue(paramView);
      continue;
      localAnimParams.animType = "translationX";
      if (this.leftDistance < this.rightDistance)
      {
        localAnimParams.startValue = getLeftValue(paramView);
      }
      else
      {
        localAnimParams.startValue = getRightValue(paramView);
        continue;
        localAnimParams.animType = "translationY";
        if (this.topDistance < this.bottomDistance)
        {
          localAnimParams.startValue = getTopValue(paramView);
        }
        else
        {
          localAnimParams.startValue = getBottomValue(paramView);
          continue;
          if (this.minX <= this.minY)
          {
            localAnimParams.animType = "translationX";
            if (this.leftDistance < this.rightDistance) {
              getLeftValue(paramView);
            } else {
              getRightValue(paramView);
            }
          }
          else
          {
            localAnimParams.animType = "translationY";
            if (this.topDistance < this.bottomDistance) {
              getTopValue(paramView);
            } else {
              getBottomValue(paramView);
            }
          }
        }
      }
    }
    localAnimParams.endValue = paramView.getTranslationY();
    return localAnimParams;
  }
  
  private float getBottomValue(View paramView)
  {
    return -(this.topDistance + paramView.getHeight()) + paramView.getTranslationY();
  }
  
  private float getLeftValue(View paramView)
  {
    return -(this.leftDistance + paramView.getWidth()) + paramView.getTranslationX();
  }
  
  private float getRightValue(View paramView)
  {
    return this.rightDistance + paramView.getWidth() + paramView.getTranslationX();
  }
  
  private float getTopValue(View paramView)
  {
    return this.bottomDistance + paramView.getHeight() + paramView.getTranslationY();
  }
  
  private void initValue(View paramView, ViewGroup paramViewGroup)
  {
    paramView.getGlobalVisibleRect(this.floatRect);
    paramViewGroup.getGlobalVisibleRect(this.parentRect);
    this.leftDistance = this.floatRect.left;
    this.rightDistance = (this.parentRect.right - this.floatRect.right);
    this.topDistance = (this.floatRect.top - this.parentRect.top);
    this.bottomDistance = (this.parentRect.bottom - this.floatRect.bottom);
    this.minX = Math.min(this.leftDistance, this.rightDistance);
    this.minY = Math.min(this.topDistance, this.bottomDistance);
  }
  
  @Nullable
  public Animator enterAnim(@NotNull View paramView, @NotNull ViewGroup paramViewGroup, int paramInt)
  {
    initValue(paramView, paramViewGroup);
    paramViewGroup = genAnimParams(paramView, paramInt);
    return ObjectAnimator.ofFloat(paramView, paramViewGroup.animType, new float[] { paramViewGroup.startValue, paramViewGroup.endValue }).setDuration(300L);
  }
  
  @Nullable
  public Animator exitAnim(@NotNull View paramView, @NotNull ViewGroup paramViewGroup, int paramInt)
  {
    initValue(paramView, paramViewGroup);
    paramViewGroup = genAnimParams(paramView, paramInt);
    return ObjectAnimator.ofFloat(paramView, paramViewGroup.animType, new float[] { paramViewGroup.endValue, paramViewGroup.startValue }).setDuration(300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.animmanager.FWActivityDefaultAnimator
 * JD-Core Version:    0.7.0.1
 */