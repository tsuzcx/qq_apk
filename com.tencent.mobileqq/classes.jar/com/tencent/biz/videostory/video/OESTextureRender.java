package com.tencent.biz.videostory.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

class OESTextureRender
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
  private int[] k = new int[1];
  
  public OESTextureRender()
  {
    this.b.put(this.a).position(0);
    Matrix.setIdentityM(this.d, 0);
  }
  
  private int a(int paramInt, String paramString)
  {
    int n = GLES20.glCreateShader(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("glCreateShader type=");
    localStringBuilder.append(paramInt);
    a(localStringBuilder.toString());
    GLES20.glShaderSource(n, paramString);
    GLES20.glCompileShader(n);
    paramString = new int[1];
    GLES20.glGetShaderiv(n, 35713, paramString, 0);
    int m = n;
    if (paramString[0] == 0)
    {
      paramString = new StringBuilder();
      paramString.append("Could not compile shader ");
      paramString.append(paramInt);
      paramString.append(":");
      Log.e("OESTextureRender", paramString.toString());
      paramString = new StringBuilder();
      paramString.append(" ");
      paramString.append(GLES20.glGetShaderInfoLog(n));
      Log.e("OESTextureRender", paramString.toString());
      GLES20.glDeleteShader(n);
      m = 0;
    }
    return m;
  }
  
  private int a(String paramString1, String paramString2)
  {
    int m = a(35633, paramString1);
    if (m == 0) {
      return 0;
    }
    int n = a(35632, paramString2);
    if (n == 0) {
      return 0;
    }
    int i1 = GLES20.glCreateProgram();
    a("glCreateProgram");
    if (i1 == 0) {
      Log.e("OESTextureRender", "Could not create program");
    }
    GLES20.glAttachShader(i1, m);
    a("glAttachShader");
    GLES20.glAttachShader(i1, n);
    a("glAttachShader");
    GLES20.glLinkProgram(i1);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(i1, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      Log.e("OESTextureRender", "Could not link program: ");
      Log.e("OESTextureRender", GLES20.glGetProgramInfoLog(i1));
      GLES20.glDeleteProgram(i1);
      return 0;
    }
    return i1;
  }
  
  public int a()
  {
    return this.f;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, int paramInt)
  {
    a("onDrawFrame start");
    paramSurfaceTexture.getTransformMatrix(this.d);
    GLES20.glClearColor(0.0F, 1.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    GLES20.glBindFramebuffer(36160, this.k[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt, 0);
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
    GLES20.glFinish();
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      int m = GLES20.glGetError();
      if (m == 0) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": glError ");
      localStringBuilder.append(m);
      Log.e("OESTextureRender", localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.clear();
    if (!paramBoolean)
    {
      this.b.put(this.a).position(0);
      return;
    }
    FloatBuffer localFloatBuffer = this.b;
    float[] arrayOfFloat = this.a;
    localFloatBuffer.put(new float[] { -1.0F, -1.0F, 0.0F, 0.0F, 1.0F - arrayOfFloat[4], 1.0F, -1.0F, 0.0F, 1.0F, 1.0F - arrayOfFloat[9], -1.0F, 1.0F, 0.0F, 0.0F, 1.0F - arrayOfFloat[14], 1.0F, 1.0F, 0.0F, 1.0F, 1.0F - arrayOfFloat[19] }).position(0);
  }
  
  public void b()
  {
    this.e = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
    int m = this.e;
    if (m != 0)
    {
      this.i = GLES20.glGetAttribLocation(m, "aPosition");
      a("glGetAttribLocation aPosition");
      if (this.i != -1)
      {
        this.j = GLES20.glGetAttribLocation(this.e, "aTextureCoord");
        a("glGetAttribLocation aTextureCoord");
        if (this.j != -1)
        {
          this.g = GLES20.glGetUniformLocation(this.e, "uMVPMatrix");
          a("glGetUniformLocation uMVPMatrix");
          if (this.g != -1)
          {
            this.h = GLES20.glGetUniformLocation(this.e, "uSTMatrix");
            a("glGetUniformLocation uSTMatrix");
            if (this.h != -1)
            {
              int[] arrayOfInt = new int[1];
              GLES20.glGenTextures(1, arrayOfInt, 0);
              this.f = arrayOfInt[0];
              GLES20.glBindTexture(36197, this.f);
              a("glBindTexture mTextureID");
              GLES20.glTexParameterf(36197, 10241, 9729.0F);
              GLES20.glTexParameterf(36197, 10240, 9729.0F);
              GLES20.glTexParameteri(36197, 10242, 33071);
              GLES20.glTexParameteri(36197, 10243, 33071);
              a("glTexParameter");
              GLES20.glGenFramebuffers(1, this.k, 0);
              a("glGenFramebuffers");
              return;
            }
            throw new RuntimeException("Could not get attrib location for uSTMatrix");
          }
          throw new RuntimeException("Could not get attrib location for uMVPMatrix");
        }
        throw new RuntimeException("Could not get attrib location for aTextureCoord");
      }
      throw new RuntimeException("Could not get attrib location for aPosition");
    }
    throw new RuntimeException("failed creating program");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.video.OESTextureRender
 * JD-Core Version:    0.7.0.1
 */