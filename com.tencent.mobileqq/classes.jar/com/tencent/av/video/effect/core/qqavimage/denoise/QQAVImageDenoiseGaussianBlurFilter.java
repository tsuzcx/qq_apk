package com.tencent.av.video.effect.core.qqavimage.denoise;

import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoPassTextureSamplingFilter;
import java.util.List;

public class QQAVImageDenoiseGaussianBlurFilter
  extends QQAVImageTwoPassTextureSamplingFilter
{
  private float mRadiusInPixels = -1.0F;
  
  public QQAVImageDenoiseGaussianBlurFilter()
  {
    this(2.0F);
  }
  
  public QQAVImageDenoiseGaussianBlurFilter(float paramFloat)
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
    int k = paramInt + 1;
    float[] arrayOfFloat = new float[k];
    int j = 0;
    int i = 0;
    float f1 = 0.0F;
    while (i < k)
    {
      double d1 = paramFloat;
      arrayOfFloat[i] = ((float)(1.0D / Math.sqrt(Math.pow(d1, 2.0D) * 6.283185307179586D) * Math.exp(-Math.pow(i, 2.0D) / (Math.pow(d1, 2.0D) * 2.0D))));
      if (i == 0)
      {
        f1 += arrayOfFloat[i];
      }
      else
      {
        d1 = f1;
        double d2 = arrayOfFloat[i];
        Double.isNaN(d2);
        Double.isNaN(d1);
        f1 = (float)(d1 + d2 * 2.0D);
      }
      i += 1;
    }
    i = 0;
    while (i < k)
    {
      arrayOfFloat[i] /= f1;
      i += 1;
    }
    k = paramInt / 2 + paramInt % 2;
    i = Math.min(k, 7);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("uniform sampler2D inputImageTexture;\nuniform highp float texelWidthOffset;\nuniform highp float texelHeightOffset;\nvarying highp vec2 blurCoordinates[");
    ((StringBuilder)localObject1).append(i * 2 + 1);
    ((StringBuilder)localObject1).append("];\nvoid main()\n{\n   lowp vec4 sum = vec4(0.0);\n   sum += texture2D(inputImageTexture, blurCoordinates[0]) * ");
    ((StringBuilder)localObject1).append(arrayOfFloat[0]);
    ((StringBuilder)localObject1).append(";\n");
    localObject1 = ((StringBuilder)localObject1).toString();
    paramInt = j;
    while (paramInt < i)
    {
      int m = paramInt * 2;
      j = m + 1;
      paramFloat = arrayOfFloat[j];
      m += 2;
      paramFloat += arrayOfFloat[m];
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("   sum += texture2D(inputImageTexture, blurCoordinates[");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append("]) * ");
      ((StringBuilder)localObject2).append(paramFloat);
      ((StringBuilder)localObject2).append(";\n");
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("   sum += texture2D(inputImageTexture, blurCoordinates[");
      ((StringBuilder)localObject2).append(m);
      ((StringBuilder)localObject2).append("]) * ");
      ((StringBuilder)localObject2).append(paramFloat);
      ((StringBuilder)localObject2).append(";\n");
      localObject1 = ((StringBuilder)localObject2).toString();
      paramInt += 1;
    }
    Object localObject2 = localObject1;
    if (k > i)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("   highp vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n");
      localObject1 = ((StringBuilder)localObject2).toString();
      paramInt = i;
      for (;;)
      {
        localObject2 = localObject1;
        if (paramInt >= k) {
          break;
        }
        j = paramInt * 2;
        i = j + 1;
        f1 = arrayOfFloat[i];
        j += 2;
        float f2 = arrayOfFloat[j];
        paramFloat = f1 + f2;
        f1 = (f1 * i + f2 * j) / paramFloat;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("   sum += texture2D(inputImageTexture, blurCoordinates[0] + singleStepOffset * ");
        ((StringBuilder)localObject2).append(f1);
        ((StringBuilder)localObject2).append(") * ");
        ((StringBuilder)localObject2).append(paramFloat);
        ((StringBuilder)localObject2).append(";\n");
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("   sum += texture2D(inputImageTexture, blurCoordinates[0] - singleStepOffset * ");
        ((StringBuilder)localObject2).append(f1);
        ((StringBuilder)localObject2).append(") * ");
        ((StringBuilder)localObject2).append(paramFloat);
        ((StringBuilder)localObject2).append(";\n");
        localObject1 = ((StringBuilder)localObject2).toString();
        paramInt += 1;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("   gl_FragColor = sum;\n");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("}\n");
    return ((StringBuilder)localObject2).toString();
  }
  
  private String getGaussianBlurVertexShader(int paramInt, float paramFloat)
  {
    if (paramInt < 1) {
      return "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}";
    }
    int k = paramInt + 1;
    Object localObject1 = new float[k];
    int j = 0;
    int i = 0;
    float f = 0.0F;
    while (i < k)
    {
      double d1 = paramFloat;
      localObject1[i] = ((float)(1.0D / Math.sqrt(Math.pow(d1, 2.0D) * 6.283185307179586D) * Math.exp(-Math.pow(i, 2.0D) / (Math.pow(d1, 2.0D) * 2.0D))));
      if (i == 0)
      {
        f += localObject1[i];
      }
      else
      {
        d1 = f;
        double d2 = localObject1[i];
        Double.isNaN(d2);
        Double.isNaN(d1);
        f = (float)(d1 + d2 * 2.0D);
      }
      i += 1;
    }
    i = 0;
    while (i < k)
    {
      localObject1[i] /= f;
      i += 1;
    }
    i = Math.min(paramInt / 2 + paramInt % 2, 7);
    Object localObject2 = new float[i];
    paramInt = 0;
    while (paramInt < i)
    {
      int m = paramInt * 2;
      k = m + 1;
      paramFloat = localObject1[k];
      m += 2;
      f = localObject1[m];
      localObject2[paramInt] = ((paramFloat * k + f * m) / (paramFloat + f));
      paramInt += 1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\nvarying vec2 blurCoordinates[");
    ((StringBuilder)localObject1).append(i * 2 + 1);
    ((StringBuilder)localObject1).append("];\nvoid main()\n{\n   gl_Position = position;\n   vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n   blurCoordinates[0] = inputTextureCoordinate.xy;\n");
    localObject1 = ((StringBuilder)localObject1).toString();
    paramInt = j;
    while (paramInt < i)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("   blurCoordinates[");
      j = paramInt * 2;
      localStringBuilder.append(j + 1);
      localStringBuilder.append("] = inputTextureCoordinate.xy + singleStepOffset * ");
      localStringBuilder.append(localObject2[paramInt]);
      localStringBuilder.append(";\n   blurCoordinates[");
      localStringBuilder.append(j + 2);
      localStringBuilder.append("] = inputTextureCoordinate.xy - singleStepOffset * ");
      localStringBuilder.append(localObject2[paramInt]);
      localStringBuilder.append(";\n");
      localObject1 = localStringBuilder.toString();
      paramInt += 1;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("}\n");
    return ((StringBuilder)localObject2).toString();
  }
  
  private void updateShader()
  {
    float f = this.mRadiusInPixels;
    if (f >= 1.0F)
    {
      double d1 = Math.pow(f, 2.0D);
      double d2 = 0.0039063F;
      double d3 = Math.sqrt(Math.pow(this.mRadiusInPixels, 2.0D) * 6.283185307179586D);
      Double.isNaN(d2);
      int i = (int)Math.floor(Math.sqrt(d1 * -2.0D * Math.log(d2 * d3)));
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
      runOnDraw(new QQAVImageDenoiseGaussianBlurFilter.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.denoise.QQAVImageDenoiseGaussianBlurFilter
 * JD-Core Version:    0.7.0.1
 */