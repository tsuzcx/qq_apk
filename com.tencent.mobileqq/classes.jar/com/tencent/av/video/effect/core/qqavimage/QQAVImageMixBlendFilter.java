package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;

public class QQAVImageMixBlendFilter
  extends QQAVImageTwoInputFilter
{
  private float mMix;
  private int mMixLocation;
  
  public QQAVImageMixBlendFilter(String paramString)
  {
    this(paramString, 0.5F);
  }
  
  public QQAVImageMixBlendFilter(String paramString, float paramFloat)
  {
    super(paramString);
    this.mMix = paramFloat;
  }
  
  public void onInit()
  {
    super.onInit();
    this.mMixLocation = GLES20.glGetUniformLocation(getProgram(), "mixturePercent");
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    setMix(this.mMix);
  }
  
  public void setMix(float paramFloat)
  {
    this.mMix = paramFloat;
    setFloat(this.mMixLocation, this.mMix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageMixBlendFilter
 * JD-Core Version:    0.7.0.1
 */