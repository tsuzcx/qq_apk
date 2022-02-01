package com.tencent.mobileqq.ar.ARRecord.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.sveffects.SLog;
import java.nio.FloatBuffer;

public class GPUBaseFilter
{
  public static float[] a = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  public static final float[] b = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  private static final FloatBuffer e = GlUtil.createFloatBuffer(a);
  private static final FloatBuffer f = GlUtil.createFloatBuffer(b);
  public int c = 3553;
  protected int d = 101;
  private final String g;
  private final String h;
  private int i;
  private boolean j;
  
  public GPUBaseFilter()
  {
    this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n");
  }
  
  public GPUBaseFilter(String paramString1, String paramString2)
  {
    this.g = paramString1;
    this.h = paramString2;
    this.c = 3553;
    this.d = 101;
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (paramInt < 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to locate '");
      localStringBuilder.append(paramString);
      localStringBuilder.append("' in program");
      SLog.e("GPUBaseFilter", new RuntimeException(localStringBuilder.toString()));
    }
  }
  
  public static void a(String paramString)
  {
    for (;;)
    {
      int k = GLES20.glGetError();
      if (k == 0) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": glError ");
      localStringBuilder.append(k);
      SLog.e("GPUBaseFilter", new RuntimeException(localStringBuilder.toString()));
    }
  }
  
  public void a()
  {
    if (this.j) {
      return;
    }
    this.i = GlUtil.createProgram(this.g, this.h);
    if (this.i == 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed creating program ");
      localStringBuilder.append(getClass().getSimpleName());
      SLog.e("GPUBaseFilter", new RuntimeException(localStringBuilder.toString()));
    }
    this.j = true;
    b();
  }
  
  public void a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    a("onDrawFrame start");
    int i1 = c();
    float[] arrayOfFloat = paramArrayOfFloat1;
    if (paramArrayOfFloat1 == null)
    {
      arrayOfFloat = new float[16];
      Matrix.setIdentityM(arrayOfFloat, 0);
    }
    paramArrayOfFloat1 = paramArrayOfFloat2;
    if (paramArrayOfFloat2 == null)
    {
      paramArrayOfFloat1 = new float[16];
      Matrix.setIdentityM(paramArrayOfFloat1, 0);
    }
    GLES20.glUseProgram(i1);
    a("glUseProgram");
    int k = GLES20.glGetAttribLocation(i1, "aPosition");
    a(k, "aPosition");
    int m = GLES20.glGetAttribLocation(i1, "aTextureCoord");
    a(m, "aTextureCoord");
    int n = GLES20.glGetUniformLocation(i1, "uMVPMatrix");
    a(n, "uMVPMatrix");
    i1 = GLES20.glGetUniformLocation(i1, "uTextureMatrix");
    a(i1, "uTextureMatrix");
    GLES20.glVertexAttribPointer(k, 2, 5126, false, 8, e);
    a("glVertexAttribPointer aPosition");
    GLES20.glEnableVertexAttribArray(k);
    a("glEnableVertexAttribArray mPositionHandle");
    GLES20.glVertexAttribPointer(m, 2, 5126, false, 8, f);
    a("glVertexAttribPointer mTextureHandle");
    GLES20.glEnableVertexAttribArray(m);
    a("glEnableVertexAttribArray mTextureHandle");
    GLES20.glUniformMatrix4fv(n, 1, false, paramArrayOfFloat1, 0);
    GLES20.glUniformMatrix4fv(i1, 1, false, arrayOfFloat, 0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.c, paramInt);
    f();
    GLES20.glDrawArrays(5, 0, 4);
    a("glDrawArrays");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.c, 0);
  }
  
  protected void b() {}
  
  public int c()
  {
    return this.i;
  }
  
  public void d()
  {
    SLog.d("GPUBaseFilter", "destroy");
    this.j = false;
    GLES20.glDeleteProgram(this.i);
    this.i = 0;
    e();
  }
  
  protected void e() {}
  
  protected void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.renderer.GPUBaseFilter
 * JD-Core Version:    0.7.0.1
 */