package com.tencent.liteav.beauty.b.c;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.b.t;

public class b
  extends t
{
  private int r;
  private int s;
  
  public b()
  {
    super(" attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n varying vec2 textureCoordinate;\n \n void main(void)\n {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }\n", " varying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main()\n {\n     lowp vec3 iColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n     lowp vec3 meanColor = texture2D(inputImageTexture2, textureCoordinate).rgb;\n     highp vec3 diffColor = (iColor - meanColor) * 7.07;\n     diffColor = min(diffColor * diffColor, 1.0);\n     gl_FragColor = vec4(diffColor, 1.0);\n }\n");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    float f = Math.min(1.0F, 360.0F / Math.min(paramInt1, paramInt2));
    this.r = Math.round(paramInt1 * f);
    this.s = Math.round(paramInt2 * f);
    super.a(this.r, this.s);
  }
  
  public int b(int paramInt)
  {
    GLES20.glViewport(0, 0, this.r, this.s);
    return super.a(paramInt, this.m, this.n);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.c.b
 * JD-Core Version:    0.7.0.1
 */