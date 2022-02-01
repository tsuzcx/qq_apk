package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.do.e;
import com.tencent.luggage.wxa.do.e.a;
import com.tencent.luggage.wxa.nn.a;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/WxaLaunchInstanceId$Companion;", "", "()V", "generate", "Lcom/tencent/luggage/launch/WxaLaunchInstanceId;", "args", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "generateString", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class p$a
{
  @JvmStatic
  @NotNull
  public final String a(@NotNull a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "args");
    Object localObject1 = e.a.a;
    if (localObject1 == null) {
      localObject1 = e.a;
    }
    localObject1 = ((e)localObject1).a();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "(MPInstanceIdFactory.IMP…FAULT).createInstanceId()");
    Object localObject2 = (CharSequence)parama.k;
    int i;
    if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return localObject1;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("&host_scene=");
    parama = parama.k;
    if (parama == null) {
      Intrinsics.throwNpe();
    }
    Intrinsics.checkExpressionValueIsNotNull(parama, "args.wechatNativeExtraData!!");
    ((StringBuilder)localObject2).append(new l(parama).b());
    return ((StringBuilder)localObject2).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.p.a
 * JD-Core Version:    0.7.0.1
 */