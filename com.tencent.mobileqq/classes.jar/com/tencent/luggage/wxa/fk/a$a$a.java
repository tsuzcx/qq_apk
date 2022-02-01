package com.tencent.luggage.wxa.fk;

import com.tencent.luggage.wxa.en.e;
import com.tencent.luggage.wxa.fa.b;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class a$a$a
  implements Runnable
{
  public static final a a = new a();
  
  public final void run()
  {
    if ((b.a.b()) && (e.b()))
    {
      o.d("Luggage.WxaAppProcessSharedPreloader", "xweb onUpdateFinished, force preload when no active runtimes");
      a.a.a(null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fk.a.a.a
 * JD-Core Version:    0.7.0.1
 */