package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.luggage.wxa.c.b;

class e$a
  implements e.b
{
  private e$a(e parame) {}
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    b.b("MiroMsg.MBBitmapPool", "hy: dummy getTask", new Object[0]);
    return Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
  }
  
  public void a()
  {
    b.b("MiroMsg.MBBitmapPool", "hy: dummy init", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.e.a
 * JD-Core Version:    0.7.0.1
 */