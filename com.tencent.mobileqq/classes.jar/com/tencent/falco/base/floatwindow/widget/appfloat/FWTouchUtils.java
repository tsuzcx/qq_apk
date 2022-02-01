package com.tencent.falco.base.floatwindow.widget.appfloat;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.falco.base.floatwindow.bean.FloatWindowConfig;
import com.tencent.falco.base.floatwindow.interfaces.OnDisplayHeight;
import com.tencent.falco.base.floatwindow.interfaces.OnFloatWindowCallbacks;
import com.tencent.falco.utils.UIUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/falco/base/floatwindow/widget/appfloat/FWTouchUtils;", "", "context", "Landroid/content/Context;", "config", "Lcom/tencent/falco/base/floatwindow/bean/FloatWindowConfig;", "(Landroid/content/Context;Lcom/tencent/falco/base/floatwindow/bean/FloatWindowConfig;)V", "bottomDistance", "", "getConfig", "()Lcom/tencent/falco/base/floatwindow/bean/FloatWindowConfig;", "getContext", "()Landroid/content/Context;", "emptyHeight", "hasStatusBar", "", "lastX", "", "lastY", "leftDistance", "location", "", "minX", "minY", "parentHeight", "parentRect", "Landroid/graphics/Rect;", "parentWidth", "rightDistance", "topDistance", "initDistanceValue", "", "params", "Landroid/view/WindowManager$LayoutParams;", "view", "Landroid/view/View;", "sideAnim", "windowManager", "Landroid/view/WindowManager;", "sideAnimWhenOutOfScreen", "statusBarHeight", "updateFloat", "event", "Landroid/view/MotionEvent;", "floatwindow_release"}, k=1, mv={1, 1, 15})
public final class FWTouchUtils
{
  private int bottomDistance;
  @NotNull
  private final FloatWindowConfig config;
  @NotNull
  private final Context context;
  private int emptyHeight;
  private boolean hasStatusBar;
  private float lastX;
  private float lastY;
  private int leftDistance;
  private final int[] location;
  private int minX;
  private int minY;
  private int parentHeight;
  private Rect parentRect;
  private int parentWidth;
  private int rightDistance;
  private int topDistance;
  
  public FWTouchUtils(@NotNull Context paramContext, @NotNull FloatWindowConfig paramFloatWindowConfig)
  {
    this.context = paramContext;
    this.config = paramFloatWindowConfig;
    this.parentRect = new Rect();
    this.location = new int[2];
    this.hasStatusBar = true;
  }
  
  private final void initDistanceValue(WindowManager.LayoutParams paramLayoutParams, View paramView)
  {
    this.leftDistance = paramLayoutParams.x;
    this.rightDistance = (this.parentWidth - (this.leftDistance + paramView.getRight()));
    this.topDistance = paramLayoutParams.y;
    if (this.hasStatusBar) {}
    for (int i = this.parentHeight - statusBarHeight(paramView) - this.topDistance - paramView.getHeight();; i = this.parentHeight - this.topDistance - paramView.getHeight())
    {
      this.bottomDistance = i;
      this.minX = Math.min(this.leftDistance, this.rightDistance);
      this.minY = Math.min(this.topDistance, this.bottomDistance);
      return;
    }
  }
  
  private final void sideAnim(View paramView, WindowManager.LayoutParams paramLayoutParams, WindowManager paramWindowManager)
  {
    initDistanceValue(paramLayoutParams, paramView);
    int i = (int)this.config.horizontalMargin;
    int j = (int)this.config.verticalMargin;
    boolean bool;
    switch (this.config.sidePattern)
    {
    default: 
      return;
    case 9: 
      bool = true;
      if (!bool) {
        break;
      }
    }
    for (j = paramLayoutParams.x;; j = paramLayoutParams.y)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { j, i });
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new FWTouchUtils.sideAnim.1(bool, paramLayoutParams, paramWindowManager, paramView));
      localValueAnimator.addListener((Animator.AnimatorListener)new FWTouchUtils.sideAnim.2(this, paramView));
      localValueAnimator.start();
      return;
      i = paramLayoutParams.x + this.rightDistance - i;
      bool = true;
      break;
      if (this.leftDistance < this.rightDistance)
      {
        bool = true;
        break;
      }
      i = paramLayoutParams.x + this.rightDistance - i;
      bool = true;
      break;
      bool = false;
      i = j;
      break;
      if (this.hasStatusBar)
      {
        i = this.emptyHeight - statusBarHeight(paramView) - j;
        bool = false;
        break;
      }
      i = this.emptyHeight - j;
      bool = false;
      break;
      if (this.topDistance < this.bottomDistance)
      {
        bool = false;
        i = j;
        break;
      }
      if (this.hasStatusBar) {}
      for (i = this.emptyHeight - statusBarHeight(paramView) - j;; i = this.emptyHeight - j)
      {
        bool = false;
        break;
      }
      if (this.minX < this.minY)
      {
        if (this.leftDistance < this.rightDistance)
        {
          bool = true;
          break;
        }
        i = paramLayoutParams.x + this.rightDistance - i;
        bool = true;
        break;
      }
      if (this.topDistance < this.bottomDistance) {
        i = j;
      }
      for (;;)
      {
        bool = false;
        break;
        if (this.hasStatusBar) {
          i = this.emptyHeight - statusBarHeight(paramView) - j;
        } else {
          i = this.emptyHeight - j;
        }
      }
    }
  }
  
  private final void sideAnimWhenOutOfScreen(View paramView, WindowManager.LayoutParams paramLayoutParams, WindowManager paramWindowManager)
  {
    initDistanceValue(paramLayoutParams, paramView);
    int j = (int)this.config.horizontalMargin;
    int i = (int)this.config.verticalMargin;
    int m = paramLayoutParams.x;
    int k = paramLayoutParams.y;
    if ((this.leftDistance < 0) || (this.rightDistance < 0)) {
      if (this.leftDistance >= this.rightDistance) {}
    }
    for (;;)
    {
      if ((this.topDistance < 0) || (this.bottomDistance < 0)) {
        if (this.topDistance >= this.bottomDistance) {}
      }
      for (;;)
      {
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramLayoutParams.x, j });
        localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new FWTouchUtils.sideAnimWhenOutOfScreen.1(paramLayoutParams, paramWindowManager, paramView));
        localValueAnimator.addListener((Animator.AnimatorListener)new FWTouchUtils.sideAnimWhenOutOfScreen.2(this, paramView));
        paramView = ValueAnimator.ofInt(new int[] { paramLayoutParams.y, i });
        paramView.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new FWTouchUtils.sideAnimWhenOutOfScreen.3(paramLayoutParams));
        paramLayoutParams = new AnimatorSet();
        paramLayoutParams.playTogether(new Animator[] { (Animator)localValueAnimator, (Animator)paramView });
        paramLayoutParams.start();
        return;
        j = paramLayoutParams.x + this.rightDistance - j;
        break;
        if (this.hasStatusBar)
        {
          i = this.emptyHeight - statusBarHeight(paramView) - i;
        }
        else
        {
          i = this.emptyHeight - i;
          continue;
          i = k;
        }
      }
      j = m;
    }
  }
  
  private final int statusBarHeight(View paramView)
  {
    return UIUtil.getStatusBarHeight(paramView.getContext());
  }
  
  @NotNull
  public final FloatWindowConfig getConfig()
  {
    return this.config;
  }
  
  @NotNull
  public final Context getContext()
  {
    return this.context;
  }
  
  public final void updateFloat(@NotNull View paramView, @NotNull MotionEvent paramMotionEvent, @NotNull WindowManager paramWindowManager, @NotNull WindowManager.LayoutParams paramLayoutParams)
  {
    boolean bool = true;
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    Intrinsics.checkParameterIsNotNull(paramWindowManager, "windowManager");
    Intrinsics.checkParameterIsNotNull(paramLayoutParams, "params");
    OnFloatWindowCallbacks localOnFloatWindowCallbacks = this.config.callbacks;
    if (localOnFloatWindowCallbacks != null) {
      localOnFloatWindowCallbacks.touchEvent(paramView, paramMotionEvent);
    }
    if ((!this.config.dragEnable) || (this.config.isAnim)) {
      this.config.isDrag = false;
    }
    do
    {
      do
      {
        float f4;
        float f3;
        do
        {
          return;
          f4 = this.config.horizontalMargin;
          f3 = this.config.verticalMargin;
          switch (paramMotionEvent.getAction() & 0xFF)
          {
          default: 
            return;
          case 0: 
            this.config.isDrag = false;
            this.lastX = paramMotionEvent.getRawX();
            this.lastY = paramMotionEvent.getRawY();
            this.parentWidth = UIUtil.getScreenWidth(this.context);
            this.parentHeight = this.config.displayHeight.getDisplayRealHeight(this.context);
            paramView.getLocationOnScreen(this.location);
            if (this.location[1] > paramLayoutParams.y) {}
            for (;;)
            {
              this.hasStatusBar = bool;
              this.emptyHeight = (this.parentHeight - paramView.getHeight());
              return;
              bool = false;
            }
          case 2: 
            f1 = paramMotionEvent.getRawX() - this.lastX;
            f2 = paramMotionEvent.getRawY() - this.lastY;
          }
        } while ((!this.config.isDrag) && (f1 * f1 + f2 * f2 < 81));
        this.config.isDrag = true;
        float f1 = paramLayoutParams.x + f1;
        float f2 = paramLayoutParams.y + f2;
        switch (this.config.sidePattern)
        {
        case 6: 
        default: 
        case 1: 
        case 2: 
        case 3: 
        case 4: 
          for (;;)
          {
            paramLayoutParams.flags = 552;
            paramLayoutParams.x = ((int)f1);
            paramLayoutParams.y = ((int)f2);
            try
            {
              paramWindowManager.updateViewLayout(paramView, (ViewGroup.LayoutParams)paramLayoutParams);
              paramWindowManager = this.config.callbacks;
              if (paramWindowManager != null) {
                paramWindowManager.drag(paramView, paramMotionEvent);
              }
              this.lastX = paramMotionEvent.getRawX();
              this.lastY = paramMotionEvent.getRawY();
              return;
            }
            catch (Exception paramView)
            {
              paramView.printStackTrace();
              return;
            }
            f1 = f4;
            continue;
            f1 = this.parentWidth - paramView.getWidth() - f4;
            continue;
            f2 = f3;
            continue;
            f2 = this.parentHeight - paramView.getHeight() - f3;
          }
        case 5: 
          if (paramMotionEvent.getRawX() * 2 > this.parentWidth) {}
          for (f1 = this.parentWidth - paramView.getWidth() - f4;; f1 = f4) {
            break;
          }
        case 7: 
          if ((paramMotionEvent.getRawY() - this.parentRect.top) * 2 > this.parentHeight) {}
          for (f2 = this.parentHeight - paramView.getHeight() - f3;; f2 = f3) {
            break;
          }
        }
        this.leftDistance = ((int)paramMotionEvent.getRawX());
        this.rightDistance = (this.parentWidth - (int)paramMotionEvent.getRawX());
        this.topDistance = ((int)paramMotionEvent.getRawY() - this.parentRect.top);
        this.bottomDistance = (this.parentHeight + this.parentRect.top - (int)paramMotionEvent.getRawY());
        this.minX = Math.min(this.leftDistance, this.rightDistance);
        this.minY = Math.min(this.topDistance, this.bottomDistance);
        if (this.minX < this.minY)
        {
          if (this.leftDistance == this.minX) {}
          for (f1 = f4;; f1 = this.parentWidth - paramView.getWidth() - f4) {
            break;
          }
        }
        if (this.topDistance == this.minY) {}
        for (f2 = f3;; f2 = this.parentHeight - paramView.getHeight() - f3) {
          break;
        }
      } while (!this.config.isDrag);
      switch (this.config.sidePattern)
      {
      default: 
        paramMotionEvent = this.config.callbacks;
      }
    } while (paramMotionEvent == null);
    paramMotionEvent.dragEnd(paramView);
    return;
    sideAnim(paramView, paramLayoutParams, paramWindowManager);
    return;
    sideAnimWhenOutOfScreen(paramView, paramLayoutParams, paramWindowManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.widget.appfloat.FWTouchUtils
 * JD-Core Version:    0.7.0.1
 */