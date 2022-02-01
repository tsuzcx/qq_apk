package com.tencent.luggage.wxa.de;

import com.tencent.ilink.tdi.b.y;
import com.tencent.luggage.wxa.df.c;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.gu;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/login/account/tdi/TdiCgiServiceClient$syncPipeline$1$1", "Lcom/tencent/luggage/login/account/tdi/ipc/TdiNetTaskAsync;", "TAG", "", "getTAG", "()Ljava/lang/String;", "syncPipeline", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "RESP", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "cmdId", "", "url", "networkType", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiNetType;", "req", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "respClazz", "Ljava/lang/Class;", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class k$b$1
  extends c
{
  @NotNull
  private final String a = "TdiCgiServiceClient$AdapterTaskAsync";
  
  @NotNull
  public <RESP extends gu> com.tencent.luggage.wxa.ro.d<RESP> a(int paramInt, @NotNull String paramString, @NotNull b.y paramy, @Nullable a parama, @NotNull Class<RESP> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(paramy, "networkType");
    Intrinsics.checkParameterIsNotNull(paramClass, "respClazz");
    d locald = l.a.b();
    if (locald == null) {
      Intrinsics.throwNpe();
    }
    return locald.b(paramInt, paramString, paramy, parama, paramClass);
  }
  
  @NotNull
  public String a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.k.b.1
 * JD-Core Version:    0.7.0.1
 */