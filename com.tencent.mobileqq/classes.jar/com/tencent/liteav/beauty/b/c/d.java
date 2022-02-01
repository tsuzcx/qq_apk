package com.tencent.liteav.beauty.b.c;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.j;

class d
  extends j
{
  private final boolean r;
  private int s = -1;
  private int t = -1;
  private int u;
  private int v;
  
  public d(boolean paramBoolean)
  {
    super(" attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n uniform float texelWidthOffset;\n uniform float texelHeightOffset;\n \n varying vec2 textureCoordinate;\n varying vec4 textureShift_1;\n varying vec4 textureShift_2;\n varying vec4 textureShift_3;\n varying vec4 textureShift_4;\n \n void main(void)\n {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n     \n     vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n     textureShift_1 = vec4(textureCoordinate - singleStepOffset, textureCoordinate + singleStepOffset);\n     textureShift_2 = vec4(textureCoordinate - 2.0 * singleStepOffset, textureCoordinate + 2.0 * singleStepOffset);\n     textureShift_3 = vec4(textureCoordinate - 3.0 * singleStepOffset, textureCoordinate + 3.0 * singleStepOffset);\n     textureShift_4 = vec4(textureCoordinate - 4.0 * singleStepOffset, textureCoordinate + 4.0 * singleStepOffset);\n }\n", "uniform sampler2D inputImageTexture;\n varying highp vec2 textureCoordinate;\n varying highp vec4 textureShift_1;\n varying highp vec4 textureShift_2;\n varying highp vec4 textureShift_3;\n varying highp vec4 textureShift_4;\n \n void main()\n {\n     mediump vec3 sum = texture2D(inputImageTexture, textureCoordinate).rgb;\n     sum += texture2D(inputImageTexture, textureShift_1.xy).rgb;\n     sum += texture2D(inputImageTexture, textureShift_1.zw).rgb;\n     sum += texture2D(inputImageTexture, textureShift_2.xy).rgb;\n     sum += texture2D(inputImageTexture, textureShift_2.zw).rgb;\n     sum += texture2D(inputImageTexture, textureShift_3.xy).rgb;\n     sum += texture2D(inputImageTexture, textureShift_3.zw).rgb;\n     sum += texture2D(inputImageTexture, textureShift_4.xy).rgb;\n     sum += texture2D(inputImageTexture, textureShift_4.zw).rgb;\n     \n     gl_FragColor = vec4(sum * 0.1111, 1.0);\n }\n");
    this.r = paramBoolean;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    float f = Math.min(1.0F, 360.0F / Math.min(paramInt1, paramInt2));
    this.u = Math.round(paramInt1 * f);
    this.v = Math.round(paramInt2 * f);
    super.a(this.u, this.v);
    if (this.r)
    {
      a(this.s, 0.0F);
      a(this.t, 1.5F / this.v);
      return;
    }
    a(this.s, 1.5F / this.u);
    a(this.t, 0.0F);
  }
  
  public int b(int paramInt)
  {
    GLES20.glViewport(0, 0, this.u, this.v);
    return super.a(paramInt, this.m, this.n);
  }
  
  public boolean b()
  {
    if (!super.b()) {
      return false;
    }
    this.s = GLES20.glGetUniformLocation(q(), "texelWidthOffset");
    this.t = GLES20.glGetUniformLocation(q(), "texelHeightOffset");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.c.d
 * JD-Core Version:    0.7.0.1
 */