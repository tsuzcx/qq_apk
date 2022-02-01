package com.tencent.luggage.wxa.ow;

import com.tencent.luggage.wxa.qw.au;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo$Companion;", "", "()V", "make", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckShortLinkResp;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class b$a
{
  @NotNull
  public final b a(@NotNull au paramau)
  {
    Intrinsics.checkParameterIsNotNull(paramau, "resp");
    Object localObject1 = paramau.a;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.luggage.wxa.qu.b)localObject1).b("UTF-8");
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    Object localObject2 = paramau.c;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.luggage.wxa.qu.b)localObject2).b("UTF-8");
      if (localObject2 != null) {}
    }
    else
    {
      localObject2 = "";
    }
    Object localObject3 = paramau.b;
    if (localObject3 != null)
    {
      localObject3 = ((com.tencent.luggage.wxa.qu.b)localObject3).b("UTF-8");
      if (localObject3 != null) {}
    }
    else
    {
      localObject3 = "";
    }
    int i = paramau.d;
    int j = paramau.e;
    paramau = paramau.f;
    if (paramau != null)
    {
      paramau = paramau.d();
      if (paramau != null) {}
    }
    else
    {
      paramau = "";
    }
    return new b((String)localObject1, (String)localObject2, (String)localObject3, i, j, paramau);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ow.b.a
 * JD-Core Version:    0.7.0.1
 */