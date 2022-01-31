package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;

public class QQAVImageSobelThresholdNewFilter
  extends QQAVImage3x3TextureSamplingFilter
{
  private float mEdgeStrength = 1.0F;
  private float mThreshold = 0.5F;
  private int mUniformEdgeStrengthLocation;
  private int mUniformThresholdLocation;
  
  public QQAVImageSobelThresholdNewFilter()
  {
    this(0.5F, 1.0F);
  }
  
  public QQAVImageSobelThresholdNewFilter(float paramFloat1, float paramFloat2)
  {
    super(String.valueOf(12));
    this.mThreshold = paramFloat1;
    this.mEdgeStrength = paramFloat2;
  }
  
  public void onInit()
  {
    super.onInit();
    this.mUniformThresholdLocation = GLES20.glGetUniformLocation(getProgram(), "threshold");
    this.mUniformEdgeStrengthLocation = GLES20.glGetUniformLocation(getProgram(), "edgeStrength");
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    setThreshold(this.mThreshold);
    setEdgeStrength(this.mEdgeStrength);
  }
  
  public void setEdgeStrength(float paramFloat)
  {
    this.mEdgeStrength = paramFloat;
    setFloat(this.mUniformEdgeStrengthLocation, paramFloat);
  }
  
  public void setThreshold(float paramFloat)
  {
    this.mThreshold = paramFloat;
    setFloat(this.mUniformThresholdLocation, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageSobelThresholdNewFilter
 * JD-Core Version:    0.7.0.1
 */