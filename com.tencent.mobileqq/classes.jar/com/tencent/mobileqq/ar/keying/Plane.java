package com.tencent.mobileqq.ar.keying;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class Plane
{
  public static final float[] a = { -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  public static final short[] b = { 0, 1, 2, 2, 3, 0 };
  public float[] c;
  public short[] d;
  private FloatBuffer e;
  private ShortBuffer f;
  
  public Plane()
  {
    this.c = a;
    this.d = b;
    b();
  }
  
  public Plane(float[] paramArrayOfFloat, short[] paramArrayOfShort)
  {
    this.c = paramArrayOfFloat;
    this.d = paramArrayOfShort;
    b();
  }
  
  private void b()
  {
    this.e = ByteBuffer.allocateDirect(this.c.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.e.put(this.c).position(0);
    this.f = ByteBuffer.allocateDirect(this.d.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
    this.f.put(this.d).position(0);
  }
  
  public void a()
  {
    GLES20.glDrawElements(4, 6, 5123, this.f);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    GLES20.glEnableVertexAttribArray(paramInt1);
    KeyingUtil.a("glEnableVertexAttribArray aPositionHandle");
    GLES20.glEnableVertexAttribArray(paramInt2);
    KeyingUtil.a("glEnableVertexAttribArray aTextureCoordHandle");
    this.e.position(0);
    GLES20.glVertexAttribPointer(paramInt1, 3, 5126, false, 20, this.e);
    this.e.position(3);
    GLES20.glVertexAttribPointer(paramInt2, 2, 5126, false, 20, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.keying.Plane
 * JD-Core Version:    0.7.0.1
 */