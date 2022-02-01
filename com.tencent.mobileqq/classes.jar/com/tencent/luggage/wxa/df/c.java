package com.tencent.luggage.wxa.df;

import com.tencent.ilink.tdi.b.y;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.gu;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/tdi/ipc/TdiNetTaskAsync;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/luggage/login/account/tdi/ipc/TdiRequest;", "Lcom/tencent/luggage/login/account/tdi/ipc/TdiResponse;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "syncPipeline", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "RESP", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "cmdId", "", "url", "networkType", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiNetType;", "req", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "respClazz", "Ljava/lang/Class;", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public abstract class c
  implements com.tencent.luggage.wxa.hj.c<e, f>
{
  @NotNull
  public abstract <RESP extends gu> d<RESP> a(int paramInt, @NotNull String paramString, @NotNull b.y paramy, @Nullable a parama, @NotNull Class<RESP> paramClass);
  
  @NotNull
  public abstract String a();
  
  public void a(@Nullable e parame, @Nullable com.tencent.luggage.wxa.hj.e<f> parame1)
  {
    if (parame == null)
    {
      o.b(a(), "data is null, return");
      if (parame1 != null)
      {
        parame = new f(0, null, null, 7, null);
        parame.a(-1);
        parame.a("invalid data");
        parame1.a(parame);
      }
      return;
    }
    Class localClass = Class.forName(parame.e());
    if (localClass != null)
    {
      a(parame.a(), parame.b(), parame.c(), parame.d(), localClass).a((e.c)new c.a(this, parame1)).a((e.a)new c.b(this, parame1));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<com.tencent.mm.protocal.protobuf.ResponseProtoBuf>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.df.c
 * JD-Core Version:    0.7.0.1
 */