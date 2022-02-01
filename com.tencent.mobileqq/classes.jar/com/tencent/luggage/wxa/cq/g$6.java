package com.tencent.luggage.wxa.cq;

import android.graphics.Bitmap;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rl.b;

class g$6
  implements b<String, Bitmap>
{
  g$6(g paramg) {}
  
  public String a(Bitmap paramBitmap)
  {
    int j = -1;
    int i;
    if (paramBitmap == null) {
      i = -1;
    } else {
      i = paramBitmap.getWidth();
    }
    if (paramBitmap != null) {
      j = paramBitmap.getHeight();
    }
    o.e("Luggage.ShareWithSnapshot", "get screenshot w %d h %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    return c.a(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cq.g.6
 * JD-Core Version:    0.7.0.1
 */