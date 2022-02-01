package com.tencent.luggage.opensdk;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rm.a;
import kotlin.Metadata;
import kotlinx.coroutines.Job.DefaultImpls;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class j$d
  implements a
{
  j$d(j paramj) {}
  
  public final void b()
  {
    boolean bool;
    if (j.b(this.a) != null) {
      bool = true;
    } else {
      bool = false;
    }
    j.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kill checker, request:");
    localStringBuilder.append(j.c(this.a));
    localStringBuilder.append(" ticket:");
    localStringBuilder.append(j.d(this.a));
    localStringBuilder.append(" started:");
    localStringBuilder.append(bool);
    o.b("Luggage.WXA.OpenSDKTicketTransferResponseStepChecker", localStringBuilder.toString());
    if (bool) {
      Job.DefaultImpls.cancel$default(j.a(this.a), null, 1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.j.d
 * JD-Core Version:    0.7.0.1
 */