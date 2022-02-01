package com.tencent.falco.base.floatwindow.widget.appfloat;

import android.content.Context;
import com.tencent.falco.base.floatwindow.bean.FloatWindowConfig;
import com.tencent.falco.base.floatwindow.interfaces.OnFloatWindowCallbacks;
import com.tencent.falco.base.floatwindow.utils.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/falco/base/floatwindow/widget/appfloat/FWAppManager;", "", "()V", "DEFAULT_TAG", "", "floatMap", "", "Lcom/tencent/falco/base/floatwindow/widget/appfloat/FWAppOperator;", "getFloatMap", "()Ljava/util/Map;", "checkTag", "", "config", "Lcom/tencent/falco/base/floatwindow/bean/FloatWindowConfig;", "create", "", "context", "Landroid/content/Context;", "dismiss", "tag", "(Ljava/lang/String;)Lkotlin/Unit;", "getAppFloatManager", "getTag", "remove", "floatTag", "visible", "isShow", "needShow", "(ZLjava/lang/String;Z)Lkotlin/Unit;", "floatwindow_release"}, k=1, mv={1, 1, 15})
public final class FWAppManager
{
  private static final String DEFAULT_TAG = "default";
  public static final FWAppManager INSTANCE = new FWAppManager();
  @NotNull
  private static final Map<String, FWAppOperator> floatMap = (Map)new LinkedHashMap();
  
  private final boolean checkTag(FloatWindowConfig paramFloatWindowConfig)
  {
    paramFloatWindowConfig.floatTag = getTag(paramFloatWindowConfig.floatTag);
    Map localMap = floatMap;
    paramFloatWindowConfig = paramFloatWindowConfig.floatTag;
    if (paramFloatWindowConfig == null) {
      Intrinsics.throwNpe();
    }
    return !localMap.containsKey(paramFloatWindowConfig);
  }
  
  public final void create(@NotNull Context paramContext, @NotNull FloatWindowConfig paramFloatWindowConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramFloatWindowConfig, "config");
    if (checkTag(paramFloatWindowConfig))
    {
      Map localMap = floatMap;
      String str = paramFloatWindowConfig.floatTag;
      if (str == null) {
        Intrinsics.throwNpe();
      }
      Intrinsics.checkExpressionValueIsNotNull(str, "config.floatTag!!");
      paramContext = paramContext.getApplicationContext();
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.applicationContext");
      paramContext = new FWAppOperator(paramContext, paramFloatWindowConfig);
      paramContext.createFloat();
      localMap.put(str, paramContext);
      return;
    }
    paramContext = paramFloatWindowConfig.callbacks;
    if (paramContext != null) {
      paramContext.createdResult(false, 4, null);
    }
    Logger.w("default", "WARN_REPEATED_TAG");
  }
  
  @Nullable
  public final Unit dismiss(@Nullable String paramString)
  {
    paramString = (FWAppOperator)floatMap.get(getTag(paramString));
    if (paramString != null)
    {
      paramString.exitAnim();
      return Unit.INSTANCE;
    }
    return null;
  }
  
  @Nullable
  public final FWAppOperator getAppFloatManager(@Nullable String paramString)
  {
    return (FWAppOperator)floatMap.get(getTag(paramString));
  }
  
  @NotNull
  public final Map<String, FWAppOperator> getFloatMap()
  {
    return floatMap;
  }
  
  @NotNull
  public final String getTag(@Nullable String paramString)
  {
    if (paramString != null) {
      return paramString;
    }
    return "default";
  }
  
  @Nullable
  public final FWAppOperator remove(@Nullable String paramString)
  {
    Map localMap = floatMap;
    if (localMap == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }
    return (FWAppOperator)TypeIntrinsics.asMutableMap(localMap).remove(paramString);
  }
  
  @Nullable
  public final Unit visible(boolean paramBoolean1, @Nullable String paramString, boolean paramBoolean2)
  {
    paramString = (FWAppOperator)floatMap.get(getTag(paramString));
    if (paramString != null)
    {
      if (paramBoolean1) {}
      for (int i = 0;; i = 8)
      {
        paramString.setVisible(i, paramBoolean2);
        return Unit.INSTANCE;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.widget.appfloat.FWAppManager
 * JD-Core Version:    0.7.0.1
 */