package com.tencent.luggage.wxa.de;

import com.tencent.luggage.wxa.qw.gu;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.b;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/login/account/tdi/TdiCgiServiceClient$syncPipeline$1$2", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallbackEx;", "Lcom/tencent/luggage/login/account/tdi/ipc/TdiResponse;", "onBridgeNotFound", "", "onCallback", "tdiResponse", "onCaughtInvokeException", "e", "Ljava/lang/Exception;", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class k$b$2
  implements com.tencent.luggage.wxa.hj.f<com.tencent.luggage.wxa.df.f>
{
  k$b$2(b paramb) {}
  
  public void a()
  {
    this.b.a("invokeAsync fail: ipc onBridgeNotFound");
  }
  
  public void a(@Nullable com.tencent.luggage.wxa.df.f paramf)
  {
    Object localObject2 = null;
    if (paramf != null) {
      localObject1 = paramf.c();
    } else {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      this.b.a("ipc invoker data is null");
      o.b(this.a.a.b(), "tdiResponse is null");
      return;
    }
    int i = paramf.a();
    boolean bool = false;
    if (i == 0)
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
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("invokeAysnc fail: ");
    ((StringBuilder)localObject3).append(paramf.a());
    ((StringBuilder)localObject3).append(' ');
    ((StringBuilder)localObject3).append(paramf.b());
    ((b)localObject1).a(((StringBuilder)localObject3).toString());
    localObject3 = this.a.a.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tdiResponse:");
    if (paramf != null) {
      bool = true;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append(" errCode");
    localObject1 = localObject2;
    if (paramf != null) {
      localObject1 = Integer.valueOf(paramf.a());
    }
    localStringBuilder.append(((Integer)localObject1).intValue());
    localStringBuilder.append(' ');
    localStringBuilder.append(paramf.b());
    o.b((String)localObject3, localStringBuilder.toString());
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
 * Qualified Name:     com.tencent.luggage.wxa.de.k.b.2
 * JD-Core Version:    0.7.0.1
 */