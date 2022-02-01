package com.tencent.luggage.wxa.fj;

import com.tencent.luggage.opensdk.a.a;
import com.tencent.luggage.opensdk.a.b;
import com.tencent.luggage.opensdk.a.c;
import com.tencent.luggage.wxa.fq.g.c;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.qy.a;
import com.tencent.luggage.wxa.qy.c;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/report/KVReport_CALL_TRANSFER_API_10054$Companion;", "", "()V", "isRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "doReport", "", "event", "Lcom/tencent/luggage/opensdk/EventOnReceivedWxaRedirectingPageResponse;", "startMonitor", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class e$a
{
  private final void a(com.tencent.luggage.opensdk.b paramb)
  {
    if (paramb != null)
    {
      a.c localc = paramb.a();
      if (localc != null)
      {
        WXLaunchWxaRedirectingPage.Resp localResp = paramb.b();
        if (localResp != null)
        {
          e locale = new e(null, null, 0, null, 0, 0L, 0, 127, null);
          locale.a(g.c.a.a());
          paramb = localc.a;
          Intrinsics.checkExpressionValueIsNotNull(paramb, "sdkRequest.env");
          locale.b(paramb.a());
          a.a locala = localc.a;
          paramb = locala;
          if (!(locala instanceof a.b)) {
            paramb = null;
          }
          paramb = (a.b)paramb;
          if (paramb != null)
          {
            paramb = paramb.i();
            if (paramb != null)
            {
              paramb = paramb.q();
              if (paramb != null)
              {
                i = paramb.ab() + 1;
                break label135;
              }
            }
          }
          int i = 0;
          label135:
          locale.a(i);
          locale.c(localc.b);
          locale.b(localResp.errCode);
          locale.a(g.c.a.b());
          locale.c(553976065);
          locale.a();
        }
      }
    }
  }
  
  public final void a()
  {
    if (!e.d().getAndSet(true)) {
      a.a.a((c)new e.a.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fj.e.a
 * JD-Core Version:    0.7.0.1
 */