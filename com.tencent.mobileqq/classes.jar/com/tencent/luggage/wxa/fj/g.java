package com.tencent.luggage.wxa.fj;

import com.tencent.luggage.wxa.dc.m;
import com.tencent.luggage.wxa.dc.m.a;
import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.do.e;
import com.tencent.luggage.wxa.do.f;
import com.tencent.luggage.wxa.fq.g.c;
import com.tencent.luggage.wxa.qz.af;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/report/WxaPVReportIDFactory;", "Lcom/tencent/luggage/sdk/config/MPSessionIdFactory;", "Lcom/tencent/luggage/sdk/config/MPInstanceIdFactory;", "()V", "createInstanceId", "", "createSessionId", "cfg", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "init", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
@ExperimentalUnsignedTypes
public final class g
  implements e, f
{
  public static final g b = new g();
  
  @NotNull
  public String a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("hash=");
    ((StringBuilder)localObject1).append(m.a.b(g.c.a.b()));
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("ts=");
    ((StringBuilder)localObject2).append(af.d());
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("host=");
    localStringBuilder.append(g.c.a.a());
    localObject1 = StringUtils.join(new String[] { localObject1, localObject2, localStringBuilder.toString(), "version=553976065", "device=2" }, "&");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "StringUtils.join(arrayOf…2-android\n        ), \"&\")");
    return localObject1;
  }
  
  @NotNull
  public String a(@Nullable c paramc)
  {
    return a();
  }
  
  public final void b()
  {
    com.tencent.luggage.wxa.do.f.a.a = (f)this;
    com.tencent.luggage.wxa.do.e.a.a = (e)this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fj.g
 * JD-Core Version:    0.7.0.1
 */