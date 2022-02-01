package com.tencent.luggage.wxa.ek;

import android.widget.FrameLayout;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class a$n
  implements Runnable
{
  a$n(a parama, boolean paramBoolean) {}
  
  public final void run()
  {
    FrameLayout localFrameLayout = a.f(this.a);
    int i;
    if (this.b) {
      i = 0;
    } else {
      i = 4;
    }
    localFrameLayout.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ek.a.n
 * JD-Core Version:    0.7.0.1
 */