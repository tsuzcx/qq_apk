package com.tencent.biz.expand.flutter.router;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/flutter/router/RouterManager$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/biz/expand/flutter/router/RouterManager;", "getInstance", "()Lcom/tencent/biz/expand/flutter/router/RouterManager;", "instance$delegate", "Lkotlin/Lazy;", "get", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RouterManager$Companion
{
  private final RouterManager b()
  {
    Lazy localLazy = RouterManager.a();
    Companion localCompanion = RouterManager.a;
    return (RouterManager)localLazy.getValue();
  }
  
  @JvmStatic
  @NotNull
  public final RouterManager a()
  {
    return ((Companion)this).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.flutter.router.RouterManager.Companion
 * JD-Core Version:    0.7.0.1
 */