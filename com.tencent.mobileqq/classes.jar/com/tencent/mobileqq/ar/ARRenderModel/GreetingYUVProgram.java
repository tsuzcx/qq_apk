package com.tencent.mobileqq.ar.ARRenderModel;

import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class GreetingYUVProgram
{
  private static float[] D = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  public static float[] b = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  public static float[] c = { -1.0F, 1.0F, 1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F };
  static float[] d = { -1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F };
  static float[] e = { 0.0F, -1.0F, 1.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  public static float[] f = { -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 0.0F, 0.0F };
  static float[] g = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  public static float[] h = { -1.0F, 1.0F, 1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F };
  private int A = -1;
  private int B = -1;
  private boolean C = false;
  public final int a;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private float[] p;
  private int q = -1;
  private int r = -1;
  private int s = -1;
  private int t = -1;
  private int u = -1;
  private int v = -1;
  private int w = -1;
  private int x = -1;
  private ByteBuffer y;
  private ByteBuffer z;
  
  public GreetingYUVProgram(int paramInt)
  {
    if (((paramInt < 0) || (paramInt > 4)) && (QLog.isColorLevel())) {
      QLog.i("GreetingYUVProgram", 1, "Index can only be 0 to 4");
    }
    this.a = paramInt;
    a(this.a);
  }
  
  private int a(int paramInt, String paramString)
  {
    int i1 = GLES20.glCreateShader(paramInt);
    paramInt = i1;
    if (i1 != 0)
    {
      GLES20.glShaderSource(i1, paramString);
      GLES20.glCompileShader(i1);
      paramString = new int[1];
      GLES20.glGetShaderiv(i1, 35713, paramString, 0);
      paramInt = i1;
      if (paramString[0] == 0)
      {
        GLES20.glDeleteShader(i1);
        paramInt = 0;
      }
    }
    return paramInt;
  }
  
  private void a(String paramString)
  {
    int i1 = GLES20.glGetError();
    if (i1 != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": glError 0x");
      localStringBuilder.append(Integer.toHexString(i1));
      QLog.i("GreetingYUVProgram", 1, localStringBuilder.toString());
    }
  }
  
  public int a(String paramString1, String paramString2)
  {
    int i3 = a(35633, paramString1);
    int i4 = a(35632, paramString2);
    int i2 = GLES20.glCreateProgram();
    int i1 = i2;
    if (i2 != 0)
    {
      GLES20.glAttachShader(i2, i3);
      a("glAttachShader");
      GLES20.glAttachShader(i2, i4);
      a("glAttachShader");
      GLES20.glLinkProgram(i2);
      paramString1 = new int[1];
      GLES20.glGetProgramiv(i2, 35714, paramString1, 0);
      i1 = i2;
      if (paramString1[0] != 1)
      {
        GLES20.glDeleteProgram(i2);
        i1 = 0;
      }
    }
    return i1;
  }
  
  public void a(int paramInt)
  {
    paramInt = this.a;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            this.p = b;
            this.j = 33984;
            this.k = 33985;
            this.l = 33986;
            this.m = 0;
            this.n = 1;
            this.o = 2;
            return;
          }
          this.p = g;
          this.j = 33993;
          this.k = 33994;
          this.l = 33995;
          this.m = 9;
          this.n = 10;
          this.o = 11;
          return;
        }
        this.p = f;
        this.j = 33990;
        this.k = 33991;
        this.l = 33992;
        this.m = 6;
        this.n = 7;
        this.o = 8;
        return;
      }
      this.p = e;
      this.j = 33987;
      this.k = 33988;
      this.l = 33989;
      this.m = 3;
      this.n = 4;
      this.o = 5;
      return;
    }
    this.p = d;
    this.j = 33984;
    this.k = 33985;
    this.l = 33986;
    this.m = 0;
    this.n = 1;
    this.o = 2;
  }
  
  public void a(Buffer paramBuffer1, Buffer paramBuffer2, Buffer paramBuffer3, int paramInt1, int paramInt2)
  {
    int i1;
    if ((paramInt1 == this.A) && (paramInt2 == this.B)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 != 0)
    {
      this.A = paramInt1;
      this.B = paramInt2;
    }
    if ((this.v < 0) || (i1 != 0))
    {
      paramInt1 = this.v;
      if (paramInt1 >= 0)
      {
        GLES20.glDeleteTextures(1, new int[] { paramInt1 }, 0);
        a("glDeleteTextures");
      }
      localObject = new int[1];
      GLES20.glGenTextures(1, (int[])localObject, 0);
      a("glGenTextures");
      this.v = localObject[0];
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("buildTextures : w=");
    ((StringBuilder)localObject).append(this.A);
    ((StringBuilder)localObject).append(" h=");
    ((StringBuilder)localObject).append(this.B);
    ((StringBuilder)localObject).append(" yData=");
    ((StringBuilder)localObject).append(paramBuffer1.capacity());
    QLog.d("AVGAmeRender", 1, ((StringBuilder)localObject).toString());
    GLES20.glBindTexture(3553, this.v);
    a("glBindTexture");
    GLES20.glTexImage2D(3553, 0, 6409, this.A, this.B, 0, 6409, 5121, paramBuffer1);
    a("glTexImage2D");
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    if ((this.w < 0) || (i1 != 0))
    {
      paramInt1 = this.w;
      if (paramInt1 >= 0)
      {
        GLES20.glDeleteTextures(1, new int[] { paramInt1 }, 0);
        a("glDeleteTextures");
      }
      paramBuffer1 = new int[1];
      GLES20.glGenTextures(1, paramBuffer1, 0);
      a("glGenTextures");
      this.w = paramBuffer1[0];
    }
    GLES20.glBindTexture(3553, this.w);
    GLES20.glTexImage2D(3553, 0, 6409, this.A / 2, this.B / 2, 0, 6409, 5121, paramBuffer2);
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    if ((this.x < 0) || (i1 != 0))
    {
      paramInt1 = this.x;
      if (paramInt1 >= 0)
      {
        GLES20.glDeleteTextures(1, new int[] { paramInt1 }, 0);
        a("glDeleteTextures");
      }
      paramBuffer1 = new int[1];
      GLES20.glGenTextures(1, paramBuffer1, 0);
      a("glGenTextures");
      this.x = paramBuffer1[0];
    }
    GLES20.glBindTexture(3553, this.x);
    GLES20.glTexImage2D(3553, 0, 6409, this.A / 2, this.B / 2, 0, 6409, 5121, paramBuffer3);
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    this.y = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    this.y.order(ByteOrder.nativeOrder());
    this.y.asFloatBuffer().put(paramArrayOfFloat);
    this.y.position(0);
    if (this.z == null)
    {
      this.z = ByteBuffer.allocateDirect(D.length * 4);
      this.z.order(ByteOrder.nativeOrder());
      this.z.asFloatBuffer().put(D);
      this.z.position(0);
    }
  }
  
  public boolean a()
  {
    return this.C;
  }
  
  public void b()
  {
    if (this.i <= 0) {
      this.i = a("attribute vec4 vPosition;\nattribute vec2 a_texCoord;\nvarying vec2 tc;\nvoid main() {\ngl_Position = vPosition;\ntc = a_texCoord;\n}\n", "precision mediump float;\nuniform sampler2D tex_y;\nuniform sampler2D tex_u;\nuniform sampler2D tex_v;\nvarying vec2 tc;\nvoid main() {\nvec4 c = vec4((texture2D(tex_y, tc).r - 16./255.) * 1.164);\nvec4 U = vec4(texture2D(tex_u, tc).r - 128./255.);\nvec4 V = vec4(texture2D(tex_v, tc).r - 128./255.);\nc += V * vec4(1.596, -0.813, 0, 0);\nc += U * vec4(0, -0.392, 2.017, 0);\nc.a = 1.0;\ngl_FragColor = c;\n}\n");
    }
    this.q = GLES20.glGetAttribLocation(this.i, "vPosition");
    a("glGetAttribLocation vPosition");
    if ((this.q == -1) && (QLog.isColorLevel())) {
      QLog.i("GreetingYUVProgram", 1, "Could not get attribute location for vPosition");
    }
    this.r = GLES20.glGetAttribLocation(this.i, "a_texCoord");
    a("glGetAttribLocation a_texCoord");
    if ((this.r == -1) && (QLog.isColorLevel())) {
      QLog.i("GreetingYUVProgram", 1, "Could not get attribute location for a_texCoord");
    }
    this.s = GLES20.glGetUniformLocation(this.i, "tex_y");
    a("glGetUniformLocation tex_y");
    if ((this.s == -1) && (QLog.isColorLevel())) {
      QLog.i("GreetingYUVProgram", 1, "Could not get uniform location for tex_y");
    }
    this.t = GLES20.glGetUniformLocation(this.i, "tex_u");
    a("glGetUniformLocation tex_u");
    if ((this.t == -1) && (QLog.isColorLevel())) {
      QLog.i("GreetingYUVProgram", 1, "Could not get uniform location for tex_u");
    }
    this.u = GLES20.glGetUniformLocation(this.i, "tex_v");
    a("glGetUniformLocation tex_v");
    if ((this.u == -1) && (QLog.isColorLevel())) {
      QLog.i("GreetingYUVProgram", 1, "Could not get uniform location for tex_v");
    }
    this.C = true;
  }
  
  public void c()
  {
    GLES20.glUseProgram(this.i);
    a("glUseProgram");
    GLES20.glVertexAttribPointer(this.q, 2, 5126, false, 8, this.y);
    a("glVertexAttribPointer mPositionHandle");
    GLES20.glEnableVertexAttribArray(this.q);
    GLES20.glVertexAttribPointer(this.r, 2, 5126, false, 8, this.z);
    a("glVertexAttribPointer maTextureHandle");
    GLES20.glEnableVertexAttribArray(this.r);
    GLES20.glActiveTexture(this.j);
    GLES20.glBindTexture(3553, this.v);
    GLES20.glUniform1i(this.s, this.m);
    GLES20.glActiveTexture(this.k);
    GLES20.glBindTexture(3553, this.w);
    GLES20.glUniform1i(this.t, this.n);
    GLES20.glActiveTexture(this.l);
    GLES20.glBindTexture(3553, this.x);
    GLES20.glUniform1i(this.u, this.o);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glFinish();
    GLES20.glDisableVertexAttribArray(this.q);
    GLES20.glDisableVertexAttribArray(this.r);
    GLES20.glUseProgram(0);
  }
  
  public void d()
  {
    int i1 = this.v;
    if (i1 != -1)
    {
      GLES20.glDeleteTextures(1, new int[] { i1 }, 0);
      a("glDeleteTextures");
      this.v = -1;
    }
    i1 = this.w;
    if (i1 != -1)
    {
      GLES20.glDeleteTextures(1, new int[] { i1 }, 0);
      a("glDeleteTextures");
      this.w = -1;
    }
    i1 = this.x;
    if (i1 != -1)
    {
      GLES20.glDeleteTextures(1, new int[] { i1 }, 0);
      a("glDeleteTextures");
      this.x = -1;
    }
    i1 = this.i;
    if (i1 > 0)
    {
      this.C = false;
      GLES20.glDeleteProgram(i1);
      a("glDeleteProgram");
      this.i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.GreetingYUVProgram
 * JD-Core Version:    0.7.0.1
 */