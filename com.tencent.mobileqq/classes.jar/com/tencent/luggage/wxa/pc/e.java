package com.tencent.luggage.wxa.pc;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region.Op;

public class e
{
  public static Bitmap a(Bitmap paramBitmap, RectF paramRectF1, RectF paramRectF2, Region.Op paramOp)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.clipRect(paramRectF1);
    localCanvas.clipRect(paramRectF2, paramOp);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pc.e
 * JD-Core Version:    0.7.0.1
 */