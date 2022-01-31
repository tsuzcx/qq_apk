package com.tencent.av.video.effect.core.qqavimage.beauty;

import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoPassTextureSamplingFilter;
import java.util.List;

public class QQAVImageBeautyGaussianBlurFilter
  extends QQAVImageTwoPassTextureSamplingFilter
{
  private float mRadiusInPixels = -1.0F;
  
  public QQAVImageBeautyGaussianBlurFilter()
  {
    this(2.0F);
  }
  
  public QQAVImageBeautyGaussianBlurFilter(float paramFloat)
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    this.mRadiusInPixels = Math.round(paramFloat);
    updateShader();
  }
  
  private String getGaussianBlurFragmentShader(int paramInt, float paramFloat)
  {
    if (paramInt < 1) {
      return "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
    }
    float[] arrayOfFloat = new float[paramInt + 1];
    float f1 = 0.0F;
    int i = 0;
    if (i < paramInt + 1)
    {
      arrayOfFloat[i] = ((float)(1.0D / Math.sqrt(6.283185307179586D * Math.pow(paramFloat, 2.0D)) * Math.exp(-Math.pow(i, 2.0D) / (2.0D * Math.pow(paramFloat, 2.0D)))));
      if (i == 0) {}
      for (f1 = arrayOfFloat[i] + f1;; f1 = (float)(f1 + 2.0D * arrayOfFloat[i]))
      {
        i += 1;
        break;
      }
    }
    i = 0;
    while (i < paramInt + 1)
    {
      arrayOfFloat[i] /= f1;
      i += 1;
    }
    i = Math.min(paramInt / 2 + paramInt % 2, 7);
    int j = paramInt / 2 + paramInt % 2;
    String str1 = "uniform sampler2D inputImageTexture;\nuniform highp float texelWidthOffset;\nuniform highp float texelHeightOffset;\nvarying highp vec2 blurCoordinates[" + (i * 2 + 1) + "];\nvoid main()\n{\n   lowp vec4 sum = vec4(0.0);\n   sum += texture2D(inputImageTexture, blurCoordinates[0]) * " + arrayOfFloat[0] + ";\n";
    paramInt = 0;
    while (paramInt < i)
    {
      paramFloat = arrayOfFloat[(paramInt * 2 + 1)] + arrayOfFloat[(paramInt * 2 + 2)];
      str1 = str1 + "   sum += texture2D(inputImageTexture, blurCoordinates[" + (paramInt * 2 + 1) + "]) * " + paramFloat + ";\n";
      str1 = str1 + "   sum += texture2D(inputImageTexture, blurCoordinates[" + (paramInt * 2 + 2) + "]) * " + paramFloat + ";\n";
      paramInt += 1;
    }
    String str2 = str1;
    if (j > i)
    {
      str1 = str1 + "   highp vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n";
      paramInt = i;
      for (;;)
      {
        str2 = str1;
        if (paramInt >= j) {
          break;
        }
        f1 = arrayOfFloat[(paramInt * 2 + 1)];
        float f2 = arrayOfFloat[(paramInt * 2 + 2)];
        paramFloat = f1 + f2;
        f1 = (f1 * (paramInt * 2 + 1) + f2 * (paramInt * 2 + 2)) / paramFloat;
        str1 = str1 + "   sum += texture2D(inputImageTexture, blurCoordinates[0] + singleStepOffset * " + f1 + ") * " + paramFloat + ";\n";
        str1 = str1 + "   sum += texture2D(inputImageTexture, blurCoordinates[0] - singleStepOffset * " + f1 + ") * " + paramFloat + ";\n";
        paramInt += 1;
      }
    }
    str1 = str2 + "   gl_FragColor = sum;\n";
    return str1 + "}\n";
  }
  
  private String getGaussianBlurVertexShader(int paramInt, float paramFloat)
  {
    if (paramInt < 1) {
      return "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}";
    }
    Object localObject = new float[paramInt + 1];
    float f = 0.0F;
    int i = 0;
    if (i < paramInt + 1)
    {
      localObject[i] = ((float)(1.0D / Math.sqrt(6.283185307179586D * Math.pow(paramFloat, 2.0D)) * Math.exp(-Math.pow(i, 2.0D) / (2.0D * Math.pow(paramFloat, 2.0D)))));
      if (i == 0) {}
      for (f = localObject[i] + f;; f = (float)(f + 2.0D * localObject[i]))
      {
        i += 1;
        break;
      }
    }
    i = 0;
    while (i < paramInt + 1)
    {
      localObject[i] /= f;
      i += 1;
    }
    i = Math.min(paramInt / 2 + paramInt % 2, 7);
    float[] arrayOfFloat = new float[i];
    paramInt = 0;
    while (paramInt < i)
    {
      paramFloat = localObject[(paramInt * 2 + 1)];
      f = localObject[(paramInt * 2 + 2)];
      arrayOfFloat[paramInt] = ((paramFloat * (paramInt * 2 + 1) + f * (paramInt * 2 + 2)) / (paramFloat + f));
      paramInt += 1;
    }
    localObject = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\nvarying vec2 blurCoordinates[" + (i * 2 + 1) + "];\nvoid main()\n{\n   gl_Position = position;\n   vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n   blurCoordinates[0] = inputTextureCoordinate.xy;\n";
    paramInt = 0;
    while (paramInt < i)
    {
      localObject = (String)localObject + "   blurCoordinates[" + (paramInt * 2 + 1) + "] = inputTextureCoordinate.xy + singleStepOffset * " + arrayOfFloat[paramInt] + ";\n   blurCoordinates[" + (paramInt * 2 + 2) + "] = inputTextureCoordinate.xy - singleStepOffset * " + arrayOfFloat[paramInt] + ";\n";
      paramInt += 1;
    }
    return (String)localObject + "}\n";
  }
  
  private void updateShader()
  {
    if (this.mRadiusInPixels >= 1.0F)
    {
      double d = Math.pow(this.mRadiusInPixels, 2.0D);
      int i = (int)Math.floor(Math.sqrt(Math.log(0.0039063F * Math.sqrt(6.283185307179586D * Math.pow(this.mRadiusInPixels, 2.0D))) * (-2.0D * d)));
      int j = i + i % 2;
      if (this.mFilters != null)
      {
        i = 0;
        while (i < this.mFilters.size())
        {
          ((QQAVImageFilter)this.mFilters.get(i)).destroy();
          i += 1;
        }
        this.mFilters.clear();
      }
      addFilter(new QQAVImageFilter(getGaussianBlurVertexShader(j, this.mRadiusInPixels), getGaussianBlurFragmentShader(j, this.mRadiusInPixels)));
      addFilter(new QQAVImageFilter(getGaussianBlurVertexShader(j, this.mRadiusInPixels), getGaussianBlurFragmentShader(j, this.mRadiusInPixels)));
    }
  }
  
  public void setRadiusInPixels(float paramFloat)
  {
    if (Math.round(paramFloat) != this.mRadiusInPixels)
    {
      this.mRadiusInPixels = Math.round(paramFloat);
      updateShader();
      runOnDraw(new QQAVImageBeautyGaussianBlurFilter.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.beauty.QQAVImageBeautyGaussianBlurFilter
 * JD-Core Version:    0.7.0.1
 */