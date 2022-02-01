package com.tencent.luggage.wxa.de;

import com.tencent.ilink.tdi.b.d;
import com.tencent.luggage.wxa.ob.a;
import com.tencent.luggage.wxa.ob.a.a;
import com.tencent.luggage.wxa.ro.b;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/login/account/tdi/TdiCgiServiceBase$syncPipeline$2$1", "Lcom/tencent/luggage/login/account/tdi/ITdiCgiCallback;", "onReceiveAppResponse", "", "taskid", "", "error", "resp", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiAppResponse;", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class j$h$1
  implements c
{
  j$h$1(b paramb) {}
  
  public void a(int paramInt1, int paramInt2, @Nullable b.d paramd)
  {
    if ((paramInt2 == 0) && (paramd != null))
    {
      this.b.a(new Object[] { this.a.a.a(paramd, this.a.f) });
      return;
    }
    this.b.a(new a(a.a.f, paramInt2, "sendTdiRequest fail"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.j.h.1
 * JD-Core Version:    0.7.0.1
 */