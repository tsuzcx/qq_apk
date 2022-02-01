package com.tencent.luggage.wxa.fv;

import com.tencent.ilink.tdi.b.v;
import com.tencent.ilink.tdi.b.z;
import com.tencent.ilinkservice.ao;
import com.tencent.ilinkservice.aq;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.dd.b.c;
import com.tencent.luggage.wxa.dd.g;
import com.tencent.luggage.wxa.de.b;
import com.tencent.luggage.wxa.de.d;
import com.tencent.luggage.wxa.de.q;
import com.tencent.luggage.wxa.fq.g.c;
import com.tencent.luggage.wxa.gl.h;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxaapi.TdiAuthErrCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errCode", "", "<anonymous parameter 1>", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiLoginResponse;", "invoke", "com/tencent/luggage/wxaapi/internal/tdi/LoginByWechatOpenSDKOauth$login$1$2$2"}, k=3, mv={1, 1, 16})
final class f$b$b
  extends Lambda
  implements Function2<Integer, b.v, Unit>
{
  f$b$b(f.b paramb)
  {
    super(2);
  }
  
  public final void a(int paramInt, @Nullable b.v paramv)
  {
    paramv = f.a(this.a.a);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("login() thirdAppLogin return errCode=");
    ((StringBuilder)localObject1).append(paramInt);
    o.d(paramv, ((StringBuilder)localObject1).toString());
    if (paramInt != 0)
    {
      paramv = this.a.a;
      localObject1 = TdiAuthErrCode.WechatTdi_Auth_Err_NormalErr;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("InternalError:");
      ((StringBuilder)localObject2).append(paramInt);
      f.a(paramv, (TdiAuthErrCode)localObject1, ((StringBuilder)localObject2).toString());
      return;
    }
    paramv = a.c.f();
    if (paramv == null) {
      Intrinsics.throwNpe();
    }
    paramv = paramv.a();
    localObject1 = new g();
    ((g)localObject1).c(g.c.a.a());
    if (paramv == null) {
      Intrinsics.throwNpe();
    }
    Object localObject2 = paramv.b();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "cloneSession!!.userInfo");
    ((g)localObject1).b(new h(((b.z)localObject2).g()).a());
    ((g)localObject1).a("LoginByTdiCloneSession");
    localObject2 = af.b("");
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "Util.nullAsNil(\"\")");
    ((g)localObject1).b((String)localObject2);
    ((g)localObject1).c(2147483647);
    localObject2 = g.c.a;
    b.z localz = paramv.b();
    Intrinsics.checkExpressionValueIsNotNull(localz, "cloneSession!!.userInfo");
    ((g.c)localObject2).a(localz.g());
    ((d)e.a(d.class)).a((b)new q(paramv));
    this.a.d.a((g)localObject1);
    f.a(this.a.a, TdiAuthErrCode.WechatTdi_Auth_Err_OK, null, 2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fv.f.b.b
 * JD-Core Version:    0.7.0.1
 */