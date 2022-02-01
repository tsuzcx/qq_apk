package com.tencent.luggage.wxa.ml;

import com.tencent.luggage.wxa.mi.b;
import com.tencent.luggage.wxa.mi.b.e;
import com.tencent.luggage.wxa.qz.o;

class a$7
  implements b.e
{
  a$7(a parama) {}
  
  public boolean a(b paramb, int paramInt1, int paramInt2)
  {
    o.e("MicroMsg.Video.AbstractVideoTextureView", "onInfo [%d %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (a.i(this.a) != null) {
      a.i(this.a).d(paramInt1, paramInt2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ml.a.7
 * JD-Core Version:    0.7.0.1
 */