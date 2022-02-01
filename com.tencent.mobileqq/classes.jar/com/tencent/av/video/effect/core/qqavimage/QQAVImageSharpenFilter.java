package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;

public class QQAVImageSharpenFilter
  extends QQAVImageFilter
{
  private int mImageHeightFactorLocation;
  private int mImageWidthFactorLocation;
  private float mSharpness;
  private int mSharpnessLocation;
  
  public QQAVImageSharpenFilter()
  {
    this(0.0F);
  }
  
  public QQAVImageSharpenFilter(float paramFloat)
  {
    super(String.valueOf(18), String.valueOf(25));
    this.mSharpness = paramFloat;
  }
  
  public void onInit()
  {
    super.onInit();
    this.mSharpnessLocation = GLES20.glGetUniformLocation(getProgram(), "sharpness");
    this.mImageWidthFactorLocation = GLES20.glGetUniformLocation(getProgram(), "imageWidthFactor");
    this.mImageHeightFactorLocation = GLES20.glGetUniformLocation(getProgram(), "imageHeightFactor");
    setSharpness(this.mSharpness);
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    setFloat(this.mImageWidthFactorLocation, 1.0F / paramInt1);
    setFloat(this.mImageHeightFactorLocation, 1.0F / paramInt2);
  }
  
  public void setSharpness(float paramFloat)
  {
    this.mSharpness = paramFloat;
    setFloat(this.mSharpnessLocation, this.mSharpness);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageSharpenFilter
 * JD-Core Version:    0.7.0.1
 */