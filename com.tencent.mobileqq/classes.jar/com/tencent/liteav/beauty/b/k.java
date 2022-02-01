package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.c.j;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import java.nio.FloatBuffer;

public class k
  extends h
{
  private static String y = "YUV420pToRGBFilter";
  private byte[] r = null;
  private int s = 1;
  private int[] t = null;
  private int[] u = null;
  private int v = 0;
  private int w = 0;
  private int[] x = null;
  
  public k(int paramInt)
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    this.s = paramInt;
    String str = y;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("yuv Type ");
    localStringBuilder.append(paramInt);
    TXCLog.i(str, localStringBuilder.toString());
  }
  
  private int r()
  {
    GLES20.glBindTexture(3553, this.x[0]);
    if (this.r != null)
    {
      NativeLoad.getInstance();
      NativeLoad.nativeglTexImage2D(3553, 0, 6408, this.e, this.f, 0, 6408, 5121, this.r, 0);
    }
    return this.x[0];
  }
  
  private void s()
  {
    int[] arrayOfInt = this.t;
    if ((arrayOfInt != null) && (arrayOfInt[0] > 0))
    {
      GLES20.glDeleteTextures(1, arrayOfInt, 0);
      this.t = null;
    }
    arrayOfInt = this.u;
    if ((arrayOfInt != null) && (arrayOfInt[0] > 0))
    {
      GLES20.glDeleteTextures(1, arrayOfInt, 0);
      this.u = null;
    }
    arrayOfInt = this.x;
    if ((arrayOfInt != null) && (arrayOfInt[0] > 0))
    {
      GLES20.glDeleteTextures(1, arrayOfInt, 0);
      this.x = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.f == paramInt2) && (this.e == paramInt1)) {
      return;
    }
    s();
    int[] arrayOfInt;
    if (this.t == null)
    {
      this.t = new int[1];
      arrayOfInt = this.t;
      arrayOfInt[0] = j.a(paramInt1, paramInt2, 6409, 6409, arrayOfInt);
    }
    this.v = GLES20.glGetUniformLocation(p(), "yTexture");
    this.w = GLES20.glGetUniformLocation(p(), "uvTexture");
    int i = this.s;
    if (1 == i)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glActiveTexture(33985);
      this.u = new int[1];
      arrayOfInt = this.u;
      arrayOfInt[0] = j.a(paramInt1, paramInt2 / 2, 6409, 6409, arrayOfInt);
      GLES20.glUniform1i(this.v, 0);
      GLES20.glUniform1i(this.w, 1);
    }
    else if (3 == i)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glActiveTexture(33985);
      this.v = GLES20.glGetUniformLocation(p(), "yTexture");
      this.w = GLES20.glGetUniformLocation(p(), "uvTexture");
      this.u = new int[1];
      arrayOfInt = this.u;
      arrayOfInt[0] = j.a(paramInt1 / 2, paramInt2 / 2, 6410, 6410, arrayOfInt);
      GLES20.glUniform1i(this.v, 0);
      GLES20.glUniform1i(this.w, 1);
    }
    else if ((2 == i) && (this.x == null))
    {
      this.x = new int[1];
      arrayOfInt = this.x;
      arrayOfInt[0] = j.a(paramInt1, paramInt2, 6408, 6408, arrayOfInt);
    }
    super.a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    super.a(-1, paramFloatBuffer1, paramFloatBuffer2);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.r = paramArrayOfByte;
  }
  
  public boolean a()
  {
    int j = this.s;
    int i = 7;
    if (j != 1) {
      if (j == 3)
      {
        i = 9;
      }
      else
      {
        if (j == 2) {
          return super.a();
        }
        String str = y;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("don't support yuv format ");
        localStringBuilder.append(this.s);
        TXCLog.e(str, localStringBuilder.toString());
      }
    }
    NativeLoad.getInstance();
    this.a = NativeLoad.nativeLoadGLProgram(i);
    if ((this.a != 0) && (b())) {
      this.g = true;
    } else {
      this.g = false;
    }
    c();
    return this.g;
  }
  
  public void e()
  {
    super.e();
    s();
  }
  
  protected void i()
  {
    super.i();
    int[] arrayOfInt;
    if (this.e % 4 != 0)
    {
      arrayOfInt = new int[1];
      GLES20.glGetIntegerv(3317, arrayOfInt, 0);
      GLES20.glPixelStorei(3317, 1);
    }
    else
    {
      arrayOfInt = null;
    }
    int i = this.s;
    if (1 == i)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.t[0]);
      GLES20.glUniform1i(this.v, 0);
      NativeLoad.getInstance();
      NativeLoad.nativeglTexImage2D(3553, 0, 6409, this.e, this.f, 0, 6409, 5121, this.r, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.u[0]);
      GLES20.glUniform1i(this.w, 1);
      NativeLoad.getInstance();
      NativeLoad.nativeglTexImage2D(3553, 0, 6409, this.e, this.f / 2, 0, 6409, 5121, this.r, this.e * this.f);
    }
    else if (3 == i)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.t[0]);
      GLES20.glUniform1i(this.v, 0);
      NativeLoad.getInstance();
      NativeLoad.nativeglTexImage2D(3553, 0, 6409, this.e, this.f, 0, 6409, 5121, this.r, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.u[0]);
      GLES20.glUniform1i(this.w, 1);
      NativeLoad.getInstance();
      NativeLoad.nativeglTexImage2D(3553, 0, 6410, this.e / 2, this.f / 2, 0, 6410, 5121, this.r, this.e * this.f);
    }
    else if (2 == i)
    {
      r();
    }
    if (this.e % 4 != 0)
    {
      if ((arrayOfInt != null) && (arrayOfInt[0] > 0))
      {
        GLES20.glPixelStorei(3317, arrayOfInt[0]);
        return;
      }
      GLES20.glPixelStorei(3317, 4);
    }
  }
  
  public int q()
  {
    if (2 == this.s)
    {
      int i = r();
      GLES20.glBindTexture(3553, 0);
      return i;
    }
    return super.b(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.k
 * JD-Core Version:    0.7.0.1
 */