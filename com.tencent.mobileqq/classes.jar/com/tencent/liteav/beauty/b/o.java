package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.liteav.beauty.NativeLoad;

public class o
  extends j
{
  private static float[] C = { 0.1826F, 0.6142F, 0.062F, -0.1006F, -0.3386F, 0.4392F, 0.4392F, -0.3989F, -0.0403F };
  private static float[] D = { 0.256816F, 0.504154F, 0.0979137F, -0.148246F, -0.29102F, 0.439266F, 0.439271F, -0.367833F, -0.071438F };
  private static float[] E = { 0.0625F, 0.5F, 0.5F };
  private String A = "RGBA2I420Filter";
  private int B = 1;
  private int r = -1;
  private int s = -1;
  private int t = -1;
  private int u = -1;
  private int v = -1;
  private int w = -1;
  private int x = -1;
  private int y = -1;
  private int z = -1;
  
  public o(int paramInt)
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    this.B = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      if ((this.f == paramInt2) && (this.e == paramInt1)) {
        return;
      }
      super.a(paramInt1, paramInt2);
      String str = this.A;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RGBA2I420Filter width ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" height ");
      localStringBuilder.append(paramInt2);
      TXCLog.i(str, localStringBuilder.toString());
      a(this.r, paramInt1);
      a(this.s, paramInt2);
      return;
    }
    TXCLog.e(this.A, "width or height is error!");
  }
  
  public boolean a()
  {
    int i = this.B;
    if (1 == i)
    {
      this.a = NativeLoad.nativeLoadGLProgram(8);
      TXCLog.i(this.A, "RGB-->I420 init!");
    }
    else if (3 == i)
    {
      TXCLog.i(this.A, "RGB-->NV21 init!");
      this.a = NativeLoad.nativeLoadGLProgram(11);
    }
    else
    {
      if (2 == i)
      {
        TXCLog.i(this.A, "RGBA Format init!");
        return super.a();
      }
      String str = this.A;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("don't support format ");
      localStringBuilder.append(this.B);
      localStringBuilder.append(" use default I420");
      TXCLog.i(str, localStringBuilder.toString());
      this.a = NativeLoad.nativeLoadGLProgram(8);
    }
    if ((this.a != 0) && (b())) {
      this.g = true;
    } else {
      this.g = false;
    }
    c();
    return this.g;
  }
  
  public boolean b()
  {
    super.b();
    this.r = GLES20.glGetUniformLocation(this.a, "width");
    this.s = GLES20.glGetUniformLocation(this.a, "height");
    return true;
  }
  
  public void c()
  {
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.o
 * JD-Core Version:    0.7.0.1
 */