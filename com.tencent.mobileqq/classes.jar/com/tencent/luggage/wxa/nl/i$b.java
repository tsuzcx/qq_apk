package com.tencent.luggage.wxa.nl;

import com.tencent.luggage.wxa.qw.bz;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"buildBasicItem", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "invoke"}, k=3, mv={1, 1, 16})
final class i$b
  extends Lambda
  implements Function0<bz>
{
  i$b(k.b paramb)
  {
    super(0);
  }
  
  @NotNull
  public final bz a()
  {
    bz localbz = new bz();
    localbz.a = i.a(i.a, this.a);
    localbz.c = this.a.f();
    if (this.a.i())
    {
      localbz.e = true;
      localbz.d = this.a.e();
    }
    else
    {
      localbz.d = this.a.e();
    }
    e.a(localbz);
    return localbz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.i.b
 * JD-Core Version:    0.7.0.1
 */