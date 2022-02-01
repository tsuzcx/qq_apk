package com.tencent.liteav.videoencoder;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.b.k;

class b$2
  implements Runnable
{
  b$2(b paramb, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong) {}
  
  public void run()
  {
    if ((b.b(this.f) == null) || (b.b(this.f).o() != this.a) || (b.b(this.f).p() != this.b))
    {
      if (b.b(this.f) != null)
      {
        b.b(this.f).d();
        b.a(this.f, null);
      }
      b.a(this.f, new k(this.c));
      if (!b.b(this.f).a())
      {
        if (b.a(this.f) != null)
        {
          b.a(this.f).c();
          b.a(this.f, null);
        }
        b.a(this.f, null);
        return;
      }
      b.b(this.f).a(true);
      b.b(this.f).a(this.a, this.b);
    }
    b.b(this.f).a(this.d);
    GLES20.glViewport(0, 0, this.a, this.b);
    int i = b.b(this.f).r();
    GLES20.glFlush();
    this.f.a(i, this.a, this.b, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.b.2
 * JD-Core Version:    0.7.0.1
 */