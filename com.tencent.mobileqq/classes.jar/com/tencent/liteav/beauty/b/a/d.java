package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.liteav.beauty.NativeLoad;

public class d
  extends j
{
  private int r = -1;
  private int s = -1;
  private float t = 4.0F;
  private String u = "SmoothHorizontal";
  
  d()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (paramInt1 > paramInt2)
    {
      if (paramInt2 < 540) {
        this.t = 2.0F;
      } else {
        this.t = 4.0F;
      }
    }
    else if (paramInt1 < 540) {
      this.t = 2.0F;
    } else {
      this.t = 4.0F;
    }
    String str = this.u;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("m_textureRation ");
    localStringBuilder.append(this.t);
    TXCLog.i(str, localStringBuilder.toString());
    a(this.r, this.t / paramInt1);
    a(this.s, this.t / paramInt2);
  }
  
  public boolean a()
  {
    this.a = NativeLoad.nativeLoadGLProgram(13);
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
    r();
    return true;
  }
  
  public void r()
  {
    this.r = GLES20.glGetUniformLocation(q(), "texelWidthOffset");
    this.s = GLES20.glGetUniformLocation(q(), "texelHeightOffset");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.a.d
 * JD-Core Version:    0.7.0.1
 */