package com.tencent.luggage.wxa.bs;

import android.graphics.Bitmap;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.i;

class h$6
  implements com.tencent.luggage.wxa.rl.b<Bitmap, Void>
{
  h$6(h paramh) {}
  
  public Bitmap a(Void paramVoid)
  {
    paramVoid = ((c)this.a.a(c.class)).a().getMagicBrush().u().a();
    o.d("Luggage.Game.WAGamePageViewRenderer", "try get game sharing screenshot: %s", new Object[] { paramVoid });
    return paramVoid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bs.h.6
 * JD-Core Version:    0.7.0.1
 */