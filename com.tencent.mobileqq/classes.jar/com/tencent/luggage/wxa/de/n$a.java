package com.tencent.luggage.wxa.de;

import com.tencent.ilink.tdi.b.y;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.gu;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/login/account/tdi/TdiCgiServiceNoLoginClient$sync$tdiResponse$1", "Lcom/tencent/luggage/login/account/tdi/ipc/TdiNetTaskSync;", "TAG", "", "getTAG", "()Ljava/lang/String;", "sync", "RESP", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "cmdId", "", "url", "networkType", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiNetType;", "req", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "respClazz", "Ljava/lang/Class;", "(ILjava/lang/String;Lcom/tencent/ilink/tdi/TdiApiProto$TdiNetType;Lcom/tencent/mm/protobuf/BaseProtoBuf;Ljava/lang/Class;)Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class n$a
  extends com.tencent.luggage.wxa.df.d
{
  @NotNull
  private final String a = "TdiCgiServiceNoLoginClient$AdapterTaskSync";
  
  @Nullable
  public <RESP extends gu> RESP a(int paramInt, @NotNull String paramString, @NotNull b.y paramy, @Nullable a parama, @NotNull Class<RESP> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(paramy, "networkType");
    Intrinsics.checkParameterIsNotNull(paramClass, "respClazz");
    d locald = l.a.e();
    if (locald == null) {
      Intrinsics.throwNpe();
    }
    return locald.a(paramInt, paramString, paramy, parama, paramClass);
  }
  
  @NotNull
  public String a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.n.a
 * JD-Core Version:    0.7.0.1
 */