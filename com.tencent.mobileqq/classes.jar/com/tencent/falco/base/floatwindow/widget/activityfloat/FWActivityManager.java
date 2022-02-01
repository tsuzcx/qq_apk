package com.tencent.falco.base.floatwindow.widget.activityfloat;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.falco.base.floatwindow.bean.FloatWindowConfig;
import com.tencent.falco.base.floatwindow.interfaces.OnFloatWindowCallbacks;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/falco/base/floatwindow/widget/activityfloat/FWActivityManager;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "parentFrame", "Landroid/widget/FrameLayout;", "createFloat", "", "config", "Lcom/tencent/falco/base/floatwindow/bean/FloatWindowConfig;", "dismiss", "tag", "", "(Ljava/lang/String;)Lkotlin/Unit;", "floatingView", "Lcom/tencent/falco/base/floatwindow/widget/activityfloat/FloatingView;", "getFloatView", "Landroid/view/View;", "getTag", "kotlin.jvm.PlatformType", "isShow", "", "setDragEnable", "dragEnable", "setVisibility", "visibility", "", "floatwindow_release"}, k=1, mv={1, 1, 15})
public final class FWActivityManager
{
  @NotNull
  private final Activity activity;
  private FrameLayout parentFrame;
  
  public FWActivityManager(@NotNull Activity paramActivity)
  {
    this.activity = paramActivity;
    paramActivity = this.activity.getWindow();
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "activity.window");
    paramActivity = paramActivity.getDecorView().findViewById(16908290);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "activity.window.decorVie…yId(android.R.id.content)");
    this.parentFrame = ((FrameLayout)paramActivity);
  }
  
  private final FloatingView floatingView(String paramString)
  {
    return (FloatingView)this.parentFrame.findViewWithTag(getTag(paramString));
  }
  
  private final String getTag(String paramString)
  {
    if (paramString != null) {
      return paramString;
    }
    paramString = this.activity.getComponentName();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "activity.componentName");
    return paramString.getClassName();
  }
  
  public final void createFloat(@NotNull FloatWindowConfig paramFloatWindowConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramFloatWindowConfig, "config");
    Object localObject1 = new FloatingView((Context)this.activity, null, 2, null);
    ((FloatingView)localObject1).setTag(getTag(paramFloatWindowConfig.floatTag));
    boolean bool = paramFloatWindowConfig.widthMatch;
    int j = -1;
    int i;
    if (bool) {
      i = -1;
    } else {
      i = -2;
    }
    if (!paramFloatWindowConfig.heightMatch) {
      j = -2;
    }
    Object localObject2 = new FrameLayout.LayoutParams(i, j);
    if (Intrinsics.areEqual(paramFloatWindowConfig.locationPair, new Point(0, 0))) {
      ((FrameLayout.LayoutParams)localObject2).gravity = paramFloatWindowConfig.gravity;
    }
    ((FloatingView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((FloatingView)localObject1).setFloatConfig(paramFloatWindowConfig);
    localObject2 = this.parentFrame;
    localObject1 = (View)localObject1;
    ((FrameLayout)localObject2).addView((View)localObject1);
    paramFloatWindowConfig.layoutView = ((View)localObject1);
    paramFloatWindowConfig = paramFloatWindowConfig.callbacks;
    if (paramFloatWindowConfig != null) {
      paramFloatWindowConfig.createdResult(true, 0, (View)localObject1);
    }
  }
  
  @Nullable
  public final Unit dismiss(@Nullable String paramString)
  {
    paramString = floatingView(paramString);
    if (paramString != null)
    {
      paramString.exitAnim$floatwindow_release();
      return Unit.INSTANCE;
    }
    return null;
  }
  
  @NotNull
  public final Activity getActivity()
  {
    return this.activity;
  }
  
  @Nullable
  public final View getFloatView(@Nullable String paramString)
  {
    paramString = floatingView(paramString);
    if (paramString != null)
    {
      paramString = paramString.getConfig();
      if (paramString != null) {
        return paramString.layoutView;
      }
    }
    return null;
  }
  
  public final boolean isShow(@Nullable String paramString)
  {
    paramString = floatingView(paramString);
    return (paramString != null) && (paramString.getVisibility() == 0);
  }
  
  public final void setDragEnable(boolean paramBoolean, @Nullable String paramString)
  {
    paramString = floatingView(paramString);
    if (paramString != null)
    {
      paramString = paramString.getConfig();
      if (paramString != null) {
        paramString.dragEnable = paramBoolean;
      }
    }
  }
  
  @Nullable
  public final FloatingView setVisibility(@Nullable String paramString, int paramInt)
  {
    FloatingView localFloatingView = floatingView(paramString);
    if (localFloatingView != null)
    {
      localFloatingView.setVisibility(paramInt);
      OnFloatWindowCallbacks localOnFloatWindowCallbacks;
      if (paramInt == 8)
      {
        localOnFloatWindowCallbacks = localFloatingView.getConfig().callbacks;
        paramString = localFloatingView;
        if (localOnFloatWindowCallbacks != null)
        {
          localOnFloatWindowCallbacks.hide((View)localFloatingView);
          return localFloatingView;
        }
      }
      else
      {
        localOnFloatWindowCallbacks = localFloatingView.getConfig().callbacks;
        paramString = localFloatingView;
        if (localOnFloatWindowCallbacks != null)
        {
          localOnFloatWindowCallbacks.show((View)localFloatingView);
          return localFloatingView;
        }
      }
    }
    else
    {
      paramString = null;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.widget.activityfloat.FWActivityManager
 * JD-Core Version:    0.7.0.1
 */