package com.tencent.falco.base.floatwindow.animmanager;

import android.animation.Animator;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.falco.base.floatwindow.bean.FloatWindowConfig;
import com.tencent.falco.base.floatwindow.interfaces.OnAppFloatWindowAnimator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FWAppAnimatorManager
{
  @NotNull
  private FloatWindowConfig fwConfig;
  @NotNull
  private WindowManager.LayoutParams layoutParams;
  @NotNull
  private View targetView;
  @NotNull
  private WindowManager windowManager;
  
  public FWAppAnimatorManager(@NotNull View paramView, @NotNull WindowManager.LayoutParams paramLayoutParams, @NotNull WindowManager paramWindowManager, FloatWindowConfig paramFloatWindowConfig)
  {
    this.targetView = paramView;
    this.layoutParams = paramLayoutParams;
    this.windowManager = paramWindowManager;
    this.fwConfig = paramFloatWindowConfig;
  }
  
  @Nullable
  public Animator enterAnim()
  {
    FloatWindowConfig localFloatWindowConfig = this.fwConfig;
    if ((localFloatWindowConfig != null) && (localFloatWindowConfig.appFloatAnimator != null)) {
      return this.fwConfig.appFloatAnimator.enterAnim(this.targetView, this.layoutParams, this.windowManager, this.fwConfig.sidePattern);
    }
    return null;
  }
  
  @Nullable
  public Animator exitAnim()
  {
    FloatWindowConfig localFloatWindowConfig = this.fwConfig;
    if ((localFloatWindowConfig != null) && (localFloatWindowConfig.appFloatAnimator != null)) {
      return this.fwConfig.appFloatAnimator.exitAnim(this.targetView, this.layoutParams, this.windowManager, this.fwConfig.sidePattern);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.animmanager.FWAppAnimatorManager
 * JD-Core Version:    0.7.0.1
 */