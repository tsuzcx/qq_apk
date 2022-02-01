package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;
import java.util.List;

public class QQAVImageTwoPassTextureSamplingFilter
  extends QQAVImageTwoPassFilter
{
  public QQAVImageTwoPassTextureSamplingFilter(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramString1, paramString2, paramString3, paramString4);
  }
  
  public float getHorizontalTexelOffsetRatio()
  {
    return 1.0F;
  }
  
  public float getVerticalTexelOffsetRatio()
  {
    return 1.0F;
  }
  
  protected void initTexelOffsets()
  {
    float f = getHorizontalTexelOffsetRatio();
    QQAVImageFilter localQQAVImageFilter = (QQAVImageFilter)this.mFilters.get(0);
    int i = GLES20.glGetUniformLocation(localQQAVImageFilter.getProgram(), "texelWidthOffset");
    int j = GLES20.glGetUniformLocation(localQQAVImageFilter.getProgram(), "texelHeightOffset");
    localQQAVImageFilter.setFloat(i, f / this.mOutputWidth);
    localQQAVImageFilter.setFloat(j, 0.0F);
    f = getVerticalTexelOffsetRatio();
    localQQAVImageFilter = (QQAVImageFilter)this.mFilters.get(1);
    i = GLES20.glGetUniformLocation(localQQAVImageFilter.getProgram(), "texelWidthOffset");
    j = GLES20.glGetUniformLocation(localQQAVImageFilter.getProgram(), "texelHeightOffset");
    localQQAVImageFilter.setFloat(i, 0.0F);
    localQQAVImageFilter.setFloat(j, f / this.mOutputHeight);
  }
  
  public void onInit()
  {
    super.onInit();
    initTexelOffsets();
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    initTexelOffsets();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoPassTextureSamplingFilter
 * JD-Core Version:    0.7.0.1
 */