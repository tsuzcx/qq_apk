package com.tencent.luggage.wxa.fp;

import android.os.Parcelable;
import com.tencent.luggage.wxa.hj.h;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class i$b
  implements Runnable
{
  i$b(String paramString1, String paramString2, int paramInt) {}
  
  public final void run()
  {
    try
    {
      h.a(r.i(), (Parcelable)new i.a.b.a(this.a, this.b, this.c), i.a.b.class);
      return;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.WxaCollectionStorage", (Throwable)localException, "caught crash", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fp.i.b
 * JD-Core Version:    0.7.0.1
 */