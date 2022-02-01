package com.tencent.luggage.wxa.cq;

import android.graphics.Bitmap;

final class c$3
  extends c.a
{
  c$3(int paramInt1, int paramInt2)
  {
    super(null);
  }
  
  Bitmap a(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = this.a;
    if (i <= j) {
      return paramBitmap;
    }
    return Bitmap.createScaledBitmap(paramBitmap, j, this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cq.c.3
 * JD-Core Version:    0.7.0.1
 */