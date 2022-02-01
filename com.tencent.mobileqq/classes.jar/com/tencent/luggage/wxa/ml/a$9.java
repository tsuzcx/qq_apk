package com.tencent.luggage.wxa.ml;

import com.tencent.luggage.wxa.mi.b;
import com.tencent.luggage.wxa.mi.b.d;
import com.tencent.luggage.wxa.qz.o;

class a$9
  implements b.d
{
  a$9(a parama) {}
  
  public boolean a(b paramb, int paramInt1, int paramInt2)
  {
    paramb = new StringBuilder();
    paramb.append("Error: ");
    paramb.append(paramInt1);
    paramb.append(",");
    paramb.append(paramInt2);
    o.c("MicroMsg.Video.AbstractVideoTextureView", paramb.toString());
    if (a.c(this.a) != null) {
      a.c(this.a).a(paramInt1, paramInt2);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ml.a.9
 * JD-Core Version:    0.7.0.1
 */