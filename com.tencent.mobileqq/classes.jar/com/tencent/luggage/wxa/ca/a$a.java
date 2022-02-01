package com.tencent.luggage.wxa.ca;

import com.tencent.luggage.wxa.qw.aa;
import com.tencent.luggage.wxa.qw.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rl.b;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/AdDataReportResponse;", "kotlin.jvm.PlatformType", "response", "call"}, k=3, mv={1, 1, 16})
final class a$a<_Ret, _Var>
  implements b<_Ret, _Var>
{
  public static final a a = new a();
  
  public final c a(c paramc)
  {
    String str = a.a(a.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AdDataReport runPipeline response:");
    Object localObject2 = null;
    if (paramc != null)
    {
      localObject1 = paramc.z;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((aa)localObject1).a);
        break label53;
      }
    }
    Object localObject1 = null;
    label53:
    localStringBuilder.append(localObject1);
    localStringBuilder.append(" errMsg:");
    if (paramc != null)
    {
      localObject1 = paramc.z;
      if (localObject1 != null)
      {
        localObject1 = ((aa)localObject1).b;
        break label91;
      }
    }
    localObject1 = null;
    label91:
    localStringBuilder.append(localObject1);
    localStringBuilder.append(", ret:");
    if (paramc != null) {
      localObject1 = Integer.valueOf(paramc.a);
    } else {
      localObject1 = null;
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append(' ');
    localObject1 = localObject2;
    if (paramc != null) {
      localObject1 = paramc.b;
    }
    localStringBuilder.append((String)localObject1);
    o.d(str, localStringBuilder.toString());
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ca.a.a
 * JD-Core Version:    0.7.0.1
 */