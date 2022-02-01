package com.tencent.falco.base.floatwindow.animmanager;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.falco.base.floatwindow.interfaces.OnAppFloatWindowAnimator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FWAppDefaultAnimator
  implements OnAppFloatWindowAnimator
{
  private static final int ANIM_DURATION_MS = 300;
  
  private int initValue(View paramView, WindowManager.LayoutParams paramLayoutParams, WindowManager paramWindowManager)
  {
    Rect localRect = new Rect();
    paramWindowManager.getDefaultDisplay().getRectSize(localRect);
    int i = paramLayoutParams.x;
    if (i < localRect.right - (paramView.getRight() + i)) {
      return -paramView.getRight();
    }
    return localRect.right;
  }
  
  @Nullable
  public Animator enterAnim(@NotNull View paramView, @NotNull WindowManager.LayoutParams paramLayoutParams, @NotNull WindowManager paramWindowManager, int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { initValue(paramView, paramLayoutParams, paramWindowManager), paramLayoutParams.x });
    if (localValueAnimator == null) {
      return null;
    }
    localValueAnimator.setDuration(300L);
    localValueAnimator.addUpdateListener(new FWAppDefaultAnimator.1(this, paramLayoutParams, paramWindowManager, paramView));
    return localValueAnimator;
  }
  
  public Animator exitAnim(@NotNull View paramView, @NotNull WindowManager.LayoutParams paramLayoutParams, @NotNull WindowManager paramWindowManager, int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramLayoutParams.x, initValue(paramView, paramLayoutParams, paramWindowManager) });
    if (localValueAnimator == null) {
      return null;
    }
    localValueAnimator.addUpdateListener(new FWAppDefaultAnimator.2(this, paramLayoutParams, paramWindowManager, paramView));
    return localValueAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.animmanager.FWAppDefaultAnimator
 * JD-Core Version:    0.7.0.1
 */