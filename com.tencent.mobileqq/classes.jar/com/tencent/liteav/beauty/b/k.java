package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.liteav.beauty.NativeLoad;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class k
  extends j
{
  private static String y = "YUV420pToRGBFilter";
  private ByteBuffer r = null;
  private final int s;
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
  
  private int s()
  {
    GLES20.glBindTexture(3553, this.x[0]);
    if (this.r != null) {
      GLES20.glTexImage2D(3553, 0, 6408, this.e, this.f, 0, 6408, 5121, this.r);
    }
    return this.x[0];
  }
  
  private void t()
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
    t();
    int[] arrayOfInt;
    if (this.t == null)
    {
      this.t = new int[1];
      arrayOfInt = this.t;
      arrayOfInt[0] = TXCOpenGlUtils.a(paramInt1, paramInt2, 6409, 6409, arrayOfInt);
    }
    this.v = GLES20.glGetUniformLocation(q(), "yTexture");
    this.w = GLES20.glGetUniformLocation(q(), "uvTexture");
    int i = this.s;
    if (1 == i)
    {
      this.u = new int[1];
      arrayOfInt = this.u;
      arrayOfInt[0] = TXCOpenGlUtils.a(paramInt1, paramInt2 / 2, 6409, 6409, arrayOfInt);
    }
    else if (3 == i)
    {
      this.v = GLES20.glGetUniformLocation(q(), "yTexture");
      this.w = GLES20.glGetUniformLocation(q(), "uvTexture");
      this.u = new int[1];
      arrayOfInt = this.u;
      arrayOfInt[0] = TXCOpenGlUtils.a(paramInt1 / 2, paramInt2 / 2, 6410, 6410, arrayOfInt);
    }
    else if ((2 == i) && (this.x == null))
    {
      this.x = new int[1];
      arrayOfInt = this.x;
      arrayOfInt[0] = TXCOpenGlUtils.a(paramInt1, paramInt2, 6408, 6408, arrayOfInt);
    }
    super.a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    super.a(-1, paramFloatBuffer1, paramFloatBuffer2);
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    this.r = paramByteBuffer;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      this.r = ByteBuffer.wrap(paramArrayOfByte);
    }
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
    t();
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
    if (2 == i)
    {
      s();
    }
    else
    {
      ByteBuffer localByteBuffer = this.r;
      if (i == 1) {
        i = 6409;
      } else {
        i = 6410;
      }
      TXCOpenGlUtils.a(localByteBuffer, i, this.e, this.f, new int[] { this.t[0], this.u[0] });
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.t[0]);
      GLES20.glUniform1i(this.v, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.u[0]);
      GLES20.glUniform1i(this.w, 1);
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
  
  public int r()
  {
    if (2 == this.s)
    {
      int i = s();
      GLES20.glBindTexture(3553, 0);
      return i;
    }
    return super.b(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.k
 * JD-Core Version:    0.7.0.1
 */