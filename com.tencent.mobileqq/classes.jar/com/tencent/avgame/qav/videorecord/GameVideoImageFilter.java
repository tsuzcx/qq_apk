package com.tencent.avgame.qav.videorecord;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class GameVideoImageFilter
  extends GPUImageFilter
{
  private volatile int k = -1;
  private volatile int l = -1;
  private volatile Bitmap m;
  private volatile int n;
  private volatile int o;
  private volatile int p;
  private volatile int q;
  
  private int a(int paramInt)
  {
    if (paramInt != -1) {
      GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
    }
    return -1;
  }
  
  private float[] a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    float f = paramFloat1 / 2.0F;
    paramFloat1 = paramFloat3 / f;
    paramFloat3 = paramFloat2 / 2.0F;
    paramFloat2 = paramFloat4 / paramFloat3;
    paramFloat4 = paramFloat5 / f;
    paramFloat5 = paramFloat6 / paramFloat3;
    paramFloat3 = paramFloat4 - 1.0F;
    paramFloat1 += paramFloat3;
    paramFloat4 = 1.0F - paramFloat5;
    paramFloat2 = paramFloat4 - paramFloat2;
    return new float[] { paramFloat3, paramFloat2, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat1, paramFloat4 };
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if ((this.n > 0) && (this.o > 0))
    {
      this.d.clear();
      this.d.put(a(paramInt1, paramInt2, this.n, this.o, this.p, this.q)).position(0);
    }
  }
  
  public void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    j();
    if (this.k != -1) {
      super.a(this.k, paramFloatBuffer1, paramFloatBuffer2);
    }
  }
  
  public void a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBitmap != this.m)
    {
      this.l = this.k;
      this.k = -1;
      this.m = paramBitmap;
    }
    this.n = paramInt1;
    this.o = paramInt2;
    this.p = paramInt3;
    this.q = paramInt4;
    if ((g() > 0) && (h() > 0))
    {
      this.d.clear();
      this.d.put(a(g(), h(), paramInt1, paramInt2, paramInt3, paramInt4)).position(0);
    }
    i();
    a(new GameVideoImageFilter.1(this));
  }
  
  public void e()
  {
    super.e();
    this.k = a(this.k);
    this.l = a(this.l);
    this.k = -1;
    this.l = -1;
    this.m = null;
  }
  
  public void l()
  {
    a(this.k, this.d, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.videorecord.GameVideoImageFilter
 * JD-Core Version:    0.7.0.1
 */