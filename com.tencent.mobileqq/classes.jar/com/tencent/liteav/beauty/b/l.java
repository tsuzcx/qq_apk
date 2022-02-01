package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.c.h;

public class l
  extends h
{
  private static String r = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nuniform int  bTransform;\nuniform mat4 textureTransform;\n\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n     gl_Position = position;\n    if (0 != bTransform){\n        textureCoordinate =  (textureTransform * inputTextureCoordinate).xy;\n    }else{\n        textureCoordinate = inputTextureCoordinate.xy;\n    }\n}\n";
  private int s = -1;
  private boolean t = false;
  
  public l()
  {
    this(r, "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", false);
  }
  
  public l(String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramString1, paramString2, paramBoolean);
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat != null) {
      b(this.s, 1);
    } else {
      b(this.s, 0);
    }
    super.a(paramArrayOfFloat);
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    this.s = GLES20.glGetUniformLocation(this.a, "bTransform");
    b(this.s, 0);
    return bool;
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean != this.t)
    {
      this.t = paramBoolean;
      h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.l
 * JD-Core Version:    0.7.0.1
 */