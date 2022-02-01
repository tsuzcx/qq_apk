package com.tencent.liteav.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class h
{
  public static int a = 1;
  public static int b = 2;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = b;
  private int h = 0;
  private boolean i = false;
  private float[] j = new float[16];
  private float[] k = new float[16];
  private float l = 1.0F;
  private float m = 1.0F;
  private boolean n = false;
  private boolean o = true;
  private final float[] p = { -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  private FloatBuffer q;
  private float[] r = new float[16];
  private float[] s = new float[16];
  private int t;
  private int u = -12345;
  private int v = -12345;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public h(Boolean paramBoolean)
  {
    this.o = paramBoolean.booleanValue();
    this.q = ByteBuffer.allocateDirect(this.p.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.q.put(this.p).position(0);
    Matrix.setIdentityM(this.s, 0);
  }
  
  private int a(int paramInt, String paramString)
  {
    int i2 = GLES20.glCreateShader(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("glCreateShader type=");
    localStringBuilder.append(paramInt);
    a(localStringBuilder.toString());
    GLES20.glShaderSource(i2, paramString);
    GLES20.glCompileShader(i2);
    paramString = new int[1];
    GLES20.glGetShaderiv(i2, 35713, paramString, 0);
    int i1 = i2;
    if (paramString[0] == 0)
    {
      paramString = new StringBuilder();
      paramString.append("Could not compile shader ");
      paramString.append(paramInt);
      paramString.append(":");
      TXCLog.e("TXTweenFilter", paramString.toString());
      paramString = new StringBuilder();
      paramString.append(" ");
      paramString.append(GLES20.glGetShaderInfoLog(i2));
      TXCLog.e("TXTweenFilter", paramString.toString());
      GLES20.glDeleteShader(i2);
      i1 = 0;
    }
    return i1;
  }
  
  private int a(String paramString1, String paramString2)
  {
    int i1 = a(35633, paramString1);
    if (i1 == 0) {
      return 0;
    }
    int i2 = a(35632, paramString2);
    if (i2 == 0) {
      return 0;
    }
    int i3 = GLES20.glCreateProgram();
    a("glCreateProgram");
    if (i3 == 0) {
      TXCLog.e("TXTweenFilter", "Could not create program");
    }
    GLES20.glAttachShader(i3, i1);
    a("glAttachShader");
    GLES20.glAttachShader(i3, i2);
    a("glAttachShader");
    GLES20.glLinkProgram(i3);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(i3, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      TXCLog.e("TXTweenFilter", "Could not link program: ");
      TXCLog.e("TXTweenFilter", GLES20.glGetProgramInfoLog(i3));
      GLES20.glDeleteProgram(i3);
      return 0;
    }
    return i3;
  }
  
  private void a(String paramString)
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
      localStringBuilder.append(i1);
      TXCLog.e("TXTweenFilter", localStringBuilder.toString());
    }
  }
  
  private void b(float[] paramArrayOfFloat)
  {
    if (this.d != 0)
    {
      if (this.c == 0) {
        return;
      }
      int i2 = this.e;
      int i1 = this.f;
      int i3 = this.h;
      if ((i3 == 270) || (i3 == 90))
      {
        i2 = this.f;
        i1 = this.e;
      }
      float f1 = this.c;
      float f4 = i2;
      float f2 = f1 * 1.0F / f4;
      i2 = this.d;
      f1 = i2;
      float f5 = i1;
      float f3 = f1 * 1.0F / f5;
      if (this.g == a)
      {
        if (f2 * f5 > i2)
        {
          f1 = f2;
          break label143;
        }
      }
      else
      {
        f1 = f2;
        if (f2 * f5 <= i2) {
          break label143;
        }
      }
      f1 = f3;
      label143:
      Matrix.setIdentityM(this.k, 0);
      if (this.i) {
        if (this.h % 180 == 0) {
          Matrix.scaleM(this.k, 0, -1.0F, 1.0F, 1.0F);
        } else {
          Matrix.scaleM(this.k, 0, 1.0F, -1.0F, 1.0F);
        }
      }
      Matrix.scaleM(this.k, 0, f4 * f1 / this.c * 1.0F, f5 * f1 / this.d * 1.0F, 1.0F);
      Matrix.rotateM(this.k, 0, this.h, 0.0F, 0.0F, -1.0F);
      Matrix.multiplyMM(paramArrayOfFloat, 0, this.j, 0, this.k, 0);
    }
  }
  
  private void d()
  {
    if (!this.n) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reloadFrameBuffer. size = ");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("*");
    ((StringBuilder)localObject).append(this.d);
    TXCLog.i("TXTweenFilter", ((StringBuilder)localObject).toString());
    e();
    localObject = new int[1];
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, (int[])localObject, 0);
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    this.u = localObject[0];
    this.v = arrayOfInt[0];
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("frameBuffer id = ");
    ((StringBuilder)localObject).append(this.v);
    ((StringBuilder)localObject).append(", texture id = ");
    ((StringBuilder)localObject).append(this.u);
    TXCLog.d("TXTweenFilter", ((StringBuilder)localObject).toString());
    GLES20.glBindTexture(3553, this.u);
    a("glBindTexture mFrameBufferTextureID");
    GLES20.glTexImage2D(3553, 0, 6408, this.c, this.d, 0, 6408, 5121, null);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    a("glTexParameter");
    GLES20.glBindFramebuffer(36160, this.v);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.u, 0);
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindFramebuffer(36160, 0);
    this.n = false;
  }
  
  private void e()
  {
    int i1 = this.v;
    if (i1 != -12345)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { i1 }, 0);
      this.v = -12345;
    }
    i1 = this.u;
    if (i1 != -12345)
    {
      GLES20.glDeleteTextures(1, new int[] { i1 }, 0);
      this.u = -12345;
    }
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.c) && (paramInt2 == this.d)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Output resolution change: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("*");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" -> ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("*");
    localStringBuilder.append(paramInt2);
    TXCLog.i("TXTweenFilter", localStringBuilder.toString());
    this.c = paramInt1;
    this.d = paramInt2;
    if (paramInt1 > paramInt2)
    {
      Matrix.orthoM(this.j, 0, -1.0F, 1.0F, -1.0F, 1.0F, -1.0F, 1.0F);
      this.l = 1.0F;
      this.m = 1.0F;
    }
    else
    {
      Matrix.orthoM(this.j, 0, -1.0F, 1.0F, -1.0F, 1.0F, -1.0F, 1.0F);
      this.l = 1.0F;
      this.m = 1.0F;
    }
    this.n = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    this.s = paramArrayOfFloat;
  }
  
  public boolean a()
  {
    return this.o;
  }
  
  public void b()
  {
    if (this.o) {
      this.t = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
    } else {
      this.t = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "varying highp vec2 vTextureCoord;\n \nuniform sampler2D sTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(sTexture, vTextureCoord);\n}");
    }
    int i1 = this.t;
    if (i1 == 0)
    {
      TXCLog.e("TXTweenFilter", "failed creating program");
      return;
    }
    this.y = GLES20.glGetAttribLocation(i1, "aPosition");
    a("glGetAttribLocation aPosition");
    if (this.y == -1)
    {
      TXCLog.e("TXTweenFilter", "Could not get attrib location for aPosition");
      return;
    }
    this.z = GLES20.glGetAttribLocation(this.t, "aTextureCoord");
    a("glGetAttribLocation aTextureCoord");
    if (this.z == -1)
    {
      TXCLog.e("TXTweenFilter", "Could not get attrib location for aTextureCoord");
      return;
    }
    this.w = GLES20.glGetUniformLocation(this.t, "uMVPMatrix");
    a("glGetUniformLocation uMVPMatrix");
    if (this.w == -1)
    {
      TXCLog.e("TXTweenFilter", "Could not get attrib location for uMVPMatrix");
      return;
    }
    this.x = GLES20.glGetUniformLocation(this.t, "uSTMatrix");
    a("glGetUniformLocation uSTMatrix");
    if (this.x == -1) {
      TXCLog.e("TXTweenFilter", "Could not get attrib location for uSTMatrix");
    }
  }
  
  public void b(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.e) && (paramInt2 == this.f)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Input resolution change: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("*");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" -> ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("*");
    localStringBuilder.append(paramInt2);
    TXCLog.i("TXTweenFilter", localStringBuilder.toString());
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public void c()
  {
    GLES20.glDeleteProgram(this.t);
    e();
  }
  
  public void c(int paramInt)
  {
    GLES20.glViewport(0, 0, this.c, this.d);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    GLES20.glUseProgram(this.t);
    a("glUseProgram");
    if (this.o)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(36197, paramInt);
    }
    else
    {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt);
    }
    this.q.position(0);
    GLES20.glVertexAttribPointer(this.y, 3, 5126, false, 20, this.q);
    a("glVertexAttribPointer maPosition");
    GLES20.glEnableVertexAttribArray(this.y);
    a("glEnableVertexAttribArray maPositionHandle");
    this.q.position(3);
    GLES20.glVertexAttribPointer(this.z, 2, 5126, false, 20, this.q);
    a("glVertexAttribPointer maTextureHandle");
    GLES20.glEnableVertexAttribArray(this.z);
    a("glEnableVertexAttribArray maTextureHandle");
    Matrix.setIdentityM(this.r, 0);
    b(this.r);
    GLES20.glUniformMatrix4fv(this.w, 1, false, this.r, 0);
    GLES20.glUniformMatrix4fv(this.x, 1, false, this.s, 0);
    a("glDrawArrays");
    GLES20.glDrawArrays(5, 0, 4);
    a("glDrawArrays");
    if (this.o)
    {
      GLES20.glBindTexture(36197, 0);
      return;
    }
    GLES20.glBindTexture(3553, 0);
  }
  
  public int d(int paramInt)
  {
    d();
    int i1 = this.v;
    if (i1 == -12345)
    {
      TXCLog.d("TXTweenFilter", "invalid frame buffer id");
      return paramInt;
    }
    GLES20.glBindFramebuffer(36160, i1);
    c(paramInt);
    GLES20.glBindFramebuffer(36160, 0);
    return this.u;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.h
 * JD-Core Version:    0.7.0.1
 */