package com.tencent.luggage.scanner.scanner.ui.widget;

import com.tencent.luggage.scanner.qbar.e;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class a$i
  implements Runnable
{
  a$i(a parama, e parame) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis();
    a locala = this.a;
    a.a(locala, a.a(locala, this.b));
    o.d("Luggage.ScanCodeMaskView", "alvinluo getFrameBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    t.a((Runnable)new a.i.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.widget.a.i
 * JD-Core Version:    0.7.0.1
 */