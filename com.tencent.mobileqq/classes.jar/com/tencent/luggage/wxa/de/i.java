package com.tencent.luggage.wxa.de;

import android.os.Build.VERSION;
import com.tencent.luggage.wxa.dg.d;
import com.tencent.luggage.wxa.dj.a.a;
import com.tencent.luggage.wxa.dj.e;
import com.tencent.luggage.wxa.dj.h.b;
import com.tencent.luggage.wxa.qw.gt;
import com.tencent.luggage.wxa.qw.ir;
import com.tencent.luggage.wxa.qw.nk;
import com.tencent.luggage.wxa.qw.nl;
import com.tencent.luggage.wxa.qw.z;
import com.tencent.luggage.wxa.qz.o;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/tdi/TdiCgiService;", "Lcom/tencent/luggage/login/account/tdi/TdiCgiServiceBase;", "Lcom/tencent/mm/protocal/protobuf/WxaRuntimeLoginTransferReq;", "Lcom/tencent/mm/protocal/protobuf/WxaRuntimeLoginTransferResp;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "<set-?>", "", "isRegistered", "()Z", "mAppId", "getMAppId", "mTdiCgi", "Lcom/tencent/luggage/login/account/tdi/ITdiCgi;", "mUin", "", "getMUin", "()I", "transfer_action", "Lcom/tencent/mm/protocal/protobuf/TransferAction;", "getTransfer_action", "(Lcom/tencent/mm/protocal/protobuf/WxaRuntimeLoginTransferResp;)Lcom/tencent/mm/protocal/protobuf/TransferAction;", "avoidProtoCrash", "", "req", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "createTransferReq", "url", "appId", "createTransferRespClass", "Ljava/lang/Class;", "fixBaseReq", "installNoLoginTdiCgi", "tdiCgi", "installTdiCgi", "onRegister", "onUnregister", "reInstallSmcReportIfNeed", "toRespData", "", "resp", "uninstall", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public class i
  extends j<nk, nl>
  implements com.tencent.luggage.wxa.hw.b
{
  @NotNull
  private final String b = "TdiCgiService";
  private b c;
  private boolean d;
  
  private final int j()
  {
    boolean bool = com.tencent.luggage.wxa.dd.i.a.g();
    int i = -1;
    if (!bool)
    {
      o.b(b(), "not login, fail");
      return -1;
    }
    com.tencent.luggage.wxa.dd.g localg = com.tencent.luggage.wxa.dd.i.a.f();
    if (localg != null) {
      i = localg.c();
    }
    return i;
  }
  
  private final String k()
  {
    return d.a.d();
  }
  
  private final void l()
  {
    b localb = this.c;
    Object localObject = localb;
    if (!(localb instanceof q)) {
      localObject = null;
    }
    localObject = (q)localObject;
    if (localObject != null)
    {
      localObject = com.tencent.luggage.wxa.dj.h.b.a(((q)localObject).b());
      a.a.b.a((com.tencent.luggage.wxa.dj.a)new e((com.tencent.luggage.wxa.dj.g)new i.a((com.tencent.luggage.wxa.dj.h)localObject)));
    }
  }
  
  @Nullable
  protected ir a(@NotNull nl paramnl)
  {
    Intrinsics.checkParameterIsNotNull(paramnl, "$this$transfer_action");
    return paramnl.b;
  }
  
  @Nullable
  public nk a(@Nullable String paramString1, @Nullable String paramString2, @Nullable com.tencent.luggage.wxa.qu.a parama)
  {
    nk localnk = new nk();
    Object localObject = (com.tencent.luggage.wxa.qu.a)localnk;
    a((com.tencent.luggage.wxa.qu.a)localObject);
    b((com.tencent.luggage.wxa.qu.a)localObject);
    localnk.a = paramString1;
    localnk.b = k();
    if (parama != null) {
      parama = parama.b();
    } else {
      parama = null;
    }
    localnk.d = new com.tencent.luggage.wxa.qu.b(parama);
    localnk.c = h.a.a();
    localnk.e = paramString2;
    localnk.f = h.a.a(paramString1);
    localnk.g = h.a.b();
    parama = b();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("createTransferReq: url:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" appId:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" host_appId:");
    ((StringBuilder)localObject).append(k());
    ((StringBuilder)localObject).append(" uin:");
    ((StringBuilder)localObject).append(j());
    ((StringBuilder)localObject).append(" cmdid:");
    ((StringBuilder)localObject).append(localnk.f);
    ((StringBuilder)localObject).append(" req");
    o.d(parama, ((StringBuilder)localObject).toString());
    return localnk;
  }
  
  public void a()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uninstall appId:");
    localStringBuilder.append(k());
    localStringBuilder.append(" uin:");
    localStringBuilder.append(j());
    o.d(str, localStringBuilder.toString());
    super.a();
  }
  
  public void a(@NotNull b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "tdiCgi");
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("installTdiCloneSession appId:");
    localStringBuilder.append(k());
    localStringBuilder.append(" uin:");
    localStringBuilder.append(j());
    o.d(str, localStringBuilder.toString());
    super.a(paramb);
    this.c = paramb;
    if (this.d) {
      l();
    }
  }
  
  public void a(@Nullable com.tencent.luggage.wxa.qu.a parama)
  {
    if ((parama instanceof gt))
    {
      parama = (gt)parama;
      if (parama.B == null)
      {
        parama.B = new z();
        if (3 == h.a.a()) {
          parama.B.b = 0;
        } else {
          parama.B.b = new com.tencent.luggage.wxa.gl.h(j()).a();
        }
        parama.B.d = 654316592;
        z localz = parama.B;
        Object localObject = com.tencent.luggage.wxa.dd.i.a.c();
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
  
  @NotNull
  protected String b()
  {
    return this.b;
  }
  
  public void b(@Nullable com.tencent.luggage.wxa.qu.a parama)
  {
    if ((parama instanceof gt))
    {
      parama = (gt)parama;
      if (parama.B != null) {
        parama.B.b = new com.tencent.luggage.wxa.gl.h(j()).a();
      }
    }
  }
  
  @NotNull
  public byte[] b(@NotNull nl paramnl)
  {
    Intrinsics.checkParameterIsNotNull(paramnl, "resp");
    paramnl = paramnl.a.b();
    Intrinsics.checkExpressionValueIsNotNull(paramnl, "resp.resp_data.toByteArray()");
    return paramnl;
  }
  
  public void c()
  {
    this.d = true;
    l();
  }
  
  public void d()
  {
    this.d = false;
  }
  
  @Nullable
  public Class<nl> e()
  {
    return nl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.i
 * JD-Core Version:    0.7.0.1
 */