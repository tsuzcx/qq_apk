package com.tencent.magicbrush;

import com.tencent.mm.appbrand.v8.BufferURLManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 13})
final class e$e
  implements Runnable
{
  e$e(e parame, Function0 paramFunction0) {}
  
  public final void run()
  {
    ak localak = (ak)this.b.invoke();
    e locale = this.a;
    locale.nativeBindTo(locale.a, localak.a(), localak.b(), localak.c());
    this.a.q().a(localak.a(), localak.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.e.e
 * JD-Core Version:    0.7.0.1
 */