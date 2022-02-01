package com.tencent.luggage.wxa.fv;

import com.google.protobuf.ByteString;
import com.tencent.ilink.tdi.b.u;
import com.tencent.ilink.tdi.b.u.a;
import com.tencent.luggage.wxa.dd.b.c;
import com.tencent.luggage.wxa.dg.b;
import com.tencent.luggage.wxa.qw.dt;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxaapi.TdiAuthErrCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "deviceLoginOk", "", "invoke"}, k=3, mv={1, 1, 16})
final class f$b
  extends Lambda
  implements Function1<Boolean, Unit>
{
  f$b(f paramf, String paramString, dt paramdt, b.c paramc)
  {
    super(1);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      o.b(f.a(this.a), "login failed by !deviceLoginOk");
      f.a(this.a, TdiAuthErrCode.WechatTdi_Auth_Err_System, "Inactivated");
      return;
    }
    Object localObject = b.u.s();
    String str = this.b;
    if (str != null) {
      ((b.u.a)localObject).d(ByteString.copyFromUtf8(str));
    }
    localObject = ((b.u.a)localObject).b(ByteString.copyFromUtf8(this.c.a)).c(1).c();
    h.a((b)a.c, (Function1)new f.b.a((b.u)localObject, this), (Function2)new f.b.b(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fv.f.b
 * JD-Core Version:    0.7.0.1
 */