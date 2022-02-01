package com.tencent.av.video.effect.core.qqavimage;

public class QQAVImageGaussianBlurFilter
  extends QQAVImageTwoPassTextureSamplingFilter
{
  protected float mBlurSize = 1.0F;
  
  public QQAVImageGaussianBlurFilter()
  {
    this(1.0F);
  }
  
  public QQAVImageGaussianBlurFilter(float paramFloat)
  {
    super(String.valueOf(20), String.valueOf(21), String.valueOf(20), String.valueOf(21));
    this.mBlurSize = paramFloat;
  }
  
  public float getHorizontalTexelOffsetRatio()
  {
    return this.mBlurSize;
  }
  
  public float getVerticalTexelOffsetRatio()
  {
    return this.mBlurSize;
  }
  
  public void setBlurSize(float paramFloat)
  {
    this.mBlurSize = paramFloat;
    runOnDraw(new QQAVImageGaussianBlurFilter.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageGaussianBlurFilter
 * JD-Core Version:    0.7.0.1
 */