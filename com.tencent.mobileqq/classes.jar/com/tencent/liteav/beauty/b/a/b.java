package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.beauty.b.t;

public class b
  extends t
{
  private int r = -1;
  private int s = -1;
  private int t = -1;
  private final String x = "BeautyBlend";
  
  public b()
  {
    super("varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
  }
  
  private void q()
  {
    this.s = GLES20.glGetUniformLocation(p(), "whiteDegree");
    this.r = GLES20.glGetUniformLocation(p(), "contrast");
    this.t = GLES20.glGetUniformLocation(p(), "ruddyDegree");
  }
  
  public void a(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setBrightLevel ");
    localStringBuilder.append(paramFloat);
    TXCLog.i("BeautyBlend", localStringBuilder.toString());
    a(this.s, paramFloat);
  }
  
  public boolean a()
  {
    NativeLoad.getInstance();
    this.a = NativeLoad.nativeLoadGLProgram(12);
    if ((this.a != 0) && (b())) {
      this.g = true;
    } else {
      this.g = false;
    }
    c();
    return this.g;
  }
  
  public void b(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRuddyLevel level ");
    localStringBuilder.append(paramFloat);
    Log.i("BeautyBlend", localStringBuilder.toString());
    a(this.t, paramFloat / 2.0F);
  }
  
  public boolean b()
  {
    super.b();
    q();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.a.b
 * JD-Core Version:    0.7.0.1
 */