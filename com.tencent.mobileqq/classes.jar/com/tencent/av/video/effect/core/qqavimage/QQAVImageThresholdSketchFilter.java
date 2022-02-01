package com.tencent.av.video.effect.core.qqavimage;

import java.util.List;

public class QQAVImageThresholdSketchFilter
  extends QQAVImageFilterGroup
{
  public QQAVImageThresholdSketchFilter()
  {
    addFilter(new QQAVImageGrayscaleFilter());
    addFilter(new QQAVImageSobelThresholdNewFilter());
  }
  
  public void setEdgeStrength(float paramFloat)
  {
    ((QQAVImageSobelThresholdNewFilter)getFilters().get(1)).setEdgeStrength(paramFloat);
  }
  
  public void setLineSize(float paramFloat)
  {
    ((QQAVImage3x3TextureSamplingFilter)getFilters().get(1)).setLineSize(paramFloat);
  }
  
  public void setThreshold(float paramFloat)
  {
    ((QQAVImageSobelThresholdNewFilter)getFilters().get(1)).setThreshold(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageThresholdSketchFilter
 * JD-Core Version:    0.7.0.1
 */