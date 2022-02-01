package com.tencent.mobileqq.ar.keying;

import android.opengl.GLES20;
import android.os.Build;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class CylinderSide
{
  int jdField_a_of_type_Int = 0;
  FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  FloatBuffer b;
  
  public CylinderSide(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    double d1 = paramFloat2;
    double d2 = paramFloat4;
    Double.isNaN(d2);
    Double.isNaN(d1);
    float f1 = (float)(d1 / (d2 * 3.141592653589793D) * 360.0D);
    float f2 = paramFloat4 / 2.0F * paramFloat1;
    float f3 = paramFloat1 * paramFloat3;
    paramFloat1 = f1 / 1.0F;
    int k = (int)paramFloat1;
    this.jdField_a_of_type_Int = (k * 3 * 4);
    int i = this.jdField_a_of_type_Int;
    float[] arrayOfFloat2 = new float[i * 4];
    float[] arrayOfFloat1 = new float[i * 4];
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("initVertexData. w = ");
    ((StringBuilder)localObject1).append(paramFloat2);
    ((StringBuilder)localObject1).append(", h = ");
    ((StringBuilder)localObject1).append(f3);
    ((StringBuilder)localObject1).append(", d = ");
    ((StringBuilder)localObject1).append(paramFloat4);
    ((StringBuilder)localObject1).append(", angleLen = ");
    ((StringBuilder)localObject1).append(f1);
    ((StringBuilder)localObject1).append(", angdegSpan = ");
    ((StringBuilder)localObject1).append(1.0F);
    ((StringBuilder)localObject1).append(", ni = ");
    ((StringBuilder)localObject1).append(k);
    ((StringBuilder)localObject1).append(", nf = ");
    ((StringBuilder)localObject1).append(paramFloat1);
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = "AREngine_CylinderSide";
    QLog.i("AREngine_CylinderSide", 1, (String)localObject2);
    int j;
    if ((!Build.MODEL.equalsIgnoreCase("MI-ONE Plus")) && (!Build.MODEL.equalsIgnoreCase("M040")))
    {
      i = 1;
      j = 0;
    }
    else
    {
      i = 0;
      j = 1;
    }
    int m = 0;
    paramFloat4 = 0.0F;
    int i1 = 0;
    int n = 0;
    paramFloat3 = f2;
    paramFloat2 = f1;
    for (;;)
    {
      d1 = paramFloat4;
      if (Math.ceil(d1) >= paramFloat2) {
        break;
      }
      double d3 = Math.toRadians(d1);
      f1 = paramFloat4 + 1.0F;
      d1 = Math.toRadians(f1);
      int i2 = m + 1;
      f2 = i2;
      float f4 = paramFloat2 - k * 1.0F;
      if ((f4 > 0.01D) && (m == k))
      {
        d1 = Math.toRadians(paramFloat4 + f4);
        paramFloat4 = m + f4 / 1.0F;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("initVertexData. angrad = ");
        ((StringBuilder)localObject2).append(d3 * 180.0D / 3.141592653589793D);
        ((StringBuilder)localObject2).append(", angradNext = ");
        ((StringBuilder)localObject2).append(180.0D * d1 / 3.141592653589793D);
        ((StringBuilder)localObject2).append(", k = ");
        ((StringBuilder)localObject2).append(m);
        ((StringBuilder)localObject2).append(", kNext = ");
        ((StringBuilder)localObject2).append(paramFloat4);
        QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      else
      {
        paramFloat4 = f2;
      }
      int i3 = i1 + 1;
      d2 = paramFloat3;
      double d4 = Math.cos(d3);
      Double.isNaN(d2);
      arrayOfFloat2[i1] = ((float)(d2 * d4));
      i1 = i3 + 1;
      d4 = Math.sin(d3);
      Double.isNaN(d2);
      arrayOfFloat2[i3] = ((float)(d2 * d4));
      i3 = i1 + 1;
      arrayOfFloat2[i1] = 0.0F;
      i1 = i3 + 1;
      arrayOfFloat2[i3] = 0.0F;
      i3 = n + 1;
      f2 = m / paramFloat1;
      arrayOfFloat1[n] = f2;
      m = i3 + 1;
      f4 = j;
      arrayOfFloat1[i3] = f4;
      n = m + 1;
      arrayOfFloat1[m] = 0.0F;
      m = n + 1;
      arrayOfFloat1[n] = 1.0F;
      n = i1 + 1;
      d4 = Math.cos(d1);
      Double.isNaN(d2);
      arrayOfFloat2[i1] = ((float)(d2 * d4));
      i1 = n + 1;
      d4 = Math.sin(d1);
      Double.isNaN(d2);
      arrayOfFloat2[n] = ((float)(d4 * d2));
      i3 = i1 + 1;
      arrayOfFloat2[i1] = f3;
      n = i3 + 1;
      arrayOfFloat2[i3] = 0.0F;
      i1 = m + 1;
      paramFloat4 /= paramFloat1;
      arrayOfFloat1[m] = paramFloat4;
      m = i1 + 1;
      float f5 = i;
      arrayOfFloat1[i1] = f5;
      i1 = m + 1;
      arrayOfFloat1[m] = 0.0F;
      m = i1 + 1;
      arrayOfFloat1[i1] = 1.0F;
      i1 = n + 1;
      d4 = Math.cos(d3);
      Double.isNaN(d2);
      arrayOfFloat2[n] = ((float)(d2 * d4));
      n = i1 + 1;
      d4 = Math.sin(d3);
      Double.isNaN(d2);
      arrayOfFloat2[i1] = ((float)(d4 * d2));
      i1 = n + 1;
      arrayOfFloat2[n] = f3;
      n = i1 + 1;
      arrayOfFloat2[i1] = 0.0F;
      i1 = m + 1;
      arrayOfFloat1[m] = f2;
      m = i1 + 1;
      arrayOfFloat1[i1] = f5;
      i1 = m + 1;
      arrayOfFloat1[m] = 0.0F;
      m = i1 + 1;
      arrayOfFloat1[i1] = 1.0F;
      i1 = n + 1;
      d4 = Math.cos(d3);
      Double.isNaN(d2);
      arrayOfFloat2[n] = ((float)(d4 * d2));
      n = i1 + 1;
      d3 = Math.sin(d3);
      Double.isNaN(d2);
      arrayOfFloat2[i1] = ((float)(d3 * d2));
      i1 = n + 1;
      arrayOfFloat2[n] = 0.0F;
      n = i1 + 1;
      arrayOfFloat2[i1] = 0.0F;
      i1 = m + 1;
      arrayOfFloat1[m] = f2;
      m = i1 + 1;
      arrayOfFloat1[i1] = f4;
      i1 = m + 1;
      arrayOfFloat1[m] = 0.0F;
      m = i1 + 1;
      arrayOfFloat1[i1] = 1.0F;
      i1 = n + 1;
      d3 = Math.cos(d1);
      Double.isNaN(d2);
      arrayOfFloat2[n] = ((float)(d3 * d2));
      n = i1 + 1;
      d3 = Math.sin(d1);
      Double.isNaN(d2);
      arrayOfFloat2[i1] = ((float)(d3 * d2));
      i1 = n + 1;
      arrayOfFloat2[n] = 0.0F;
      n = i1 + 1;
      arrayOfFloat2[i1] = 0.0F;
      i1 = m + 1;
      arrayOfFloat1[m] = paramFloat4;
      m = i1 + 1;
      arrayOfFloat1[i1] = f4;
      i1 = m + 1;
      arrayOfFloat1[m] = 0.0F;
      m = i1 + 1;
      arrayOfFloat1[i1] = 1.0F;
      i1 = n + 1;
      d3 = Math.cos(d1);
      Double.isNaN(d2);
      arrayOfFloat2[n] = ((float)(d3 * d2));
      i3 = i1 + 1;
      d1 = Math.sin(d1);
      Double.isNaN(d2);
      arrayOfFloat2[i1] = ((float)(d2 * d1));
      n = i3 + 1;
      arrayOfFloat2[i3] = f3;
      arrayOfFloat2[n] = 0.0F;
      i1 = m + 1;
      arrayOfFloat1[m] = paramFloat4;
      m = i1 + 1;
      arrayOfFloat1[i1] = f5;
      i3 = m + 1;
      arrayOfFloat1[m] = 0.0F;
      arrayOfFloat1[i3] = 1.0F;
      paramFloat4 = f1;
      m = i2;
      i1 = n + 1;
      n = i3 + 1;
    }
    localObject1 = ByteBuffer.allocateDirect(arrayOfFloat2.length * 4);
    ((ByteBuffer)localObject1).order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioFloatBuffer = ((ByteBuffer)localObject1).asFloatBuffer();
    this.jdField_a_of_type_JavaNioFloatBuffer.put(arrayOfFloat2);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    localObject1 = ByteBuffer.allocateDirect(arrayOfFloat1.length * 4);
    ((ByteBuffer)localObject1).order(ByteOrder.nativeOrder());
    this.b = ((ByteBuffer)localObject1).asFloatBuffer();
    this.b.put(arrayOfFloat1);
    this.b.position(0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    GLES20.glVertexAttribPointer(paramInt1, 3, 5126, false, 16, this.jdField_a_of_type_JavaNioFloatBuffer);
    GLES20.glVertexAttribPointer(paramInt2, 2, 5126, false, 16, this.b);
    GLES20.glEnableVertexAttribArray(paramInt1);
    GLES20.glEnableVertexAttribArray(paramInt2);
    GLES20.glDrawArrays(4, 0, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.keying.CylinderSide
 * JD-Core Version:    0.7.0.1
 */