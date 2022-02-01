package com.tencent.biz.pubaccount.readinjoyAd.ad.video.alphaplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class AlphaTextureRenderer
  extends TextureSurfaceRenderer
  implements SurfaceTexture.OnFrameAvailableListener
{
  private static float[] d = { -1.0F, 1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F };
  private static short[] e = { 0, 1, 2, 0, 2, 3 };
  private Context f;
  private FloatBuffer g;
  private float[] h = { 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.666F, 0.0F, 0.0F, 1.0F, 0.666F, 1.0F, 0.0F, 1.0F };
  private float[] i = { 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.333F, 0.0F, 1.0F, 1.0F, 0.333F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  private int[] j = new int[1];
  private int k;
  private FloatBuffer l;
  private ShortBuffer m;
  private SurfaceTexture n;
  private float[] o;
  private boolean p = false;
  private int q;
  private int r;
  private boolean s;
  private boolean t;
  
  public AlphaTextureRenderer(Context paramContext, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramSurfaceTexture, paramInt1, paramInt2);
    this.f = paramContext;
    this.o = new float[16];
    this.s = paramBoolean1;
    this.t = paramBoolean2;
  }
  
  private void a(Context paramContext)
  {
    if (this.s) {
      paramContext = this.h;
    } else {
      paramContext = this.i;
    }
    paramContext = ByteBuffer.allocateDirect(paramContext.length * 4);
    paramContext.order(ByteOrder.nativeOrder());
    this.g = paramContext.asFloatBuffer();
    FloatBuffer localFloatBuffer = this.g;
    if (this.s) {
      paramContext = this.h;
    } else {
      paramContext = this.i;
    }
    localFloatBuffer.put(paramContext);
    this.g.position(0);
    GLES20.glActiveTexture(33984);
    GLES20.glGenTextures(1, this.j, 0);
    a("Texture generate");
    GLES20.glBindTexture(36197, this.j[0]);
    a("Texture bind");
    this.n = new SurfaceTexture(this.j[0]);
    this.n.setOnFrameAvailableListener(this);
  }
  
  private void g()
  {
    Context localContext = this.f;
    int i1;
    if (this.s) {
      i1 = 2114125825;
    } else {
      i1 = 2114125826;
    }
    this.k = OpenGLUtils.a(OpenGLUtils.a(localContext, i1), OpenGLUtils.a(this.f, 2114125824));
  }
  
  private void h()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(e.length * 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.m = localByteBuffer.asShortBuffer();
    this.m.put(e);
    this.m.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(d.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.l = localByteBuffer.asFloatBuffer();
    this.l.put(d);
    this.l.position(0);
  }
  
  private void i()
  {
    int i1 = this.q / 3;
    float f1 = this.c / this.b;
    float f2 = this.r;
    float f3 = i1 * 2;
    if (f1 > f2 / f3)
    {
      f1 = this.b / f3;
      i1 = (int)(this.r * f1);
      i2 = -((i1 - this.c) / 2);
      GLES20.glViewport(0, i2, this.b, i1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("adjustViewport - glViewport(0, ");
      localStringBuilder.append(i2);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", ");
      localStringBuilder.append(i1);
      localStringBuilder.append(")");
      Log.i("AlphaTextureRenderer", localStringBuilder.toString());
      return;
    }
    i1 = (int)(f3 * (this.c / this.r));
    int i2 = -((i1 - this.b) / 2);
    GLES20.glViewport(i2, 0, i1, this.c);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("adjustViewport - glViewport(, ");
    localStringBuilder.append(i2);
    localStringBuilder.append(", 0, ");
    localStringBuilder.append(i1);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    Log.i("AlphaTextureRenderer", localStringBuilder.toString());
  }
  
  private void j()
  {
    int i1 = this.q / 3;
    float f1 = this.c / this.b;
    float f2 = this.r;
    float f3 = i1 * 2;
    if (f1 > f2 / f3)
    {
      i1 = (int)(f3 * (this.c / this.r));
      GLES20.glViewport(-((i1 - this.b) / 2), 0, i1, this.c);
      return;
    }
    f1 = this.b / f3;
    i1 = (int)(this.r * f1);
    GLES20.glViewport(0, -((i1 - this.c) / 2), this.b, i1);
  }
  
  private void k()
  {
    int i1 = this.r / 3;
    float f1 = this.c / this.b;
    float f2 = i1 * 2;
    if (f1 > f2 / this.q)
    {
      i1 = (int)(f2 * (this.b / this.q));
      i2 = -((i1 - this.c) / 2);
      GLES20.glViewport(0, i2, this.b, i1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("adjustViewport - glViewport(0, ");
      localStringBuilder.append(i2);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", ");
      localStringBuilder.append(i1);
      localStringBuilder.append(")");
      Log.i("AlphaTextureRenderer", localStringBuilder.toString());
      return;
    }
    f1 = this.c / f2;
    i1 = (int)(this.q * f1);
    int i2 = -((i1 - this.b) / 2);
    GLES20.glViewport(i2, 0, i1, this.c);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("adjustViewport - glViewport(, ");
    localStringBuilder.append(i2);
    localStringBuilder.append(", 0, ");
    localStringBuilder.append(i1);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    Log.i("AlphaTextureRenderer", localStringBuilder.toString());
  }
  
  private void l()
  {
    int i1 = this.q / 3;
    float f1 = this.c / this.b;
    float f2 = this.r;
    float f3 = i1 * 2;
    if (f1 > f2 / f3)
    {
      i1 = (int)(f3 * (this.c / this.r));
      GLES20.glViewport(-((i1 - this.b) / 2), 0, i1, this.c);
      return;
    }
    f1 = this.b / f3;
    i1 = (int)(this.r * f1);
    GLES20.glViewport(0, -((i1 - this.c) / 2), this.b, i1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.q = paramInt1;
    this.r = paramInt2;
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      int i1 = GLES20.glGetError();
      if (i1 == 0) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": glError ");
      localStringBuilder.append(GLUtils.getEGLErrorString(i1));
      Log.e("AlphaTextureRenderer", localStringBuilder.toString());
    }
  }
  
  protected boolean a()
  {
    try
    {
      boolean bool = this.p;
      if (bool) {
        try
        {
          this.n.updateTexImage();
          this.n.getTransformMatrix(this.o);
          this.p = false;
          if (this.s)
          {
            if (this.t) {
              j();
            } else {
              i();
            }
          }
          else if (this.t) {
            l();
          } else {
            k();
          }
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          GLES20.glClear(16384);
          GLES20.glUseProgram(this.k);
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(770, 771);
          int i1 = GLES20.glGetUniformLocation(this.k, "texture");
          int i2 = GLES20.glGetAttribLocation(this.k, "vTexCoordinate");
          int i3 = GLES20.glGetAttribLocation(this.k, "vPosition");
          int i4 = GLES20.glGetUniformLocation(this.k, "textureTransform");
          GLES20.glEnableVertexAttribArray(i3);
          GLES20.glVertexAttribPointer(i3, 3, 5126, false, 0, this.l);
          GLES20.glBindTexture(36197, this.j[0]);
          GLES20.glActiveTexture(33984);
          GLES20.glUniform1i(i1, 0);
          GLES20.glEnableVertexAttribArray(i2);
          GLES20.glVertexAttribPointer(i2, 4, 5126, false, 0, this.g);
          GLES20.glUniformMatrix4fv(i4, 1, false, this.o, 0);
          GLES20.glDrawElements(4, e.length, 5123, this.m);
          GLES20.glDisableVertexAttribArray(i3);
          GLES20.glDisableVertexAttribArray(i2);
          GLES20.glDisable(3042);
          return true;
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("draw:thread id =");
          localStringBuilder.append(Thread.currentThread().getId());
          Log.e("AlphaTextureRenderer", localStringBuilder.toString(), localException);
          return false;
        }
      }
      return false;
    }
    finally {}
  }
  
  protected void b()
  {
    h();
    a(this.f);
    g();
    Log.d("AlphaTextureRenderer", "initGLComponents");
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  protected void c()
  {
    GLES20.glDeleteTextures(1, this.j, 0);
    GLES20.glDeleteProgram(this.k);
    this.n.release();
    this.n.setOnFrameAvailableListener(null);
    Log.d("AlphaTextureRenderer", "deinitGLComponents");
  }
  
  public SurfaceTexture d()
  {
    return this.n;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.p = true;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.alphaplayer.AlphaTextureRenderer
 * JD-Core Version:    0.7.0.1
 */