package com.tencent.luggage.wxa.de;

import android.os.Build.VERSION;
import com.google.protobuf.ByteString;
import com.tencent.ilink.tdi.b.c;
import com.tencent.ilink.tdi.b.c.a;
import com.tencent.ilink.tdi.b.h;
import com.tencent.ilink.tdi.b.y;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.dc.w;
import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.dg.d;
import com.tencent.luggage.wxa.qw.gt;
import com.tencent.luggage.wxa.qw.ir;
import com.tencent.luggage.wxa.qw.nm;
import com.tencent.luggage.wxa.qw.nn;
import com.tencent.luggage.wxa.qw.z;
import com.tencent.luggage.wxa.qz.o;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/tdi/TdiCgiServiceNoLogin;", "Lcom/tencent/luggage/login/account/tdi/TdiCgiServiceBase;", "Lcom/tencent/mm/protocal/protobuf/WxaRuntimeNonLoginTransferReq;", "Lcom/tencent/mm/protocal/protobuf/WxaRuntimeNonLoginTransferResp;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "mAppId", "getMAppId", "mDeviceToken", "getMDeviceToken", "mDeviceUsername", "getMDeviceUsername", "transfer_action", "Lcom/tencent/mm/protocal/protobuf/TransferAction;", "getTransfer_action", "(Lcom/tencent/mm/protocal/protobuf/WxaRuntimeNonLoginTransferResp;)Lcom/tencent/mm/protocal/protobuf/TransferAction;", "avoidProtoCrash", "", "req", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "bootInner", "bootCallback", "Lkotlin/Function2;", "", "createTdiAppRequest", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiAppRequest;", "cmdId", "", "url", "networkType", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiNetType;", "createTransferReq", "appId", "createTransferRespClass", "Ljava/lang/Class;", "fixBaseReq", "installNoLoginTdiCgi", "tdiCgi", "Lcom/tencent/luggage/login/account/tdi/ITdiCgi;", "installTdiCgi", "toRespData", "", "resp", "transferCmdId", "transferUrl", "uninstall", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public class m
  extends j<nm, nn>
{
  @NotNull
  private final String b = "TdiCgiServiceNoLogin";
  
  private final String c()
  {
    return d.a.d();
  }
  
  private final String d()
  {
    return d.a.b();
  }
  
  private final String j()
  {
    return d.a.c();
  }
  
  @NotNull
  public b.c a(int paramInt, @NotNull String paramString, @NotNull b.y paramy, @Nullable com.tencent.luggage.wxa.qu.a parama)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(paramy, "networkType");
    b.c.a locala = b.c.u();
    if (parama != null) {
      parama = parama.b();
    } else {
      parama = null;
    }
    paramString = locala.a(ByteString.copyFrom(parama)).a(paramString).a(paramInt).a(paramy).b(30000).a(b.h.c).c();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "TdiApiProto.TdiAppReques…cdh)\n            .build()");
    return paramString;
  }
  
  @Nullable
  protected ir a(@NotNull nn paramnn)
  {
    Intrinsics.checkParameterIsNotNull(paramnn, "$this$transfer_action");
    return paramnn.b;
  }
  
  @Nullable
  public nm a(@Nullable String paramString1, @Nullable String paramString2, @Nullable com.tencent.luggage.wxa.qu.a parama)
  {
    nm localnm = new nm();
    a((com.tencent.luggage.wxa.qu.a)localnm);
    localnm.a = paramString1;
    localnm.b = c();
    if (parama != null) {
      parama = parama.b();
    } else {
      parama = null;
    }
    localnm.d = new com.tencent.luggage.wxa.qu.b(parama);
    localnm.c = h.a.a();
    localnm.e = paramString2;
    localnm.g = d();
    localnm.h = j();
    localnm.f = h.a.a(paramString1);
    localnm.i = h.a.b();
    parama = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("url:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" appId:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" host_appId:");
    localStringBuilder.append(c());
    localStringBuilder.append(" token:");
    localStringBuilder.append(d());
    localStringBuilder.append(" username:");
    localStringBuilder.append(j());
    localStringBuilder.append(" cmdid:");
    localStringBuilder.append(localnm.f);
    localStringBuilder.append(" req");
    o.e(parama, localStringBuilder.toString());
    return localnm;
  }
  
  public void a()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uninstall appId:");
    localStringBuilder.append(c());
    o.d(str, localStringBuilder.toString());
    super.a();
  }
  
  public void a(@NotNull b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "tdiCgi");
  }
  
  public void a(@Nullable com.tencent.luggage.wxa.qu.a parama)
  {
    if ((parama instanceof gt))
    {
      parama = (gt)parama;
      if (parama.B == null)
      {
        parama.B = new z();
        parama.B.d = 654316592;
        z localz = parama.B;
        Object localObject = i.a.c();
        Charset localCharset = Charsets.UTF_8;
        if (localObject != null)
        {
          localObject = ((String)localObject).getBytes(localCharset);
          Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.String).getBytes(charset)");
          localz.c = new com.tencent.luggage.wxa.qu.b((byte[])localObject);
          localz = parama.B;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("android-");
          ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
          localObject = ((StringBuilder)localObject).toString();
          localCharset = Charsets.UTF_8;
          if (localObject != null)
          {
            localObject = ((String)localObject).getBytes(localCharset);
            Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.String).getBytes(charset)");
            localz.e = new com.tencent.luggage.wxa.qu.b((byte[])localObject);
            parama.B.a = new com.tencent.luggage.wxa.qu.b(new byte[0]);
            parama.B.f = 0;
            return;
          }
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
  }
  
  public void a(@Nullable Function2<? super Boolean, ? super String, Unit> paramFunction2)
  {
    com.tencent.luggage.wxa.dg.b localb = (com.tencent.luggage.wxa.dg.b)e.a(com.tencent.luggage.wxa.dg.b.class);
    if (localb == null) {
      localb = com.tencent.luggage.wxa.dg.b.b;
    }
    w localw = w.a;
    Intrinsics.checkExpressionValueIsNotNull(localb, "activateDeviceLogic");
    localw.b(localb, (Function2)new m.a(this, paramFunction2));
  }
  
  @NotNull
  protected String b()
  {
    return this.b;
  }
  
  public void b(@Nullable com.tencent.luggage.wxa.qu.a parama)
  {
    if ((parama instanceof nm))
    {
      parama = (nm)parama;
      parama.g = d();
      parama.h = j();
      parama = b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("find bug ");
      localStringBuilder.append(d());
      localStringBuilder.append(' ');
      localStringBuilder.append(j());
      o.f(parama, localStringBuilder.toString());
    }
  }
  
  @NotNull
  public byte[] b(@NotNull nn paramnn)
  {
    Intrinsics.checkParameterIsNotNull(paramnn, "resp");
    paramnn = paramnn.a.b();
    Intrinsics.checkExpressionValueIsNotNull(paramnn, "resp.resp_data.toByteArray()");
    return paramnn;
  }
  
  @Nullable
  public Class<nn> e()
  {
    return nn.class;
  }
  
  @NotNull
  public String g()
  {
    return a.a.d();
  }
  
  public int h()
  {
    return a.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.m
 * JD-Core Version:    0.7.0.1
 */