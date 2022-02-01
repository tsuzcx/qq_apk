package com.tencent.luggage.wxa.de;

import com.tencent.ilink.tdi.b.d;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/login/account/tdi/TdiCgiServiceBase$sync$1$1", "Lcom/tencent/luggage/login/account/tdi/ITdiCgiCallback;", "onReceiveAppResponse", "", "taskid", "", "error", "resp", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiAppResponse;", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class j$f$1
  implements c
{
  public void a(int paramInt1, int paramInt2, @Nullable b.d paramd)
  {
    if ((paramInt2 == 0) && (paramd != null))
    {
      this.a.f.set(this.a.a.a(paramd, this.a.g));
      this.a.h.countDown();
      return;
    }
    this.a.f.set(null);
    this.a.h.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.j.f.1
 * JD-Core Version:    0.7.0.1
 */