package com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools;

import android.content.Context;
import com.tencent.luggage.wxa.nv.b;
import com.tencent.mm.plugin.appbrand.appstorage.WxaNativeCrashTest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/menu/devtools/SecondaryMenuDelegate_TestNativeCrash;", "Lcom/tencent/mm/plugin/appbrand/menu/base/BaseSecondaryMenuDelegate;", "Lcom/tencent/luggage/sdk/jsapi/component/AppBrandPageViewLU;", "()V", "getTitle", "", "context", "Landroid/content/Context;", "pageView", "appId", "performItemClick", "", "shouldShow", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class c
  implements b<com.tencent.luggage.wxa.dq.c>
{
  public boolean a(@NotNull Context paramContext, @NotNull com.tencent.luggage.wxa.dq.c paramc, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramc, "pageView");
    return true;
  }
  
  @NotNull
  public String b(@NotNull Context paramContext, @NotNull com.tencent.luggage.wxa.dq.c paramc, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramc, "pageView");
    return "Test Native Crash";
  }
  
  public void c(@NotNull Context paramContext, @NotNull com.tencent.luggage.wxa.dq.c paramc, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramc, "pageView");
    WxaNativeCrashTest.crashForTest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools.c
 * JD-Core Version:    0.7.0.1
 */