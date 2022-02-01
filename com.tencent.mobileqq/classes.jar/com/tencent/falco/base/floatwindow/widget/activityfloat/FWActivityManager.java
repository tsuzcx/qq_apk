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
    int j = -1;
    Intrinsics.checkParameterIsNotNull(paramFloatWindowConfig, "config");
    FloatingView localFloatingView = new FloatingView((Context)this.activity, null, 2, null);
    localFloatingView.setTag(getTag(paramFloatWindowConfig.floatTag));
    int i;
    if (paramFloatWindowConfig.widthMatch)
    {
      i = -1;
      if (!paramFloatWindowConfig.heightMatch) {
        break label161;
      }
    }
    for (;;)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, j);
      if (Intrinsics.areEqual(paramFloatWindowConfig.locationPair, new Point(0, 0))) {
        localLayoutParams.gravity = paramFloatWindowConfig.gravity;
      }
      localFloatingView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      localFloatingView.setFloatConfig(paramFloatWindowConfig);
      this.parentFrame.addView((View)localFloatingView);
      paramFloatWindowConfig.layoutView = ((View)localFloatingView);
      paramFloatWindowConfig = paramFloatWindowConfig.callbacks;
      if (paramFloatWindowConfig != null) {
        paramFloatWindowConfig.createdResult(true, 0, (View)localFloatingView);
      }
      return;
      i = -2;
      break;
      label161:
      j = -2;
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
    paramString = floatingView(paramString);
    if (paramString != null)
    {
      paramString.setVisibility(paramInt);
      OnFloatWindowCallbacks localOnFloatWindowCallbacks;
      if (paramInt == 8)
      {
        localOnFloatWindowCallbacks = paramString.getConfig().callbacks;
        if (localOnFloatWindowCallbacks != null) {
          localOnFloatWindowCallbacks.hide((View)paramString);
        }
      }
      for (;;)
      {
        return paramString;
        localOnFloatWindowCallbacks = paramString.getConfig().callbacks;
        if (localOnFloatWindowCallbacks != null) {
          localOnFloatWindowCallbacks.show((View)paramString);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.widget.activityfloat.FWActivityManager
 * JD-Core Version:    0.7.0.1
 */