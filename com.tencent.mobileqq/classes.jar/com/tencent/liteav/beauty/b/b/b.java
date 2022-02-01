package com.tencent.liteav.beauty.b.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.liteav.beauty.NativeLoad;

public class b
  extends j
{
  private int r = -1;
  private int s = -1;
  private float[] t = new float[4];
  private String u = "Beauty3Filter";
  
  public b()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
  }
  
  private void b(float[] paramArrayOfFloat)
  {
    c(this.s, paramArrayOfFloat);
  }
  
  public void a(float paramFloat)
  {
    float[] arrayOfFloat = this.t;
    arrayOfFloat[0] = paramFloat;
    b(arrayOfFloat);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    c(paramInt1, paramInt2);
  }
  
  public boolean a()
  {
    this.a = NativeLoad.nativeLoadGLProgram(14);
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
    float[] arrayOfFloat = this.t;
    arrayOfFloat[1] = paramFloat;
    b(arrayOfFloat);
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    this.r = GLES20.glGetUniformLocation(q(), "singleStepOffset");
    this.s = GLES20.glGetUniformLocation(q(), "beautyParams");
    a(5.0F);
    return bool;
  }
  
  public void c(float paramFloat)
  {
    float[] arrayOfFloat = this.t;
    arrayOfFloat[2] = paramFloat;
    b(arrayOfFloat);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    a(this.r, new float[] { 2.0F / paramInt1, 2.0F / paramInt2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.b.b
 * JD-Core Version:    0.7.0.1
 */