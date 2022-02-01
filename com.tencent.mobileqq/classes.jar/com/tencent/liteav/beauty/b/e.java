package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;

public class e
  extends s
{
  private int A;
  private float[] B;
  private int x;
  private int y;
  private int z;
  
  public void b(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float[3];
    double d1 = paramArrayOfFloat[0];
    Double.isNaN(d1);
    double d2 = paramArrayOfFloat[1];
    Double.isNaN(d2);
    double d3 = paramArrayOfFloat[2];
    Double.isNaN(d3);
    arrayOfFloat[0] = ((float)(d1 * 0.2989D + d2 * 0.5866D + d3 * 0.1145D));
    d1 = paramArrayOfFloat[0] - arrayOfFloat[0];
    Double.isNaN(d1);
    arrayOfFloat[1] = ((float)(d1 * 0.7132D));
    d1 = paramArrayOfFloat[2] - arrayOfFloat[0];
    Double.isNaN(d1);
    arrayOfFloat[2] = ((float)(d1 * 0.5647D));
    b(this.y, arrayOfFloat);
  }
  
  public void c()
  {
    super.c();
    this.x = GLES20.glGetUniformLocation(q(), "screenMode");
    this.y = GLES20.glGetUniformLocation(q(), "screenReplaceColor");
    this.z = GLES20.glGetUniformLocation(q(), "screenMirrorX");
    this.A = GLES20.glGetUniformLocation(q(), "screenMirrorY");
    b(this.B);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.e
 * JD-Core Version:    0.7.0.1
 */