package com.tencent.luggage.opensdk;

import android.os.Looper;
import com.tencent.luggage.wxa.qw.nh;
import com.tencent.luggage.wxa.qz.v;
import com.tencent.luggage.wxa.qz.v.a;
import com.tencent.luggage.wxa.ro.h;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/WxaRuntimeGetDeeplinkTicketResp;", "call"}, k=3, mv={1, 1, 16})
final class i$b$e<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  i$b$e(i.b paramb) {}
  
  @Nullable
  public final String a(@Nullable nh paramnh)
  {
    if (paramnh == null)
    {
      h.b().a("fail: get ticket failed");
      return "";
    }
    Object localObject = (CharSequence)paramnh.a;
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      i.b.a(this.a, "GetDeepLinkTicket return EMPTY ticket");
      h.b().a(new Exception("empty ticket"));
      return null;
    }
    localObject = h.b();
    long l = TimeUnit.SECONDS.toMillis(paramnh.b);
    i.b.a(this.a, new v(Looper.getMainLooper(), (v.a)new i.b.e.1((com.tencent.luggage.wxa.ro.b)localObject), false));
    i.b.a(this.a).a(l, l);
    paramnh = paramnh.a;
    if (paramnh == null) {
      Intrinsics.throwNpe();
    }
    return paramnh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.i.b.e
 * JD-Core Version:    0.7.0.1
 */