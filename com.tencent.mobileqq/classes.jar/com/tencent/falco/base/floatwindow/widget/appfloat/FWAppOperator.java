package com.tencent.falco.base.floatwindow.widget.appfloat;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.falco.base.floatwindow.animmanager.FWAppAnimatorManager;
import com.tencent.falco.base.floatwindow.bean.FloatWindowConfig;
import com.tencent.falco.base.floatwindow.interfaces.OnFloatWindowCallbacks;
import com.tencent.falco.base.floatwindow.interfaces.OnFloatWindowTouchListener;
import com.tencent.falco.base.floatwindow.utils.Logger;
import com.tencent.falco.utils.UIUtil;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/falco/base/floatwindow/widget/appfloat/FWAppOperator;", "", "context", "Landroid/content/Context;", "config", "Lcom/tencent/falco/base/floatwindow/bean/FloatWindowConfig;", "(Landroid/content/Context;Lcom/tencent/falco/base/floatwindow/bean/FloatWindowConfig;)V", "getConfig", "()Lcom/tencent/falco/base/floatwindow/bean/FloatWindowConfig;", "setConfig", "(Lcom/tencent/falco/base/floatwindow/bean/FloatWindowConfig;)V", "getContext", "()Landroid/content/Context;", "frameLayout", "Lcom/tencent/falco/base/floatwindow/widget/appfloat/ParentFrameLayout;", "getFrameLayout", "()Lcom/tencent/falco/base/floatwindow/widget/appfloat/ParentFrameLayout;", "setFrameLayout", "(Lcom/tencent/falco/base/floatwindow/widget/appfloat/ParentFrameLayout;)V", "params", "Landroid/view/WindowManager$LayoutParams;", "getParams", "()Landroid/view/WindowManager$LayoutParams;", "setParams", "(Landroid/view/WindowManager$LayoutParams;)V", "touchUtils", "Lcom/tencent/falco/base/floatwindow/widget/appfloat/FWTouchUtils;", "windowManager", "Landroid/view/WindowManager;", "getWindowManager", "()Landroid/view/WindowManager;", "setWindowManager", "(Landroid/view/WindowManager;)V", "addView", "", "createFloat", "()Lkotlin/Unit;", "enterAnim", "floatingView", "Landroid/view/View;", "exitAnim", "floatOver", "initParams", "setGravity", "view", "setVisible", "visible", "", "needShow", "", "updateWindowParams", "Companion", "floatwindow_release"}, k=1, mv={1, 1, 15})
public final class FWAppOperator
{
  public static final FWAppOperator.Companion Companion = new FWAppOperator.Companion(null);
  private static final String TAG = "FWAppOperator";
  @NotNull
  private FloatWindowConfig config;
  @NotNull
  private final Context context;
  @Nullable
  private ParentFrameLayout frameLayout;
  @NotNull
  public WindowManager.LayoutParams params;
  private FWTouchUtils touchUtils;
  @NotNull
  public WindowManager windowManager;
  
  public FWAppOperator(@NotNull Context paramContext, @NotNull FloatWindowConfig paramFloatWindowConfig)
  {
    this.context = paramContext;
    this.config = paramFloatWindowConfig;
  }
  
  private final void addView()
  {
    this.frameLayout = new ParentFrameLayout(this.context, this.config, null, 0, 12, null);
    Object localObject1 = this.frameLayout;
    if (localObject1 != null) {
      ((ParentFrameLayout)localObject1).setTag(this.config.floatTag);
    }
    if (this.config.layoutId == -1) {}
    Object localObject2;
    do
    {
      return;
      localObject1 = LayoutInflater.from(this.context).inflate(this.config.layoutId, (ViewGroup)this.frameLayout, true);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "floatingView");
      ((View)localObject1).setVisibility(4);
      localObject2 = this.windowManager;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("windowManager");
      }
      View localView = (View)this.frameLayout;
      WindowManager.LayoutParams localLayoutParams = this.params;
      if (localLayoutParams == null) {
        Intrinsics.throwUninitializedPropertyAccessException("params");
      }
      ((WindowManager)localObject2).addView(localView, (ViewGroup.LayoutParams)localLayoutParams);
      localObject2 = this.frameLayout;
      if (localObject2 != null) {
        ((ParentFrameLayout)localObject2).setTouchListener((OnFloatWindowTouchListener)new FWAppOperator.addView.1(this));
      }
      localObject2 = this.frameLayout;
    } while (localObject2 == null);
    ((ParentFrameLayout)localObject2).setLayoutListener((ParentFrameLayout.OnLayoutListener)new FWAppOperator.addView.2(this, (View)localObject1));
  }
  
  private final void enterAnim(View paramView)
  {
    if ((this.frameLayout == null) || (this.config.isAnim)) {
      return;
    }
    Object localObject = this.frameLayout;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = (View)localObject;
    WindowManager.LayoutParams localLayoutParams = this.params;
    if (localLayoutParams == null) {
      Intrinsics.throwUninitializedPropertyAccessException("params");
    }
    WindowManager localWindowManager = this.windowManager;
    if (localWindowManager == null) {
      Intrinsics.throwUninitializedPropertyAccessException("windowManager");
    }
    localObject = new FWAppAnimatorManager((View)localObject, localLayoutParams, localWindowManager, this.config).enterAnim();
    if (localObject != null)
    {
      localLayoutParams = this.params;
      if (localLayoutParams == null) {
        Intrinsics.throwUninitializedPropertyAccessException("params");
      }
      localLayoutParams.flags = 552;
      ((Animator)localObject).addListener((Animator.AnimatorListener)new FWAppOperator.enterAnim.1(this, paramView));
      ((Animator)localObject).start();
      return;
    }
    paramView.setVisibility(0);
    localObject = this.windowManager;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("windowManager");
    }
    localLayoutParams = this.params;
    if (localLayoutParams == null) {
      Intrinsics.throwUninitializedPropertyAccessException("params");
    }
    ((WindowManager)localObject).updateViewLayout(paramView, (ViewGroup.LayoutParams)localLayoutParams);
  }
  
  private final void floatOver()
  {
    try
    {
      this.config.isAnim = false;
      FWAppManager.INSTANCE.remove(this.config.floatTag);
      WindowManager localWindowManager = this.windowManager;
      if (localWindowManager == null) {
        Intrinsics.throwUninitializedPropertyAccessException("windowManager");
      }
      localWindowManager.removeView((View)this.frameLayout);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("FWAppOperator", "浮窗关闭出现异常");
      localException.printStackTrace();
    }
  }
  
  private final void initParams()
  {
    int j = -1;
    Object localObject = this.context.getSystemService("window");
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
    }
    this.windowManager = ((WindowManager)localObject);
    localObject = new WindowManager.LayoutParams();
    if (Build.VERSION.SDK_INT >= 26)
    {
      i = 2038;
      ((WindowManager.LayoutParams)localObject).type = i;
      ((WindowManager.LayoutParams)localObject).format = 1;
      ((WindowManager.LayoutParams)localObject).gravity = 8388659;
      ((WindowManager.LayoutParams)localObject).flags = 40;
      if (!this.config.widthMatch) {
        break label178;
      }
      i = -1;
      label91:
      ((WindowManager.LayoutParams)localObject).width = i;
      if (!this.config.heightMatch) {
        break label184;
      }
    }
    label178:
    label184:
    for (int i = j;; i = -2)
    {
      ((WindowManager.LayoutParams)localObject).height = i;
      if ((Intrinsics.areEqual(this.config.locationPair, new Point(0, 0)) ^ true))
      {
        ((WindowManager.LayoutParams)localObject).x = this.config.locationPair.x;
        ((WindowManager.LayoutParams)localObject).y = this.config.locationPair.y;
      }
      this.params = ((WindowManager.LayoutParams)localObject);
      return;
      i = 2002;
      break;
      i = -2;
      break label91;
    }
  }
  
  @SuppressLint({"RtlHardcoded"})
  private final void setGravity(View paramView)
  {
    if (((Intrinsics.areEqual(this.config.locationPair, new Point(0, 0)) ^ true)) || (paramView == null)) {
      return;
    }
    Object localObject1 = new Rect();
    Object localObject2 = this.windowManager;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("windowManager");
    }
    ((WindowManager)localObject2).getDefaultDisplay().getRectSize((Rect)localObject1);
    int i = ((Rect)localObject1).bottom - UIUtil.getStatusBarHeight(paramView.getContext());
    switch (this.config.gravity)
    {
    }
    for (;;)
    {
      localObject1 = this.params;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("params");
      }
      ((WindowManager.LayoutParams)localObject1).x += this.config.offsetPair.x;
      localObject1 = this.params;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("params");
      }
      ((WindowManager.LayoutParams)localObject1).y += this.config.offsetPair.y;
      localObject1 = this.windowManager;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("windowManager");
      }
      localObject2 = this.params;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("params");
      }
      ((WindowManager)localObject1).updateViewLayout(paramView, (ViewGroup.LayoutParams)localObject2);
      return;
      localObject2 = this.params;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("params");
      }
      ((WindowManager.LayoutParams)localObject2).x = (((Rect)localObject1).right - paramView.getWidth());
      continue;
      localObject1 = this.params;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("params");
      }
      ((WindowManager.LayoutParams)localObject1).y = (i - paramView.getHeight());
      continue;
      localObject2 = this.params;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("params");
      }
      ((WindowManager.LayoutParams)localObject2).x = (((Rect)localObject1).right - paramView.getWidth());
      localObject1 = this.params;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("params");
      }
      ((WindowManager.LayoutParams)localObject1).y = (i - paramView.getHeight());
      continue;
      localObject2 = this.params;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("params");
      }
      ((WindowManager.LayoutParams)localObject2).x = ((int)((((Rect)localObject1).right - paramView.getWidth()) * 0.5F));
      localObject1 = this.params;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("params");
      }
      ((WindowManager.LayoutParams)localObject1).y = ((int)((i - paramView.getHeight()) * 0.5F));
      continue;
      localObject2 = this.params;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("params");
      }
      ((WindowManager.LayoutParams)localObject2).x = ((int)((((Rect)localObject1).right - paramView.getWidth()) * 0.5F));
      continue;
      localObject2 = this.params;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("params");
      }
      ((WindowManager.LayoutParams)localObject2).x = ((int)((((Rect)localObject1).right - paramView.getWidth()) * 0.5F));
      localObject1 = this.params;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("params");
      }
      ((WindowManager.LayoutParams)localObject1).y = (i - paramView.getHeight());
      continue;
      localObject1 = this.params;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("params");
      }
      ((WindowManager.LayoutParams)localObject1).y = ((int)((i - paramView.getHeight()) * 0.5F));
      continue;
      localObject2 = this.params;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("params");
      }
      ((WindowManager.LayoutParams)localObject2).x = (((Rect)localObject1).right - paramView.getWidth());
      localObject1 = this.params;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("params");
      }
      ((WindowManager.LayoutParams)localObject1).y = ((int)((i - paramView.getHeight()) * 0.5F));
    }
  }
  
  @Nullable
  public final Unit createFloat()
  {
    Object localObject = null;
    try
    {
      this.touchUtils = new FWTouchUtils(this.context, this.config);
      initParams();
      addView();
      this.config.isShow = true;
      Unit localUnit = Unit.INSTANCE;
      localObject = localUnit;
    }
    catch (Exception localException)
    {
      OnFloatWindowCallbacks localOnFloatWindowCallbacks;
      do
      {
        localOnFloatWindowCallbacks = this.config.callbacks;
      } while (localOnFloatWindowCallbacks == null);
      localOnFloatWindowCallbacks.createdResult(false, 7, null);
    }
    return localObject;
    return Unit.INSTANCE;
  }
  
  public final void exitAnim()
  {
    if (this.frameLayout == null) {
      return;
    }
    if (this.config.isAnim)
    {
      floatOver();
      return;
    }
    Object localObject = this.frameLayout;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = (View)localObject;
    WindowManager.LayoutParams localLayoutParams = this.params;
    if (localLayoutParams == null) {
      Intrinsics.throwUninitializedPropertyAccessException("params");
    }
    WindowManager localWindowManager = this.windowManager;
    if (localWindowManager == null) {
      Intrinsics.throwUninitializedPropertyAccessException("windowManager");
    }
    localObject = new FWAppAnimatorManager((View)localObject, localLayoutParams, localWindowManager, this.config).exitAnim();
    if (localObject == null)
    {
      floatOver();
      return;
    }
    localLayoutParams = this.params;
    if (localLayoutParams == null) {
      Intrinsics.throwUninitializedPropertyAccessException("params");
    }
    localLayoutParams.flags = 552;
    ((Animator)localObject).addListener((Animator.AnimatorListener)new FWAppOperator.exitAnim.1(this));
    ((Animator)localObject).start();
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
  
  @Nullable
  public final ParentFrameLayout getFrameLayout()
  {
    return this.frameLayout;
  }
  
  @NotNull
  public final WindowManager.LayoutParams getParams()
  {
    WindowManager.LayoutParams localLayoutParams = this.params;
    if (localLayoutParams == null) {
      Intrinsics.throwUninitializedPropertyAccessException("params");
    }
    return localLayoutParams;
  }
  
  @NotNull
  public final WindowManager getWindowManager()
  {
    WindowManager localWindowManager = this.windowManager;
    if (localWindowManager == null) {
      Intrinsics.throwUninitializedPropertyAccessException("windowManager");
    }
    return localWindowManager;
  }
  
  public final void setConfig(@NotNull FloatWindowConfig paramFloatWindowConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramFloatWindowConfig, "<set-?>");
    this.config = paramFloatWindowConfig;
  }
  
  public final void setFrameLayout(@Nullable ParentFrameLayout paramParentFrameLayout)
  {
    this.frameLayout = paramParentFrameLayout;
  }
  
  public final void setParams(@NotNull WindowManager.LayoutParams paramLayoutParams)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutParams, "<set-?>");
    this.params = paramLayoutParams;
  }
  
  public final void setVisible(int paramInt, boolean paramBoolean)
  {
    if (this.frameLayout == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            this.config.needShow = Boolean.valueOf(paramBoolean);
            localObject = this.frameLayout;
            if (localObject != null) {
              ((ParentFrameLayout)localObject).setVisibility(paramInt);
            }
            if (paramInt != 0) {
              break;
            }
            this.config.isShow = true;
            localObject = this.frameLayout;
            if (localObject == null) {
              Intrinsics.throwNpe();
            }
          } while (((ParentFrameLayout)localObject).getChildCount() <= 0);
          localObject = this.config.callbacks;
        } while (localObject == null);
        localParentFrameLayout = this.frameLayout;
        if (localParentFrameLayout == null) {
          Intrinsics.throwNpe();
        }
        ((OnFloatWindowCallbacks)localObject).show(localParentFrameLayout.getChildAt(0));
        return;
        this.config.isShow = false;
        localObject = this.frameLayout;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
      } while (((ParentFrameLayout)localObject).getChildCount() <= 0);
      localObject = this.config.callbacks;
    } while (localObject == null);
    ParentFrameLayout localParentFrameLayout = this.frameLayout;
    if (localParentFrameLayout == null) {
      Intrinsics.throwNpe();
    }
    ((OnFloatWindowCallbacks)localObject).hide(localParentFrameLayout.getChildAt(0));
  }
  
  public final void setWindowManager(@NotNull WindowManager paramWindowManager)
  {
    Intrinsics.checkParameterIsNotNull(paramWindowManager, "<set-?>");
    this.windowManager = paramWindowManager;
  }
  
  public final void updateWindowParams(@NotNull WindowManager.LayoutParams paramLayoutParams)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutParams, "params");
    WindowManager localWindowManager = this.windowManager;
    if (localWindowManager == null) {
      Intrinsics.throwUninitializedPropertyAccessException("windowManager");
    }
    if (localWindowManager == null) {}
    while (this.frameLayout == null) {
      return;
    }
    localWindowManager = this.windowManager;
    if (localWindowManager == null) {
      Intrinsics.throwUninitializedPropertyAccessException("windowManager");
    }
    localWindowManager.updateViewLayout((View)this.frameLayout, (ViewGroup.LayoutParams)paramLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.widget.appfloat.FWAppOperator
 * JD-Core Version:    0.7.0.1
 */