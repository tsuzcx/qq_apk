package com.tencent.luggage.wxa.standalone_open_runtime.app;

import android.app.Application;
import com.tencent.luggage.wxa.hj.i;
import com.tencent.luggage.wxa.hk.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/app/WxaIPCBridgeInitializer;", "", "()V", "CONTAINER_SERVICES", "", "Ljava/lang/Class;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/app/WxaIPCContainerService0;", "[Ljava/lang/Class;", "install", "", "application", "Landroid/app/Application;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
{
  public static final b a = new b();
  private static final Class<? extends WxaIPCContainerService0>[] b = { WxaIPCContainerService0.class, WxaIPCContainerService1.class, WxaIPCContainerService2.class, WxaIPCContainerService3.class, WxaIPCContainerService4.class };
  
  public final void a(@NotNull Application paramApplication)
  {
    Intrinsics.checkParameterIsNotNull(paramApplication, "application");
    i.a(paramApplication, (c)new b.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.app.b
 * JD-Core Version:    0.7.0.1
 */