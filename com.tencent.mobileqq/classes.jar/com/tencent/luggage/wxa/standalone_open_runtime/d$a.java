package com.tencent.luggage.wxa.standalone_open_runtime;

import android.content.Context;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.joor.Reflect;
import org.joor.ReflectException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageContainer$Companion;", "", "()V", "createForApp", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageContainer;", "context", "Landroid/content/Context;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "preloadedPageView", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "createForGame", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class d$a
{
  @JvmStatic
  @NotNull
  public final d a(@NotNull Context paramContext, @NotNull com.tencent.luggage.wxa.ed.d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramd, "rt");
    try
    {
      paramContext = Reflect.on("com.tencent.luggage.wxa.standalone_open_runtime.WxaGamePageContainer").create(new Object[] { paramContext, paramd }).get();
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "Reflect.on(\"com.tencent.…).get<WxaPageContainer>()");
      paramContext = (d)paramContext;
      return paramContext;
    }
    catch (ReflectException paramContext)
    {
      label49:
      break label49;
    }
    throw ((Throwable)new RuntimeException("Check your proguard config pls, you should keep 'com.tencent.luggage.wxa.standalone_open_runtime.WxaGamePageContainer' for mini-game support."));
  }
  
  @JvmStatic
  @NotNull
  public final d a(@NotNull Context paramContext, @NotNull com.tencent.luggage.wxa.ed.d paramd, @NotNull e parame)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramd, "rt");
    Intrinsics.checkParameterIsNotNull(parame, "preloadedPageView");
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(parame);
    return (d)new d.a.a(localLinkedList, paramContext, paramd, paramContext, paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.d.a
 * JD-Core Version:    0.7.0.1
 */