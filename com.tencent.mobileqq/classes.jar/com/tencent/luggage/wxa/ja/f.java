package com.tencent.luggage.wxa.ja;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region.Op;
import com.tencent.luggage.wxa.pc.e;

public class f
  extends Canvas
{
  private Bitmap a;
  
  public f()
  {
    b();
  }
  
  public f(Bitmap paramBitmap)
  {
    super(paramBitmap);
    b();
    this.a = paramBitmap;
  }
  
  private void b() {}
  
  public Bitmap a()
  {
    return this.a;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Bitmap localBitmap = this.a;
    localBitmap = e.a(localBitmap, new RectF(0.0F, 0.0F, localBitmap.getWidth(), this.a.getHeight()), new RectF(paramFloat1, paramFloat2, paramFloat3, paramFloat4), Region.Op.DIFFERENCE);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.a.eraseColor(0);
      drawBitmap(localBitmap, 0.0F, 0.0F, null);
      localBitmap.recycle();
    }
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    super.setBitmap(paramBitmap);
    this.a = paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ja.f
 * JD-Core Version:    0.7.0.1
 */