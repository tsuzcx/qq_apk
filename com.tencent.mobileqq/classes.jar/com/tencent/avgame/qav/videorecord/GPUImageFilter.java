package com.tencent.avgame.qav.videorecord;

import android.opengl.GLES20;
import com.tencent.qav.log.AVLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.LinkedList;

public class GPUImageFilter
{
  public static final float[] a = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  public static final float[] b = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  protected FloatBuffer c;
  protected FloatBuffer d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  private final String k;
  private final String l;
  private boolean m;
  private final LinkedList<Runnable> n = new LinkedList();
  
  public GPUImageFilter()
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "precision mediump float;\nvarying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
  }
  
  public GPUImageFilter(String paramString1, String paramString2)
  {
    this.k = paramString1;
    this.l = paramString2;
    this.c = ByteBuffer.allocateDirect(a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.c.put(a);
    this.d = ByteBuffer.allocateDirect(b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.d.put(b).position(0);
  }
  
  public static int k()
  {
    int i1 = GLES20.glGetError();
    if (i1 != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error:");
      localStringBuilder.append(i1);
      AVLog.a("GPUImageFilter", localStringBuilder.toString());
    }
    return i1;
  }
  
  public final void a()
  {
    b();
    this.m = true;
    c();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    this.j = paramInt2;
  }
  
  public void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    if (!f()) {
      a();
    }
    GLES20.glUseProgram(this.e);
    if (!this.m) {
      return;
    }
    j();
    paramFloatBuffer1.position(0);
    GLES20.glVertexAttribPointer(this.f, 2, 5126, false, 0, paramFloatBuffer1);
    GLES20.glEnableVertexAttribArray(this.f);
    paramFloatBuffer2.position(0);
    GLES20.glVertexAttribPointer(this.h, 2, 5126, false, 0, paramFloatBuffer2);
    GLES20.glEnableVertexAttribArray(this.h);
    if (paramInt != -1)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt);
      GLES20.glUniform1i(this.g, 0);
    }
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.f);
    GLES20.glDisableVertexAttribArray(this.h);
    GLES20.glBindTexture(3553, 0);
    k();
  }
  
  protected void a(Runnable paramRunnable)
  {
    synchronized (this.n)
    {
      this.n.addLast(paramRunnable);
      return;
    }
  }
  
  public void b()
  {
    this.e = OpenGlUtils.a(this.k, this.l);
    this.f = GLES20.glGetAttribLocation(this.e, "position");
    this.g = GLES20.glGetUniformLocation(this.e, "inputImageTexture");
    this.h = GLES20.glGetAttribLocation(this.e, "inputTextureCoordinate");
    this.m = true;
  }
  
  public void c() {}
  
  public final void d()
  {
    this.m = false;
    GLES20.glDeleteProgram(this.e);
    this.n.clear();
    e();
  }
  
  public void e() {}
  
  public boolean f()
  {
    return this.m;
  }
  
  public int g()
  {
    return this.i;
  }
  
  public int h()
  {
    return this.j;
  }
  
  protected void i()
  {
    synchronized (this.n)
    {
      this.n.clear();
      return;
    }
  }
  
  protected void j()
  {
    while (!this.n.isEmpty()) {
      ((Runnable)this.n.removeFirst()).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.videorecord.GPUImageFilter
 * JD-Core Version:    0.7.0.1
 */