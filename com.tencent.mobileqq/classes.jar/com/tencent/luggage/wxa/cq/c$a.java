package com.tencent.luggage.wxa.cq;

import android.graphics.Bitmap;

abstract class c$a
{
  abstract Bitmap a(Bitmap paramBitmap);
  
  final Bitmap b(Bitmap paramBitmap)
  {
    Bitmap localBitmap = a(paramBitmap);
    if (localBitmap != paramBitmap) {}
    try
    {
      paramBitmap.recycle();
      return localBitmap;
    }
    catch (Exception paramBitmap) {}
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cq.c.a
 * JD-Core Version:    0.7.0.1
 */