package com.tencent.luggage.wxa.ca;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.qw.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/ad/CgiAdDataReport;", "", "()V", "CMDID", "", "TAG", "", "URL", "runPipeline", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "Lcom/tencent/mm/protocal/protobuf/AdDataReportResponse;", "appId", "hostAppId", "logId", "logStr", "createTime", "", "sync", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a
{
  public static final a a = new a();
  private static final String b = "Luggage.CgiAdDataReport";
  
  @JvmStatic
  @NotNull
  public static final com.tencent.luggage.wxa.ro.d<c> a(@NotNull String paramString1, @NotNull String paramString2, int paramInt, @NotNull String paramString3, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "appId");
    Intrinsics.checkParameterIsNotNull(paramString2, "hostAppId");
    Intrinsics.checkParameterIsNotNull(paramString3, "logStr");
    Object localObject1 = b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("appId:");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append(" hostAppId:");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append(" logId:");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(" logStr:");
    ((StringBuilder)localObject2).append(paramString3);
    o.d((String)localObject1, ((StringBuilder)localObject2).toString());
    paramString2 = new com.tencent.luggage.wxa.qw.b();
    paramString2.a = new LinkedList();
    localObject1 = paramString2.a;
    localObject2 = new com.tencent.luggage.wxa.qw.d();
    ((com.tencent.luggage.wxa.qw.d)localObject2).a = paramInt;
    paramString3 = paramString3.getBytes(Charsets.UTF_8);
    Intrinsics.checkExpressionValueIsNotNull(paramString3, "(this as java.lang.String).getBytes(charset)");
    ((com.tencent.luggage.wxa.qw.d)localObject2).b = new com.tencent.luggage.wxa.qu.b(paramString3);
    ((com.tencent.luggage.wxa.qw.d)localObject2).c = paramLong;
    ((LinkedList)localObject1).add(localObject2);
    paramString1 = ((com.tencent.luggage.wxa.ob.b)e.a(com.tencent.luggage.wxa.ob.b.class)).b("/cgi-bin/mmoc-bin/ad/addatareport", paramString1, (com.tencent.luggage.wxa.qu.a)paramString2, c.class).a((com.tencent.luggage.wxa.rl.b)a.a.a);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "Luggage.customize(ICgiSe…xt response\n            }");
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ca.a
 * JD-Core Version:    0.7.0.1
 */