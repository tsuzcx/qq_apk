package com.tencent.liteav.basic.opengl;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.LinkedList;

public class j
{
  protected int a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected boolean g;
  protected FloatBuffer h;
  protected FloatBuffer i;
  protected float[] j;
  protected float[] k;
  protected j.a l;
  protected int m = -1;
  protected int n = -1;
  protected boolean o = false;
  protected boolean p = false;
  protected boolean q = false;
  private final LinkedList<Runnable> r = new LinkedList();
  private final String s;
  private final String t;
  private boolean u = false;
  private int v = -1;
  private float[] w = null;
  
  public j()
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", false);
  }
  
  public j(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, false);
  }
  
  public j(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.s = paramString1;
    this.t = paramString2;
    this.q = paramBoolean;
    if (true == paramBoolean) {
      TXCLog.i("TXCGPUFilter", "set Oes fileter");
    }
    this.h = ByteBuffer.allocateDirect(m.e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.j = m.e;
    this.h.put(this.j).position(0);
    this.i = ByteBuffer.allocateDirect(m.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.k = m.a(l.a, false, true);
    this.i.put(this.k).position(0);
  }
  
  private static float[] a(FloatBuffer paramFloatBuffer)
  {
    if (paramFloatBuffer.limit() <= 0) {
      return null;
    }
    float[] arrayOfFloat = new float[paramFloatBuffer.limit()];
    int i1 = 0;
    while (i1 < paramFloatBuffer.limit())
    {
      arrayOfFloat[i1] = paramFloatBuffer.get(i1);
      i1 += 1;
    }
    return arrayOfFloat;
  }
  
  public int a(int paramInt)
  {
    return b(paramInt, this.h, this.i);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.g) {
      return -1;
    }
    GLES20.glBindFramebuffer(36160, paramInt2);
    a(paramInt1, this.h, this.i);
    j.a locala = this.l;
    if ((locala instanceof j.a)) {
      locala.a(paramInt3);
    }
    GLES20.glBindFramebuffer(36160, 0);
    return paramInt3;
  }
  
  public void a(int paramInt, float paramFloat)
  {
    a(new j.2(this, paramInt, paramFloat));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.f == paramInt2) && (this.e == paramInt1)) {
      return;
    }
    this.e = paramInt1;
    this.f = paramInt2;
    if (this.o)
    {
      if (this.m != -1) {
        f();
      }
      int[] arrayOfInt = new int[1];
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
      this.m = arrayOfInt[0];
      this.n = TXCOpenGlUtils.a(paramInt1, paramInt2, 6408, 6408);
      GLES20.glBindFramebuffer(36160, this.m);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.n, 0);
      GLES20.glBindFramebuffer(36160, 0);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramArrayOfFloat == null) {
      paramArrayOfFloat = m.a(l.a, false, true);
    }
    float f2 = paramInt1;
    float f1 = paramInt2;
    float f3 = f2 / f1;
    int i1;
    if (f3 > paramFloat)
    {
      i1 = (int)(f1 * paramFloat);
    }
    else
    {
      i1 = paramInt1;
      if (f3 < paramFloat)
      {
        paramInt2 = (int)(f2 / paramFloat);
        i1 = paramInt1;
      }
    }
    paramFloat = i1 / f2;
    f1 = paramInt2 / f1;
    paramFloat = (1.0F - paramFloat) / 2.0F;
    f1 = (1.0F - f1) / 2.0F;
    paramInt1 = 0;
    while (paramInt1 < paramArrayOfFloat.length / 2)
    {
      paramInt2 = paramInt1 * 2;
      if (paramArrayOfFloat[paramInt2] < 0.5F) {
        paramArrayOfFloat[paramInt2] += paramFloat;
      } else {
        paramArrayOfFloat[paramInt2] -= paramFloat;
      }
      paramInt2 += 1;
      if (paramArrayOfFloat[paramInt2] < 0.5F) {
        paramArrayOfFloat[paramInt2] += f1;
      } else {
        paramArrayOfFloat[paramInt2] -= f1;
      }
      paramInt1 += 1;
    }
    paramInt2 = paramInt3 / 90;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      paramFloat = paramArrayOfFloat[0];
      f1 = paramArrayOfFloat[1];
      paramArrayOfFloat[0] = paramArrayOfFloat[2];
      paramArrayOfFloat[1] = paramArrayOfFloat[3];
      paramArrayOfFloat[2] = paramArrayOfFloat[6];
      paramArrayOfFloat[3] = paramArrayOfFloat[7];
      paramArrayOfFloat[6] = paramArrayOfFloat[4];
      paramArrayOfFloat[7] = paramArrayOfFloat[5];
      paramArrayOfFloat[4] = paramFloat;
      paramArrayOfFloat[5] = f1;
      paramInt1 += 1;
    }
    if ((paramInt2 != 0) && (paramInt2 != 2))
    {
      if (paramBoolean2)
      {
        paramArrayOfFloat[0] = (1.0F - paramArrayOfFloat[0]);
        paramArrayOfFloat[2] = (1.0F - paramArrayOfFloat[2]);
        paramArrayOfFloat[4] = (1.0F - paramArrayOfFloat[4]);
        paramArrayOfFloat[6] = (1.0F - paramArrayOfFloat[6]);
      }
      if (paramBoolean1)
      {
        paramArrayOfFloat[1] = (1.0F - paramArrayOfFloat[1]);
        paramArrayOfFloat[3] = (1.0F - paramArrayOfFloat[3]);
        paramArrayOfFloat[5] = (1.0F - paramArrayOfFloat[5]);
        paramArrayOfFloat[7] = (1.0F - paramArrayOfFloat[7]);
      }
    }
    else
    {
      if (paramBoolean1)
      {
        paramArrayOfFloat[0] = (1.0F - paramArrayOfFloat[0]);
        paramArrayOfFloat[2] = (1.0F - paramArrayOfFloat[2]);
        paramArrayOfFloat[4] = (1.0F - paramArrayOfFloat[4]);
        paramArrayOfFloat[6] = (1.0F - paramArrayOfFloat[6]);
      }
      if (paramBoolean2)
      {
        paramArrayOfFloat[1] = (1.0F - paramArrayOfFloat[1]);
        paramArrayOfFloat[3] = (1.0F - paramArrayOfFloat[3]);
        paramArrayOfFloat[5] = (1.0F - paramArrayOfFloat[5]);
        paramArrayOfFloat[7] = (1.0F - paramArrayOfFloat[7]);
      }
    }
    a((float[])m.e.clone(), paramArrayOfFloat);
  }
  
  public void a(int paramInt, FloatBuffer paramFloatBuffer)
  {
    if (paramFloatBuffer == null) {
      paramFloatBuffer = m.a(l.a, false, true);
    } else {
      paramFloatBuffer = a(paramFloatBuffer);
    }
    int i1 = paramInt / 90;
    paramInt = 0;
    while (paramInt < i1)
    {
      float f1 = paramFloatBuffer[0];
      float f2 = paramFloatBuffer[1];
      paramFloatBuffer[0] = paramFloatBuffer[2];
      paramFloatBuffer[1] = paramFloatBuffer[3];
      paramFloatBuffer[2] = paramFloatBuffer[6];
      paramFloatBuffer[3] = paramFloatBuffer[7];
      paramFloatBuffer[6] = paramFloatBuffer[4];
      paramFloatBuffer[7] = paramFloatBuffer[5];
      paramFloatBuffer[4] = f1;
      paramFloatBuffer[5] = f2;
      paramInt += 1;
    }
    a((float[])m.e.clone(), paramFloatBuffer);
  }
  
  public void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    GLES20.glUseProgram(this.a);
    k();
    if (!this.g) {
      return;
    }
    paramFloatBuffer1.position(0);
    GLES20.glVertexAttribPointer(this.b, 2, 5126, false, 0, paramFloatBuffer1);
    GLES20.glEnableVertexAttribArray(this.b);
    paramFloatBuffer2.position(0);
    GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 0, paramFloatBuffer2);
    GLES20.glEnableVertexAttribArray(this.d);
    int i1 = this.v;
    if (i1 >= 0)
    {
      paramFloatBuffer1 = this.w;
      if (paramFloatBuffer1 != null) {
        GLES20.glUniformMatrix4fv(i1, 1, false, paramFloatBuffer1, 0);
      }
    }
    if (paramInt != -1)
    {
      GLES20.glActiveTexture(33984);
      if (true == this.q) {
        GLES20.glBindTexture(36197, paramInt);
      } else {
        GLES20.glBindTexture(3553, paramInt);
      }
      GLES20.glUniform1i(this.c, 0);
    }
    i();
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.b);
    GLES20.glDisableVertexAttribArray(this.d);
    j();
    if (true == this.q)
    {
      GLES20.glBindTexture(36197, 0);
      return;
    }
    GLES20.glBindTexture(3553, 0);
  }
  
  public void a(int paramInt, float[] paramArrayOfFloat)
  {
    a(new j.3(this, paramInt, paramArrayOfFloat));
  }
  
  public void a(j.a parama)
  {
    boolean bool;
    if (parama != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.u = bool;
    this.l = parama;
  }
  
  public void a(Runnable paramRunnable)
  {
    synchronized (this.r)
    {
      this.r.addLast(paramRunnable);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    this.w = paramArrayOfFloat;
  }
  
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.j = paramArrayOfFloat1;
    this.h = ByteBuffer.allocateDirect(m.e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.h.put(paramArrayOfFloat1).position(0);
    this.k = paramArrayOfFloat2;
    this.i = ByteBuffer.allocateDirect(m.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.i.put(paramArrayOfFloat2).position(0);
  }
  
  public boolean a()
  {
    this.a = TXCOpenGlUtils.a(this.s, this.t);
    if ((this.a != 0) && (b())) {
      this.g = true;
    } else {
      this.g = false;
    }
    c();
    return this.g;
  }
  
  public float[] a(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer, a parama, int paramInt3)
  {
    int i1 = 0;
    if (paramFloatBuffer == null)
    {
      if (4 == paramInt3) {
        paramFloatBuffer = m.a(l.a, false, false);
      } else {
        paramFloatBuffer = m.a(l.a, false, true);
      }
    }
    else {
      paramFloatBuffer = a(paramFloatBuffer);
    }
    if (parama != null)
    {
      float f1 = parama.a;
      float f2 = paramInt1 * 1.0F;
      f1 /= f2;
      f2 = (paramInt1 - parama.a - parama.c) / f2;
      float f4 = parama.b;
      float f3 = paramInt2 * 1.0F;
      f4 /= f3;
      f3 = (paramInt2 - parama.b - parama.d) / f3;
      paramInt1 = i1;
      while (paramInt1 < paramFloatBuffer.length / 2)
      {
        paramInt2 = paramInt1 * 2;
        if (paramFloatBuffer[paramInt2] < 0.5F) {
          paramFloatBuffer[paramInt2] += f1;
        } else {
          paramFloatBuffer[paramInt2] -= f2;
        }
        paramInt2 += 1;
        if (paramFloatBuffer[paramInt2] < 0.5F) {
          paramFloatBuffer[paramInt2] += f4;
        } else {
          paramFloatBuffer[paramInt2] -= f3;
        }
        paramInt1 += 1;
      }
    }
    return paramFloatBuffer;
  }
  
  public int b(int paramInt)
  {
    return a(paramInt, this.m, this.n);
  }
  
  public int b(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    if (!this.g) {
      return -1;
    }
    a(paramInt, paramFloatBuffer1, paramFloatBuffer2);
    paramFloatBuffer1 = this.l;
    if ((paramFloatBuffer1 instanceof j.a)) {
      paramFloatBuffer1.a(paramInt);
    }
    return 1;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(new j.1(this, paramInt1, paramInt2));
  }
  
  public void b(int paramInt, float[] paramArrayOfFloat)
  {
    a(new j.4(this, paramInt, paramArrayOfFloat));
  }
  
  public void b(boolean paramBoolean)
  {
    this.p = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set Nearest model ");
    localStringBuilder.append(paramBoolean);
    TXCLog.i("TXCGPUFilter", localStringBuilder.toString());
  }
  
  public boolean b()
  {
    this.b = GLES20.glGetAttribLocation(this.a, "position");
    this.c = GLES20.glGetUniformLocation(this.a, "inputImageTexture");
    this.v = GLES20.glGetUniformLocation(this.a, "textureTransform");
    this.d = GLES20.glGetAttribLocation(this.a, "inputTextureCoordinate");
    return true;
  }
  
  public void c() {}
  
  public void c(int paramInt, float[] paramArrayOfFloat)
  {
    a(new j.5(this, paramInt, paramArrayOfFloat));
  }
  
  public void d()
  {
    GLES20.glDeleteProgram(this.a);
    e();
    this.g = false;
  }
  
  public void e()
  {
    f();
    this.f = -1;
    this.e = -1;
  }
  
  public void f()
  {
    int i1 = this.m;
    if (i1 != -1)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { i1 }, 0);
      this.m = -1;
    }
    i1 = this.n;
    if (i1 != -1)
    {
      GLES20.glDeleteTextures(1, new int[] { i1 }, 0);
      this.n = -1;
    }
  }
  
  public void g()
  {
    if (this.k != null)
    {
      int i1 = 0;
      while (i1 < 8)
      {
        float[] arrayOfFloat = this.k;
        arrayOfFloat[i1] = (1.0F - arrayOfFloat[i1]);
        i1 += 2;
      }
      a(this.j, this.k);
    }
  }
  
  public void h()
  {
    if (this.k != null)
    {
      int i1 = 1;
      while (i1 < 8)
      {
        float[] arrayOfFloat = this.k;
        arrayOfFloat[i1] = (1.0F - arrayOfFloat[i1]);
        i1 += 2;
      }
      a(this.j, this.k);
    }
  }
  
  protected void i() {}
  
  protected void j() {}
  
  protected void k()
  {
    while (!this.r.isEmpty()) {
      ((Runnable)this.r.removeFirst()).run();
    }
  }
  
  public int l()
  {
    return this.n;
  }
  
  public int m()
  {
    return this.m;
  }
  
  public boolean n()
  {
    return this.g;
  }
  
  public int o()
  {
    return this.e;
  }
  
  public int p()
  {
    return this.f;
  }
  
  public int q()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.j
 * JD-Core Version:    0.7.0.1
 */