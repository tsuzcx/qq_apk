package com.tencent.luggage.wxa.ec;

import android.util.Log;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.jj.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"bundleRuntimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "runtime", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "luggage-wechat-full-sdk_release"}, k=2, mv={1, 1, 16})
public final class c
{
  @NotNull
  public static final j a(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "runtime");
    int i = paramd.j().r;
    String str1 = paramd.aa();
    Intrinsics.checkExpressionValueIsNotNull(str1, "runtime.appId");
    int j = paramd.ab();
    Object localObject1 = paramd.j();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "runtime.initConfig");
    boolean bool1 = ((com.tencent.luggage.wxa.do.c)localObject1).g();
    int k = paramd.j().c;
    localObject1 = paramd.j();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "runtime.initConfig");
    localObject1 = ((com.tencent.luggage.wxa.do.c)localObject1).i();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "runtime.initConfig.wxaLaunchInstanceId");
    String str2 = paramd.j().b;
    Intrinsics.checkExpressionValueIsNotNull(str2, "runtime.initConfig.username");
    Object localObject2 = paramd.j();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "runtime.initConfig");
    localObject2 = (h)localObject2;
    boolean bool2 = paramd.j().s;
    long l = paramd.j().m;
    if (com.tencent.luggage.wxa.qz.c.a) {
      paramd = Log.getStackTraceString(new Throwable());
    } else {
      paramd = "debug use only";
    }
    Intrinsics.checkExpressionValueIsNotNull(paramd, "if (BuildInfo.DEBUG) {\n …debug use only\"\n        }");
    return new j(i, str1, j, bool1, k + 1000, (String)localObject1, str2, (h)localObject2, bool2, l, paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ec.c
 * JD-Core Version:    0.7.0.1
 */