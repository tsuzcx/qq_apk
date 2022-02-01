package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import com.tencent.mm.ui.base.e;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/WxaWrapScreenAdaptiveContext;", "Lcom/tencent/mm/ui/base/IWrapScreenAdaptiveContext;", "()V", "adaptive", "Landroid/content/Context;", "ctx", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class m
  implements e
{
  @NotNull
  public Context a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "ctx");
    return (Context)new k(paramContext, (k.a)m.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.m
 * JD-Core Version:    0.7.0.1
 */