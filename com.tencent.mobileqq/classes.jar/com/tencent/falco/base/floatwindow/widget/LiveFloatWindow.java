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
    Object localObject = this.config.callbacks;
    if (localObject != null) {
      ((OnFloatWindowCallbacks)localObject).createdResult(false, paramInt, null);
    }
    Logger.w(Integer.valueOf(paramInt));
    if ((paramInt != 2) && (paramInt != 3) && (paramInt != 5)) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("callbackCreateFailed失败:");
    ((StringBuilder)localObject).append(paramInt);
    throw ((Throwable)new Exception(((StringBuilder)localObject).toString()));
  }
  
  private final boolean checkUninitialized()
  {
    int i = this.config.showPattern;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i != 0)
    {
      if ((i != 1) && (i != 2) && (i != 3))
      {
        if (i != 4) {
          return false;
        }
        ArrayList localArrayList = this.config.filterList;
        Intrinsics.checkExpressionValueIsNotNull(localArrayList, "config.filterList");
        bool1 = bool2;
        if (!(((Collection)localArrayList).isEmpty() ^ true)) {
          return bool1;
        }
        bool1 = bool2;
        if (LiveFloatWindowManager.getInstance().isInitialized) {
          return bool1;
        }
      }
      else
      {
        bool1 = bool2;
        if (LiveFloatWindowManager.getInstance().isInitialized) {
          return bool1;
        }
      }
      bool1 = true;
    }
    return bool1;
  }
  
  private final void createActivityFloat()
  {
    Context localContext = this.activity;
    if ((localContext instanceof Activity))
    {
      new FWActivityManager((Activity)localContext).createFloat(this.config);
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
    Context localContext = this.activity;
    if ((localContext instanceof Activity))
    {
      FWPermission.requestPermission((Activity)localContext, (OnFloatWindowPermissionListener)this);
      return;
    }
    callbackCreateFailed(6);
  }
  
  @NotNull
  public final LiveFloatWindow hasEditText(boolean paramBoolean)
  {
    LiveFloatWindow localLiveFloatWindow = (LiveFloatWindow)this;
    localLiveFloatWindow.config.hasEditText = paramBoolean;
    return localLiveFloatWindow;
  }
  
  @NotNull
  public final LiveFloatWindow invokeView(@NotNull OnInvokeView paramOnInvokeView)
  {
    Intrinsics.checkParameterIsNotNull(paramOnInvokeView, "invokeView");
    LiveFloatWindow localLiveFloatWindow = (LiveFloatWindow)this;
    localLiveFloatWindow.config.invokeView = paramOnInvokeView;
    return localLiveFloatWindow;
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
    LiveFloatWindow localLiveFloatWindow = (LiveFloatWindow)this;
    localLiveFloatWindow.config.callbacks = paramOnFloatWindowCallbacks;
    return localLiveFloatWindow;
  }
  
  @NotNull
  public final LiveFloatWindow setAnimator(@Nullable OnActivityFloatWindowAnimator paramOnActivityFloatWindowAnimator)
  {
    LiveFloatWindow localLiveFloatWindow = (LiveFloatWindow)this;
    localLiveFloatWindow.config.activityFloatAnimator = paramOnActivityFloatWindowAnimator;
    return localLiveFloatWindow;
  }
  
  @NotNull
  public final LiveFloatWindow setAppFloatAnimator(@Nullable OnAppFloatWindowAnimator paramOnAppFloatWindowAnimator)
  {
    LiveFloatWindow localLiveFloatWindow = (LiveFloatWindow)this;
    localLiveFloatWindow.config.appFloatAnimator = paramOnAppFloatWindowAnimator;
    return localLiveFloatWindow;
  }
  
  @NotNull
  public final LiveFloatWindow setDisplayHeight(@NotNull OnDisplayHeight paramOnDisplayHeight)
  {
    Intrinsics.checkParameterIsNotNull(paramOnDisplayHeight, "displayHeight");
    LiveFloatWindow localLiveFloatWindow = (LiveFloatWindow)this;
    localLiveFloatWindow.config.displayHeight = paramOnDisplayHeight;
    return localLiveFloatWindow;
  }
  
  @NotNull
  public final LiveFloatWindow setDragEnable(boolean paramBoolean)
  {
    LiveFloatWindow localLiveFloatWindow = (LiveFloatWindow)this;
    localLiveFloatWindow.config.dragEnable = paramBoolean;
    return localLiveFloatWindow;
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
    return localLiveFloatWindow;
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
    FloatWindowConfig localFloatWindowConfig = localLiveFloatWindow.config;
    localFloatWindowConfig.gravity = paramInt1;
    localFloatWindowConfig.offsetPair = new Point(paramInt2, paramInt3);
    return localLiveFloatWindow;
  }
  
  @NotNull
  public final LiveFloatWindow setHorizontalMargin(float paramFloat)
  {
    LiveFloatWindow localLiveFloatWindow = (LiveFloatWindow)this;
    localLiveFloatWindow.config.horizontalMargin = paramFloat;
    return localLiveFloatWindow;
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
    FloatWindowConfig localFloatWindowConfig = localLiveFloatWindow.config;
    localFloatWindowConfig.layoutId = paramInt;
    localFloatWindowConfig.invokeView = paramOnInvokeView;
    return localLiveFloatWindow;
  }
  
  @NotNull
  public final LiveFloatWindow setLocation(int paramInt1, int paramInt2)
  {
    LiveFloatWindow localLiveFloatWindow = (LiveFloatWindow)this;
    localLiveFloatWindow.config.locationPair = new Point(paramInt1, paramInt2);
    return localLiveFloatWindow;
  }
  
  @NotNull
  public final LiveFloatWindow setMatchParent(boolean paramBoolean1, boolean paramBoolean2)
  {
    LiveFloatWindow localLiveFloatWindow = (LiveFloatWindow)this;
    FloatWindowConfig localFloatWindowConfig = localLiveFloatWindow.config;
    localFloatWindowConfig.widthMatch = paramBoolean1;
    localFloatWindowConfig.heightMatch = paramBoolean2;
    return localLiveFloatWindow;
  }
  
  @NotNull
  public final LiveFloatWindow setShowPattern(int paramInt)
  {
    LiveFloatWindow localLiveFloatWindow = (LiveFloatWindow)this;
    localLiveFloatWindow.config.showPattern = paramInt;
    if (!(localLiveFloatWindow.activity instanceof Activity)) {
      return localLiveFloatWindow;
    }
    if ((paramInt == 1) || (paramInt == 0))
    {
      FloatWindowConfig localFloatWindowConfig = localLiveFloatWindow.config;
      ComponentName localComponentName = ((Activity)localLiveFloatWindow.activity).getComponentName();
      Intrinsics.checkExpressionValueIsNotNull(localComponentName, "activity.componentName");
      localFloatWindowConfig.currentActivityName = localComponentName.getClassName();
    }
    return localLiveFloatWindow;
  }
  
  @NotNull
  public final LiveFloatWindow setSidePattern(int paramInt)
  {
    LiveFloatWindow localLiveFloatWindow = (LiveFloatWindow)this;
    localLiveFloatWindow.config.sidePattern = paramInt;
    return localLiveFloatWindow;
  }
  
  @NotNull
  public final LiveFloatWindow setTag(@Nullable String paramString)
  {
    LiveFloatWindow localLiveFloatWindow = (LiveFloatWindow)this;
    localLiveFloatWindow.config.floatTag = paramString;
    return localLiveFloatWindow;
  }
  
  @NotNull
  public final LiveFloatWindow setVerticalMargin(float paramFloat)
  {
    LiveFloatWindow localLiveFloatWindow = (LiveFloatWindow)this;
    localLiveFloatWindow.config.verticalMargin = paramFloat;
    return localLiveFloatWindow;
  }
  
  public final void show()
  {
    if (this.config.layoutId == -1)
    {
      callbackCreateFailed(2);
      return;
    }
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
    if (FWPermission.hasPermission(this.activity)) {
      createAppFloat();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.widget.LiveFloatWindow
 * JD-Core Version:    0.7.0.1
 */