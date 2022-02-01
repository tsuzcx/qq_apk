package com.tencent.luggage.wxa.de;

import com.tencent.ilink.tdi.b.z;
import com.tencent.ilinkservice.ag.c;
import com.tencent.ilinkservice.aq;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.dg.b;
import com.tencent.luggage.wxa.dg.b.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/login/account/tdi/TdiAccountManager$mTdiSessionCallback$1", "Lcom/tencent/luggage/login/device/IActivateDevice$TdiSessionCallbackWrapper;", "onAppSessionTimeout", "", "onRequestUploadLogfiles", "p0", "Lcom/tencent/ilinkservice/IlinkServiceProto$IlinkPullLogCmd;", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class f$b
  extends b.b
{
  public void a()
  {
    Object localObject1 = e.a(b.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "Luggage.customize(IActivateDevice::class.java)");
    localObject1 = ((b)localObject1).f();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "tdiSession");
    Object localObject2 = ((aq)localObject1).b();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "tdiSession.userInfo");
    localObject2 = ((b.z)localObject2).c();
    String str = this.a.i();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAppSessionTimeout ");
    localStringBuilder.append(localObject2);
    o.d(str, localStringBuilder.toString());
    if (localObject2 == null) {
      return;
    }
    int i = g.a[localObject2.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {}
      }
      else {
        this.a.b();
      }
    }
    else {
      ((aq)localObject1).c();
    }
  }
  
  public void a(@Nullable ag.c paramc)
  {
    if (r.h()) {
      this.a.a(paramc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.f.b
 * JD-Core Version:    0.7.0.1
 */