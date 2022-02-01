package com.tencent.liteav.beauty.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;

class m$1
  implements Runnable
{
  m$1(m paramm, Bitmap paramBitmap1, Bitmap paramBitmap2) {}
  
  public void run()
  {
    m.a(this.c, this.a);
    m.b(this.c, this.b);
    Bitmap localBitmap = this.a;
    m localm;
    if (localBitmap != null)
    {
      localm = this.c;
      m.a(localm, TXCOpenGlUtils.a(localBitmap, m.a(localm), false));
      m.b(this.c)[0] = 1.0F;
    }
    else
    {
      if (m.a(this.c) != -1) {
        GLES20.glDeleteTextures(1, new int[] { m.a(this.c) }, 0);
      }
      m.a(this.c, -1);
      m.b(this.c)[0] = 0.0F;
    }
    localBitmap = this.b;
    if (localBitmap != null)
    {
      localm = this.c;
      m.b(localm, TXCOpenGlUtils.a(localBitmap, m.c(localm), false));
      m.b(this.c)[1] = 1.0F;
      return;
    }
    if (m.c(this.c) != -1) {
      GLES20.glDeleteTextures(1, new int[] { m.c(this.c) }, 0);
    }
    m.b(this.c, -1);
    m.b(this.c)[1] = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.m.1
 * JD-Core Version:    0.7.0.1
 */