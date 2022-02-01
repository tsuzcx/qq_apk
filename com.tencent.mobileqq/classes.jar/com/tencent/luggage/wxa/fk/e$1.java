package com.tencent.luggage.wxa.fk;

import com.tencent.luggage.wxa.fl.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxa/standalone_open_runtime/runtime/WxaRuntime$1", "Lcom/tencent/luggage/wxa/standalone_open_runtime/test_kit/ForceKillAppNotify;", "onKill", "", "appId", "", "versionType", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class e$1
  extends b
{
  public void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    if ((Intrinsics.areEqual(paramString, this.a.aa())) && (paramInt == this.a.ab())) {
      this.a.E();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fk.e.1
 * JD-Core Version:    0.7.0.1
 */