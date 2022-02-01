package com.tencent.falco.base.floatwindow.animmanager;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.falco.base.floatwindow.interfaces.OnActivityFloatWindowAnimator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FWActivityAnimatorManager
{
  @Nullable
  private OnActivityFloatWindowAnimator onActivityFloatWindowAnimator;
  @NotNull
  private ViewGroup parentView;
  private int sideMoveType;
  @NotNull
  private View targetView;
  
  public FWActivityAnimatorManager(@Nullable OnActivityFloatWindowAnimator paramOnActivityFloatWindowAnimator, @NotNull View paramView, @NotNull ViewGroup paramViewGroup, int paramInt)
  {
    this.onActivityFloatWindowAnimator = paramOnActivityFloatWindowAnimator;
    this.targetView = paramView;
    this.parentView = paramViewGroup;
    this.sideMoveType = paramInt;
  }
  
  @Nullable
  public Animator enterAnim()
  {
    OnActivityFloatWindowAnimator localOnActivityFloatWindowAnimator = this.onActivityFloatWindowAnimator;
    if (localOnActivityFloatWindowAnimator == null) {
      return null;
    }
    return localOnActivityFloatWindowAnimator.enterAnim(this.targetView, this.parentView, this.sideMoveType);
  }
  
  @Nullable
  public Animator exitAnim()
  {
    OnActivityFloatWindowAnimator localOnActivityFloatWindowAnimator = this.onActivityFloatWindowAnimator;
    if (localOnActivityFloatWindowAnimator == null) {
      return null;
    }
    return localOnActivityFloatWindowAnimator.exitAnim(this.targetView, this.parentView, this.sideMoveType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.animmanager.FWActivityAnimatorManager
 * JD-Core Version:    0.7.0.1
 */