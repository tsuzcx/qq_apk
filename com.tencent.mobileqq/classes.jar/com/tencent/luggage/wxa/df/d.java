package com.tencent.luggage.wxa.df;

import com.tencent.ilink.tdi.b.y;
import com.tencent.luggage.wxa.hj.k;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.gu;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/tdi/ipc/TdiNetTaskSync;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/luggage/login/account/tdi/ipc/TdiRequest;", "Lcom/tencent/luggage/login/account/tdi/ipc/TdiResponse;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "invoke", "data", "sync", "RESP", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "cmdId", "", "url", "networkType", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiNetType;", "req", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "respClazz", "Ljava/lang/Class;", "(ILjava/lang/String;Lcom/tencent/ilink/tdi/TdiApiProto$TdiNetType;Lcom/tencent/mm/protobuf/BaseProtoBuf;Ljava/lang/Class;)Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public abstract class d
  implements k<e, f>
{
  @NotNull
  public f a(@Nullable e parame)
  {
    if (parame == null)
    {
      o.b(a(), "data is null, return");
      parame = new f(0, null, null, 7, null);
      parame.a(-1);
      parame.a("invalid data");
      return parame;
    }
    Object localObject;
    try
    {
      localObject = Class.forName(parame.e());
      if (localObject != null)
      {
        parame = a(parame.a(), parame.b(), parame.c(), parame.d(), (Class)localObject);
        if (parame == null)
        {
          o.b(a(), "resp is null, return");
          parame = new f(0, null, null, 7, null);
          parame.a(-1);
          parame.a("resp is null, return");
          return parame;
        }
        localObject = new f(0, null, null, 7, null);
        ((f)localObject).a((a)parame);
        ((f)localObject).a(0);
        ((f)localObject).a("");
        return localObject;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<out com.tencent.mm.protocal.protobuf.ResponseProtoBuf>");
    }
    catch (Exception parame)
    {
      localObject = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invoke fail ");
      localStringBuilder.append(parame);
      o.b((String)localObject, localStringBuilder.toString());
      localObject = new f(0, null, null, 7, null);
      ((f)localObject).a(-1);
      ((f)localObject).a(String.valueOf(parame.getMessage()));
    }
    return localObject;
  }
  
  @Nullable
  public abstract <RESP extends gu> RESP a(int paramInt, @NotNull String paramString, @NotNull b.y paramy, @Nullable a parama, @NotNull Class<RESP> paramClass);
  
  @NotNull
  public abstract String a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.df.d
 * JD-Core Version:    0.7.0.1
 */