package com.tencent.falco.base.floatwindow.widget;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Point;
import androidx.annotation.LayoutRes;
import com.tencent.falco.base.floatwindow.bean.FloatWindowConfig;
import com.tencent.falco.base.floatwindow.interfaces.OnActivityFloatWindowAnimator;
import com.tencent.falco.base.floatwindow.interfaces.OnAppFloatWindowAnimator;
import com.tencent.falco.base.floatwindow.interfaces.OnDisplayHeight;
import com.tencent.falco.base.floatwindow.interfaces.OnFloatWindowCallbacks;
import com.tencent.falco.base.floatwindow.interfaces.OnFloatWindowPermissionListener;
import com.tencent.falco.base.floatwindow.interfaces.OnInvokeView;
import com.tencent.falco.base.floatwindow.permission.FWPermission;
import com.tencent.falco.base.floatwindow.utils.Logger;
import com.tencent.falco.base.floatwindow.widget.activityfloat.FWActivityManager;
import com.tencent.falco.base.floatwindow.widget.appfloat.FWAppManager;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/falco/base/floatwindow/widget/LiveFloatWindow;", "Lcom/tencent/falco/base/floatwindow/interfaces/OnFloatWindowPermissionListener;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "config", "Lcom/tencent/falco/base/floatwindow/bean/FloatWindowConfig;", "callbackCreateFailed", "", "reason", "", "checkUninitialized", "", "createActivityFloat", "createAppFloat", "hasEditText", "invokeView", "Lcom/tencent/falco/base/floatwindow/interfaces/OnInvokeView;", "permissionFinish", "isAuth", "registerCallbacks", "callbacks", "Lcom/tencent/falco/base/floatwindow/interfaces/OnFloatWindowCallbacks;", "requestPermission", "setAnimator", "floatAnimator", "Lcom/tencent/falco/base/floatwindow/interfaces/OnActivityFloatWindowAnimator;", "setAppFloatAnimator", "appFloatAnimator", "Lcom/tencent/falco/base/floatwindow/interfaces/OnAppFloatWindowAnimator;", "setDisplayHeight", "displayHeight", "Lcom/tencent/falco/base/floatwindow/interfaces/OnDisplayHeight;", "setDragEnable", "dragEnable", "setFilter", "clazz", "", "Ljava/lang/Class;", "([Ljava/lang/Class;)Lcom/tencent/falco/base/floatwindow/widget/LiveFloatWindow;", "setGravity", "gravity", "offsetX", "offsetY", "setHorizontalMargin", "margin", "", "setLayout", "layoutId", "setLocation", "x", "y", "setMatchParent", "widthMatch", "heightMatch", "setShowPattern", "showPattern", "setSidePattern", "sidePattern", "setTag", "floatTag", "", "setVerticalMargin", "show", "floatwindow_release"}, k=1, mv={1, 1, 15})
public final class LiveFloatWindow
  implements OnFloatWindowPermissionListener
{
  private final Context activity;
  private final FloatWindowConfig config;
  
  public LiveFloatWindow(@NotNull Context paramContext)
  {
    this.activity = paramContext;
    this.config = new FloatWindowConfig();
  }
  
  private final void callbackCreateFailed(int paramInt)
  {
    OnFloatWindowCallbacks localOnFloatWindowCallbacks = this.config.callbacks;
    if (localOnFloatWindowCallbacks != null) {
      localOnFloatWindowCallbacks.createdResult(false, paramInt, null);
    }
    Logger.w(Integer.valueOf(paramInt));
    if ((paramInt == 2) || (paramInt == 3) || (paramInt == 5)) {
      throw ((Throwable)new Exception("callbackCreateFailed失败:" + paramInt));
    }
  }
  
  private final boolean checkUninitialized()
  {
    switch (this.config.showPattern)
    {
    default: 
      return false;
    case 0: 
      return false;
    case 1: 
    case 2: 
    case 3: 
      return !LiveFloatWindowManager.getInstance().isInitialized;
    }
    ArrayList localArrayList = this.config.filterList;
    Intrinsics.checkExpressionValueIsNotNull(localArrayList, "config.filterList");
    if (!((Collection)localArrayList).isEmpty()) {}
    for (int i = 1; (i != 0) && (!LiveFloatWindowManager.getInstance().isInitialized); i = 0) {
      return true;
    }
    return false;
  }
  
  private final void createActivityFloat()
  {
    if ((this.activity instanceof Activity))
    {
      new FWActivityManager((Activity)this.activity).createFloat(this.config);
      return;
    }
    callbackCreateFailed(5);
  }
  
  private final void createAppFloat()
  {
    FWAppManager.INSTANCE.create(this.activity, this.config);
  }
  
  private final void requestPermission()
  {
    if ((this.activity instanceof Activity))
    {
      FWPermission.requestPermission((Activity)this.activity, (OnFloatWindowPermissionListener)this);
      return;
    }
    callbackCreateFailed(6);
  }
  
  @NotNull
  public final LiveFloatWindow hasEditText(boolean paramBoolean)
  {
    ((LiveFloatWindow)this).config.hasEditText = paramBoolean;
    return (LiveFloatWindow)this;
  }
  
  @NotNull
  public final LiveFloatWindow invokeView(@NotNull OnInvokeView paramOnInvokeView)
  {
    Intrinsics.checkParameterIsNotNull(paramOnInvokeView, "invokeView");
    ((LiveFloatWindow)this).config.invokeView = paramOnInvokeView;
    return (LiveFloatWindow)this;
  }
  
  public void permissionFinish(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      createAppFloat();
      return;
    }
    callbackCreateFailed(1);
  }
  
  @NotNull
  public final LiveFloatWindow registerCallbacks(@NotNull OnFloatWindowCallbacks paramOnFloatWindowCallbacks)
  {
    Intrinsics.checkParameterIsNotNull(paramOnFloatWindowCallbacks, "callbacks");
    ((LiveFloatWindow)this).config.callbacks = paramOnFloatWindowCallbacks;
    return (LiveFloatWindow)this;
  }
  
  @NotNull
  public final LiveFloatWindow setAnimator(@Nullable OnActivityFloatWindowAnimator paramOnActivityFloatWindowAnimator)
  {
    ((LiveFloatWindow)this).config.activityFloatAnimator = paramOnActivityFloatWindowAnimator;
    return (LiveFloatWindow)this;
  }
  
  @NotNull
  public final LiveFloatWindow setAppFloatAnimator(@Nullable OnAppFloatWindowAnimator paramOnAppFloatWindowAnimator)
  {
    ((LiveFloatWindow)this).config.appFloatAnimator = paramOnAppFloatWindowAnimator;
    return (LiveFloatWindow)this;
  }
  
  @NotNull
  public final LiveFloatWindow setDisplayHeight(@NotNull OnDisplayHeight paramOnDisplayHeight)
  {
    Intrinsics.checkParameterIsNotNull(paramOnDisplayHeight, "displayHeight");
    ((LiveFloatWindow)this).config.displayHeight = paramOnDisplayHeight;
    return (LiveFloatWindow)this;
  }
  
  @NotNull
  public final LiveFloatWindow setDragEnable(boolean paramBoolean)
  {
    ((LiveFloatWindow)this).config.dragEnable = paramBoolean;
    return (LiveFloatWindow)this;
  }
  
  @NotNull
  public final LiveFloatWindow setFilter(@NotNull Class<?>... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "clazz");
    LiveFloatWindow localLiveFloatWindow = (LiveFloatWindow)this;
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramVarArgs[i];
      localLiveFloatWindow.config.filterList.add(((Class)localObject).getName());
      if ((localLiveFloatWindow.activity instanceof Activity))
      {
        localObject = ((Class)localObject).getName();
        ComponentName localComponentName = ((Activity)localLiveFloatWindow.activity).getComponentName();
        Intrinsics.checkExpressionValueIsNotNull(localComponentName, "activity.componentName");
        if (Intrinsics.areEqual(localObject, localComponentName.getClassName())) {
          localLiveFloatWindow.config.filterSelf = true;
        }
      }
      i += 1;
    }
    return (LiveFloatWindow)this;
  }
  
  @JvmOverloads
  @NotNull
  public final LiveFloatWindow setGravity(int paramInt)
  {
    return setGravity$default(this, paramInt, 0, 0, 6, null);
  }
  
  @JvmOverloads
  @NotNull
  public final LiveFloatWindow setGravity(int paramInt1, int paramInt2)
  {
    return setGravity$default(this, paramInt1, paramInt2, 0, 4, null);
  }
  
  @JvmOverloads
  @NotNull
  public final LiveFloatWindow setGravity(int paramInt1, int paramInt2, int paramInt3)
  {
    LiveFloatWindow localLiveFloatWindow = (LiveFloatWindow)this;
    localLiveFloatWindow.config.gravity = paramInt1;
    localLiveFloatWindow.config.offsetPair = new Point(paramInt2, paramInt3);
    return (LiveFloatWindow)this;
  }
  
  @NotNull
  public final LiveFloatWindow setHorizontalMargin(float paramFloat)
  {
    ((LiveFloatWindow)this).config.horizontalMargin = paramFloat;
    return (LiveFloatWindow)this;
  }
  
  @JvmOverloads
  @NotNull
  public final LiveFloatWindow setLayout(@LayoutRes int paramInt)
  {
    return setLayout$default(this, paramInt, null, 2, null);
  }
  
  @JvmOverloads
  @NotNull
  public final LiveFloatWindow setLayout(@LayoutRes int paramInt, @Nullable OnInvokeView paramOnInvokeView)
  {
    LiveFloatWindow localLiveFloatWindow = (LiveFloatWindow)this;
    localLiveFloatWindow.config.layoutId = paramInt;
    localLiveFloatWindow.config.invokeView = paramOnInvokeView;
    return (LiveFloatWindow)this;
  }
  
  @NotNull
  public final LiveFloatWindow setLocation(int paramInt1, int paramInt2)
  {
    ((LiveFloatWindow)this).config.locationPair = new Point(paramInt1, paramInt2);
    return (LiveFloatWindow)this;
  }
  
  @NotNull
  public final LiveFloatWindow setMatchParent(boolean paramBoolean1, boolean paramBoolean2)
  {
    LiveFloatWindow localLiveFloatWindow = (LiveFloatWindow)this;
    localLiveFloatWindow.config.widthMatch = paramBoolean1;
    localLiveFloatWindow.config.heightMatch = paramBoolean2;
    return (LiveFloatWindow)this;
  }
  
  @NotNull
  public final LiveFloatWindow setShowPattern(int paramInt)
  {
    Object localObject = (LiveFloatWindow)this;
    ((LiveFloatWindow)localObject).config.showPattern = paramInt;
    if (!(((LiveFloatWindow)localObject).activity instanceof Activity)) {}
    for (;;)
    {
      return (LiveFloatWindow)this;
      if ((paramInt == 1) || (paramInt == 0))
      {
        FloatWindowConfig localFloatWindowConfig = ((LiveFloatWindow)localObject).config;
        localObject = ((Activity)((LiveFloatWindow)localObject).activity).getComponentName();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "activity.componentName");
        localFloatWindowConfig.currentActivityName = ((ComponentName)localObject).getClassName();
      }
    }
  }
  
  @NotNull
  public final LiveFloatWindow setSidePattern(int paramInt)
  {
    ((LiveFloatWindow)this).config.sidePattern = paramInt;
    return (LiveFloatWindow)this;
  }
  
  @NotNull
  public final LiveFloatWindow setTag(@Nullable String paramString)
  {
    ((LiveFloatWindow)this).config.floatTag = paramString;
    return (LiveFloatWindow)this;
  }
  
  @NotNull
  public final LiveFloatWindow setVerticalMargin(float paramFloat)
  {
    ((LiveFloatWindow)this).config.verticalMargin = paramFloat;
    return (LiveFloatWindow)this;
  }
  
  public final void show()
  {
    if (this.config.layoutId == -1) {
      callbackCreateFailed(2);
    }
    do
    {
      return;
      if (checkUninitialized())
      {
        callbackCreateFailed(3);
        return;
      }
      if (this.config.showPattern == 0)
      {
        createActivityFloat();
        return;
      }
    } while (!FWPermission.hasPermission(this.activity));
    createAppFloat();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.widget.LiveFloatWindow
 * JD-Core Version:    0.7.0.1
 */