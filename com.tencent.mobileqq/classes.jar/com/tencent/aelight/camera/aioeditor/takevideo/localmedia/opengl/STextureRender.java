package com.tencent.aelight.camera.aioeditor.takevideo.localmedia.opengl;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

public class STextureRender
{
  private final float[] a = { -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  private FloatBuffer b = ByteBuffer.allocateDirect(this.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
  private float[] c = new float[16];
  private float[] d = new float[16];
  private int e;
  private int f = -12345;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public STextureRender()
  {
    this.b.put(this.a).position(0);
    Matrix.setIdentityM(this.d, 0);
  }
  
  private int a(String paramString1, String paramString2)
  {
    int k = b(35633, paramString1);
    if (k == 0) {
      return 0;
    }
    int m = b(35632, paramString2);
    if (m == 0) {
      return 0;
    }
    int n = GLES20.glCreateProgram();
    if (n == 0) {
      Log.e("STextureRender", "Could not create program");
    }
    GLES20.glAttachShader(n, k);
    a("glAttachShader");
    GLES20.glAttachShader(n, m);
    a("glAttachShader");
    GLES20.glLinkProgram(n);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(n, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      Log.e("STextureRender", "Could not link program: ");
      Log.e("STextureRender", GLES20.glGetProgramInfoLog(n));
      GLES20.glDeleteProgram(n);
      return 0;
    }
    return n;
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (paramInt >= 0) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unable to locate '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("' in program");
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  private int b(int paramInt, String paramString)
  {
    int m = GLES20.glCreateShader(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("glCreateShader type=");
    localStringBuilder.append(paramInt);
    a(localStringBuilder.toString());
    GLES20.glShaderSource(m, paramString);
    GLES20.glCompileShader(m);
    paramString = new int[1];
    GLES20.glGetShaderiv(m, 35713, paramString, 0);
    int k = m;
    if (paramString[0] == 0)
    {
      paramString = new StringBuilder();
      paramString.append("Could not compile shader ");
      paramString.append(paramInt);
      paramString.append(":");
      Log.e("STextureRender", paramString.toString());
      paramString = new StringBuilder();
      paramString.append(" ");
      paramString.append(GLES20.glGetShaderInfoLog(m));
      Log.e("STextureRender", paramString.toString());
      GLES20.glDeleteShader(m);
      k = 0;
    }
    return k;
  }
  
  public int a()
  {
    return this.f;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    a("onDrawFrame start");
    Log.e("STextureRender", Arrays.toString(this.d));
    Log.e("STextureRender", String.valueOf(paramBoolean));
    GLES20.glClearColor(0.0F, 1.0F, 0.0F, 1.0F);
    GLES20.glClear(16384);
    GLES20.glUseProgram(this.e);
    a("glUseProgram");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, this.f);
    this.b.position(0);
    GLES20.glVertexAttribPointer(this.i, 3, 5126, false, 20, this.b);
    a("glVertexAttribPointer maPosition");
    GLES20.glEnableVertexAttribArray(this.i);
    a("glEnableVertexAttribArray maPositionHandle");
    this.b.position(3);
    GLES20.glVertexAttribPointer(this.j, 2, 5126, false, 20, this.b);
    a("glVertexAttribPointer maTextureHandle");
    GLES20.glEnableVertexAttribArray(this.j);
    a("glEnableVertexAttribArray maTextureHandle");
    Matrix.setIdentityM(this.c, 0);
    GLES20.glUniformMatrix4fv(this.g, 1, false, this.c, 0);
    GLES20.glUniformMatrix4fv(this.h, 1, false, this.d, 0);
    GLES20.glDrawArrays(5, 0, 4);
    a("glDrawArrays");
    GLES20.glBindTexture(36197, 0);
  }
  
  public void a(String paramString)
  {
    int k = GLES20.glGetError();
    if (k == 0) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": glError ");
    localStringBuilder.append(k);
    Log.e("STextureRender", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": glError ");
    localStringBuilder.append(k);
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  public void b()
  {
    this.e = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
    int k = this.e;
    if (k != 0)
    {
      this.i = GLES20.glGetAttribLocation(k, "aPosition");
      a(this.i, "aPosition");
      this.j = GLES20.glGetAttribLocation(this.e, "aTextureCoord");
      a(this.j, "aTextureCoord");
      this.g = GLES20.glGetUniformLocation(this.e, "uMVPMatrix");
      a(this.g, "uMVPMatrix");
      this.h = GLES20.glGetUniformLocation(this.e, "uSTMatrix");
      a(this.h, "uSTMatrix");
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      this.f = arrayOfInt[0];
      GLES20.glBindTexture(36197, this.f);
      a("glBindTexture mTextureID");
      GLES20.glTexParameterf(36197, 10241, 9728.0F);
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
      GLES20.glTexParameteri(36197, 10242, 33071);
      GLES20.glTexParameteri(36197, 10243, 33071);
      a("glTexParameter");
      return;
    }
    throw new RuntimeException("failed creating program");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.localmedia.opengl.STextureRender
 * JD-Core Version:    0.7.0.1
 */