package com.tencent.av.video.effect.core.qqavimage.beauty;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;

public class QQAVImageBeautySharpenAndExposureFilter
  extends QQAVImageFilter
{
  private float mExposure;
  private int mExposureLocation;
  private int mImageHeightFactorLocation;
  private int mImageWidthFactorLocation;
  private float mSharpness;
  private int mSharpnessLocation;
  
  public QQAVImageBeautySharpenAndExposureFilter()
  {
    this(0.0F, 0.0F);
  }
  
  public QQAVImageBeautySharpenAndExposureFilter(float paramFloat1, float paramFloat2)
  {
    super(String.valueOf(3), String.valueOf(4));
    this.mSharpness = paramFloat1;
    this.mExposure = paramFloat2;
  }
  
  public void onInit()
  {
    super.onInit();
    this.mSharpnessLocation = GLES20.glGetUniformLocation(getProgram(), "sharpness");
    this.mExposureLocation = GLES20.glGetUniformLocation(getProgram(), "exposure");
    this.mImageWidthFactorLocation = GLES20.glGetUniformLocation(getProgram(), "imageWidthFactor");
    this.mImageHeightFactorLocation = GLES20.glGetUniformLocation(getProgram(), "imageHeightFactor");
    setSharpness(this.mSharpness);
    setExposure(this.mExposure);
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    setFloat(this.mImageWidthFactorLocation, 1.0F / paramInt1);
    setFloat(this.mImageHeightFactorLocation, 1.0F / paramInt2);
  }
  
  public void setExposure(float paramFloat)
  {
    this.mExposure = paramFloat;
    setFloat(this.mExposureLocation, this.mExposure);
  }
  
  public void setSharpness(float paramFloat)
  {
    this.mSharpness = paramFloat;
    setFloat(this.mSharpnessLocation, this.mSharpness);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.beauty.QQAVImageBeautySharpenAndExposureFilter
 * JD-Core Version:    0.7.0.1
 */