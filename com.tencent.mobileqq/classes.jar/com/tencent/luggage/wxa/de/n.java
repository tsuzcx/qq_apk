package com.tencent.luggage.wxa.de;

import android.os.Parcelable;
import com.tencent.ilink.tdi.b.y;
import com.tencent.luggage.wxa.df.e;
import com.tencent.luggage.wxa.df.f;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.gu;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.ro.d;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/tdi/TdiCgiServiceNoLoginClient;", "Lcom/tencent/luggage/login/account/tdi/TdiCgiServiceNoLogin;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "installTdiCgi", "", "tdiCgi", "Lcom/tencent/luggage/login/account/tdi/ITdiCgi;", "sync", "RESP", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "cmdId", "", "url", "networkType", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiNetType;", "req", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "respClazz", "Ljava/lang/Class;", "(ILjava/lang/String;Lcom/tencent/ilink/tdi/TdiApiProto$TdiNetType;Lcom/tencent/mm/protobuf/BaseProtoBuf;Ljava/lang/Class;)Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "syncPipeline", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "uninstall", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class n
  extends m
{
  @NotNull
  private final String b = "Luggage.TdiCgiServiceNoLoginClient";
  
  @Nullable
  public <RESP extends gu> RESP a(int paramInt, @NotNull String paramString, @NotNull b.y paramy, @Nullable a parama, @NotNull Class<RESP> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(paramy, "networkType");
    Intrinsics.checkParameterIsNotNull(paramClass, "respClazz");
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sync cmdId:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" req:");
    localStringBuilder.append(parama);
    o.d(str, localStringBuilder.toString());
    str = r.i();
    paramClass = paramClass.getName();
    Intrinsics.checkExpressionValueIsNotNull(paramClass, "respClazz.name");
    paramy = (f)com.tencent.luggage.wxa.hj.h.a(str, (Parcelable)new e(paramInt, paramString, paramy, parama, paramClass), new n.a().getClass());
    if (paramy != null) {
      paramString = paramy.c();
    } else {
      paramString = null;
    }
    if ((paramString != null) && (paramy.a() == 0))
    {
      paramString = b();
      parama = new StringBuilder();
      parama.append("sync tdiResponse: ");
      parama.append(paramy.c());
      o.e(paramString, parama.toString());
      paramString = paramy.c();
      if (paramString != null) {
        return (gu)paramString;
      }
      throw new TypeCastException("null cannot be cast to non-null type RESP");
    }
    parama = b();
    paramClass = new StringBuilder();
    paramClass.append("tdiResponse:");
    boolean bool;
    if (paramy != null) {
      bool = true;
    } else {
      bool = false;
    }
    paramClass.append(bool);
    paramClass.append(" resp:");
    paramClass.append(paramy.c());
    paramClass.append("  errCode");
    if (paramy != null) {
      paramString = Integer.valueOf(paramy.a());
    } else {
      paramString = null;
    }
    paramClass.append(paramString);
    o.b(parama, paramClass.toString());
    return null;
  }
  
  public void a() {}
  
  public void a(@NotNull b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "tdiCgi");
  }
  
  @NotNull
  public <RESP extends gu> d<RESP> b(int paramInt, @NotNull String paramString, @NotNull b.y paramy, @Nullable a parama, @NotNull Class<RESP> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(paramy, "networkType");
    Intrinsics.checkParameterIsNotNull(paramClass, "respClazz");
    paramString = com.tencent.luggage.wxa.ro.h.a().a((com.tencent.luggage.wxa.rl.b)new n.b(this, paramInt, paramString, paramy, parama, paramClass));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "QuickAccess.pipeline().n…           null\n        }");
    return paramString;
  }
  
  @NotNull
  protected String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.n
 * JD-Core Version:    0.7.0.1
 */