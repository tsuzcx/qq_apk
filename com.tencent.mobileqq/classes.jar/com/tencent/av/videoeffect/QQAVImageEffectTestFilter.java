package com.tencent.av.videoeffect;

import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilterGroup;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageGaussianBlurFilter;

public class QQAVImageEffectTestFilter
  extends QQAVImageFilterGroup
{
  public QQAVImageEffectTestFilter()
  {
    super(null);
    int i = 0;
    while (i < 3)
    {
      addFilter(new QQAVImageGaussianBlurFilter());
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.videoeffect.QQAVImageEffectTestFilter
 * JD-Core Version:    0.7.0.1
 */