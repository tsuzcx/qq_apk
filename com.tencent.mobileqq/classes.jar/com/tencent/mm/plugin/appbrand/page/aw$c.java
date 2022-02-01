package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.oi.f.a;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$1"}, k=3, mv={1, 1, 16})
public final class aw$c
  implements Runnable
{
  public aw$c(aw paramaw1, aw paramaw2, f.a parama, int paramInt) {}
  
  public final void run()
  {
    if (!aw.b(this.a).d())
    {
      o.b(aw.a(this.a), "runOnUiThread in ui-thread PageView destroyed");
      return;
    }
    aw.c(this.b).a(this.c.a(), this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aw.c
 * JD-Core Version:    0.7.0.1
 */