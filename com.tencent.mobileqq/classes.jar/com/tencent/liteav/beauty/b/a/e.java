package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.beauty.b.t;

public class e
  extends t
{
  private String A = "SmoothVertical";
  private int r = -1;
  private int s = -1;
  private int t = -1;
  private int x = -1;
  private float y = 2.0F;
  private float z = 0.5F;
  
  e()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
  }
  
  public void a(float paramFloat)
  {
    this.z = paramFloat;
    String str = this.A;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setBeautyLevel ");
    localStringBuilder.append(paramFloat);
    TXCLog.i(str, localStringBuilder.toString());
    a(this.t, paramFloat);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (paramInt1 > paramInt2)
    {
      if (paramInt2 < 540) {
        this.y = 2.0F;
      } else {
        this.y = 4.0F;
      }
    }
    else if (paramInt1 < 540) {
      this.y = 2.0F;
    } else {
      this.y = 4.0F;
    }
    String str = this.A;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("m_textureRation ");
    localStringBuilder.append(this.y);
    TXCLog.i(str, localStringBuilder.toString());
    a(this.r, this.y / paramInt1);
    a(this.s, this.y / paramInt2);
  }
  
  public boolean a()
  {
    if ((Build.BRAND.equals("samsung")) && (Build.MODEL.equals("GT-I9500")) && (Build.VERSION.RELEASE.equals("4.3")))
    {
      Log.d(this.A, "SAMSUNG_S4 GT-I9500 + Android 4.3; use diffrent shader!");
      NativeLoad.getInstance();
      this.a = NativeLoad.nativeLoadGLProgram(15);
    }
    else
    {
      NativeLoad.getInstance();
      this.a = NativeLoad.nativeLoadGLProgram(5);
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
    q();
    return true;
  }
  
  public void q()
  {
    this.r = GLES20.glGetUniformLocation(p(), "texelWidthOffset");
    this.s = GLES20.glGetUniformLocation(p(), "texelHeightOffset");
    this.t = GLES20.glGetUniformLocation(p(), "smoothDegree");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.a.e
 * JD-Core Version:    0.7.0.1
 */