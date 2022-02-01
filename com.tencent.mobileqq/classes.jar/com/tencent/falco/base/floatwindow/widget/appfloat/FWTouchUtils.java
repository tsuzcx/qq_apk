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
    int i;
    int j;
    if (this.hasStatusBar)
    {
      i = this.parentHeight - statusBarHeight(paramView) - this.topDistance;
      j = paramView.getHeight();
    }
    else
    {
      i = this.parentHeight - this.topDistance;
      j = paramView.getHeight();
    }
    this.bottomDistance = (i - j);
    this.minX = Math.min(this.leftDistance, this.rightDistance);
    this.minY = Math.min(this.topDistance, this.bottomDistance);
  }
  
  private final void sideAnim(View paramView, WindowManager.LayoutParams paramLayoutParams, WindowManager paramWindowManager)
  {
    initDistanceValue(paramLayoutParams, paramView);
    int k = (int)this.config.horizontalMargin;
    int j = (int)this.config.verticalMargin;
    int i = k;
    switch (this.config.sidePattern)
    {
    default: 
      return;
    case 15: 
      if (this.minX < this.minY)
      {
        if (this.leftDistance < this.rightDistance)
        {
          i = k;
          break label318;
        }
        i = paramLayoutParams.x;
        j = this.rightDistance;
      }
      else if (this.topDistance >= this.bottomDistance)
      {
        if (this.hasStatusBar) {
          i = this.emptyHeight - statusBarHeight(paramView);
        } else {
          i = this.emptyHeight;
        }
      }
      break;
    case 14: 
      if (this.topDistance >= this.bottomDistance) {
        if (this.hasStatusBar) {
          i = this.emptyHeight - statusBarHeight(paramView);
        } else {
          i = this.emptyHeight;
        }
      }
      break;
    case 13: 
      if (this.leftDistance < this.rightDistance)
      {
        i = k;
      }
      else
      {
        i = paramLayoutParams.x;
        j = this.rightDistance;
      }
      break;
    case 12: 
      if (this.hasStatusBar) {
        i = this.emptyHeight - statusBarHeight(paramView);
      } else {
        i = this.emptyHeight;
      }
      i -= j;
      break;
    case 11: 
      i = j;
      bool = false;
      break;
    case 10: 
      i = paramLayoutParams.x;
      j = this.rightDistance;
      i = i + j - k;
    }
    label318:
    boolean bool = true;
    if (bool) {
      j = paramLayoutParams.x;
    } else {
      j = paramLayoutParams.y;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { j, i });
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new FWTouchUtils.sideAnim.1(bool, paramLayoutParams, paramWindowManager, paramView));
    localValueAnimator.addListener((Animator.AnimatorListener)new FWTouchUtils.sideAnim.2(this, paramView));
    localValueAnimator.start();
  }
  
  private final void sideAnimWhenOutOfScreen(View paramView, WindowManager.LayoutParams paramLayoutParams, WindowManager paramWindowManager)
  {
    initDistanceValue(paramLayoutParams, paramView);
    int i = (int)this.config.horizontalMargin;
    int k = (int)this.config.verticalMargin;
    int j = paramLayoutParams.x;
    int m = paramLayoutParams.y;
    if ((this.leftDistance < 0) || (this.rightDistance < 0))
    {
      if (this.leftDistance >= this.rightDistance) {
        i = paramLayoutParams.x + this.rightDistance - i;
      }
      j = i;
    }
    if (this.topDistance >= 0)
    {
      i = m;
      if (this.bottomDistance >= 0) {}
    }
    else
    {
      if (this.topDistance < this.bottomDistance) {
        i = k;
      }
      for (;;)
      {
        break;
        if (this.hasStatusBar) {
          i = this.emptyHeight - statusBarHeight(paramView);
        } else {
          i = this.emptyHeight;
        }
        i -= k;
      }
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramLayoutParams.x, j });
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new FWTouchUtils.sideAnimWhenOutOfScreen.1(paramLayoutParams, paramWindowManager, paramView));
    localValueAnimator.addListener((Animator.AnimatorListener)new FWTouchUtils.sideAnimWhenOutOfScreen.2(this, paramView));
    paramView = ValueAnimator.ofInt(new int[] { paramLayoutParams.y, i });
    paramView.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new FWTouchUtils.sideAnimWhenOutOfScreen.3(paramLayoutParams));
    paramLayoutParams = new AnimatorSet();
    paramLayoutParams.playTogether(new Animator[] { (Animator)localValueAnimator, (Animator)paramView });
    paramLayoutParams.start();
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
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    Intrinsics.checkParameterIsNotNull(paramWindowManager, "windowManager");
    Intrinsics.checkParameterIsNotNull(paramLayoutParams, "params");
    OnFloatWindowCallbacks localOnFloatWindowCallbacks = this.config.callbacks;
    if (localOnFloatWindowCallbacks != null) {
      localOnFloatWindowCallbacks.touchEvent(paramView, paramMotionEvent);
    }
    boolean bool2 = this.config.dragEnable;
    boolean bool1 = false;
    if ((bool2) && (!this.config.isAnim))
    {
      float f6 = this.config.horizontalMargin;
      float f4 = this.config.verticalMargin;
      int i = paramMotionEvent.getAction() & 0xFF;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return;
          }
          float f2 = paramMotionEvent.getRawX() - this.lastX;
          float f1 = paramMotionEvent.getRawY() - this.lastY;
          if ((!this.config.isDrag) && (f2 * f2 + f1 * f1 < 81)) {
            return;
          }
          this.config.isDrag = true;
          float f3 = f2 + paramLayoutParams.x;
          float f5 = paramLayoutParams.y + f1;
          f1 = f4;
          f2 = f6;
          int j;
          switch (this.config.sidePattern)
          {
          case 6: 
          default: 
            f1 = f3;
            f2 = f5;
            break;
          case 8: 
            this.leftDistance = ((int)paramMotionEvent.getRawX());
            this.rightDistance = (this.parentWidth - (int)paramMotionEvent.getRawX());
            this.topDistance = ((int)paramMotionEvent.getRawY() - this.parentRect.top);
            this.bottomDistance = (this.parentHeight + this.parentRect.top - (int)paramMotionEvent.getRawY());
            this.minX = Math.min(this.leftDistance, this.rightDistance);
            this.minY = Math.min(this.topDistance, this.bottomDistance);
            i = this.minX;
            j = this.minY;
            if (i < j)
            {
              if (this.leftDistance == i)
              {
                f2 = f6;
                break label612;
              }
              i = this.parentWidth;
              j = paramView.getWidth();
            }
            else if (this.topDistance == j)
            {
              f1 = f4;
            }
            else
            {
              i = this.parentHeight;
              j = paramView.getHeight();
            }
            break;
          case 7: 
            f2 = paramMotionEvent.getRawY();
            f5 = this.parentRect.top;
            f6 = 2;
            i = this.parentHeight;
            f1 = f4;
            if ((f2 - f5) * f6 > i) {
              f1 = i - paramView.getHeight();
            }
            break;
          case 5: 
            f1 = paramMotionEvent.getRawX();
            f3 = 2;
            i = this.parentWidth;
            f2 = f6;
            if (f1 * f3 > i) {
              j = paramView.getWidth();
            }
            break;
          case 4: 
            i = this.parentHeight;
            j = paramView.getHeight();
            f1 = i - j;
            f1 -= f4;
          case 3: 
            f2 = f1;
            f1 = f3;
            break;
          case 2: 
            i = this.parentWidth;
            j = paramView.getWidth();
            f2 = i - j - f6;
          }
          label612:
          f1 = f2;
          f2 = f5;
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
        }
        if (!this.config.isDrag) {
          return;
        }
        switch (this.config.sidePattern)
        {
        default: 
          paramMotionEvent = this.config.callbacks;
          if (paramMotionEvent == null) {
            break;
          }
          paramMotionEvent.dragEnd(paramView);
          return;
        case 16: 
          sideAnimWhenOutOfScreen(paramView, paramLayoutParams, paramWindowManager);
          return;
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
          sideAnim(paramView, paramLayoutParams, paramWindowManager);
          return;
        }
      }
      else
      {
        this.config.isDrag = false;
        this.lastX = paramMotionEvent.getRawX();
        this.lastY = paramMotionEvent.getRawY();
        this.parentWidth = UIUtil.getScreenWidth(this.context);
        this.parentHeight = this.config.displayHeight.getDisplayRealHeight(this.context);
        paramView.getLocationOnScreen(this.location);
        if (this.location[1] > paramLayoutParams.y) {
          bool1 = true;
        }
        this.hasStatusBar = bool1;
        this.emptyHeight = (this.parentHeight - paramView.getHeight());
      }
      return;
    }
    this.config.isDrag = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.widget.appfloat.FWTouchUtils
 * JD-Core Version:    0.7.0.1
 */