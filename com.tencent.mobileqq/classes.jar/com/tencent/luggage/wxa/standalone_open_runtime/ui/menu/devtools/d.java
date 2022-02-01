package com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools;

import android.content.Context;
import com.tencent.luggage.wxa.dq.c;
import com.tencent.luggage.wxa.nv.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/menu/devtools/SecondaryMenuDeletate_TestJavaCrash;", "Lcom/tencent/mm/plugin/appbrand/menu/base/BaseSecondaryMenuDelegate;", "Lcom/tencent/luggage/sdk/jsapi/component/AppBrandPageViewLU;", "()V", "getTitle", "", "context", "Landroid/content/Context;", "pageView", "appId", "performItemClick", "", "shouldShow", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class d
  implements b<c>
{
  public boolean a(@NotNull Context paramContext, @NotNull c paramc, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramc, "pageView");
    return true;
  }
  
  @NotNull
  public String b(@NotNull Context paramContext, @NotNull c paramc, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramc, "pageView");
    return "Test Java Crash";
  }
  
  public void c(@NotNull Context paramContext, @NotNull c paramc, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramc, "pageView");
    throw ((Throwable)new IllegalAccessException("Test Java Crash"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools.d
 * JD-Core Version:    0.7.0.1
 */