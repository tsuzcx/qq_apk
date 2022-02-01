package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.qw.er;
import com.tencent.mm.plugin.appbrand.widget.dialog.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.c.a;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class i$a$1
  implements Runnable
{
  i$a$1(i.a parama, com.tencent.luggage.wxa.ro.b paramb, er paramer) {}
  
  public final void run()
  {
    if (!this.a.b.d())
    {
      this.b.a(f.b.a);
      return;
    }
    i.a.1.a locala = new i.a.1.a(this);
    this.a.a.a((h)this.a.b, (com.tencent.mm.plugin.appbrand.widget.dialog.i)new c(this.a.a.a((h)this.a.b), (List)g.a(this.c.c), this.c.d, this.c.e, (c.a)locala));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.i.a.1
 * JD-Core Version:    0.7.0.1
 */