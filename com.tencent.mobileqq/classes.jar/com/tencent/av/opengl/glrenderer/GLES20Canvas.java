package com.tencent.av.opengl.glrenderer;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import com.tencent.av.opengl.program.DrawProgram;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.texture.BasicTexture;
import com.tencent.av.opengl.utils.IntArray;
import com.tencent.av.opengl.utils.Utils;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

@TargetApi(8)
public class GLES20Canvas
  implements GLCanvas
{
  private static final GLId G = new GLES20Id();
  private static final float[] b = { -0.5F, -0.5F, 0.5F, -0.5F, -0.5F, 0.5F, 0.5F, 0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  private final float[] A = new float[32];
  private final float[] B = new float[4];
  private final RectF C = new RectF();
  private final RectF D = new RectF();
  private final float[] E = new float[16];
  private final int[] F = new int[1];
  float[] a = new float[16];
  private float[] c = new float[8];
  private IntArray d = new IntArray();
  private int e = 0;
  private int f = 0;
  private volatile int g;
  private volatile int h;
  private DrawProgram i;
  private int j;
  private float[] k = new float[16];
  private float[] l = new float[16];
  private float[] m;
  private float n = 3.0F;
  private float o = 0.0F;
  private float p = 180.0F;
  private float[][] q = (float[][])Array.newInstance(Float.TYPE, new int[] { 10, 16 });
  private int r = -1;
  private float s = 0.0F;
  private ByteBuffer t = ByteBuffer.allocateDirect(12);
  private final IntArray u = new IntArray();
  private final IntArray v = new IntArray();
  private int w = 0;
  private int x = 0;
  private int y = 0;
  private int z = 0;
  
  public GLES20Canvas()
  {
    Matrix.setIdentityM(this.E, 0);
    this.c[this.e] = 1.0F;
    this.j = a(a(b));
    this.i = new DrawProgram();
    GLES20.glBlendFunc(1, 771);
    Utils.a();
  }
  
  private int a(Buffer paramBuffer, int paramInt)
  {
    G.a(1, this.F, 0);
    Utils.a();
    int i1 = this.F[0];
    GLES20.glBindBuffer(34962, i1);
    Utils.a();
    GLES20.glBufferData(34962, paramBuffer.capacity() * paramInt, paramBuffer, 35044);
    Utils.a();
    return i1;
  }
  
  private static FloatBuffer a(float[] paramArrayOfFloat)
  {
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    localFloatBuffer.put(paramArrayOfFloat, 0, paramArrayOfFloat.length).position(0);
    return localFloatBuffer;
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    Matrix.frustumM(this.k, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat)
  {
    GLES20.glUseProgram(this.i.a());
    Utils.a();
    if (paramFloat > 0.0F)
    {
      GLES20.glLineWidth(paramFloat);
      Utils.a();
    }
    float[] arrayOfFloat = b(paramInt2);
    boolean bool;
    if (arrayOfFloat[3] < 1.0F) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool);
    if (bool)
    {
      GLES20.glBlendColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
      Utils.a();
    }
    GLES20.glUniform4fv(this.i.b()[2].a, 1, arrayOfFloat, 0);
    a(this.i.b(), paramInt1);
    Utils.a();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4, float paramFloat5)
  {
    a(paramInt2, paramInt4, paramFloat5);
    a(this.i.b(), paramInt1, paramInt3, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GLPaint paramGLPaint)
  {
    a(paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramGLPaint.a(), paramGLPaint.b());
  }
  
  private void a(RectF paramRectF)
  {
    this.E[0] = paramRectF.width();
    this.E[5] = paramRectF.height();
    this.E[12] = paramRectF.left;
    this.E[13] = paramRectF.top;
  }
  
  private static void a(RectF paramRectF, BasicTexture paramBasicTexture)
  {
    int i1 = paramBasicTexture.i();
    int i2 = paramBasicTexture.j();
    float f1 = paramRectF.left;
    float f2 = i1;
    paramRectF.left = (f1 / f2);
    paramRectF.right /= f2;
    f1 = paramRectF.top;
    f2 = i2;
    paramRectF.top = (f1 / f2);
    paramRectF.bottom /= f2;
  }
  
  private void a(BasicTexture paramBasicTexture, RectF paramRectF1, RectF paramRectF2)
  {
    a(paramRectF1);
    a(paramBasicTexture, this.E, paramRectF2);
  }
  
  private void a(BasicTexture paramBasicTexture, float[] paramArrayOfFloat, RectF paramRectF)
  {
    ShaderParameter[] arrayOfShaderParameter = paramBasicTexture.c(this);
    a(arrayOfShaderParameter, 0);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[3].a, 1, false, paramArrayOfFloat, 0);
    Utils.a();
    if (paramBasicTexture.d())
    {
      a(2);
      a(0.0F, paramRectF.centerY());
      b(1.0F, -1.0F, 1.0F);
      a(0.0F, -paramRectF.centerY());
    }
    a(arrayOfShaderParameter, 5, 4, paramRectF.left, paramRectF.top, paramRectF.width(), paramRectF.height());
    if (paramBasicTexture.d()) {
      g();
    }
    this.x += 1;
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GLES20.glEnable(3042);
      Utils.a();
      return;
    }
    GLES20.glDisable(3042);
    Utils.a();
  }
  
  private void a(ShaderParameter[] paramArrayOfShaderParameter, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    l();
    a(paramFloat1, paramFloat2, 0.0F);
    b(paramFloat3, paramFloat4, 1.0F);
    GLES20.glUniformMatrix4fv(paramArrayOfShaderParameter[1].a, 1, false, n(), 0);
    m();
    Utils.a();
  }
  
  private void a(ShaderParameter[] paramArrayOfShaderParameter, int paramInt)
  {
    GLES20.glBindBuffer(34962, this.j);
    Utils.a();
    GLES20.glVertexAttribPointer(paramArrayOfShaderParameter[0].a, 2, 5126, false, 8, paramInt * 8);
    Utils.a();
    GLES20.glBindBuffer(34962, 0);
    Utils.a();
  }
  
  private void a(ShaderParameter[] paramArrayOfShaderParameter, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    a(paramArrayOfShaderParameter, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    int i1 = paramArrayOfShaderParameter[0].a;
    GLES20.glEnableVertexAttribArray(i1);
    Utils.a();
    GLES20.glDrawArrays(paramInt1, 0, paramInt2);
    Utils.a();
    GLES20.glDisableVertexAttribArray(i1);
    GLES20.glBindTexture(3553, 0);
    Utils.a();
  }
  
  private float[] b(int paramInt)
  {
    float f1 = (paramInt >>> 24 & 0xFF) / 255.0F * e();
    float f2 = (paramInt >>> 16 & 0xFF) / 255.0F;
    float f3 = (paramInt >>> 8 & 0xFF) / 255.0F;
    float f4 = (paramInt & 0xFF) / 255.0F;
    float[] arrayOfFloat = this.B;
    arrayOfFloat[0] = (f2 * f1);
    arrayOfFloat[1] = (f3 * f1);
    arrayOfFloat[2] = (f4 * f1);
    arrayOfFloat[3] = f1;
    return arrayOfFloat;
  }
  
  private float[] n()
  {
    Matrix.multiplyMM(this.a, 0, this.l, 0, this.m, 0);
    float[] arrayOfFloat = this.a;
    Matrix.multiplyMM(arrayOfFloat, 0, this.k, 0, arrayOfFloat, 0);
    return this.a;
  }
  
  public int a(FloatBuffer paramFloatBuffer)
  {
    return a(paramFloatBuffer, 4);
  }
  
  public Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    IntBuffer localIntBuffer = IntBuffer.allocate(paramInt1 * paramInt2);
    GLES20.glReadPixels(0, 0, paramInt1, paramInt2, 6408, 5121, localIntBuffer);
    paramBitmap.copyPixelsFromBuffer(IntBuffer.wrap(localIntBuffer.array()));
    return paramBitmap;
  }
  
  public GLId a()
  {
    return G;
  }
  
  public void a(float paramFloat)
  {
    this.c[this.e] = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    a(paramFloat1, paramFloat2, 0.0F);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix.translateM(this.m, 0, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Matrix.rotateM(this.m, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    this.s = paramFloat3;
    Matrix.setLookAtM(this.l, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    a(5, 0, 4, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, 0.0F);
    this.y += 1;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GLPaint paramGLPaint)
  {
    a(3, 4, 2, paramFloat1, paramFloat2, paramFloat3 - paramFloat1, paramFloat4 - paramFloat2, paramGLPaint);
    this.z += 1;
  }
  
  @TargetApi(9)
  public void a(int paramInt)
  {
    int i2 = 0;
    if ((paramInt & 0x1) == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      float f1 = e();
      this.e += 1;
      if (this.c.length <= this.e)
      {
        float[] arrayOfFloat1;
        if (Build.VERSION.SDK_INT >= 9)
        {
          arrayOfFloat1 = this.c;
          this.c = Arrays.copyOf(arrayOfFloat1, arrayOfFloat1.length * 2);
        }
        else
        {
          arrayOfFloat1 = new float[this.c.length * 2];
          i1 = 0;
          for (;;)
          {
            float[] arrayOfFloat2 = this.c;
            if (i1 >= arrayOfFloat2.length) {
              break;
            }
            arrayOfFloat1[i1] = arrayOfFloat2[i1];
            i1 += 1;
          }
          this.c = arrayOfFloat1;
        }
      }
      this.c[this.e] = f1;
    }
    int i1 = i2;
    if ((paramInt & 0x2) == 2) {
      i1 = 1;
    }
    if (i1 != 0) {
      l();
    }
    this.d.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.h = paramInt2;
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    k();
    int i1 = -paramInt1;
    a(i1 / 4, paramInt1 / 4, -paramInt2 / 4, paramInt2 / 4, paramInt2, 1000000.0F);
    a(0.0F, 0.0F, paramInt2 * 2, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    a(0.0F, paramInt2 / 2, 0.0F);
    b(1.0F, -1.0F, 1.0F);
    a(i1 / 2, 0.0F, 0.0F);
    Utils.a();
  }
  
  public void a(BasicTexture paramBasicTexture, int paramInt1, int paramInt2)
  {
    int i2 = paramBasicTexture.l();
    int[] arrayOfInt = paramBasicTexture.e();
    int i1 = 0;
    while (i1 < arrayOfInt.length)
    {
      GLES20.glBindTexture(i2, paramBasicTexture.e()[i1]);
      i1 += 1;
    }
    Utils.a();
    GLES20.glTexImage2D(i2, 0, paramInt1, paramBasicTexture.i(), paramBasicTexture.j(), 0, paramInt1, paramInt2, null);
  }
  
  public void a(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt3 > 0)
    {
      if (paramInt4 <= 0) {
        return;
      }
      Rect localRect = paramBasicTexture.h();
      this.C.set(localRect.left, localRect.top, localRect.right, localRect.bottom);
      this.D.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
      a(this.C, paramBasicTexture);
      a(paramBasicTexture, this.C, this.D);
    }
  }
  
  public void a(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4)
  {
    int i2 = paramBasicTexture.l();
    int[] arrayOfInt = paramBasicTexture.e();
    int i1 = 0;
    while (i1 < arrayOfInt.length)
    {
      GLES20.glBindTexture(i2, paramBasicTexture.e()[i1]);
      i1 += 1;
    }
    Utils.a();
    GLUtils.texSubImage2D(i2, 0, paramInt1, paramInt2, paramBitmap, paramInt3, paramInt4);
  }
  
  public void a(BasicTexture paramBasicTexture, Bitmap paramBitmap)
  {
    int i2 = paramBasicTexture.l();
    int[] arrayOfInt = paramBasicTexture.e();
    int i1 = 0;
    while (i1 < arrayOfInt.length)
    {
      GLES20.glBindTexture(i2, paramBasicTexture.e()[i1]);
      i1 += 1;
    }
    Utils.a();
    GLUtils.texImage2D(i2, 0, paramBitmap, 0);
  }
  
  public void a(BasicTexture paramBasicTexture, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt3 > 0)
    {
      if (paramInt4 <= 0) {
        return;
      }
      this.D.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
      a(paramBasicTexture, paramArrayOfFloat, this.D);
    }
  }
  
  public boolean a(BasicTexture paramBasicTexture)
  {
    boolean bool = paramBasicTexture.m();
    if (bool) {}
    for (;;)
    {
      synchronized (this.u)
      {
        paramBasicTexture = paramBasicTexture.e();
        if (paramBasicTexture != null) {
          break label68;
        }
        return bool;
        if (i1 < paramBasicTexture.length)
        {
          this.u.a(paramBasicTexture[i1]);
          i1 += 1;
          continue;
        }
        return bool;
      }
      return bool;
      label68:
      int i1 = 0;
    }
  }
  
  public int b()
  {
    return this.g;
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix.scaleM(this.m, 0, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void b(BasicTexture paramBasicTexture)
  {
    int i2 = paramBasicTexture.l();
    int[] arrayOfInt = paramBasicTexture.e();
    int i1 = 0;
    while (i1 < arrayOfInt.length)
    {
      GLES20.glBindTexture(i2, paramBasicTexture.e()[i1]);
      i1 += 1;
    }
    Utils.a();
    GLES20.glTexParameteri(i2, 10242, 33071);
    GLES20.glTexParameteri(i2, 10243, 33071);
    GLES20.glTexParameterf(i2, 10241, 9729.0F);
    GLES20.glTexParameterf(i2, 10240, 9729.0F);
  }
  
  public int c()
  {
    return this.h;
  }
  
  public void d()
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    Utils.a();
    GLES20.glClear(16384);
    Utils.a();
  }
  
  public float e()
  {
    return this.c[this.e];
  }
  
  public void f()
  {
    a(-1);
  }
  
  public void g()
  {
    int i3 = this.d.a();
    int i2 = 0;
    if ((i3 & 0x1) == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      this.e -= 1;
    }
    int i1 = i2;
    if ((i3 & 0x2) == 2) {
      i1 = 1;
    }
    if (i1 != 0)
    {
      this.f -= 16;
      m();
    }
  }
  
  public void h()
  {
    synchronized (this.u)
    {
      IntArray localIntArray2 = this.u;
      if (this.u.b() > 0)
      {
        G.a(null, localIntArray2.b(), localIntArray2.c(), 0);
        localIntArray2.d();
      }
      localIntArray2 = this.v;
      if (localIntArray2.b() > 0)
      {
        G.b(null, localIntArray2.b(), localIntArray2.c(), 0);
        localIntArray2.d();
      }
      return;
    }
  }
  
  public int i()
  {
    return this.g;
  }
  
  public int j()
  {
    return this.h;
  }
  
  public void k()
  {
    this.m = new float[16];
    Matrix.setRotateM(this.m, 0, 0.0F, 1.0F, 0.0F, 0.0F);
  }
  
  public void l()
  {
    this.r += 1;
    int i1 = 0;
    while (i1 < 16)
    {
      this.q[this.r][i1] = this.m[i1];
      i1 += 1;
    }
  }
  
  public void m()
  {
    int i1 = 0;
    while (i1 < 16)
    {
      this.m[i1] = this.q[this.r][i1];
      i1 += 1;
    }
    this.r -= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.glrenderer.GLES20Canvas
 * JD-Core Version:    0.7.0.1
 */