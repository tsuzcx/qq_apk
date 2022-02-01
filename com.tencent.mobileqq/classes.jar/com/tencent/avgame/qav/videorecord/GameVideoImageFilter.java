package com.tencent.avgame.qav.videorecord;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class GameVideoImageFilter
  extends GPUImageFilter
{
  private volatile Bitmap a;
  private volatile int g = -1;
  private volatile int h = -1;
  private volatile int i;
  private volatile int j;
  private volatile int k;
  private volatile int l;
  
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
    if ((this.i > 0) && (this.j > 0))
    {
      this.b.clear();
      this.b.put(a(paramInt1, paramInt2, this.i, this.j, this.k, this.l)).position(0);
    }
  }
  
  public void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    g();
    if (this.g != -1) {
      super.a(this.g, paramFloatBuffer1, paramFloatBuffer2);
    }
  }
  
  public void a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBitmap != this.jdField_a_of_type_AndroidGraphicsBitmap)
    {
      this.h = this.g;
      this.g = -1;
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    }
    this.i = paramInt1;
    this.j = paramInt2;
    this.k = paramInt3;
    this.l = paramInt4;
    if ((a() > 0) && (b() > 0))
    {
      this.b.clear();
      this.b.put(a(a(), b(), paramInt1, paramInt2, paramInt3, paramInt4)).position(0);
    }
    f();
    a(new GameVideoImageFilter.1(this));
  }
  
  public void e()
  {
    super.e();
    this.g = a(this.g);
    this.h = a(this.h);
    this.g = -1;
    this.h = -1;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
  }
  
  public void h()
  {
    a(this.g, this.b, this.jdField_a_of_type_JavaNioFloatBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.videorecord.GameVideoImageFilter
 * JD-Core Version:    0.7.0.1
 */