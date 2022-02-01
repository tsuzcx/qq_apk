package com.tencent.luggage.wxa.dc;

import com.tencent.ilink.tdi.b.y;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.gt;
import com.tencent.luggage.wxa.qw.gu;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/TdiCgi;", "REQUEST", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "RESPONSE", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "", "()V", "getCmdId", "", "getUrl", "", "runPipeline", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "request", "respClazz", "Ljava/lang/Class;", "(Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;Ljava/lang/Class;)Lcom/tencent/mm/vending/pipeline/Pipeable;", "sync", "(Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;Ljava/lang/Class;)Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public abstract class k<REQUEST extends gt, RESPONSE extends gu>
{
  @NotNull
  public final com.tencent.luggage.wxa.ro.d<RESPONSE> a(@NotNull REQUEST paramREQUEST, @NotNull Class<RESPONSE> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramREQUEST, "request");
    Intrinsics.checkParameterIsNotNull(paramClass, "respClazz");
    return ((com.tencent.luggage.wxa.de.d)e.a(com.tencent.luggage.wxa.de.d.class)).b(b(), a(), b.y.a, (a)paramREQUEST, paramClass);
  }
  
  @NotNull
  protected abstract String a();
  
  protected abstract int b();
  
  @Nullable
  public final RESPONSE b(@NotNull REQUEST paramREQUEST, @NotNull Class<RESPONSE> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramREQUEST, "request");
    Intrinsics.checkParameterIsNotNull(paramClass, "respClazz");
    return ((com.tencent.luggage.wxa.de.d)e.a(com.tencent.luggage.wxa.de.d.class)).a(b(), a(), b.y.a, (a)paramREQUEST, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.k
 * JD-Core Version:    0.7.0.1
 */