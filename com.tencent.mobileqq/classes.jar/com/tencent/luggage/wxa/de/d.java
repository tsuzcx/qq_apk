package com.tencent.luggage.wxa.de;

import com.tencent.ilink.tdi.b.y;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.gu;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/tdi/ITdiCgiService;", "Lcom/tencent/mm/plugin/appbrand/networking/ICgiService;", "installNoLoginTdiCgi", "", "tdiCgi", "Lcom/tencent/luggage/login/account/tdi/ITdiCgi;", "installTdiCgi", "sync", "RESP", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "cmdId", "", "url", "", "networkType", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiNetType;", "req", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "respClazz", "Ljava/lang/Class;", "(ILjava/lang/String;Lcom/tencent/ilink/tdi/TdiApiProto$TdiNetType;Lcom/tencent/mm/protobuf/BaseProtoBuf;Ljava/lang/Class;)Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "syncPipeline", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "uninstall", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public abstract interface d
  extends com.tencent.luggage.wxa.ob.b
{
  @Nullable
  public abstract <RESP extends gu> RESP a(int paramInt, @NotNull String paramString, @NotNull b.y paramy, @Nullable a parama, @NotNull Class<RESP> paramClass);
  
  public abstract void a();
  
  public abstract void a(@NotNull b paramb);
  
  @NotNull
  public abstract <RESP extends gu> com.tencent.luggage.wxa.ro.d<RESP> b(int paramInt, @NotNull String paramString, @NotNull b.y paramy, @Nullable a parama, @NotNull Class<RESP> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.d
 * JD-Core Version:    0.7.0.1
 */