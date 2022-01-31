package com.tencent.av.video.effect.core.qqavimage;

public class QQAVImageTwoPassFilter
  extends QQAVImageFilterGroup
{
  public QQAVImageTwoPassFilter(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(null);
    addFilter(new QQAVImageFilter(paramString1, paramString2));
    addFilter(new QQAVImageFilter(paramString3, paramString4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoPassFilter
 * JD-Core Version:    0.7.0.1
 */