package com.tencent.luggage.wxa.fc;

import com.tencent.luggage.wxa.standalone_open_runtime.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class b$b$a
  implements Runnable
{
  b$b$a(b.b paramb) {}
  
  public final void run()
  {
    e locale = (e)this.a.y();
    if (locale == null) {
      Intrinsics.throwNpe();
    }
    locale.f("onLoadURL");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fc.b.b.a
 * JD-Core Version:    0.7.0.1
 */