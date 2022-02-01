package com.tencent.luggage.wxa.cv;

import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.qw.ef;
import com.tencent.luggage.wxa.qw.jf;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/JSAPIRealtimeVerifyResponse;", "onTerminate"}, k=3, mv={1, 1, 16})
final class b$g<T>
  implements e.c<ef>
{
  b$g(b paramb, int paramInt, Function0 paramFunction01, m paramm, String paramString, Function0 paramFunction02) {}
  
  public final void a(@Nullable ef paramef)
  {
    int i = this.b;
    if (paramef != null)
    {
      localObject = paramef.b;
      if ((localObject != null) && (i == ((jf)localObject).c))
      {
        this.c.invoke();
        return;
      }
    }
    b.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doRealtimeVerify get VerifyInfo:");
    if (paramef != null)
    {
      paramef = paramef.b;
      if (paramef != null)
      {
        paramef = b.a(this.a, paramef);
        break label83;
      }
    }
    paramef = null;
    label83:
    ((StringBuilder)localObject).append(paramef);
    ((StringBuilder)localObject).append(" with api:");
    ((StringBuilder)localObject).append(this.d.d());
    ((StringBuilder)localObject).append(", url:");
    ((StringBuilder)localObject).append(this.e);
    o.b("Luggage.STANDALONE.HTMLWebViewJsApiPermissionController", ((StringBuilder)localObject).toString());
    this.f.invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cv.b.g
 * JD-Core Version:    0.7.0.1
 */