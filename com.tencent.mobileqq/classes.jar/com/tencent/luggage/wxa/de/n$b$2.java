package com.tencent.luggage.wxa.de;

import com.tencent.luggage.wxa.qw.gu;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.b;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/login/account/tdi/TdiCgiServiceNoLoginClient$syncPipeline$1$2", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallbackEx;", "Lcom/tencent/luggage/login/account/tdi/ipc/TdiResponse;", "onBridgeNotFound", "", "onCallback", "tdiResponse", "onCaughtInvokeException", "e", "Ljava/lang/Exception;", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class n$b$2
  implements com.tencent.luggage.wxa.hj.f<com.tencent.luggage.wxa.df.f>
{
  n$b$2(b paramb) {}
  
  public void a()
  {
    this.b.a("invokeAsync fail: ipc onBridgeNotFound");
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.df.f paramf)
  {
    Intrinsics.checkParameterIsNotNull(paramf, "tdiResponse");
    if (paramf.c() == null)
    {
      this.b.a("ipc invoker data is null");
      o.b(this.a.a.b(), "tdiResponse is null");
      return;
    }
    if (paramf.a() == 0)
    {
      localObject1 = this.b;
      localObject2 = paramf.c();
      if (localObject2 != null)
      {
        ((b)localObject1).a(new Object[] { (gu)localObject2 });
        localObject1 = this.a.a.b();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("tdiResponse: ");
        ((StringBuilder)localObject2).append(paramf.c());
        o.e((String)localObject1, ((StringBuilder)localObject2).toString());
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type RESP");
    }
    Object localObject1 = this.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("invokeAsync fail: ");
    ((StringBuilder)localObject2).append(paramf.a());
    ((StringBuilder)localObject2).append(' ');
    ((StringBuilder)localObject2).append(paramf.b());
    ((b)localObject1).a(((StringBuilder)localObject2).toString());
    localObject1 = this.a.a.b();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("tdiResponse:");
    ((StringBuilder)localObject2).append(true);
    ((StringBuilder)localObject2).append(" errCode");
    ((StringBuilder)localObject2).append(paramf.a());
    ((StringBuilder)localObject2).append(' ');
    ((StringBuilder)localObject2).append(paramf.b());
    o.b((String)localObject1, ((StringBuilder)localObject2).toString());
  }
  
  public void a(@Nullable Exception paramException)
  {
    String str = this.a.a.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("syncPipeline cmdId:");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append(", onCaughtInvokeException:");
    localStringBuilder.append(paramException);
    o.b(str, localStringBuilder.toString());
    this.b.a("invokeAsync fail: ipc onCaughtInvokeException");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.n.b.2
 * JD-Core Version:    0.7.0.1
 */