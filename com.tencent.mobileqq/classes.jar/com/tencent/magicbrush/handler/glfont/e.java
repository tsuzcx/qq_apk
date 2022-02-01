package com.tencent.magicbrush.handler.glfont;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;

class e
{
  private Bitmap a;
  private d b = new l();
  private Rect c = new Rect();
  private int[] d = new int[4];
  
  e(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = 512;
    }
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 512;
    }
    this.a = Bitmap.createBitmap(i, paramInt1, Bitmap.Config.ARGB_8888);
    this.b.a(i, paramInt1);
    this.c.setEmpty();
  }
  
  void a()
  {
    this.c.setEmpty();
    this.b.a();
    Bitmap localBitmap = this.a;
    if (localBitmap != null) {
      localBitmap.eraseColor(0);
    }
  }
  
  boolean a(int paramInt1, int paramInt2, Rect paramRect)
  {
    if (paramRect == null) {
      return false;
    }
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.b.a(paramInt1, paramInt2, paramRect);
      if ((paramRect.left >= 0) && (paramRect.right >= 0) && (paramRect.width() > 0))
      {
        if (paramRect.height() <= 0) {
          return false;
        }
        this.c.union(paramRect);
        return true;
      }
      return false;
    }
    paramRect.setEmpty();
    return false;
  }
  
  void b()
  {
    Bitmap localBitmap = this.a;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
  }
  
  int[] c()
  {
    if (!(this.c.isEmpty() ^ true)) {
      return null;
    }
    this.d[0] = this.c.left;
    this.d[1] = this.c.top;
    this.d[2] = this.c.right;
    this.d[3] = this.c.bottom;
    this.c.setEmpty();
    return this.d;
  }
  
  Bitmap d()
  {
    return this.a;
  }
  
  int e()
  {
    Bitmap localBitmap = this.a;
    if (localBitmap != null) {
      return localBitmap.getWidth();
    }
    return 0;
  }
  
  int f()
  {
    Bitmap localBitmap = this.a;
    if (localBitmap != null) {
      return localBitmap.getHeight();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.e
 * JD-Core Version:    0.7.0.1
 */