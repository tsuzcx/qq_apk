package com.tencent.av.video.effect.core.qqavimage.SpecialFilter;

import android.graphics.Bitmap;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoInputFilter;
import com.tencent.av.video.effect.core.qqavimage.util.OpenGlUtils;

public class QQAVImageSingleCurvePicFilter
  extends QQAVImageTwoInputFilter
{
  public QQAVImageSingleCurvePicFilter()
  {
    super(String.valueOf(33));
  }
  
  public void setBitmap(int paramInt, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramBitmap.isRecycled())) {}
    while (paramBitmap == null) {
      return;
    }
    this.mFilterSourceTexture2 = OpenGlUtils.loadTexture(paramBitmap, this.mFilterSourceTexture2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.SpecialFilter.QQAVImageSingleCurvePicFilter
 * JD-Core Version:    0.7.0.1
 */